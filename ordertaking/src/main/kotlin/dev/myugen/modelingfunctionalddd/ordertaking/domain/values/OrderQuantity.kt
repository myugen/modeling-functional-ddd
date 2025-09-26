package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import java.math.BigDecimal

sealed interface OrderQuantity {
  @JvmInline
  value class Kilogram private constructor(val value: BigDecimal) : OrderQuantity {
    companion object {
      fun of(value: BigDecimal): Kilogram {
        return Kilogram(value)
      }
    }
  }

  @JvmInline
  value class Unit private constructor(val value: Int) : OrderQuantity {
    companion object {
      fun of(value: Int): Unit {
        return Unit(value)
      }
    }
  }
}
