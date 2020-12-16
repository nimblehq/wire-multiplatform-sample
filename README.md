# gRPC meets Kotlin Multiplatform 

An example of building gRPC apps powered by Wire and Kotlin Multiplatform.

We made a few adjustments to accommodate our needs of demo, as well as documentation for people to get starting with.

## Documentations

- Protocol Buffers: https://developers.google.com/protocol-buffers

- Wire: https://square.github.io/wire/

- Kotlin Multiplatform: https://kotlinlang.org/docs/reference/multiplatform.html

- Ktor: https://ktor.io/docs/quickstart-index.html

- Jetpack Compose (Android): https://developer.android.com/jetpack/compose/

## Getting started
  0. Import this project as a whole.

  1. Run the server app:

    $./gradlew server:run

  2. Run the Android app:

    $./gradlew android:assembleDebug
  or you can import the project with android studio.

  3. Run the iOS app:
 
   a. Build the protos common: `$./gradlew protos:build`
 
   b. Open XCode and import the iOS module and run.


**Note:** Remember: for development purpose we are running on localhost, so you may want to update the pointing address on each client app.

Credit to @Egorand the original author.

