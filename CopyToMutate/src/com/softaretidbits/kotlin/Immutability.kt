package com.softwaretidbits.kotlin

class Immutability {

    fun copyFromOriginal() {

        val originalRecord = DataRecord("Samuel", "Davies", 50322)
        println(originalRecord)

        val updatedRecord = originalRecord.copy(zip = 80322)
        println(updatedRecord)

        val updatedRecordOfTwoFields = originalRecord.copy(zip=55555, firstName="Sammy")
        println(updatedRecordOfTwoFields)
        println(originalRecord)
        println(updatedRecord)
    }
}

data class DataRecord(val firstName: String, val lastName: String, val zip: Int)

fun main() {
    val immutableExample = Immutability()
    immutableExample.copyFromOriginal()
}