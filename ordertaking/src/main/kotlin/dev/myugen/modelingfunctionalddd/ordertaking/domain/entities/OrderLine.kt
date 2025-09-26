package dev.myugen.modelingfunctionalddd.ordertaking.domain.entities

import dev.myugen.modelingfunctionalddd.ordertaking.domain.aggregators.OrderId
import dev.myugen.modelingfunctionalddd.ordertaking.domain.values.Id
import dev.myugen.modelingfunctionalddd.ordertaking.domain.values.OrderQuantity
import dev.myugen.modelingfunctionalddd.ordertaking.domain.values.Price
import dev.myugen.modelingfunctionalddd.ordertaking.domain.values.ProductCode
import java.util.*

data class OrderLineId private constructor(override val value: String) : Id<String>(value) {
  companion object {
    fun of(value: String): OrderLineId = OrderLineId(value)
    fun generate(): OrderLineId = OrderLineId(UUID.randomUUID().toString())
  }
}

data class OrderLine private constructor(
  override val id: OrderLineId,
  val orderId: OrderId,
  val productCode: ProductCode,
  val quantity: OrderQuantity,
  val price: Price,
) : Entity<OrderLineId>(id) {
  companion object {
    fun create(
      orderId: OrderId,
      productCode: ProductCode,
      quantity: OrderQuantity,
      price: Price,
    ): OrderLine = OrderLine(OrderLineId.generate(), orderId, productCode, quantity, price)
  }
}
