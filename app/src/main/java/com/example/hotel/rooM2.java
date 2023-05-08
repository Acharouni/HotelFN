package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel.ui.room.room;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class rooM2 extends AppCompatActivity {
    private Button rez2;
    private TextView pre;
    private FirebaseAuth fAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roo_m2);
        fAuth = fAuth.getInstance();
        rez2 = findViewById(R.id.buttonrez2);
        pre = findViewById(R.id.textView16);
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
        DatabaseReference referance= FirebaseDatabase.getInstance().getReference().child("prix").child("room2");

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