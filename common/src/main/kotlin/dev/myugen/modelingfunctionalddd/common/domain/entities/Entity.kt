package dev.myugen.modelingfunctionalddd.common.domain.entities

import dev.myugen.modelingfunctionalddd.common.domain.values.Id

abstract class Entity<T : Id<*>>(open val id: T) {

  override fun equals(other: Any?): Boolean = when {
    this === other -> true
    other !is Entity<*> -> false
    id != other.id -> false
    else -> true
  }

  override fun hashCode(): Int = id?.hashCode() ?: 0
}