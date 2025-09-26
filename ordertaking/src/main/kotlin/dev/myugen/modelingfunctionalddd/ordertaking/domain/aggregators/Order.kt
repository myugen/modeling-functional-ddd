package dev.myugen.modelingfunctionalddd.ordertaking.domain.aggregators

import dev.myugen.modelingfunctionalddd.ordertaking.domain.entities.Entity
import dev.myugen.modelingfunctionalddd.ordertaking.domain.entities.OrderLine
import dev.myugen.modelingfunctionalddd.ordertaking.domain.values.*
import java.math.BigDecimal

data class Order(
  override val id: OrderId,
  val customerId: CustomerId,
  val shippingAddress: ShippingAddress,
  val billingAddress: BillingAddress,
  val orderLines: List<OrderLine>,
  val billingAmount: BillingAmount,
) : Entity<OrderId>(id) {
  companion object {
    fun create(
      customerId: CustomerId,
      shippingAddress: ShippingAddress,
      billingAddress: BillingAddress,
      orderLines: List<OrderLine>,
    ): Order = Order(
      OrderId.generate(),
      customerId,
      shippingAddress,
      billingAddress,
      orderLines,
      BillingAmount.of(BigDecimal.ZERO),
    )
  }
}
