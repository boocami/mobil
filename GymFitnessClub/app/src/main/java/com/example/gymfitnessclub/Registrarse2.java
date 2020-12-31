package com.example.gymfitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registrarse2 extends AppCompatActivity {
    EditText text_input_usuario, text_input_peso, text_input_estatura, text_input_correo, text_input_contrasena, text_input_contrasenarepetir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse2);
        text_input_usuario = (EditText) findViewById(R.id.text_input_usuario);
        text_input_peso = (EditText) findViewById(R.id.text_input_peso);
        text_input_estatura = (EditText) findViewById(R.id.text_input_estatura);
        text_input_correo = (EditText) findViewById(R.id.text_input_correo);
        text_input_contrasena = (EditText) findViewById(R.id.text_input_contrasena);
        text_input_contrasenarepetir = (EditText) findViewById(R.id.text_input_contrasenarepetir);
    }

    public void Validacion(View view){
        if(text_input_usuario.getText().toString().trim().equalsIgnoreCase("")){
            text_input_usuario.setError("Debe ingresar nombre de usuario");
        }else if(text_input_peso.getText().toString().trim().equalsIgnoreCase("")){
            text_input_peso.setError("Debe ingresar su peso actual");
        }else if(text_input_estatura.getText().toString().trim().equalsIgnoreCase("")){
            text_input_estatura.setError("Debe ingresar su estatura");
        }else if(text_input_correo.getText().toString().trim().equalsIgnoreCase("")){
            text_input_correo.setError("Debe ingresar nombre de correo");
        }else if(text_input_contrasena.getText().toString().trim().equalsIgnoreCase("")){
            text_input_contrasena.setError("Debe ingresar nombre de contrasena");
        }else if(text_input_contrasenarepetir.getText().toString().trim().equalsIgnoreCase("")){
            text_input_contrasena.setError("Debe repetir contrasena");
        }else if(text_input_contrasena.equals(text_input_contrasenarepetir)==false){
            text_input_contrasenarepetir.setError("La contraseña es diferente, vuelva a escribirla");
        }
    }

}
