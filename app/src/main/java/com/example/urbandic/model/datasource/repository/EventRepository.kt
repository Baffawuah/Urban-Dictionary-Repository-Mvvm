package com.example.urbandic.model.datasource.repository

import com.example.urbandic.model.WordResponse.WordResponse
import com.example.urbandic.model.datasource.remote.retrofit.WordResponseService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EventRepository @Inject constructor(){

    private var wordResponse: WordResponseService = WordResponseService.createService()

    fun getWordResponse(term: String?): Observable<WordResponse> {
        //make the call for the data
        val t = wordResponse!!.getWordResponse(term)
        val wordData = t.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        return wordData
    }
}