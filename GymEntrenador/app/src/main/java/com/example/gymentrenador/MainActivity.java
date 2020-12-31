package com.example.gymentrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText usuario, contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        usuario = (EditText)findViewById(R.id.editTextUsuario);
        contrasena = (EditText)findViewById(R.id.editTextContrasena);
    }
    public void Validacion(View view){
        if(usuario.getText().toString().trim().equalsIgnoreCase("")){
            usuario.setError("Debe ingresar su usuario");
        }else if(contrasena.getText().toString().trim().equalsIgnoreCase("")){
            contrasena.setError("Debe ingresar su contraseña");
        }else{
            //intent, la clase intent cambia de interfaz.
            Intent intent = new Intent(this, UsuarioListado.class);
            startActivity(intent);
    }
    }

}

