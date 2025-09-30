package dev.myugen.modelingfunctionalddd.ordertaking.application.inputs

data class UnvalidatedOrder(
  val orderId: String,
  val customerInfo: Nothing,
  val shippingAddress: String,
)
