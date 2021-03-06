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
            System.out.println("CHECK1");
           String country = programList.get(0).getCountry();
           ArrayList<String> locationList = control.getLocations(country);
            System.out.println("CHECK2");
           System.out.println("CITY" + locationList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        initCountryNames(AppController.getInstance());
    }

    private void initCountryNames(AppController appController) {
        ArrayList<Program> program = appController.getProgramList();

        for (int i = 0; i < program.size(); ++i) {
            programNames.add(program.get(i).getProgramCountry());
        }

//        programNames.add("TEST");

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