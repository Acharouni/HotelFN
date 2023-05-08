package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.hotel.ui.room.room;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class rooM1 extends AppCompatActivity {
    private TextView pre;
    private Button rez;
    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roo_m1);
        fAuth = fAuth.getInstance();
        rez = findViewById(R.id.buttonR1);
        pre = findViewById(R.id.textView14);

        DatabaseReference referance= FirebaseDatabase.getInstance().getReference().child("prix").child("room1");

        referance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //case if the user exists
                if (snapshot.exists()){
                    pre.setText(snapshot.getValue().toString());
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});


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