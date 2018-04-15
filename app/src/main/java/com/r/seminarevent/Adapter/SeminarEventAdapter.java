package com.r.seminarevent.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.r.seminarevent.UI.DetailSeminarEvent;
import com.r.seminarevent.R;
import com.r.seminarevent.Model.SeminarEventData;

import java.util.List;

/**
 * Created by Unknown on 3/16/2018.
 */

public class SeminarEventAdapter extends RecyclerView.Adapter<SeminarEventAdapter.ViewHolder> {

    List<SeminarEventData> seminarEventDatas;
    Context context;
    Integer[] images = {R.drawable.ic_seminar, R.drawable.ic_seminar2, R.drawable.ic_seminar3, R.drawable.ic_seminar4};

    public SeminarEventAdapter(Context context, List<SeminarEventData> seminarEventDatas) {
        this.context = context;
        this.seminarEventDatas = seminarEventDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seminar_event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SeminarEventData seminarEventData = seminarEventDatas.get(position);

        if(position < images.length)
            roundImage(holder.gambar, images[position]);
        else
            roundImage(holder.gambar, images[position-images.length]);
        holder.nama.setText(seminarEventData.getNama());
        holder.tanggal.setText(seminarEventData.getTanggal());
        holder.waktu.setText(seminarEventData.getWaktu());
        holder.seminarEventLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailSeminarEvent.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seminarEventDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, tanggal, waktu;
        private ImageView gambar;
        private LinearLayout seminarEventLL;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.namaSeminarEventTV);
            tanggal = (TextView) itemView.findViewById(R.id.tanggalSeminarEventTV);
            waktu = (TextView) itemView.findViewById(R.id.waktuSeminarEventTV);
            gambar = (ImageView) itemView.findViewById(R.id.gambarSeminarEventIV);
            seminarEventLL = (LinearLayout) itemView.findViewById(R.id.seminarEventItemLL);
        }
    }

    private void roundImage(ImageView imageView, int image){
        Bitmap mbitmap = ((BitmapDrawable) context.getResources().getDrawable(image)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 15, 15, mpaint);// Round Image Corner 100 100 100 100
        imageView.setImageBitmap(imageRounded);
    }
}
