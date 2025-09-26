package dev.myugen.modelingfunctionalddd.ordertaking.domain.entities

import dev.myugen.modelingfunctionalddd.common.domain.entities.Entity
import dev.myugen.modelingfunctionalddd.ordertaking.domain.values.*

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
