package com.davidtomas.watermyplants.features.home.domain.model

sealed class PlantStatus(val name: String) {
    object Upcoming : PlantStatus(UPCOMING_TXT)
    object ForgotToWater : PlantStatus(FORGOT_TO_WATER_TXT)
    object History : PlantStatus(HISTORY_TXT)

    companion object {
        private const val UPCOMING_TXT = "Upcoming"
        private const val FORGOT_TO_WATER_TXT = "Forgot to water"
        private const val HISTORY_TXT = "History"
        fun fromString(name: String): PlantStatus {
            return when (name) {
                UPCOMING_TXT -> Upcoming
                FORGOT_TO_WATER_TXT -> ForgotToWater
                HISTORY_TXT -> History
                else -> History
            }
        }
    }
}