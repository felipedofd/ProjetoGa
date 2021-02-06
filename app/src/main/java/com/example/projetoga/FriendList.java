package com.example.projetoga;

import java.util.List;

public class FriendList {

    private List<Friend> friends;

    public FriendList(List<Friend> friendList) {
        friends = friendList;
    }

    public List<Friend> getFriends() {
        return friends;

    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

}
