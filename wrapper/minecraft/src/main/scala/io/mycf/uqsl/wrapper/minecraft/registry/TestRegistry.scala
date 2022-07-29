
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

import io.mycf.uqsl.wrapper.minecraft.registry.RegistryExtensions.*

import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

private def test() = {
  val TEST_BLOCK: Block = ???

  RegistryDsl.registryDsl("foo") {
    Registry.BLOCK registerAll {
      TEST_BLOCK > "test_block"
      TEST_BLOCK named Identifier("name", "something_else")
    }
    Registry.BLOCK {
      TEST_BLOCK > "test_block"
      TEST_BLOCK named Identifier("name", "something_else")
    }
    Registry.BLOCK from TEST_BLOCK named ""
    Registry.BLOCK <<- TEST_BLOCK > ""
  }

  Registry.BLOCK from TEST_BLOCK named Identifier("modid", "block_name")
  Registry.BLOCK <<- TEST_BLOCK > Identifier("modid", "block_name")
}
