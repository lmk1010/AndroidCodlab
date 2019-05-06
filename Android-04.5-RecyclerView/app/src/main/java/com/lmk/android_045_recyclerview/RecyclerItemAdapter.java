package com.lmk.android_045_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

public class RecyclerItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private final LinkedList<String> itemList;

    private LayoutInflater mInflater;

    public RecyclerItemAdapter(Context context,LinkedList<String> itemList) {
        //从上下文获取充气组件
        mInflater = LayoutInflater.from(context);
        //注入itemList
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View viewItem = mInflater.inflate(R.layout.recycler_item, viewGroup, false);

        return new ItemViewHolder(viewItem,this);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
        //根据位置获取当前的list中的string
        String mCurrent = itemList.get(i);
        //赋值
        viewHolder.itemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
