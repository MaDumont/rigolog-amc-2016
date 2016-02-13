package com.example.ringolog.ringologapp;

import android.media.Image;

/**
 * Created by Chou on 2016-02-13.
 */
public class Friend {
    private Image profilPicture;
    private String name;
    private String status;

    public Friend() {
    this.name = "Default Name";
    }

    public Friend(Image picture, String name, String status) {
        this.name = name;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
