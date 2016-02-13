package com.example.ringolog.ringologapp;

import android.media.Image;

/**
 * Created by Chou on 2016-02-13.
 */
public class Friend {
    Image profilPicture;
    String name;

    public Friend() {
    this.name = "Default Name";
    }

    public Friend(Image picture, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getProfilPicture() {
        return profilPicture;
    }

    public void setProfilPicture(Image profilPicture) {
        this.profilPicture = profilPicture;
    }
}
