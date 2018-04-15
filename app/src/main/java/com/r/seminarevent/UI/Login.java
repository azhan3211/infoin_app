package com.r.seminarevent.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.r.seminarevent.R;

/**
 * Created by Unknown on 3/26/2018.
 */

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button login;
    TextView daftar;
    EditText usernameEmail, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initialVariable();
        login.setOnClickListener(this);
        daftar.setOnClickListener(this);
    }

    private void initialVariable() {
        login = (Button) findViewById(R.id.loginBtn);
        daftar = (TextView) findViewById(R.id.daftarBtn);
        usernameEmail = (EditText) findViewById(R.id.usernameEmailET);
        password = (EditText) findViewById(R.id.passwordET);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.loginBtn:
                intent = new Intent(Login.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.daftarBtn:
                intent = new Intent(Login.this, Daftar.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
