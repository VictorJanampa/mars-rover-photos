package com.example.marsroverphotos.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.CameraType
import com.example.domain.interactors.FilterPhotosUseCaseImpl
import com.example.domain.interactors.GetPhotosUseCaseImpl
import com.example.domain.models.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPhotosUseCaseImpl: GetPhotosUseCaseImpl,
    private val filterPhotosUseCaseImpl: FilterPhotosUseCaseImpl) : ViewModel() {
    private var photoList: Flow<List<Photo>> = getPhotosUseCaseImpl.invoke()
    private val selectedChipStateFlow: MutableStateFlow<String> = MutableStateFlow(CameraType.FHAZ.toString())

    private fun filterPhotos(cameraName: String) {
        viewModelScope.launch(Dispatchers.IO){
            filterPhotosUseCaseImpl.invoke(cameraName)
        }
    }

    private fun onSelectedChip(cameraName: String){
        selectedChipStateFlow.value = cameraName.uppercase()
        filterPhotos(cameraName)
    }

    val homeState = HomeUiState(
        photosValue = photoList.stateIn(viewModelScope, SharingStarted.Lazily, emptyList()),
        selectedChip = selectedChipStateFlow,
        filterPhotos = this::filterPhotos,
        onSelectedChip = this::onSelectedChip
    )
}