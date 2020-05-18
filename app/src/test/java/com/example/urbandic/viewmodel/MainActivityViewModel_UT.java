package com.example.urbandic.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.urbandic.model.WordResponse.WordResponse;
import com.example.urbandic.model.datasource.repository.EventRepository;
import com.example.urbandic.viewmodel.MainActivityViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class MainActivityViewModel_UT {
    @Mock EventRepository repository;
    @Mock MutableLiveData<String> searchTerm;

    @InjectMocks
    MainActivityViewModel viewModel;

    Observable<WordResponse> wordResponse;

    private String testValue;

    @Before
    public void setUp(){
        viewModel = new MainActivityViewModel();
        testValue = "testing Value";

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFromRepository(){
        when(searchTerm.getValue()).thenReturn(testValue);
        when(repository.getWordResponse(testValue)).thenReturn(wordResponse);

        assertSame(
                viewModel.DataCall(),
                wordResponse
        );
    }
}