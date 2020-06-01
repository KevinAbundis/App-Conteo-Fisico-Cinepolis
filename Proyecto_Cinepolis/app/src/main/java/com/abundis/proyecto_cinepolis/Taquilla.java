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

public class Taquilla extends AppCompatActivity implements View.OnClickListener {

    //Variables
    private EditText TextcajasTCCTaquilla, TextpiezasTCCTaquilla, TextresultadoTCCTaquilla;
    private EditText TextcajasTCCFTaquilla, TextpiezasTCCFTaquilla, TextresultadoTCCFTaquilla;
    private EditText TextcajasTCCSFTaquilla, TextpiezasTCCSFTaquilla, TextresultadoTCCSFTaquilla;
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
        setContentView(R.layout.activity_taquilla);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();


        //Hacemos referencias de los textos de entrada
        TextcajasTCCTaquilla = (EditText) findViewById(R.id.cajasTCCTaquilla);
        TextpiezasTCCTaquilla = (EditText) findViewById(R.id.piezasTCCTaquilla);
        TextresultadoTCCTaquilla = (EditText) findViewById(R.id.resultadoTCCTaquilla);

        TextcajasTCCFTaquilla = (EditText) findViewById(R.id.cajasTCCFTaquilla);
        TextpiezasTCCFTaquilla = (EditText) findViewById(R.id.piezasTCCFTaquilla);
        TextresultadoTCCFTaquilla = (EditText) findViewById(R.id.resultadoTCCFTaquilla);

        TextcajasTCCSFTaquilla = (EditText) findViewById(R.id.cajasTCCSFTaquilla);
        TextpiezasTCCSFTaquilla = (EditText) findViewById(R.id.piezasTCCSFTaquilla);
        TextresultadoTCCSFTaquilla = (EditText) findViewById(R.id.resultadoTCCSFTaquilla);

        //Hacemos referencia al dialogo de progreso
        progressDialog = new ProgressDialog(this);

        //Hacemos referencia al botón
        BotonGenerarvalores = (Button) findViewById(R.id.generarvalores_taquilla);
        BotonMostrarvalores = (Button) findViewById(R.id.mostrarvalores_taquilla);

        //listener de los botones
        BotonGenerarvalores.setOnClickListener(this);
        BotonMostrarvalores.setOnClickListener(this);

    }

    private void operacionestarjetaclubcinepolisfan(){
        //Obtenemos datos
        final String cajas = TextcajasTCCTaquilla.getText().toString().trim();
        final String piezas = TextpiezasTCCTaquilla.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(cajas)){
            Toast.makeText(this, "Hay campos vacios en producto: Tarjeta Club Cinépolis Fan", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(piezas)){
            Toast.makeText(this, "Hay campos vacios en producto: Tarjeta Club Cinépolis Fan", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(cajas)*100)+
                                  Float.parseFloat(piezas);

        //Mandamos el resultado de la operación a una caja de texto
        TextresultadoTCCTaquilla.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-LEALTAD",691, existenciafisica);
    }

    private void operacionestarjetaclubcinepolisfanatico(){
        //Obtenemos datos
        final String cajas = TextcajasTCCFTaquilla.getText().toString().trim();
        final String piezas = TextpiezasTCCFTaquilla.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(cajas)){
            Toast.makeText(this, "Hay campos vacios en producto: Tarjeta Club Cinépolis Fanático", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(piezas)){
            Toast.makeText(this, "Hay campos vacios en producto: Tarjeta Club Cinépolis Fanático", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(cajas)*100)+
                Float.parseFloat(piezas);

        //Mandamos el resultado de la operación a una caja de texto
        TextresultadoTCCFTaquilla.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-LEALTAD",2879, existenciafisica);
    }

    private void operacionestarjetaclubcinepolissuperfanatico(){
        //Obtenemos datos
        final String cajas = TextcajasTCCSFTaquilla.getText().toString().trim();
        final String piezas = TextpiezasTCCSFTaquilla.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(cajas)){
            Toast.makeText(this, "Hay campos vacios en producto: Tarjeta Club Cinépolis Super Fanático", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(piezas)){
            Toast.makeText(this, "Hay campos vacios en producto: Tarjeta Club Cinépolis Super Fanático", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(cajas)*100)+
                Float.parseFloat(piezas);

        //Mandamos el resultado de la operación a una caja de texto
        TextresultadoTCCSFTaquilla.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-LEALTAD",3802, existenciafisica);
    }


    private void actualizardatos(String categoria, int id_producto, float existenciafisica){
        //Recibimos el id que tiene el usuario actual
        String id = firebaseAuth.getCurrentUser().getUid();

        //Creamos el mapa de los valores que vamos a actualizar
        Map<String, Object> map = new HashMap<>();
        map.put("Id-Usuario", id);
        map.put("Existencia-Fisica",existenciafisica);

        //Actualizamos los datos con esta función
        databaseReference.child("Productos").child("Taquilla").child(categoria).child(""+id_producto).updateChildren(map);
    }

    private void guardarPreferencias(){
        //Creamos un archivo xml para guardar los datos de nuestra preferencia en caso de que se nos cierre
        //accidentalmente la aplicación y queramos recuperar esos datos al abrir nuevamente la aplicación
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos de las cajas de texto
        String tcccajas = TextcajasTCCTaquilla.getText().toString();
        String tccpiezas = TextpiezasTCCTaquilla.getText().toString();

        String tccfcajas = TextcajasTCCFTaquilla.getText().toString();
        String tccfpiezas = TextpiezasTCCFTaquilla.getText().toString();

        String tccsfcajas = TextcajasTCCSFTaquilla.getText().toString();
        String tccsfpiezas = TextpiezasTCCSFTaquilla.getText().toString();

        //Creamos un objeto para poder escribir en el archivo xml que creamos los datos que hemos obtenido
        SharedPreferences.Editor editor = preferences.edit();

        //Aqui estamos escribiendo los datos en el archivo xml
        editor.putString("Tarjeta Club Cinépolis Cajas",tcccajas);
        editor.putString("Tarjeta Club Cinépolis Piezas",tccpiezas);

        editor.putString("Tarjeta Club Cinépolis Fánatico Cajas",tccfcajas);
        editor.putString("Tarjeta Club Cinépolis Fánatico Piezas",tccfpiezas);

        editor.putString("Tarjeta Club Cinépolis Super Fánatico Cajas",tccsfcajas);
        editor.putString("Tarjeta Club Cinépolis Super Fánatico Piezas",tccsfpiezas);

        //Toast.makeText(Dulceria_Productos_Estrella.this, "Datos: "+modulo1+","+modulo2+","+modulo3+","+modulo4, Toast.LENGTH_SHORT).show();

        editor.commit();
    }

    private void cargarPreferencias(){

        //Abrimos el archivo xml que hemos creado anteriormente
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos del archivo xml
        String tcccajas = preferences.getString("Tarjeta Club Cinépolis Cajas","No existe la información");
        String tccpiezas = preferences.getString("Tarjeta Club Cinépolis Piezas","No existe la información");

        String tccfcajas = preferences.getString("Tarjeta Club Cinépolis Fánatico Cajas","No existe la información");
        String tccfpiezas = preferences.getString("Tarjeta Club Cinépolis Fánatico Piezas","No existe la información");

        String tccsfcajas = preferences.getString("Tarjeta Club Cinépolis Super Fánatico Cajas","No existe la información");
        String tccsfpiezas = preferences.getString("Tarjeta Club Cinépolis Super Fánatico Piezas","No existe la información");


        //Mandamos a las cajas de texto los datos obtenidos del archivo xml
        TextcajasTCCTaquilla.setText(tcccajas);
        TextpiezasTCCTaquilla.setText(tccpiezas);

        TextcajasTCCFTaquilla.setText(tccfcajas);
        TextpiezasTCCFTaquilla.setText(tccfpiezas);

        TextcajasTCCSFTaquilla.setText(tccsfcajas);
        TextpiezasTCCSFTaquilla.setText(tccsfpiezas);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.generarvalores_taquilla:
                //Mandar mensaje en pantalla que se están realizando las operaciones
                progressDialog.setMessage("Realizando operaciones, espere un momento...");
                progressDialog.show();

                //Invocamos los métodos
                operacionestarjetaclubcinepolisfan();
                operacionestarjetaclubcinepolisfanatico();
                operacionestarjetaclubcinepolissuperfanatico();

                guardarPreferencias();

                //Dejamos de mostrar en pantalla el cuadro de dialogo de progreso
                progressDialog.dismiss();

                break;

            case R.id.mostrarvalores_taquilla:

                cargarPreferencias();

                break;

        }
    }
}
