package com.example.marsroverphotos.home

import com.example.data.models.PhotoEntity
import kotlinx.coroutines.flow.StateFlow

data class HomeUiState (
    val photosValue: StateFlow<List<PhotoEntity>>,
    val fetchData: () -> Unit,
    )
