package com.example.penguinprotocol;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    private static final String TAG = "ReviewsActivity";
    private ArrayList<String> reviewName = new ArrayList<>();
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

                setContentView(R.layout.activity_review_entry);
            }
        });

        initReviewNames(AppController.getInstance());
    }

    private void initReviewNames(AppController appController) {
        Log.d(TAG, "initReviewNames: initReviewNames");

        ArrayList<Review> temp = AppController.getInstance().getReviews(calledLocationName);

        for (int i = 0; i < temp.size(); ++i) {
            reviewName.add(temp.get(i).getEntryDate());
        }

//        //FUNCTION CALL TO FILL THE ARRAY HERE
        reviewName.add("01-01-2000, BAR");
        reviewName.add("01-01-2000, BAR");
        reviewName.add("01-01-2000, BAR");

        initReviewRecyclerView();
    }

    private void initReviewRecyclerView() {
        Log.d(TAG, "initReviewRecyclerView(): called");
        RecyclerView recyclerView = findViewById(R.id.ReviewRecyclerView);
        ReviewsRecyclerViewAdapter adapter = new ReviewsRecyclerViewAdapter(reviewName, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
