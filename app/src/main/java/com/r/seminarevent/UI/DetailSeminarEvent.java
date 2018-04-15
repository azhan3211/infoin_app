package com.r.seminarevent.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.r.seminarevent.R;

/**
 * Created by Unknown on 3/16/2018.
 */

public class DetailSeminarEvent extends AppCompatActivity {
    ActionBar actionBar;
//    Button qrCodebtn, qrCodeScanner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Detail Event");
        setContentView(R.layout.detail_seminar_event_layout);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//        qrCodebtn = (Button) findViewById(R.id.qrCodeBtn);
//        qrCodeScanner = (Button) findViewById(R.id.qrCodeScannerBtn);
//
//        qrCodebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DetailSeminarEvent.this, QrCode.class);
//                startActivity(intent);
//            }
//        });
//
//        qrCodeScanner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //proses inisialisasi scanner qrcode
//                IntentIntegrator intentIntegrator = new IntentIntegrator(DetailSeminarEvent.this);
//                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
//                intentIntegrator.setBeepEnabled(false);
//                intentIntegrator.setBarcodeImageEnabled(false);
//                intentIntegrator.setCameraId(0);
//                intentIntegrator.setPrompt("Scan");
//                intentIntegrator.initiateScan();
//            }
//        });
    }

    //proses membaca qrcode
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if(result != null){
//            if(result.getContents() == null){
//                Toast.makeText(DetailSeminarEvent.this, "You cancelled the scanner", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(DetailSeminarEvent.this, result.getContents(), Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
