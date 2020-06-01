package com.abundis.proyecto_cinepolis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables de Login
    private EditText TextEmail;
    private EditText TextPassword;
    private ProgressDialog progressDialog;
    private Button BotonLogin;



    //Declaramos objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    //Declaramos el objeto databaseReference para poder utilizar la base de datos en tiempo real de Firebase
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializamos objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //inicializamos objeto databaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //Hacemos referencias de los views
        TextEmail = (EditText) findViewById(R.id.TxtEmail);
        TextPassword = (EditText) findViewById(R.id.TxtPassword);
        BotonLogin = (Button) findViewById(R.id.BtnIniciarSesion);
        progressDialog = new ProgressDialog(this);

        //listener de los botones
        BotonLogin.setOnClickListener(this);
    }



    private void loginUsuario(){
        //Obtener el email y contraseña
        final String email = TextEmail.getText().toString().trim();
        final String password = TextPassword.getText().toString().trim();

        //Verificar que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Favor de ingresar su correo electrónico", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Favor de ingresar su contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        //Mandar mensaje en pantalla que se esta realizando el inicio de sesión
        progressDialog.setMessage("Iniciando sesión...");
        progressDialog.show();

        //Login de usuario
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Actualizamos la contraseña del usuario en la base de datos en tiempo real en caso de que este la haya restablecido,
                            //ya que solo se verá reflejado el cambio en la pestaña de autenticación, pero no en la de la base de datos en tiempo real
                            actualizarPasswordUsuarios();

                            //Mensaje de que el usuario ha iniciado sesión exitosamente
                            Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                            //Aquí estamos enviando el usuario a la otra actividad
                            Intent intencion = new Intent(getApplication(), Menuprincipal.class);

                            //Iniciamos la otra activity
                            startActivity(intencion);

                            //Finalizamos la activity actual, para que cuando el usuario presione el botón de atras ya no se visualize de nuevo
                            finish();


                        }else {

                            if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                                //Mensaje de que el usuario no existe
                                Toast.makeText(MainActivity.this, "El usuario no esta registrado", Toast.LENGTH_SHORT).show();

                            }else{
                                if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    //Mensaje de que la contraseña en incorrecta
                                    Toast.makeText(MainActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();

                                }else{
                                    //Mensaje de que no se pudo iniciar sesión por alguna otra razón
                                    Toast.makeText(MainActivity.this, "No se pudo iniciar sesión", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void actualizarPasswordUsuarios(){
        //Obtenemos la contraseña
        final String password = TextPassword.getText().toString().trim();

        //Recibimos el id que tiene el usuario actual
        String id = firebaseAuth.getCurrentUser().getUid();

        //Creamos el mapa del valor de la contraseña que es la que vamos a actualizar
        Map<String, Object> map = new HashMap<>();
        map.put("Contrasenia", password);

        //Actualizamos los datos con esta función
        databaseReference.child("Usuarios").child(id).updateChildren(map);
    }


    //Método para mandar a llamar el activity de registrar usuario
    public void IrRegistrarUsuario (View view){
        Intent irregistrarusuario = new Intent(this, Registrar_Usuario.class);
        startActivity(irregistrarusuario);
    }

    //Método para mandar a llamar el activity de recuperar contrasenia
    public void IrRecuperarContrasenia (View view){
        Intent irrecuperarcontrasenia = new Intent(this, RecuperarContrasenia.class);
        startActivity(irrecuperarcontrasenia);
    }


    //Método que activa el evento al momento de dar clic en los botones
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.BtnIniciarSesion:
                //Invocamos al método
                //loginUsuario();

                //BORRAR LAS LÍNEAS DE CÓDIGO QUE SE ENCUENTRAN DEBAJO Y DESCOMENTAR LA LINEA DE CÓDIGO QUE MANDA A LLAMAR LA FUNCIÓN
                //LOGINUSUARIO
                //Mensaje de que el usuario ha iniciado sesión exitosamente
                Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                //Aquí estamos enviando el usuario a la otra actividad
                Intent intencion = new Intent(getApplication(), Menuprincipal.class);

                //Iniciamos la otra activity
                startActivity(intencion);

                //Finalizamos la activity actual, para que cuando el usuario presione el botón de atras ya no se visualize de nuevo
                finish();
                break;
        }

    }
}
