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

public class Dulceria_Agua_Nachos_Helado_Hotdog extends AppCompatActivity implements View.OnClickListener{

    //Variables
    private EditText TextAgua600refri1_dul, TextAgua600refri2_dul, TextAgua600refri3_dul,TextAgua600paquetes_dul, TextAgua600fisico_dul;
    private EditText TextAgua1refri1_dul, TextAgua1refri2_dul, TextAgua1refri3_dul,TextAgua1paquetes_dul, TextAgua1fisico_dul;
    private EditText Textcharolanachos1_dul, Textcharolanachos2_dul, Textcharolanachoscajas_dul,Textcharolanachospiezas_dul, Textcharolanachosfisico_dul;
    private EditText Textcharolanachosgrandes1_dul, Textcharolanachosgrandes2_dul, Textcharolanachosgrandescajas_dul,Textcharolanachosgrandespiezas_dul, Textcharolanachosgrandesfisico_dul;
    private EditText Textcharolahotdog1_dul, Textcharolahotdog2_dul, Textcharolahotdogfisico_dul;
    private EditText Textpanhotdogpaquetes1_dul, Textpanhotdogpiezas1_dul, Textpanhotdogpaquetes2_dul, Textpanhotdogpiezas2_dul, Textpanhotdogfisico_dul;
    private EditText Textsalchichapaquetes_dul, Textsalchichapiezas_dul, Textsalchichafisico_dul;
    private EditText Textcharolahotdogjumbo1_dul, Textcharolahotdogjumbo2_dul, Textcharolahotdogjumbofisico_dul;
    private EditText Textsalchichamegapaquetes_dul, Textsalchichamegapiezas_dul, Textsalchichamegafisico_dul;
    private EditText Textsalchibotana_dul;
    private EditText Textcornettohersheyconge1_dul, Textcornettohersheyconge2_dul, Textcornettohersheyconge3_dul, Textcornettohersheyfisico_dul;
    private EditText Textcornettochocolateconge1_dul, Textcornettochocolateconge2_dul, Textcornettochocolateconge3_dul, Textcornettochocolatefisico_dul;
    private EditText Textmagnumalmendrasconge1_dul, Textmagnumalmendrasconge2_dul, Textmagnumalmendrasconge3_dul, Textmagnumalmendrasfisico_dul;
    private EditText Textmagnumclasicaconge1_dul, Textmagnumclasicaconge2_dul, Textmagnumclasicaconge3_dul, Textmagnumclasicafisico_dul;
    private EditText Textmordiskoconge1_dul, Textmordiskoconge2_dul, Textmordiskoconge3_dul, Textmordiskofisico_dul;
    private EditText Textcococonge1_dul, Textcococonge2_dul, Textcococonge3_dul, Textcocofisico_dul;
    private EditText Textfresaconge1_dul, Textfresaconge2_dul, Textfresaconge3_dul, Textfresafisico_dul;
    private EditText Textcornettooreoconge1_dul, Textcornettooreoconge2_dul, Textcornettooreoconge3_dul, Textcornettooreofisico_dul;
    private EditText Textcornettofrutosconge1_dul, Textcornettofrutosconge2_dul, Textcornettofrutosconge3_dul, Textcornettofrutosfisico_dul;
    private EditText Textmichaoreoconge1_dul, Textmichaoreoconge2_dul, Textmichaoreoconge3_dul, Textmichaoreofisico_dul;
    private EditText Textmichammconge1_dul, Textmichammconge2_dul, Textmichammconge3_dul, Textmichammfisico_dul;
    private EditText Textmichamordiskoconge1_dul, Textmichamordiskoconge2_dul, Textmichamordiskoconge3_dul, Textmichamordiskofisico_dul;


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
        setContentView(R.layout.activity_dulceria_agua_nachos_helado_hotdog);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();


        //Hacemos referencias de los textos de entrada
        TextAgua600refri1_dul = (EditText) findViewById(R.id.agua600Refri1_dul);
        TextAgua600refri2_dul = (EditText) findViewById(R.id.agua600refri2_dul);
        TextAgua600refri3_dul = (EditText) findViewById(R.id.agua600refri3_dul);
        TextAgua600paquetes_dul = (EditText) findViewById(R.id.agua600paquete_dul);
        TextAgua600fisico_dul = (EditText) findViewById(R.id.agua600fisico_dul);

        TextAgua1refri1_dul = (EditText) findViewById(R.id.agua1Refri1_dul);
        TextAgua1refri2_dul = (EditText) findViewById(R.id.agua1refri2_dul);
        TextAgua1refri3_dul = (EditText) findViewById(R.id.agua1refri3_dul);
        TextAgua1paquetes_dul = (EditText) findViewById(R.id.agua1paquete_dul);
        TextAgua1fisico_dul = (EditText) findViewById(R.id.agua1fisico_dul);

        Textcharolanachoscajas_dul = (EditText) findViewById(R.id.charolanachoscajas_dul);
        Textcharolanachospiezas_dul = (EditText) findViewById(R.id.charolanachospz_dul);
        Textcharolanachos1_dul = (EditText) findViewById(R.id.charolanachos1_dul);
        Textcharolanachos2_dul = (EditText) findViewById(R.id.charolanachos2_dul);
        Textcharolanachosfisico_dul = (EditText) findViewById(R.id.charolanachosfisico_dul);

        Textcharolanachosgrandescajas_dul = (EditText) findViewById(R.id.charolanachosgrandecajas_dul);
        Textcharolanachosgrandespiezas_dul = (EditText) findViewById(R.id.charolanachosgrandepz_dul);
        Textcharolanachosgrandes1_dul = (EditText) findViewById(R.id.charolanachosgrande1_dul);
        Textcharolanachosgrandes2_dul = (EditText) findViewById(R.id.charolanachosgrande2_dul);
        Textcharolanachosgrandesfisico_dul = (EditText) findViewById(R.id.charolanachosgrandefisico_dul);

        Textcharolahotdog1_dul = (EditText) findViewById(R.id.charolahotdog1_dul);
        Textcharolahotdog2_dul = (EditText) findViewById(R.id.charolahotdog2_dul);
        Textcharolahotdogfisico_dul = (EditText) findViewById(R.id.charolahotdogfisico_dul);

        Textpanhotdogpaquetes1_dul = (EditText) findViewById(R.id.panhotdog1_dul);
        Textpanhotdogpiezas1_dul = (EditText) findViewById(R.id.panhotdog2_dul);
        Textpanhotdogpaquetes2_dul = (EditText) findViewById(R.id.panhotdog3_dul);
        Textpanhotdogpiezas2_dul = (EditText) findViewById(R.id.panhotdog4_dul);
        Textpanhotdogfisico_dul = (EditText) findViewById(R.id.panhotdogfisico_dul);

        Textsalchichapaquetes_dul = (EditText) findViewById(R.id.salchichahotdog1_dul);
        Textsalchichapiezas_dul = (EditText) findViewById(R.id.salchichahotdog2_dul);
        Textsalchichafisico_dul = (EditText) findViewById(R.id.salchichahotdogfisico_dul);

        Textcharolahotdogjumbo1_dul = (EditText) findViewById(R.id.charolajumbohotdog1_dul);
        Textcharolahotdogjumbo2_dul = (EditText) findViewById(R.id.charolajumbohotdog2_dul);
        Textcharolahotdogjumbofisico_dul = (EditText) findViewById(R.id.charolajumbohotdogfisico_dul);

        Textsalchichamegapaquetes_dul = (EditText) findViewById(R.id.salchichajumbohotdog1_dul);
        Textsalchichamegapiezas_dul = (EditText) findViewById(R.id.salchichajumbohotdog2_dul);
        Textsalchichamegafisico_dul = (EditText) findViewById(R.id.salchichajumbohotdogfisico_dul);

        Textsalchibotana_dul = (EditText) findViewById(R.id.salchibotana_dul);

        Textcornettohersheyconge1_dul = (EditText) findViewById(R.id.cornetohersheycong1_dul);
        Textcornettohersheyconge2_dul = (EditText) findViewById(R.id.cornetohersheycong2_dul);
        Textcornettohersheyconge3_dul = (EditText) findViewById(R.id.cornetohersheycong3_dul);
        Textcornettohersheyfisico_dul = (EditText) findViewById(R.id.cornetohersheyfisico_dul);

        Textcornettochocolateconge1_dul = (EditText) findViewById(R.id.cornetochocolaggecong1_dul);
        Textcornettochocolateconge2_dul = (EditText) findViewById(R.id.cornetochocolaggecong2_dul);
        Textcornettochocolateconge3_dul = (EditText) findViewById(R.id.cornetochocolaggecong3_dul);
        Textcornettochocolatefisico_dul = (EditText) findViewById(R.id.cornetochocolaggefisico_dul);

        Textmagnumalmendrasconge1_dul = (EditText) findViewById(R.id.magnumalmcong1_dul);
        Textmagnumalmendrasconge2_dul = (EditText) findViewById(R.id.magnumalmcong2_dul);
        Textmagnumalmendrasconge3_dul = (EditText) findViewById(R.id.magnumalmcong3_dul);
        Textmagnumalmendrasfisico_dul = (EditText) findViewById(R.id.magnumalmfisico_dul);

        Textmagnumclasicaconge1_dul = (EditText) findViewById(R.id.magnumclscong1_dul);
        Textmagnumclasicaconge2_dul = (EditText) findViewById(R.id.magnumclscong2_dul);
        Textmagnumclasicaconge3_dul = (EditText) findViewById(R.id.magnumclscong3_dul);
        Textmagnumclasicafisico_dul = (EditText) findViewById(R.id.magnumclsfisico_dul);

        Textmordiskoconge1_dul = (EditText) findViewById(R.id.mordiskovainillacong1_dul);
        Textmordiskoconge2_dul = (EditText) findViewById(R.id.mordiskovainillacong2_dul);
        Textmordiskoconge3_dul = (EditText) findViewById(R.id.mordiskovainillacong3_dul);
        Textmordiskofisico_dul = (EditText) findViewById(R.id.mordiskovainillafisico_dul);

        Textcococonge1_dul = (EditText) findViewById(R.id.solerocococong1_dul);
        Textcococonge2_dul = (EditText) findViewById(R.id.solerocococong2_dul);
        Textcococonge3_dul = (EditText) findViewById(R.id.solerocococong3_dul);
        Textcocofisico_dul = (EditText) findViewById(R.id.solerococofisico_dul);

        Textfresaconge1_dul = (EditText) findViewById(R.id.solerofresacong1_dul);
        Textfresaconge2_dul = (EditText) findViewById(R.id.solerofresacong2_dul);
        Textfresaconge3_dul = (EditText) findViewById(R.id.solerofresacong3_dul);
        Textfresafisico_dul = (EditText) findViewById(R.id.solerofresafisico_dul);

        Textcornettooreoconge1_dul = (EditText) findViewById(R.id.cornetooreocong1_dul);
        Textcornettooreoconge2_dul = (EditText) findViewById(R.id.cornetooreocong2_dul);
        Textcornettooreoconge3_dul = (EditText) findViewById(R.id.cornetooreocong3_dul);
        Textcornettooreofisico_dul = (EditText) findViewById(R.id.cornetooreofisico_dul);

        Textcornettofrutosconge1_dul = (EditText) findViewById(R.id.cornetofrutoscong1_dul);
        Textcornettofrutosconge2_dul = (EditText) findViewById(R.id.cornetofrutoscong2_dul);
        Textcornettofrutosconge3_dul = (EditText) findViewById(R.id.cornetofrutoscong3_dul);
        Textcornettofrutosfisico_dul = (EditText) findViewById(R.id.cornetofrutosfisico_dul);

        Textmichaoreoconge1_dul = (EditText) findViewById(R.id.michaoreocong1_dul);
        Textmichaoreoconge2_dul = (EditText) findViewById(R.id.michaoreocong2_dul);
        Textmichaoreoconge3_dul = (EditText) findViewById(R.id.michaoreocong3_dul);
        Textmichaoreofisico_dul = (EditText) findViewById(R.id.michaoreofisico_dul);

        Textmichammconge1_dul = (EditText) findViewById(R.id.michammcong1_dul);
        Textmichammconge2_dul = (EditText) findViewById(R.id.michammcong2_dul);
        Textmichammconge3_dul = (EditText) findViewById(R.id.michammcong3_dul);
        Textmichammfisico_dul = (EditText) findViewById(R.id.michammfisico_dul);

        Textmichamordiskoconge1_dul = (EditText) findViewById(R.id.michamordiskocong1_dul);
        Textmichamordiskoconge2_dul = (EditText) findViewById(R.id.michamordiskocong2_dul);
        Textmichamordiskoconge3_dul = (EditText) findViewById(R.id.michamordiskocong3_dul);
        Textmichamordiskofisico_dul = (EditText) findViewById(R.id.michamordiskofisico_dul);


        //Hacemos referencia al dialogo de progreso
        progressDialog = new ProgressDialog(this);

        //Hacemos referencia al botón
        BotonGenerarvalores = (Button) findViewById(R.id.generarvaloresagua_dul);
        BotonMostrarvalores = (Button) findViewById(R.id.mostrarvaloresagua_dul);

        //Listener de los botones
        BotonGenerarvalores.setOnClickListener(this);
        BotonMostrarvalores.setOnClickListener(this);

        //Guardar las preferencias automáticamente en caso de cerrar la aplicación por accidente
        TextAgua600refri1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua600refri1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextAgua600refri2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua600refri2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextAgua600refri3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua600refri3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextAgua600paquetes_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua600paquetes_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });


        TextAgua1refri1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua1refri1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextAgua1refri2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua1refri2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextAgua1refri3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua1refri3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextAgua1paquetes_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextAgua1paquetes_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachoscajas_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachoscajas_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachospiezas_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachospiezas_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachos1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachos1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachos2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachos2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachosgrandescajas_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachosgrandescajas_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachosgrandespiezas_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachosgrandespiezas_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachosgrandes1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachosgrandes1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolanachosgrandes2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolanachosgrandes2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolahotdog1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolahotdog1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolahotdog2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolahotdog2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpanhotdogpaquetes1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpanhotdogpaquetes1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpanhotdogpiezas1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpanhotdogpiezas1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpanhotdogpaquetes2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpanhotdogpaquetes2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpanhotdogpiezas2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpanhotdogpiezas2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsalchichapaquetes_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsalchichapaquetes_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsalchichapiezas_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsalchichapiezas_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolahotdogjumbo1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolahotdogjumbo1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcharolahotdogjumbo2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcharolahotdogjumbo2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsalchichamegapaquetes_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsalchichamegapaquetes_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsalchichamegapiezas_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsalchichamegapiezas_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsalchibotana_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsalchibotana_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettohersheyconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettohersheyconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettohersheyconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettohersheyconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettohersheyconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettohersheyconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettochocolateconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettochocolateconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettochocolateconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettochocolateconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettochocolateconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettochocolateconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmagnumalmendrasconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmagnumalmendrasconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmagnumalmendrasconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmagnumalmendrasconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmagnumalmendrasconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmagnumalmendrasconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmagnumclasicaconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmagnumclasicaconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmagnumclasicaconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmagnumclasicaconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmagnumclasicaconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmagnumclasicaconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmordiskoconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmordiskoconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmordiskoconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmordiskoconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmordiskoconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmordiskoconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcococonge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcococonge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcococonge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcococonge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcococonge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcococonge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textfresaconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textfresaconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textfresaconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textfresaconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textfresaconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textfresaconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettooreoconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettooreoconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettooreoconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettooreoconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettooreoconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettooreoconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettofrutosconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettofrutosconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettofrutosconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettofrutosconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcornettofrutosconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcornettofrutosconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichaoreoconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichaoreoconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichaoreoconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichaoreoconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichaoreoconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichaoreoconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichammconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichammconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichammconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichammconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichammconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichammconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichamordiskoconge1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichamordiskoconge1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichamordiskoconge2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichamordiskoconge2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmichamordiskoconge3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmichamordiskoconge3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });


    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesagua600(){
        //Obtenemos datos
        final String modulo1 = TextAgua600refri1_dul.getText().toString().trim();
        final String modulo2 = TextAgua600refri2_dul.getText().toString().trim();
        final String modulo3 = TextAgua600refri3_dul.getText().toString().trim();
        final String modulo4 = TextAgua600paquetes_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 600 ML", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 600 ML", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 600 ML", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 600 ML", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+(Float.parseFloat(modulo4)*12);

        //Mandamos el resultado de la operación a una caja de texto
        TextAgua600fisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-BEBIDAS",194, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesagua1LT(){
        //Obtenemos datos
        final String modulo1 = TextAgua1refri1_dul.getText().toString().trim();
        final String modulo2 = TextAgua1refri2_dul.getText().toString().trim();
        final String modulo3 = TextAgua1refri3_dul.getText().toString().trim();
        final String modulo4 = TextAgua1paquetes_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 1.2 LT", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 1.2 LT", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 1.2 LT", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Agua 1.2 LT", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+(Float.parseFloat(modulo4)*12);

        //Mandamos el resultado de la operación a una caja de texto
        TextAgua1fisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-BEBIDAS",4334, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescharolanachos(){
        //Obtenemos datos
        final String modulo1 = Textcharolanachoscajas_dul.getText().toString().trim();
        final String modulo2 = Textcharolanachospiezas_dul.getText().toString().trim();
        final String modulo3 = Textcharolanachos1_dul.getText().toString().trim();
        final String modulo4 = Textcharolanachos2_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Chicos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Chicos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Chicos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Chicos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*40)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcharolanachosfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-NACHOS",412, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescharolanachosgrandes(){
        //Obtenemos datos
        final String modulo1 = Textcharolanachosgrandescajas_dul.getText().toString().trim();
        final String modulo2 = Textcharolanachosgrandespiezas_dul.getText().toString().trim();
        final String modulo3 = Textcharolanachosgrandes1_dul.getText().toString().trim();
        final String modulo4 = Textcharolanachosgrandes2_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Grandes", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Grandes", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Grandes", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Nachos Grandes", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*20)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcharolanachosgrandesfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-NACHOS",2104, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescharolahotdog(){
        //Obtenemos datos
        final String modulo1 = Textcharolahotdog1_dul.getText().toString().trim();
        final String modulo2 = Textcharolahotdog2_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Hotdog Chico", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Hotdog Chico", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textcharolahotdogfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HD",377, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespanhotdog(){
        //Obtenemos datos
        final String modulo1 = Textpanhotdogpaquetes1_dul.getText().toString().trim();
        final String modulo2 = Textpanhotdogpiezas1_dul.getText().toString().trim();
        final String modulo3 = Textpanhotdogpaquetes2_dul.getText().toString().trim();
        final String modulo4 = Textpanhotdogpiezas2_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Pan Para Hotdog", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Pan Para Hotdog", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Pan Para Hotdog", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Pan Para Hotdog", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*8)+Float.parseFloat(modulo2)+(Float.parseFloat(modulo3)*8)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textpanhotdogfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HD",384, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionessalchicha(){
        //Obtenemos datos
        final String modulo1 = Textsalchichapaquetes_dul.getText().toString().trim();
        final String modulo2 = Textsalchichapiezas_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Salchicha Normal", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Salchicha Normal", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*6)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textsalchichafisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HD",393, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescharolahotdogjumbo(){
        //Obtenemos datos
        final String modulo1 = Textcharolahotdogjumbo1_dul.getText().toString().trim();
        final String modulo2 = Textcharolahotdogjumbo2_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Hotdog Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Charola Hotdog Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textcharolahotdogjumbofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HD",2172, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionessalchichamega(){
        //Obtenemos datos
        final String modulo1 = Textsalchichamegapaquetes_dul.getText().toString().trim();
        final String modulo2 = Textsalchichamegapiezas_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Salchicha Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Salchicha Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = (Float.parseFloat(modulo1)*18)+Float.parseFloat(modulo2);

        //Mandamos el resultado de la operación a una caja de texto
        Textsalchichamegafisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HD",2171, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionessalchibotana(){
        //Obtenemos datos
        final String modulo1 = Textsalchibotana_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Salchibotana", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1);

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HD",6245, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescornettohershey(){
        //Obtenemos datos
        final String modulo1 = Textcornettohersheyconge1_dul.getText().toString().trim();
        final String modulo2 = Textcornettohersheyconge2_dul.getText().toString().trim();
        final String modulo3 = Textcornettohersheyconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Herhey", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Herhey", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Herhey", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textcornettohersheyfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",10607, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescornettochocolate(){
        //Obtenemos datos
        final String modulo1 = Textcornettochocolateconge1_dul.getText().toString().trim();
        final String modulo2 = Textcornettochocolateconge2_dul.getText().toString().trim();
        final String modulo3 = Textcornettochocolateconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Chocolate", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Chocolate", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Chocolate", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textcornettochocolatefisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",1778, existenciafisica);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmagnumalmendras(){
        //Obtenemos datos
        final String modulo1 = Textmagnumalmendrasconge1_dul.getText().toString().trim();
        final String modulo2 = Textmagnumalmendrasconge2_dul.getText().toString().trim();
        final String modulo3 = Textmagnumalmendrasconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Magnum Almendras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Magnum Almendras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Magnum Almendras", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textmagnumalmendrasfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",1782, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmagnumclasica(){
        //Obtenemos datos
        final String modulo1 = Textmagnumclasicaconge1_dul.getText().toString().trim();
        final String modulo2 = Textmagnumclasicaconge2_dul.getText().toString().trim();
        final String modulo3 = Textmagnumclasicaconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Magnum Clásica", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Magnum Clásica", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Magnum Clásica", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textmagnumclasicafisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",1783, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmordiskovainilla(){
        //Obtenemos datos
        final String modulo1 = Textmordiskoconge1_dul.getText().toString().trim();
        final String modulo2 = Textmordiskoconge2_dul.getText().toString().trim();
        final String modulo3 = Textmordiskoconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Mordisko Vainilla", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Mordisko Vainilla", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Mordisko Vainilla", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textmordiskofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",1786, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionessolerococo(){
        //Obtenemos datos
        final String modulo1 = Textcococonge1_dul.getText().toString().trim();
        final String modulo2 = Textcococonge2_dul.getText().toString().trim();
        final String modulo3 = Textcococonge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Solero Coco", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Solero Coco", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Solero Coco", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textcocofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",1788, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionessolerofresa(){
        //Obtenemos datos
        final String modulo1 = Textfresaconge1_dul.getText().toString().trim();
        final String modulo2 = Textfresaconge2_dul.getText().toString().trim();
        final String modulo3 = Textfresaconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Solero Fresa", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Solero Fresa", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Solero Fresa", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textfresafisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",1789, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescornettooreo(){
        //Obtenemos datos
        final String modulo1 = Textcornettooreoconge1_dul.getText().toString().trim();
        final String modulo2 = Textcornettooreoconge2_dul.getText().toString().trim();
        final String modulo3 = Textcornettooreoconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Oreo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Oreo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Oreo", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textcornettooreofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",7272, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescornettofrutosrojos(){
        //Obtenemos datos
        final String modulo1 = Textcornettofrutosconge1_dul.getText().toString().trim();
        final String modulo2 = Textcornettofrutosconge2_dul.getText().toString().trim();
        final String modulo3 = Textcornettofrutosconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Frutos Rojos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Frutos Rojos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Cornetto Frutos Rojos", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textcornettofrutosfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",7972, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmichaoreo(){
        //Obtenemos datos
        final String modulo1 = Textmichaoreoconge1_dul.getText().toString().trim();
        final String modulo2 = Textmichaoreoconge2_dul.getText().toString().trim();
        final String modulo3 = Textmichaoreoconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha Oreo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha Oreo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha Oreo", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textmichaoreofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",8138, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmichamm(){
        //Obtenemos datos
        final String modulo1 = Textmichammconge1_dul.getText().toString().trim();
        final String modulo2 = Textmichammconge2_dul.getText().toString().trim();
        final String modulo3 = Textmichammconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha M&M", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha M&M", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha M&M", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textmichammfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",8926, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmichamordisko(){
        //Obtenemos datos
        final String modulo1 = Textmichamordiskoconge1_dul.getText().toString().trim();
        final String modulo2 = Textmichamordiskoconge2_dul.getText().toString().trim();
        final String modulo3 = Textmichamordiskoconge3_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha Mordisko", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha Mordisko", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Micha Mordisko", Toast.LENGTH_SHORT).show();
            return;
        }


        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3);

        //Mandamos el resultado de la operación a una caja de texto
        Textmichamordiskofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-HELADO",9692, existenciafisica);
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
        String pccmodulo1 = TextAgua600refri1_dul.getText().toString();
        String pccmodulo2 = TextAgua600refri2_dul.getText().toString();
        String pccmodulo3 = TextAgua600refri3_dul.getText().toString();
        String pccmodulo4 = TextAgua600paquetes_dul.getText().toString();

        String pmmodulo1 = TextAgua1refri1_dul.getText().toString();
        String pmmodulo2 = TextAgua1refri2_dul.getText().toString();
        String pmmodulo3 = TextAgua1refri3_dul.getText().toString();
        String pmmodulo4 = TextAgua1paquetes_dul.getText().toString();

        String pgmodulo1 = Textcharolanachoscajas_dul.getText().toString();
        String pgmodulo2 = Textcharolanachospiezas_dul.getText().toString();
        String pgmodulo3 = Textcharolanachos1_dul.getText().toString();
        String pgmodulo4 = Textcharolanachos2_dul.getText().toString();

        String pjmodulo1 = Textcharolanachosgrandescajas_dul.getText().toString();
        String pjmodulo2 = Textcharolanachosgrandespiezas_dul.getText().toString();
        String pjmodulo3 = Textcharolanachosgrandes1_dul.getText().toString();
        String pjmodulo4 = Textcharolanachosgrandes2_dul.getText().toString();

        String plmodulo1 = Textcharolahotdog1_dul.getText().toString();
        String plmodulo2 = Textcharolahotdog2_dul.getText().toString();

        String plmodulo3 = Textpanhotdogpaquetes1_dul.getText().toString();
        String plmodulo4 = Textpanhotdogpiezas1_dul.getText().toString();
        String pcmodulo1 = Textpanhotdogpaquetes2_dul.getText().toString();
        String pcmodulo2 = Textpanhotdogpiezas2_dul.getText().toString();

        String pcmodulo3 = Textsalchichapaquetes_dul.getText().toString();
        String pcmodulo4 = Textsalchichapiezas_dul.getText().toString();

        String vcmodulo1 = Textcharolahotdogjumbo1_dul.getText().toString();
        String vcmodulo2  = Textcharolahotdogjumbo2_dul.getText().toString();

        String vcmodulo3 = Textsalchichamegapaquetes_dul.getText().toString();
        String vcmodulo4 = Textsalchichamegapiezas_dul.getText().toString();

        String vmmodulo1 = Textsalchibotana_dul.getText().toString();

        String vmmodulo2 = Textcornettohersheyconge1_dul.getText().toString();
        String vmmodulo3 = Textcornettohersheyconge2_dul.getText().toString();
        String vmmodulo4 = Textcornettohersheyconge3_dul.getText().toString();

        String vgmodulo1 = Textcornettochocolateconge1_dul.getText().toString();
        String vgmodulo2 = Textcornettochocolateconge2_dul.getText().toString();
        String vgmodulo3 = Textcornettochocolateconge3_dul.getText().toString();

        String vgmodulo4 = Textmagnumalmendrasconge1_dul.getText().toString();
        String vjmodulo1 = Textmagnumalmendrasconge2_dul.getText().toString();
        String vjmodulo2 = Textmagnumalmendrasconge3_dul.getText().toString();

        String vjmodulo3 = Textmagnumclasicaconge1_dul.getText().toString();
        String vjmodulo4 = Textmagnumclasicaconge2_dul.getText().toString();
        String vimodulo1 = Textmagnumclasicaconge3_dul.getText().toString();

        String vimodulo2 = Textmordiskoconge1_dul.getText().toString();
        String vimodulo3 = Textmordiskoconge2_dul.getText().toString();
        String vimodulo4 = Textmordiskoconge3_dul.getText().toString();

        String vimodulo5 = Textcococonge1_dul.getText().toString();
        String vimodulo6 = Textcococonge2_dul.getText().toString();
        String vimodulo7 = Textcococonge3_dul.getText().toString();

        String vimodulo8 = Textfresaconge1_dul.getText().toString();
        String vimodulo9 = Textfresaconge2_dul.getText().toString();
        String vimodulo10 = Textfresaconge3_dul.getText().toString();

        String vimodulo11 = Textcornettooreoconge1_dul.getText().toString();
        String vimodulo12 = Textcornettooreoconge2_dul.getText().toString();
        String vimodulo13 = Textcornettooreoconge3_dul.getText().toString();

        String vimodulo14 = Textcornettofrutosconge1_dul.getText().toString();
        String vimodulo15 = Textcornettofrutosconge2_dul.getText().toString();
        String vimodulo16 = Textcornettofrutosconge3_dul.getText().toString();

        String vimodulo17 = Textmichaoreoconge1_dul.getText().toString();
        String vimodulo18 = Textmichaoreoconge2_dul.getText().toString();
        String vimodulo19 = Textmichaoreoconge3_dul.getText().toString();

        String vimodulo20 = Textmichammconge1_dul.getText().toString();
        String vimodulo21 = Textmichammconge2_dul.getText().toString();
        String vimodulo22 = Textmichammconge3_dul.getText().toString();

        String vimodulo23 = Textmichamordiskoconge1_dul.getText().toString();
        String vimodulo24 = Textmichamordiskoconge2_dul.getText().toString();
        String vimodulo25 = Textmichamordiskoconge3_dul.getText().toString();

        //Creamos un objeto para poder escribir en el archivo xml que creamos los datos que hemos obtenido
        SharedPreferences.Editor editor = preferences.edit();

        //Aqui estamos escribiendo los datos en el archivo xml
        editor.putString("Agua 600 refrigerador 1",pccmodulo1);
        editor.putString("Agua 600 refrigerador 2",pccmodulo2);
        editor.putString("Agua 600 refrigerador 3",pccmodulo3);
        editor.putString("Agua 600 paquetes",pccmodulo4);

        editor.putString("Agua 1.2 refrigerador 1",pmmodulo1);
        editor.putString("Agua 1.2 refrigerador 2",pmmodulo2);
        editor.putString("Agua 1.2 refrigerador 3",pmmodulo3);
        editor.putString("Agua 1.2 paquetes",pmmodulo4);

        editor.putString("Charola Nachos Chicos cajas",pgmodulo1);
        editor.putString("Charola Nachos Chicos piezas",pgmodulo2);
        editor.putString("Charola Nachos Chicos 1",pgmodulo3);
        editor.putString("Charola Nachos Chicos 2",pgmodulo4);

        editor.putString("Charola Nachos Grandes cajas",pjmodulo1);
        editor.putString("Charola Nachos Grandes piezas",pjmodulo2);
        editor.putString("Charola Nachos Grandes 1",pjmodulo3);
        editor.putString("Charola Nachos Grandes 2",pjmodulo4);

        editor.putString("Charola Hotdog Chico 1",plmodulo1);
        editor.putString("Charola Hotdog Chico 2",plmodulo2);

        editor.putString("Pan Para Hotdog 1",plmodulo3);
        editor.putString("Pan Para Hotdog 2",plmodulo4);
        editor.putString("Pan Para Hotdog 3",pcmodulo1);
        editor.putString("Pan Para Hotdog 4",pcmodulo2);

        editor.putString("Salchicha 1",pcmodulo3);
        editor.putString("Salchicha 2",pcmodulo4);

        editor.putString("Charola Hotdog Jumbo 1",vcmodulo1);
        editor.putString("Charola Hotdog Jumbo 2",vcmodulo2);

        editor.putString("Salchicha Mega 1",vcmodulo3);
        editor.putString("Salchicha Mega 2",vcmodulo4);

        editor.putString("Salchibotana",vmmodulo1);

        editor.putString("Cornetto Hershey 1",vmmodulo2);
        editor.putString("Cornetto Hershey 2",vmmodulo3);
        editor.putString("Cornetto Hershey 3",vmmodulo4);

        editor.putString("Cornetto Chocolate 1",vgmodulo1);
        editor.putString("Cornetto Chocolate 2",vgmodulo2);
        editor.putString("Cornetto Chocolate 3",vgmodulo3);

        editor.putString("Magnum Almendras 1",vgmodulo4);
        editor.putString("Magnum Almendras 2",vjmodulo1);
        editor.putString("Magnum Almendras 3",vjmodulo2);

        editor.putString("Magnum Clasica 1",vjmodulo3);
        editor.putString("Magnum Clasica 2",vjmodulo4);
        editor.putString("Magnum Clasica 3",vimodulo1);

        editor.putString("Mordisko 1",vimodulo2);
        editor.putString("Mordisko 2",vimodulo3);
        editor.putString("Mordisko 3",vimodulo4);

        editor.putString("Solero Coco 1",vimodulo5);
        editor.putString("Solero Coco 2",vimodulo6);
        editor.putString("Solero Coco 3",vimodulo7);

        editor.putString("Solero Fresa 1",vimodulo8);
        editor.putString("Solero Fresa 2",vimodulo9);
        editor.putString("Solero Fresa 3",vimodulo10);

        editor.putString("Cornetto Oreo 1",vimodulo11);
        editor.putString("Cornetto Oreo 2",vimodulo12);
        editor.putString("Cornetto Oreo 3",vimodulo13);

        editor.putString("Cornetto Frutos Rojos 1",vimodulo14);
        editor.putString("Cornetto Frutos Rojos 2",vimodulo15);
        editor.putString("Cornetto Frutos Rojos 3",vimodulo16);

        editor.putString("Micha Oreo 1",vimodulo17);
        editor.putString("Micha Oreo 2",vimodulo18);
        editor.putString("Micha Oreo 3",vimodulo19);

        editor.putString("Micha MM 1",vimodulo20);
        editor.putString("Micha MM 2",vimodulo21);
        editor.putString("Micha MM 3",vimodulo22);

        editor.putString("Micha Mordisko 1",vimodulo23);
        editor.putString("Micha Mordisko 2",vimodulo24);
        editor.putString("Micha Mordisko 3",vimodulo25);

        //Toast.makeText(Dulceria_Productos_Estrella.this, "Datos: "+modulo1+","+modulo2+","+modulo3+","+modulo4, Toast.LENGTH_SHORT).show();

        editor.commit();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void cargarPreferencias(){

        //Abrimos el archivo xml que hemos creado anteriormente
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos del archivo xml
        String pccmodulo1 = preferences.getString("Agua 600 refrigerador 1","No existe la información");
        String pccmodulo2 = preferences.getString("Agua 600 refrigerador 2","No existe la información");
        String pccmodulo3 = preferences.getString("Agua 600 refrigerador 3","No existe la información");
        String pccmodulo4 = preferences.getString("Agua 600 paquetes","No existe la información");

        String pmmodulo1 = preferences.getString("Agua 1.2 refrigerador 1","No existe la información");
        String pmmodulo2 = preferences.getString("Agua 1.2 refrigerador 2","No existe la información");
        String pmmodulo3 = preferences.getString("Agua 1.2 refrigerador 3","No existe la información");
        String pmmodulo4 = preferences.getString("Agua 1.2 paquetes","No existe la información");

        String pgmodulo1 = preferences.getString("Charola Nachos Chicos cajas","No existe la información");
        String pgmodulo2 = preferences.getString("Charola Nachos Chicos piezas","No existe la información");
        String pgmodulo3 = preferences.getString("Charola Nachos Chicos 1","No existe la información");
        String pgmodulo4 = preferences.getString("Charola Nachos Chicos 2","No existe la información");

        String pjmodulo1 = preferences.getString("Charola Nachos Grandes cajas","No existe la información");
        String pjmodulo2 = preferences.getString("Charola Nachos Grandes piezas","No existe la información");
        String pjmodulo3 = preferences.getString("Charola Nachos Grandes 1","No existe la información");
        String pjmodulo4 = preferences.getString("Charola Nachos Grandes 2","No existe la información");

        String plmodulo1 = preferences.getString("Charola Hotdog Chico 1","No existe la información");
        String plmodulo2 = preferences.getString("Charola Hotdog Chico 2","No existe la información");

        String plmodulo3 = preferences.getString("Pan Para Hotdog 1","No existe la información");
        String plmodulo4 = preferences.getString("Pan Para Hotdog 2","No existe la información");
        String pcmodulo1 = preferences.getString("Pan Para Hotdog 3","No existe la información");
        String pcmodulo2 = preferences.getString("Pan Para Hotdog 4","No existe la información");

        String pcmodulo3 = preferences.getString("Salchicha 1","No existe la información");
        String pcmodulo4 = preferences.getString("Salchicha 2","No existe la información");

        String vcmodulo1 = preferences.getString("Charola Hotdog Jumbo 1","No existe la información");
        String vcmodulo2 = preferences.getString("Charola Hotdog Jumbo 2","No existe la información");

        String vcmodulo3 = preferences.getString("Salchicha Mega 1","No existe la información");
        String vcmodulo4 = preferences.getString("Salchicha Mega 2","No existe la información");

        String vmmodulo1 = preferences.getString("Salchibotana","No existe la información");

        String vmmodulo2 = preferences.getString("Cornetto Hershey 1","No existe la información");
        String vmmodulo3 = preferences.getString("Cornetto Hershey 2","No existe la información");
        String vmmodulo4 = preferences.getString("Cornetto Hershey 3","No existe la información");

        String vgmodulo1 = preferences.getString("Cornetto Chocolate 1","No existe la información");
        String vgmodulo2 = preferences.getString("Cornetto Chocolate 2","No existe la información");
        String vgmodulo3 = preferences.getString("Cornetto Chocolate 3","No existe la información");

        String vgmodulo4 = preferences.getString("Magnum Almendras 1","No existe la información");
        String vjmodulo1 = preferences.getString("Magnum Almendras 2","No existe la información");
        String vjmodulo2 = preferences.getString("Magnum Almendras 3","No existe la información");

        String vjmodulo3 = preferences.getString("Magnum Clasica 1","No existe la información");
        String vjmodulo4 = preferences.getString("Magnum Clasica 2","No existe la información");
        String vimodulo1 = preferences.getString("Magnum Clasica 3","No existe la información");

        String vimodulo2 = preferences.getString("Mordisko 1","No existe la información");
        String vimodulo3 = preferences.getString("Mordisko 2","No existe la información");
        String vimodulo4 = preferences.getString("Mordisko 3","No existe la información");

        String vimodulo5 = preferences.getString("Solero Coco 1","No existe la información");
        String vimodulo6 = preferences.getString("Solero Coco 2","No existe la información");
        String vimodulo7 = preferences.getString("Solero Coco 3","No existe la información");

        String vimodulo8 = preferences.getString("Solero Fresa 1","No existe la información");
        String vimodulo9 = preferences.getString("Solero Fresa 2","No existe la información");
        String vimodulo10 = preferences.getString("Solero Fresa 3","No existe la información");

        String vimodulo11 = preferences.getString("Cornetto Oreo 1","No existe la información");
        String vimodulo12 = preferences.getString("Cornetto Oreo 2","No existe la información");
        String vimodulo13 = preferences.getString("Cornetto Oreo 3","No existe la información");

        String vimodulo14 = preferences.getString("Cornetto Frutos Rojos 1","No existe la información");
        String vimodulo15 = preferences.getString("Cornetto Frutos Rojos 2","No existe la información");
        String vimodulo16 = preferences.getString("Cornetto Frutos Rojos 3","No existe la información");

        String vimodulo17 = preferences.getString("Micha Oreo 1","No existe la información");
        String vimodulo18 = preferences.getString("Micha Oreo 2","No existe la información");
        String vimodulo19 = preferences.getString("Micha Oreo 3","No existe la información");

        String vimodulo20 = preferences.getString("Micha MM 1","No existe la información");
        String vimodulo21 = preferences.getString("Micha MM 2","No existe la información");
        String vimodulo22 = preferences.getString("Micha MM 3","No existe la información");

        String vimodulo23 = preferences.getString("Micha Mordisko 1","No existe la información");
        String vimodulo24 = preferences.getString("Micha Mordisko 2","No existe la información");
        String vimodulo25 = preferences.getString("Micha Mordisko 3","No existe la información");

        //Mandamos a las cajas de texto los datos obtenidos del archivo xml
        TextAgua600refri1_dul.setText(pccmodulo1);
        TextAgua600refri2_dul.setText(pccmodulo2);
        TextAgua600refri3_dul.setText(pccmodulo3);
        TextAgua600paquetes_dul.setText(pccmodulo4);

        TextAgua1refri1_dul.setText(pmmodulo1);
        TextAgua1refri2_dul.setText(pmmodulo2);
        TextAgua1refri3_dul.setText(pmmodulo3);
        TextAgua1paquetes_dul.setText(pmmodulo4);

        Textcharolanachoscajas_dul.setText(pgmodulo1);
        Textcharolanachospiezas_dul.setText(pgmodulo2);
        Textcharolanachos1_dul.setText(pgmodulo3);
        Textcharolanachos2_dul.setText(pgmodulo4);

        Textcharolanachosgrandescajas_dul.setText(pjmodulo1);
        Textcharolanachosgrandespiezas_dul.setText(pjmodulo2);
        Textcharolanachosgrandes1_dul.setText(pjmodulo3);
        Textcharolanachosgrandes2_dul.setText(pjmodulo4);

        Textcharolahotdog1_dul.setText(plmodulo1);
        Textcharolahotdog2_dul.setText(plmodulo2);

        Textpanhotdogpaquetes1_dul.setText(plmodulo3);
        Textpanhotdogpiezas1_dul.setText(plmodulo4);
        Textpanhotdogpaquetes2_dul.setText(pcmodulo1);
        Textpanhotdogpiezas2_dul.setText(pcmodulo2);

        Textsalchichapaquetes_dul.setText(pcmodulo3);
        Textsalchichapiezas_dul.setText(pcmodulo4);

        Textcharolahotdogjumbo1_dul.setText(vcmodulo1);
        Textcharolahotdogjumbo2_dul.setText(vcmodulo2);

        Textsalchichamegapaquetes_dul.setText(vcmodulo3);
        Textsalchichamegapiezas_dul.setText(vcmodulo4);

        Textsalchibotana_dul.setText(vmmodulo1);

        Textcornettohersheyconge1_dul.setText(vmmodulo2);
        Textcornettohersheyconge2_dul.setText(vmmodulo3);
        Textcornettohersheyconge3_dul.setText(vmmodulo4);

        Textcornettochocolateconge1_dul.setText(vgmodulo1);
        Textcornettochocolateconge2_dul.setText(vgmodulo2);
        Textcornettochocolateconge3_dul.setText(vgmodulo3);

        Textmagnumalmendrasconge1_dul.setText(vgmodulo4);
        Textmagnumalmendrasconge2_dul.setText(vjmodulo1);
        Textmagnumalmendrasconge3_dul.setText(vjmodulo2);

        Textmagnumclasicaconge1_dul.setText(vjmodulo3);
        Textmagnumclasicaconge2_dul.setText(vjmodulo4);
        Textmagnumclasicaconge3_dul.setText(vimodulo1);

        Textmordiskoconge1_dul.setText(vimodulo2);
        Textmordiskoconge2_dul.setText(vimodulo3);
        Textmordiskoconge3_dul.setText(vimodulo4);

        Textcococonge1_dul.setText(vimodulo5);
        Textcococonge2_dul.setText(vimodulo6);
        Textcococonge3_dul.setText(vimodulo7);

        Textfresaconge1_dul.setText(vimodulo8);
        Textfresaconge2_dul.setText(vimodulo9);
        Textfresaconge3_dul.setText(vimodulo10);

        Textcornettooreoconge1_dul.setText(vimodulo11);
        Textcornettooreoconge2_dul.setText(vimodulo12);
        Textcornettooreoconge3_dul.setText(vimodulo13);

        Textcornettofrutosconge1_dul.setText(vimodulo14);
        Textcornettofrutosconge2_dul.setText(vimodulo15);
        Textcornettofrutosconge3_dul.setText(vimodulo16);

        Textmichaoreoconge1_dul.setText(vimodulo17);
        Textmichaoreoconge2_dul.setText(vimodulo18);
        Textmichaoreoconge3_dul.setText(vimodulo19);

        Textmichammconge1_dul.setText(vimodulo20);
        Textmichammconge2_dul.setText(vimodulo21);
        Textmichammconge3_dul.setText(vimodulo22);

        Textmichamordiskoconge1_dul.setText(vimodulo23);
        Textmichamordiskoconge2_dul.setText(vimodulo24);
        Textmichamordiskoconge3_dul.setText(vimodulo25);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.generarvaloresagua_dul:
                //Mandar mensaje en pantalla que se están realizando las operaciones
                progressDialog.setMessage("Realizando operaciones, espere un momento...");
                progressDialog.show();

                //Invocamos los métodos
                operacionesagua600();
                operacionesagua1LT();
                operacionescharolanachos();
                operacionescharolanachosgrandes();
                operacionescharolahotdog();
                operacionespanhotdog();
                operacionessalchicha();
                operacionescharolahotdogjumbo();
                operacionessalchichamega();
                operacionessalchibotana();
                operacionescornettohershey();
                operacionescornettochocolate();
                operacionesmagnumalmendras();
                operacionesmagnumclasica();
                operacionesmordiskovainilla();
                operacionessolerococo();
                operacionessolerofresa();
                operacionescornettooreo();
                operacionescornettofrutosrojos();
                operacionesmichaoreo();
                operacionesmichamm();
                operacionesmichamordisko();

                //Guardamos preferencias
                guardarPreferencias();


                //Dejamos de mostrar en pantalla el cuadro de dialogo de progreso
                progressDialog.dismiss();

                break;

            case R.id.mostrarvaloresagua_dul:

                //Invocamos al método
                cargarPreferencias();

                break;
        }

    }
}
