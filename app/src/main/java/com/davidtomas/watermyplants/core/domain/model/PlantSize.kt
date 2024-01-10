package com.davidtomas.watermyplants.core.domain.model

import androidx.annotation.StringRes
import com.davidtomas.watermyplants.R

enum class PlantSize(
    @StringRes open val textResId: Int
) {
    Small(R.string.label_plant_size_small),
    Medium(R.string.label_plant_size_medium),
    Large(R.string.label_plant_size_large),
    XLarge(R.string.label_plant_size_xlarge),
}