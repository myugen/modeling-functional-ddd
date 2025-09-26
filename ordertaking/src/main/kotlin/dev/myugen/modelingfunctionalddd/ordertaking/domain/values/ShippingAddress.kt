package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

@JvmInline
value class ShippingAddress private constructor(val value: String) {
  companion object {
    fun of(value: String): ShippingAddress {
      return ShippingAddress(value)
    }
  }
}
