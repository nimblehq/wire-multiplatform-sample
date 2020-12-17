/*
 * Copyright 2019 Square Inc.
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
package com.squareup.dinosaurs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.squareup.dinosaurs.api.DinosaurRetrofit.dinosaursApi
import com.squareup.dinosaurs.ui.DinosaursTheme
import com.squareup.dinosaurs.view.DinosaurView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
  private val scope: CoroutineScope = MainScope()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    scope.launch {
      val dinosaur = withContext(Dispatchers.IO) {
        try {
          dinosaursApi.getDinosaur()
        } catch (ex: Exception) {
          null
        }
      }
      setContent {
        DinosaursTheme {
          DinosaurView(dinosaur)
        }
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    scope.cancel()
  }
}
