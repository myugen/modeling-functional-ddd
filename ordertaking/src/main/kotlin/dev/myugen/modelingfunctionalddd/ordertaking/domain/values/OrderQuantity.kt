package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import java.math.BigDecimal

sealed interface OrderQuantity {
  @JvmInline
  value class Kilogram private constructor(val value: BigDecimal) : OrderQuantity {
    companion object {
      fun of(value: BigDecimal): Either<String, Kilogram> = either {
        val isInValidRange = value >= BigDecimal("0.05") && value <= BigDecimal("100.00")
        ensure(isInValidRange) { "Kilogram order quantity must be between 0.05 and 100.00" }
        Kilogram(value)
      }

      fun unchecked(value: BigDecimal): Kilogram = Kilogram(value)
    }
  }

  @JvmInline
  value class Unit private constructor(val value: Int) : OrderQuantity {
    companion object {
      fun of(value: Int): Either<String, Unit> = either {
        val isInValidRange = IntRange(1, 1000).contains(value)
        ensure(isInValidRange) { "Unit order quantity must be between 1 and 1000" }
        Unit(value)
      }

      fun unchecked(value: Int): Unit = Unit(value)
    }
  }
}
