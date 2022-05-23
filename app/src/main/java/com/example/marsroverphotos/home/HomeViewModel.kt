package com.example.marsroverphotos.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.PhotoRoomModel
import com.example.domain.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: PhotoRepository<PhotoRoomModel>) : ViewModel() {
    private var dataFromDb: Flow<List<PhotoRoomModel>> = runBlocking {repository.getPhotos()}

    private fun fetchData() {


    }

    val homeState = HomeUiState(
        photosValue = dataFromDb.stateIn(viewModelScope, SharingStarted.Lazily, emptyList()),
        fetchData = this::fetchData,
    )
}