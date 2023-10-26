package com.example.drinkhub.classes;

import android.widget.ImageView;

import java.io.Serializable;

public class Utente implements Serializable {
    private String username;
    private String password;
    private ImageView avatar;
    private Boolean logged;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ImageView getImage() {
        return avatar;
    }
    public void setImage(ImageView image) {
        this.avatar = image;
    }
    public ImageView getAvatar() { return avatar; }
    public void setAvatar(ImageView avatar) { this.avatar = avatar; }
    public Boolean isLogged() { return logged; }
    public void setLogged(Boolean logged) { this.logged = logged; }

    public Utente(String username, String password, ImageView avatar, Boolean logged) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.logged = logged;
    }
}
