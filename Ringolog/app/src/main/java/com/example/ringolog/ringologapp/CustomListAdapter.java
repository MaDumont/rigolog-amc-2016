package com.example.ringolog.ringologapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chou on 2016-02-13.
 */
public class CustomListAdapter extends ArrayAdapter {
    Context context;

    public CustomListAdapter(Activity context, ArrayList<String> itemsArrayList) {
        super(context, R.layout.friendlist_row, itemsArrayList);
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View friendlist_row = inflater.inflate(R.layout.friendlist_row, parent, false);

        // 3. Get the two text view from the rowView
        TextView name = (TextView) friendlist_row.findViewById(R.id.textName);
        //ImageView imageView = (ImageView) friendlist_row.findViewById(R.id.icon);

        // 4. Set the text for textView
        name.setText("test");
        //String title = itemsArrayList.get(position).toString();
        //labelView.setText(title);
        return friendlist_row;
    }
}

