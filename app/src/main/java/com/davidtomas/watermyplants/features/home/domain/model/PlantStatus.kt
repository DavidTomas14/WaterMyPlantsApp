package com.davidtomas.watermyplants.features.home.domain.model

sealed class PlantStatus(val name: String) {
    object Today : PlantStatus(UPCOMING_TXT)
    object ForgotToWater : PlantStatus(FORGOT_TO_WATER_TXT)
    object NextDays : PlantStatus(HISTORY_TXT)

    companion object {
        private const val UPCOMING_TXT = "Today"
        private const val FORGOT_TO_WATER_TXT = "Forgot to water"
        private const val HISTORY_TXT = "Next Days"
        fun fromString(name: String): PlantStatus {
            return when (name) {
                UPCOMING_TXT -> Today
                FORGOT_TO_WATER_TXT -> ForgotToWater
                HISTORY_TXT -> NextDays
                else -> NextDays
            }
        }
    }
}