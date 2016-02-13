package com.example.ringolog.ringologapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ringolog");

        ArrayList<Challenge> challenges = new ArrayList<>();
        Challenge challenge1 = new Challenge("Buy a lunch", "Help someone");
        Challenge challenge2 = new Challenge("Donate money", "Help someone");
        Challenge challenge3 = new Challenge("Save the world", "Help someone");
        Challenge challenge4 = new Challenge("Bring peace", "Help someone");
        challenges.add(challenge1);
        challenges.add(challenge2);
        challenges.add(challenge3);
        challenges.add(challenge4);

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
