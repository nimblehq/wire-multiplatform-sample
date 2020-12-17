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

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.squareup.common.Dinosaur
import com.squareup.common.Period
import com.squareup.dinosaurs.ui.DinosaursTheme
import com.squareup.dinosaurs.ui.typography
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun DinosaurView(dinosaur: Dinosaur?) {

  if (dinosaur == null) {
    Column(modifier = Modifier.padding(32.dp)) {
      BasicText(
        stringResource(R.string.error_template, "Exception occurred!"),
        style = typography.body1
      )
    }
  } else {
    Column(modifier = Modifier.padding(32.dp)) {
      BasicText(stringResource(R.string.name_template, dinosaur.name), style = typography.body1)
      Divider(color = Transparent, thickness = 16.dp)
      BasicText(
        stringResource(R.string.period_template, dinosaur.period.name),
        style = typography.body1
      )
      Divider(color = Transparent, thickness = 16.dp)
      BasicText(
        stringResource(R.string.length_template, dinosaur.length_meters),
        style = typography.body1,
      )
      Divider(color = Transparent, thickness = 16.dp)
      BasicText(
        stringResource(R.string.mass_template, dinosaur.mass_kilograms),
        style = typography.body1,
      )
      Divider(color = Transparent, thickness = 16.dp)
      GlideImage(data = dinosaur.picture_urls.firstOrNull() ?: "", fadeIn = true)
    }
  }
}

@Preview
@Composable
fun DefaultPreview() {
  val dinosaur = Dinosaur(
    name = "Stegosaurus",
    period = Period.JURASSIC,
    length_meters = 9.0,
    mass_kilograms = 5000.0,
    picture_urls = listOf("http://goo.gl/LD5KY5", "http://goo.gl/VYRM67"),
  )
  DinosaursTheme {
    DinosaurView(dinosaur)
  }
}
