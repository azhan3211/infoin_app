package com.r.seminarevent.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.r.seminarevent.R;

import java.util.List;

/**
 * Created by Unknown on 3/17/2018.
 */

public class SeminarEventKategoriAdapter extends RecyclerView.Adapter<SeminarEventKategoriAdapter.ViewHolder> {

    List<String> categories;

    public SeminarEventKategoriAdapter(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seminar_event_kategori_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nama.setText(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama;
        private ImageView gambar;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.namaKategoriSeminarEventTV);
            gambar = (ImageView) itemView.findViewById(R.id.gambarKategoriSeminarEventIV);
        }
    }
}
