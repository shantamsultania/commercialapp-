package com.dummies.shantam.cnapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrationpage extends AppCompatActivity {
    Button back, submit;
    EditText pass, cpass, email,regusername,regphonenumber;

    FirebaseAuth firebaseAuth;

    String  cpas, ccpass, cemail,cusername,cphonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationpage);

        getdata2();


        firebaseAuth = FirebaseAuth.getInstance();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registrationpage.this, loginpage.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(registrationpage.this);
                mDialog.setMessage("please wait....");
                if (valid()) {
                    mDialog.dismiss();

                    String usernamereg, userpasswordreg;
                    usernamereg = email.getText().toString().trim();
                    userpasswordreg = pass.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(usernamereg, userpasswordreg).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                sendemail();

                            } else
                                Toast.makeText(registrationpage.this, "please try again", Toast.LENGTH_SHORT).show();
                        }

                    });
                }
            }
        });
    }


    private void getdata2() {
        back = (Button) findViewById(R.id.back);
        submit = (Button) findViewById(R.id.submit);
        pass = (EditText) findViewById(R.id.regpass);
        cpass = (EditText) findViewById(R.id.regconpass);
        email = (EditText) findViewById(R.id.regemail);
        regphonenumber=(EditText)findViewById(R.id.editTextphonenumber);
        regusername=(EditText)findViewById(R.id.editTextusername);

    }

    private boolean valid() {
        boolean result = false;

        cpas = pass.getText().toString();
        ccpass = cpass.getText().toString();
        cemail = email.getText().toString();
        cusername=regusername.getText().toString();
        cphonenumber=regphonenumber.getText().toString();

        if (cpas.isEmpty() || ccpass.isEmpty() || cemail.isEmpty() ||cusername.isEmpty()||cphonenumber.isEmpty()) {
            Toast.makeText(this, "please enter all the details", Toast.LENGTH_SHORT).show();
        } else {
            if (cpas.equals(ccpass)) {
                result = true;
            } else {
                Toast.makeText(this, "please check the password ", Toast.LENGTH_SHORT).show();
            }

        }

        return result;
    }

    public void sendemail()
    {
        final FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        senduserdata();
                        Toast.makeText(registrationpage.this,"email verification send",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();

                        Intent intent=new Intent(registrationpage.this,loginpage.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(registrationpage.this,"email verification failed",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void senduserdata()
    {

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myref=firebaseDatabase.getReference(firebaseAuth.getUid());
        userdata userdata;
        userdata = new userdata(cusername,cphonenumber,cemail);
        myref.setValue(userdata);

    }
}
