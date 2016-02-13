package com.example.ringolog.ringologapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Challenge> challenges = new ArrayList<Challenge>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ringolog");



        Firebase mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        mFirebaseRef.child("pendingChallenges").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());
                for (DataSnapshot messageSnapshot : snapshot.getChildren()) {
                    String challengeTitle = (String) messageSnapshot.child("Title").getValue();
                    String objective = (String) messageSnapshot.child("Objective").getValue();
                    String time = (String) messageSnapshot.child("Time").getValue();
                    int id = Integer.parseInt(messageSnapshot.child("id").getValue().toString());
                    challenges.add(new Challenge(challengeTitle, objective, time, id));

                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


        PersonalChallengeListAdapter adapter = new PersonalChallengeListAdapter(this, challenges);
        ListView lv = (ListView) findViewById(R.id.myChallengeListView);
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_home:
                //Toast.makeText(getApplicationContext(), "home selected",
                  //      Toast.LENGTH_LONG).show();
                //openHomeTab();
                break;

            case R.id.item_friends:
                //Toast.makeText(getApplicationContext(), "friends selected",
                  //      Toast.LENGTH_LONG).show();
                openFriendsTab();
                break;
            case R.id.item_profil:
                //Toast.makeText(getApplicationContext(), "profil selected",
                    //    Toast.LENGTH_LONG).show();
                openProfilTab();
                break;
            case R.id.item_settings:
                //Toast.makeText(getApplicationContext(), "settings selected",
                  //      Toast.LENGTH_LONG).show();
                openSettingsTab();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openHomeTab(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    public void openFriendsTab(){
        Intent intent = new Intent(this, Friendlist.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    public void openProfilTab(){
        Intent intent = new Intent(this, Profil.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    public void openSettingsTab(){
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
