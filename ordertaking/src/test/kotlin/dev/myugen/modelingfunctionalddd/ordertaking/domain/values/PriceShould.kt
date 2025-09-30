package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.math.BigDecimal
import java.util.stream.Stream
import kotlin.test.assertEquals

class PriceShould {
  @ParameterizedTest
  @ArgumentsSource(PriceArgumentsProvider::class)
  fun `validate prices`(value: BigDecimal, expected: String) {
    Price.of(value).fold(
      ifLeft = { error -> assertEquals(expected, error) },
      ifRight = { price -> assertEquals(expected, price.value.toString()) }
    )
  }

  class PriceArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
      return Stream.of(
        Arguments.of(BigDecimal("99.99"), "99.99"),
        Arguments.of(BigDecimal.ZERO, "0"),
        Arguments.of(BigDecimal("0.01"), "0.01"),
        Arguments.of(BigDecimal("1000"), "1000"),
        Arguments.of(BigDecimal("-1"), "Price must be non-negative"),
        Arguments.of(BigDecimal("-50.25"), "Price must be non-negative"),
      )
    }
  }

}