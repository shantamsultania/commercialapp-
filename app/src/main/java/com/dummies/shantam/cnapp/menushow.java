package com.dummies.shantam.cnapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class menushow extends AppCompatActivity {

    TextView mtitle,mdetails,maddress;
    ImageView mimage;
    Button placeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menushow);
        ActionBar actionBar=getSupportActionBar();

        actionBar.setTitle("Details");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mtitle=findViewById(R.id.Titletv);
        mdetails=findViewById(R.id.descrptiontv);
        mimage=findViewById(R.id.ImageViewtv);
        maddress=findViewById(R.id.t_address_details);



        String image=getIntent().getStringExtra("image");
        String title=getIntent().getStringExtra("title");
        String details=getIntent().getStringExtra("description");
        String address=getIntent().getStringExtra("address");


        //Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        mtitle.setText(title);
        mdetails.setText(details);
        maddress.setText(address);
        Picasso.get().load(image).into(mimage);

        placeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menushow.this,placed.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
