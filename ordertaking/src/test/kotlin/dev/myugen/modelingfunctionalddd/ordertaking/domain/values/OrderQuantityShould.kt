package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.math.BigDecimal
import java.util.stream.Stream
import kotlin.test.assertEquals

class OrderQuantityShould {
  @ParameterizedTest
  @ArgumentsSource(UnitOrderQuantityArgumentsProvider::class)
  fun `validate unit order quantity`(code: Int, expected: Either<String, OrderQuantity.Unit>) {
    assertEquals(expected, OrderQuantity.Unit.of(code))
  }

  @ParameterizedTest
  @ArgumentsSource(KilogramOrderQuantityArgumentsProvider::class)
  fun `validate kilogram order quantity`(
    code: BigDecimal,
    expected: Either<String, OrderQuantity.Kilogram>
  ) {
    assertEquals(expected, OrderQuantity.Kilogram.of(code))
  }

  class UnitOrderQuantityArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
      return Stream.of(
        Arguments.of(5, OrderQuantity.Unit.unchecked(5).right()),
        Arguments.of(
          -1,
          "Unit order quantity must be between 1 and 1000".left(),
        ),
      )
    }
  }

  class KilogramOrderQuantityArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
      return Stream.of(
        Arguments.of(
          "0.150".toBigDecimal(),
          OrderQuantity.Kilogram.unchecked("0.150".toBigDecimal()).right()
        ),
        Arguments.of(
          "0.01".toBigDecimal(),
          "Kilogram order quantity must be between 0.05 and 100.00".left(),
        ),
      )
    }
  }
}
