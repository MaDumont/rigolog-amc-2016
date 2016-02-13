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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int image_id = 1;
        ArrayList<String> textList = new ArrayList();
        textList.add("test");
        textList.add("test2");
        CustomListAdapter adapter = new CustomListAdapter(this, textList);
        ListView lv = (ListView) findViewById(R.id.Friendlist_View);
        lv.setAdapter(adapter);
    }

}
