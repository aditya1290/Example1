package com.example.example1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText e1,e2;

    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    DatabaseReference root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1 = (EditText)findViewById(R.id.Register_input_name);
        e2 = (EditText)findViewById(R.id.Register_input_password);

        auth = FirebaseAuth.getInstance();
        root = FirebaseDatabase.getInstance().getReference();
    }

    // CREATING USER --->
    public void createUser(View v)
    {
        if(e1.getText().toString().equals("") || e2.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Blank Not Allowed",Toast.LENGTH_SHORT).show();
        }
        else
        {
            final String email = e1.getText().toString();
            final String password = e2.getText().toString();

            auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Successfully generated account",Toast.LENGTH_SHORT).show();
                                firebaseUser = auth.getCurrentUser();
                                User newUser = new User(e1.getText().toString(), e2.getText().toString());

                                root.child(firebaseUser.getUid()).setValue(newUser)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful())
                                                {
                                                    finish();
                                                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                                    startActivity(i);
                                                }
                                                else
                                                {
                                                    Toast.makeText(getApplicationContext(), "Unsuccessful",Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                            else
                            {
                                String error=((FirebaseAuthException)task.getException()).getErrorCode();
                                switch(error)
                                {
                                    case "ERROR_WEAK_PASSWORD":
                                        Toast.makeText(getApplicationContext(),"Make A Password Of Atleast 6 Digits",Toast.LENGTH_SHORT).show();
                                        break;

                                    case "ERROR_EMAIL_ALREADY_IN_USE":
                                        Toast.makeText(getApplicationContext(),"This EMAIL is already registered",Toast.LENGTH_SHORT).show();
                                        break;

                                    default:
                                        Toast.makeText(getApplicationContext(),"Any Error Occured",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }
    }

    public void myui(View v)
    {
        
    }

}
