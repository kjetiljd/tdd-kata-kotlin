# TDD Kata with Kotlin and Gradle

## Preparations

### Clone and make sure you can build

```sh
git clone git@github.com:akafred/tdd-kata-kotlin.git # or git pull if already cloned
cd tdd-kata-kotlin
```
And then:
```sh
./gradlew build  # or 'gradlew.bat build' if weird
```
This should return something like:

```
> Task :test

StuffTest > test some method() PASSED

BUILD SUCCESSFUL in 1s
```


### Set up your IDE/editor of choice (for Kotlin and Gradle)

If you use IntelliJ, open the `build.gradle.kts`-file and usually things work themselves out.

Make sure you can build, run tests, and perhaps also debug.
