/*
 * Copyright (C) 2019 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
  kotlin("multiplatform")
  id("org.jetbrains.kotlin.native.cocoapods")
  id("com.squareup.wire")
}

version = "0.0.1"

kotlin {
  jvm("android")
  sourceSets {
    commonMain {
      kotlin.srcDir("$buildDir/generated/source/wire")
      dependencies {
        api(deps.okio)
        api(deps.wire.runtime)
      }
    }
  }

  // Configure iOS.
  val sdkName = System.getenv("SDK_NAME")
  if (sdkName != null && sdkName.startsWith("iphoneos")) {
    iosArm64("ios")
  } else {
    iosX64("ios")
  }
  cocoapods {
    summary = "Generated protos module for Dinosaurs sample."
    homepage = "https://github.com/Egorand/wire-multiplatform-sample/tree/master/protos"
  }
}

wire {
  kotlin {}
}
