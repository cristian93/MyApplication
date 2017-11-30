package com.i053114.myapplication.Views;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.R;
import com.i053114.myapplication.Utilities.Constants;

public class NewCommentActivity extends Activity {
    EditText editTexttitle;
    EditText editTextDescription;

    Integer Idcontact;

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comment);

        editTexttitle = (EditText) findViewById(R.id.id_et_comment_decription_title);

        editTextDescription = (EditText) findViewById(R.id.id_et_comment_decription);

      Idcontact =  getIntent().getExtras().getInt("idi2");

        sqliteHelper = new SqliteHelper(this, " db_comment", null, 1);

    }

    public void onclickCreateComment(View view) {

        String stringTitle = editTexttitle.getText().toString();
        String stringDescription = editTextDescription.getText().toString();

        Toast.makeText(this, "El id imagen es:"+Idcontact, Toast.LENGTH_SHORT).show();

        createComment();

       /* if (TextUtils.isEmpty(stringTitle)) {
            Toast.makeText(this, "El campo de titulo esta vacio", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(stringDescription)) {
            Toast.makeText(this, "El campo de descripcion esta vacio", Toast.LENGTH_SHORT).show();
        } else {
            createComment();
        }*/

    }

    public void createComment() {

        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Constants.TABLA_FIELD_TITLEComent, editTexttitle.getText().toString());
       // Toast.makeText(this, editTexttitle.getText().toString(), Toast.LENGTH_SHORT).show();

        values.put(Constants.TABLA_FIELD_descriptionCOMMENT, editTextDescription.getText().toString());
      // Toast.makeText(this, editTextDescription.getText().toString(), Toast.LENGTH_SHORT).show();
        values.put(Constants.TABLA_FIELD_IDIglesia, Idcontact);

       //Toast.makeText(this, ""+Idcontact, Toast.LENGTH_SHORT).show();


        Long idResult = db.insert(Constants.TABLA_NAME_COMMENTSUSERS, Constants.TABLA_FIELD_IDCommentUsers, values);

        if (idResult >0){
            Toast.makeText(this, "comentario guardado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ListCommentActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "comentario no guardado", Toast.LENGTH_SHORT).show();
        }
    }
}
