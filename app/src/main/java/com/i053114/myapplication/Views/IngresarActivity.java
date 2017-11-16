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


        editTextNickName = (EditText) findViewById(R.id.id_tv_detail_nickname_ingreso);
        editTextPassword = (EditText) findViewById(R.id.id_tv_detail_pasword_ingreso);
        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);
    }

    public void onClickSearchContact(View view) {
        searchContact();
    }

    public void searchContact() {

        SQLiteDatabase db = sqliteHelper.getReadableDatabase();

        String[] params = {editTextNickName.getText().toString()};
        String[] fields = {Constants.TABLA_FIELD_ID, Constants.TABLA_FIELD_NICKNAME, Constants.TABLA_FIELD_PASSWORD, Constants.TABLA_FIELD_NAME, Constants.TABLA_FIELD_LASTNAME, Constants.TABLA_FIELD_PHONE};

        db.execSQL("");


        Cursor cursor = db.query(Constants.TABLA_NAME_USERS, fields, Constants.TABLA_FIELD_NICKNAME + "=?", params, null, null, null);

        while (cursor.moveToNext()) {
            User contact = new User();
            contact.setId(cursor.getInt(0));
            contact.setNickname(cursor.getString(1));
            contact.setName(cursor.getString(2));
            contact.setLastname(cursor.getString(3));
            contact.setPhone(cursor.getString(4));

            contactList.add(contact);
        }

        cursor.close();

        if (contactList.size() != 0) {


            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);


        } else {
            Toast.makeText(this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
        }
    }


}
