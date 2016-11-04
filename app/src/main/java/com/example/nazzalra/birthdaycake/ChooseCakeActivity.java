package com.example.nazzalra.birthdaycake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ChooseCakeActivity extends AppCompatActivity {
    SessionManager session;
    ListView listCake;
    String[]CakeName={
            "Birthday Cake Balonku",
            "Birthday Cake Coklat Nikmat",
            "Birthday Cake Dua Hati",
            "Birthday Cake Satu Hati"

    };

    int[]CakePic = {
            R.drawable.birthdaycake1,
            R.drawable.birthdaycake2,
            R.drawable.birthdaycake3,
            R.drawable.birthdaycake4,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cake);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();


        CakeAdapter adapter = new CakeAdapter(this, CakeName, CakePic);
        listCake = (ListView)findViewById(R.id.lvCake);
        View header = (View)getLayoutInflater().inflate(R.layout.list_cake_header, null);
        listCake.addHeaderView(header);
        listCake.setAdapter(adapter);

        listCake.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String PilihKue = CakeName[position-1];
                Toast.makeText(getApplicationContext(), PilihKue, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChooseCakeActivity.this, SendCakeActivity.class );
                intent.putExtra("cakeName", PilihKue);
                startActivity(intent);

            }
        });
    }
}
