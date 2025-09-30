package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.math.BigDecimal
import java.util.stream.Stream
import kotlin.test.assertEquals

class BillingAmountShould {
  @ParameterizedTest
  @ArgumentsSource(BillingAmountArgumentsProvider::class)
  fun `validate billing amounts`(value: BigDecimal, expected: String) {
    BillingAmount.of(value).fold(
      ifLeft = { error -> assertEquals(expected, error) },
      ifRight = { billingAmount -> assertEquals(expected, billingAmount.value.toString()) }
    )
  }

  class BillingAmountArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
      return Stream.of(
        Arguments.of(BigDecimal("100.50"), "100.50"),
        Arguments.of(BigDecimal.ZERO, "0"),
        Arguments.of(BigDecimal("0.01"), "0.01"),
        Arguments.of(BigDecimal("-1"), "Billing amount must be non-negative"),
        Arguments.of(BigDecimal("-100.50"), "Billing amount must be non-negative"),
      )
    }
  }

}