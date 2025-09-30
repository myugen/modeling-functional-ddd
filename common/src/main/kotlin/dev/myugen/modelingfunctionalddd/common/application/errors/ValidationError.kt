package dev.myugen.modelingfunctionalddd.common.application.errors

interface ValidationError {
  val field: String
  val reason: String
}
