plugins {
    alias(libs.plugins.android.application)
    id("androidx.navigation.safeargs")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.snacktrack"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.snacktrack"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {


    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("androidx.navigation:navigation-fragment:2.7.7")
    implementation ("androidx.navigation:navigation-ui:2.7.7")
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")

    implementation ("com.squareup.retrofit2:converter-moshi:2.4.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation ("com.airbnb.android:lottie:3.7.0")


    implementation ("androidx.room:room-rxjava3:2.6.1")

    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.6")



}