package com.example.marsroverphotos.home

import com.example.domain.models.Photo
import kotlinx.coroutines.flow.StateFlow

data class HomeUiState (
    val photosValue: StateFlow<List<Photo>>,
    val selectedChip: StateFlow<String>,
    val filterPhotos: (String) -> Unit,
    val onSelectedChip: (String) -> Unit
)
