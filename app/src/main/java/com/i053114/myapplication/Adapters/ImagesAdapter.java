package com.i053114.myapplication.Adapters;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.Models.Images;
import com.i053114.myapplication.R;
import com.i053114.myapplication.Utilities.Constants;
import com.i053114.myapplication.Views.DescriptionActivity;
import com.i053114.myapplication.Views.NewCommentActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 17/11/2017.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {


    SqliteHelper sqliteHelper;

    List<Images> imageDatesList = new ArrayList<>();
    Context context;




    public ImagesAdapter(List<Images> imageDatesList, Context context) {
        this.imageDatesList = imageDatesList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      //  sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_iglesias, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewdesc.setText(imageDatesList.get(position).getHorarios());
        holder.textViewtitle.setText(imageDatesList.get(position).getNamei());
        holder.textViewurl.setText(imageDatesList.get(position).getImagen());



       Picasso.with(context).load(imageDatesList.get(position).getImagen()).into(holder.imageView);

        if(holder.checkBox.isChecked()){

            SQLiteDatabase db = sqliteHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Constants.TABLA_FIELD_NAMEF, imageDatesList.get(position).getNamei());
            values.put(Constants.TABLA_FIELD_IMAGENF, imageDatesList.get(position).getImagen());
            values.put(Constants.TABLA_FIELD_DIRECTIONF, imageDatesList.get(position).getDirection());
            values.put(Constants.TABLA_FIELD_HORARIOSF, imageDatesList.get(position).getHorarios());
            values.put(Constants.TABLA_FIELD_DESCRIPTIONF, imageDatesList.get(position).getDescrpcion());
            values.put(Constants.TABLA_FIELD_IDUSERF, imageDatesList.get(position).getIdi());

            db.insert(Constants.TABLA_NAME_FAVORITOS, Constants.TABLA_FIELD_IDF, values);

            //textInputEditTextName.setText("");
            //textInputEditTextPhone.setText("");
            //textInputEditTextEmail.setText("");

            //Intent intent = new Intent(this, ContactsActivity.class);
            // startActivity(intent);

            Toast.makeText(context, "favoritos guardado", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(context, "favoritos no", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return  imageDatesList.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewtitle;
        TextView  textViewurl;
        TextView textViewdesc;

        ImageView imageView;
        CheckBox checkBox;

        public ViewHolder(View item) {

            super(item);
            item.setOnClickListener(this);
            textViewtitle = (TextView) item.findViewById(R.id.id_tv_item_title);
            textViewurl = (TextView) item.findViewById(R.id.id_tv_item_url);
            textViewdesc =(TextView)item.findViewById(R.id.id_tv_item_comment_description222);



                    imageView= (ImageView) item.findViewById(R.id.img_item_cardview);
            checkBox = (CheckBox) item.findViewById(R.id.checkBox);
        }


        @Override
        public void onClick(View view) {

            Toast.makeText(context, "id_imagen"+imageDatesList.get(getLayoutPosition()).getIdi(), Toast.LENGTH_SHORT).show();

          Context contextItem = view.getContext();
            Intent intent = new Intent(context, DescriptionActivity.class);

            intent.putExtra("idi",Integer.toString (imageDatesList.get(getLayoutPosition()).getIdi()));
            intent.putExtra ("namei", imageDatesList.get(getLayoutPosition()).getNamei());
            intent.putExtra ("imagen", imageDatesList.get(getLayoutPosition()).getImagen());
            intent.putExtra("direction" ,imageDatesList.get(getLayoutPosition()).getDirection());
            intent.putExtra("horarios", imageDatesList.get(getLayoutPosition()).getHorarios());
            intent.putExtra("descripcion", imageDatesList.get(getLayoutPosition()).getDescrpcion());
            contextItem.startActivity(intent);

        }
    }

}


