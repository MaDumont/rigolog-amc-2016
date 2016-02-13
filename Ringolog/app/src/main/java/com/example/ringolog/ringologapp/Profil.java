package com.example.ringolog.ringologapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

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
                openHomeTab();
                break;

            case R.id.item_friends:
                openFriendsTab();
                break;
            case R.id.item_profil:
                break;
            case R.id.item_settings:
                openSettingsTab();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openHomeTab(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void openFriendsTab(){
        Intent intent = new Intent(this, Friendlist.class);
        startActivity(intent);
        finish();
    }
    public void openProfilTab(){
        Intent intent = new Intent(this, Friendlist.class);
        startActivity(intent);
        finish();
    }
    public void openSettingsTab(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause(){
        finish();
        super.onPause();
    }
}
