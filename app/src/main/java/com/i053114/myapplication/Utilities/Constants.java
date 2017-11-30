package com.i053114.myapplication.Utilities;

/**
 * Created by chris on 15/11/2017.
 */

public class Constants {


    //USER...................
    public static final String TABLA_NAME_USERS = "users";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NICKNAME = "nickname";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_PASSWORD = "password";
    public static final String TABLA_FIELD_LASTNAME = "lastname";
    public static final String TABLA_FIELD_PHONE = "phone";


    public static final String CREATE_TABLE_USERS =

            "CREATE TABLE " + TABLA_NAME_USERS + " (" +
                    TABLA_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLA_FIELD_NICKNAME + " TEXT, " +
                    TABLA_FIELD_PASSWORD + " TEXT, " +
                    TABLA_FIELD_NAME + " TEXT, " +
                    TABLA_FIELD_LASTNAME + " TEXT," +
                    TABLA_FIELD_PHONE + " TEXT)";


    // Iglesias ..................
    public static final String TABLA_NAME_IGLESIAS = "iglesias";
    public static final String TABLA_FIELD_IDI = "idi";
    public static final String TABLA_FIELD_NAMEI = "namei";
    public static final String TABLA_FIELD_IMAGEN = "imagen";
    public static final String TABLA_FIELD_DIRECTION = "direction";
    public static final String TABLA_FIELD_HORARIOS = "horarios";
    public static final String TABLA_FIELD_DESCRIPTION = "descripcion";
    public static final String CREATE_TABLE_IGLESIAS =
            "CREATE TABLE " + TABLA_NAME_IGLESIAS + " (" +
                    TABLA_FIELD_IDI + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLA_FIELD_NAMEI + " TEXT, " +
                    TABLA_FIELD_IMAGEN + " TEXT, " +
                    TABLA_FIELD_DIRECTION + " TEXT, " +
                    TABLA_FIELD_HORARIOS + " TEXT, " +
                    TABLA_FIELD_DESCRIPTION + " TEXT)";


    // Coments- users
    public static final String TABLA_NAME_COMMENTSUSERS = "commentsUsers";
    public static final String TABLA_FIELD_IDCommentUsers = "idCommentUser";
    public static final String TABLA_FIELD_TITLEComent = "titleComent";
    public static final String TABLA_FIELD_descriptionCOMMENT = "descriptionComment";
    public static final String TABLA_FIELD_IDIglesia = "idi2";
    //public static final String TABLA_FIELD_IDuser = "idu";

    public static final String CREATE_TABLE_COMMENTSUSERS =
            "CREATE TABLE " + TABLA_NAME_COMMENTSUSERS + " (" +
                    TABLA_FIELD_IDCommentUsers + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLA_FIELD_TITLEComent + " TEXT, " +
                    TABLA_FIELD_descriptionCOMMENT + " TEXT, " +
                    TABLA_FIELD_IDIglesia + " INTEGER) ";




    // FAvoritos
    public static final String TABLA_NAME_FAVORITOS = "favoritos";
    public static final String TABLA_FIELD_IDF = "idf";
    public static final String TABLA_FIELD_NAMEF = "namef";
    public static final String TABLA_FIELD_IMAGENF = "imagen";
    public static final String TABLA_FIELD_DIRECTIONF = "directionf";
    public static final String TABLA_FIELD_HORARIOSF = "horariosf";
    public static final String TABLA_FIELD_DESCRIPTIONF = "descripcionf";
    public static final String TABLA_FIELD_IDUSERF = "Iduserf";



    public static final String CREATE_TABLE_FAVORITOS =

            "CREATE TABLE " + TABLA_NAME_FAVORITOS + " (" +
                    TABLA_FIELD_IDF + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLA_FIELD_NAMEF + " TEXT, " +
                    TABLA_FIELD_IMAGENF + " TEXT, " +
                    TABLA_FIELD_DIRECTIONF + " TEXT, " +
                    TABLA_FIELD_HORARIOSF + " TEXT, " +
                    TABLA_FIELD_DESCRIPTIONF + " TEXT, " +
                    TABLA_FIELD_IDUSERF + " TEXT)";


}
