package com.r.seminarevent.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.r.seminarevent.R;

/**
 * Created by Unknown on 3/16/2018.
 */

public class SeminarEventAdAdapter extends RecyclerView.Adapter<SeminarEventAdAdapter.ViewHolder> {

    private Integer[] images = {R.drawable.seminar1, R.drawable.seminar2, R.drawable.seminar3};
    Context context;

    public SeminarEventAdAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seminar_event_ad_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.gambar.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView gambar;
        public ViewHolder(View itemView) {
            super(itemView);
            gambar = (ImageView) itemView.findViewById(R.id.seminarEventAdIV);
        }
    }
}
