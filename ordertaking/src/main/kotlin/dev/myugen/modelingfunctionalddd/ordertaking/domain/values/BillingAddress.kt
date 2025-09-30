package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure

@JvmInline
value class BillingAddress private constructor(val value: String) {
  companion object {
    fun of(value: String): Either<String, BillingAddress> = either {
      ensure(value.isNotBlank()) { "Billing address must not be blank" }
      BillingAddress(value)
    }
  }
}
