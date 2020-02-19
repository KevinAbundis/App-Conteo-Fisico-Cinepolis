package com.abundis.cinepolis_conteo_fisico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Método para mandar a llamar el activity menú principal
    public void Irmenuprincipal (View view){
        Intent irmenuprincipal = new Intent(this, Menuprincipal.class);
        startActivity(irmenuprincipal);
    }

    //Método para mandar a llamar el activity de recuperar contrasenia
    public void Irrecuperarcontrasenia (View view){
        Intent irrecuperarcontrasenia = new Intent(this, RecuperarContrasenia.class);
        startActivity(irrecuperarcontrasenia);
    }


}
