package com.example.penguinprotocol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 *
 */
class CountryRecyclerViewAdapter extends RecyclerViewAdapter {
    private static final String TAG = "CountryViewAdapter";

    public CountryRecyclerViewAdapter(Context mContext, ArrayList<String> itemNames) {
        super(mContext, itemNames);

    }

//    @Override
//    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
//        Log.d(TAG, "onBindViewHolder: called"); //Displays logs for each created item
//
//        holder.itemText.setText(itemNames.get(position));
//
//        //This is an inefficient way to do this but its a hackathon
//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onBindViewHolder: clicked on: " + itemNames.get(position));
//
//                Toast.makeText(mContext, itemNames.get(position), Toast.LENGTH_LONG).show();
//
//                Intent intent = new Intent(mContext, LocationsActivity.class);
//                mContext.startActivity(intent);
//
//            }
//        });
//    }
}
