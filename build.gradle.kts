buildscript {
    val kotlinVersion = meow.AppConfig.Versions.KOTLIN

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.2.1")
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

allprojects {

    tasks.withType(Javadoc::class) {
        (options as CoreJavadocOptions).addStringOption("Xdoclint:none", "-quiet")
        options.encoding = "UTF-8"
    }
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    delete(File("buildSrc\\build"))
}
