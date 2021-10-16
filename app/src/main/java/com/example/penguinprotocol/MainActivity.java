
package com.example.penguinprotocol;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemListener {

    private static final String TAG = "MainActivity";

    private ArrayList<String> countryNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        initCountryNames();
    }

    private void initCountryNames() {
        //This will be populated with the values from the database using loop
        countryNames.add("Italy");
        countryNames.add("Spain");
        countryNames.add("Denmark");

        initCountryRecyclerView();
    }

    private void initCountryRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.ProgramsRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, countryNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {

    }
}