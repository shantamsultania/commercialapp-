package com.dummies.shantam.cnapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button flash= findViewById(R.id.buttom1);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"welcome to our app ",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,frontpage.class);
                startActivity(intent);
            }
        });


    }
}
