package com.example.nazzalra.birthdaycake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SendCakeActivity extends AppCompatActivity {
SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_cake);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        TextView tv_Cake = (TextView) findViewById(R.id.tvCake);

        final EditText et_Message = (EditText) findViewById(R.id.etMessage);
        final EditText et_Friend = (EditText) findViewById(R.id.etFriend);
        final EditText et_You = (EditText) findViewById(R.id.etYou);
        Button btn_Send = (Button) findViewById(R.id.btnSend);

        Bundle bundle = getIntent().getExtras();
        String cakeName = bundle.getString("cakeName");
        tv_Cake.setText(cakeName);


        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendCake = new Intent(SendCakeActivity.this, ReceiveCakeActivity.class);
                sendCake.putExtra("Message", et_Message.getText().toString());
                sendCake.putExtra("Friend", et_Friend.getText().toString());
                sendCake.putExtra("You", et_You.getText().toString());

                startActivity(sendCake);
            }
        });

    }
}
