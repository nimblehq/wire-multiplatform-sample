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

`$ ./gradlew server:run`

2. Run the Android app:

`$ ./gradlew android:assembleDebug`
or you can import the project with android studio.

3. Run the iOS app:
 a. Build the protos common:
 `$ ./gradlew protos:build`
 b. Open XCode and import the iOS module and run.

**Note:** Remember: for development purpose we are running on localhost, so you may want to update the pointing address on each client app.

## Troubleshoot
1. On IntelliJ/Android Studio, from :server, I cannot reference to generatedSrc of :protos
-> To fix this: Open Module Settings -> Project Settings -> Modules -> Add "Dinosaurs.protos.commonMain" as a Provided Dependency.
-> If necessary, File -> Invalidate Cache and Restart.


Still have issue? File an Issue and we may help you out.


## About

![Nimble](https://assets.nimblehq.co/logo/dark/logo-dark-text-160.png)

This project is maintained and funded by Nimble.

We love open source and do our part in sharing our work with the community!
See [our other projects][community] or [hire our team][hire] to help build your product.

[community]: https://github.com/nimblehq
[hire]: https://nimblehq.co/

Credit to @Egorand(https://github.com/Egorand) and Square(https://github.com/square) the original author.

