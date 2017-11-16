package com.i053114.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.i053114.myapplication.Views.IngresarActivity;
import com.i053114.myapplication.Views.RegisterItemsActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }



    public void onClickIngresar(View view){
        Intent intent = new Intent(this, IngresarActivity.class);
        startActivity(intent);
    }

    public void onClickRegistrarse(View view){
        Intent intent = new Intent(this, RegisterItemsActivity.class);
        startActivity(intent);
    }

}
