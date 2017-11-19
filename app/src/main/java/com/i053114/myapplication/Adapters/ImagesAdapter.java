package com.i053114.myapplication.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        holder.textViewtitle.setText(imageDatesList.get(position).getTitle());
        holder.textViewurl.setText(imageDatesList.get(position).getUrl());
        String [] images ;
        images  = new String[ 6];

        images [0]="http://www.turismopasto.gov.co/images/iglesias/tsanfelipe2.jpg";
        images [1]="https://pasto-ciudad-sorpresa.wikispaces.com/file/view/templo_cristo_rey_pasto_narino_colombia_031508.jpg/262194364/312x456/templo_cristo_rey_pasto_narino_colombia_031508.jpg";
        images [2]="https://media-cdn.tripadvisor.com/media/photo-s/04/39/57/a2/fachada-iglesia-catedral.jpg";
        images [3]="http://www.turismopasto.gov.co/images/iglesias/tfatima2.jpg";
        images [4]="http://static.panoramio.com/photos/original/3115787.jpg ";
        images [5]="https://instanttanne.files.wordpress.com/2016/03/iglesia-san-agustin-pasto.jpg";


        int number = (int ) (Math.random()*5);

        Picasso.with(context).load(images[number]).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return  imageDatesList.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView  textViewurl;
        ImageView imageView;

        public ViewHolder(View item) {
            super(item);
            textViewtitle = (TextView) item.findViewById(R.id.id_tv_item_title);
            textViewurl = (TextView) item.findViewById(R.id.id_tv_item_url);
            imageView= (ImageView) item.findViewById(R.id.img_item_cardview);
        }



    }
}
