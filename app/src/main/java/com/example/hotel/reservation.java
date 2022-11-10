package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.hotel.ui.room.room;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class reservation extends AppCompatActivity {
    private EditText mFName, mLName, mRoom, mAdult, mChild, mdate_E, mdate_D;
    private String Fname, Fsubname, Froom, Fadult, Fchild, Date_E, Date_D, nameU;
    FirebaseAuth fAuth;
    private Button mUpload;
    FirebaseDatabase rootNude;
    DatabaseReference reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        mFName = findViewById(R.id.Fname);
        mLName = findViewById(R.id.Lname);
        mRoom = findViewById(R.id.room);
        mAdult = findViewById(R.id.adult);
        mChild = findViewById(R.id.child);
        mdate_E = findViewById(R.id.arrival);
        mdate_D = findViewById(R.id.dep);
        mUpload = findViewById(R.id.rezvv);

        String nameRoom = nameRooM.getNameRoom();
        String currentUserId =fAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference referance= FirebaseDatabase.getInstance().getReference().child("users")
                .child(currentUserId);

        referance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //case if the user exists
                if (snapshot.exists()){
                    mFName.setText(snapshot.child("name").getValue().toString());
                    mLName.setText(snapshot.child("surname").getValue().toString());
                    mRoom.setText(nameRoom);



                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});

        mUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fname = mFName.getText().toString().trim();
                Fsubname = mLName.getText().toString().trim();
                Fsubname = mLName.getText().toString().trim();
                Froom = mRoom.getText().toString().trim();
                Fadult = mAdult.getText().toString().trim();
                Fchild = mChild.getText().toString().trim();
                Date_E = mdate_E.getText().toString().trim();
                Date_D = mdate_D.getText().toString().trim();
                EnregResV enregResV= new EnregResV(Fname, Fsubname, nameRoom, Fadult, Fchild, Date_E, Date_D);
                FirebaseDatabase.getInstance().getReference("reservation").child(getnbr()).child(currentUserId).setValue(enregResV);

                if (TextUtils.isEmpty(Fadult)){
                    mAdult.setError("Veuillez entrer votre nbr adult");
                    return;
                }

                if (TextUtils.isEmpty(Fchild)){
                    mChild.setError("Veuillez entrer votre nbr child");
                    return;
                }

                if (TextUtils.isEmpty(Date_E)){
                    mdate_E.setError("Veuillez entrer votre mail");
                    return;
                }

                if (TextUtils.isEmpty(Date_D)){
                    mdate_D.setError("Veuillez entrer votre telephone");
                    return;
                }
                Toast.makeText(reservation.this, "get reserved !!!. ", Toast.LENGTH_SHORT).show();
                onBackPressed();



            }


        });
        View rt = findViewById(R.id.reture2);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    int nbr=0;
    public String getnbr(){
    this.nbr+=1;
    String s=String.valueOf(nbr);
    return s;
    }
}