package com.example.urbandic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.urbandic.model.WordResponse.WordResponse
import com.example.urbandic.model.datasource.repository.EventRepository
import io.reactivex.Observable
import javax.inject.Inject


class MainActivityViewModel @Inject constructor() : ViewModel() {
    val TAG = "NETCALL"

    var searchTerm : MutableLiveData<String>
    var wordData : MutableLiveData<WordResponse>
    @Inject
    lateinit var repository: EventRepository

    // sets up the repo and liveData
    init {
        searchTerm = MutableLiveData<String>()
        wordData = MutableLiveData<WordResponse>()
    }

    fun DataCall() : Observable<WordResponse> {
        // define the function here
        // return an observable to be consumed
        return repository
                .getWordResponse(searchTerm.value)
    }
}