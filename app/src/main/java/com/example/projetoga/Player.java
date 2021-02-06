package com.example.projetoga;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("personaname")
    private String personaName;

    public Player(String personaName) {
        this.personaName = personaName;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;}

}

