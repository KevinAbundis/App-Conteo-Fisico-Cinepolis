package com.abundis.proyecto_cinepolis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import harmony.java.awt.Color;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Menu_Dulceria extends AppCompatActivity implements View.OnClickListener{

    //Variable para dar de alta producto
    private EditText Textcategoria, Textid, Textnombre, Textunidad;



    //Variable para el archivo PDF
    private final static String NOMBRE_DIRECTORIO = "Reportes-Cinépolis";
    private final static String NOMBRE_DOCUMENTO = "Reporte-Dulceria.pdf";
    private final static String ETIQUETA_ERROR = "ERROR PDF";
    private File archivoPDF;
    Context contexto;

    //Bandera que me indica si existe el archivo PDF
    private int fPDF = 0;

    //Productos de CAFE-ENVASES
    String nombre_producto67, existencia_fisica67, unidad_medida67;
    String nombre_producto68, existencia_fisica68, unidad_medida68;
    String nombre_producto69, existencia_fisica69, unidad_medida69;
    String nombre_producto70, existencia_fisica70, unidad_medida70;
    String nombre_producto71, existencia_fisica71, unidad_medida71;
    String nombre_producto72, existencia_fisica72, unidad_medida72;
    String nombre_producto73, existencia_fisica73, unidad_medida73;


    //Productos de DUL-BEBIDAS
    String nombre_producto1, existencia_fisica1, unidad_medida1;
    String nombre_producto2, existencia_fisica2, unidad_medida2;
    String nombre_producto3, existencia_fisica3, unidad_medida3;
    String nombre_producto4, existencia_fisica4, unidad_medida4;
    String nombre_producto5, existencia_fisica5, unidad_medida5;
    String nombre_producto6, existencia_fisica6, unidad_medida6;
    String nombre_producto7, existencia_fisica7, unidad_medida7;

    //Productos DUL-GRANEL
    String nombre_producto8, existencia_fisica8, unidad_medida8;
    String nombre_producto9, existencia_fisica9, unidad_medida9;
    String nombre_producto10, existencia_fisica10, unidad_medida10;

    //Productos DUL-HD
    String nombre_producto11, existencia_fisica11, unidad_medida11;
    String nombre_producto12, existencia_fisica12, unidad_medida12;
    String nombre_producto13, existencia_fisica13, unidad_medida13;
    String nombre_producto14, existencia_fisica14, unidad_medida14;
    String nombre_producto15, existencia_fisica15, unidad_medida15;
    String nombre_producto16, existencia_fisica16, unidad_medida16;

    //Productos DUL-HELADO
    String nombre_producto17, existencia_fisica17, unidad_medida17;
    String nombre_producto18, existencia_fisica18, unidad_medida18;
    String nombre_producto19, existencia_fisica19, unidad_medida19;
    String nombre_producto20, existencia_fisica20, unidad_medida20;
    String nombre_producto21, existencia_fisica21, unidad_medida21;
    String nombre_producto22, existencia_fisica22, unidad_medida22;
    String nombre_producto23, existencia_fisica23, unidad_medida23;
    String nombre_producto24, existencia_fisica24, unidad_medida24;
    String nombre_producto25, existencia_fisica25, unidad_medida25;
    String nombre_producto26, existencia_fisica26, unidad_medida26;
    String nombre_producto27, existencia_fisica27, unidad_medida27;
    String nombre_producto28, existencia_fisica28, unidad_medida28;

    //Productos DUL-NACHOS
    String nombre_producto29, existencia_fisica29, unidad_medida29;
    String nombre_producto30, existencia_fisica30, unidad_medida30;

    //Productos DUL-PAL
    String nombre_producto31, existencia_fisica31, unidad_medida31;
    String nombre_producto32, existencia_fisica32, unidad_medida32;
    String nombre_producto33, existencia_fisica33, unidad_medida33;
    String nombre_producto34, existencia_fisica34, unidad_medida34;
    String nombre_producto35, existencia_fisica35, unidad_medida35;
    String nombre_producto36, existencia_fisica36, unidad_medida36;
    String nombre_producto37, existencia_fisica37, unidad_medida37;

    //Productos DUL-SNACK
    String nombre_producto38, existencia_fisica38, unidad_medida38;
    String nombre_producto39, existencia_fisica39, unidad_medida39;
    String nombre_producto40, existencia_fisica40, unidad_medida40;

    //Productos DUL-VITRINA
    String nombre_producto41, existencia_fisica41, unidad_medida41;
    String nombre_producto42, existencia_fisica42, unidad_medida42;
    String nombre_producto43, existencia_fisica43, unidad_medida43;
    String nombre_producto44, existencia_fisica44, unidad_medida44;
    String nombre_producto45, existencia_fisica45, unidad_medida45;

    String nombre_producto47, existencia_fisica47, unidad_medida47;
    String nombre_producto48, existencia_fisica48, unidad_medida48;
    String nombre_producto49, existencia_fisica49, unidad_medida49;
    String nombre_producto50, existencia_fisica50, unidad_medida50;
    String nombre_producto51, existencia_fisica51, unidad_medida51;
    String nombre_producto52, existencia_fisica52, unidad_medida52;
    String nombre_producto53, existencia_fisica53, unidad_medida53;
    String nombre_producto54, existencia_fisica54, unidad_medida54;
    String nombre_producto55, existencia_fisica55, unidad_medida55;
    String nombre_producto56, existencia_fisica56, unidad_medida56;
    String nombre_producto57, existencia_fisica57, unidad_medida57;
    String nombre_producto58, existencia_fisica58, unidad_medida58;
    String nombre_producto59, existencia_fisica59, unidad_medida59;
    String nombre_producto60, existencia_fisica60, unidad_medida60;
    String nombre_producto61, existencia_fisica61, unidad_medida61;
    String nombre_producto62, existencia_fisica62, unidad_medida62;
    String nombre_producto63, existencia_fisica63, unidad_medida63;
    String nombre_producto64, existencia_fisica64, unidad_medida64;
    String nombre_producto65, existencia_fisica65, unidad_medida65;
    String nombre_producto66, existencia_fisica66, unidad_medida66;


    private Button BotonGenerarReporteDulceria;
    private Button BotonRegistrarProducto;

    //Declaramos el objeto databaseReference para poder utilizar la base de datos en tiempo real de Firebase
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dulceria);

        // Permisos
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    1000);
        }

        contexto = getApplicationContext();


        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("Productos").child("Dulceria").child("DUL-BEBIDAS").child("194").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto1 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica1 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida1 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-BEBIDAS").child("392").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto2 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica2 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida2 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-BEBIDAS").child("431").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto3 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica3 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida3 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-BEBIDAS").child("4334").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto4 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica4 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida4 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-BEBIDAS").child("438").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto5 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica5 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida5 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-BEBIDAS").child("441").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto6 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica6 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida6 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-BEBIDAS").child("443").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto7 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica7 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida7 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-GRANEL").child("11717").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto8 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica8 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida8 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-GRANEL").child("11718").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto9 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica9 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida9 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-GRANEL").child("11719").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto10 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica10 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida10 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HD").child("2171").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto11 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica11 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida11 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HD").child("2172").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto12 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica12 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida12 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HD").child("377").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto13 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica13 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida13 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HD").child("384").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto14 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica14 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida14 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReference.child("Productos").child("Dulceria").child("DUL-HD").child("393").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto15 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica15 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida15 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HD").child("6245").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto16 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica16 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida16 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("10607").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto17 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica17 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida17 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("1778").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto18 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica18 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida18 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("1782").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto19 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica19 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida19 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("1783").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto20 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica20 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida20 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("1786").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto21 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica21 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida21 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("1788").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto22 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica22 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida22 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("1789").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto23 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica23 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida23 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("7272").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto24 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica24 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida24 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("7972").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto25 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica25 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida25 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("8138").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto26 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica26 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida26 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("8926").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto27 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica27 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida27 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-HELADO").child("9692").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto28 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica28 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida28 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-NACHOS").child("2104").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto29 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica29 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida29 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-NACHOS").child("412").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto30 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica30 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida30 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-PAL").child("11661").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto31 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica31 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida31 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-PAL").child("14174").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto32 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica32 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida32 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-PAL").child("293").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto33 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica33 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida33 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-PAL").child("359").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto34 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica34 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida34 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-PAL").child("452").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto35 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica35 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida35 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-PAL").child("456").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto36 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica36 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida36 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-PAL").child("5622").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto37 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica37 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida37 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-SNACK").child("15412").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto38 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica38 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida38 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-SNACK").child("1740").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto39 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica39 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida39 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-SNACK").child("1741").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto40 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica40 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida40 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("1032").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto41 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica41 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida41 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("1033").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto42 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica42 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida42 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("10790").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto43 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica43 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida43 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("11345").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto44 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica44 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida44 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("13122").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto45 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica45 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida45 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("13125").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto47 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica47 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida47 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("13126").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto48 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica48 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida48 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("13798").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto49 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica49 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida49 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("15095").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto50 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica50 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida50 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("1757").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto51 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica51 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida51 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("1758").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto52 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica52 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida52 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("1759").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto53 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica53 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida53 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("202").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto54 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica54 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida54 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("204").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto55 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica55 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida55 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("207").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto56 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica56 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida56 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("216").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto57 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica57 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida57 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("220").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto58 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica58 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida58 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("224").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto59 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica59 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida59 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("234").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto60 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica60 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida60 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("241").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto61 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica61 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida61 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("2513").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto62 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica62 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida62 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("253").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto63 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica63 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida63 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("261").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto64 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica64 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida64 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("6241").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto65 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica65 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida65 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("DUL-VITRINA").child("7378").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto66 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica66 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida66 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("CAFE-ENVASES").child("522").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto67 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica67 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida67 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("CAFE-ENVASES").child("524").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto68 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica68 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida68 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("CAFE-ENVASES").child("526").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto69 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica69 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida69 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("CAFE-ENVASES").child("528").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto70 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica70 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida70 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("CAFE-ENVASES").child("529").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto71 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica71 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida71 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("CAFE-ENVASES").child("530").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto72 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica72 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida72 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Productos").child("Dulceria").child("CAFE-ENVASES").child("532").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    nombre_producto73 = dataSnapshot.child("Nombre-Producto").getValue().toString();
                    existencia_fisica73 = dataSnapshot.child("Existencia-Fisica").getValue().toString();
                    unidad_medida73 = dataSnapshot.child("Unidad-Medida").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //Referencias de cajas de textos
        Textcategoria = (EditText) findViewById(R.id.categoriaproducto);
        Textid = (EditText) findViewById(R.id.idproducto);
        Textnombre = (EditText) findViewById(R.id.nombreproducto);
        Textunidad = (EditText) findViewById(R.id.unidadmedida);



        //Hacemos referencia al botón
        BotonGenerarReporteDulceria = (Button) findViewById(R.id.generarReporteDulceria);
        BotonRegistrarProducto = (Button) findViewById(R.id.registrarProductoDulceria);

        //Listener de los botones
        BotonGenerarReporteDulceria.setOnClickListener(this);
        BotonRegistrarProducto.setOnClickListener(this);
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

    //Método para mandar a llamar el activity del menu de dulceria de aguas, nachos, helados y hotdog
    public void Irdulceriasanhh (View view){
        Intent irdulceriaanhh = new Intent(this, Dulceria_Agua_Nachos_Helado_Hotdog.class);
        startActivity(irdulceriaanhh);
    }

    //Método para mandar a llamar el activity del menu de dulceria de vitrina
    public void Irdulceriavitrina (View view){
        Intent irdulceriavitrina = new Intent(this, Dulceria_Vitrina.class);
        startActivity(irdulceriavitrina);
    }

    //Método para mandar a llamar el activity del menu de dulceria de envases cine cafe
    public void Irdulceriaenvases (View view){
        Intent irdulceriaenvases = new Intent(this, Dulceria_Envases_Cine_Cafe.class);
        startActivity(irdulceriaenvases);
    }


    private void crearPDF() {

        // Creamos el documento.
        Document documento = new Document();

        try {

            //Tomo la fecha y la hora del sistema (Telefono, Tablet, SmartWatch, etc)
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            // Creamos el fichero con el nombre que deseemos.
            archivoPDF = crearFichero(NOMBRE_DOCUMENTO);

            // Creamos el flujo de datos de salida para el fichero donde
            // guardaremos el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream(
                    archivoPDF.getAbsolutePath());

            // Asociamos el flujo que acabamos de crear al documento.
            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);

            // Añadimos un título con una fuente personalizada.
            Font font1 = FontFactory.getFont(FontFactory.HELVETICA, 20,
                    Font.BOLD, Color.RED);

            // Incluimos el píe de página y una cabecera
            HeaderFooter cabecera = new HeaderFooter(new Phrase(
                    "       REPORTE DE PRODUCTOS FÍSICOS DULCERÍA",font1), false);
            HeaderFooter pie = new HeaderFooter(new Phrase(
                    "                            Fecha de generación del reporte: " + date), false);


            documento.setHeader(cabecera);
            documento.setFooter(pie);

            // Abrimos el documento.
            documento.open();


            // Añadimos un título con una fuente personalizada.
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 14,
                    Font.BOLD, Color.BLUE);

            documento.add(new Paragraph("Categoría: CAFE-ENVASES \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla0 = new PdfPTable(3);

            for(int i = 0 ; i < 24 ; i++) {
                if(i==0){
                    tabla0.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla0.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla0.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla0.addCell(nombre_producto67);
                    i++;
                }

                if(i==4){
                    tabla0.addCell(existencia_fisica67);
                    i++;
                }

                if(i==5){
                    tabla0.addCell(unidad_medida67);
                    i++;
                }


                if(i==6){
                    tabla0.addCell(nombre_producto68);
                    i++;
                }

                if(i==7){
                    tabla0.addCell(existencia_fisica68);
                    i++;
                }

                if(i==8){
                    tabla0.addCell(unidad_medida68);
                    i++;
                }

                if(i==9){
                    tabla0.addCell(nombre_producto69);
                    i++;
                }

                if(i==10){
                    tabla0.addCell(existencia_fisica69);
                    i++;
                }

                if(i==11){
                    tabla0.addCell(unidad_medida69);
                    i++;
                }

                if(i==12){
                    tabla0.addCell(nombre_producto70);
                    i++;
                }

                if(i==13){
                    tabla0.addCell(existencia_fisica70);
                    i++;
                }

                if(i==14){
                    tabla0.addCell(unidad_medida70);
                    i++;
                }

                if(i==15){
                    tabla0.addCell(nombre_producto71);
                    i++;
                }

                if(i==16){
                    tabla0.addCell(existencia_fisica71);
                    i++;
                }

                if(i==17){
                    tabla0.addCell(unidad_medida71);
                    i++;
                }

                if(i==18){
                    tabla0.addCell(nombre_producto72);
                    i++;
                }

                if(i==19){
                    tabla0.addCell(existencia_fisica72);
                    i++;
                }

                if(i==20){
                    tabla0.addCell(unidad_medida72);
                    i++;
                }

                if(i==21){
                    tabla0.addCell(nombre_producto73);
                    i++;
                }

                if(i==22){
                    tabla0.addCell(existencia_fisica73);
                    i++;
                }

                if(i==23){
                    tabla0.addCell(unidad_medida73);
                    i++;
                }


            }

            documento.add(tabla0);

            documento.add(new Paragraph("Categoría: DUL-BEBIDAS \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla1 = new PdfPTable(3);

            for(int i = 0 ; i < 24 ; i++) {
                if(i==0){
                    tabla1.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla1.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla1.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla1.addCell(nombre_producto1);
                    i++;
                }

                if(i==4){
                    tabla1.addCell(existencia_fisica1);
                    i++;
                }

                if(i==5){
                    tabla1.addCell(unidad_medida1);
                    i++;
                }


                if(i==6){
                    tabla1.addCell(nombre_producto2);
                    i++;
                }

                if(i==7){
                    tabla1.addCell(existencia_fisica2);
                    i++;
                }

                if(i==8){
                    tabla1.addCell(unidad_medida2);
                    i++;
                }

                if(i==9){
                    tabla1.addCell(nombre_producto3);
                    i++;
                }

                if(i==10){
                    tabla1.addCell(existencia_fisica3);
                    i++;
                }

                if(i==11){
                    tabla1.addCell(unidad_medida3);
                    i++;
                }

                if(i==12){
                    tabla1.addCell(nombre_producto4);
                    i++;
                }

                if(i==13){
                    tabla1.addCell(existencia_fisica4);
                    i++;
                }

                if(i==14){
                    tabla1.addCell(unidad_medida4);
                    i++;
                }

                if(i==15){
                    tabla1.addCell(nombre_producto5);
                    i++;
                }

                if(i==16){
                    tabla1.addCell(existencia_fisica5);
                    i++;
                }

                if(i==17){
                    tabla1.addCell(unidad_medida5);
                    i++;
                }

                if(i==18){
                    tabla1.addCell(nombre_producto6);
                    i++;
                }

                if(i==19){
                    tabla1.addCell(existencia_fisica6);
                    i++;
                }

                if(i==20){
                    tabla1.addCell(unidad_medida6);
                    i++;
                }

                if(i==21){
                    tabla1.addCell(nombre_producto7);
                    i++;
                }

                if(i==22){
                    tabla1.addCell(existencia_fisica7);
                    i++;
                }

                if(i==23){
                    tabla1.addCell(unidad_medida7);
                    i++;
                }


            }

            documento.add(tabla1);

            documento.add(new Paragraph("Categoría: DUL-GRANEL \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla2 = new PdfPTable(3);

            for(int i = 0 ; i < 12 ; i++) {
                if(i==0){
                    tabla2.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla2.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla2.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla2.addCell(nombre_producto8);
                    i++;
                }

                if(i==4){
                    tabla2.addCell(existencia_fisica8);
                    i++;
                }

                if(i==5){
                    tabla2.addCell(unidad_medida8);
                    i++;
                }


                if(i==6){
                    tabla2.addCell(nombre_producto9);
                    i++;
                }

                if(i==7){
                    tabla2.addCell(existencia_fisica9);
                    i++;
                }

                if(i==8){
                    tabla2.addCell(unidad_medida9);
                    i++;
                }

                if(i==9){
                    tabla2.addCell(nombre_producto10);
                    i++;
                }

                if(i==10){
                    tabla2.addCell(existencia_fisica10);
                    i++;
                }

                if(i==11){
                    tabla2.addCell(unidad_medida10);
                    i++;
                }


            }

            documento.add(tabla2);

            documento.add(new Paragraph("\n\n", font2));

            documento.add(new Paragraph("Categoría: DUL-HD \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla3 = new PdfPTable(3);

            for(int i = 0 ; i < 21 ; i++) {
                if(i==0){
                    tabla3.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla3.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla3.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla3.addCell(nombre_producto11);
                    i++;
                }

                if(i==4){
                    tabla3.addCell(existencia_fisica11);
                    i++;
                }

                if(i==5){
                    tabla3.addCell(unidad_medida11);
                    i++;
                }


                if(i==6){
                    tabla3.addCell(nombre_producto12);
                    i++;
                }

                if(i==7){
                    tabla3.addCell(existencia_fisica12);
                    i++;
                }

                if(i==8){
                    tabla3.addCell(unidad_medida12);
                    i++;
                }

                if(i==9){
                    tabla3.addCell(nombre_producto13);
                    i++;
                }

                if(i==10){
                    tabla3.addCell(existencia_fisica13);
                    i++;
                }

                if(i==11){
                    tabla3.addCell(unidad_medida13);
                    i++;
                }

                if(i==12){
                    tabla3.addCell(nombre_producto14);
                    i++;
                }

                if(i==13){
                    tabla3.addCell(existencia_fisica14);
                    i++;
                }

                if(i==14){
                    tabla3.addCell(unidad_medida14);
                    i++;
                }

                if(i==15){
                    tabla3.addCell(nombre_producto15);
                    i++;
                }

                if(i==16){
                    tabla3.addCell(existencia_fisica15);
                    i++;
                }

                if(i==17){
                    tabla3.addCell(unidad_medida15);
                    i++;
                }

                if(i==18){
                    tabla3.addCell(nombre_producto16);
                    i++;
                }

                if(i==19){
                    tabla3.addCell(existencia_fisica16);
                    i++;
                }

                if(i==20){
                    tabla3.addCell(unidad_medida16);
                    i++;
                }


            }

            documento.add(tabla3);

            documento.add(new Paragraph("Categoría: DUL-HELADO \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla4 = new PdfPTable(3);

            for(int i = 0 ; i < 42 ; i++) {
                if(i==0){
                    tabla4.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla4.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla4.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla4.addCell(nombre_producto17);
                    i++;
                }

                if(i==4){
                    tabla4.addCell(existencia_fisica17);
                    i++;
                }

                if(i==5){
                    tabla4.addCell(unidad_medida17);
                    i++;
                }

                if(i==6){
                    tabla4.addCell(nombre_producto18);
                    i++;
                }

                if(i==7){
                    tabla4.addCell(existencia_fisica18);
                    i++;
                }

                if(i==8){
                    tabla4.addCell(unidad_medida18);
                    i++;
                }

                if(i==9){
                    tabla4.addCell(nombre_producto19);
                    i++;
                }

                if(i==10){
                    tabla4.addCell(existencia_fisica19);
                    i++;
                }

                if(i==11){
                    tabla4.addCell(unidad_medida19);
                    i++;
                }

                if(i==12){
                    tabla4.addCell(nombre_producto20);
                    i++;
                }

                if(i==13){
                    tabla4.addCell(existencia_fisica20);
                    i++;
                }

                if(i==14){
                    tabla4.addCell(unidad_medida20);
                    i++;
                }

                if(i==15){
                    tabla4.addCell(nombre_producto21);
                    i++;
                }

                if(i==16){
                    tabla4.addCell(existencia_fisica21);
                    i++;
                }

                if(i==17){
                    tabla4.addCell(unidad_medida21);
                    i++;
                }

                if(i==18){
                    tabla4.addCell(nombre_producto21);
                    i++;
                }

                if(i==19){
                    tabla4.addCell(existencia_fisica21);
                    i++;
                }

                if(i==20){
                    tabla4.addCell(unidad_medida21);
                    i++;
                }

                if(i==21){
                    tabla4.addCell(nombre_producto22);
                    i++;
                }

                if(i==22){
                    tabla4.addCell(existencia_fisica22);
                    i++;
                }

                if(i==23){
                    tabla4.addCell(unidad_medida22);
                    i++;
                }

                if(i==24){
                    tabla4.addCell(nombre_producto23);
                    i++;
                }

                if(i==25){
                    tabla4.addCell(existencia_fisica23);
                    i++;
                }

                if(i==26){
                    tabla4.addCell(unidad_medida23);
                    i++;
                }

                if(i==27){
                    tabla4.addCell(nombre_producto24);
                    i++;
                }

                if(i==28){
                    tabla4.addCell(existencia_fisica24);
                    i++;
                }

                if(i==29){
                    tabla4.addCell(unidad_medida24);
                    i++;
                }

                if(i==30){
                    tabla4.addCell(nombre_producto25);
                    i++;
                }

                if(i==31){
                    tabla4.addCell(existencia_fisica25);
                    i++;
                }

                if(i==32){
                    tabla4.addCell(unidad_medida25);
                    i++;
                }

                if(i==33){
                    tabla4.addCell(nombre_producto26);
                    i++;
                }

                if(i==34){
                    tabla4.addCell(existencia_fisica26);
                    i++;
                }

                if(i==35){
                    tabla4.addCell(unidad_medida26);
                    i++;
                }

                if(i==36){
                    tabla4.addCell(nombre_producto27);
                    i++;
                }

                if(i==37){
                    tabla4.addCell(existencia_fisica27);
                    i++;
                }

                if(i==38){
                    tabla4.addCell(unidad_medida27);
                    i++;
                }

                if(i==39){
                    tabla4.addCell(nombre_producto28);
                    i++;
                }

                if(i==40){
                    tabla4.addCell(existencia_fisica28);
                    i++;
                }

                if(i==41){
                    tabla4.addCell(unidad_medida28);
                    i++;
                }


            }

            documento.add(tabla4);

            documento.add(new Paragraph("Categoría: DUL-NACHOS \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla5 = new PdfPTable(3);

            for(int i = 0 ; i < 9 ; i++) {
                if(i==0){
                    tabla5.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla5.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla5.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla5.addCell(nombre_producto29);
                    i++;
                }

                if(i==4){
                    tabla5.addCell(existencia_fisica29);
                    i++;
                }

                if(i==5){
                    tabla5.addCell(unidad_medida29);
                    i++;
                }

                if(i==6){
                    tabla5.addCell(nombre_producto30);
                    i++;
                }

                if(i==7){
                    tabla5.addCell(existencia_fisica30);
                    i++;
                }

                if(i==8){
                    tabla5.addCell(unidad_medida30);
                    i++;
                }


            }

            documento.add(tabla5);

            documento.add(new Paragraph("\n\n\n", font2));

            documento.add(new Paragraph("Categoría: DUL-PAL \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla6 = new PdfPTable(3);

            for(int i = 0 ; i < 24 ; i++) {
                if(i==0){
                    tabla6.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla6.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla6.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla6.addCell(nombre_producto31);
                    i++;
                }

                if(i==4){
                    tabla6.addCell(existencia_fisica31);
                    i++;
                }

                if(i==5){
                    tabla6.addCell(unidad_medida31);
                    i++;
                }

                if(i==6){
                    tabla6.addCell(nombre_producto32);
                    i++;
                }

                if(i==7){
                    tabla6.addCell(existencia_fisica32);
                    i++;
                }

                if(i==8){
                    tabla6.addCell(unidad_medida32);
                    i++;
                }

                if(i==9){
                    tabla6.addCell(nombre_producto33);
                    i++;
                }

                if(i==10){
                    tabla6.addCell(existencia_fisica33);
                    i++;
                }

                if(i==11){
                    tabla6.addCell(unidad_medida33);
                    i++;
                }

                if(i==12){
                    tabla6.addCell(nombre_producto34);
                    i++;
                }

                if(i==13){
                    tabla6.addCell(existencia_fisica34);
                    i++;
                }

                if(i==14){
                    tabla6.addCell(unidad_medida34);
                    i++;
                }

                if(i==15){
                    tabla6.addCell(nombre_producto35);
                    i++;
                }

                if(i==16){
                    tabla6.addCell(existencia_fisica35);
                    i++;
                }

                if(i==17){
                    tabla6.addCell(unidad_medida35);
                    i++;
                }

                if(i==18){
                    tabla6.addCell(nombre_producto36);
                    i++;
                }

                if(i==19){
                    tabla6.addCell(existencia_fisica36);
                    i++;
                }

                if(i==20){
                    tabla6.addCell(unidad_medida36);
                    i++;
                }

                if(i==21){
                    tabla6.addCell(nombre_producto37);
                    i++;
                }

                if(i==22){
                    tabla6.addCell(existencia_fisica37);
                    i++;
                }

                if(i==23){
                    tabla6.addCell(unidad_medida37);
                    i++;
                }


            }

            documento.add(tabla6);

            documento.add(new Paragraph("Categoría: DUL-SNACK \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla7 = new PdfPTable(3);

            for(int i = 0 ; i < 12 ; i++) {
                if(i==0){
                    tabla7.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla7.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla7.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla7.addCell(nombre_producto38);
                    i++;
                }

                if(i==4){
                    tabla7.addCell(existencia_fisica38);
                    i++;
                }

                if(i==5){
                    tabla7.addCell(unidad_medida38);
                    i++;
                }

                if(i==6){
                    tabla7.addCell(nombre_producto39);
                    i++;
                }

                if(i==7){
                    tabla7.addCell(existencia_fisica39);
                    i++;
                }

                if(i==8){
                    tabla7.addCell(unidad_medida39);
                    i++;
                }

                if(i==9){
                    tabla7.addCell(nombre_producto40);
                    i++;
                }

                if(i==10){
                    tabla7.addCell(existencia_fisica40);
                    i++;
                }

                if(i==11){
                    tabla7.addCell(unidad_medida40);
                    i++;
                }


            }

            documento.add(tabla7);



            documento.add(new Paragraph("Categoría: DUL-VITRINA \n\n", font2));

            // Insertamos una tabla
            PdfPTable tabla8 = new PdfPTable(3);


            for(int i = 0 ; i < 78 ; i++) {
                if (i == 0) {
                    tabla8.addCell("Nombre del Producto");
                    i++;
                }
                if (i == 1) {
                    tabla8.addCell("Existencia Física");
                    i++;
                }
                if (i == 2) {
                    tabla8.addCell("Unidad de Medida");
                    i++;
                }


                if (i == 3) {
                    tabla8.addCell(nombre_producto41);
                    i++;
                }

                if (i == 4) {
                    tabla8.addCell(existencia_fisica41);
                    i++;
                }

                if (i == 5) {
                    tabla8.addCell(unidad_medida41);
                    i++;
                }

                if (i == 6) {
                    tabla8.addCell(nombre_producto42);
                    i++;
                }

                if (i == 7) {
                    tabla8.addCell(existencia_fisica42);
                    i++;
                }

                if (i == 8) {
                    tabla8.addCell(unidad_medida42);
                    i++;
                }

                if (i == 9) {
                    tabla8.addCell(nombre_producto43);
                    i++;
                }

                if (i == 10) {
                    tabla8.addCell(existencia_fisica43);
                    i++;
                }

                if (i ==11) {
                    tabla8.addCell(unidad_medida43);
                    i++;
                }

                if (i == 12) {
                    tabla8.addCell(nombre_producto44);
                    i++;
                }

                if (i == 13) {
                    tabla8.addCell(existencia_fisica44);
                    i++;
                }

                if (i ==14) {
                    tabla8.addCell(unidad_medida44);
                    i++;
                }

                if (i == 15) {
                    tabla8.addCell(nombre_producto45);
                    i++;
                }

                if (i == 16) {
                    tabla8.addCell(existencia_fisica45);
                    i++;
                }

                if (i ==17) {
                    tabla8.addCell(unidad_medida45);
                    i++;
                }


                if (i == 18) {
                    tabla8.addCell(nombre_producto47);
                    i++;
                }

                if (i == 19) {
                    tabla8.addCell(existencia_fisica47);
                    i++;
                }

                if (i ==20) {
                    tabla8.addCell(unidad_medida47);
                    i++;
                }

                if (i == 21) {
                    tabla8.addCell(nombre_producto48);
                    i++;
                }

                if (i == 22) {
                    tabla8.addCell(existencia_fisica48);
                    i++;
                }

                if (i ==23) {
                    tabla8.addCell(unidad_medida48);
                    i++;
                }

                if (i == 24) {
                    tabla8.addCell(nombre_producto49);
                    i++;
                }

                if (i == 25) {
                    tabla8.addCell(existencia_fisica49);
                    i++;
                }

                if (i ==26) {
                    tabla8.addCell(unidad_medida49);
                    i++;
                }

                if (i == 27) {
                    tabla8.addCell(nombre_producto50);
                    i++;
                }

                if (i == 28) {
                    tabla8.addCell(existencia_fisica50);
                    i++;
                }

                if (i == 29) {
                    tabla8.addCell(unidad_medida50);
                    i++;
                }

                if (i == 30) {
                    tabla8.addCell(nombre_producto51);
                    i++;
                }

                if (i == 31) {
                    tabla8.addCell(existencia_fisica51);
                    i++;
                }

                if (i == 32) {
                    tabla8.addCell(unidad_medida51);
                    i++;
                }

                if (i == 33) {
                    tabla8.addCell(nombre_producto52);
                    i++;
                }

                if (i == 34) {
                    tabla8.addCell(existencia_fisica52);
                    i++;
                }

                if (i == 35) {
                    tabla8.addCell(unidad_medida52);
                    i++;
                }

                if (i == 36) {
                    tabla8.addCell(nombre_producto53);
                    i++;
                }

                if (i == 37) {
                    tabla8.addCell(existencia_fisica53);
                    i++;
                }

                if (i == 38) {
                    tabla8.addCell(unidad_medida53);
                    i++;
                }

                if (i == 39) {
                    tabla8.addCell(nombre_producto54);
                    i++;
                }

                if (i == 40) {
                    tabla8.addCell(existencia_fisica54);
                    i++;
                }

                if (i == 41) {
                    tabla8.addCell(unidad_medida54);
                    i++;
                }

                if (i == 42) {
                    tabla8.addCell(nombre_producto55);
                    i++;
                }

                if (i == 43) {
                    tabla8.addCell(existencia_fisica55);
                    i++;
                }

                if (i == 44) {
                    tabla8.addCell(unidad_medida55);
                    i++;
                }

                if (i == 45) {
                    tabla8.addCell(nombre_producto56);
                    i++;
                }

                if (i == 46) {
                    tabla8.addCell(existencia_fisica56);
                    i++;
                }

                if (i == 47) {
                    tabla8.addCell(unidad_medida56);
                    i++;
                }

                if (i == 48) {
                    tabla8.addCell(nombre_producto57);
                    i++;
                }

                if (i == 49) {
                    tabla8.addCell(existencia_fisica57);
                    i++;
                }

                if (i == 50) {
                    tabla8.addCell(unidad_medida57);
                    i++;
                }

                if (i == 51) {
                    tabla8.addCell(nombre_producto58);
                    i++;
                }

                if (i == 52) {
                    tabla8.addCell(existencia_fisica58);
                    i++;
                }

                if (i == 53) {
                    tabla8.addCell(unidad_medida58);
                    i++;
                }

                if (i == 54) {
                    tabla8.addCell(nombre_producto59);
                    i++;
                }

                if (i == 55) {
                    tabla8.addCell(existencia_fisica59);
                    i++;
                }

                if (i == 56) {
                    tabla8.addCell(unidad_medida59);
                    i++;
                }

                if (i == 57) {
                    tabla8.addCell(nombre_producto60);
                    i++;
                }

                if (i == 58) {
                    tabla8.addCell(existencia_fisica60);
                    i++;
                }

                if (i == 59) {
                    tabla8.addCell(unidad_medida60);
                    i++;
                }

                if (i == 60) {
                    tabla8.addCell(nombre_producto61);
                    i++;
                }

                if (i == 61) {
                    tabla8.addCell(existencia_fisica61);
                    i++;
                }

                if (i == 62) {
                    tabla8.addCell(unidad_medida61);
                    i++;
                }

                if (i == 63) {
                    tabla8.addCell(nombre_producto62);
                    i++;
                }

                if (i == 64) {
                    tabla8.addCell(existencia_fisica62);
                    i++;
                }

                if (i == 65) {
                    tabla8.addCell(unidad_medida62);
                    i++;
                }

                if (i == 66) {
                    tabla8.addCell(nombre_producto63);
                    i++;
                }

                if (i == 67) {
                    tabla8.addCell(existencia_fisica63);
                    i++;
                }

                if (i == 68) {
                    tabla8.addCell(unidad_medida63);
                    i++;
                }

                if (i == 69) {
                    tabla8.addCell(nombre_producto64);
                    i++;
                }

                if (i == 70) {
                    tabla8.addCell(existencia_fisica64);
                    i++;
                }

                if (i == 71) {
                    tabla8.addCell(unidad_medida64);
                    i++;
                }

                if (i == 72) {
                    tabla8.addCell(nombre_producto65);
                    i++;
                }

                if (i == 73) {
                    tabla8.addCell(existencia_fisica65);
                    i++;
                }

                if (i == 74) {
                    tabla8.addCell(unidad_medida65);
                    i++;
                }

                if (i == 75) {
                    tabla8.addCell(nombre_producto66);
                    i++;
                }

                if (i == 76) {
                    tabla8.addCell(existencia_fisica66);
                    i++;
                }

                if (i == 77) {
                    tabla8.addCell(unidad_medida66);
                    i++;
                }
            }

            documento.add(tabla8);





            // Agregar marca de agua
            font2 = FontFactory.getFont(FontFactory.HELVETICA, 42, Font.BOLD,
                    Color.lightGray);
            ColumnText.showTextAligned(writer.getDirectContentUnder(),
                    Element.ALIGN_CENTER, new Paragraph(
                            "Cinépolis", font2), 297.5f, 421,
                    writer.getPageNumber() % 2 == 1 ? 45 : -45);
            Toast.makeText(contexto,"PDF creado correctamente",Toast.LENGTH_LONG).show();

        } catch (DocumentException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());

        } catch (IOException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());


        } finally {

            // Cerramos el documento.
            documento.close();
        }

    }



    /**
     * Crea un fichero con el nombre que se le pasa a la función y en la ruta
     * especificada.
     *
     * @param nombreFichero
     * @return
     * @throws IOException
     */
    public static File crearFichero(String nombreFichero) throws IOException {
        File ruta = getRuta();
        File fichero = null;
        if (ruta != null)
            fichero = new File(ruta, nombreFichero);
        return fichero;
    }

    /**
     * Obtenemos la ruta donde vamos a almacenar el fichero.
     *
     * @return
     */
    public static File getRuta() {

        // El fichero será almacenado en un directorio dentro del directorio
        // Descargas
        File ruta = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            ruta = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    NOMBRE_DIRECTORIO);

            if (ruta != null) {
                if (!ruta.mkdirs()) {
                    if (!ruta.exists()) {
                        return null;
                    }
                }
            }
        } else {
        }

        return ruta;
    }

    private void verPDF() {
        //Primero busca el archivo
        buscarPDF();
        if(fPDF==1) {
            //De que actividad estoy a cual quiero ir
            Intent intent = new Intent(contexto, PDF_Dulceria.class);
            //Envío de información entre actividades
            intent.putExtra("path", archivoPDF.getAbsolutePath());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contexto.startActivity(intent);
            Toast.makeText(contexto,"Si existe archivo PDF para LEER",Toast.LENGTH_LONG).show();
        }
        else
        if(fPDF==0){
            Toast.makeText(contexto,"No existe archivo PDF para LEER",Toast.LENGTH_LONG).show();
        }
    }


    private void buscarPDF() {
        try{
            File carpeta = null;
            if (Environment.MEDIA_MOUNTED.equals(Environment
                    .getExternalStorageState())) {
                carpeta = new File(
                        Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                        NOMBRE_DIRECTORIO);
                archivoPDF = new File(carpeta, NOMBRE_DOCUMENTO);


                //Verifica si la carpeta existe
                if (archivoPDF.exists()) {
                    fPDF = 1;     //La bandera esta activada para leer PDFs
                } else {
                    fPDF = 0;     //La bandera está desactivada para leer los PDFs
                }
            }
        }catch (Exception e){
            //Mensaje que me dirá si hay errores
            Log.e(ETIQUETA_ERROR,e.toString());
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void registrarProducto(){
        //Obtener datos de caja de texto
        final String categoria_producto = Textcategoria.getText().toString().trim();
        final String id_producto = Textid.getText().toString().trim();
        final String nombre_producto = Textnombre.getText().toString().trim();
        final String  unidad_medida = Textunidad.getText().toString().trim();


        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(categoria_producto)){
            Toast.makeText(this, "Favor de ingresar categoría del producto", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(id_producto)){
            Toast.makeText(this, "Favor de ingresar id del producto", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(nombre_producto)){
            Toast.makeText(this, "Favor de ingresar el nombre del producto", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(unidad_medida)){
            Toast.makeText(this, "Favor de ingresar la unidad de medida del producto", Toast.LENGTH_SHORT).show();
            return;
        }



        //Creamos el conjunto de valores con los datos del poducto que vamos a registrar
        Map<String, Object> map1 = new HashMap<>();
        map1.put("Existencia-Fisica","0");
        map1.put("Id-Usuario","0");
        map1.put("Nombre-Producto",nombre_producto);
        map1.put("Unidad-Medida", unidad_medida);




        databaseReference.child("Productos").child("Dulceria").child(""+categoria_producto).child(""+id_producto).setValue(map1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //Mensaje de que el producto ha sido registrado
                    Toast.makeText(Menu_Dulceria.this, "Se ha registrado el producto correctamente", Toast.LENGTH_SHORT).show();



                }else{
                    //Mensaje de que no se pudieron registrar los datos del producto
                    Toast.makeText(Menu_Dulceria.this, "No se pudieron registrar los datos correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.generarReporteDulceria:
                //Invocamos los métodos
                crearPDF();
                verPDF();
                break;
        }

        switch (v.getId()){
            case R.id.registrarProductoDulceria:
                //Invocamos los métodos
                registrarProducto();
                break;
        }

    }
}
