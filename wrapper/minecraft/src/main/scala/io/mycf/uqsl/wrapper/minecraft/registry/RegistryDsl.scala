
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
import net.minecraft.block.Block
import net.minecraft.util.registry.Registry
import net.minecraft.util.Identifier

import scala.annotation.targetName

def test() = {
  val TEST_BLOCK: Block = ???
  import io.mycf.uqsl.wrapper.minecraft.registry.RegistryDsl.{registerAll, named, from, +++}
  RegistryDsl.registryDsl("foo") {
    Registry.BLOCK registerAll {
      TEST_BLOCK +++ "test_block"
      TEST_BLOCK named Identifier("name", "something_else")
    }
    Registry.BLOCK from TEST_BLOCK named  ""
  }

  Registry.BLOCK from TEST_BLOCK named Identifier("modid", "block_name")
}

class RegistryDsl private(val modid: String)

object RegistryDsl {
  def registryDsl(modid: String)(registryAction: RegistryDsl ?=> Unit): Unit = {
    registryAction(using RegistryDsl(modid))
  }


  extension[T] (registry: Registry[T])
    def registerAll(runCtx: RegistryContext[T] ?=> Unit) = runCtx(using RegistryContext(registry))
    def from(t: T): RegistryMissingName[T] = RegistryMissingName(registry, t)

  extension[A] (item: A)
    @targetName("namedP")
    def +++(id: String | Identifier)(using dsl: RegistryDsl)(using ctx: RegistryContext[A]): A = named(id)(using dsl)(using ctx)
    def named(id: String | Identifier)(using dsl: RegistryDsl)(using ctx: RegistryContext[A]): A =
      id match {
        case nameStr: String        => Registry.register(ctx.registry, Identifier(dsl.modid, nameStr), item)
        case identifier: Identifier => Registry.register(ctx.registry, identifier, item)
      }

}

case class RegistryContext[T](registry: Registry[T])

case class RegistryMissingName[T](registry: Registry[T], t: T) {
  def named(id: String | Identifier)(using dsl: RegistryDsl): T = {
    import io.mycf.uqsl.wrapper.minecraft.registry.RegistryDsl.named
    this.t.named(id)(using dsl)(using RegistryContext(registry))
  }
  def named(id: Identifier): T = Registry.register(registry, id, t)
}
