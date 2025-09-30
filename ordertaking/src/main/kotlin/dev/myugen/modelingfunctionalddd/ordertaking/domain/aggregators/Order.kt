package dev.myugen.modelingfunctionalddd.ordertaking.domain.aggregators

import arrow.core.Either
import arrow.core.NonEmptyList
import arrow.core.raise.ExperimentalRaiseAccumulateApi
import arrow.core.raise.accumulate
import arrow.core.raise.either
import arrow.core.raise.ensure
import dev.myugen.modelingfunctionalddd.common.domain.entities.Entity
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
    @OptIn(ExperimentalRaiseAccumulateApi::class)
    fun create(
      customerId: CustomerId,
      shippingAddress: ShippingAddress,
      billingAddress: BillingAddress,
      orderLines: List<OrderLine>,
    ): Either<NonEmptyList<String>, Order> = either {
      accumulate {
        ensure(orderLines.isNotEmpty()) { "Order must have at least one order line" }
        val billingAmount = BillingAmount.of(BigDecimal.ZERO).bind()
        Order(
          OrderId.generate(),
          customerId,
          shippingAddress,
          billingAddress,
          orderLines,
          billingAmount,
        )
      }
    }
  }
}
