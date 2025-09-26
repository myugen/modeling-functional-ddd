package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import java.util.*

data class OrderId private constructor(override val value: String) : Id<String>(value) {
  companion object {
    fun of(value: String): OrderId = OrderId(value)
    fun generate(): OrderId = OrderId(UUID.randomUUID().toString())
  }
}
