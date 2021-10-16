package com.example.penguinprotocol;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class LocationsActivity extends AppCompatActivity {
    private static final String TAG = "LocationsActivity";
    private Location currLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        Log.d(TAG, "onCreate: called");

        currLocation = new Location("test", "test", "test", "test");

        TextView locationTitle = findViewById(R.id.selectedProgram);
        locationTitle.setText(currLocation.name);
    }
}
