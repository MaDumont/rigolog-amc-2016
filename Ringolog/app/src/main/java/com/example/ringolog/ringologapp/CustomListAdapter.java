package com.example.ringolog.ringologapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Chou on 2016-02-13.
 */
public class CustomListAdapter extends ArrayAdapter {
    Context context;
    String friendName;
    ArrayList<Friend> itemsArrayList;
    public CustomListAdapter(Activity context, ArrayList<Friend> itemsArrayList) {
        super(context, R.layout.friendlist_row, itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        friendName = itemsArrayList.get(position).getName();
        String friendStatus = itemsArrayList.get(position).getStatus();
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View friendlist_row = inflater.inflate(R.layout.friendlist_row, parent, false);

        // 3. Get the two text view from the rowView

        TextView name = (TextView) friendlist_row.findViewById(R.id.textName);
        Button ChallengeButton = (Button) friendlist_row.findViewById(R.id.button);
        //ImageView imageView = (ImageView) friendlist_row.findViewById(R.id.icon);

        // 4. Set the text for textView
        name.setText(friendName);
        ChallengeButton.setText(friendStatus);
        String message = "";
        //message += " " + friendStatus;
        final String action = friendStatus;
        ChallengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+ finalMessage,
                //        Toast.LENGTH_LONG).show();
                if(action.equals("challenge")) {
                    openChallenge();
                }
            }
        });
        return friendlist_row;
    }

private void openChallenge(){
    Intent intent = new Intent(context, ChallengeList.class);
    context.startActivity(intent);
}
}

