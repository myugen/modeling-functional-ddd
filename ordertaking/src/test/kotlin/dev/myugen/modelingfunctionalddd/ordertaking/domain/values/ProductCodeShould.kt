package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ProductCodeShould {
  @ParameterizedTest
  @ArgumentsSource(WidgetProductCodeArgumentsProvider::class)
  fun `validate widget product codes`(code: String, expected: String) {
    ProductCode.Widget.of(code).fold(
      ifLeft = { error -> assertEquals(expected, error) },
      ifRight = { widget -> assertEquals(expected, widget.value) }
    )
  }

  @ParameterizedTest
  @ArgumentsSource(GizmoProductCodeArgumentsProvider::class)
  fun `validate gizmo product codes`(code: String, expected: String) {
    ProductCode.Gizmo.of(code).fold(
      ifLeft = { error -> assertEquals(expected, error) },
      ifRight = { gizmo -> assertEquals(expected, gizmo.value) }
    )
  }

  class WidgetProductCodeArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
      return Stream.of(
        Arguments.of("W123", "W123"),
        Arguments.of("X123", "Invalid Widget code, X123. Valid format is WXXX where X is a digit"),
      )
    }
  }

  class GizmoProductCodeArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
      return Stream.of(
        Arguments.of("G12", "G12"),
        Arguments.of("Y12", "Invalid Gizmo code, Y12. Valid format is GXX where X is a digit"),
      )
    }
  }

}
