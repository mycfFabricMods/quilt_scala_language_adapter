package me.mycf.language_adapter

import org.quiltmc.loader.api.{LanguageAdapter, LanguageAdapterException, ModContainer}

class ScalaAdapter extends LanguageAdapter:

  override def create[T](mod: ModContainer, value: String, aClass: Class[T]): T = {
    val scalaObject = getClass(value + "$")

    scalaObject match {
      case Right(clazz) => clazz.getField("MODULE$").get(null).asInstanceOf[T]
      case Left(error)  =>
        val scalaClass = getClass(value)
        scalaClass match {
          case Right(clazz) => clazz.getDeclaredConstructor().newInstance().asInstanceOf[T]
          case Left(error2) => throw LanguageAdapterException(s"Couldn't match declared $value with neither $error or $error2")
        }
    }
  }

  private def getClass(value: String): Either[String, Class[?]] = {
    try {
      Right(Class.forName(value))
    } catch {
        case _: ClassNotFoundException => Left(s"$value")
    }
  }

end ScalaAdapter
