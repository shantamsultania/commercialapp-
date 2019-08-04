package com.dummies.shantam.cnapp;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class home extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebasedatabase;
    DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //RecyclerView
        mRecyclerView =findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        //layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebasedatabase =FirebaseDatabase.getInstance();
        mRef =mFirebasedatabase.getReference("data");
    }
    //searching and going to the details window
    private void firebaseSearch(String Searchtext)
    {
        Query firebaseSearchQuery=mRef.orderByChild("title").startAt(Searchtext).endAt(Searchtext + "\uf8ff");


        FirebaseRecyclerAdapter<Model ,ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(Model.class,R.layout.row,ViewHolder.class,firebaseSearchQuery){

                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                        viewHolder.setDetails(getApplicationContext(),model.getTitle(),model.getImage(),model.getDescription(),model.getAddress());

                    }
                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder=super.onCreateViewHolder(parent,viewType);
                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                String mTitike=getItem(position).getTitle();
                                String mdetail=getItem(position).getDescription();
                                String mimage=getItem(position).getImage();
                                String maddress=getItem(position).getAddress();
                                Intent intent=new Intent(view.getContext(),menushow.class);
                                intent.putExtra("image",mimage);
                                intent.putExtra("title",mTitike);
                                intent.putExtra("description",mdetail);
                                intent.putExtra("address",maddress);
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {
                                String mTitike=getItem(position).getTitle();
                                String mdetail=getItem(position).getDescription();
                                String mimage=getItem(position).getImage();
                                String maddress=getItem(position).getAddress();
                                Intent intent=new Intent(view.getContext(),menushow.class);
                                intent.putExtra("image",mimage);
                                intent.putExtra("title",mTitike);
                                intent.putExtra("description",mdetail);
                                intent.putExtra("address",maddress);
                                startActivity(intent);
                            }
                        });
                        return viewHolder;
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model ,ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(Model.class,R.layout.row,ViewHolder.class,mRef) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                        viewHolder.setDetails(getApplicationContext(),model.getTitle(),model.getImage(),model.getDescription(),model.getAddress());
                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder=super.onCreateViewHolder(parent,viewType);
                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {



                                String mTitike=getItem(position).getTitle();
                                String mdetail=getItem(position).getDescription();
                                String mimage=getItem(position).getImage();
                                String maddress=getItem(position).getAddress();
                                Intent intent=new Intent(view.getContext(),menushow.class);
                                intent.putExtra("image",mimage);
                                intent.putExtra("title",mTitike);
                                intent.putExtra("description",mdetail);
                                intent.putExtra("address",maddress);
                                startActivity(intent);

                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                                String mTitike=getItem(position).getTitle();
                                String mdetail=getItem(position).getDescription();
                                String mimage=getItem(position).getImage();
                                String maddress=getItem(position).getAddress();
                                Intent intent=new Intent(view.getContext(),menushow.class);
                                intent.putExtra("image",mimage);
                                intent.putExtra("title",mTitike);
                                intent.putExtra("description",mdetail);
                                intent.putExtra("address",maddress);
                                startActivity(intent);
                            }
                        });
                        return viewHolder;
                    }
                };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                firebaseSearch(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
