package dev.myugen.modelingfunctionalddd.ordertaking.application.workflows

import arrow.core.Either
import dev.myugen.modelingfunctionalddd.common.application.workflows.Workflow
import dev.myugen.modelingfunctionalddd.ordertaking.application.errors.PlaceOrderError
import dev.myugen.modelingfunctionalddd.ordertaking.application.inputs.UnvalidatedOrder
import dev.myugen.modelingfunctionalddd.ordertaking.application.outputs.PlaceOrderEvents

class PlaceOrder : Workflow<UnvalidatedOrder, Either<PlaceOrderError, PlaceOrderEvents>> {
  override operator fun invoke(input: UnvalidatedOrder): Either<PlaceOrderError, PlaceOrderEvents> {
    TODO()
  }
}
