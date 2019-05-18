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
import com.example.UTSZHAFIR.model.FriendModel;

public class FriendAdapter extends RecyclerView.Adapter<FriendCardViewHolder> {

    private Context context;
    private FriendModel[] model;

    public FriendAdapter (Context context, FriendModel[] images) {
        this.context = context;
        this.model = images;
    }

    @NonNull
    @Override
    public FriendCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycle_daily_friend,
                parent,
                false);
        return new FriendCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FriendCardViewHolder holder, int position) {
        holder.image.setImageResource(model[position].getImage());
        holder.name.setText(model[position].getName());
        holder.location.setText(model[position].getLocation());

    }

    @Override
    public int getItemCount() {
        return model.length;
    }
}

class FriendCardViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView name, location;

    public FriendCardViewHolder (View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.daily_activity_friend_photo);
        name = itemView.findViewById(R.id.daily_activity_friend_name);
        location = itemView.findViewById(R.id.daily_activity_friend_location);
    }
}