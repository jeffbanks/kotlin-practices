package com.softwaretidbits.kotlin


/**
 *
 * Kotlin try/catch as expression.
 *
 * softwaretidbits.com
 *
 */
class TryCatch {

    fun usingTryCatchAsExpression(inputValue: String): Number {
        return try {
            return invokeLibWith(inputValue)
        } catch (ex: NumberFormatException) {
            1
        }
    }

    private fun invokeLibWith(constantAsString: String): Number {
        return Integer.valueOf(constantAsString)
    }
}

fun main() {

    val app = TryCatch()
    val myConstant = "1000"
    val numberReturned = app.usingTryCatchAsExpression(myConstant)
    println(numberReturned)

    val myConstantNotNumber = "abc123"
    val defaultNumberReturned = app.usingTryCatchAsExpression(myConstantNotNumber)
    println(defaultNumberReturned)
}
