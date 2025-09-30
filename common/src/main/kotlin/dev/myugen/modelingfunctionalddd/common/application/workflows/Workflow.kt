package dev.myugen.modelingfunctionalddd.common.application.workflows

fun interface Workflow<In, Out> {
  operator fun invoke(input: In): Out
}
