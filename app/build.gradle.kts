@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.kapt)
  alias(libs.plugins.dagger.hilt)
}

android {
  namespace = "com.rohitkaradkar.sample"
  compileSdk = 33

  defaultConfig {
    applicationId = "com.rohitkaradkar.sample"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  buildFeatures {
    viewBinding = true
    compose = true
  }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get() }

  testOptions { unitTests.isIncludeAndroidResources = true }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions { jvmTarget = JavaVersion.VERSION_11.toString() }
}

dependencies {
  implementation(libs.androidx.appcompat)
  implementation(libs.kotlin.stdlib)
  implementation(libs.android.material)
  implementation(libs.androidx.lifecycle)
  implementation(libs.androidx.navigation.compose)

  val composeBom = platform(libs.compose.bom)
  implementation(composeBom)
  androidTestImplementation(composeBom)
  implementation(libs.androidx.activity.compose)
  implementation(libs.compose.material)
  implementation(libs.coil.compose)
  implementation(libs.compose.ui.tooling.preview)
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.androidx.lifecycleViewModelCompose)
  androidTestImplementation(libs.compose.ui.test.junit4)
  debugImplementation(libs.compose.ui.test.manifest)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compilerAnnotation)
  implementation(libs.hilt.navigationCompose)

  implementation(libs.moshi)
  kapt(libs.moshi.codegenAnnotation)

  testImplementation(libs.junit)
  testImplementation(libs.truth)

  implementation(libs.retrofit)
  implementation(libs.retrofit.moshiConverter)
  implementation(libs.okhttp.loggingInterceptor)
  testImplementation(libs.okhttp.mockWebServer)

  implementation(libs.coroutines.android)
  testImplementation(libs.coroutines.test)

  testImplementation(libs.robolectric)
}

kapt { correctErrorTypes = true }
