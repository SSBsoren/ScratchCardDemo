package com.sagensoren.scratchcarddemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.List;

public class ScratchAdapter extends RecyclerView.Adapter<ScratchAdapter.MyViewHolder> {

    private List<ScratchModel> scratchModelList;
    private OnCardItemClickListener onCardItemClickListener;


    public ScratchAdapter(List<ScratchModel> scratchModelList,OnCardItemClickListener onCardItemClickListener) {
        this.scratchModelList = scratchModelList;
        this.onCardItemClickListener = onCardItemClickListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scratchs, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        ScratchModel model = scratchModelList.get(position);
        holder.imageView.setImageResource(model.getImg_scratch());
      //  holder.rupee.setText("You've won \n\u20B9" + String.valueOf(model.getRupees()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onCardItemClickListener != null){
                    onCardItemClickListener.cardItemClicked(holder.getAdapterPosition());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return scratchModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_img);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }
}
