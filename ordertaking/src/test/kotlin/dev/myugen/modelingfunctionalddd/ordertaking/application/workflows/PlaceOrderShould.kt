package dev.myugen.modelingfunctionalddd.ordertaking.application.workflows

import dev.myugen.modelingfunctionalddd.ordertaking.application.inputs.UnvalidatedOrder
import org.junit.jupiter.api.Test

class PlaceOrderShould {
  @Test
  fun `do something`() {
    val workflow = PlaceOrder(/* dependencies */)

    val input = UnvalidatedOrder(
      orderId = "123",
      customerInfo = TODO(),
      shippingAddress = "456 Main St",
    )

    val output = workflow(input)

    assert(true)
  }
}
