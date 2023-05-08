package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class myreservation extends AppCompatActivity {
    private Button btn_send;
    private View home;
    FirebaseAuth fAuth;
    private TextView resv;
    FirebaseDatabase rootNude;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myreservation);
        home = findViewById(R.id.idhome);
        btn_send = findViewById(R.id.buttonAnnuler);
        resv = findViewById(R.id.afich);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(myreservation.this, MainActivity.class);
                startActivity(i);
            }
        });

        String currentUserId =fAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference referance= FirebaseDatabase.getInstance().getReference().child("reservation")
                .child(currentUserId);
        referance.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //case if the user exists
                if (snapshot.exists()){
                    String name= (snapshot.child("name").getValue().toString());
                    String surname = (snapshot.child("subname").getValue().toString());
                    String adult = (snapshot.child("adult").getValue().toString());
                    String children = (snapshot.child("child").getValue().toString());
                    String room = (snapshot.child("room").getValue().toString());
                    String datee = (snapshot.child("date_E").getValue().toString());
                    String dated = (snapshot.child("date_D").getValue().toString());
                    resv.setText("     name : "+ name +"\n"+
                            "     surname : "+surname+"\n"+
                            "     adult : "+adult+"\n"+
                            "     children : "+children+"\n"+
                            "     room : "+room+"\n"+
                            "     date entry : "+datee+"\n"+
                            "     date leve : "+dated);
                }


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});





        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference referance2= FirebaseDatabase.getInstance().getReference().child("reservation")
                        .child(currentUserId);
                referance2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //case if the user exists
                        if (snapshot.exists()){
                             snapshot.getRef().removeValue();
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {}});

                    onBackPressed();


            }
        });


    }
}