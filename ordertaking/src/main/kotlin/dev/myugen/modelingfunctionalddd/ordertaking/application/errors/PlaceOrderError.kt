package dev.myugen.modelingfunctionalddd.ordertaking.application.errors

import dev.myugen.modelingfunctionalddd.common.application.errors.ValidationError

sealed interface PlaceOrderError {
  data class Invalid(val validations: List<ValidationError>) : PlaceOrderError
}
