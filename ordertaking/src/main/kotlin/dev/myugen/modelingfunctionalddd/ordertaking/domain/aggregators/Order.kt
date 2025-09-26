package dev.myugen.modelingfunctionalddd.ordertaking.domain.aggregators

import dev.myugen.modelingfunctionalddd.ordertaking.domain.entities.Entity
import dev.myugen.modelingfunctionalddd.ordertaking.domain.entities.OrderLine
import dev.myugen.modelingfunctionalddd.ordertaking.domain.values.Id
import java.util.*

data class OrderId private constructor(override val value: String) : Id<String>(value) {
  companion object {
    fun of(value: String): OrderId = OrderId(value)
    fun generate(): OrderId = OrderId(UUID.randomUUID().toString())
  }
}

data class Order(
  override val id: OrderId,
  val orderLines: List<OrderLine>,
) : Entity<OrderId>(id) {
  companion object {
    fun create(orderLines: List<OrderLine>): Order = Order(OrderId.generate(), orderLines)
  }
}
