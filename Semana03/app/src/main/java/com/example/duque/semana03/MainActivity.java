package com.example.duque.semana03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declarar variables del tipo de dato que corresponda.
    EditText edt1, edt2, edt3;
    TextView tv1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //relacionar las variables con los widgets
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText2);
        edt3 = (EditText) findViewById(R.id.editText3);
        tv1 = (TextView) findViewById(R.id.textView);

    }

    public void CapturaDatos(View view){
        String nombre, apellido, msj;
        int edad;
        //capturar los valores, validando que no deje campos vacios.
        if(edt1.getText().toString().trim().equalsIgnoreCase("")){
            edt1.setError("Debe ingresar su nombre");
        }else if(edt2.getText().toString().trim().equalsIgnoreCase("")){
            edt2.setError("Debe ingresar su apellido");
        }else if(edt3.getText().toString().trim().equalsIgnoreCase("")){
            edt3.setError("Debe ingresar su edad");
        }else{
            //recuperar los datos.
            nombre = edt1.getText().toString();
            apellido = edt2.getText().toString();
            edad = Integer.parseInt(edt3.getText().toString());
            msj = "Nombre "+nombre+" Apellido "+apellido;
            //mostramos en un mensaje flotante TOAST
            Toast.makeText(this, msj, Toast.LENGTH_LONG).show();
            tv1.setText(msj);
            Operacion operacion = new Operacion();
            String mensaje = operacion.verificaEdad(edad);
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }
    public void CambiarRegistro(View view){
        //intent, la clase intent cambia de interfaz.
        Intent intent = new Intent(this, RegistrarUsuario.class);
        startActivity(intent);
    }
}
