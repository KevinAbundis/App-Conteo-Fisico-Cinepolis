package com.abundis.proyecto_cinepolis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    //Método para mandar a llamar el activity del menu de dulceria
    public void Irdulceria (View view){
        Intent irdulceria = new Intent(this, Menu_Dulceria.class);
        startActivity(irdulceria);
    }

    //Método para mandar a llamar el activity del menu de taquilla
    public void Irtaquilla (View view){
        Intent irtaquilla = new Intent(this, Menu_Taquilla.class);
        startActivity(irtaquilla);
    }

    //Método para mandar a llamar el activity de presentaciones
    public void Irpresentaciones (View view){
        Intent irpresentaciones = new Intent(this, Presentaciones.class);
        startActivity(irpresentaciones);
    }


    //Método para mandar a llamar el activity de acerca de nosotros
    public void IrAcercadenosotros (View view){
        Intent iracercadenosotros = new Intent(this, Acercadenosotros.class);
        startActivity(iracercadenosotros);
    }
}
