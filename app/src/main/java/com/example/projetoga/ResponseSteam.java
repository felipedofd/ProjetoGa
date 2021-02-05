package com.example.projetoga;

import com.google.gson.annotations.SerializedName;

public class ResponseSteam {

    @SerializedName("playerstats")
    public PlayerStats playerStats;

    public ResponseSteam(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }
}
