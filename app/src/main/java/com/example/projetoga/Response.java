package com.example.projetoga;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("players")
    private List<Player> playerList;

    public Response(List<Player> playerList) {this.playerList = playerList; }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList; }
}
