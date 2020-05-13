package com.example.urbandic.model.datasource.repository

import androidx.lifecycle.MutableLiveData
import com.example.urbandic.model.WordResponse.WordResponse
import com.example.urbandic.model.datasource.remote.retrofit.WordResponseService
import com.example.urbandic.model.datasource.remote.retrofit.WordResponseService.Companion.createService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object EventRepository {
    // todo dagger this up
    private var wordResponse: WordResponseService? = null

    //singleton Repository to get instance of connection for the app
    init {
        wordResponse = createService()
    }

    fun getWordResponse(term: String?): MutableLiveData<WordResponse>? {
        val wordData = MutableLiveData<WordResponse>()
        //make the call for the data
        val t = wordResponse!!.getWordResponse(term)
        t.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ wordData.value = it}
        return wordData
    }
}