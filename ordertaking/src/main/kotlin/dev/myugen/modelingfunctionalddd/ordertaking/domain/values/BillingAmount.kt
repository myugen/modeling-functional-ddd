package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import java.math.BigDecimal

@JvmInline
value class BillingAmount private constructor(val value: BigDecimal) {
  companion object {
    fun of(value: BigDecimal): Either<String, BillingAmount> = either {
      ensure(value >= BigDecimal.ZERO) { "Billing amount must be non-negative" }
      BillingAmount(value)
    }
  }
}
