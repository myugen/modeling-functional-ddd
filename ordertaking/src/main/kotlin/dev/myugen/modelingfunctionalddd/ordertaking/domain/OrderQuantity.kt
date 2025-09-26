package dev.myugen.modelingfunctionalddd.ordertaking.domain

sealed interface OrderQuantity {
  @JvmInline
  value class Kilogram private constructor(val value: Double) : OrderQuantity {
    companion object {
      fun of(value: Double): Kilogram {
        return Kilogram(value)
      }
    }
  }

  @JvmInline
  value class Unit private constructor(val value: Int) : OrderQuantity {
    companion object {
      fun of(value: Int): Unit {
        return Unit(value)
      }
    }
  }
}
