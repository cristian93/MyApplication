package com.i053114.myapplication.Views;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.i053114.myapplication.Adapters.FavoritosAdapters;
import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.Models.Favoritos;
import com.i053114.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListaFavoritosActivity extends AppCompatActivity  {

    SqliteHelper sqliteHelper;
    // SqliteHelper sqliteHelper2;
    RecyclerView recyclerView;
    List<Favoritos> favoritosList= new ArrayList<>();
    FavoritosAdapters favoritosAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favoritos);
        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);

        recyclerView = (RecyclerView) findViewById(R.id.id_rv_lista_favoritos);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        listIgesiasFavoritos();
    }


    public void listIgesiasFavoritos(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from favoritos order by idf desc", null);

        while (cursor.moveToNext()){
            Favoritos contact = new Favoritos();
            contact.setIdf(cursor.getInt(0));
            contact.setNamef(cursor.getString(1));
            contact.setImagenf(cursor.getString(2));
            contact.setHorariosf(cursor.getString(3));
            contact.setDescripcionf(cursor.getString(4));
            favoritosList.add(contact);
        }

        cursor.close();

        if (favoritosList.size() != 0){
            processData();
            Toast.makeText(this, "ok "+favoritosList.size(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        favoritosAdapters = new FavoritosAdapters (favoritosList, getApplicationContext());
        recyclerView.setAdapter(favoritosAdapters);
    }
}
