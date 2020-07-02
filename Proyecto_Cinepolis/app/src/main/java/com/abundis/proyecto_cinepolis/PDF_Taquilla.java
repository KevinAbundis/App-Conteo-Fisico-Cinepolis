package com.abundis.proyecto_cinepolis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PDF_Taquilla extends AppCompatActivity {

    //Creo la instancia de los Objetos del XML
    private PDFView VisorPDF;
    private File archivoPDF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_taquilla);

        //Hago el casting de las distintas vairbles
        VisorPDF = (PDFView) findViewById(R.id.pdfVisor);

        //Creo un Bundle para recibir la información de otras Activities
        Bundle miBundle = getIntent().getExtras();
        //Verifico que si recibi alguna información
        if(miBundle!=null){
            archivoPDF = new File(miBundle.getString("path", ""));

            //Abro el PDF con los respectivos atributos que se escojan
            VisorPDF.fromFile(archivoPDF)
                    .enableSwipe(true)         //Deslizar página
                    .swipeHorizontal(false)    //Deslizamiento vertical de páginas
                    .enableDoubletap(true)     //Hago zoom con doble click
                    .enableAntialiasing(true)  //Mejor visualización
                    .load();
        }//final miBundle!=null
    }
}
