package com.webtech;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtusername,edtpassword;
    Button btnlogin;
    TextView tvmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logincheck();

        edtusername = findViewById(R.id.edtusername);
        edtpassword = findViewById(R.id.edtpassword);
        btnlogin = findViewById(R.id.btnsubmit);
        tvmsg = findViewById(R.id.tvmsg);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtusername.getText().toString().equals("abc") &&
                edtpassword.getText().toString().equals("123")){

                    SharedPreferences sh = getSharedPreferences("data",MODE_PRIVATE);
                    SharedPreferences.Editor edit = sh.edit();
                    edit.putString("username",edtusername.getText().toString());
                    edit.putString("password",edtpassword.getText().toString());
                    edit.commit();


                    Intent i = new Intent(MainActivity.this,Page2.class);
                    startActivity(i);
                    finish();
                }else{
                    tvmsg.setText("Username/Password Invalid");
                }
            }
        });

    }

    void logincheck(){
        SharedPreferences sh = getSharedPreferences("data",MODE_PRIVATE);

        if(!sh.getString("username","").equals("")){
            Intent i = new Intent(MainActivity.this,Page2.class);
            startActivity(i);
            finish();
        }
    }
}
