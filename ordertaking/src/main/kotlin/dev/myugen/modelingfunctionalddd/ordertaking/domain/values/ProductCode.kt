package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

sealed interface ProductCode {
  @JvmInline
  value class Widget private constructor(val value: String) : ProductCode {
    companion object {
      fun of(value: String): Widget {
        return Widget(value)
      }
    }
  }

  @JvmInline
  value class Gizmo private constructor(val value: String) : ProductCode {
    companion object {
      fun of(value: String): Gizmo {
        return Gizmo(value)
      }
    }
  }
}
