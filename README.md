Demos:

- Scrollable Chart using KoalaPlot library ([source code](https://github.com/AlexZhukovich/KotlinMultiplatformPlayground/blob/main/composeApp/src/commonMain/kotlin/com/alexzh/kmp/playground/presentation/features/chart/ScrollableChart.kt), [article](https://alexzh.com/how-to-create-a-scrollable-chart-in-compose-multiplatform/), [video](https://www.youtube.com/watch?v=WtYJuUodiuQ))
- Platform-specific icons ([source code](https://github.com/AlexZhukovich/KotlinMultiplatformPlayground/blob/main/composeApp/src/commonMain/kotlin/com/alexzh/kmp/playground/presentation/features/icons/IconList.kt), [article](https://alexzh.com/how-to-add-platform-specific-icons-to-a-compose-multiplatform-project/), [video](https://youtu.be/AMZ91EYURjk))

---

This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.

You can open the desktop application by running the `::composeApp:run` Gradle task.
