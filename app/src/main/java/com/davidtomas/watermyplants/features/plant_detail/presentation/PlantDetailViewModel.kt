package com.davidtomas.watermyplants.features.plant_detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.davidtomas.watermyplants.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(

) : ViewModel() {
    var state by mutableStateOf(PlantDetailState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: PlantDetailEvent) {
        when (event) {
            else -> Unit
        }
    }
}