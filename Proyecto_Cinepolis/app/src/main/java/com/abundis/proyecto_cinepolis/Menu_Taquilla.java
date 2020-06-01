package com.abundis.proyecto_cinepolis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu_Taquilla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_taquilla);

    }

    //Método para mandar a llamar el activity de taquilla
    public void Irtaquilla (View view){
        Intent irtaquilla = new Intent(this, Taquilla.class);
        startActivity(irtaquilla);
    }

    //Método para mandar a llamar el activity de dulceria
    public void  generarReporteTaquilla(){
        Toast.makeText(Menu_Taquilla.this, "Generar Reporte de Taquilla", Toast.LENGTH_SHORT).show();
    }
}
