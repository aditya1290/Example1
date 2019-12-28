package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RegisterActivity(View v)
    {
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
        finish();

    }

    public void LoginActivity(View v)
    {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
