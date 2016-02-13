package com.example.ringolog.ringologapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ChallengeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);

        ArrayList<Challenge> challenges = new ArrayList<>();
        Challenge challenge1 = new Challenge("Buy a lunch", "Help someone");
        Challenge challenge2 = new Challenge("Give money", "Help someone");
        challenges.add(challenge1);
        challenges.add(challenge2);

        ChallengeListAdapter adapter = new ChallengeListAdapter(this, challenges);
        ListView lv = (ListView) findViewById(R.id.Challengelist_View);
        lv.setAdapter(adapter);

    }
}
