package com.abundis.cinepolis_conteo_fisico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Acercadenosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercadenosotros);

        //Poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}
