package com.gjiazhe.layoutswitch;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gjz on 16/01/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    public static final int SPAN_COUNT_SMALL = 1;
    public static final int SPAN_COUNT_BIG = 3;

    private List<Item> mItems;
    private GridLayoutManager mLayoutManager;

    public ItemAdapter(List<Item> items, GridLayoutManager layoutManager) {
        mItems = items;
        mLayoutManager = layoutManager;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == SPAN_COUNT_SMALL) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_big, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_small, parent, false);
        }
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = mItems.get(position % 4);
        holder.title.setText(item.getTitle());
        holder.iv.setImageResource(item.getImgResId());
        if (mLayoutManager.getSpanCount() == SPAN_COUNT_SMALL) {
            holder.info.setText(item.getLikes() + " likes  ·  " + item.getComments() + " comments");
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView title;
        TextView info;

        ItemViewHolder(View itemView) {
            super(itemView);
            if (mLayoutManager.getSpanCount() == SPAN_COUNT_SMALL) {
                iv = (ImageView) itemView.findViewById(R.id.image_big);
                title = (TextView) itemView.findViewById(R.id.title_big);
                info = (TextView) itemView.findViewById(R.id.tv_info);
            } else {
                iv = (ImageView) itemView.findViewById(R.id.image_small);
                title = (TextView) itemView.findViewById(R.id.title_small);
            }
        }
    }
}
