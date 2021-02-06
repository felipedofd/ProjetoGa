package com.example.projetoga;

import com.google.gson.annotations.SerializedName;

public class Friend {

    @SerializedName("steamid")
    private String steamId;

    public Friend(String newSteamId) {
        steamId = newSteamId;
    }

    public String getSteamId() {
        return steamId;

    }

    public void setSteamId (String steamId)  {this.steamId = steamId; }


}
