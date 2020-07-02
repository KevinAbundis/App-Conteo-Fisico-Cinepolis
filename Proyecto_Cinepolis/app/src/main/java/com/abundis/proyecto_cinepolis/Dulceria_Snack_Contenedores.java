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

public class Dulceria_Snack_Contenedores extends AppCompatActivity implements View.OnClickListener{

    //Variables
    private EditText Textcontenedor5onz1_dul, Textcontenedor5onz2_dul, Textcontenedor5onz3_dul, Textcontenedor5onz4_dul, Textcontenedor5onzfisico_dul;
    private EditText Textcontenedor8onz1_dul, Textcontenedor8onz2_dul, Textcontenedor8onz3_dul, Textcontenedor8onz4_dul, Textcontenedor8onzfisico_dul;
    private EditText Textcontenedor12onz1_dul, Textcontenedor12onz2_dul, Textcontenedor12onz3_dul, Textcontenedor12onz4_dul, Textcontenedor12onzfisico_dul;
    private EditText Textpapasnaturales;
    private EditText Textpapasadobadas;
    private EditText Textvasopalomero;
    private EditText Textpapasnegras;

    private Button BotonGenerarvalores;
    private Button BotonMostrarvalores;

    //Variable para mostrar un dialogo de progreso
    private ProgressDialog progressDialog;

    //Declaramos objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    //Declaramos el objeto databaseReference para poder utilizar la base de datos en tiempo real de Firebase
    private DatabaseReference databaseReference;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dulceria_snack_contenedores);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //Hacemos referencias de los textos de entrada
        Textcontenedor5onz1_dul = (EditText) findViewById(R.id.contenedor5onz1_dul);
        Textcontenedor5onz2_dul = (EditText) findViewById(R.id.contenedor5onz2_dul);
        Textcontenedor5onz3_dul = (EditText) findViewById(R.id.contenedor5onz3_dul);
        Textcontenedor5onz4_dul = (EditText) findViewById(R.id.contenedor5onz4_dul);
        Textcontenedor5onzfisico_dul = (EditText) findViewById(R.id.contenedor5onzfisico_dul);

        Textcontenedor8onz1_dul = (EditText) findViewById(R.id.contenedor8onz1_dul);
        Textcontenedor8onz2_dul = (EditText) findViewById(R.id.contenedor8onz2_dul);
        Textcontenedor8onz3_dul = (EditText) findViewById(R.id.contenedor8onz3_dul);
        Textcontenedor8onz4_dul = (EditText) findViewById(R.id.contenedor8onz4_dul);
        Textcontenedor8onzfisico_dul = (EditText) findViewById(R.id.contenedor8onzfisico_dul);

        Textcontenedor12onz1_dul = (EditText) findViewById(R.id.contenedor12onz1_dul);
        Textcontenedor12onz2_dul = (EditText) findViewById(R.id.contenedor12onz2_dul);
        Textcontenedor12onz3_dul = (EditText) findViewById(R.id.contenedor12onz3_dul);
        Textcontenedor12onz4_dul = (EditText) findViewById(R.id.contenedor12onz4_dul);
        Textcontenedor12onzfisico_dul = (EditText) findViewById(R.id.contenedor12onzfisico_dul);

        Textpapasnaturales = (EditText) findViewById(R.id.papasnaturales_dul);

        Textpapasadobadas = (EditText) findViewById(R.id.papasadobadas_dul);

        Textvasopalomero =(EditText) findViewById(R.id.vasopalomero_dul);

        Textpapasnegras = (EditText) findViewById(R.id.papassalsanegra_dul);

        //Hacemos referencia al dialogo de progreso
        progressDialog = new ProgressDialog(this);

        //Hacemos referencia al botón
        BotonGenerarvalores = (Button) findViewById(R.id.generarvaloressnack_dul);
        BotonMostrarvalores = (Button) findViewById(R.id.mostrarvaloressnack_dul);

        //Listener de los botones
        BotonGenerarvalores.setOnClickListener(this);
        BotonMostrarvalores.setOnClickListener(this);


        //Guardar las preferencias automáticamente en caso de cerrar la aplicación por accidente
        Textcontenedor5onz1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor5onz1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor5onz2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor5onz2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor5onz3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor5onz3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor5onz4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor5onz4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor8onz1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor8onz1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor8onz2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor8onz2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor8onz3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor8onz3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor8onz4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor8onz4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor12onz1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor12onz1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor12onz2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor12onz2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor12onz3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor12onz3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcontenedor12onz4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcontenedor12onz4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpapasnaturales.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpapasnaturales.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpapasadobadas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpapasadobadas.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textvasopalomero.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textvasopalomero.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpapasnegras.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpapasnegras.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescontenedor5onz(){
        //Obtenemos datos
        final String modulo1 = Textcontenedor5onz1_dul.getText().toString().trim();
        final String modulo2 = Textcontenedor5onz2_dul.getText().toString().trim();
        final String modulo3 = Textcontenedor5onz3_dul.getText().toString().trim();
        final String modulo4 = Textcontenedor5onz4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 5 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 5 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 5 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 5 onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcontenedor5onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-GRANEL",11717, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescontenedor8onz(){
        //Obtenemos datos
        final String modulo1 = Textcontenedor8onz1_dul.getText().toString().trim();
        final String modulo2 = Textcontenedor8onz2_dul.getText().toString().trim();
        final String modulo3 = Textcontenedor8onz3_dul.getText().toString().trim();
        final String modulo4 = Textcontenedor8onz4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 8 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 8 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 8 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 8 onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcontenedor8onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-GRANEL",11718, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescontenedor12onz(){
        //Obtenemos datos
        final String modulo1 = Textcontenedor12onz1_dul.getText().toString().trim();
        final String modulo2 = Textcontenedor12onz2_dul.getText().toString().trim();
        final String modulo3 = Textcontenedor12onz3_dul.getText().toString().trim();
        final String modulo4 = Textcontenedor12onz4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 12 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 12 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 12 onzas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Contenedor 12 onzas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcontenedor12onzfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-GRANEL",11719, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespapasnaturales(){
        //Obtenemos datos
        final String modulo1 = Textpapasnaturales.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Papas Naturales", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1);


        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-SNACK",1740, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespapasadobadas(){
        //Obtenemos datos
        final String modulo1 = Textpapasadobadas.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Papas Adobadas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1);


        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-SNACK",1741, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvasopalomero(){
        //Obtenemos datos
        final String modulo1 = Textvasopalomero.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Palomero", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1);


        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",452, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespapasnegras(){
        //Obtenemos datos
        final String modulo1 = Textpapasnegras.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Papas Salsa Negra", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1);


        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-SNACK",15412, existenciafisica);

        //Mensaje de pantalla
        Toast.makeText(this, "Datos Generados y Guardados Correctamente", Toast.LENGTH_LONG).show();
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


    private void guardarPreferencias(){
        //Creamos un archivo xml para guardar los datos de nuestra preferencia en caso de que se nos cierre
        //accidentalmente la aplicación y queramos recuperar esos datos al abrir nuevamente la aplicación
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos de las cajas de texto
        String c5modulo1 = Textcontenedor5onz1_dul.getText().toString();
        String c5cmodulo2 = Textcontenedor5onz2_dul.getText().toString();
        String c5cmodulo3 = Textcontenedor5onz3_dul.getText().toString();
        String c5cmodulo4 = Textcontenedor5onz4_dul.getText().toString();

        String c8modulo1 = Textcontenedor8onz1_dul.getText().toString();
        String c8modulo2 = Textcontenedor8onz2_dul.getText().toString();
        String c8modulo3 = Textcontenedor8onz3_dul.getText().toString();
        String c8modulo4 = Textcontenedor8onz4_dul.getText().toString();

        String c12modulo1 = Textcontenedor12onz1_dul.getText().toString();
        String c12modulo2 = Textcontenedor12onz2_dul.getText().toString();
        String c12modulo3 = Textcontenedor12onz3_dul.getText().toString();
        String c12modulo4 = Textcontenedor12onz3_dul.getText().toString();

        String pnmodulo1 = Textpapasnaturales.getText().toString();

        String pamodulo2 = Textpapasadobadas.getText().toString();

        String vpmodulo3 = Textvasopalomero.getText().toString();

        String pnmodulo4 = Textpapasnegras.getText().toString();


        //Creamos un objeto para poder escribir en el archivo xml que creamos los datos que hemos obtenido
        SharedPreferences.Editor editor = preferences.edit();

        //Aqui estamos escribiendo los datos en el archivo xml
        editor.putString("Contenedor 5 onzas modulo 1",c5modulo1);
        editor.putString("Contenedor 5 onzas modulo 2",c5cmodulo2);
        editor.putString("Contenedor 5 onzas modulo 3",c5cmodulo3);
        editor.putString("Contenedor 5 onzas modulo 4",c5cmodulo4);

        editor.putString("Contenedor 8 onzas modulo 1",c8modulo1);
        editor.putString("Contenedor 8 onzas modulo 2",c8modulo2);
        editor.putString("Contenedor 8 onzas modulo 3",c8modulo3);
        editor.putString("Contenedor 8 onzas modulo 4",c8modulo4);

        editor.putString("Contenedor 12 onzas modulo 1",c12modulo1);
        editor.putString("Contenedor 12 onzas modulo 2",c12modulo2);
        editor.putString("Contenedor 12 onzas modulo 3",c12modulo3);
        editor.putString("Contenedor 12 onzas modulo 4",c12modulo4);

        editor.putString("Papas naturales",pnmodulo1);

        editor.putString("Papas adobadas",pamodulo2);

        editor.putString("Vaso palomero",vpmodulo3);

        editor.putString("Papas salsa negra",pnmodulo4);


        editor.commit();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void cargarPreferencias(){

        //Abrimos el archivo xml que hemos creado anteriormente
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos del archivo xml
        String c5modulo1 = preferences.getString("Contenedor 5 onzas modulo 1","No existe la información");
        String c5modulo2 = preferences.getString("Contenedor 5 onzas modulo 2","No existe la información");
        String c5modulo3 = preferences.getString("Contenedor 5 onzas modulo 3","No existe la información");
        String c5modulo4 = preferences.getString("Contenedor 5 onzas modulo 4","No existe la información");

        String pmmodulo1 = preferences.getString("Contenedor 8 onzas modulo 1","No existe la información");
        String pmmodulo2 = preferences.getString("Contenedor 8 onzas modulo 2","No existe la información");
        String pmmodulo3 = preferences.getString("Contenedor 8 onzas modulo 3","No existe la información");
        String pmmodulo4 = preferences.getString("Contenedor 8 onzas modulo 4","No existe la información");

        String pgmodulo1 = preferences.getString("Contenedor 12 onzas modulo 1","No existe la información");
        String pgmodulo2 = preferences.getString("Contenedor 12 onzas modulo 2","No existe la información");
        String pgmodulo3 = preferences.getString("Contenedor 12 onzas modulo 3","No existe la información");
        String pgmodulo4 = preferences.getString("Contenedor 12 onzas modulo 4","No existe la información");

        String pjmodulo1 = preferences.getString("Papas naturales","No existe la información");

        String pjmodulo2 = preferences.getString("Papas adobadas","No existe la información");

        String pjmodulo3 = preferences.getString("Vaso palomero","No existe la información");

        String pjmodulo4 = preferences.getString("Papas salsa negra","No existe la información");


        //Mandamos a las cajas de texto los datos obtenidos del archivo xml
        Textcontenedor5onz1_dul.setText(c5modulo1);
        Textcontenedor5onz2_dul.setText(c5modulo2);
        Textcontenedor5onz3_dul.setText(c5modulo3);
        Textcontenedor5onz4_dul.setText(c5modulo4);

        Textcontenedor8onz1_dul.setText(pmmodulo1);
        Textcontenedor8onz2_dul.setText(pmmodulo2);
        Textcontenedor8onz3_dul.setText(pmmodulo3);
        Textcontenedor8onz4_dul.setText(pmmodulo4);

        Textcontenedor12onz1_dul.setText(pgmodulo1);
        Textcontenedor12onz2_dul.setText(pgmodulo2);
        Textcontenedor12onz3_dul.setText(pgmodulo3);
        Textcontenedor12onz4_dul.setText(pgmodulo4);

        Textpapasnaturales.setText(pjmodulo1);

        Textpapasadobadas.setText(pjmodulo2);

        Textvasopalomero.setText(pjmodulo3);

        Textpapasnegras.setText(pjmodulo4);


    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.generarvaloressnack_dul:
                //Mandar mensaje en pantalla que se están realizando las operaciones
                progressDialog.setMessage("Realizando operaciones, espere un momento...");
                progressDialog.show();

                //Invocamos los métodos
                operacionescontenedor5onz();
                operacionescontenedor8onz();
                operacionescontenedor12onz();
                operacionespapasnaturales();
                operacionespapasadobadas();
                operacionesvasopalomero();
                operacionespapasnegras();

                //Guardamos preferencias
                guardarPreferencias();

                //Dejamos de mostrar en pantalla el cuadro de dialogo de progreso
                progressDialog.dismiss();

                break;

            case R.id.mostrarvaloressnack_dul:

                //Invocamos al método
                cargarPreferencias();

                break;
        }

    }

}
