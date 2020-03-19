package com.abundis.cinepolis_conteo_fisico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menuprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
    }

    //Método para mandar a llamar el activity del menu de almacén
    public void Iralmacen (View view){
        Intent iralmacen = new Intent(this, Menu_Almacen.class);
        startActivity(iralmacen);
    }

    //Método para mandar a llamar el activity de dulceria
    public void Irdulceria (View view){
        Intent irdulceria = new Intent(this, Menu_Dulceria.class);
        startActivity(irdulceria);
    }

    //Método para mandar a llamar el activity de taquilla
    public void Irtaquilla (View view){
        Intent irtaquilla = new Intent(this, Taquilla.class);
        startActivity(irtaquilla);
    }

    //Método para mandar a llamar el activity de presentaciones
    public void Irpresentaciones (View view){
        Intent irpresentaciones = new Intent(this, Presentaciones.class);
        startActivity(irpresentaciones);
    }


    //Método para mandar a llamar el activity de acerca de nosotros
    public void Acercadenosotros (View view){
        Intent acercadenosotros = new Intent(this, Acercadenosotros.class);
        startActivity(acercadenosotros);
    }
}
