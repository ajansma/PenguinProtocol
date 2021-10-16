
package com.example.penguinprotocol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * MainActivity Represents the first page of the app that has all of the Location Names
 * Implements onItemListener interface to detect for clicks on items in the recycler view
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ArrayList<String> locationNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        initCountryNames(AppController.getInstance());
    }

    private void initCountryNames(AppController appController) {
        //This will be populated with the values from the database using loop

//        for (int i = 0; i < appController.getProgramList().size(); ++i) {
//            locationNames.add(appController.getProgramList().get(i).getCountry());
//        }

        locationNames.add("Italy");
        locationNames.add("Spain");
        locationNames.add("Denmark");

        initCountryRecyclerView();
    }

    private void initCountryRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.ProgramsRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, locationNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}