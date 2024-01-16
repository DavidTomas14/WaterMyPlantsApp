package com.davidtomas.watermyplants.core.util

import java.time.DayOfWeek

val String.Companion.EMPTY_STRING: String
    get() = ""

fun String.capitalizeOnlyFirstLetter(): String = this.lowercase()
    .replaceFirstChar { it.uppercase() }

fun List<DayOfWeek>.formatToTwoLetterString() = joinToString(separator = ", ") {
    it.name.substring(0, 2).capitalizeOnlyFirstLetter()
}

fun String.formatToListOfDayWeek(): List<DayOfWeek> {
    val days = this.split(',')
    return if (days.size == 1) {
        listOf(
            DayOfWeek.values()
                .first() { it.name.substring(0, 2).uppercase() == days.first().uppercase() })
    } else {
        days.map { element ->
            DayOfWeek.values()
                .first() { it.name.substring(0, 2).uppercase() == element.trim().uppercase() }
        }
    }
}