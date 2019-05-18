package com.example.UTSZHAFIR.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.UTSZHAFIR.R;
import com.example.UTSZHAFIR.model.GalleryModel;
//17-05-2019-10116368-ZHAFIR-MAHDI-IF-8
public class GalleryAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private Context context;
    private GalleryModel[] images;

    public GalleryAdapter(Context context, GalleryModel[] images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycle_gallery_card,
                parent,
                false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlaceViewHolder holder, int position) {
        holder.image.setImageResource(images[position].getImage());
        holder.title.setText(images[position].getTitle());
        holder.location.setText(images[position].getLocation());

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}

class PlaceViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView title, location;

    public PlaceViewHolder(View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.gallery_image_card);
        title = itemView.findViewById(R.id.gallery_image_title);
        location = itemView.findViewById(R.id.gallery_image_location);
    }
}