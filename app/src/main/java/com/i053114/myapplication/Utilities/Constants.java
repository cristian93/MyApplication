package com.i053114.myapplication.Utilities;

/**
 * Created by chris on 15/11/2017.
 */

public class Constants {
    public static final String TABLA_NAME_USERS = "users";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NICKNAME = "nickname";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_PASSWORD = "password";
    public static final String TABLA_FIELD_LASTNAME = "lastname";
    public static final String TABLA_FIELD_PHONE = "phone";


    public static final String CREATE_TABLE_USERS =

            "CREATE TABLE "+ TABLA_NAME_USERS+" ("+
                    TABLA_FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NICKNAME+" TEXT, "+
                    TABLA_FIELD_PASSWORD+" TEXT, "+
                    TABLA_FIELD_NAME+" TEXT, "+
                    TABLA_FIELD_LASTNAME+" TEXT,"+
                    TABLA_FIELD_PHONE+" TEXT)";

}
