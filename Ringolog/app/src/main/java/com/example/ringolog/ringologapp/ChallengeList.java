package com.example.ringolog.ringologapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class ChallengeList extends AppCompatActivity {
    private ArrayList<Challenge> ChallengesWithBenefits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_list);
        Firebase.setAndroidContext(this);
        Firebase mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        ChallengesWithBenefits = new ArrayList<Challenge>();
        mFirebaseRef.child("challenges").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());
                for (DataSnapshot messageSnapshot : snapshot.getChildren()) {
                    String challengeTitle = (String) messageSnapshot.child("Title").getValue();
                    String objective = (String) messageSnapshot.child("Objective").getValue();
                    String time = (String) messageSnapshot.child("Time").getValue();
                    int id = Integer.parseInt(messageSnapshot.child("id").getValue().toString());
                    ChallengesWithBenefits.add(new Challenge(challengeTitle, objective, time, id));

                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        ArrayList<Challenge> challenges = new ArrayList<>();
        Challenge challenge1 = new Challenge("Buy a lunch", "Help someone");
        Challenge challenge2 = new Challenge("Give money", "Help someone");
        challenges.add(challenge1);
        challenges.add(challenge2);

        ChallengeListAdapter adapter = new ChallengeListAdapter(this, ChallengesWithBenefits);
        ListView lv = (ListView) findViewById(R.id.Challengelist_View);
        lv.setAdapter(adapter);

    }


}
