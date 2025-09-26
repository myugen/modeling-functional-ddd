plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.kotlin.spring)
  alias(libs.plugins.spring.boot)
  alias(libs.plugins.spring.dependency.management)
}

dependencies {
  // Common module dependency
  implementation(project(":common"))

  // Common Spring dependencies using version catalog
  implementation(libs.bundles.spring.common)

  // Test dependencies
  testImplementation(libs.bundles.spring.test)
  testRuntimeOnly(libs.junit.platform.launcher)

  // Add module-specific dependencies here if needed
  // implementation(libs.spring.boot.starter.data.jpa)
  // implementation(libs.spring.boot.starter.validation)
}
