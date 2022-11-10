package com.example.hotel.ui.contactus;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotel.MainActivity;
import com.example.hotel.R;
import com.example.hotel.contacter;
import com.example.hotel.login1;
import com.example.hotel.signup1;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class contactus extends Fragment {
    private EditText Email, Message, objet;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNude;
    DatabaseReference reference;
    private String mailA, messageA, objetA;
    private Button bTsend;

    private ContactusViewModel mViewModel;

    public static contactus newInstance() {
        return new contactus();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_contactus, container, false);
        Email = v.findViewById(R.id.editTextTextEmailAddress);
        Message = v.findViewById(R.id.editTextTextMultiLine);
        objet = v.findViewById(R.id.objettxt);
        fAuth = FirebaseAuth.getInstance();
        bTsend = v.findViewById(R.id.buttonsend);

       bTsend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               rootNude = FirebaseDatabase.getInstance();
               reference = rootNude.getReference("contact");
               mailA = Email.getText().toString().trim();
               messageA = Message.getText().toString().trim();
               objetA = objet.getText().toString().trim();

               contacter msg= new contacter(mailA, messageA, objetA);

               if (TextUtils.isEmpty(mailA)){
                   Email.setError("Veuillez entrer votre mail");
                   return;
               }
               if (TextUtils.isEmpty(mailA)){
                   Email.setError("Veuillez entrer votre objet");
                   return;
               }

               if (TextUtils.isEmpty(messageA)){
                   Message.setError("Veuillez entrer votre message");
                   return;
               }else{
                   reference.child(objetA).setValue(msg);
                   Toast.makeText(getContext(), "send successful. ", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(getContext(), MainActivity.class));
               }




           }
       });









        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContactusViewModel.class);
        // TODO: Use the ViewModel
    }

}