package com.example.ringolog.ringologapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chou on 2016-02-13.
 */
public class PersonalChallengeListAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Challenge> itemsArrayList;
    public PersonalChallengeListAdapter(Activity context, ArrayList<Challenge> itemsArrayList) {
        super(context, R.layout.personal_challenge_row,itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View personal_challenge_row = inflater.inflate(R.layout.personal_challenge_row, parent, false);

        // 3. Get the two text view from the rowView
        TextView challengeBox = (TextView) personal_challenge_row.findViewById(R.id.textName);
        //ImageView imageView = (ImageView) friendlist_row.findViewById(R.id.icon);
        Button ChallengeButton = (Button) personal_challenge_row.findViewById(R.id.button);
        // 4. Set the text for textView
        challengeBox.setText(itemsArrayList.get(position).getChallengeTitle());
        //String title = itemsArrayList.get(position).toString();
        //labelView.setText(title);

        ChallengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+ finalMessage,
                //        Toast.LENGTH_LONG).show();
                open();
            }
        });

        return personal_challenge_row;
    }

    private void open(){
        Intent intent = new Intent(context, ChallengeDetail.class);
        context.startActivity(intent);
    }
}
