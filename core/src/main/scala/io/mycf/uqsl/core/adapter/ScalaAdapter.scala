package io.mycf.uqsl.core.adapter

import org.quiltmc.loader.api.{LanguageAdapter, LanguageAdapterException, ModContainer}

class ScalaAdapter extends LanguageAdapter:

  override def create[T](mod: ModContainer, value: String, aClass: Class[T]): T = {
    val clazz = getClass(value + "$")
      .map { _.getField("MODULE$").get(null).asInstanceOf[T] }
      .orElse {
        getClass(value)
          .map { _.getDeclaredConstructor().newInstance().asInstanceOf[T] }
      }

    clazz match {
      case None        => throw LanguageAdapterException(s"Class: $value cannot be found or instantiated.")
      case Some(ans)   => ans
    }
  }

  private def getClass(value: String): Option[Class[?]] = {
    try {
      Option(Class.forName(value))
    } catch {
        case _: ClassNotFoundException => None
    }
  }

end ScalaAdapter
