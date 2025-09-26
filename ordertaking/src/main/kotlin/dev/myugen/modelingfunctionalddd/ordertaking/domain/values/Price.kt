package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import java.math.BigDecimal

@JvmInline
value class Price private constructor(val value: BigDecimal) {
  companion object {
    fun of(value: BigDecimal): Price {
      return Price(value)
    }
  }
}
