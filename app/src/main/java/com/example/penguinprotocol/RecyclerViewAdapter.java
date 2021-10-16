package com.example.penguinprotocol;

import android.annotation.SuppressLint;
import android.content.Context;
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
 * Parent Class to all of the recycler views
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> itemNames = new ArrayList<>();
    private Context mContext;
    private OnItemListener onItemListener;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> itemNames, OnItemListener onItemListener) {
        this.itemNames = itemNames;
        this.mContext = mContext;
        this.onItemListener = onItemListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view, onItemListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "onBindViewHolder: called"); //Displays logs for each created item

        holder.itemText.setText(itemNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onBindViewHolder: clicked on: " + itemNames.get(position));

                Toast.makeText(mContext, itemNames.get(position), Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemText;
        OnItemListener onItemListener;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView, OnItemListener onItemListenerParam) {
            super(itemView);
            itemText = itemView.findViewById(R.id.location_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.onItemListener = onItemListenerParam;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener {
        void onItemClick(int position);
    }

}