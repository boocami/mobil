package com.example.duque.sqlite3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {
    TextView tv1;
    EditText edt1, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
        String rut, nombre, apellido;
        rut = getIntent().getStringExtra("rut");
        nombre = getIntent().getStringExtra("nombre");
        apellido = getIntent().getStringExtra("apellido");

        tv1 = (TextView) findViewById(R.id.textView);
        edt1 = (EditText) findViewById(R.id.editText4);
        edt2 = (EditText) findViewById(R.id.editText5);

        tv1.setText(rut);
        edt1.setText(nombre);
        edt2.setText(apellido);
    }
    
}
