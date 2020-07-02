package com.abundis.proyecto_cinepolis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import harmony.java.awt.Color;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu_Taquilla extends AppCompatActivity implements View.OnClickListener {

    private final static String NOMBRE_DIRECTORIO = "Reportes-Cinépolis";
    private final static String NOMBRE_DOCUMENTO = "Reporte-Taquilla.pdf";
    private final static String ETIQUETA_ERROR = "ERROR PDF";
    Context contexto;
    //Variable para el archivo PDF
    private File archivoPDF;
    //Bandera que me indica si existe el archivo PDF
    private int fPDF = 0;

    String nombre_producto1, existencia_fisica1, unidad_medida1;
    String nombre_producto2, existencia_fisica2, unidad_medida2;
    String nombre_producto3, existencia_fisica3, unidad_medida3;



    private Button BotonGenerarReporteTaquilla;
    //private Button BotonVerReporteTaquilla;

    //Declaramos el objeto databaseReference para poder utilizar la base de datos en tiempo real de Firebase
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_taquilla);

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

        databaseReference.child("Productos").child("Taquilla").child("DUL-LEALTAD").child("691").addValueEventListener(new ValueEventListener() {
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

        databaseReference.child("Productos").child("Taquilla").child("DUL-LEALTAD").child("2879").addValueEventListener(new ValueEventListener() {
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

        databaseReference.child("Productos").child("Taquilla").child("DUL-LEALTAD").child("3802").addValueEventListener(new ValueEventListener() {
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

        //Hacemos referencia al botón
        BotonGenerarReporteTaquilla = (Button) findViewById(R.id.generarReporteTaquilla);
        //BotonVerReporteTaquilla = (Button)findViewById(R.id.verReporteTaquilla);

        //Listener de los botones
        BotonGenerarReporteTaquilla.setOnClickListener(this);
        //BotonVerReporteTaquilla.setOnClickListener(this);



    }

    //Método para mandar a llamar el activity de taquilla
    public void Irtaquilla (View view){
        Intent irtaquilla = new Intent(this, Taquilla.class);
        startActivity(irtaquilla);
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
                    "       REPORTE DE PRODUCTOS FÍSICOS TAQUILLA",font1), false);
            HeaderFooter pie = new HeaderFooter(new Phrase(
                    "                            Fecha de generación del reporte: " + date), false);


            documento.setHeader(cabecera);
            documento.setFooter(pie);

            // Abrimos el documento.
            documento.open();

            // Añadimos un título con la fuente por defecto.
            //documento.add(new Paragraph("Título 1"));

            // Añadimos un título con una fuente personalizada.
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 14,
                    Font.BOLD, Color.BLUE);

            documento.add(new Paragraph("Categoría: DUL-LEALTAD \n\n", font2));

            /*// Insertamos una imagen que se encuentra en los recursos de la
            // aplicación.
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    R.drawable.usuario1);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image imagen = Image.getInstance(stream.toByteArray());
            documento.add(imagen);*/

            // Insertamos una tabla
            PdfPTable tabla = new PdfPTable(3);

            for(int i = 0 ; i < 12 ; i++) {
                if(i==0){
                    tabla.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla.addCell(nombre_producto1);
                    i++;
                }

                if(i==4){
                    tabla.addCell(existencia_fisica1);
                    i++;
                }

                if(i==5){
                    tabla.addCell(unidad_medida1);
                    i++;
                }


                if(i==6){
                    tabla.addCell(nombre_producto2);
                    i++;
                }

                if(i==7){
                    tabla.addCell(existencia_fisica2);
                    i++;
                }

                if(i==8){
                    tabla.addCell(unidad_medida2);
                    i++;
                }

                if(i==9){
                    tabla.addCell(nombre_producto3);
                    i++;
                }

                if(i==10){
                    tabla.addCell(existencia_fisica3);
                    i++;
                }

                if(i==11){
                    tabla.addCell(unidad_medida3);
                    i++;
                }


            }

            documento.add(tabla);

            /*// Insertamos una tabla.
            PdfPTable tabla = new PdfPTable(5);
            for (int i = 0; i < 15; i++) {
                tabla.addCell("Celda " + i);
            }
            documento.add(tabla);*/

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

    /*//Método para crear PFD del reporte
    public void CrearPDF(){
        Document documento = new Document();

        try {
            File file = crearFichero(NOMBRE_DOCUMENTO);
            FileOutputStream ficheroPDF = new FileOutputStream(file.getAbsolutePath());

            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPDF);

            documento.open();

            documento.add(new Paragraph("                                       REPORTE DE PRODUCTOS FÍSICOS TAQUILLA \n\n"));

            documento.add(new Paragraph("Categoría: DUL-LEALTAD \n\n"));
            // Insertamos una tabla
            PdfPTable tabla = new PdfPTable(3);

            for(int i = 0 ; i < 15 ; i++) {
                if(i==0){
                    tabla.addCell("Nombre del Producto");
                    i++;
                }
                if(i==1){
                    tabla.addCell("Existencia Física");
                    i++;
                }
                if(i==2){
                    tabla.addCell("Unidad de Medida");
                    i++;
                }


                if(i==3){
                    tabla.addCell(nombre_producto1);
                    i++;
                }

                if(i==4){
                    tabla.addCell(existencia_fisica1);
                    i++;
                }

                if(i==5){
                    tabla.addCell(unidad_medida1);
                    i++;
                }


                if(i==6){
                    tabla.addCell(nombre_producto2);
                    i++;
                }

                if(i==7){
                    tabla.addCell(existencia_fisica2);
                    i++;
                }

                if(i==8){
                    tabla.addCell(unidad_medida2);
                    i++;
                }

                if(i==9){
                    tabla.addCell(nombre_producto3);
                    i++;
                }

                if(i==10){
                    tabla.addCell(existencia_fisica3);
                    i++;
                }

                if(i==11){
                    tabla.addCell(unidad_medida3);
                    i++;
                }


            }

            documento.add(tabla);

            // Agregar marca de agua
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 42, Font.BOLD,
                    Color.GRAY);
            ColumnText.showTextAligned(writer.getDirectContentUnder(),
                    Element.ALIGN_CENTER, new Paragraph(
                            "cinépolis", font), 297.5f, 421,
                    writer.getPageNumber() % 2 == 1 ? 45 : -45);

        } catch(DocumentException e) {
        } catch(IOException e) {
        } finally {
            documento.close();
        }

    }

    public File crearFichero(String nombreFichero) {
        File ruta = getRuta();

        File fichero = null;
        if(ruta != null) {
            fichero = new File(ruta, nombreFichero);
        }

        return fichero;
    }

    public File getRuta() {
        File ruta = null;

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            ruta = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), NOMBRE_DIRECTORIO);

            if(ruta != null) {
                if(!ruta.mkdirs()) {
                    if(!ruta.exists()) {
                        return null;
                    }
                }
            }

        }
        return ruta;
    }*/


    /*private void verPDFAPP(Activity activity) {
        //Primero busca el archivo
        buscarPDF();
        if(fPDF==1) {
            Toast.makeText(contexto,"Si existe archivo PDF para LEER",Toast.LENGTH_LONG).show();
            Uri uri= Uri.fromFile(archivoPDF);
            //Creo un Intent para inciar una nueva actividad, pero de otra APP
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "applicacion/PDF");
            //Try catch ´por si no existe una APP en el dispositivo
            try{
                activity.startActivity(intent);
            }catch (ActivityNotFoundException e){
                activity.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=cn.wps.moffice_eng&hl=es")));
                //Mensaje en un Toast para que se visualize el posible error
                Toast.makeText(activity.getApplicationContext(),
                        "No hay una APP para ver PDFs", Toast.LENGTH_LONG).show();
                Log.e("verPDFAPP",e.toString());
            }

        }
        else
        if(fPDF==0){
            Toast.makeText(contexto,"No existe archivo PDF para LEER",Toast.LENGTH_LONG).show();
        }


    }*/


    private void verPDF() {
        //Primero busca el archivo
        buscarPDF();
        if(fPDF==1) {
            //De que actividad estoy a cual quiero ir
            Intent intent = new Intent(contexto, PDF_Taquilla.class);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.generarReporteTaquilla:

                //Invocamos al método
                crearPDF();

                //Toast.makeText(Menu_Taquilla.this,"Reporte Creado Exitosamente", Toast.LENGTH_LONG).show();

                verPDF();

                //verPDFAPP(this);

                //mostrarPDF("Reporte-Taquilla.pdf", Menu_Taquilla.this);

                /*//Aquí estamos enviando el usuario a la otra actividad
                Intent intencion = new Intent(getApplication(), PDF_Taquilla.class);

                //Iniciamos la otra activity
                startActivity(intencion);*/

                break;

            /*case R.id.verReporteTaquilla:

                //Invocamos al método


                break;*/


        }

    }
}
