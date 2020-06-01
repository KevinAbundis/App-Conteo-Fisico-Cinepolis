package com.abundis.proyecto_cinepolis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Dulceria_Productos_Estrella extends AppCompatActivity implements View.OnClickListener{

    //Variables
    private EditText TextPalomitasgrandes1_dul, TextPalomitasgrandes2_dul, TextPalomitasgrandes3_dul,TextPalomitasgrandes4_dul, TextPalomitasgrandesfisico_dul;
    private EditText TextPalomitasjumbo1_dul, TextPalomitasjumbo2_dul, TextPalomitasjumbo3_dul,TextPalomitasjumbo4_dul, TextPalomitasjumbofisico_dul;
    private Button BotonGenerarvalores;
    private Button BotonMostrarvalores;

    //Variable para mostrar un dialogo de progreso
    private ProgressDialog progressDialog;

    //Declaramos objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    //Declaramos el objeto databaseReference para poder utilizar la base de datos en tiempo real de Firebase
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dulceria_productos_estrella);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();


        //Hacemos referencias de los textos de entrada
        TextPalomitasgrandes1_dul = (EditText) findViewById(R.id.palomitasgrandes1_dul);
        TextPalomitasgrandes2_dul = (EditText) findViewById(R.id.palomitasgrandes2_dul);
        TextPalomitasgrandes3_dul = (EditText) findViewById(R.id.palomitasgrandes3_dul);
        TextPalomitasgrandes4_dul = (EditText) findViewById(R.id.palomitasgrandes4_dul);
        TextPalomitasgrandesfisico_dul = (EditText) findViewById(R.id.palomitasgrandesfisico_dul);

        TextPalomitasjumbo1_dul = (EditText) findViewById(R.id.palomitasjumbo1_dul);
        TextPalomitasjumbo2_dul = (EditText) findViewById(R.id.palomitasjumbo2_dul);
        TextPalomitasjumbo3_dul = (EditText) findViewById(R.id.palomitasjumbo3_dul);
        TextPalomitasjumbo4_dul = (EditText) findViewById(R.id.palomitasjumbo4_dul);
        TextPalomitasjumbofisico_dul = (EditText) findViewById(R.id.palomitasjumbofisico_dul);

        //Hacemos referencia al dialogo de progreso
        progressDialog = new ProgressDialog(this);

        //Hacemos referencia al botón
        BotonGenerarvalores = (Button) findViewById(R.id.generarvalores_dul_pal);
        BotonMostrarvalores = (Button) findViewById(R.id.mostrarvalores_dul_pal);

        //listener de los botones
        BotonGenerarvalores.setOnClickListener(this);
        BotonMostrarvalores.setOnClickListener(this);

    }

    private void operacionespalomitasgrandes(){
        //Obtenemos datos
        final String modulo1 = TextPalomitasgrandes1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitasgrandes2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitasgrandes3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitasgrandes4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomita Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomita Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomita Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomita Grande", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitasgrandesfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",293, existenciafisica);
    }


    private void operacionespalomitasjumbo(){
        //Obtenemos datos
        final String modulo1 = TextPalomitasjumbo1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitasjumbo2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitasjumbo3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitasjumbo4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitasjumbofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",14174, existenciafisica);
    }


    private void actualizardatos(String categoria, int id_producto, float existenciafisica){
        //Recibimos el id que tiene el usuario actual
        String id = firebaseAuth.getCurrentUser().getUid();

        //Creamos el mapa de los valores que vamos a actualizar
        Map<String, Object> map = new HashMap<>();
        map.put("Id-Usuario", id);
        map.put("Existencia-Fisica",existenciafisica);

        //Actualizamos los datos con esta función
        databaseReference.child("Productos").child("Dulceria").child(categoria).child(""+id_producto).updateChildren(map);
    }


    private void guardarPreferencias(){
        //Creamos un archivo xml para guardar los datos de nuestra preferencia en caso de que se nos cierre
        //accidentalmente la aplicación y queramos recuperar esos datos al abrir nuevamente la aplicación
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos de las cajas de texto
        String pgmodulo1 = TextPalomitasgrandes1_dul.getText().toString();
        String pgmodulo2 = TextPalomitasgrandes2_dul.getText().toString();
        String pgmodulo3 = TextPalomitasgrandes3_dul.getText().toString();
        String pgmodulo4 = TextPalomitasgrandes4_dul.getText().toString();

        String pjmodulo1 = TextPalomitasjumbo1_dul.getText().toString();
        String pjmodulo2 = TextPalomitasjumbo2_dul.getText().toString();
        String pjmodulo3 = TextPalomitasjumbo3_dul.getText().toString();
        String pjmodulo4 = TextPalomitasjumbo4_dul.getText().toString();

        //Creamos un objeto para poder escribir en el archivo xml que creamos los datos que hemos obtenido
        SharedPreferences.Editor editor = preferences.edit();

        //Aqui estamos escribiendo los datos en el archivo xml
        editor.putString("Palomitas grandes modulo 1",pgmodulo1);
        editor.putString("Palomitas grandes modulo 2",pgmodulo2);
        editor.putString("Palomitas grandes modulo 3",pgmodulo3);
        editor.putString("Palomitas grandes modulo 4",pgmodulo4);

        editor.putString("Palomitas jumbo modulo 1",pjmodulo1);
        editor.putString("Palomitas jumbo modulo 2",pjmodulo2);
        editor.putString("Palomitas jumbo modulo 3",pjmodulo3);
        editor.putString("Palomitas jumbo modulo 4",pjmodulo4);

        //Toast.makeText(Dulceria_Productos_Estrella.this, "Datos: "+modulo1+","+modulo2+","+modulo3+","+modulo4, Toast.LENGTH_SHORT).show();

        editor.commit();
    }

    private void cargarPreferencias(){

        //Abrimos el archivo xml que hemos creado anteriormente
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos del archivo xml
        String pgmodulo1 = preferences.getString("Palomitas grandes modulo 1","No existe la información");
        String pgmodulo2 = preferences.getString("Palomitas grandes modulo 2","No existe la información");
        String pgmodulo3 = preferences.getString("Palomitas grandes modulo 3","No existe la información");
        String pgmodulo4 = preferences.getString("Palomitas grandes modulo 4","No existe la información");

        String pjmodulo1 = preferences.getString("Palomitas jumbo modulo 1","No existe la información");
        String pjmodulo2 = preferences.getString("Palomitas jumbo modulo 2","No existe la información");
        String pjmodulo3 = preferences.getString("Palomitas jumbo modulo 3","No existe la información");
        String pjmodulo4 = preferences.getString("Palomitas jumbo modulo 4","No existe la información");

        //Mandamos a las cajas de texto los datos obtenidos del archivo xml
        TextPalomitasgrandes1_dul.setText(pgmodulo1);
        TextPalomitasgrandes2_dul.setText(pgmodulo2);
        TextPalomitasgrandes3_dul.setText(pgmodulo3);
        TextPalomitasgrandes4_dul.setText(pgmodulo4);

        TextPalomitasjumbo1_dul.setText(pjmodulo1);
        TextPalomitasjumbo2_dul.setText(pjmodulo2);
        TextPalomitasjumbo3_dul.setText(pjmodulo3);
        TextPalomitasjumbo4_dul.setText(pjmodulo4);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.generarvalores_dul_pal:
                //Mandar mensaje en pantalla que se están realizando las operaciones
                progressDialog.setMessage("Realizando operaciones, espere un momento...");
                progressDialog.show();

                //Invocamos los métodos
                operacionespalomitasgrandes();
                operacionespalomitasjumbo();

                guardarPreferencias();

                //Dejamos de mostrar en pantalla el cuadro de dialogo de progreso
                progressDialog.dismiss();

                break;

            case R.id.mostrarvalores_dul_pal:

                //Invocamos al método
                cargarPreferencias();

                break;
        }

    }
}
