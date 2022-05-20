package com.example.marsroverphotos.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.PhotoEntity
import com.example.data.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: PhotoRepository) : ViewModel() {
    private var dataFromDb: Flow<List<PhotoEntity>> = repository.getPhotos()

    private fun fetchOneMoreElement() {

    }

    val homeState = HomeUiState(
        photosValue = dataFromDb.stateIn(viewModelScope, SharingStarted.Lazily, emptyList()),
        fetchData = this::fetchOneMoreElement,
    )
}