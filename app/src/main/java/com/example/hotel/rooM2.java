package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hotel.ui.room.room;
import com.google.firebase.auth.FirebaseAuth;

public class rooM2 extends AppCompatActivity {
    private Button rez2;
    private FirebaseAuth fAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roo_m2);
        fAuth = fAuth.getInstance();
        rez2 = findViewById(R.id.buttonrez2);
        rez2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fAuth.getCurrentUser() !=null){
                    startActivity(new Intent(rooM2.this, reservation.class));

                }else{
                    Toast.makeText(rooM2.this, "Connected first !!!. ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(rooM2.this, login1.class));
                }

            }
        });


        String nameR= "Room 2";
        nameRooM name= new nameRooM(nameR);






        View rt = findViewById(R.id.imageView8);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}