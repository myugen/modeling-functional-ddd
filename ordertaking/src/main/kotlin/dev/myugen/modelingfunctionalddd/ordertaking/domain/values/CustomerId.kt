package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

data class CustomerId(override val value: String) : Id<String>(value) {
  companion object {
    fun of(value: String): CustomerId {
      return CustomerId(value)
    }
  }
}
