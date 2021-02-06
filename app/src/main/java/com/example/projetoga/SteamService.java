package com.example.projetoga;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SteamService {
    @GET("ISteamUserStats/GetUserStatsForGame/v0002/")
    Call<ResponseSteam> getUserStatsForGame(
            @Query("appid") String appid,
            @Query("key") String key,
            @Query("steamid") String steamid);

    @GET("ISteamUser/GetFriendList/v0001/")
    Call<ResponseSteam2> getFriendList(
            @Query("relationship") String relationship,
            @Query("key") String key,
            @Query("steamid") String steamid);
}