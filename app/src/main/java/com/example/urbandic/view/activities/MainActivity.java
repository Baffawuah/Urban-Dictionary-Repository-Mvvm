package com.example.urbandic.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.urbandic.R;
import com.example.urbandic.databinding.ActivityMainBinding;
import com.example.urbandic.model.WordResponse.WordResponse;
import com.example.urbandic.model.adapters.WordsRVAdapter;
import com.example.urbandic.model.WordResponse.ListItem;

import com.example.urbandic.viewmodel.MainActivityViewModel;
import com.example.urbandic.viewmodel.ViewModelProviderFactory;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends DaggerAppCompatActivity {
    ArrayList<ListItem> defList;

    //getting the viewModel working
    MainActivityViewModel mainActivityViewModel;
    ActivityMainBinding binding;

    @Inject
    ViewModelProviderFactory providerFactory;

    RecyclerView recyclerView;
    WordsRVAdapter adapter;
    LinearLayoutManager viewManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewModel
        mainActivityViewModel = new ViewModelProvider(this, providerFactory).get(MainActivityViewModel.class);
        //mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewModel(mainActivityViewModel);
        binding.setLifecycleOwner(this);

    }

    public void sortFuncClick(View view) {
        if(adapter != null) {
            switch (view.getId()) {
                case R.id.btnSortUpVote:
                    adapter.orderThumbsUp();
                    break;
                case R.id.btnSortDownVote:
                    Toast.makeText(this, "Downsort Clicked", Toast.LENGTH_SHORT).show();
                    adapter.orderThumbsDown();
                    break;
            }
        }
    }

    public void onClick(View v){
        mainActivityViewModel
                .DataCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver);
    }

    public void updateRecyclerView(){
        //adapter.setListItems(set);
        //if the RecyclerView isn't up yet, make a call and fill it
        if(adapter == null){
            //RecyclerView Setup
            recyclerView = findViewById(R.id.rvWordList);
            viewManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(viewManager);

            defList = new ArrayList<>(mainActivityViewModel.getWordData().getValue().getList());
            adapter = new WordsRVAdapter(defList);
            recyclerView.setAdapter(adapter);

        } else {
            defList = new ArrayList<>(mainActivityViewModel.getWordData().getValue().getList());
            adapter.setListItems(defList);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    Observer<WordResponse> myObserver = new Observer<WordResponse>() {
        @Override
        public void onSubscribe(Disposable d) { }

        @Override
        public void onNext(WordResponse wordResponse) {
            mainActivityViewModel.setWordData(new MutableLiveData<>(wordResponse));
        }
        @Override
        public void onError(Throwable e) { }

        @Override
        public void onComplete() { updateRecyclerView(); }
    };
}
