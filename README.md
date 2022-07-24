# Scala Language Adapter

The unofficial Quilt scala language adapter. You can use it to bootstrap your mods in scala!

## Usage

You need to declare this mod as a dependency (there is no maven (yet)).
    It bundles the scala libraries for you, so you don't need to bundle them for yourself.
    You must add them as 'implementation' though.

You can then make MainClass for your mod which is either an object or a class.

```scala
package com.example.example_mod

import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

object MyMod extends ModInitializer:
  override def onInitialize(mod: ModContainer): Unit = {
    println("This should work")
  }
```

Declare the entrypoint like so:

```json
"entrypoints": {
    "init": [
        {
            "adapter": "scala",
            "value": "com.example.example_mod.ExampleMod"
        }
    ]
},
```

## Plans for the future

I might upgrade this API so that it resembles something like the official Kotlin Library but for Scala.
    If you want to help, you're free to make PR's or fork it yourself.

## License

This template on the QuiltMC GitHub is licensed under the [Creative Common Zero v1.0 license](./LICENSE-TEMPLATE.md).

Mods created with this template are not automatically licensed under the CC0, and are not required to give any kind of credit back to QuiltMC for this template.
