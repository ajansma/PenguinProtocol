package com.example.penguinprotocol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ReviewsRecyclerViewAdapter extends RecyclerView.Adapter<ReviewsRecyclerViewAdapter.ReviewsViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> reviewNames = new ArrayList<>();
    private Context mContext;

    public ReviewsRecyclerViewAdapter(ArrayList<String> reviewNames, Context mContext) {
        this.reviewNames = reviewNames;
        this.mContext = mContext;
    }

    @Override
    public ReviewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewsViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "onBindViewHolder: called"); //Displays logs for each created item

        holder.reviewText.setText(reviewNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onBindViewHolder: clicked on: " + reviewNames.get(position));

                Toast.makeText(mContext, reviewNames.get(position), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(mContext, ReadReviewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("reviewName", reviewNames.get(position));
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() { return reviewNames.size(); }

    public class ReviewsViewHolder extends RecyclerView.ViewHolder {
        TextView reviewText;
        ConstraintLayout parentLayout;

        public ReviewsViewHolder(@NonNull View itemView) {
            super(itemView);
            reviewText = itemView.findViewById(R.id.item_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
