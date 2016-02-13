package com.example.ringolog.ringologapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Friendlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);



        int image_id = 1;
        ArrayList<Friend> friends = new ArrayList();
        Friend friend1 = new Friend(null, "Bob");
        Friend friend2 = new Friend(null, "Roger");
        friends.add(friend1);
        friends.add(friend2);

        CustomListAdapter adapter = new CustomListAdapter(this, friends);
        ListView lv = (ListView) findViewById(R.id.Friendlist_View);
        lv.setAdapter(adapter);
    }

}
