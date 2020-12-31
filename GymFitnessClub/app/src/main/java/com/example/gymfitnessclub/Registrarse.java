package com.example.gymfitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.Calendar;

public class Registrarse extends AppCompatActivity  {
    EditText text_input_nombre, text_input_apaterno, text_input_apmaterno, text_input_fechanacimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        text_input_nombre = (EditText) findViewById(R.id.text_input_nombre);
        text_input_apaterno = (EditText) findViewById(R.id.text_input_apaterno);
        text_input_apmaterno = (EditText) findViewById(R.id.text_input_apmaterno);
        text_input_fechanacimiento = (EditText) findViewById(R.id.text_input_fechanacimiento);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Registrarse.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.genero));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }


    public void Validacion(View view){
        if(text_input_nombre.getText().toString().trim().equalsIgnoreCase("")){
            text_input_nombre.setError("Debe ingresar su nombre ");
        }else if(text_input_apaterno.getText().toString().trim().equalsIgnoreCase("")){
            text_input_apmaterno.setError("Debe ingresar apellido paterno");
        }else if(text_input_apmaterno.getText().toString().trim().equalsIgnoreCase("")){
            text_input_apmaterno.setError("Debe ingresar apellido materno");
        }else if(text_input_fechanacimiento.getText().toString().trim().equalsIgnoreCase("")){
            text_input_fechanacimiento.setError("Debe ingresar su fecha de nacimiento");
        }else{
            Intent intent = new Intent(this, Registrarse2.class);
            startActivity(intent);
        }
    }
    public void Calendario(View view){
        //Instanciar el calendario
        final Calendar calendar = Calendar.getInstance();
        //Obtener la fecha por separado
        int anio  = calendar.get(Calendar.YEAR);
        int mes  = calendar.get(Calendar.MONTH);
        int dia  = calendar.get(Calendar.DAY_OF_MONTH);
        //Datepickeardialog es el que carga el calendario en un widget (Editable)
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int mes2 = month +1;
                String fechac = dayOfMonth+"/"+mes2+"/"+year;
                text_input_fechanacimiento.setText(fechac);//carga fecha en edittext
            }
        }, anio,mes,dia);
        datePickerDialog.show();
    }

    public void VolverIniciar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}





