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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registrar_Usuario extends AppCompatActivity implements View.OnClickListener{

    //Variables de Registrar usuario
    private EditText TextNombre;
    private EditText TextCine;
    private EditText TextPuesto;
    private EditText TextEmail;
    private EditText TextPassword;
    private ProgressDialog progressDialog;
    private Button BotonRegistrar;

    //Declaramos objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    //Declaramos el objeto databaseReference para poder utilizar la base de datos en tiempo real de Firebase
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //Hacemos referencias de los views
        TextNombre = (EditText) findViewById(R.id.TxtNombre);
        TextCine = (EditText) findViewById(R.id.TxtCine);
        TextPuesto = (EditText) findViewById(R.id.TxtPuesto);
        TextEmail = (EditText) findViewById(R.id.TxtEmail2);
        TextPassword = (EditText) findViewById(R.id.TxtPassword2);

        BotonRegistrar = (Button) findViewById(R.id.BtnRegistrarUsuario2);
        progressDialog = new ProgressDialog(this);

        //listener de los botones
        BotonRegistrar.setOnClickListener(this);

    }

    private void registrarUsuario(){
        //Obtener el nombre, cine, puesto, email y contraseña
        final String nombre = TextNombre.getText().toString().trim();
        final String cine = TextCine.getText().toString().trim();
        final String puesto = TextPuesto.getText().toString().trim();
        final String email = TextEmail.getText().toString().trim();
        final String password = TextPassword.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(nombre)){
            Toast.makeText(this, "Favor de ingresar su nombre completo", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(cine)){
            Toast.makeText(this, "Favor de ingresar el nombre del cine donde trabaja", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(puesto)){
            Toast.makeText(this, "Favor de ingresar su puesto de trabajo", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Favor de ingresar su correo electrónico", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Favor de ingresar su contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        //Verificar que la contraseña tenga almenos 6 digitos, ya que Firebase pide que la contraseña tenga 6 digitos como minimo
        if (password.length() < 6){
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        //Mandar mensaje en pantalla que se esta realizando registro
        progressDialog.setMessage("Realizando registro de usuario...");
        progressDialog.show();

        //Creando nuevo usuario
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checando si hay registro
                        if(task.isSuccessful()){
                            //Recibimos el id que tiene el usuario actual
                            String id = firebaseAuth.getCurrentUser().getUid();

                            //Creamos el conjunto de valores con los datos del usuario que vamos a registrar
                            Map<String, Object> map = new HashMap<>();
                            map.put("Nombre-Completo",nombre);
                            map.put("Nombre-Cine", cine);
                            map.put("Puesto-Trabajo", puesto);
                            map.put("Email", email);
                            map.put("Contrasenia", password);


                            //Creamos un nodo hijo llamado usuarios para almacenar en este los datos del usuario que se esta registrando
                            databaseReference.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task2) {
                                    if(task2.isSuccessful()){
                                        //Mensaje de que el usuario ha sido registrado
                                        Toast.makeText(Registrar_Usuario.this, "Se ha registrado el usuario correctamente", Toast.LENGTH_SHORT).show();

                                        //Aquí estamos enviando el usuario a la otra actividad
                                        Intent intencion = new Intent(getApplication(), MainActivity.class);

                                        //Iniciamos la otra activity
                                        startActivity(intencion);

                                        //Finalizamos la activity actual, para que cuando el usuario presione el botón de atras ya no se visualize de nuevo
                                        finish();

                                    }else{
                                        //Mensaje de que no se pudieron registrar los datos del usuario
                                        Toast.makeText(Registrar_Usuario.this, "No se pudieron registrar los datos correctamente", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });


                        }else {
                            //Verificar si el usuario ya esta registrado
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                //Mensaje de que el usuario ya existe
                                Toast.makeText(Registrar_Usuario.this, "Correo ya se encuentra registrado, intente con otro", Toast.LENGTH_SHORT).show();
                            } else {
                                //Mensaje de que no se pudo registrar el usuario
                                Toast.makeText(Registrar_Usuario.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.BtnRegistrarUsuario2:
                //Invocamos al método
                registrarUsuario();
                break;

        }
    }
}
