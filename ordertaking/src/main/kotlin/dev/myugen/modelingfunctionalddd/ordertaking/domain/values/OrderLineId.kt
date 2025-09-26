package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import java.util.*

data class OrderLineId private constructor(override val value: String) : Id<String>(value) {
  companion object {
    fun of(value: String): OrderLineId = OrderLineId(value)
    fun generate(): OrderLineId = OrderLineId(UUID.randomUUID().toString())
  }
}
