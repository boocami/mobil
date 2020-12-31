package com.example.duque.sqlite3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2, edt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText2);
        edt3 = (EditText) findViewById(R.id.editText3);
    }

    public void registrarUsuario(View view){
        if(edt1.getText().toString().trim().equalsIgnoreCase("")){
            edt1.setError("Debe ingresar su Rut");
        }else if(edt2.getText().toString().trim().equalsIgnoreCase("")){
            edt2.setError("Debe ingresar su Nombre");
        }else if(edt3.getText().toString().trim().equalsIgnoreCase("")){
            edt3.setError("Debe ingresar su Apellido");
        }else{
            String rut, nombre, apellido;
            rut = edt1.getText().toString();
            nombre = edt2.getText().toString();
            apellido = edt3.getText().toString();

            //instanciamos la clase DbHelper.
            DbHelper dbHelper = new DbHelper(this, "bdgym",null,1);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            if(sqLiteDatabase != null){
                // manejo de persistencia a través de un objeto.
                ContentValues contentValues = new ContentValues();
                //debemos cargar el objeto con los datos.
                contentValues.put("rut", rut);
                contentValues.put("nombre", nombre);
                contentValues.put("apellido", apellido);
                 long nfilas = sqLiteDatabase.insert("tblpersona",null,contentValues);
                if(nfilas > 0){
                    Toast.makeText(this, "Registro insertado con exito", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "No hay permiso de escritura", Toast.LENGTH_SHORT).show();
            }





        }




    }
    public void cambiarActivity(View view){
        Intent intent = new Intent(this, MostrarUsuarios.class);
        startActivity(intent);
    }
}
