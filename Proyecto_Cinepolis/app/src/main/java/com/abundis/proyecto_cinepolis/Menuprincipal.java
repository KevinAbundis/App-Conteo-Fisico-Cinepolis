package com.abundis.proyecto_cinepolis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menuprincipal extends AppCompatActivity {

    boolean cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
    }

    //Método para poner un cuadro de dialogo en caso de que el usuario quiera salir de la aplicación
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("SALIR");
        builder.setMessage("¿Estás seguro que deseas salir de la aplicación?");

        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cerrar=true;
                salirApp(cerrar);
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cerrar=false;
                salirApp(cerrar);
            }
        });

        builder.create();
        builder.show();

    }


    //Método para cerrar aplicación o seguir dentro de ella dependiendo de respuesta del usuario
    public void salirApp(boolean cerrar){
        if(cerrar==true){
            Toast.makeText(this, "Vuelve pronto", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }else {
            Toast.makeText(this, "Gracias por seguir en la aplicación", Toast.LENGTH_SHORT).show();
        }
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
