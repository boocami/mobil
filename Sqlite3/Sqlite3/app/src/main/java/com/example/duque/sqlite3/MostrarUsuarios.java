package com.example.duque.sqlite3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MostrarUsuarios extends AppCompatActivity {
    ListView lv;

    //metodo para hacer un auto post back ( recarga )


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios);
        lv = (ListView) findViewById(R.id.listview0);
        ListarDatos();
        //programacion del evento onClick del listView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = lv.getItemAtPosition(position).toString();
                Toast.makeText(MostrarUsuarios.this, "Item recuperado "+item, Toast.LENGTH_SHORT).show();

                String rut = item.split(" ")[0];
                String nombre = item.split(" ")[1];
                String apellido = item.split(" ")[2];

                Intent intent = new Intent(MostrarUsuarios.this, DetallePersona.class);
                intent.putExtra("rut", rut);
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido", apellido);
                startActivity(intent);
            }
        });
    }

    public void ListarDatos(){

        DbHelper dbHelper = new DbHelper(this, "bdgym", null, 1);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        if(sqLiteDatabase != null){
         //String rutb="123-4";
         //Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tblpersona WHERE rut = '"+rutb+"'",null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tblpersona",null);
         int dimension = cursor.getCount(); //cuenta filas.
         String[] datoUsario = new String[dimension];
         int i=0;
                    if(cursor.moveToFirst()){

                        do{
                          //  String rowid = cursor.getString(0);
                         String rut = cursor.getString(0);
                         String nombre = cursor.getString(1);
                         String apellido = cursor.getString(2);
                         String item = rut+" "+nombre+" "+apellido;
                         datoUsario[i] = item;
                         i++;
                        }while(cursor.moveToNext());
                    }
                    cursor.close();
                    //ya tenemos el origen de datos cargado en un vector
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datoUsario);
                    lv.setAdapter(adapter);

        }else{
            Toast.makeText(this, "No se puede leer base de datos...", Toast.LENGTH_SHORT).show();
        }


    }
}
