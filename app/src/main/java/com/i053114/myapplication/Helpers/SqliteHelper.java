package com.i053114.myapplication.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.i053114.myapplication.Utilities.Constants;

/**
 * Created by chris on 15/11/2017.
 */

public class SqliteHelper  extends SQLiteOpenHelper{

    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE_USERS);
        db.execSQL(Constants.CREATE_TABLE_IGLESIAS);

        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('san felipe', 'http://www.turismopasto.gov.co/images/iglesias/tsanfelipe2.jpg', 'calle falsa 123','horario falso','descripcion falsa')");


        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('falsa', 'https://pasto-ciudad-sorpresa.wikispaces.com/file/view/templo_cristo_rey_pasto_narino_colombia_031508.jpg/262194364/312x456/templo_cristo_rey_pasto_narino_colombia_031508.jpg'," +
                " 'calle falsa 123','horario falso','descripcion falsa')");



        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('falsa3', 'https://media-cdn.tripadvisor.com/media/photo-s/04/39/57/a2/fachada-iglesia-catedral.jpg', 'calle falsa 123','horario falso','descripcion falsa')");



        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('falsa 4', 'http://www.turismopasto.gov.co/images/iglesias/tfatima2.jpg', 'calle falsa 123','horario falso','descripcion falsa')");



        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('falsa 5', 'http://static.panoramio.com/photos/original/3115787.jpg', 'calle falsa 123','horario falso','descripcion falsa')");


        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('falsa 6', 'https://instanttanne.files.wordpress.com/2016/03/iglesia-san-agustin-pasto.jpg', 'calle falsa 123','horario falso','descripcion falsa')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_USERS);
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_IGLESIAS);
        onCreate(db);
    }


}


