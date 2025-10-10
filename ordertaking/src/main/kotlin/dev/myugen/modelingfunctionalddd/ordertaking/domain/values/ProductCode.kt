package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure

sealed interface ProductCode {
  @JvmInline
  value class Widget private constructor(val value: String) : ProductCode {
    companion object {
      fun of(value: String): Either<String, Widget> = either {
        val isValidWidgetCode = value.length == 5
          && value.startsWith("W")
          && value.substring(1).all { it.isDigit() }
        ensure(isValidWidgetCode) { "Invalid Widget code, $value. Valid format is WXXXX where X is a digit" }
        Widget(value)
      }

      fun unchecked(value: String): Widget = Widget(value)
    }
  }

  @JvmInline
  value class Gizmo private constructor(val value: String) : ProductCode {
    companion object {
      fun of(value: String): Either<String, Gizmo> = either {
        val isValidGizmoCode = value.length == 4
          && value.startsWith("G")
          && value.substring(1).all { it.isDigit() }
        ensure(isValidGizmoCode) { "Invalid Gizmo code, $value. Valid format is GXXX where X is a digit" }
        Gizmo(value)
      }

      fun unchecked(value: String): Gizmo = Gizmo(value)
    }
  }
}
