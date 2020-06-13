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

    val firstConstant = "1000"
    val firstReturn = app.usingTryCatchAsExpression(firstConstant)
    println("First Run: $firstReturn")

    val secondConstant = "abc123"
    val secondReturn = app.usingTryCatchAsExpression(secondConstant)
    println("Second Run: $secondReturn")
}
