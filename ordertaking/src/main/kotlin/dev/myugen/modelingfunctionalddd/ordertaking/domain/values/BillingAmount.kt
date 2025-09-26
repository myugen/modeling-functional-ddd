package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import java.math.BigDecimal

@JvmInline
value class BillingAmount private constructor(val value: BigDecimal) {
  companion object {
    fun of(value: BigDecimal): BillingAmount {
      return BillingAmount(value)
    }
  }
}
