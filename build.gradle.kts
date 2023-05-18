@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

plugins {
  alias(libs.plugins.android.application).apply(false)
  alias(libs.plugins.kotlin.android).apply(false)
  alias(libs.plugins.kotlin.jvm).apply(false)
  alias(libs.plugins.kotlin.kapt).apply(false)
  alias(libs.plugins.dagger.hilt).apply(false)
}

buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies { classpath(libs.hilt.agp) }
}
