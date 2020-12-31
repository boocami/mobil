package com.example.gymentrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class Evaluacion extends AppCompatActivity {
    EditText fechaEvaluacion,peso,estatura,medidaCintura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fechaEvaluacion = (EditText) findViewById(R.id.textInputFecha);
        peso = (EditText) findViewById(R.id.textInputPeso);
        estatura = (EditText)findViewById(R.id.textInputEstatura);
        medidaCintura = (EditText) findViewById(R.id.textInputMedidaCintura);
    }

    public void Validacion (View view){
        if(fechaEvaluacion.getText().toString().trim().equalsIgnoreCase("")){
            fechaEvaluacion.setError("Debe ingresar la fecha de evaluacion");
        }else if(peso.getText().toString().trim().equalsIgnoreCase("")){
            peso.setError("Debe ingresar el peso");
        }else if(estatura.getText().toString().trim().equalsIgnoreCase("")){
            estatura.setError("Debe ingresar la estatura");
        }else if(medidaCintura.getText().toString().trim().equalsIgnoreCase("")){
            medidaCintura.setError("Debe ingresar la medida de cintura");
        }else{
            Intent intent = new Intent(this, Evaluacion2.class);
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
                fechaEvaluacion.setText(fechac);//carga fecha en edittext
            }
        }, anio,mes,dia);
        datePickerDialog.show();
    }

}
