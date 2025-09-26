package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import dev.myugen.modelingfunctionalddd.common.domain.values.Id

data class CustomerId(override val value: String) : Id<String>(value) {
  companion object {
    fun of(value: String): CustomerId {
      return CustomerId(value)
    }
  }
}
