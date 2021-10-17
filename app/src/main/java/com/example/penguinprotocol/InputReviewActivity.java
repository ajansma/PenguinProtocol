package com.example.penguinprotocol;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputReviewActivity extends AppCompatActivity {
    private static final String TAG = "InputReviewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_entry);
        EditText inputName = findViewById(R.id.nameInput);
        EditText inputDate = findViewById(R.id.reviewDateInput);
        RatingBar inputRating = findViewById(R.id.ratingInput);
        RatingBar inputPrice = findViewById(R.id.priceInput);
        EditText inputLocation = findViewById(R.id.locationInput);
        @SuppressLint("WrongViewCast") EditText inputTextBody = findViewById(R.id.reviewTextBody);
        Button submitButton = findViewById(R.id.submitReviewButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: submitButton");
                String nameString = inputName.getText().toString();
                String dateString = inputDate.getText().toString();
                String ratingString = Float.toString(inputRating.getRating());
                String priceString = Float.toString(inputPrice.getRating());
                String textBodyString = inputTextBody.getText().toString();
                String locationString = inputLocation.getText().toString();

                AppController.getInstance().getConnection().addReview(nameString, dateString, "LOCATION", textBodyString, ratingString, priceString);

                setContentView(R.layout.activity_reviews);
            }
        });
    }
}

