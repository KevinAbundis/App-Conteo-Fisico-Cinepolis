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

public class Dulceria_Envases_Cine_Cafe extends AppCompatActivity implements View.OnClickListener{

    //Variables
    private EditText Textvaso12onzmanga_dul, Textvaso12onzpz_dul, Textvaso12onzfisico_dul;
    private EditText Textvaso16onzmanga_dul, Textvaso16onzpz_dul, Textvaso16onzfisico_dul;
    private EditText Textvaso20onzmanga_dul, Textvaso20onzpz_dul, Textvaso20onzfisico_dul;
    private EditText Textvasotrophy12onzmanga_dul, Textvasotrophy12onzpz_dul, Textvasotrophy12onzfisico_dul;
    private EditText Textvasotrophy16onzmanga_dul, Textvasotrophy16onzpz_dul, Textvasotrophy16onzfisico_dul;
    private EditText Textvasotrophy20onzmanga_dul, Textvasotrophy20onzpz_dul, Textvasotrophy20onzfisico_dul;
    private EditText Textvaso4onz;

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
        setContentView(R.layout.activity_dulceria_envases_cine_cafe);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //Hacemos referencias de los textos de entrada
        Textvaso12onzmanga_dul = (EditText) findViewById(R.id.vaso12onzmanga_dul);
        Textvaso12onzpz_dul = (EditText) findViewById(R.id.vaso12onzpz_dul);
        Textvaso12onzfisico_dul = (EditText) findViewById(R.id.vaso12onzfisico_dul);

        Textvaso16onzmanga_dul = (EditText) findViewById(R.id.vaso16onzmanga_dul);
        Textvaso16onzpz_dul = (EditText) findViewById(R.id.vaso16onzpz_dul);
        Textvaso16onzfisico_dul = (EditText) findViewById(R.id.vaso16onzfisico_dul);

        Textvaso20onzmanga_dul = (EditText) findViewById(R.id.vaso20onzmanga_dul);
        Textvaso20onzpz_dul = (EditText) findViewById(R.id.vaso20onzpz_dul);
        Textvaso20onzfisico_dul = (EditText) findViewById(R.id.vaso20onzfisico_dul);

        Textvasotrophy12onzmanga_dul = (EditText) findViewById(R.id.vasotrophy12onzmanga_dul);
        Textvasotrophy12onzpz_dul = (EditText) findViewById(R.id.vasotrophy12onzpz_dul);
        Textvasotrophy12onzfisico_dul = (EditText) findViewById(R.id.vasotrophy12onzfisico_dul);

        Textvasotrophy16onzmanga_dul = (EditText) findViewById(R.id.vasotrophy16onzmanga_dul);
        Textvasotrophy16onzpz_dul = (EditText) findViewById(R.id.vasotrophy16onzpz_dul);
        Textvasotrophy16onzfisico_dul = (EditText) findViewById(R.id.vasotrophy16onzfisico_dul);

        Textvasotrophy20onzmanga_dul = (EditText) findViewById(R.id.vasotrophy20onzmanga_dul);
        Textvasotrophy20onzpz_dul = (EditText) findViewById(R.id.vasotrophy20onzpz_dul);
        Textvasotrophy20onzfisico_dul = (EditText) findViewById(R.id.vasotrophy20onzfisico_dul);

        Textvaso4onz = (EditText) findViewById(R.id.vaso4onzpiezas_dul);

        //Hacemos referencia al dialogo de progreso
        progressDialog = new ProgressDialog(this);

        //Hacemos referencia al botón
        BotonGenerarvalores = (Button) findViewById(R.id.generarvaloresenvases_dul);
        BotonMostrarvalores = (Button) findViewById(R.id.mostrarvaloresenvases_dul);

        //Listener de los botones
        BotonGenerarvalores.setOnClickListener(this);
        BotonMostrarvalores.setOnClickListener(this);

        //Guardar las preferencias automáticamente en caso de cerrar la aplicación por accidente
        Textvaso12onzmanga_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus &&  Textvaso12onzmanga_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvaso12onzpz_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvaso12onzpz_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvaso16onzmanga_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus &&  Textvaso16onzmanga_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvaso16onzpz_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvaso16onzpz_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvaso20onzmanga_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus &&  Textvaso20onzmanga_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvaso20onzpz_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvaso20onzpz_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvasotrophy12onzmanga_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus &&  Textvasotrophy12onzmanga_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvasotrophy12onzpz_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvasotrophy12onzpz_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvasotrophy16onzmanga_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus &&  Textvasotrophy16onzmanga_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvasotrophy16onzpz_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvasotrophy16onzpz_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvasotrophy20onzmanga_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus &&  Textvasotrophy20onzmanga_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvasotrophy20onzpz_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvasotrophy20onzpz_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvaso4onz.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvaso4onz.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });


    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvaso12onzpet(){
        //Obtenemos datos
        final String modulo1 = Textvaso12onzmanga_dul.getText().toString().trim();
        final String modulo2 = Textvaso12onzpz_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Pet 12 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Pet 12 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*25)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textvaso12onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("CAFE-ENVASES",522, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvaso16onzpet(){
        //Obtenemos datos
        final String modulo1 = Textvaso16onzmanga_dul.getText().toString().trim();
        final String modulo2 = Textvaso16onzpz_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Pet 16 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Pet 16 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*25)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textvaso16onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("CAFE-ENVASES",524, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvaso20onzpet(){
        //Obtenemos datos
        final String modulo1 = Textvaso20onzmanga_dul.getText().toString().trim();
        final String modulo2 = Textvaso20onzpz_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Pet 20 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Pet 20 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*25)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textvaso20onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("CAFE-ENVASES",526, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvaso12onztrophy(){
        //Obtenemos datos
        final String modulo1 = Textvasotrophy12onzmanga_dul.getText().toString().trim();
        final String modulo2 = Textvasotrophy12onzpz_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Trophy 12 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Trophy 12 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*25)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textvasotrophy12onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("CAFE-ENVASES",529, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvaso16onztrophy(){
        //Obtenemos datos
        final String modulo1 = Textvasotrophy16onzmanga_dul.getText().toString().trim();
        final String modulo2 = Textvasotrophy16onzpz_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Trophy 16 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Trophy 16 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*25)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textvasotrophy16onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("CAFE-ENVASES",530, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvaso20onztrophy(){
        //Obtenemos datos
        final String modulo1 = Textvasotrophy20onzmanga_dul.getText().toString().trim();
        final String modulo2 = Textvasotrophy20onzpz_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Trophy 20 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Trophy 20 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*25)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textvasotrophy20onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("CAFE-ENVASES",532, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvaso4onz(){
        //Obtenemos datos
        final String modulo1 = Textvaso4onz.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso 4 Onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1);

        //Mandamos a llamar la función actualizar datos
        actualizardatos("CAFE-ENVASES",528, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private void guardarPreferencias() {
        //Creamos un archivo xml para guardar los datos de nuestra preferencia en caso de que se nos cierre
        //accidentalmente la aplicación y queramos recuperar esos datos al abrir nuevamente la aplicación
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos de las cajas de texto
        String amodulo1 = Textvaso12onzmanga_dul.getText().toString();
        String amodulo2 = Textvaso12onzpz_dul.getText().toString();

        String bmodulo1 = Textvaso16onzmanga_dul.getText().toString();
        String bmodulo2 = Textvaso16onzpz_dul.getText().toString();

        String cmodulo1 = Textvaso20onzmanga_dul.getText().toString();
        String cmodulo2 = Textvaso20onzpz_dul.getText().toString();

        String dmodulo1 = Textvasotrophy12onzmanga_dul.getText().toString();
        String dmodulo2 = Textvasotrophy12onzpz_dul.getText().toString();

        String emodulo1 = Textvasotrophy16onzmanga_dul.getText().toString();
        String emodulo2 = Textvasotrophy16onzpz_dul.getText().toString();

        String fmodulo1 = Textvasotrophy20onzmanga_dul.getText().toString();
        String fmodulo2 = Textvasotrophy20onzpz_dul.getText().toString();

        String gmodulo1 = Textvaso4onz.getText().toString();


        //Creamos un objeto para poder escribir en el archivo xml que creamos los datos que hemos obtenido
        SharedPreferences.Editor editor = preferences.edit();

        //Aqui estamos escribiendo los datos en el archivo xml
        editor.putString("Pet 12 manga",amodulo1);
        editor.putString("Pet 12 pieza",amodulo2);

        editor.putString("Pet 16 manga",bmodulo1);
        editor.putString("Pet 16 pieza",bmodulo2);

        editor.putString("Pet 20 manga",cmodulo1);
        editor.putString("Pet 20 pieza",cmodulo2);

        editor.putString("Trophy 12 manga",dmodulo1);
        editor.putString("Trophy 12 pieza",dmodulo2);

        editor.putString("Trophy 16 manga",emodulo1);
        editor.putString("Trophy 16 pieza",emodulo2);

        editor.putString("Trophy 20 manga",fmodulo1);
        editor.putString("Trophy 20 pieza",fmodulo2);

        editor.putString("4 onz",gmodulo1);


        editor.commit();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void cargarPreferencias() {

        //Abrimos el archivo xml que hemos creado anteriormente
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos del archivo xml
        String amodulo1 = preferences.getString("Pet 12 manga", "No existe la información");
        String amodulo2 = preferences.getString("Pet 12 pieza", "No existe la información");

        String bmodulo1 = preferences.getString("Pet 16 manga", "No existe la información");
        String bmodulo2 = preferences.getString("Pet 16 pieza", "No existe la información");

        String cmodulo1 = preferences.getString("Pet 20 manga", "No existe la información");
        String cmodulo2 = preferences.getString("Pet 20 pieza", "No existe la información");

        String dmodulo1 = preferences.getString("Trophy 12 manga", "No existe la información");
        String dmodulo2 = preferences.getString("Trophy 12 pieza", "No existe la información");

        String emodulo1 = preferences.getString("Trophy 16 manga", "No existe la información");
        String emodulo2 = preferences.getString("Trophy 16 pieza", "No existe la información");

        String fmodulo1 = preferences.getString("Trophy 20 manga", "No existe la información");
        String fmodulo2 = preferences.getString("Trophy 20 pieza", "No existe la información");

        String gmodulo1 = preferences.getString("4 onz", "No existe la información");


        //Mandamos a las cajas de texto los datos obtenidos del archivo xml
        Textvaso12onzmanga_dul.setText(amodulo1);
        Textvaso12onzpz_dul.setText(amodulo2);

        Textvaso16onzmanga_dul.setText(bmodulo1);
        Textvaso16onzpz_dul.setText(bmodulo2);

        Textvaso20onzmanga_dul.setText(cmodulo1);
        Textvaso20onzpz_dul.setText(cmodulo2);

        Textvasotrophy12onzmanga_dul.setText(dmodulo1);
        Textvasotrophy12onzpz_dul.setText(dmodulo2);

        Textvasotrophy16onzmanga_dul.setText(emodulo1);
        Textvasotrophy16onzpz_dul.setText(emodulo2);

        Textvasotrophy20onzmanga_dul.setText(fmodulo1);
        Textvasotrophy20onzpz_dul.setText(fmodulo2);

        Textvaso4onz.setText(gmodulo1);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.generarvaloresenvases_dul:
                //Mandar mensaje en pantalla que se están realizando las operaciones
                progressDialog.setMessage("Realizando operaciones, espere un momento...");
                progressDialog.show();

                //Invocamos los métodos
                operacionesvaso12onzpet();
                operacionesvaso16onzpet();
                operacionesvaso20onzpet();
                operacionesvaso12onztrophy();
                operacionesvaso16onztrophy();
                operacionesvaso20onztrophy();
                operacionesvaso4onz();

                //Guardamos preferencias
                guardarPreferencias();

                //Dejamos de mostrar en pantalla el cuadro de dialogo de progreso
                progressDialog.dismiss();

                break;

            case R.id.mostrarvaloresenvases_dul:

                //Invocamos al método
                cargarPreferencias();

                break;
        }

    }
}
