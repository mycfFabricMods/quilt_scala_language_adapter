
/*
 * Copyright 2022 mycf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.mycf.uqsl.wrapper.minecraft.registry

import com.sun.jndi.ldap.LdapCtxFactory
import net.minecraft.util.registry.Registry
import net.minecraft.util.Identifier

import scala.annotation.targetName

/**
 * Defines all extension functions for the DSL registry.
 */
object RegistryExtensions {

  extension[T] (registry: Registry[T])

    /**
     * <p>
     * Alias to [[RegistryExtensions.apply]].
     * </p>
     * <p>
     * Creates a scope in which the modid is implicitly passed through
     * </p>
     *
     * @param runCtx The implicit scope
     */
    def registerAll(runCtx: RegistryContext[T] ?=> Unit) = runCtx(using RegistryContext(registry))

    /**
     * <p>
     * Allows for registries to get called.
     * </p>
     * <p>
     * Creates a scope in which the modid is implicitly passed through
     * </p>
     *
     * @example Registry.BLOCK {}
     *
     * @param runCtx the implicit scope
     */
    def apply(runCtx: RegistryContext[T] ?=> Unit) = runCtx(using RegistryContext(registry))

    /**
     * <p>
     * Alias to [[RegistryExtensions.from]]
     * </p>
     * <p>
     * Creates a [[RegistryObject]] which can be registered using [[RegistryObject.named]] or [[RegistryObject.>]]
     * </p>
     *
     * @param t The object that gets registered
     * @return a [[RegistryObject]]
     */
    @targetName("fromInfix")
    def <<-(t: T): RegistryObject[T] = RegistryObject(registry, t)

    /**
     * <p>
     * Alias to [[RegistryExtensions.<<-]]
     * </p>
     * <p>
     * Creates a [[RegistryObject]] which can be registered using [[RegistryObject.named]] or [[RegistryObject.>]]
     * </p>
     *
     * @param t The object that gets registered
     * @return a [[RegistryObject]]
     */
    def from(t: T): RegistryObject[T] = RegistryObject(registry, t)

  extension[A] (item: A)

    /**
     * <p>
     *   Alias for [[RegistryExtensions.>]]
     * </p>
     * <p>
     *   Registers the Object using the `id`, the implicit modid and the implicit [[net.minecraft.util.registry.Registry]]
     * </p>
     *
     * @param id Either a String or an [[net.minecraft.util.Identifier]]
     * @param dsl implicit [[RegistryDsl]] (The Modid)
     * @param ctx implicit [[RegistryContext]] (The [[net.minecraft.util.registry.Registry]])
     */
    @targetName("namedInfix")
    def >(id: String | Identifier)(using dsl: RegistryDsl)(using ctx: RegistryContext[A]): A = named(id)(using dsl)(using ctx)


    /**
     * <p>
     *   Alias for [[RegistryExtensions.>]]
     * </p>
     * <p>
     *   Registers the Object using the `id`, the implicit modid and the implicit [[net.minecraft.util.registry.Registry]]
     * </p>
     *
     * @param id Either a String or an [[net.minecraft.util.Identifier]]
     * @param dsl implicit [[RegistryDsl]] (The Modid)
     * @param ctx implicit [[RegistryContext]] (The [[net.minecraft.util.registry.Registry]])
     */
    def named(id: String | Identifier)(using dsl: RegistryDsl)(using ctx: RegistryContext[A]): A =
      id match {
        case nameStr: String        => Registry.register(ctx.registry, resolve(dsl.modid, nameStr), item)
        case identifier: Identifier => Registry.register(ctx.registry, identifier, item)
      }

    /**
     * Resolves a String to an [[net.minecraft.util.Identifier]] to a String.
     *
     * @example "foobar:quux" returns an [[net.minecraft.util.Identifier]] with id foobar, and path quux
     * @example "quux" returns an [[net.minecraft.util.Identifier]] with the given modid as id, and path quux
     *
     * @param modid the modid
     * @param str the path
     * @return
     */
    private def resolve(modid: String, str: String): Identifier = {
      if str.contains(':')
      then
        Identifier(str)
      else
        Identifier(modid, str)
    }
}

/**
 * Wrapper around the modid
 */
case class RegistryDsl private[registry](modid: String)

object RegistryDsl {

  /**
   * Creates a [[RegistryDsl]] using the `modid`
   *
   * @example RegistryDsl.registryDsl("modid") {}
   */
  def registryDsl(modid: String)(runDsl: RegistryDsl ?=> Unit): Unit = {
    runDsl(using RegistryDsl(modid))
  }
}

/**
 * Wrapper around a [[net.minecraft.util.registry.Registry]]
 */
case class RegistryContext[T] private[registry](registry: Registry[T])

/**
 * Wrapper around a [[net.minecraft.util.registry.Registry]] and something that can be registered
 */
case class RegistryObject[T] private[registry](registry: Registry[T], t: T) {

  /**
   * <p>
   *   Alias for [[RegistryObject.>]]
   * </p>
   * <p>
   *   Registers the Object using the `id`, the implicit modid and the implicit [[net.minecraft.util.registry.Registry]]
   *   Forwards the call to [[RegistryExtensions.named]]
   * </p>
   *
   * @param id Either a String or an [[net.minecraft.util.Identifier]]
   * @param dsl implicit [[RegistryDsl]] (The Modid)
   */
  def named(id: String | Identifier)(using dsl: RegistryDsl): T = {
    import io.mycf.uqsl.wrapper.minecraft.registry.RegistryExtensions.named
    this.t.named(id)(using dsl)(using RegistryContext(registry))
  }

  /**
   * <p>
   *   Alias for [[RegistryObject.named]]
   * </p>
   * <p>
   *   Registers the Object using the `id`, the implicit modid and the implicit [[net.minecraft.util.registry.Registry]]
   *   Forwards the call to [[RegistryObject.named]]
   * </p>
   *
   * @param id Either a String or an [[net.minecraft.util.Identifier]]
   * @param dsl implicit [[RegistryDsl]] (The Modid)
   */
  @targetName("namedInfix")
  def >(id: String | Identifier)(using dsl: RegistryDsl): T = {
    this.named(id)(using dsl)
  }

  /**
   * <p>
   *   Alias for [[RegistryObject.named]]
   * </p>
   * <p>
   *   Registers the Object using the `id`
   * </p>
   *
   * @param id An [[net.minecraft.util.Identifier]]
   */
  @targetName("namedInfix")
  def >(id: Identifier): T = Registry.register(registry, id, t)

  /**
   * <p>
   *   Alias for [[RegistryObject.>]]
   * </p>
   * <p>
   *   Registers the Object using the `id`
   * </p>
   *
   * @param id An [[net.minecraft.util.Identifier]]
   */
  def named(id: Identifier): T = Registry.register(registry, id, t)
}
