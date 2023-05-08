package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login1 extends AppCompatActivity {
    private TextView nUser;
    private View home;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    private EditText email, password;
    private Button log;
    private String mailA,pws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        email = findViewById(R.id.idEmail1);
        password = findViewById(R.id.idPassword1);
        log = findViewById(R.id.idLogin);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.idprogressBar1);
        nUser = findViewById(R.id.Create);
        home= findViewById(R.id.idhome1);
        nUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login1.this, signup1.class));


            }
        });



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "HELLO !!!", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(login1.this, MainActivity.class);
                startActivity(i);

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailA =email.getText().toString();
                pws =password.getText().toString();

                if (!mailA.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(mailA).matches()){
                    if (!pws.isEmpty()){
                        fAuth.signInWithEmailAndPassword(mailA, pws)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(login1.this, "Login successful. ", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(login1.this, MainActivity.class));
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(login1.this, "Login Failed. ", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else{
                        password.setError("password cannot be empty");
                    }
                } else if(mailA.isEmpty()){
                    email.setError("mail cannot be empty");
                }else{
                    email.setError("please enter valid email");
                }
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
}