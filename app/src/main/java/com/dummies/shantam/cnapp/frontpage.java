package com.dummies.shantam.cnapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frontpage extends AppCompatActivity {


    Button signin,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);


        signin=(Button)findViewById(R.id.fsignin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signin=new Intent(frontpage.this,loginpage.class);
                startActivity(signin);
            }
        });

        signup=(Button)findViewById(R.id.fsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup=new Intent(frontpage.this,registrationpage.class);
                startActivity(signup);
            }
        });
    }
}
