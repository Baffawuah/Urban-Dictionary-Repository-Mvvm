package com.example.urbandic.model.dagger.di;

import com.example.urbandic.model.datasource.remote.retrofit.WordResponseService;
import com.example.urbandic.model.datasource.repository.EventRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    static String getThatString(){
        return "this is a test String";
    }

    @Singleton
    @Provides
    static EventRepository providesEventRepository(){
        return new EventRepository();
    }

    @Singleton
    @Provides
    static WordResponseService providesWordResponseService(){
        return WordResponseService.Companion.createService();
    }
}
