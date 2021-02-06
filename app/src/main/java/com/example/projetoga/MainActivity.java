 package com.example.projetoga;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

 public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        EditText pid = findViewById(R.id.ppid);
        EditText id = findViewById(R.id.id);
        TextView deaths = findViewById(R.id.total_deaths);
        TextView kills = findViewById(R.id.total_kills);
        TextView wins = findViewById(R.id.total_wins);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.steampowered.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SteamService service = retrofit.create(SteamService.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getFriendList("friend", "AE2DC846D2E477E97A841CED5E0ED908", "76561198060505954").enqueue(new Callback<ResponseSteam2>() {
                    @Override
                    public void onResponse(Call<ResponseSteam2> call, Response<ResponseSteam2> response) {
                        kills.setText("Id igual a: " + response.body().getFriendsList().getFriends().get(0).getSteamId());
//                        kills.setText("Quantidade de jogadores abatidos: " + response.body().playerStats.stats.get(0).getValue());
//                        deaths.setText("Quantidades de Mortes: " + response.body().playerStats.stats.get(1).getValue());
//                        wins.setText("Quantidade de Vitorias: " + response.body().playerStats.stats.get(5).getValue());
                    }

                    @Override
                    public void onFailure(Call<ResponseSteam2> call, Throwable t) {
                        deaths.setText("Erro");
                        kills.setText("Erro");
                        wins.setText("Erro");
                    }
                });
            }
        });

    }
}


