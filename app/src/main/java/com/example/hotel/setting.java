package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class setting extends AppCompatActivity {
    private String name, subname, mail, phone, password, cnp;
    private EditText nameA, surnameA, mailA, phoneA, passwordA, cnpws;
    private Button btn_send;
    private View home;

    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNude;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mailA = findViewById(R.id.idEmailmed);
        phoneA = findViewById(R.id.idPhonemed);
        passwordA = findViewById(R.id.idPasswordmed);
        cnpws = findViewById(R.id.idConPassmed);
        fAuth = FirebaseAuth.getInstance();
        btn_send = findViewById(R.id.idEnrgBtonmed);
        progressBar = findViewById(R.id.idprogressBar2);
        home= findViewById(R.id.idhome2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(setting.this, MainActivity.class);
                startActivity(i);

            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNude = FirebaseDatabase.getInstance();
                reference = rootNude.getReference("users");
                String currentUserId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
                mail = mailA.getText().toString().trim();
                phone = phoneA.getText().toString().trim();
                password = passwordA.getText().toString().trim();
                cnp = cnpws.getText().toString().trim();

                meDfData medfdata= new meDfData(mail,phone,password);

                reference.child(currentUserId).child("email").setValue(medfdata.getMail());
                reference.child(currentUserId).child("phone").setValue(medfdata.getPhone());
                reference.child(currentUserId).child("password").setValue(medfdata.getPassword());
                Toast.makeText(setting.this, "med Created. ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(setting.this, MainActivity.class));

            }
        });


    }
}