package com.example.penguinprotocol;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LocationsActivity extends AppCompatActivity {
    private static final String TAG = "LocationsActivity";
    private ArrayList<String> locationNames = new ArrayList<>();
    private String calledProgramName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        Log.d(TAG, "onCreate: called");
        calledProgramName = getIntent().getExtras().getString("programCountry");

        initLocationNames(AppController.getInstance());
    }

    private void initLocationNames(AppController appController) {
        //Uncomment when appController has data
        //This needs to only take the selected program locations
        //Base this around the calledProgramName
//        for (int i = 0; i < appController.getLocationList().size(); ++i) {
//            locationsNamesList.add(appController.getLocationList().get(i).getName());
//        }

        locationNames.add("CAFE");
        locationNames.add("NIGHT CLUB");
        locationNames.add("BAR");

        initLocationRecyclerView();
    }

    private void initLocationRecyclerView() {
        Log.d(TAG, "initLocationRecyclerView: initLocationRecyclerView");
        RecyclerView recyclerView = findViewById(R.id.LocationRecyclerView);
        LocationRecyclerViewAdapter adapter = new LocationRecyclerViewAdapter(this, locationNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
