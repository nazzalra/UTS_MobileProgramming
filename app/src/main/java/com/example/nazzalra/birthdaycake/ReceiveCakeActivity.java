package com.example.nazzalra.birthdaycake;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceiveCakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_cake);

        final SessionManager sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();

        TextView tv_Friend = (TextView) findViewById(R.id.tvFriend);
        TextView tv_Message= (TextView) findViewById(R.id.tvMessage);
        TextView tv_You = (TextView) findViewById(R.id.tvYou);
        ImageView gambarKue = (ImageView) findViewById(R.id.cakePic);
        Button btnHome = (Button) findViewById(R.id.btnHome);




        Bundle hasilPesan = getIntent().getExtras();
        String Message = hasilPesan.getString("Message");
        String Friend = hasilPesan.getString("Friend");
        String You = hasilPesan.getString("You");




        tv_Friend.setText(Friend);
        tv_Message.setText(Message);
        tv_You.setText(You);



        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(ReceiveCakeActivity.this, ChooseCakeActivity.class);
                startActivity(k);
            }
        });


    }
}
