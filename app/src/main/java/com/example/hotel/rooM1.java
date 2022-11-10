package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.hotel.ui.room.room;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class rooM1 extends AppCompatActivity {
    private Button rez;
    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roo_m1);
        fAuth = fAuth.getInstance();
        rez = findViewById(R.id.buttonR1);
        rez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fAuth.getCurrentUser() !=null){
                    startActivity(new Intent(rooM1.this, reservation.class));

                }else{
                    Toast.makeText(rooM1.this, "Connected first !!!. ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(rooM1.this, login1.class));
                }

            }
        });

        String nameR= "Room 1";
        nameRooM name= new nameRooM(nameR);







        View rt = findViewById(R.id.reture);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}