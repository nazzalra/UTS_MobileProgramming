package com.example.nazzalra.birthdaycake;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;
    TextView tvForgot;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new SessionManager(getApplicationContext());
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvForgot = (TextView) findViewById(R.id.tvForgot);
        tvForgot.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DataLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("dataUsername", "admin");
        editor.putString("dataPassword", "admin");
        editor.commit();

    }

    public void onClick(View clicked) {

        switch (clicked.getId()) {
            case R.id.btnLogin:
                Login();

                break;
            case R.id.tvForgot:
                Toast.makeText(this, "Username : admin , Password : admin", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void Login(){
        if(etUsername.getText().toString().equals("")||etPassword.getText().toString().equals("")){
            Toast.makeText(LoginActivity.this,"Username dan Password tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }
        else {
            String Username = etUsername.getText().toString();
            String Password = etPassword.getText().toString();

            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DataLogin", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("dataUsername", null);
            String password = sharedPreferences.getString("dataPassword", null);

            if(Username.equals(username) && Password.equals(password)){

                session.createLoginSession();

                Intent intent = new Intent(LoginActivity.this, ChooseCakeActivity.class);
                LoginActivity.this.startActivity(intent);
            }else{

                Toast.makeText(getApplicationContext(), "Login Gagal..\n"
                        + "Username/Password anda salah", Toast.LENGTH_LONG).show();
            }



        }
    }
}