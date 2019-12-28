package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class firstActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this,getmylist());
        mRecyclerView.setAdapter(myAdapter);

    }

    private ArrayList<Model> getmylist()
    {
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("Loction");
        m.setDesc("Locate Yourself");
        m.setImage(R.drawable.location);
        models.add(m);

        m = new Model();
        m.setTitle("Scan");
        m.setDesc("Click on this to scan");
        m.setImage(R.drawable.scan);
        models.add(m);


        m = new Model();
        m.setTitle("Search");
        m.setDesc("Tap to search");
        m.setImage(R.drawable.search);
        models.add(m);


        m = new Model();
        m.setTitle("Settings");
        m.setDesc("Change them as your way");
        m.setImage(R.drawable.settings);
        models.add(m);


        m = new Model();
        m.setTitle("Profile");
        m.setDesc("Go to your profile");
        m.setImage(R.drawable.profile);
        models.add(m);


        m = new Model();
        m.setTitle("Scan QR/Barcode with Zxing Library");
        m.setDesc("Click to scan");
        m.setImage(R.drawable.scan);
        models.add(m);

        return models;
    }



}
