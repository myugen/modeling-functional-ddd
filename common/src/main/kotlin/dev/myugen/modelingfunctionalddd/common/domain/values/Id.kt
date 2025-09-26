package dev.myugen.modelingfunctionalddd.common.domain.values

abstract class Id<T>(open val value: T) {
  override fun equals(other: Any?): Boolean = when {
    this === other -> true
    other !is Id<*> -> false
    value != other.value -> false
    else -> true
  }

  override fun hashCode(): Int = value.hashCode()
}
