package com.i053114.myapplication.Views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.i053114.myapplication.Adapters.ImagesAdapter;
import com.i053114.myapplication.Connection.HttpManager;
import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.Models.Images;
import com.i053114.myapplication.Parser.JsonImages;
import com.i053114.myapplication.R;
import com.i053114.myapplication.StartActivity;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity {


    SqliteHelper sqliteHelper;
    RecyclerView recyclerView;
    List<Images> imageList= new ArrayList<>();
    ImagesAdapter imagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);


        recyclerView = (RecyclerView) findViewById(R.id.id_rv_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        listIgesias();

    }



    public void listIgesias(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from iglesias order by idi desc", null);

        while (cursor.moveToNext()){
            Images contact = new Images();
            contact.setIdi(cursor.getInt(0));
            contact.setNamei(cursor.getString(1));
            contact.setImagen(cursor.getString(2));
            contact.setHorarios(cursor.getString(3));
            contact.setDescrpcion(cursor.getString(4));
            imageList.add(contact);
        }

        cursor.close();

        if (imageList.size() != 0){
            processData();
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        imagesAdapter = new ImagesAdapter (imageList, getApplicationContext());
        recyclerView.setAdapter(imagesAdapter);
    }
}
