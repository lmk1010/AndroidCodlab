package com.lmk.android_045_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public final TextView itemView;

    final RecyclerItemAdapter recyclerItemAdapter;


    public ItemViewHolder(@NonNull View itemView, RecyclerItemAdapter recyclerItemAdapter) {
        super(itemView);
        this.itemView = itemView.findViewById(R.id.item);
        this.recyclerItemAdapter = recyclerItemAdapter;
    }


}
