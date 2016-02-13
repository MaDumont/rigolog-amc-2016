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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Friendlist extends AppCompatActivity {
<<<<<<< HEAD

    private JSONObject JSONFriends;
    private HashMap<String,String> hMapFriends;
    private ArrayList<Friend> FriendsWithBenefits;

=======
    Context context = getBaseContext();
>>>>>>> 6decc9274fc08562094d074869fd1ba072be07f7
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);

        Firebase.setAndroidContext(this);
        Firebase mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        FriendsWithBenefits = new ArrayList<Friend>();
        mFirebaseRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot messageSnapshot: snapshot.getChildren()) {
                    String name = (String) messageSnapshot.child("fullName").getValue();
                    String status = (String) messageSnapshot.child("status").getValue();
                    FriendsWithBenefits.add(new Friend(null,name,status));

                }

                //hMapFriends = (HashMap<String,String>) snapshot.getValue();
                //System.out.println(hMapFriends);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        //parseJSONToFriends(JSONFriends);
        //parseHmapToFriends(this.hMapFriends);
        int image_id = 1;
        ArrayList<Friend> friends = new ArrayList();
        Friend friend1 = new Friend(null, "Bob", "challenge");
        Friend friend2 = new Friend(null, "Roger", "ongoing");
        friends.add(friend1);
        friends.add(friend2);

        CustomListAdapter adapter = new CustomListAdapter(this, FriendsWithBenefits);
        ListView lv = (ListView) findViewById(R.id.Friendlist_View);
        lv.setAdapter(adapter);
    }
<<<<<<< HEAD
    public JSONObject getJSONFriends(){
        return this.JSONFriends;
    }
    public ArrayList<Friend> parseHmapToFriends(HashMap<String, String> hMapFriends){
        List<String> listtemp =  new ArrayList<String>(hMapFriends.keySet());
        ArrayList<Friend> results = new ArrayList<Friend>();
        for(int i=0;i<listtemp.size(); i++) {
            System.out.println(listtemp.get(i));
        }
        return results;
    }
    public ArrayList<Friend> parseJSONToFriends(JSONObject JSONdata){
        JSONObject obj = JSONdata;
        System.out.println(obj);
        JSONArray arr = null;
        try {
            arr = obj.getJSONArray("user");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr.length(); i++)
        {
            try {
                System.out.println(arr.getJSONObject(i).getString("fullName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
=======

>>>>>>> 6decc9274fc08562094d074869fd1ba072be07f7
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
