package com.abundis.proyecto_cinepolis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecuperarContrasenia extends AppCompatActivity implements View.OnClickListener {

    //Variables de recuperar contraseña
    private EditText TextEmail;
    private Button BtnRecuperarContrasenia;
    private ProgressDialog progressDialog;

    //Declaramos objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    //Declaramos el objeto databaseReference para poder utilizar la base de datos en tiempo real de Firebase
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasenia);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //Hacemos referencias de los views
        TextEmail = (EditText) findViewById(R.id.TxtEmail3);
        BtnRecuperarContrasenia = (Button) findViewById(R.id.BtnRecuperarContra);
        progressDialog = new ProgressDialog(this);

        //listener de los botones
        BtnRecuperarContrasenia.setOnClickListener(this);

    }

    //Función para recuperar la contraseña del usuario
    private void recuperarContrasenia(){

        //Obtener el email
        final String email = TextEmail.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Favor de ingresar su correo electrónico", Toast.LENGTH_SHORT).show();
            return;
        }

        //Mandar mensaje en pantalla que se esta realizando la petición de recuperación de contraseña
        progressDialog.setMessage("Realizando petición...");
        progressDialog.show();




        //Establecemos el idioma en el que se mandara el correo
        firebaseAuth.setLanguageCode("es");

        //Recuperar contraseña
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    //Mensaje de que el correo para restablecer la contraseña ha sido enviado
                    Toast.makeText(RecuperarContrasenia.this, "Se ha enviado un correo a "+email+" para restablecer tu contraseña", Toast.LENGTH_LONG).show();


                    //Aquí estamos enviando el usuario a la otra actividad
                    Intent intencion = new Intent(getApplication(), MainActivity.class);

                    //Iniciamos la otra activity
                    startActivity(intencion);

                    //Finalizamos la activity actual, para que cuando el usuario presione el botón de atras ya no se visualize de nuevo
                    finish();

                }else{
                    if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                        //Mensaje de que el usuario con el correo proporcionado no existe
                        Toast.makeText(RecuperarContrasenia.this, "El correo electrónico que ingresaste no se encuentra registrado", Toast.LENGTH_SHORT).show();

                    }else{
                        //Mensaje de que no se pudo restablecer la contraseña
                        Toast.makeText(RecuperarContrasenia.this, "No se pudo enviar el correo para restablecer contraseña", Toast.LENGTH_SHORT).show();
                    }
                }

                progressDialog.dismiss();

            }

        });

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.BtnRecuperarContra:
                //Invocamos al método
                recuperarContrasenia();
                break;

        }
    }
}
