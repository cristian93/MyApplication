package com.i053114.myapplication.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.Models.User;
import com.i053114.myapplication.R;
import com.i053114.myapplication.Utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class IngresarActivity extends AppCompatActivity {

    EditText editTextNickName;
    EditText editTextPassword;
    List<User> contactList = new ArrayList<>();
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);

        editTextNickName = (EditText) findViewById(R.id.id_tv_detail_nickname_ingreso);
        editTextPassword = (EditText) findViewById(R.id.id_tv_detail_pasword_ingreso1);

    }



    public void searchContact(View  view) {

        SQLiteDatabase db = sqliteHelper.getReadableDatabase();

        //String[] params = {editTextNickName.getText().toString(),editTextPassword.getText().toString()};
       // String[] fields = {Constants.TABLA_FIELD_ID, Constants.TABLA_FIELD_NICKNAME, Constants.TABLA_FIELD_PASSWORD, Constants.TABLA_FIELD_NAME, Constants.TABLA_FIELD_LASTNAME, Constants.TABLA_FIELD_PHONE};
        String nickname1 = editTextNickName.getText().toString();
        String password1 = editTextPassword.getText().toString();


        try {

            Cursor cursor = db.rawQuery("select * from users  where nickname = '"+nickname1+"' and password = '"+password1+"'",null);

            if(cursor.moveToNext()){
                Integer id_user = cursor.getInt(0);
                String nickname = cursor.getString(1);
                String pasword = cursor.getString(3);


                if(nickname1.equals(nickname) && password1.equals(pasword) ){

                   // Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, ListActivity.class);

                    //Toast.makeText(this, "Bienvenido"+id_user, Toast.LENGTH_SHORT).show();
                   startActivity(intent);

                }
            }else{
                Toast.makeText(this, "no hay resultados", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            Toast.makeText(this, "Nombre del contacto no encontrado", Toast.LENGTH_SHORT).show();
        }

    }


}





