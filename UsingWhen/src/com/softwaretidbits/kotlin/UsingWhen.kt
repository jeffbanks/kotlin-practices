package com.softwaretidbits.kotlin

import kotlin.math.roundToInt

/**
 *
 * Kotlin try/catch as expression.
 *
 * softwaretidbits.com
 *
 */
class UsingWhen {

    fun nucleotideName(code: String?): String = when (code) {
        null -> throw IllegalArgumentException("code supplied is null")
        "T" -> "thymine"
        "A" -> "adenine"
        "C" -> "cytosine"
        "G" -> "guanine"
        else -> "unknown code supplied: $code"
    }

    fun nucleotideNameCodeNotNull(code: String): String = when (code) {
        "T" -> "thymine"
        "A" -> "adenine"
        "C" -> "cytosine"
        "G" -> "guanine"
        else -> "unknown code supplied: $code"
    }

    fun phType(value: Int?): String = when (value) {
        null -> throw IllegalArgumentException("value supplied is null")
        in 0..6 -> "acidic"
        in 7..7 -> "neutral"
        in 8..14 -> "alkaline"
        else -> "out of range detected: $value"
    }

    fun phTypeWhenStatement(value: Int?) {
        when (value) {
            null -> throw IllegalArgumentException("value supplied is null")
            in 0..6 -> println("acidic")
            in 7..7 -> println("neutral")
            in 8..14 -> println("alkaline")
        }
    }

    fun normalizePhValueType(value: Any?): String? = when (value) {
        null -> throw IllegalArgumentException(
            "value supplied is null or " +
                    "not able to be normalized to number"
        )
        is String -> {
            val stringToValue: Any? =
                value.toDoubleOrNull()
                    ?: value.toFloatOrNull()
                    ?: value.toIntOrNull()
            normalizePhValueType(stringToValue)
        }
        is Int -> phType(value)
        is Float -> phType(value.roundToInt())
        is Double -> phType(value.roundToInt())
        is Long -> phType(value.toInt())
        else -> throw java.lang.IllegalArgumentException("pH value's type can't be converted")
    }
}

fun main() {

    val app = UsingWhen()

    println(app.phTypeWhenStatement(5))
    println(app.nucleotideName("T"))
    println(app.nucleotideNameCodeNotNull("G"))

    println(app.normalizePhValueType("100.0"))
    println(app.normalizePhValueType("1"))
    println(app.normalizePhValueType("3.202010101101"))
    println(app.normalizePhValueType("3.2020901011012222"))
    println(app.normalizePhValueType("7.1"))

    println(app.normalizePhValueType(3.1F))
    println(app.normalizePhValueType(5))
    println(app.normalizePhValueType(32819301740171L))
    println(app.normalizePhValueType(8.2020901011012222))

    // Throws exception!
    println(app.normalizePhValueType("what is this?"))
}
