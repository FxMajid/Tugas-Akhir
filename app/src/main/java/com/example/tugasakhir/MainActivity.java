package com.example.tugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView petugas, responden, lihatSurvei, inputSurvei, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definisi Cadrview
        petugas     = (CardView) findViewById(R.id.Petugas);
        responden   = (CardView) findViewById(R.id.Responden);
        lihatSurvei = (CardView) findViewById(R.id.lihat);
        inputSurvei = (CardView) findViewById(R.id.input);
        about       = (CardView) findViewById(R.id.about);
        logout      = (CardView) findViewById(R.id.logout);

        //Supaya bisa diklik
        petugas.setOnClickListener(this);
        responden.setOnClickListener(this);
        lihatSurvei.setOnClickListener(this);
        inputSurvei.setOnClickListener(this);
        about.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
                case R.id.Petugas : i = new Intent(this, PetugasActivity.class);
                startActivity(i);
                break;
                case R.id.Responden : i = new Intent(this, RespondenActivity.class);
                startActivity(i);
                break;
                case R.id.lihat : i = new Intent(this, LihatSurvei.class);
                startActivity(i);
                break;
                case R.id.input : i = new Intent(this, InputSurvey.class);
                startActivity(i);
                break;
                case R.id.about : i = new Intent(this, About.class);
                startActivity(i);
                break;
                case R.id.logout : i = new Intent(this, Login.class);
                startActivity(i);
                break;
                default:break;

         }

    }
}

