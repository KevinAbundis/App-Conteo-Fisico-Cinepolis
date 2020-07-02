package com.abundis.proyecto_cinepolis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Dulceria_Vitrina extends AppCompatActivity implements View.OnClickListener  {

    //Variables
    private EditText Textkitkat4mod1_dul, Textkitkat4mod2_dul, Textkitkat4mod3_dul,Textkitkat4mod4_dul, Textkitkat4fisico_dul;
    private EditText Texthersheycookiesmod1_dul, Texthersheycookiesmod2_dul, Texthersheycookiesmod3_dul, Texthersheycookiesmod4_dul, Texthersheycookiesfisico_dul;
    private EditText Texthersheyalmendrasmod1_dul, Texthersheyalmendrasmod2_dul, Texthersheyalmendrasmod3_dul, Texthersheyalmendrasmod4_dul, Texthersheyalmendrasfisico_dul;
    private EditText Textcruchmod1_dul, Textcruchmod2_dul, Textcruchmod3_dul, Textcruchmod4_dul, Textcruchfisico_dul;
    private EditText Textskrmod1_dul, Textskrmod2_dul, Textskrmod3_dul,Textskrmod4_dul, Textskrfisico_dul;
    private EditText Textsksmod1_dul, Textsksmod2_dul, Textsksmod3_dul, Textsksmod4_dul, Textsksfisico_dul;
    private EditText Textcaramelmod1_dul, Textcaramelmod2_dul, Textcaramelmod3_dul, Textcaramelmod4_dul, Textcaramelfisico_dul;
    private EditText Textsandiamod1_dul, Textsandiamod2_dul, Textsandiamod3_dul, Textsandiamod4_dul, Textsandiafisico_dul;
    private EditText Textfrutasmod1_dul, Textfrutasmod2_dul, Textfrutasmod3_dul, Textfrutasmod4_dul, Textfrutasfisico_dul;
    private EditText Textchocolatemod1_dul, Textchocolatemod2_dul, Textchocolatemod3_dul, Textchocolatemod4_dul, Textchocolatefisico_dul;
    private EditText Textamarillomod1_dul, Textamarillomod2_dul, Textamarillomod3_dul, Textamarillomod4_dul, Textamarillofisico_dul;
    private EditText Textcafemod1_dul, Textcafemod2_dul, Textcafemod3_dul, Textcafemod4_dul, Textcafefisico_dul;
    private EditText Textponponsmod1_dul, Textponponsmod2_dul, Textponponsmod3_dul, Textponponsmod4_dul, Textponponsfisico_dul;
    private EditText Textsnickersmod1_dul, Textsnickersmod2_dul, Textsnickersmod3_dul, Textsnickersmod4_dul, Textsnickersfisico_dul;
    private EditText Textpelonazomod1_dul, Textpelonazomod2_dul, Textpelonazomod3_dul, Textpelonazomod4_dul, Textpelonazofisico_dul;
    private EditText Textmangomod1_dul, Textmangomod2_dul, Textmangomod3_dul, Textmangomod4_dul, Textmangofisico_dul;
    private EditText Textpelonetemod1_dul, Textpelonetemod2_dul, Textpelonetemod3_dul, Textpelonetemod4_dul, Textpelonetefisico_dul;
    private EditText Textnerdsmod1_dul, Textnerdsmod2_dul, Textnerdsmod3_dul, Textnerdsmod4_dul, Textnerdsfisico_dul;
    private EditText Textskittlesmod1_dul, Textskittlesmod2_dul, Textskittlesmod3_dul, Textskittlesmod4_dul, Textskittlesfisico_dul;
    private EditText Textgomitasmod1_dul, Textgomitasmod2_dul, Textgomitasmod3_dul, Textgomitasmod4_dul, Textgomitasfisico_dul;
    private EditText Textalgodonmod1_dul, Textalgodonmod2_dul, Textalgodonmod3_dul, Textalgodonmod4_dul, Textalgodonfisico_dul;
    private EditText Textlifesavermod1_dul, Textlifesavermod2_dul, Textlifesavermod3_dul, Textlifesavermod4_dul, Textlifesaverfisico_dul;
    private EditText Textpouchmod1_dul, Textpouchmod2_dul, Textpouchmod3_dul, Textpouchmod4_dul, Textpouchfisico_dul;
    private EditText Textchocolatevipmod1_dul, Textchocolatevipmod2_dul, Textchocolatevipmod3_dul, Textchocolatevipmod4_dul, Textchocolatevipfisico_dul;
    private EditText Textcacahuatevipmod1_dul, Textcacahuatevipmod2_dul, Textcacahuatevipmod3_dul, Textcacahuatevipmod4_dul, Textcacahuatevipfisico_dul;



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
        setContentView(R.layout.activity_dulceria_vitrina);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //Hacemos referencias de los textos de entrada
        Textkitkat4mod1_dul = (EditText) findViewById(R.id.kitkat4mod1_dul);
        Textkitkat4mod2_dul = (EditText) findViewById(R.id.kitkat4mod2_dul);
        Textkitkat4mod3_dul = (EditText) findViewById(R.id.kitkat4mod3_dul);
        Textkitkat4mod4_dul = (EditText) findViewById(R.id.kitkat4mod4_dul);
        Textkitkat4fisico_dul = (EditText) findViewById(R.id.kitkatfisico_dul);

        Texthersheycookiesmod1_dul = (EditText) findViewById(R.id.hersheygalletamod1_dul);
        Texthersheycookiesmod2_dul = (EditText) findViewById(R.id.hersheygalletamod2_dul);
        Texthersheycookiesmod3_dul = (EditText) findViewById(R.id.hersheygalletamod3_dul);
        Texthersheycookiesmod4_dul = (EditText) findViewById(R.id.hersheygalletamod4_dul);
        Texthersheycookiesfisico_dul = (EditText) findViewById(R.id.hersheygalletafisico_dul);

        Texthersheyalmendrasmod1_dul = (EditText) findViewById(R.id.hersheyalmendramod1_dul);
        Texthersheyalmendrasmod2_dul = (EditText) findViewById(R.id.hersheyalmendramod2_dul);
        Texthersheyalmendrasmod3_dul = (EditText) findViewById(R.id.hersheyalmendramod3_dul);
        Texthersheyalmendrasmod4_dul = (EditText) findViewById(R.id.hersheyalmendramod4_dul);
        Texthersheyalmendrasfisico_dul = (EditText) findViewById(R.id.hersheyalmendrafisico_dul);

        Textcruchmod1_dul = (EditText) findViewById(R.id.crunchmod1_dul);
        Textcruchmod2_dul = (EditText) findViewById(R.id.crunchmod2_dul);
        Textcruchmod3_dul = (EditText) findViewById(R.id.crunchmod3_dul);
        Textcruchmod4_dul = (EditText) findViewById(R.id.crunchmod4_dul);
        Textcruchfisico_dul = (EditText) findViewById(R.id.crunchfisico_dul);

        Textskrmod1_dul = (EditText) findViewById(R.id.skpcmod1_dul);
        Textskrmod2_dul = (EditText) findViewById(R.id.skpcmod2_dul);
        Textskrmod3_dul = (EditText) findViewById(R.id.skpcmod3_dul);
        Textskrmod4_dul = (EditText) findViewById(R.id.skpcmod4_dul);
        Textskrfisico_dul = (EditText) findViewById(R.id.skpcfisico_dul);

        Textsksmod1_dul = (EditText) findViewById(R.id.skssmod1_dul);
        Textsksmod2_dul = (EditText) findViewById(R.id.skssmod2_dul);
        Textsksmod3_dul = (EditText) findViewById(R.id.skssmod3_dul);
        Textsksmod4_dul = (EditText) findViewById(R.id.skssmod4_dul);
        Textsksfisico_dul = (EditText) findViewById(R.id.skssfisico_dul);

        Textcaramelmod1_dul = (EditText) findViewById(R.id.mmcaramelmod1_dul);
        Textcaramelmod2_dul = (EditText) findViewById(R.id.mmcaramelmod2_dul);
        Textcaramelmod3_dul = (EditText) findViewById(R.id.mmcaramelmod3_dul);
        Textcaramelmod4_dul = (EditText) findViewById(R.id.mmcaramelmod4_dul);
        Textcaramelfisico_dul = (EditText) findViewById(R.id.mmcaramelfisico_dul);

        Textsandiamod1_dul = (EditText) findViewById(R.id.sanchetsandmod1_dul);
        Textsandiamod2_dul = (EditText) findViewById(R.id.sanchetsandmod2_dul);
        Textsandiamod3_dul = (EditText) findViewById(R.id.sanchetsandmod3_dul);
        Textsandiamod4_dul = (EditText) findViewById(R.id.sanchetsandmod4_dul);
        Textsandiafisico_dul = (EditText) findViewById(R.id.sanchetsandfisico_dul);

        Textfrutasmod1_dul = (EditText) findViewById(R.id.sanchetfrutasmod1_dul);
        Textfrutasmod2_dul = (EditText) findViewById(R.id.sanchetfrutasmod2_dul);
        Textfrutasmod3_dul = (EditText) findViewById(R.id.sanchetfrutasmod3_dul);
        Textfrutasmod4_dul = (EditText) findViewById(R.id.sanchetfrutasmod4_dul);
        Textfrutasfisico_dul = (EditText) findViewById(R.id.sanchetfrutasfisico_dul);

        Textchocolatemod1_dul = (EditText) findViewById(R.id.sanchetchocomod1_dul);
        Textchocolatemod2_dul = (EditText) findViewById(R.id.sanchetchocomod2_dul);
        Textchocolatemod3_dul = (EditText) findViewById(R.id.sanchetchocomod3_dul);
        Textchocolatemod4_dul = (EditText) findViewById(R.id.sanchetchocomod4_dul);
        Textchocolatefisico_dul = (EditText) findViewById(R.id.sanchetchocofisico_dul);

        Textamarillomod1_dul = (EditText) findViewById(R.id.mmamarillomod1_dul);
        Textamarillomod2_dul = (EditText) findViewById(R.id.mmamarillomod2_dul);
        Textamarillomod3_dul = (EditText) findViewById(R.id.mmamarillomod3_dul);
        Textamarillomod4_dul = (EditText) findViewById(R.id.mmamarillomod4_dul);
        Textamarillofisico_dul = (EditText) findViewById(R.id.mmamarillofisico_dul);

        Textcafemod1_dul = (EditText) findViewById(R.id.mmcafemod1_dul);
        Textcafemod2_dul = (EditText) findViewById(R.id.mmcafemod2_dul);
        Textcafemod3_dul = (EditText) findViewById(R.id.mmcafemod3_dul);
        Textcafemod4_dul = (EditText) findViewById(R.id.mmcafemod4_dul);
        Textcafefisico_dul = (EditText) findViewById(R.id.mmcafefisico_dul);

        Textponponsmod1_dul = (EditText) findViewById(R.id.ponponsmod1_dul);
        Textponponsmod2_dul = (EditText) findViewById(R.id.ponponsmod2_dul);
        Textponponsmod3_dul = (EditText) findViewById(R.id.ponponsmod3_dul);
        Textponponsmod4_dul = (EditText) findViewById(R.id.ponponsmod4_dul);
        Textponponsfisico_dul = (EditText) findViewById(R.id.ponponsfisico_dul);

        Textsnickersmod1_dul = (EditText) findViewById(R.id.snickersmod1_dul);
        Textsnickersmod2_dul = (EditText) findViewById(R.id.snickersmod2_dul);
        Textsnickersmod3_dul = (EditText) findViewById(R.id.snickersmod3_dul);
        Textsnickersmod4_dul = (EditText) findViewById(R.id.snickersmod4_dul);
        Textsnickersfisico_dul = (EditText) findViewById(R.id.snickersfisico_dul);

        Textpelonazomod1_dul = (EditText) findViewById(R.id.pelonmod1_dul);
        Textpelonazomod2_dul = (EditText) findViewById(R.id.pelonmod2_dul);
        Textpelonazomod3_dul = (EditText) findViewById(R.id.pelonmod3_dul);
        Textpelonazomod4_dul = (EditText) findViewById(R.id.pelonmod4_dul);
        Textpelonazofisico_dul = (EditText) findViewById(R.id.pelonfisico_dul);

        Textmangomod1_dul = (EditText) findViewById(R.id.sachetbolmod1_dul);
        Textmangomod2_dul = (EditText) findViewById(R.id.sachetbolmod2_dul);
        Textmangomod3_dul = (EditText) findViewById(R.id.sachetbolmod3_dul);
        Textmangomod4_dul = (EditText) findViewById(R.id.sachetbolmod4_dul);
        Textmangofisico_dul = (EditText) findViewById(R.id.sachetbolfisico_dul);

        Textpelonetemod1_dul = (EditText) findViewById(R.id.pelonetemod1_dul);
        Textpelonetemod2_dul = (EditText) findViewById(R.id.pelonetemod2_dul);
        Textpelonetemod3_dul = (EditText) findViewById(R.id.pelonetemod3_dul);
        Textpelonetemod4_dul = (EditText) findViewById(R.id.pelonetemod4_dul);
        Textpelonetefisico_dul = (EditText) findViewById(R.id.pelonetefisico_dul);

        Textnerdsmod1_dul = (EditText) findViewById(R.id.nerdsmod1_dul);
        Textnerdsmod2_dul = (EditText) findViewById(R.id.nerdsmod2_dul);
        Textnerdsmod3_dul = (EditText) findViewById(R.id.nerdsmod3_dul);
        Textnerdsmod4_dul = (EditText) findViewById(R.id.nerdsmod4_dul);
        Textnerdsfisico_dul = (EditText) findViewById(R.id.nerdsfisico_dul);

        Textskittlesmod1_dul = (EditText) findViewById(R.id.skittlesgrdmod1_dul);
        Textskittlesmod2_dul = (EditText) findViewById(R.id.skittlesgrdmod2_dul);
        Textskittlesmod3_dul = (EditText) findViewById(R.id.skittlesgrdmod3_dul);
        Textskittlesmod4_dul = (EditText) findViewById(R.id.skittlesgrdmod4_dul);
        Textskittlesfisico_dul = (EditText) findViewById(R.id.skittlesgrdfisico_dul);

        Textgomitasmod1_dul = (EditText) findViewById(R.id.gomdulmod1_dul);
        Textgomitasmod2_dul = (EditText) findViewById(R.id.gomdulmod2_dul);
        Textgomitasmod3_dul = (EditText) findViewById(R.id.gomdulmod3_dul);
        Textgomitasmod4_dul = (EditText) findViewById(R.id.gomdulmod4_dul);
        Textgomitasfisico_dul = (EditText) findViewById(R.id.gomdulfisico_dul);

        Textalgodonmod1_dul = (EditText) findViewById(R.id.algodonmod1_dul);
        Textalgodonmod2_dul = (EditText) findViewById(R.id.algodonmod2_dul);
        Textalgodonmod3_dul = (EditText) findViewById(R.id.algodonmod3_dul);
        Textalgodonmod4_dul = (EditText) findViewById(R.id.algodonmod4_dul);
        Textalgodonfisico_dul = (EditText) findViewById(R.id.algodonfisico_dul);

        Textlifesavermod1_dul = (EditText) findViewById(R.id.gomlifemod1_dul);
        Textlifesavermod2_dul = (EditText) findViewById(R.id.gomlifemod2_dul);
        Textlifesavermod3_dul = (EditText) findViewById(R.id.gomlifemod3_dul);
        Textlifesavermod4_dul = (EditText) findViewById(R.id.gomlifemod4_dul);
        Textlifesaverfisico_dul = (EditText) findViewById(R.id.gomlifefisico_dul);

        Textpouchmod1_dul = (EditText) findViewById(R.id.sktpunchmod1_dul);
        Textpouchmod2_dul = (EditText) findViewById(R.id.sktpunchmod2_dul);
        Textpouchmod3_dul = (EditText) findViewById(R.id.sktpunchmod3_dul);
        Textpouchmod4_dul = (EditText) findViewById(R.id.sktpunchmod4_dul);
        Textpouchfisico_dul = (EditText) findViewById(R.id.sktpunchfisico_dul);

        Textchocolatevipmod1_dul = (EditText) findViewById(R.id.mmcafecompmod1_dul);
        Textchocolatevipmod2_dul = (EditText) findViewById(R.id.mmcafecompmod2_dul);
        Textchocolatevipmod3_dul = (EditText) findViewById(R.id.mmcafecompmod3_dul);
        Textchocolatevipmod4_dul = (EditText) findViewById(R.id.mmcafecompmod4_dul);
        Textchocolatevipfisico_dul = (EditText) findViewById(R.id.mmcafecompfisico_dul);

        Textcacahuatevipmod1_dul = (EditText) findViewById(R.id.mmamarillocompmod1_dul);
        Textcacahuatevipmod2_dul = (EditText) findViewById(R.id.mmamarillocompmod2_dul);
        Textcacahuatevipmod3_dul = (EditText) findViewById(R.id.mmamarillocompmod3_dul);
        Textcacahuatevipmod4_dul = (EditText) findViewById(R.id.mmamarillocompmod4_dul);
        Textcacahuatevipfisico_dul = (EditText) findViewById(R.id.mmamarillocompfisico_dul);


        //Hacemos referencia al dialogo de progreso
        progressDialog = new ProgressDialog(this);

        //Hacemos referencia al botón
        BotonGenerarvalores = (Button) findViewById(R.id.generarvaloresvitrina_dul);
        BotonMostrarvalores = (Button) findViewById(R.id.mostrarvaloresvitrina_dul);

        //Listener de los botones
        BotonGenerarvalores.setOnClickListener(this);
        BotonMostrarvalores.setOnClickListener(this);

        //Guardar las preferencias automáticamente en caso de cerrar la aplicación por accidente
        Textkitkat4mod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textkitkat4mod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textkitkat4mod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textkitkat4mod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textkitkat4mod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textkitkat4mod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textkitkat4mod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textkitkat4mod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheycookiesmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheycookiesmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheycookiesmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheycookiesmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheycookiesmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheycookiesmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheycookiesmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheycookiesmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheyalmendrasmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheyalmendrasmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheyalmendrasmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheyalmendrasmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheyalmendrasmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheyalmendrasmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Texthersheyalmendrasmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Texthersheyalmendrasmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcruchmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcruchmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcruchmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcruchmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcruchmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcruchmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcruchmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcruchmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskrmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskrmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskrmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskrmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskrmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskrmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskrmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskrmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsksmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsksmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsksmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsksmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsksmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsksmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsksmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsksmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcaramelmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcaramelmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcaramelmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcaramelmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcaramelmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcaramelmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcaramelmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcaramelmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsandiamod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsandiamod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsandiamod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsandiamod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsandiamod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsandiamod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsandiamod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsandiamod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textfrutasmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textfrutasmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textfrutasmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textfrutasmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textfrutasmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textfrutasmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textfrutasmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textfrutasmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatemod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatemod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatemod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatemod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatemod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatemod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatemod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatemod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textamarillomod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textamarillomod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textamarillomod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textamarillomod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textamarillomod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textamarillomod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textamarillomod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textamarillomod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcafemod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcafemod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcafemod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcafemod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcafemod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcafemod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcafemod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcafemod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textponponsmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textponponsmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textponponsmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textponponsmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textponponsmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textponponsmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textponponsmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textponponsmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsnickersmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsnickersmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsnickersmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsnickersmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsnickersmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsnickersmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textsnickersmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textsnickersmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonazomod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonazomod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonazomod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonazomod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonazomod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonazomod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonazomod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonazomod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmangomod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmangomod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmangomod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmangomod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmangomod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmangomod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textmangomod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textmangomod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonetemod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonetemod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonetemod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonetemod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonetemod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonetemod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpelonetemod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpelonetemod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textnerdsmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textnerdsmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textnerdsmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textnerdsmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textnerdsmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textnerdsmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textnerdsmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textnerdsmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskittlesmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskittlesmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskittlesmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskittlesmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskittlesmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskittlesmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textskittlesmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textskittlesmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textgomitasmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textgomitasmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textgomitasmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textgomitasmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textgomitasmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textgomitasmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textgomitasmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textgomitasmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textalgodonmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textalgodonmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textalgodonmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textalgodonmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textalgodonmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textalgodonmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textalgodonmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textalgodonmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textlifesavermod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textlifesavermod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textlifesavermod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textlifesavermod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textlifesavermod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textlifesavermod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textlifesavermod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textlifesavermod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpouchmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpouchmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpouchmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpouchmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpouchmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpouchmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textpouchmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textpouchmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatevipmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatevipmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatevipmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatevipmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatevipmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatevipmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textchocolatevipmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textchocolatevipmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcacahuatevipmod1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcacahuatevipmod1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcacahuatevipmod2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcacahuatevipmod2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcacahuatevipmod3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcacahuatevipmod3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        Textcacahuatevipmod4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && Textcacahuatevipmod4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacioneskitkat(){
        //Obtenemos datos
        final String modulo1 = Textkitkat4mod1_dul.getText().toString().trim();
        final String modulo2 = Textkitkat4mod2_dul.getText().toString().trim();
        final String modulo3 = Textkitkat4mod3_dul.getText().toString().trim();
        final String modulo4 = Textkitkat4mod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Kit Kat 4", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Kit Kat 4", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Kit Kat 4", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Kit Kat 4", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textkitkat4fisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",11345, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacioneshersheycookies(){
        //Obtenemos datos
        final String modulo1 = Texthersheycookiesmod1_dul.getText().toString().trim();
        final String modulo2 = Texthersheycookiesmod2_dul.getText().toString().trim();
        final String modulo3 = Texthersheycookiesmod3_dul.getText().toString().trim();
        final String modulo4 = Texthersheycookiesmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Cookies", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Cookies", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Cookies", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Cookies", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Texthersheycookiesfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",202, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacioneshersheyalmendras(){
        //Obtenemos datos
        final String modulo1 = Texthersheyalmendrasmod1_dul.getText().toString().trim();
        final String modulo2 = Texthersheyalmendrasmod2_dul.getText().toString().trim();
        final String modulo3 = Texthersheyalmendrasmod3_dul.getText().toString().trim();
        final String modulo4 = Texthersheyalmendrasmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Almendras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Almendras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Almendras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Hershey Almendras", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Texthersheyalmendrasfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",204, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionescrunch(){
        //Obtenemos datos
        final String modulo1 = Textcruchmod1_dul.getText().toString().trim();
        final String modulo2 = Textcruchmod2_dul.getText().toString().trim();
        final String modulo3 = Textcruchmod3_dul.getText().toString().trim();
        final String modulo4 = Textcruchmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Crunch", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Crunch", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Crunch", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Crunch", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcruchfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",207, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesskwinklesrellenos(){
        //Obtenemos datos
        final String modulo1 = Textskrmod1_dul.getText().toString().trim();
        final String modulo2 = Textskrmod2_dul.getText().toString().trim();
        final String modulo3 = Textskrmod3_dul.getText().toString().trim();
        final String modulo4 = Textskrmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Rellenos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Rellenos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Rellenos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Rellenos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textskrfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",13125, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesskwinklessalsagueti(){
        //Obtenemos datos
        final String modulo1 = Textsksmod1_dul.getText().toString().trim();
        final String modulo2 = Textsksmod2_dul.getText().toString().trim();
        final String modulo3 = Textsksmod3_dul.getText().toString().trim();
        final String modulo4 = Textsksmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Salsaguetti", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Salsaguetti", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Salsaguetti", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Skwinkles Salsaguetti", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textsksfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",13126, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmmcaramel(){
        //Obtenemos datos
        final String modulo1 = Textcaramelmod1_dul.getText().toString().trim();
        final String modulo2 = Textcaramelmod2_dul.getText().toString().trim();
        final String modulo3 = Textcaramelmod3_dul.getText().toString().trim();
        final String modulo4 = Textcaramelmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Caramel", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Caramel", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Caramel", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Caramel", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcaramelfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",13798, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesbolitassandia(){
        //Obtenemos datos
        final String modulo1 = Textsandiamod1_dul.getText().toString().trim();
        final String modulo2 = Textsandiamod2_dul.getText().toString().trim();
        final String modulo3 = Textsandiamod3_dul.getText().toString().trim();
        final String modulo4 = Textsandiamod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Sandía", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Sandía", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Sandía", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Sandía", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textsandiafisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",1757, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesfrutas(){
        //Obtenemos datos
        final String modulo1 = Textfrutasmod1_dul.getText().toString().trim();
        final String modulo2 = Textfrutasmod2_dul.getText().toString().trim();
        final String modulo3 = Textfrutasmod3_dul.getText().toString().trim();
        final String modulo4 = Textfrutasmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Frutas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Frutas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Frutas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Frutas", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textfrutasfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",1758, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacioneschocolate(){
        //Obtenemos datos
        final String modulo1 = Textchocolatemod1_dul.getText().toString().trim();
        final String modulo2 = Textchocolatemod2_dul.getText().toString().trim();
        final String modulo3 = Textchocolatemod3_dul.getText().toString().trim();
        final String modulo4 = Textchocolatemod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Chocolate", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Chocolate", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Chocolate", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Malvavisco Chocolate", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textchocolatefisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",1759, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmmamarillo(){
        //Obtenemos datos
        final String modulo1 = Textamarillomod1_dul.getText().toString().trim();
        final String modulo2 = Textamarillomod2_dul.getText().toString().trim();
        final String modulo3 = Textamarillomod3_dul.getText().toString().trim();
        final String modulo4 = Textamarillomod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Amarillo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Amarillo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Amarillo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Amarillo", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textamarillofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",216, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmmcafe(){
        //Obtenemos datos
        final String modulo1 = Textcafemod1_dul.getText().toString().trim();
        final String modulo2 = Textcafemod2_dul.getText().toString().trim();
        final String modulo3 = Textcafemod3_dul.getText().toString().trim();
        final String modulo4 = Textcafemod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cafe", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cafe", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cafe", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cafe", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcafefisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",220, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesponpons(){
        //Obtenemos datos
        final String modulo1 = Textponponsmod1_dul.getText().toString().trim();
        final String modulo2 = Textponponsmod2_dul.getText().toString().trim();
        final String modulo3 = Textponponsmod3_dul.getText().toString().trim();
        final String modulo4 = Textponponsmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Ponpons", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Ponpons", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Ponpons", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Ponpons", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textponponsfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",224, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionessnickers(){
        //Obtenemos datos
        final String modulo1 = Textsnickersmod1_dul.getText().toString().trim();
        final String modulo2 = Textsnickersmod2_dul.getText().toString().trim();
        final String modulo3 = Textsnickersmod3_dul.getText().toString().trim();
        final String modulo4 = Textsnickersmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Snickers", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Snickers", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Snickers", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Snickers", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textsnickersfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",234, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespelonazo(){
        //Obtenemos datos
        final String modulo1 = Textpelonazomod1_dul.getText().toString().trim();
        final String modulo2 = Textpelonazomod2_dul.getText().toString().trim();
        final String modulo3 = Textpelonazomod3_dul.getText().toString().trim();
        final String modulo4 = Textpelonazomod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonazo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonazo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonazo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonazo", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textpelonazofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",241, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmango(){
        //Obtenemos datos
        final String modulo1 = Textmangomod1_dul.getText().toString().trim();
        final String modulo2 = Textmangomod2_dul.getText().toString().trim();
        final String modulo3 = Textmangomod3_dul.getText().toString().trim();
        final String modulo4 = Textmangomod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Mango", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Mango", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Mango", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Bolitas Mango", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textmangofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",2513, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespelonete(){
        //Obtenemos datos
        final String modulo1 = Textpelonetemod1_dul.getText().toString().trim();
        final String modulo2 = Textpelonetemod2_dul.getText().toString().trim();
        final String modulo3 = Textpelonetemod3_dul.getText().toString().trim();
        final String modulo4 = Textpelonetemod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonete", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonete", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonete", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Pelonete", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textpelonetefisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",253, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesnerds(){
        //Obtenemos datos
        final String modulo1 = Textnerdsmod1_dul.getText().toString().trim();
        final String modulo2 = Textnerdsmod2_dul.getText().toString().trim();
        final String modulo3 = Textnerdsmod3_dul.getText().toString().trim();
        final String modulo4 = Textnerdsmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Nerds", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Nerds", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Nerds", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Nerds", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textnerdsfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",261, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesskittles(){
        //Obtenemos datos
        final String modulo1 = Textskittlesmod1_dul.getText().toString().trim();
        final String modulo2 = Textskittlesmod2_dul.getText().toString().trim();
        final String modulo3 = Textskittlesmod3_dul.getText().toString().trim();
        final String modulo4 = Textskittlesmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Grandes", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Grandes", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Grandes", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Grandes", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textskittlesfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",6241, existenciafisica);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesgomitas(){
        //Obtenemos datos
        final String modulo1 = Textgomitasmod1_dul.getText().toString().trim();
        final String modulo2 = Textgomitasmod2_dul.getText().toString().trim();
        final String modulo3 = Textgomitasmod3_dul.getText().toString().trim();
        final String modulo4 = Textgomitasmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Dulcipolis", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Dulcipolis", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Dulcipolis", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Dulcipolis", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textgomitasfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",7378, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesalgodon(){
        //Obtenemos datos
        final String modulo1 = Textalgodonmod1_dul.getText().toString().trim();
        final String modulo2 = Textalgodonmod2_dul.getText().toString().trim();
        final String modulo3 = Textalgodonmod3_dul.getText().toString().trim();
        final String modulo4 = Textalgodonmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Algodón de Azúcar", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Algodón de Azúcar", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Algodón de Azúcar", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Algodón de Azúcar", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textalgodonfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",10790, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacioneslifesaver(){
        //Obtenemos datos
        final String modulo1 = Textlifesavermod1_dul.getText().toString().trim();
        final String modulo2 = Textlifesavermod2_dul.getText().toString().trim();
        final String modulo3 = Textlifesavermod3_dul.getText().toString().trim();
        final String modulo4 = Textlifesavermod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Lifesaver", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Lifesaver", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Lifesaver", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Gomitas Lifesaver", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textlifesaverfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",15095, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespouch(){
        //Obtenemos datos
        final String modulo1 = Textpouchmod1_dul.getText().toString().trim();
        final String modulo2 = Textpouchmod2_dul.getText().toString().trim();
        final String modulo3 = Textpouchmod3_dul.getText().toString().trim();
        final String modulo4 = Textpouchmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Pouch", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Pouch", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Pouch", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Skittles Pouch", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textpouchfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",13122, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmmchocolate(){
        //Obtenemos datos
        final String modulo1 = Textchocolatevipmod1_dul.getText().toString().trim();
        final String modulo2 = Textchocolatevipmod2_dul.getText().toString().trim();
        final String modulo3 = Textchocolatevipmod3_dul.getText().toString().trim();
        final String modulo4 = Textchocolatevipmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Chocolate VIP", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Chocolate VIP", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Chocolate VIP", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Chocolate VIP", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textchocolatevipfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",1033, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesmmcacahuate(){
        //Obtenemos datos
        final String modulo1 = Textcacahuatevipmod1_dul.getText().toString().trim();
        final String modulo2 = Textcacahuatevipmod2_dul.getText().toString().trim();
        final String modulo3 = Textcacahuatevipmod3_dul.getText().toString().trim();
        final String modulo4 = Textcacahuatevipmod4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cacahuate VIP", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cacahuate VIP", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cacahuate VIP", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: M&M Cacahuate VIP", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        Textcacahuatevipfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-VITRINA",1032, existenciafisica);
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
        String pccmodulo1 = Textkitkat4mod1_dul.getText().toString();
        String pccmodulo2 = Textkitkat4mod2_dul.getText().toString();
        String pccmodulo3 = Textkitkat4mod3_dul.getText().toString();
        String pccmodulo4 = Textkitkat4mod4_dul.getText().toString();

        String pmmodulo1 = Texthersheycookiesmod1_dul.getText().toString();
        String pmmodulo2 = Texthersheycookiesmod2_dul.getText().toString();
        String pmmodulo3 = Texthersheycookiesmod3_dul.getText().toString();
        String pmmodulo4 = Texthersheycookiesmod4_dul.getText().toString();

        String pgmodulo1 = Texthersheyalmendrasmod1_dul.getText().toString();
        String pgmodulo2 = Texthersheyalmendrasmod2_dul.getText().toString();
        String pgmodulo3 = Texthersheyalmendrasmod3_dul.getText().toString();
        String pgmodulo4 = Texthersheyalmendrasmod4_dul.getText().toString();

        String pjmodulo1 = Textcruchmod1_dul.getText().toString();
        String pjmodulo2 = Textcruchmod2_dul.getText().toString();
        String pjmodulo3 = Textcruchmod3_dul.getText().toString();
        String pjmodulo4 = Textcruchmod4_dul.getText().toString();

        String plmodulo1 = Textskrmod1_dul.getText().toString();
        String plmodulo2 = Textskrmod2_dul.getText().toString();
        String plmodulo3 = Textskrmod3_dul.getText().toString();
        String plmodulo4 = Textskrmod4_dul.getText().toString();

        String pcmodulo1 = Textsksmod1_dul.getText().toString();
        String pcmodulo2 = Textsksmod2_dul.getText().toString();
        String pcmodulo3 = Textsksmod3_dul.getText().toString();
        String pcmodulo4 = Textsksmod4_dul.getText().toString();

        String vcmodulo1 = Textcaramelmod1_dul.getText().toString();
        String vcmodulo2 = Textcaramelmod2_dul.getText().toString();
        String vcmodulo3 = Textcaramelmod3_dul.getText().toString();
        String vcmodulo4 = Textcaramelmod4_dul.getText().toString();

        String vmmodulo1 = Textsandiamod1_dul.getText().toString();
        String vmmodulo2 = Textsandiamod2_dul.getText().toString();
        String vmmodulo3 = Textsandiamod3_dul.getText().toString();
        String vmmodulo4 = Textsandiamod4_dul.getText().toString();

        String vgmodulo1 = Textfrutasmod1_dul.getText().toString();
        String vgmodulo2 = Textfrutasmod2_dul.getText().toString();
        String vgmodulo3 = Textfrutasmod3_dul.getText().toString();
        String vgmodulo4 = Textfrutasmod4_dul.getText().toString();

        String vjmodulo1 = Textchocolatemod1_dul.getText().toString();
        String vjmodulo2 = Textchocolatemod2_dul.getText().toString();
        String vjmodulo3 = Textchocolatemod3_dul.getText().toString();
        String vjmodulo4 = Textchocolatemod4_dul.getText().toString();

        String vimodulo1 = Textamarillomod1_dul.getText().toString();
        String vimodulo2 = Textamarillomod2_dul.getText().toString();
        String vimodulo3 = Textamarillomod3_dul.getText().toString();
        String vimodulo4 = Textamarillomod4_dul.getText().toString();

        String amodulo1 = Textcafemod1_dul.getText().toString();
        String amodulo2 = Textcafemod2_dul.getText().toString();
        String amodulo3 = Textcafemod3_dul.getText().toString();
        String amodulo4 = Textcafemod4_dul.getText().toString();

        String bmodulo1 = Textponponsmod1_dul.getText().toString();
        String bmodulo2 = Textponponsmod2_dul.getText().toString();
        String bmodulo3 = Textponponsmod3_dul.getText().toString();
        String bmodulo4 = Textponponsmod4_dul.getText().toString();

        String cmodulo1 = Textsnickersmod1_dul.getText().toString();
        String cmodulo2 = Textsnickersmod2_dul.getText().toString();
        String cmodulo3 = Textsnickersmod3_dul.getText().toString();
        String cmodulo4 = Textsnickersmod4_dul.getText().toString();

        String dmodulo1 = Textpelonazomod1_dul.getText().toString();
        String dmodulo2 = Textpelonazomod2_dul.getText().toString();
        String dmodulo3 = Textpelonazomod3_dul.getText().toString();
        String dmodulo4 = Textpelonazomod4_dul.getText().toString();

        String emodulo1 = Textmangomod1_dul.getText().toString();
        String emodulo2 = Textmangomod2_dul.getText().toString();
        String emodulo3 = Textmangomod3_dul.getText().toString();
        String emodulo4 = Textmangomod4_dul.getText().toString();

        String fmodulo1 = Textpelonetemod1_dul.getText().toString();
        String fmodulo2 = Textpelonetemod2_dul.getText().toString();
        String fmodulo3 = Textpelonetemod3_dul.getText().toString();
        String fmodulo4 = Textpelonetemod4_dul.getText().toString();

        String gmodulo1 = Textnerdsmod1_dul.getText().toString();
        String gmodulo2 = Textnerdsmod2_dul.getText().toString();
        String gmodulo3 = Textnerdsmod3_dul.getText().toString();
        String gmodulo4 = Textnerdsmod4_dul.getText().toString();

        String hmodulo1 = Textskittlesmod1_dul.getText().toString();
        String hmodulo2 = Textskittlesmod2_dul.getText().toString();
        String hmodulo3 = Textskittlesmod3_dul.getText().toString();
        String hmodulo4 = Textskittlesmod4_dul.getText().toString();

        String imodulo1 = Textgomitasmod1_dul.getText().toString();
        String imodulo2 = Textgomitasmod2_dul.getText().toString();
        String imodulo3 = Textgomitasmod3_dul.getText().toString();
        String imodulo4 = Textgomitasmod4_dul.getText().toString();

        String jmodulo1 = Textalgodonmod1_dul.getText().toString();
        String jmodulo2 = Textalgodonmod2_dul.getText().toString();
        String jmodulo3 = Textalgodonmod3_dul.getText().toString();
        String jmodulo4 = Textalgodonmod4_dul.getText().toString();

        String kmodulo1 = Textlifesavermod1_dul.getText().toString();
        String kmodulo2 = Textlifesavermod2_dul.getText().toString();
        String kmodulo3 = Textlifesavermod3_dul.getText().toString();
        String kmodulo4 = Textlifesavermod4_dul.getText().toString();

        String lmodulo1 = Textpouchmod1_dul.getText().toString();
        String lmodulo2 = Textpouchmod2_dul.getText().toString();
        String lmodulo3 = Textpouchmod3_dul.getText().toString();
        String lmodulo4 = Textpouchmod4_dul.getText().toString();

        String mmodulo1 = Textchocolatevipmod1_dul.getText().toString();
        String mmodulo2 = Textchocolatevipmod2_dul.getText().toString();
        String mmodulo3 = Textchocolatevipmod3_dul.getText().toString();
        String mmodulo4 = Textchocolatevipmod4_dul.getText().toString();

        String nmodulo1 = Textcacahuatevipmod1_dul.getText().toString();
        String nmodulo2 = Textcacahuatevipmod2_dul.getText().toString();
        String nmodulo3 = Textcacahuatevipmod3_dul.getText().toString();
        String nmodulo4 = Textcacahuatevipmod4_dul.getText().toString();

        //Creamos un objeto para poder escribir en el archivo xml que creamos los datos que hemos obtenido
        SharedPreferences.Editor editor = preferences.edit();

        //Aqui estamos escribiendo los datos en el archivo xml
        editor.putString("Kit Kat modulo 1",pccmodulo1);
        editor.putString("Kit Kat modulo 2",pccmodulo2);
        editor.putString("Kit Kat modulo 3",pccmodulo3);
        editor.putString("Kit Kat modulo 4",pccmodulo4);

        editor.putString("Cookies modulo 1",pmmodulo1);
        editor.putString("Cookies modulo 2",pmmodulo2);
        editor.putString("Cookies modulo 3",pmmodulo3);
        editor.putString("Cookies modulo 4",pmmodulo4);

        editor.putString("Almendras modulo 1",pgmodulo1);
        editor.putString("Almendras modulo 2",pgmodulo2);
        editor.putString("Almendras modulo 3",pgmodulo3);
        editor.putString("Almendras modulo 4",pgmodulo4);

        editor.putString("Crunch modulo 1",pjmodulo1);
        editor.putString("Crunch modulo 2",pjmodulo2);
        editor.putString("Crunch modulo 3",pjmodulo3);
        editor.putString("Crunch modulo 4",pjmodulo4);

        editor.putString("Rellenos modulo 1",plmodulo1);
        editor.putString("Rellenos modulo 2",plmodulo2);
        editor.putString("Rellenos modulo 3",plmodulo3);
        editor.putString("Rellenos modulo 4",plmodulo4);

        editor.putString("Salsaguetti modulo 1",pcmodulo1);
        editor.putString("Salsaguetti modulo 2",pcmodulo2);
        editor.putString("Salsaguetti modulo 3",pcmodulo3);
        editor.putString("Salsaguetti modulo 4",pcmodulo4);

        editor.putString("Caramel modulo 1",vcmodulo1);
        editor.putString("Caramel modulo 2",vcmodulo2);
        editor.putString("Caramel modulo 3",vcmodulo3);
        editor.putString("Caramel modulo 4",vcmodulo4);

        editor.putString("Sandia modulo 1",vmmodulo1);
        editor.putString("Sandia modulo 2",vmmodulo2);
        editor.putString("Sandia modulo 3",vmmodulo3);
        editor.putString("Sandia modulo 4",vmmodulo4);

        editor.putString("Frutas modulo 1",vgmodulo1);
        editor.putString("Frutas modulo 2",vgmodulo2);
        editor.putString("Frutas modulo 3",vgmodulo3);
        editor.putString("Frutas modulo 4",vgmodulo4);

        editor.putString("Chocolate modulo 1",vjmodulo1);
        editor.putString("Chocolate modulo 2",vjmodulo2);
        editor.putString("Chocolate modulo 3",vjmodulo3);
        editor.putString("Chocolate modulo 4",vjmodulo4);

        editor.putString("Amarillo modulo 1",vimodulo1);
        editor.putString("Amarillo modulo 2",vimodulo2);
        editor.putString("Amarillo modulo 3",vimodulo3);
        editor.putString("Amarillo modulo 4",vimodulo4);

        editor.putString("Cafe modulo 1",amodulo1);
        editor.putString("Cafe modulo 2",amodulo2);
        editor.putString("Cafe modulo 3",amodulo3);
        editor.putString("Cafe modulo 4",amodulo4);

        editor.putString("Ponpons modulo 1",bmodulo1);
        editor.putString("Ponpons modulo 2",bmodulo2);
        editor.putString("Ponpons modulo 3",bmodulo3);
        editor.putString("Ponpons modulo 4",bmodulo4);

        editor.putString("Snickers modulo 1",cmodulo1);
        editor.putString("Snickers modulo 2",cmodulo2);
        editor.putString("Snickers modulo 3",cmodulo3);
        editor.putString("Snickers modulo 4",cmodulo4);

        editor.putString("Pelonazo modulo 1",dmodulo1);
        editor.putString("Pelonazo modulo 2",dmodulo2);
        editor.putString("Pelonazo modulo 3",dmodulo3);
        editor.putString("Pelonazo modulo 4",dmodulo4);

        editor.putString("Mango modulo 1",emodulo1);
        editor.putString("Mango modulo 2",emodulo2);
        editor.putString("Mango modulo 3",emodulo3);
        editor.putString("Mango modulo 4",emodulo4);

        editor.putString("Pelonete modulo 1",fmodulo1);
        editor.putString("Pelonete modulo 2",fmodulo2);
        editor.putString("Pelonete modulo 3",fmodulo3);
        editor.putString("Pelonete modulo 4",fmodulo4);

        editor.putString("Nerds modulo 1",gmodulo1);
        editor.putString("Nerds modulo 2",gmodulo2);
        editor.putString("Nerds modulo 3",gmodulo3);
        editor.putString("Nerds modulo 4",gmodulo4);

        editor.putString("Skittles modulo 1",hmodulo1);
        editor.putString("Skittles modulo 2",hmodulo2);
        editor.putString("Skittles modulo 3",hmodulo3);
        editor.putString("Skittles modulo 4",hmodulo4);

        editor.putString("Gomitas modulo 1",imodulo1);
        editor.putString("Gomitas modulo 2",imodulo2);
        editor.putString("Gomitas modulo 3",imodulo3);
        editor.putString("Gomitas modulo 4",imodulo4);

        editor.putString("Algodon modulo 1",jmodulo1);
        editor.putString("Algodon modulo 2",jmodulo2);
        editor.putString("Algodon modulo 3",jmodulo3);
        editor.putString("Algodon modulo 4",jmodulo4);

        editor.putString("Lifesaver modulo 1",kmodulo1);
        editor.putString("Lifesaver modulo 2",kmodulo2);
        editor.putString("Lifesaver modulo 3",kmodulo3);
        editor.putString("Lifesaver modulo 4",kmodulo4);

        editor.putString("Pouch modulo 1",lmodulo1);
        editor.putString("Pouch modulo 2",lmodulo2);
        editor.putString("Pouch modulo 3",lmodulo3);
        editor.putString("Pouch modulo 4",lmodulo4);

        editor.putString("Chocolate vip modulo 1",mmodulo1);
        editor.putString("Chocolate vip modulo 2",mmodulo2);
        editor.putString("Chocolate vip modulo 3",mmodulo3);
        editor.putString("Chocolate vip modulo 4",mmodulo4);

        editor.putString("Cacahuate vip modulo 1",nmodulo1);
        editor.putString("Cacahuate vip modulo 2",nmodulo2);
        editor.putString("Cacahuate vip modulo 3",nmodulo3);
        editor.putString("Cacahuate vip modulo 4",nmodulo4);

        editor.commit();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void cargarPreferencias() {

        //Abrimos el archivo xml que hemos creado anteriormente
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos del archivo xml
        String pccmodulo1 = preferences.getString("Kit Kat modulo 1", "No existe la información");
        String pccmodulo2 = preferences.getString("Kit Kat modulo 2", "No existe la información");
        String pccmodulo3 = preferences.getString("Kit Kat modulo 3", "No existe la información");
        String pccmodulo4 = preferences.getString("Kit Kat modulo 4", "No existe la información");

        String pmmodulo1 = preferences.getString("Cookies modulo 1","No existe la información");
        String pmmodulo2 = preferences.getString("Cookies modulo 2","No existe la información");
        String pmmodulo3 = preferences.getString("Cookies modulo 3","No existe la información");
        String pmmodulo4 = preferences.getString("Cookies modulo 4","No existe la información");

        String pgmodulo1 = preferences.getString("Almendras modulo 1","No existe la información");
        String pgmodulo2 = preferences.getString("Almendras modulo 2","No existe la información");
        String pgmodulo3 = preferences.getString("Almendras modulo 3","No existe la información");
        String pgmodulo4 = preferences.getString("Almendras modulo 4","No existe la información");

        String pjmodulo1 = preferences.getString("Crunch modulo 1","No existe la información");
        String pjmodulo2 = preferences.getString("Crunch modulo 2","No existe la información");
        String pjmodulo3 = preferences.getString("Crunch modulo 3","No existe la información");
        String pjmodulo4 = preferences.getString("Crunch modulo 4","No existe la información");

        String plmodulo1 = preferences.getString("Rellenos modulo 1","No existe la información");
        String plmodulo2 = preferences.getString("Rellenos modulo 2","No existe la información");
        String plmodulo3 = preferences.getString("Rellenos modulo 3","No existe la información");
        String plmodulo4 = preferences.getString("Rellenos modulo 4","No existe la información");

        String pcmodulo1 = preferences.getString("Salsaguetti modulo 1","No existe la información");
        String pcmodulo2 = preferences.getString("Salsaguetti modulo 2","No existe la información");
        String pcmodulo3 = preferences.getString("Salsaguetti modulo 3","No existe la información");
        String pcmodulo4 = preferences.getString("Salsaguetti modulo 4","No existe la información");

        String vcmodulo1 = preferences.getString("Caramel modulo 1","No existe la información");
        String vcmodulo2 = preferences.getString("Caramel modulo 2","No existe la información");
        String vcmodulo3 = preferences.getString("Caramel modulo 3","No existe la información");
        String vcmodulo4 = preferences.getString("Caramel modulo 4","No existe la información");

        String vmmodulo1 = preferences.getString("Sandia modulo 1","No existe la información");
        String vmmodulo2 = preferences.getString("Sandia modulo 2","No existe la información");
        String vmmodulo3 = preferences.getString("Sandia modulo 3","No existe la información");
        String vmmodulo4 = preferences.getString("Sandia modulo 4","No existe la información");

        String vgmodulo1 = preferences.getString("Frutas modulo 1","No existe la información");
        String vgmodulo2 = preferences.getString("Frutas modulo 2","No existe la información");
        String vgmodulo3 = preferences.getString("Frutas modulo 3","No existe la información");
        String vgmodulo4 = preferences.getString("Frutas modulo 4","No existe la información");

        String vjmodulo1 = preferences.getString("Chocolate modulo 1","No existe la información");
        String vjmodulo2 = preferences.getString("Chocolate modulo 2","No existe la información");
        String vjmodulo3 = preferences.getString("Chocolate modulo 3","No existe la información");
        String vjmodulo4 = preferences.getString("Chocolate modulo 4","No existe la información");

        String vimodulo1 = preferences.getString("Amarillo modulo 1","No existe la información");
        String vimodulo2 = preferences.getString("Amarillo modulo 2","No existe la información");
        String vimodulo3 = preferences.getString("Amarillo modulo 3","No existe la información");
        String vimodulo4 = preferences.getString("Amarillo modulo 4","No existe la información");

        String amodulo1 = preferences.getString("Cafe modulo 1","No existe la información");
        String amodulo2 = preferences.getString("Cafe modulo 2","No existe la información");
        String amodulo3 = preferences.getString("Cafe modulo 3","No existe la información");
        String amodulo4 = preferences.getString("Cafe modulo 4","No existe la información");

        String bmodulo1 = preferences.getString("Ponpons modulo 1","No existe la información");
        String bmodulo2 = preferences.getString("Ponpons modulo 2","No existe la información");
        String bmodulo3 = preferences.getString("Ponpons modulo 3","No existe la información");
        String bmodulo4 = preferences.getString("Ponpons modulo 4","No existe la información");

        String cmodulo1 = preferences.getString("Snickers modulo 1","No existe la información");
        String cmodulo2 = preferences.getString("Snickers modulo 2","No existe la información");
        String cmodulo3 = preferences.getString("Snickers modulo 3","No existe la información");
        String cmodulo4 = preferences.getString("Snickers modulo 4","No existe la información");

        String dmodulo1 = preferences.getString("Pelonazo modulo 1","No existe la información");
        String dmodulo2 = preferences.getString("Pelonazo modulo 2","No existe la información");
        String dmodulo3 = preferences.getString("Pelonazo modulo 3","No existe la información");
        String dmodulo4 = preferences.getString("Pelonazo modulo 4","No existe la información");

        String emodulo1 = preferences.getString("Mango modulo 1","No existe la información");
        String emodulo2 = preferences.getString("Mango modulo 2","No existe la información");
        String emodulo3 = preferences.getString("Mango modulo 3","No existe la información");
        String emodulo4 = preferences.getString("Mango modulo 4","No existe la información");

        String fmodulo1 = preferences.getString("Pelonete modulo 1","No existe la información");
        String fmodulo2 = preferences.getString("Pelonete modulo 2","No existe la información");
        String fmodulo3 = preferences.getString("Pelonete modulo 3","No existe la información");
        String fmodulo4 = preferences.getString("Pelonete modulo 4","No existe la información");

        String gmodulo1 = preferences.getString("Nerds modulo 1","No existe la información");
        String gmodulo2 = preferences.getString("Nerds modulo 2","No existe la información");
        String gmodulo3 = preferences.getString("Nerds modulo 3","No existe la información");
        String gmodulo4 = preferences.getString("Nerds modulo 4","No existe la información");

        String hmodulo1 = preferences.getString("Skittles modulo 1","No existe la información");
        String hmodulo2 = preferences.getString("Skittles modulo 2","No existe la información");
        String hmodulo3 = preferences.getString("Skittles modulo 3","No existe la información");
        String hmodulo4 = preferences.getString("Skittles modulo 4","No existe la información");

        String imodulo1 = preferences.getString("Gomitas modulo 1","No existe la información");
        String imodulo2 = preferences.getString("Gomitas modulo 2","No existe la información");
        String imodulo3 = preferences.getString("Gomitas modulo 3","No existe la información");
        String imodulo4 = preferences.getString("Gomitas modulo 4","No existe la información");

        String jmodulo1 = preferences.getString("Algodon modulo 1","No existe la información");
        String jmodulo2 = preferences.getString("Algodon modulo 2","No existe la información");
        String jmodulo3 = preferences.getString("Algodon modulo 3","No existe la información");
        String jmodulo4 = preferences.getString("Algodon modulo 4","No existe la información");

        String kmodulo1 = preferences.getString("Lifesaver modulo 1","No existe la información");
        String kmodulo2 = preferences.getString("Lifesaver modulo 2","No existe la información");
        String kmodulo3 = preferences.getString("Lifesaver modulo 3","No existe la información");
        String kmodulo4 = preferences.getString("Lifesaver modulo 4","No existe la información");

        String lmodulo1 = preferences.getString("Pouch modulo 1","No existe la información");
        String lmodulo2 = preferences.getString("Pouch modulo 2","No existe la información");
        String lmodulo3 = preferences.getString("Pouch modulo 3","No existe la información");
        String lmodulo4 = preferences.getString("Pouch modulo 4","No existe la información");

        String mmodulo1 = preferences.getString("Chocolate vip modulo 1","No existe la información");
        String mmodulo2 = preferences.getString("Chocolate vip modulo 2","No existe la información");
        String mmodulo3 = preferences.getString("Chocolate vip modulo 3","No existe la información");
        String mmodulo4 = preferences.getString("Chocolate vip modulo 4","No existe la información");

        String nmodulo1 = preferences.getString("Cacahuate vip modulo 1","No existe la información");
        String nmodulo2 = preferences.getString("Cacahuate vip modulo 2","No existe la información");
        String nmodulo3 = preferences.getString("Cacahuate vip modulo 3","No existe la información");
        String nmodulo4 = preferences.getString("Cacahuate vip modulo 4","No existe la información");



        //Mandamos a las cajas de texto los datos obtenidos del archivo xml
        Textkitkat4mod1_dul.setText(pccmodulo1);
        Textkitkat4mod2_dul.setText(pccmodulo2);
        Textkitkat4mod3_dul.setText(pccmodulo3);
        Textkitkat4mod4_dul.setText(pccmodulo4);

        Texthersheycookiesmod1_dul.setText(pmmodulo1);
        Texthersheycookiesmod2_dul.setText(pmmodulo2);
        Texthersheycookiesmod3_dul.setText(pmmodulo3);
        Texthersheycookiesmod4_dul.setText(pmmodulo4);

        Texthersheyalmendrasmod1_dul.setText(pgmodulo1);
        Texthersheyalmendrasmod2_dul.setText(pgmodulo2);
        Texthersheyalmendrasmod3_dul.setText(pgmodulo3);
        Texthersheyalmendrasmod4_dul.setText(pgmodulo4);

        Textcruchmod1_dul.setText(pjmodulo1);
        Textcruchmod2_dul.setText(pjmodulo2);
        Textcruchmod3_dul.setText(pjmodulo3);
        Textcruchmod4_dul.setText(pjmodulo4);

        Textskrmod1_dul.setText(plmodulo1);
        Textskrmod2_dul.setText(plmodulo2);
        Textskrmod3_dul.setText(plmodulo3);
        Textskrmod4_dul.setText(plmodulo4);

        Textsksmod1_dul.setText(pcmodulo1);
        Textsksmod2_dul.setText(pcmodulo2);
        Textsksmod3_dul.setText(pcmodulo3);
        Textsksmod4_dul.setText(pcmodulo4);

        Textcaramelmod1_dul.setText(vcmodulo1);
        Textcaramelmod2_dul.setText(vcmodulo2);
        Textcaramelmod3_dul.setText(vcmodulo3);
        Textcaramelmod4_dul.setText(vcmodulo4);

        Textsandiamod1_dul.setText(vmmodulo1);
        Textsandiamod2_dul.setText(vmmodulo2);
        Textsandiamod3_dul.setText(vmmodulo3);
        Textsandiamod4_dul.setText(vmmodulo4);

        Textfrutasmod1_dul.setText(vgmodulo1);
        Textfrutasmod2_dul.setText(vgmodulo2);
        Textfrutasmod3_dul.setText(vgmodulo3);
        Textfrutasmod4_dul.setText(vgmodulo4);

        Textchocolatemod1_dul.setText(vjmodulo1);
        Textchocolatemod2_dul.setText(vjmodulo2);
        Textchocolatemod3_dul.setText(vjmodulo3);
        Textchocolatemod4_dul.setText(vjmodulo4);

        Textamarillomod1_dul.setText(vimodulo1);
        Textamarillomod2_dul.setText(vimodulo2);
        Textamarillomod3_dul.setText(vimodulo3);
        Textamarillomod4_dul.setText(vimodulo4);

        Textcafemod1_dul.setText(amodulo1);
        Textcafemod2_dul.setText(amodulo2);
        Textcafemod3_dul.setText(amodulo3);
        Textcafemod4_dul.setText(amodulo4);

        Textponponsmod1_dul.setText(bmodulo1);
        Textponponsmod2_dul.setText(bmodulo2);
        Textponponsmod3_dul.setText(bmodulo3);
        Textponponsmod4_dul.setText(bmodulo4);

        Textsnickersmod1_dul.setText(cmodulo1);
        Textsnickersmod2_dul.setText(cmodulo2);
        Textsnickersmod3_dul.setText(cmodulo3);
        Textsnickersmod4_dul.setText(cmodulo4);

        Textpelonazomod1_dul.setText(dmodulo1);
        Textpelonazomod2_dul.setText(dmodulo2);
        Textpelonazomod3_dul.setText(dmodulo3);
        Textpelonazomod4_dul.setText(dmodulo4);

        Textmangomod1_dul.setText(emodulo1);
        Textmangomod2_dul.setText(emodulo2);
        Textmangomod3_dul.setText(emodulo3);
        Textmangomod4_dul.setText(emodulo4);

        Textpelonetemod1_dul.setText(fmodulo1);
        Textpelonetemod2_dul.setText(fmodulo2);
        Textpelonetemod3_dul.setText(fmodulo3);
        Textpelonetemod4_dul.setText(fmodulo4);

        Textnerdsmod1_dul.setText(gmodulo1);
        Textnerdsmod2_dul.setText(gmodulo2);
        Textnerdsmod3_dul.setText(gmodulo3);
        Textnerdsmod4_dul.setText(gmodulo4);

        Textskittlesmod1_dul.setText(hmodulo1);
        Textskittlesmod2_dul.setText(hmodulo2);
        Textskittlesmod3_dul.setText(hmodulo3);
        Textskittlesmod4_dul.setText(hmodulo4);

        Textgomitasmod1_dul.setText(imodulo1);
        Textgomitasmod2_dul.setText(imodulo2);
        Textgomitasmod3_dul.setText(imodulo3);
        Textgomitasmod4_dul.setText(imodulo4);

        Textalgodonmod1_dul.setText(jmodulo1);
        Textalgodonmod2_dul.setText(jmodulo2);
        Textalgodonmod3_dul.setText(jmodulo3);
        Textalgodonmod4_dul.setText(jmodulo4);

        Textlifesavermod1_dul.setText(kmodulo1);
        Textlifesavermod2_dul.setText(kmodulo2);
        Textlifesavermod3_dul.setText(kmodulo3);
        Textlifesavermod4_dul.setText(kmodulo4);

        Textpouchmod1_dul.setText(lmodulo1);
        Textpouchmod2_dul.setText(lmodulo2);
        Textpouchmod3_dul.setText(lmodulo3);
        Textpouchmod4_dul.setText(lmodulo4);

        Textchocolatevipmod1_dul.setText(mmodulo1);
        Textchocolatevipmod2_dul.setText(mmodulo2);
        Textchocolatevipmod3_dul.setText(mmodulo3);
        Textchocolatevipmod4_dul.setText(mmodulo4);

        Textcacahuatevipmod1_dul.setText(nmodulo1);
        Textcacahuatevipmod2_dul.setText(nmodulo2);
        Textcacahuatevipmod3_dul.setText(nmodulo3);
        Textcacahuatevipmod4_dul.setText(nmodulo4);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.generarvaloresvitrina_dul:
                //Mandar mensaje en pantalla que se están realizando las operaciones
                progressDialog.setMessage("Realizando operaciones, espere un momento...");
                progressDialog.show();

                //Invocamos los métodos
                operacioneskitkat();
                operacioneshersheycookies();
                operacioneshersheyalmendras();
                operacionescrunch();
                operacionesskwinklesrellenos();
                operacionesskwinklessalsagueti();
                operacionesmmcaramel();
                operacionesbolitassandia();
                operacionesfrutas();
                operacioneschocolate();
                operacionesmmamarillo();
                operacionesmmcafe();
                operacionesponpons();
                operacionessnickers();
                operacionespelonazo();
                operacionesmango();
                operacionespelonete();
                operacionesnerds();
                operacionesskittles();
                operacionesgomitas();
                operacionesalgodon();
                operacioneslifesaver();
                operacionespouch();
                operacionesmmchocolate();
                operacionesmmcacahuate();

                //Guardamos preferencias
                guardarPreferencias();

                //Dejamos de mostrar en pantalla el cuadro de dialogo de progreso
                progressDialog.dismiss();

                break;

            case R.id.mostrarvaloresvitrina_dul:

                //Invocamos al método
                cargarPreferencias();

                break;
        }
    }
}
