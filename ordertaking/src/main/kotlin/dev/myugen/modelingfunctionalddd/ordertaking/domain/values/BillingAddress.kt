package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

@JvmInline
value class BillingAddress private constructor(val value: String) {
  companion object {
    fun of(value: String): BillingAddress {
      return BillingAddress(value)
    }
  }
}
