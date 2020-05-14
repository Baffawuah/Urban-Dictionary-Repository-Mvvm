package com.example.urbandic.model.datasource.remote.retrofit

import com.example.urbandic.model.WordResponse.WordResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface  WordResponseService {
    companion object {
        fun createService() : WordResponseService =
                RetrofitHelper.getRetrofitInstance().create(WordResponseService::class.java)
    }

    @GET(RetrofitHelper.API_PATH)
    fun getWordResponse(@Query(RetrofitHelper.QUERY_TERM) term: String?): Observable<WordResponse>
}