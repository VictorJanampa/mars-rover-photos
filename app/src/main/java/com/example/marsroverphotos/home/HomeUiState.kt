package com.example.marsroverphotos.home

import com.example.data.models.PhotoRoomModel
import kotlinx.coroutines.flow.StateFlow

data class HomeUiState (
    val photosValue: StateFlow<List<PhotoRoomModel>>,
    val fetchData: () -> Unit,
    )
