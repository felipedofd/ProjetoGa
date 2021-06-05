 package com.example.projetoga;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

 public class MainActivity extends Activity {

     private String apiKey = "AE2DC846D2E477E97A841CED5E0ED908";

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
        ImageView avatar = findViewById(R.id.user_image);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.steampowered.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SteamService servico = retrofit.create(SteamService.class);

        // Clique no botao
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getStats(servico, pid.getText().toString(),id.getText().toString(),kills, deaths, wins);
                getUserInfo(servico, id.getText().toString(), avatar);

            }
        });


    }




    void getUserInfo(SteamService service, String id, ImageView avatar2){
        ArrayList<String> listaId = new ArrayList<>();
        listaId.add(id);
        service.getPlayerSummaries(apiKey, listaId).enqueue(new Callback<ResponseSteam3>() {
            @Override
            public void onResponse(Call<ResponseSteam3> call, Response<ResponseSteam3> response) {
                if(response.isSuccessful()){
                    String avatarUrl = response.body().getResponse().getPlayerList().get(0).getAvatar();

                    ImageLoader imageLoader = Coil.imageLoader(getApplicationContext());
                    ImageRequest request = new ImageRequest.Builder(getApplicationContext())
                            .data(avatarUrl)
                            .crossfade(true)
                            .target(avatar2)
                            .build();
                    imageLoader.enqueue(request);
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<ResponseSteam3> call, Throwable t) {

            }
        });

    }

    void getStats(SteamService service, String pid, String id, TextView kills, TextView deaths, TextView wins ){
        // Serviço passado pid, key, id
        service.getUserStatsForGame(pid, apiKey, id )
                .enqueue(new Callback<ResponseSteam>() {
                    @Override
                    public void onResponse(Call<ResponseSteam> call, Response<ResponseSteam> response) {
                        // Resposta
                        if (response.isSuccessful()) {
                            kills.setText("Você matou: "+ response.body().getPlayerStats().getStats().get(0).value);
                            deaths.setText("Você morreu: "+ response.body().getPlayerStats().getStats().get(1).value);
                            wins.setText("Você ganhou: "+ response.body().getPlayerStats().getStats().get(5).value);

                        } else {
                            deaths.setText("Erro");
                            kills.setText("Erro");
                            wins.setText("Erro");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseSteam> call, Throwable t) {
                        // Erro
                        deaths.setText("Erro");
                        kills.setText("Erro");
                        wins.setText("Erro");
                    }
                });
    }
}

