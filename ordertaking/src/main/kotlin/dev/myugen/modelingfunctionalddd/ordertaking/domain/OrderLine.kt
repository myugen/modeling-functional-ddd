package dev.myugen.modelingfunctionalddd.ordertaking.domain

data class OrderLineId(override val value: String) : Id<String>(value) {
  companion object {
    fun generate(): OrderLineId = OrderLineId(java.util.UUID.randomUUID().toString())
  }
}

data class OrderLine private constructor(override val id: OrderLineId) : Entity<OrderLineId>(id) {
  companion object {
    fun create(): OrderLine = OrderLine(OrderLineId.generate())
  }
}
