package com.hirumi.visualnovelstrider;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hirumi.visualnovelstrider.adapter.SearchListAdapter;
import com.hirumi.visualnovelstrider.repository.VnRepository;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {


    @Inject
    public VnRepository vnRepository;
    private RecyclerView recyclerView;
    private SearchListAdapter searchListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton fab;
    private EditText searchVN;

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
        Button searchVNClear = findViewById(R.id.searchVNClear);
        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.rvSearch);

        fab.setOnClickListener(view -> {
            //get query
            String title = searchVN.getText().toString();

            //clear focus & hide keyboard
            searchVN.clearFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(searchVN.getApplicationWindowToken(), 0);
            //end

            //get data & set data
            vnRepository.getAsw(title).observe(this, searchViewModels -> {
                searchListAdapter = new SearchListAdapter(searchViewModels, MainActivity.this);
                linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(searchListAdapter);
            });
        });

        searchVNClear.setOnClickListener(view -> {
            //clear text & gain focus
            searchVN.setText("");
            searchVN.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(searchVN, InputMethodManager.SHOW_IMPLICIT);
        });


//        searchViewModel.getMutableLiveData().observe(this, viewModel -> {
//            searchListAdapter = new SearchListAdapter(viewModel, this);
//            linearLayoutManager = new LinearLayoutManager(MainActivity.this);
//            recyclerView.setLayoutManager(linearLayoutManager);
//            recyclerView.setAdapter(searchListAdapter);
//        });

    }


}