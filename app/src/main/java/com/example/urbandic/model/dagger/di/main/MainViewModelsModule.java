package com.example.urbandic.model.dagger.di.main;

import androidx.lifecycle.ViewModel;

import com.example.urbandic.model.dagger.di.ViewModelKey;
import com.example.urbandic.viewmodel.MainActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    public abstract ViewModel bindMainViewModel(MainActivityViewModel mainActivityViewModel);
}
