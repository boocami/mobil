package com.example.gymfitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

public class OlvidasteTuContrasena extends AppCompatActivity {
    Button recuperarContrasena;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidaste_tu_contrasena);
        email = findViewById(R.id.text_input_correo);
        recuperarContrasena = findViewById(R.id.botonContrasena);
    }
}
