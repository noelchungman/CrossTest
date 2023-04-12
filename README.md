Did all taught by 'Getting started with Kotlin Multiplatform for mobile'
https://kotlinlang.org/docs/multiplatform-mobile-create-first-app.html#create-the-project-from-a-template


Notes:
A. Reverse String

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Guess what it is! > ${platform.name.reversed()}!"
    }
}

B. Add to New Year Days

i. Navigate to the build.gradle.kts file in the shared directory.

2. Add the following dependency to the commonMain source set dependencies:
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            }
        }
    }
}
3. Synchronize the Gradle files by clicking Sync Now in the notification.

4. In shared/src/commonMain/kotlin, create a new file NewYear.kt in the project folder.

5. Update the file with a short function that calculates the number of days from today until the New Year using the date-time date arithmetic:

import kotlinx.datetime.*

fun daysUntilNewYear(): Int {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    val closestNewYear = LocalDate(today.year + 1, 1, 1)
    return today.daysUntil(closestNewYear)
}

6. In Greeting.kt, update the greet() function to see the result:

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Guess what it is! > ${platform.name.reversed()}!" +
                "\nThere are only ${daysUntilNewYear()} days left until New Year! 🎆"
    }
}

C. Get method

Global search comment: "Show get method got content" will show the steps
