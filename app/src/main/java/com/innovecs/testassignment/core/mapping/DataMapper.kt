package com.innovecs.testassignment.core.mapping


abstract class DataMapper<in T, out U> {

    abstract fun T.fromDto(): U

    fun convertNullable(dtoEntity: T?): U? {
        return dtoEntity?.fromDto()
    }

    fun convertListNullable(dtoEntities: List<T>?): List<U>? {
        return dtoEntities?.map { it.fromDto() }
    }
}