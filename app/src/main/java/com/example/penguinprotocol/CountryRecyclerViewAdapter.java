package com.example.penguinprotocol;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

/**
 *
 */
class CountryRecyclerViewAdapter extends RecyclerViewAdapter {
    public CountryRecyclerViewAdapter(Context mContext, ArrayList<String> itemNames) {
        super(mContext, itemNames);
    }
}
