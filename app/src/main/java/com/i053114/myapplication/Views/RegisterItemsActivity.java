package com.i053114.myapplication.Views;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.R;
import com.i053114.myapplication.StartActivity;
import com.i053114.myapplication.Utilities.Constants;

public class RegisterItemsActivity extends Activity {


    TextInputEditText textInputEditTextNickName;
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextLastName;
    TextInputEditText textInputEditTextPhone;
    TextInputEditText textInputEditTextPasword;
    SqliteHelper sqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_items);

        textInputEditTextNickName = (TextInputEditText) findViewById(R.id.id_tv_detail_nickname_register);


        textInputEditTextPasword = (TextInputEditText) findViewById(R.id.id_tv_detail_pasword_register);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tv_detail_nombre_register);

        textInputEditTextLastName = (TextInputEditText) findViewById(R.id.id_tv_detail_apellido_register);

        textInputEditTextPhone = (TextInputEditText) findViewById(R.id.id_tv_detail_telefono_register);


        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);


    }



    public void onClickCreateUser(View view){
        String stringNickName = textInputEditTextNickName.getText().toString();
        String stringPassword = textInputEditTextPasword.getText().toString();
        String stringName = textInputEditTextName.getText().toString();
        String stringLAstName = textInputEditTextLastName.getText().toString();
        String stringPhone = textInputEditTextPhone.getText().toString();


        if (TextUtils.isEmpty(stringNickName)){
            Toast.makeText(this, "El campo de nombre esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPassword)){
            Toast.makeText(this, "El campo de telefono esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringName)){
            Toast.makeText(this, "El campo de email esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringLAstName)){
            Toast.makeText(this, "El campo de email esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPhone)){
            Toast.makeText(this, "El campo de email esta vacio", Toast.LENGTH_SHORT).show();
        } else{
            createUser();
        }
    }

    public void createUser(){
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Constants.TABLA_FIELD_NICKNAME, textInputEditTextNickName.getText().toString());
        values.put(Constants.TABLA_FIELD_PASSWORD, textInputEditTextPasword.getText().toString());
        values.put(Constants.TABLA_FIELD_NAME, textInputEditTextName.getText().toString());
        values.put(Constants.TABLA_FIELD_LASTNAME, textInputEditTextLastName.getText().toString());
        values.put(Constants.TABLA_FIELD_PHONE, textInputEditTextPhone.getText().toString());


        db.insert(Constants.TABLA_NAME_USERS, Constants.TABLA_FIELD_ID, values);

        Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();

        textInputEditTextName.setText("");
        textInputEditTextPhone.setText("");
        textInputEditTextPasword.setText("");
        textInputEditTextNickName.setText("");
        textInputEditTextLastName.setText("");


        Intent intent = new Intent(this, StartActivity.class);
      //  intent.putExtra ("id", Constants.TABLA_FIELD_ID);
        startActivity(intent);
    }

}
