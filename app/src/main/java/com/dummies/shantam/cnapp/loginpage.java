package com.dummies.shantam.cnapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginpage extends AppCompatActivity {

    Button login;
    EditText user_name, user_password;
    TextView regi;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        getdata1();
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            finish();
            Intent intent = new Intent(loginpage.this,home.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();

            }
        });


        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration = new Intent(loginpage.this, registrationpage.class);
                startActivity(registration);
            }
        });
    }

    private void getdata1() {
        login = (Button) findViewById(R.id.login);
        user_name = (EditText) findViewById(R.id.usernamelog);
        user_password = (EditText) findViewById(R.id.passwordlog);
        regi = (TextView) findViewById(R.id.reg);
    }

    private void validation() {
        String username = user_name.getText().toString();
        String password = user_password.getText().toString();
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "please enter the username and password", Toast.LENGTH_SHORT).show();
        } else {

            final ProgressDialog mDialog = new ProgressDialog(loginpage.this);
            mDialog.setMessage("please wait....");
            mDialog.show();
            firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        mDialog.dismiss();
                        emaiverification();
                    }
                    else
                    {
                        mDialog.dismiss();
                        Toast.makeText(loginpage.this,"please login again",Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
    public void emaiverification()
    {
        FirebaseUser firebaseUser= firebaseAuth.getInstance().getCurrentUser();
        boolean email;
        email=firebaseUser.isEmailVerified();

        if(email)
        {
            finish();
            Toast.makeText(loginpage.this,"login successful",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(loginpage.this,home.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(loginpage.this,"please verify your email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
