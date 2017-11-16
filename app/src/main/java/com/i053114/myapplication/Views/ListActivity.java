package com.i053114.myapplication.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.i053114.myapplication.R;
import com.i053114.myapplication.StartActivity;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }




    public void onClickRegistrarse(View view){

        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}
