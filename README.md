Appetiser Exam
=============================

This is a Appetiser Exam that implements MVVM Architecture, Dagger Hilt, Coroutines, Retrofit + GSON, Room, LiveData
to display a list of track from itunes and save the data.

## Building the Appetiser Exam App

First, clone the repo:

`git clone https://github.com/papijeiboi/AppetiserExam.git`

### Android Studio (Recommended)

* Open Android Studio and select `File->Open...` or from the Android Launcher select `Import project (Eclipse ADT, Gradle, etc.)` and navigate to the root directory of your project.
* Select the directory or drill in and select the file `build.gradle` in the cloned repo.
* Click 'OK' to open the the project in Android Studio.
* A Gradle sync should start, but you can force a sync and build the 'app' module as needed.

### Gradle (command line)

* Build the APK: `./gradlew build`


## Running the  Appetiser Exam App

Connect an Android device to your development machine.

### Android Studio

* Select `Run -> Run 'app'` (or `Debug 'app'`) from the menu bar
* Select the device you wish to run the app on and click 'OK'

### Gradle

* Install the debug APK on your device `./gradlew installDebug`
* Start the APK: `<path to Android SDK>/platform-tools/adb -d shell am start io.keen.client.android.example/io.keen.client.android.example.MyActivity`


## Using the Appetiser Exam App

This app fetch data from a REST API using Retrofit, and cache the data for offline use in an SQLite database using the Room persistence. I also use NetworkBoundResource implementation based on Kotlin Coroutines and Kotlin Flow.
The app follows MVVM architecture with dependency injection
