package com.hirumi.visualnovelstrider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hirumi.visualnovelstrider.adapter.SearchListAdapter;
import com.hirumi.visualnovelstrider.repository.VnRepository;
import com.hirumi.visualnovelstrider.viewmodel.SearchViewModel;

import java.util.ArrayList;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {


    @Inject
    public VnRepository vnRepository;
    private RecyclerView recyclerView;
    private SearchListAdapter searchListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton fab;
    private EditText searchVN;
    private Button searchVNClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ((MyApplication) getApplicationContext()).applicationComponent.inject(this);

//        Async.init();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        vnRepository.getSocketClient().connect().subscribe(new SocketSubscriber() {
//            @Override
//            public void onConnected() {
//                Log.d("onConnexted", "");
//            }
//
//            @Override
//            public void onDisconnected() {
//                Log.d("onConnexted", "");
//            }
//
//            @Override
//            public void onResponse(@NotNull byte[] bytes) {
//                Log.d("asw", Arrays.toString(bytes));
//            }
//        }, throwable -> Log.e("As", throwable.toString()));

        searchVN = findViewById(R.id.searchVN);
        searchVNClear = findViewById(R.id.searchVNClear);
        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.rvSearch);

        fab.setOnClickListener(view -> {
            String title = searchVN.getText().toString();
            searchVN.clearFocus();
            vnRepository.getAsw(title).observe(this, new Observer<ArrayList<SearchViewModel>>() {
                @Override
                public void onChanged(ArrayList<SearchViewModel> searchViewModels) {
                    searchListAdapter = new SearchListAdapter(searchViewModels, MainActivity.this);
                    linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(searchListAdapter);
                }
            });
        });

        searchVNClear.setOnClickListener(view -> {
            searchVN.setText("");
            searchVN.requestFocusFromTouch();
        });


//        searchViewModel.getMutableLiveData().observe(this, viewModel -> {
//            searchListAdapter = new SearchListAdapter(viewModel, this);
//            linearLayoutManager = new LinearLayoutManager(MainActivity.this);
//            recyclerView.setLayoutManager(linearLayoutManager);
//            recyclerView.setAdapter(searchListAdapter);
//        });

    }


}