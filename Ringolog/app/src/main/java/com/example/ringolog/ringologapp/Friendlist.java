package com.example.ringolog.ringologapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class Friendlist extends AppCompatActivity {
    Context context = getBaseContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);

        Firebase.setAndroidContext(this);
        Firebase mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));

        mFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Object JSONdata = snapshot.getValue();
                System.out.println(JSONdata);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        int image_id = 1;
        ArrayList<Friend> friends = new ArrayList();
        Friend friend1 = new Friend(null, "Bob", "challenge");
        Friend friend2 = new Friend(null, "Roger", "ongoing");
        friends.add(friend1);
        friends.add(friend2);

        CustomListAdapter adapter = new CustomListAdapter(this, friends);
        ListView lv = (ListView) findViewById(R.id.Friendlist_View);
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
                Toast.makeText(getApplicationContext(), "home selected",
                        Toast.LENGTH_LONG).show();
                openHomeTab();
                break;

            case R.id.item_friends:
                Toast.makeText(getApplicationContext(), "friends selected",
                        Toast.LENGTH_LONG).show();
                openFriendsTab();
                break;
            case R.id.item_profil:
                Toast.makeText(getApplicationContext(), "profil selected",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.item_settings:
                Toast.makeText(getApplicationContext(), "settings selected",
                        Toast.LENGTH_LONG).show();
                openSettingsTab();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openHomeTab(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openFriendsTab(){
        Intent intent = new Intent(this, Friendlist.class);
        startActivity(intent);
    }
    public void openProfilTab(){
        Intent intent = new Intent(this, Friendlist.class);
        startActivity(intent);
    }
    public void openSettingsTab(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
