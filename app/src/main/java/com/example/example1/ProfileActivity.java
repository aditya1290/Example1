package com.example.example1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {


    TextView e1,e2;
    Button btn;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        e1 = (TextView)findViewById(R.id.profile_output_email);
        e2 = (TextView)findViewById(R.id.profile_output_password);
        btn = (Button)findViewById(R.id.profile_show);
        root = FirebaseDatabase.getInstance().getReference().child(user.getUid());
    }


    // Show Profile ------------------>
    public void showProfile(View v)
    {
        if(btn.getText().toString()=="SHOW")
        {
            root.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    e1.setText(dataSnapshot.child("email").getValue().toString());
                    e2.setText(dataSnapshot.child("password").getValue().toString());
                    btn.setText("HIDE");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else
        {
            e1.setText("");
            e2.setText("");
            btn.setText("SHOW");
        }

    }



    //      Logout --------------------->
    public void ProfileLogout(View v)
    {
        auth.signOut();
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
