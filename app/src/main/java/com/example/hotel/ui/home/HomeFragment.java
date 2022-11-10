package com.example.hotel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.hotel.R;
import com.example.hotel.ui.about.about;
import com.example.hotel.ui.contactus.contactus;
import com.example.hotel.ui.dinner.dinner;
import com.example.hotel.ui.gallery.GalleryFragment;
import com.example.hotel.ui.local.local;
import com.example.hotel.ui.room.room;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HomeFragment extends Fragment {
    private View imroom, imgallery, imdinner, imcontact, imloacal, imabout;


    private HomeViewModel mViewModel;

    public static com.example.hotel.ui.home.HomeFragment newInstance() {
        return new com.example.hotel.ui.home.HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         View v= inflater.inflate(R.layout.fragment_home, container, false);
         imroom =v.findViewById(R.id.imgRoom);
         imgallery =v.findViewById(R.id.imggallery);
         imdinner =v.findViewById(R.id.imgdiner);
         imcontact =v.findViewById(R.id.imgcontact);
         imloacal =v.findViewById(R.id.imglocal);
         imabout =v.findViewById(R.id.imgabout);

         imroom.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                Fragment fragment = new room();
                 FragmentManager manager = getParentFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(R.id.nav_host_fragment_content_main, fragment);
                 transaction.addToBackStack(null).commit();



             }
         });

        imgallery.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Fragment fragment = new GalleryFragment();
                 FragmentManager manager = getParentFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(R.id.nav_host_fragment_content_main, fragment);
                 transaction.commit();
             }
         });

         imdinner.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Fragment fragment = new dinner();
                 FragmentManager manager = getParentFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(R.id.nav_host_fragment_content_main, fragment);
                 transaction.commit();

             }
         });

         imcontact.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Fragment fragment = new contactus();
                 FragmentManager manager = getParentFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(R.id.nav_host_fragment_content_main, fragment);
                 transaction.commit();
             }
         });

         imloacal.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Fragment fragment = new local();
                 FragmentManager manager = getParentFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(R.id.nav_host_fragment_content_main, fragment);
                 transaction.commit();

             }
         });

         imabout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Fragment fragment = new about();
                 FragmentManager manager = getParentFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(R.id.nav_host_fragment_content_main, fragment);
                 transaction.commit();
             }
         });








        return v ;

    }


}