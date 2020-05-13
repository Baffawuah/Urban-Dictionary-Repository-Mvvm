package com.example.urbandic.model.datasource.remote.retrofit;

import android.util.Log;

import com.example.urbandic.model.datasource.events.WordResponseEvent;
import com.example.urbandic.model.WordResponse.WordResponse;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverWordResponse implements Observer<WordResponse> {
    //Local variable should be included so you can pass something back
    WordResponse wordResponse;
    @Override
    public void onSubscribe(Disposable d) {
        //Log this

    }

    @Override
    public void onNext(WordResponse wordResponse) {
        this.wordResponse = wordResponse;

    }

    @Override
    public void onError(Throwable e) {
        Log.e("CHAIN", "onError: ", e );

    }

    @Override
    public void onComplete() {
        EventBus.getDefault().post(new WordResponseEvent(wordResponse));
    }
}