package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class signup1 extends AppCompatActivity {
    private TextView User;
    private Button btn_send;
    private EditText nameA, surnameA, mailA, phoneA, passwordA, cnpws;
    private String name, subname, mail, phone, password, cnp;
    private View home;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNude;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        nameA = findViewById(R.id.idUserName);
        surnameA = findViewById(R.id.idUserPName);
        mailA = findViewById(R.id.idEmail);
        phoneA = findViewById(R.id.idPhone);
        passwordA = findViewById(R.id.idPassword);
        cnpws = findViewById(R.id.idConPass);
        fAuth = FirebaseAuth.getInstance();
        btn_send = findViewById(R.id.idEnrgBton);

        progressBar = findViewById(R.id.idprogressBar2);
        home= findViewById(R.id.idhome2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(signup1.this, MainActivity.class);
                startActivity(i);

            }
        });

        User= findViewById(R.id.idSignin);
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(signup1.this, login1.class);
                startActivity(i);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNude = FirebaseDatabase.getInstance();
                reference = rootNude.getReference("users");
                name = nameA.getText().toString().trim();
                subname = surnameA.getText().toString().trim();
                mail = mailA.getText().toString().trim();
                phone = phoneA.getText().toString().trim();
                password = passwordA.getText().toString().trim();
                cnp = cnpws.getText().toString().trim();

                UsersClass usersClass = new UsersClass(name, subname, mail, phone, password);



                if (TextUtils.isEmpty(name)){
                    nameA.setError("Veuillez entrer votre nom");
                    return;
                }

                if (TextUtils.isEmpty(subname)){
                    surnameA.setError("Veuillez entrer votre prenom");
                    return;
                }

                if (TextUtils.isEmpty(mail)){
                    mailA.setError("Veuillez entrer votre mail");
                    return;
                }

                if (TextUtils.isEmpty(phone)){
                    phoneA.setError("Veuillez entrer votre telephone");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    passwordA.setError("Veuillez entrer votre mot de passe");
                    return;
                }

                if (TextUtils.isEmpty(cnp)){
                    cnpws.setError("Veuillez conferme votre mot de passe");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                //ATH FIRE BASE
                fAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            String currentUserId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
                            reference.child(currentUserId).setValue(usersClass);
                            Toast.makeText(signup1.this, "User Created. ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(signup1.this, login1.class));


                        }else {Toast.makeText(signup1.this, "User Failed " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }



                    }
                });
            }
        });





    }
}