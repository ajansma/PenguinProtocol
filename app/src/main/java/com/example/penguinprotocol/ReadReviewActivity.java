package com.example.penguinprotocol;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReadReviewActivity extends AppCompatActivity {
    private static final String TAG = "ReviewInputActivity";
    private String reviewTitle;
    private String reviewRating;
    private String reviewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_read);
        reviewTitle = getIntent().getExtras().getString("reviewName");

        TextView reviewTitleText = findViewById(R.id.readReviewTitle);
        TextView reviewRatingText = findViewById(R.id.reviewRating);
        TextView reviewTextBody = findViewById(R.id.reviewTextBody);

        reviewTitleText.setText(reviewTitle);
        //NEED TO ADD SPACE TO ADD RATING AND TEXT BASED ON THE REVIEW LOCATION AND DATE
    }
}
