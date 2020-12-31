package com.example.gymentrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Evaluacion2 extends AppCompatActivity {
    EditText grasaInstrumental;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion2);
        grasaInstrumental = (EditText) findViewById(R.id.textInputGrasaInstrumento);
    }

    public void Validacion (View view){
        if(grasaInstrumental.getText().toString().trim().equalsIgnoreCase("")){
            grasaInstrumental.setError("Debe ingresar grasa intrumental");
        }
    }
}
