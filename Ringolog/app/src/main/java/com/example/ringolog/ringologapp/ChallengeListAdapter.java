package com.example.ringolog.ringologapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by Chou on 2016-02-13.
 */
public class ChallengeListAdapter extends ArrayAdapter {

    Context context;
    ArrayList<Challenge> itemsArrayList;
    public ChallengeListAdapter(Activity context, ArrayList<Challenge> itemsArrayList) {
        super(context, R.layout.challengelist_row, itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View challengelist_row = inflater.inflate(R.layout.challengelist_row, parent, false);
        CheckBox challengeBox = (CheckBox) challengelist_row.findViewById(R.id.checkBox);

        View challengelistSelect_row = inflater.inflate(R.layout.activity_challenge_list, parent, false);

        // 3. Get the two text view from the rowView

        Button sendButton = (Button) challengelistSelect_row.findViewById(R.id.sendButton);
        Button cancelButton = (Button) challengelistSelect_row.findViewById(R.id.cancelButton);
        // 4. Set the text for textView
        challengeBox.setText(itemsArrayList.get(position).getChallengeTitle());
        //String title = itemsArrayList.get(position).toString();
        //labelView.setText(title);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });


        return challengelist_row;
    }

}
