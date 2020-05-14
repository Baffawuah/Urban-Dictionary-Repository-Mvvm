package com.example.urbandic.model.dagger.di;

import com.example.urbandic.model.dagger.di.main.MainViewModelsModule;
import com.example.urbandic.view.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
