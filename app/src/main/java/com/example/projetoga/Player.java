package com.example.projetoga;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("personaname")
    private String personaName;

    @SerializedName("avatarfull")
    private String avatarFull;

    public Player(String personaName) {
        this.personaName = personaName;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }

    public String getAvatar() {
        return avatarFull;
    }

    public void setAvatar(String avatar) {
        this.avatarFull = avatar;
    }

    public void setPersonaName(String personaName, String avatar) {
        this.personaName = personaName;
        this.avatarFull = avatar;
    }

}

