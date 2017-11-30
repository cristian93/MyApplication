package com.i053114.myapplication.Views;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.i053114.myapplication.Adapters.ImagesAdapter;
import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.R;
import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {
    ImageView Imagen;
    TextView Namei;
    TextView Direction;
    TextView Horarios;
    TextView Descripcion;
    Context context;
    Integer id_imagen;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        Imagen = (ImageView) findViewById(R.id.img_post);
        Namei = (TextView) findViewById(R.id.id_tv_item_comment_nombre);
        Direction = (TextView) findViewById(R.id.id_tv_item_comment_ubication);
        Horarios = (TextView) findViewById(R.id.id_tv_item_comment_horary);
        Descripcion = (TextView) findViewById(R.id.id_tv_item_comment_description);

      //  sqliteHelper = new SqliteHelper(this, "db_comment", null, 1);


        id_imagen = Integer.parseInt(getIntent().getExtras().getString("idi"));

      //Toast.makeText(context, "id_imagen ESTA SI"+getIntent().getExtras().getString("idi"), Toast.LENGTH_SHORT).show();

        Namei.setText(getIntent().getExtras().getString("namei"));

        Picasso.with(context).load(getIntent().getExtras().getString("imagen")).into(Imagen);
        Direction.setText(getIntent().getExtras().getString("direction"));
        Horarios.setText(getIntent().getExtras().getString("horarios"));
        Descripcion.setText(getIntent().getExtras().getString("descripcion"));


    }

    public void onClickNewcommentactivity(View view) {

        Toast.makeText(this, "id imagen"+id_imagen, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, NewCommentActivity.class);
       intent.putExtra ("idi2",Integer.parseInt(getIntent().getExtras().getString("idi")));
        view.getContext().startActivity(intent);
    }

    public void onClickShowWindowListComments(View view) {
        Intent intent = new Intent(this, ListCommentActivity.class);
        startActivity(intent);
    }


}
