package com.example.penguinprotocol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * MainActivity Represents the first page of the app that has all of the Location Names
 * Implements onItemListener interface to detect for clicks on items in the recycler view
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ArrayList<String> programNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        try {
           AppController control = new AppController();
            ArrayList<Program> programList = control.getProgramList();
            String country = programList.get(0).getCountry();
            ArrayList<Location> reviewList = control.getLocations(country);
            System.out.println(reviewList.get(0).getCity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        initCountryNames(AppController.getInstance());
    }

    private void initCountryNames(AppController appController) {
        //This will be populated with the values from appController
        //for (int i = 0; i < appController.getProgramList().size(); ++i) {
       //     locationNames.add(appController.getProgramList().get(i).getCountry());
       //}


        programNames.add("Italy");
        programNames.add("Spain");
        programNames.add("Denmark");

        initCountryRecyclerView();
    }

    private void initCountryRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.ProgramsRecyclerView);
        ProgramRecyclerViewAdapter adapter = new ProgramRecyclerViewAdapter(this, programNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}