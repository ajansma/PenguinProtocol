package com.example.penguinprotocol;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    private static final String TAG = "ReviewsActivity";
    private ArrayList<String> datesAndLocations = new ArrayList<>();
    private String calledLocationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        Log.d(TAG, "onCreate: called");
        calledLocationName = getIntent().getExtras().getString("locationName");
        TextView reviewScreenTitle = findViewById(R.id.selectedLocation);
        reviewScreenTitle.setText(calledLocationName);
        Button newReviewButton = findViewById(R.id.newReviewButton);
        
        newReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: newReviewButtonClicked");
            }
        });

        initReviewNames(AppController.getInstance());
    }

    private void initReviewNames(AppController appController) {
        Log.d(TAG, "initReviewNames: initReviewNames");

        //FUNCTION CALL TO FILL THE ARRAY HERE
        datesAndLocations.add("01-01-2000, BAR");
        datesAndLocations.add("01-01-2000, BAR");
        datesAndLocations.add("01-01-2000, BAR");

        initReviewRecyclerView();
    }

    private void initReviewRecyclerView() {
        Log.d(TAG, "initReviewRecyclerView(): called");
        RecyclerView recyclerView = findViewById(R.id.ReviewRecyclerView);
        ReviewsRecyclerViewAdapter adapter = new ReviewsRecyclerViewAdapter(datesAndLocations, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
