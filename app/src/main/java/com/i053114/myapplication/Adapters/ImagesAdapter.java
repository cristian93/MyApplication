package com.i053114.myapplication.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.i053114.myapplication.Models.Images;
import com.i053114.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 17/11/2017.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {


    List<Images> imageDatesList = new ArrayList<>();
    Context context;


    public ImagesAdapter(List<Images> imageDatesList, Context context) {
        this.imageDatesList = imageDatesList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_iglesias, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textViewtitle.setText(imageDatesList.get(position).getNamei());
        holder.textViewurl.setText(imageDatesList.get(position).getDescrpcion());


       Picasso.with(context).load(imageDatesList.get(position).getImagen()).into(holder.imageView);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(compoundButton.isChecked()){
                    Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
                }else{
                Toast.makeText(context, "no", Toast.LENGTH_SHORT).show();}
            }
        });


    }

    @Override
    public int getItemCount() {
        return  imageDatesList.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView  textViewurl;
        ImageView imageView;
        CheckBox checkBox;

        public ViewHolder(View item) {
            super(item);
            textViewtitle = (TextView) item.findViewById(R.id.id_tv_item_title);
            textViewurl = (TextView) item.findViewById(R.id.id_tv_item_url);
            imageView= (ImageView) item.findViewById(R.id.img_item_cardview);
            checkBox = (CheckBox) item.findViewById(R.id.checkBox);
        }



    }
}
