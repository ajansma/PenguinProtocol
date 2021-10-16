package com.example.penguinprotocol;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class LocationsActivity extends AppCompatActivity {
    private static final String TAG = "LocationsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        Log.d(TAG, "onCreate: called");
    }
}
