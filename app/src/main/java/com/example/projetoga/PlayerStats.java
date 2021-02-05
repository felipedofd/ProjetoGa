package com.example.projetoga;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerStats {

    @SerializedName("steamID")
    public String steamId;
    @SerializedName("gameName")
    public String gameName;
    @SerializedName("stats")
    public List<Stats> stats;

    public PlayerStats(String steamId, String gameName, List<Stats> stats) {
        this.steamId = steamId;
        this.gameName = gameName;
        this.stats = stats;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }
}
