package com.example.urbandic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.urbandic.model.WordResponse.WordResponse
import com.example.urbandic.model.datasource.remote.retrofit.WordResponseService
import com.example.urbandic.model.datasource.repository.EventRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivityViewModel : ViewModel() {
    val TAG = "NETCALL"

    var searchTerm : MutableLiveData<String>
    var wordData : MutableLiveData<WordResponse>
    val repo : EventRepository
    // sets up the repo and liveData
    init {
        searchTerm = MutableLiveData<String>()
        wordData = MutableLiveData<WordResponse>()
        repo = EventRepository
    }

    fun DataCall() : Observable<WordResponse> {
        // define the function here
        // return an observable to be consumed
        return WordResponseService
                .createService()
                .getWordResponse(searchTerm.value)
    }

    fun searchFunc() {

        wordData = EventRepository.getWordResponse(searchTerm.value)!!
        DataCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{}
    }

}