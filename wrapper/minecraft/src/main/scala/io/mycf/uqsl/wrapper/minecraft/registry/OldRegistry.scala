package io.mycf.uqsl.wrapper.minecraft.registry





/////**
//// * Makes the usage of given Strings safe
//// */
////opaque type Modid = String
////
////object Modid {
////  def fromString(str: String): Modid = str
////
////  extension (str: String)
////    def toModid: Modid = fromString(str)
////
////  given asString: Conversion[Modid, String] with
////    override def apply(x: Modid): _root_.java.lang.String = x
////
////}
//
///**
// * Registry DSL class, used to register objects more cleanly.
// *
// * @param modid The modid you want to register under.
// * */
//class RegistryDsl private (private val modid: String) {
//
//  //  def register(action: RegistryDsl ?=> Unit): Unit = {
//  //    action(using this)
//  //  }
//
//  //  extension[T] (thiz: T)
//  //  /**
//  //   * Creates a RegistryObject.
//  //   *
//  //   * @param name The name to register under.
//  //   */
//  //    def withName(name: String): RegistryObject[T] = RegistryObject(modid, name, thiz)
//}
//
//object RegistryDsl {
//
//  /**
//   * Creates a RegistryDsl
//   * @param modid the Modid of the Mod
//   * @param action the action in which Objects can be registered
//   */
//  def register(modid: String)(action: RegistryDsl ?=> Unit): Unit = {
//    action(using RegistryDsl(modid))
//  }
//
//  extension[T] (thiz: Registry[T])
//
//  /**
//   * Applies a RegistryAction.
//   *
//   * @param action The action.
//   */
//    def registerAllWith(name: String, action: RegistryAction[T] ?=> Unit) = {
//      action(using RegistryAction(name, thiz))
//    }
//
//  extension[T] (thiz: T)
//
//  /**
//   * Creates a RegistryObject.
//   *
//   * @param id The Identifier to register under.
//   */
//    def withId(id: Identifier): RegistryObject[T] = {
//      RegistryObject(id.getNamespace, id.getPath, thiz)
//    }
//}
//
//
//case class RegistryObject[T](modid: String, name: String, t: T) {
//
//  /**
//   * Registers a RegistryObject.
//   *
//   * @param registry The registry to register to.
//   * */
//  def toRegistry(registry: Registry[T]): T = Registry.register(registry, Identifier(modid, name), this.t)
//}
//
///**
// * Represents an action with a registry.
// *
// * @param modid    The modid to register under.
// * @param registry The registry to register to.
// * */
//case class RegistryAction[T](modid: String, registry: Registry[T]) {
//
//  extension (thiz: T)
//
//  /**
//   * Registers an object with a given Identifier.
//   *
//   * @param id The Identifier to register under.
//   */
//    def withId(id: Identifier) = {
//      Registry.register(registry, id, thiz)
//    }
//
//    /**
//     * Registers an object with a given name.
//     *
//     * If no modid is present, it uses `"modid:name"` format.
//     *
//     * @param name The name to register under.
//     * */
//    def withName(name: String) = {
//      if (modid == null) {
//        Registry.register(registry, Identifier(name), thiz)
//      }
//      Registry.register(registry, Identifier(modid, name), thiz)
//    }
//}

