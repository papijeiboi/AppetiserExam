package com.papijeiboi.appetiser_exam.viewmodel

import androidx.lifecycle.*
import com.papijeiboi.appetiser_exam.data.TrackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    repository: TrackRepository
) : ViewModel() {
    val tracks = repository.getTrack().asLiveData()
}