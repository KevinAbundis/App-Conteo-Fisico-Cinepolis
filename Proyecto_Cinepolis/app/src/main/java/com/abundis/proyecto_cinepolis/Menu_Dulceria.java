package com.abundis.proyecto_cinepolis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_Dulceria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dulceria);
    }

    //Método para mandar a llamar el activity del menu de dulceria de productos estrella
    public void Irdulceriaproductosestrella (View view){
        Intent irdulceriaproductosestrella = new Intent(this, Dulceria_Productos_Estrella.class);
        startActivity(irdulceriaproductosestrella);
    }

    //Método para mandar a llamar el activity del menu de dulceria de snack y contenedores
    public void Irdulceriasnackcontenedores (View view){
        Intent irdulceriasnackcontenedores = new Intent(this, Dulceria_Snack_Contenedores.class);
        startActivity(irdulceriasnackcontenedores);
    }


}
