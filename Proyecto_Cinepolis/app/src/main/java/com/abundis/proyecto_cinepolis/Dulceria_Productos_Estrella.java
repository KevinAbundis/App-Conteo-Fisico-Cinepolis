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
    private EditText TextPalomitaschica1_dul, TextPalomitaschica2_dul, TextPalomitaschica3_dul,TextPalomitaschica4_dul, TextPalomitaschicafisico_dul;
    private EditText TextPalomitasmedianas1_dul, TextPalomitasmedianas2_dul, TextPalomitasmedianas3_dul,TextPalomitasmedianas4_dul, TextPalomitasmedianasfisico_dul;
    private EditText TextPalomitasgrandes1_dul, TextPalomitasgrandes2_dul, TextPalomitasgrandes3_dul,TextPalomitasgrandes4_dul, TextPalomitasgrandesfisico_dul;
    private EditText TextPalomitasjumbo1_dul, TextPalomitasjumbo2_dul, TextPalomitasjumbo3_dul,TextPalomitasjumbo4_dul, TextPalomitasjumbofisico_dul;
    private EditText TextPalomitasllevar1_dul, TextPalomitasllevar2_dul, TextPalomitasllevar3_dul,TextPalomitasllevar4_dul, TextPalomitasllevarfisico_dul;
    private EditText TextPalomitascajita1_dul, TextPalomitascajita2_dul, TextPalomitascajita3_dul,TextPalomitascajita4_dul, TextPalomitascajitafisico_dul;

    private EditText TextVasochico1_dul, TextVasochico2_dul, TextVasochico3_dul,TextVasochico4_dul, TextVasochicofisico_dul;
    private EditText TextVasomediano1_dul, TextVasomediano2_dul, TextVasomediano3_dul,TextVasomediano4_dul, TextVasomedianofisico_dul;
    private EditText TextVasogrande1_dul, TextVasogrande2_dul, TextVasogrande3_dul,TextVasogrande4_dul, TextVasograndefisico_dul;
    private EditText TextVasojumbo1_dul, TextVasojumbo2_dul, TextVasojumbo3_dul,TextVasojumbo4_dul, TextVasojumbofisico_dul;
    private EditText TextVasoicee1_dul, TextVasoicee2_dul, TextVasoicee3_dul,TextVasoicee4_dul, TextVasoiceefisico_dul;

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
        setContentView(R.layout.activity_dulceria_productos_estrella);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();


        //Hacemos referencias de los textos de entrada
        TextPalomitaschica1_dul = (EditText) findViewById(R.id.palomitaschica1_dul);
        TextPalomitaschica2_dul = (EditText) findViewById(R.id.palomitaschica2_dul);
        TextPalomitaschica3_dul = (EditText) findViewById(R.id.palomitaschica3_dul);
        TextPalomitaschica4_dul = (EditText) findViewById(R.id.palomitaschica4_dul);
        TextPalomitaschicafisico_dul = (EditText) findViewById(R.id.palomitaschicafisico_dul);

        TextPalomitasmedianas1_dul = (EditText) findViewById(R.id.palomitasmedianas1_dul);
        TextPalomitasmedianas2_dul = (EditText) findViewById(R.id.palomitasmedianas2_dul);
        TextPalomitasmedianas3_dul = (EditText) findViewById(R.id.palomitasmedianas3_dul);
        TextPalomitasmedianas4_dul = (EditText) findViewById(R.id.palomitasmedianas4_dul);
        TextPalomitasmedianasfisico_dul = (EditText) findViewById(R.id.palomitasmedianasfisico_dul);

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

        TextPalomitasllevar1_dul = (EditText) findViewById(R.id.palomitasllevar1_dul);
        TextPalomitasllevar2_dul = (EditText) findViewById(R.id.palomitasllevar2_dul);
        TextPalomitasllevar3_dul = (EditText) findViewById(R.id.palomitasllevar3_dul);
        TextPalomitasllevar4_dul = (EditText) findViewById(R.id.palomitasllevar4_dul);
        TextPalomitasllevarfisico_dul = (EditText) findViewById(R.id.palomitasllevarfisico_dul);

        TextPalomitascajita1_dul = (EditText) findViewById(R.id.palomitascajita1_dul);
        TextPalomitascajita2_dul = (EditText) findViewById(R.id.palomitascajita2_dul);
        TextPalomitascajita3_dul = (EditText) findViewById(R.id.palomitascajita3_dul);
        TextPalomitascajita4_dul = (EditText) findViewById(R.id.palomitascajita4_dul);
        TextPalomitascajitafisico_dul = (EditText) findViewById(R.id.palomitascajitafisico_dul);

        TextVasochico1_dul = (EditText) findViewById(R.id.vasochico1_dul);
        TextVasochico2_dul = (EditText) findViewById(R.id.vasochico2_dul);
        TextVasochico3_dul = (EditText) findViewById(R.id.vasochico3_dul);
        TextVasochico4_dul = (EditText) findViewById(R.id.vasochico4_dul);
        TextVasochicofisico_dul = (EditText) findViewById(R.id.vasochicofisico_dul);

        TextVasomediano1_dul = (EditText) findViewById(R.id.vasomediano1_dul);
        TextVasomediano2_dul = (EditText) findViewById(R.id.vasomediano2_dul);
        TextVasomediano3_dul = (EditText) findViewById(R.id.vasomediano3_dul);
        TextVasomediano4_dul = (EditText) findViewById(R.id.vasomediano4_dul);
        TextVasomedianofisico_dul = (EditText) findViewById(R.id.vasomedianofisico_dul);

        TextVasogrande1_dul = (EditText) findViewById(R.id.vasogrande1_dul);
        TextVasogrande2_dul = (EditText) findViewById(R.id.vasogrande2_dul);
        TextVasogrande3_dul = (EditText) findViewById(R.id.vasogrande3_dul);
        TextVasogrande4_dul = (EditText) findViewById(R.id.vasogrande4_dul);
        TextVasograndefisico_dul = (EditText) findViewById(R.id.vasograndefisico_dul);

        TextVasojumbo1_dul = (EditText) findViewById(R.id.vasojumbo1_dul);
        TextVasojumbo2_dul = (EditText) findViewById(R.id.vasojumbo2_dul);
        TextVasojumbo3_dul = (EditText) findViewById(R.id.vasojumbo3_dul);
        TextVasojumbo4_dul = (EditText) findViewById(R.id.vasojumbo4_dul);
        TextVasojumbofisico_dul = (EditText) findViewById(R.id.vasojumbofisico_dul);

        TextVasoicee1_dul = (EditText) findViewById(R.id.vasoicee1_dul);
        TextVasoicee2_dul = (EditText) findViewById(R.id.vasoicee2_dul);
        TextVasoicee3_dul = (EditText) findViewById(R.id.vasoicee3_dul);
        TextVasoicee4_dul = (EditText) findViewById(R.id.vasoicee4_dul);
        TextVasoiceefisico_dul = (EditText) findViewById(R.id.vasoiceefisico_dul);

        //Hacemos referencia al dialogo de progreso
        progressDialog = new ProgressDialog(this);

        //Hacemos referencia al botón
        BotonGenerarvalores = (Button) findViewById(R.id.generarvalores_dul_pal);
        BotonMostrarvalores = (Button) findViewById(R.id.mostrarvalores_dul_pal);

        //Listener de los botones
        BotonGenerarvalores.setOnClickListener(this);
        BotonMostrarvalores.setOnClickListener(this);

        //Guardar las preferencias automáticamente en caso de cerrar la aplicación por accidente
        TextPalomitaschica1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitaschica1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitaschica2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitaschica2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitaschica3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitaschica3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitaschica4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitaschica4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasmedianas1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasmedianas1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasmedianas2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasmedianas2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasmedianas3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasmedianas3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });


        TextPalomitasmedianas4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasmedianas4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasgrandes1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasgrandes1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasgrandes2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasgrandes2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasgrandes3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasgrandes3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasgrandes4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasgrandes4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasjumbo1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasjumbo1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasjumbo2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasjumbo2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasjumbo3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasjumbo3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasjumbo4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasjumbo4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasllevar1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasllevar1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasllevar2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasllevar2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasllevar3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasllevar3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitasllevar4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitasllevar4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitascajita1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitascajita1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitascajita2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitascajita2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitascajita3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitascajita3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextPalomitascajita4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextPalomitascajita4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasochico1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasochico1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasochico2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasochico2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasochico3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasochico3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasochico4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasochico4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });


        TextVasomediano1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasomediano1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasomediano2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasomediano2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasomediano3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasomediano3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasomediano4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasomediano4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasogrande1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasogrande1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasogrande2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasogrande2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasogrande3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasogrande3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasogrande4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasogrande4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });


        TextVasojumbo1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasojumbo1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasojumbo2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasojumbo2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasojumbo3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasojumbo3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasojumbo4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasojumbo4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasoicee1_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasoicee1_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasoicee2_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasoicee2_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasoicee3_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasoicee3_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });

        TextVasoicee4_dul.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && TextVasoicee4_dul.getText().toString() != null){
                    guardarPreferencias();
                }
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespalomitaschicas(){
        //Obtenemos datos
        final String modulo1 = TextPalomitaschica1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitaschica2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitaschica3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitaschica4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Chica", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Chica", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Chica", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Chica", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitaschicafisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",11661, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespalomitasmedianas(){
        //Obtenemos datos
        final String modulo1 = TextPalomitasmedianas1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitasmedianas2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitasmedianas3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitasmedianas4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Mediana", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Mediana", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Mediana", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Mediana", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitasmedianasfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",359, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespalomitasgrandes(){
        //Obtenemos datos
        final String modulo1 = TextPalomitasgrandes1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitasgrandes2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitasgrandes3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitasgrandes4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Grande", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitasgrandesfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",293, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespalomitasjumbo(){
        //Obtenemos datos
        final String modulo1 = TextPalomitasjumbo1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitasjumbo2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitasjumbo3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitasjumbo4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitasjumbofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",14174, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespalomitasllevar(){
        //Obtenemos datos
        final String modulo1 = TextPalomitasllevar1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitasllevar2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitasllevar3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitasllevar4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Para Llevar", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Para Llevar", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Para Llevar", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Canasta Palomitas Para Llevar", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitasllevarfisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",5622, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionespalomitascajita(){
        //Obtenemos datos
        final String modulo1 = TextPalomitascajita1_dul.getText().toString().trim();
        final String modulo2 = TextPalomitascajita2_dul.getText().toString().trim();
        final String modulo3 = TextPalomitascajita3_dul.getText().toString().trim();
        final String modulo4 = TextPalomitascajita4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Cajita Feliz Cartón", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Cajita Feliz Cartón", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Cajita Feliz Cartón", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Cajita Feliz Cartón", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextPalomitascajitafisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-PAL",456, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvasochico(){
        //Obtenemos datos
        final String modulo1 = TextVasochico1_dul.getText().toString().trim();
        final String modulo2 = TextVasochico2_dul.getText().toString().trim();
        final String modulo3 = TextVasochico3_dul.getText().toString().trim();
        final String modulo4 = TextVasochico4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Chico", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Chico", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Chico", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Chico", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextVasochicofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-BEBIDAS",438, existenciafisica);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvasomediano(){
        //Obtenemos datos
        final String modulo1 = TextVasomediano1_dul.getText().toString().trim();
        final String modulo2 = TextVasomediano2_dul.getText().toString().trim();
        final String modulo3 = TextVasomediano3_dul.getText().toString().trim();
        final String modulo4 = TextVasomediano4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Mediano", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Mediano", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Mediano", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Mediano", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextVasomedianofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-BEBIDAS",441, existenciafisica);
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvasogrande(){
        //Obtenemos datos
        final String modulo1 = TextVasogrande1_dul.getText().toString().trim();
        final String modulo2 = TextVasogrande2_dul.getText().toString().trim();
        final String modulo3 = TextVasogrande3_dul.getText().toString().trim();
        final String modulo4 = TextVasogrande4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Grande", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Grande", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextVasograndefisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-BEBIDAS",443, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvasojumbo(){
        //Obtenemos datos
        final String modulo1 = TextVasojumbo1_dul.getText().toString().trim();
        final String modulo2 = TextVasojumbo2_dul.getText().toString().trim();
        final String modulo3 = TextVasojumbo3_dul.getText().toString().trim();
        final String modulo4 = TextVasojumbo4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Refresco Jumbo", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextVasojumbofisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-BEBIDAS",392, existenciafisica);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operacionesvasoicee(){
        //Obtenemos datos
        final String modulo1 = TextVasoicee1_dul.getText().toString().trim();
        final String modulo2 = TextVasoicee2_dul.getText().toString().trim();
        final String modulo3 = TextVasoicee3_dul.getText().toString().trim();
        final String modulo4 = TextVasoicee4_dul.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(modulo1)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Icee", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo2)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Icee", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo3)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Icee", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(modulo4)){
            Toast.makeText(this, "Hay campos vacios en producto: Vaso Icee", Toast.LENGTH_SHORT).show();
            return;
        }

        //Realizamos las operaciones correspondientes
        float existenciafisica = Float.parseFloat(modulo1)+Float.parseFloat(modulo2)+Float.parseFloat(modulo3)+Float.parseFloat(modulo4);

        //Mandamos el resultado de la operación a una caja de texto
        TextVasoiceefisico_dul.setText(String.valueOf(existenciafisica));

        //Mandamos a llamar la función actualizar datos
        actualizardatos("DUL-BEBIDAS",431, existenciafisica);

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
        String pccmodulo1 = TextPalomitaschica1_dul.getText().toString();
        String pccmodulo2 = TextPalomitaschica2_dul.getText().toString();
        String pccmodulo3 = TextPalomitaschica3_dul.getText().toString();
        String pccmodulo4 = TextPalomitaschica4_dul.getText().toString();

        String pmmodulo1 = TextPalomitasmedianas1_dul.getText().toString();
        String pmmodulo2 = TextPalomitasmedianas2_dul.getText().toString();
        String pmmodulo3 = TextPalomitasmedianas3_dul.getText().toString();
        String pmmodulo4 = TextPalomitasmedianas4_dul.getText().toString();

        String pgmodulo1 = TextPalomitasgrandes1_dul.getText().toString();
        String pgmodulo2 = TextPalomitasgrandes2_dul.getText().toString();
        String pgmodulo3 = TextPalomitasgrandes3_dul.getText().toString();
        String pgmodulo4 = TextPalomitasgrandes4_dul.getText().toString();

        String pjmodulo1 = TextPalomitasjumbo1_dul.getText().toString();
        String pjmodulo2 = TextPalomitasjumbo2_dul.getText().toString();
        String pjmodulo3 = TextPalomitasjumbo3_dul.getText().toString();
        String pjmodulo4 = TextPalomitasjumbo4_dul.getText().toString();

        String plmodulo1 = TextPalomitasllevar1_dul.getText().toString();
        String plmodulo2 = TextPalomitasllevar2_dul.getText().toString();
        String plmodulo3 = TextPalomitasllevar3_dul.getText().toString();
        String plmodulo4 = TextPalomitasllevar4_dul.getText().toString();

        String pcmodulo1 = TextPalomitascajita1_dul.getText().toString();
        String pcmodulo2 = TextPalomitascajita2_dul.getText().toString();
        String pcmodulo3 = TextPalomitascajita3_dul.getText().toString();
        String pcmodulo4 = TextPalomitascajita4_dul.getText().toString();

        String vcmodulo1 = TextVasochico1_dul.getText().toString();
        String vcmodulo2 = TextVasochico2_dul.getText().toString();
        String vcmodulo3 = TextVasochico3_dul.getText().toString();
        String vcmodulo4 = TextVasochico4_dul.getText().toString();

        String vmmodulo1 = TextVasomediano1_dul.getText().toString();
        String vmmodulo2 = TextVasomediano2_dul.getText().toString();
        String vmmodulo3 = TextVasomediano3_dul.getText().toString();
        String vmmodulo4 = TextVasomediano4_dul.getText().toString();

        String vgmodulo1 = TextVasogrande1_dul.getText().toString();
        String vgmodulo2 = TextVasogrande2_dul.getText().toString();
        String vgmodulo3 = TextVasogrande3_dul.getText().toString();
        String vgmodulo4 = TextVasogrande4_dul.getText().toString();

        String vjmodulo1 = TextVasojumbo1_dul.getText().toString();
        String vjmodulo2 = TextVasojumbo2_dul.getText().toString();
        String vjmodulo3 = TextVasojumbo3_dul.getText().toString();
        String vjmodulo4 = TextVasojumbo4_dul.getText().toString();

        String vimodulo1 = TextVasoicee1_dul.getText().toString();
        String vimodulo2 = TextVasoicee2_dul.getText().toString();
        String vimodulo3 = TextVasoicee3_dul.getText().toString();
        String vimodulo4 = TextVasoicee4_dul.getText().toString();

        //Creamos un objeto para poder escribir en el archivo xml que creamos los datos que hemos obtenido
        SharedPreferences.Editor editor = preferences.edit();

        //Aqui estamos escribiendo los datos en el archivo xml
        editor.putString("Palomitas chicas modulo 1",pccmodulo1);
        editor.putString("Palomitas chicas modulo 2",pccmodulo2);
        editor.putString("Palomitas chicas modulo 3",pccmodulo3);
        editor.putString("Palomitas chicas modulo 4",pccmodulo4);

        editor.putString("Palomitas medianas modulo 1",pmmodulo1);
        editor.putString("Palomitas medianas modulo 2",pmmodulo2);
        editor.putString("Palomitas medianas modulo 3",pmmodulo3);
        editor.putString("Palomitas medianas modulo 4",pmmodulo4);

        editor.putString("Palomitas grandes modulo 1",pgmodulo1);
        editor.putString("Palomitas grandes modulo 2",pgmodulo2);
        editor.putString("Palomitas grandes modulo 3",pgmodulo3);
        editor.putString("Palomitas grandes modulo 4",pgmodulo4);

        editor.putString("Palomitas jumbo modulo 1",pjmodulo1);
        editor.putString("Palomitas jumbo modulo 2",pjmodulo2);
        editor.putString("Palomitas jumbo modulo 3",pjmodulo3);
        editor.putString("Palomitas jumbo modulo 4",pjmodulo4);

        editor.putString("Palomitas para llevar modulo 1",plmodulo1);
        editor.putString("Palomitas para llevar modulo 2",plmodulo2);
        editor.putString("Palomitas para llevar modulo 3",plmodulo3);
        editor.putString("Palomitas para llevar modulo 4",plmodulo4);

        editor.putString("Palomitas cajita feliz modulo 1",pcmodulo1);
        editor.putString("Palomitas cajita feliz modulo 2",pcmodulo2);
        editor.putString("Palomitas cajita feliz modulo 3",pcmodulo3);
        editor.putString("Palomitas cajita feliz modulo 4",pcmodulo4);

        editor.putString("Vaso chico modulo 1",vcmodulo1);
        editor.putString("Vaso chico modulo 2",vcmodulo2);
        editor.putString("Vaso chico modulo 3",vcmodulo3);
        editor.putString("Vaso chico modulo 4",vcmodulo4);

        editor.putString("Vaso mediano modulo 1",vmmodulo1);
        editor.putString("Vaso mediano modulo 2",vmmodulo2);
        editor.putString("Vaso mediano modulo 3",vmmodulo3);
        editor.putString("Vaso mediano modulo 4",vmmodulo4);

        editor.putString("Vaso grande modulo 1",vgmodulo1);
        editor.putString("Vaso grande modulo 2",vgmodulo2);
        editor.putString("Vaso grande modulo 3",vgmodulo3);
        editor.putString("Vaso grande modulo 4",vgmodulo4);

        editor.putString("Vaso jumbo modulo 1",vjmodulo1);
        editor.putString("Vaso jumbo modulo 2",vjmodulo2);
        editor.putString("Vaso jumbo modulo 3",vjmodulo3);
        editor.putString("Vaso jumbo modulo 4",vjmodulo4);

        editor.putString("Vaso icee modulo 1",vimodulo1);
        editor.putString("Vaso icee modulo 2",vimodulo2);
        editor.putString("Vaso icee modulo 3",vimodulo3);
        editor.putString("Vaso icee modulo 4",vimodulo4);

        //Toast.makeText(Dulceria_Productos_Estrella.this, "Datos: "+modulo1+","+modulo2+","+modulo3+","+modulo4, Toast.LENGTH_SHORT).show();

        editor.commit();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void cargarPreferencias(){

        //Abrimos el archivo xml que hemos creado anteriormente
        SharedPreferences preferences = getSharedPreferences
                ("Mis datos", Context.MODE_PRIVATE);

        //Obtenemos los datos del archivo xml
        String pccmodulo1 = preferences.getString("Palomitas chicas modulo 1","No existe la información");
        String pccmodulo2 = preferences.getString("Palomitas chicas modulo 2","No existe la información");
        String pccmodulo3 = preferences.getString("Palomitas chicas modulo 3","No existe la información");
        String pccmodulo4 = preferences.getString("Palomitas chicas modulo 4","No existe la información");

        String pmmodulo1 = preferences.getString("Palomitas medianas modulo 1","No existe la información");
        String pmmodulo2 = preferences.getString("Palomitas medianas modulo 2","No existe la información");
        String pmmodulo3 = preferences.getString("Palomitas medianas modulo 3","No existe la información");
        String pmmodulo4 = preferences.getString("Palomitas medianas modulo 4","No existe la información");

        String pgmodulo1 = preferences.getString("Palomitas grandes modulo 1","No existe la información");
        String pgmodulo2 = preferences.getString("Palomitas grandes modulo 2","No existe la información");
        String pgmodulo3 = preferences.getString("Palomitas grandes modulo 3","No existe la información");
        String pgmodulo4 = preferences.getString("Palomitas grandes modulo 4","No existe la información");

        String pjmodulo1 = preferences.getString("Palomitas jumbo modulo 1","No existe la información");
        String pjmodulo2 = preferences.getString("Palomitas jumbo modulo 2","No existe la información");
        String pjmodulo3 = preferences.getString("Palomitas jumbo modulo 3","No existe la información");
        String pjmodulo4 = preferences.getString("Palomitas jumbo modulo 4","No existe la información");

        String plmodulo1 = preferences.getString("Palomitas para llevar modulo 1","No existe la información");
        String plmodulo2 = preferences.getString("Palomitas para llevar modulo 2","No existe la información");
        String plmodulo3 = preferences.getString("Palomitas para llevar modulo 3","No existe la información");
        String plmodulo4 = preferences.getString("Palomitas para llevar modulo 4","No existe la información");

        String pcmodulo1 = preferences.getString("Palomitas cajita feliz modulo 1","No existe la información");
        String pcmodulo2 = preferences.getString("Palomitas cajita feliz modulo 2","No existe la información");
        String pcmodulo3 = preferences.getString("Palomitas cajita feliz modulo 3","No existe la información");
        String pcmodulo4 = preferences.getString("Palomitas cajita feliz modulo 4","No existe la información");

        String vcmodulo1 = preferences.getString("Vaso chico modulo 1","No existe la información");
        String vcmodulo2 = preferences.getString("Vaso chico modulo 2","No existe la información");
        String vcmodulo3 = preferences.getString("Vaso chico modulo 3","No existe la información");
        String vcmodulo4 = preferences.getString("Vaso chico modulo 4","No existe la información");

        String vmmodulo1 = preferences.getString("Vaso mediano modulo 1","No existe la información");
        String vmmodulo2 = preferences.getString("Vaso mediano modulo 2","No existe la información");
        String vmmodulo3 = preferences.getString("Vaso mediano modulo 3","No existe la información");
        String vmmodulo4 = preferences.getString("Vaso mediano modulo 4","No existe la información");

        String vgmodulo1 = preferences.getString("Vaso grande modulo 1","No existe la información");
        String vgmodulo2 = preferences.getString("Vaso grande modulo 2","No existe la información");
        String vgmodulo3 = preferences.getString("Vaso grande modulo 3","No existe la información");
        String vgmodulo4 = preferences.getString("Vaso grande modulo 4","No existe la información");

        String vjmodulo1 = preferences.getString("Vaso jumbo modulo 1","No existe la información");
        String vjmodulo2 = preferences.getString("Vaso jumbo modulo 2","No existe la información");
        String vjmodulo3 = preferences.getString("Vaso jumbo modulo 3","No existe la información");
        String vjmodulo4 = preferences.getString("Vaso jumbo modulo 4","No existe la información");

        String vimodulo1 = preferences.getString("Vaso icee modulo 1","No existe la información");
        String vimodulo2 = preferences.getString("Vaso icee modulo 2","No existe la información");
        String vimodulo3 = preferences.getString("Vaso icee modulo 3","No existe la información");
        String vimodulo4 = preferences.getString("Vaso icee modulo 4","No existe la información");

        //Mandamos a las cajas de texto los datos obtenidos del archivo xml
        TextPalomitaschica1_dul.setText(pccmodulo1);
        TextPalomitaschica2_dul.setText(pccmodulo2);
        TextPalomitaschica3_dul.setText(pccmodulo3);
        TextPalomitaschica4_dul.setText(pccmodulo4);

        TextPalomitasmedianas1_dul.setText(pmmodulo1);
        TextPalomitasmedianas2_dul.setText(pmmodulo2);
        TextPalomitasmedianas3_dul.setText(pmmodulo3);
        TextPalomitasmedianas4_dul.setText(pmmodulo4);

        TextPalomitasgrandes1_dul.setText(pgmodulo1);
        TextPalomitasgrandes2_dul.setText(pgmodulo2);
        TextPalomitasgrandes3_dul.setText(pgmodulo3);
        TextPalomitasgrandes4_dul.setText(pgmodulo4);

        TextPalomitasjumbo1_dul.setText(pjmodulo1);
        TextPalomitasjumbo2_dul.setText(pjmodulo2);
        TextPalomitasjumbo3_dul.setText(pjmodulo3);
        TextPalomitasjumbo4_dul.setText(pjmodulo4);

        TextPalomitasllevar1_dul.setText(plmodulo1);
        TextPalomitasllevar2_dul.setText(plmodulo2);
        TextPalomitasllevar3_dul.setText(plmodulo3);
        TextPalomitasllevar4_dul.setText(plmodulo4);

        TextPalomitascajita1_dul.setText(pcmodulo1);
        TextPalomitascajita2_dul.setText(pcmodulo2);
        TextPalomitascajita3_dul.setText(pcmodulo3);
        TextPalomitascajita4_dul.setText(pcmodulo4);

        TextVasochico1_dul.setText(vcmodulo1);
        TextVasochico2_dul.setText(vcmodulo2);
        TextVasochico3_dul.setText(vcmodulo3);
        TextVasochico4_dul.setText(vcmodulo4);

        TextVasomediano1_dul.setText(vmmodulo1);
        TextVasomediano2_dul.setText(vmmodulo2);
        TextVasomediano3_dul.setText(vmmodulo3);
        TextVasomediano4_dul.setText(vmmodulo4);

        TextVasogrande1_dul.setText(vgmodulo1);
        TextVasogrande2_dul.setText(vgmodulo2);
        TextVasogrande3_dul.setText(vgmodulo3);
        TextVasogrande4_dul.setText(vgmodulo4);

        TextVasojumbo1_dul.setText(vjmodulo1);
        TextVasojumbo2_dul.setText(vjmodulo2);
        TextVasojumbo3_dul.setText(vjmodulo3);
        TextVasojumbo4_dul.setText(vjmodulo4);

        TextVasoicee1_dul.setText(vimodulo1);
        TextVasoicee2_dul.setText(vimodulo2);
        TextVasoicee3_dul.setText(vimodulo3);
        TextVasoicee4_dul.setText(vimodulo4);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.generarvalores_dul_pal:
                //Mandar mensaje en pantalla que se están realizando las operaciones
                progressDialog.setMessage("Realizando operaciones, espere un momento...");
                progressDialog.show();

                //Invocamos los métodos
                operacionespalomitaschicas();
                operacionespalomitasmedianas();
                operacionespalomitasgrandes();
                operacionespalomitasjumbo();
                operacionespalomitasllevar();
                operacionespalomitascajita();
                operacionesvasochico();
                operacionesvasomediano();
                operacionesvasogrande();
                operacionesvasojumbo();
                operacionesvasoicee();

                //Guardamos preferencias
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
