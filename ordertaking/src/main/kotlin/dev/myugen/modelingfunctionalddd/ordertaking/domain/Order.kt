package dev.myugen.modelingfunctionalddd.ordertaking.domain

data class OrderId(override val value: String) : Id<String>(value) {
  companion object {
    fun generate(): OrderId = OrderId(java.util.UUID.randomUUID().toString())
  }
}

data class Order(override val id: OrderId, private val orderLines: List<OrderLine>) :
  Entity<OrderId>(id) {
  companion object {
    fun create(orderLines: List<OrderLine>): Order = Order(OrderId.generate(), orderLines)
  }
}
