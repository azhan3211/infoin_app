package com.r.seminarevent.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.r.seminarevent.Connection.RetrofitConnection;
import com.r.seminarevent.Data.InfoinInterface;
import com.r.seminarevent.Data.UserRegistration;
import com.r.seminarevent.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Unknown on 3/21/2018.
 */

public class Daftar extends AppCompatActivity {
    private Button daftar;
    private EditText fullname, password, email, phone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_layout);
        setTitle("Daftar");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.hide();
        initialVariable();
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRegistration userRegistration = new UserRegistration(
                        fullname.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        phone.getText().toString()
                );
                registration(userRegistration);
                Intent intent = new Intent(Daftar.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void registration(UserRegistration userRegistration){
        RetrofitConnection retrofitConnection = new RetrofitConnection();
        Retrofit retrofit = retrofitConnection.service();
        InfoinInterface infoinInterface = retrofit.create(InfoinInterface.class);
        Call<UserRegistration> call = infoinInterface.registration(userRegistration);
        call.enqueue(new Callback<UserRegistration>() {
            @Override
            public void onResponse(Call<UserRegistration> call, Response<UserRegistration> response) {
                UserRegistration result = response.body();
                Log.d("kenapatidakmuncul", result.getUser_id());
            }

            @Override
            public void onFailure(Call<UserRegistration> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void initialVariable() {
        daftar = (Button) findViewById(R.id.daftarBtn);
        fullname = (EditText) findViewById(R.id.fullnameET);
        password = (EditText) findViewById(R.id.passwordET);
        email = (EditText) findViewById(R.id.emailET);
        phone = (EditText) findViewById(R.id.phoneET);
    }
}