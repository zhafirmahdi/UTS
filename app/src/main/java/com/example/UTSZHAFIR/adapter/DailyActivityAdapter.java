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
import com.example.UTSZHAFIR.model.DailyActivityModel;
//17-05-2019-10116368-ZHAFIR-MAHDI-IF-8
public class DailyActivityAdapter extends RecyclerView.Adapter<DefaultCardViewHolder> {

    private Context context;
    private DailyActivityModel[] model;

    public DailyActivityAdapter(Context context, DailyActivityModel[] model) {
        this.context = context;
        this.model= model;
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous

        switch (model[position].getType()) {
            case "image3":
                return 0;
            case "image1":
                return 1;
            default:
                return 2;
        }
    }

    @NonNull
    @Override
    public DefaultCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recycle_daily_three_image,
                        parent,
                        false);
                return new CardWithThreeImageViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recycle_daily_one_image,
                        parent,
                        false);
                return new CardWithOneImageViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recycle_daily_text_only,
                        parent,
                        false);
                return new CardOnlyTextViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull DefaultCardViewHolder holder, int position) {
        holder.times.setText(model[position].getTime());
        holder.location.setText(model[position].getLocation());
        holder.text.setText(model[position].getText());
        holder.like.setText(Integer.toString(model[position].getLike()));
        holder.comment.setText(Integer.toString(model[position].getComment()));
        String viewType = model[position].getType();

        switch (viewType) {
            case "image3":
                holder.image1.setImageResource(model[position].getImage()[0]);
                holder.image2.setImageResource(model[position].getImage()[1]);
                holder.image3.setImageResource(model[position].getImage()[2]);
            case "image1":
                holder.image1.setImageResource(model[position].getImage()[0]);
            default:
                break;
        }

    }


    @Override
    public int getItemCount() {
        return model.length;
    }
}

class DefaultCardViewHolder extends RecyclerView.ViewHolder {
    TextView times, location, text, like, comment;
    ImageView image1, image2, image3;
    public DefaultCardViewHolder(View itemView) {
        super(itemView);
        times = itemView.findViewById(R.id.daily_activity_times);
        location = itemView.findViewById(R.id.daily_activity_location);
        text = itemView.findViewById(R.id.daily_activity_text);
        like = itemView.findViewById(R.id.daily_activity_like);
        comment = itemView.findViewById(R.id.daily_activity_comment);
    }
}

class CardOnlyTextViewHolder extends DefaultCardViewHolder {
    public CardOnlyTextViewHolder(View itemView) {
        super(itemView);
    }
}

class CardWithOneImageViewHolder extends DefaultCardViewHolder {
    public CardWithOneImageViewHolder(View itemView) {
        super(itemView);
        image1 = itemView.findViewById(R.id.daily_activity_image1);
    }
}

class CardWithThreeImageViewHolder extends DefaultCardViewHolder {
    public CardWithThreeImageViewHolder(View itemView) {
        super(itemView);
        image1 = itemView.findViewById(R.id.daily_activity_image1);
        image2 = itemView.findViewById(R.id.daily_activity_image2);
        image3 = itemView.findViewById(R.id.daily_activity_image3);
    }
}