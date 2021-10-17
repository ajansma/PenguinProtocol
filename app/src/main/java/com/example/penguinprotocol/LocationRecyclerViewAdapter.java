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

/**
 *
 */
class LocationRecyclerViewAdapter extends RecyclerView.Adapter<LocationRecyclerViewAdapter.LocationViewHolder> {
    private static final String TAG = "CountryViewAdapter";

    private ArrayList<String> locationNames = new ArrayList<>();
    private Context mContext;

    public LocationRecyclerViewAdapter(Context mContext, ArrayList<String> locationNames) {
        this.locationNames = locationNames;
        this.mContext = mContext;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new LocationViewHolder(view); //Passes onItemListener to the ViewHolderConstructor
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "onBindViewHolder: called"); //Displays logs for each created item

        holder.locationText.setText(locationNames.get(position));

        //This is an inefficient way to do this but its a hackathon
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onBindViewHolder: clicked on: " + locationNames.get(position));

                Toast.makeText(mContext, locationNames.get(position), Toast.LENGTH_LONG).show();

                //CHANGE THIS TO GO TO THE REVIEW RECYCLER VIEW ADAPTER
//                Intent intent = new Intent(mContext, LocationsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("locationName", locationNames.get(position));
//                intent.putExtras(bundle);
//                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return locationNames.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {
        TextView locationText;
        ConstraintLayout parentLayout;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            locationText = itemView.findViewById(R.id.item_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

