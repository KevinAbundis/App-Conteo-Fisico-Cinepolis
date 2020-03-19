package com.abundis.cinepolis_conteo_fisico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_Almacen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_almacen);
    }

    //Método para mandar a llamar el activity de almacén 1
    public void Iralmacen1 (View view){
        Intent iralmacen1 = new Intent(this, almacen1.class);
        startActivity(iralmacen1);
    }
}
