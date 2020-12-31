package com.example.gymfitnessclub;

import androidx.appcompat.app.AppCompatActivity;


import android.widget.EditText;
import  android.widget.Button;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.View;
import android.content.Intent;


import static android.view.WindowManager.*;

public class MainActivity extends AppCompatActivity {
    //Declaramos el tipo y las id de los elementos a usar
    EditText text_input_usuario, text_input_contrasena;
    Button botonIniciarSesion, Registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);

        //Inicializamos las variables
        text_input_usuario = (EditText) findViewById(R.id.text_input_usuario);
        text_input_contrasena = (EditText) findViewById(R.id.text_input_contrasena);
    }


    //Metodos

    public void Validacion(View view){
        if(text_input_usuario.getText().toString().trim().equalsIgnoreCase("")){
            text_input_usuario.setError("Debe ingresar usuario");
        }else if(text_input_contrasena.getText().toString().trim().equalsIgnoreCase("")){
            text_input_contrasena.setError("Debe ingresar contraseÃƒÂ±as");
        }

    }

    public void Registro(View view){
        //intent, la clase intent cambia de interfaz.
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }

    public void RestablecerContraseña(View view){
        //intent, la clase intent cambia de interfaz.
        Intent intent = new Intent(this, OlvidasteTuContrasena.class);
        startActivity(intent);
    }
}

