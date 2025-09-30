package dev.myugen.modelingfunctionalddd.ordertaking.domain.values

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class BillingAddressShould {
  @ParameterizedTest
  @ArgumentsSource(BillingAddressArgumentsProvider::class)
  fun `validate billing addresses`(value: String, expected: String) {
    BillingAddress.of(value).fold(
      ifLeft = { error -> assertEquals(expected, error) },
      ifRight = { billingAddress -> assertEquals(expected, billingAddress.value) }
    )
  }

  class BillingAddressArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
      return Stream.of(
        Arguments.of("123 Main St, City, State 12345", "123 Main St, City, State 12345"),
        Arguments.of("A", "A"),
        Arguments.of("Valid address", "Valid address"),
        Arguments.of("", "Billing address must not be blank"),
        Arguments.of("   ", "Billing address must not be blank"),
      )
    }
  }

}