package com.webtech;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {

    TextView tvwelcome;
    SharedPreferences sh;
    Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        tvwelcome = findViewById(R.id.tvwelcome);
        btnlogout = findViewById(R.id.btnlogout);
        sh = getSharedPreferences("data",MODE_PRIVATE);

        tvwelcome.setText(sh.getString("username",""));

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = sh.edit();
                edit.putString("username","");
                edit.commit();
                Intent i = new Intent(Page2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
