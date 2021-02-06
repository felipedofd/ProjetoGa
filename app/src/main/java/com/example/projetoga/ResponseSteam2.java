package com.example.projetoga;

import com.google.gson.annotations.SerializedName;

public class ResponseSteam2 {

    @SerializedName("friendslist")
    private FriendList friendsList;

    public ResponseSteam2 (FriendList friendsList) {
        this.friendsList = friendsList;
    }

    public FriendList getFriendsList() {
        return friendsList;

    }

    public void setFriendsList(FriendList friendsList) {
        this.friendsList = friendsList;
    }
}
