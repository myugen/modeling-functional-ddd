package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import java.math.BigDecimal

@JvmInline
value class Price private constructor(val value: BigDecimal) {
  companion object {
    fun of(value: BigDecimal): Either<String, Price> = either {
      ensure(value >= BigDecimal.ZERO) { "Price must be non-negative" }
      Price(value)
    }
  }
}
