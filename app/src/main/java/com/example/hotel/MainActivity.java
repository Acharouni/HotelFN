package com.example.hotel;


import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hotel.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private String nameu;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fAuth = FirebaseAuth.getInstance();
     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);;

       /* binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.room, R.id.nav_gallery, R.id.dinning, R.id.loaction, R.id.contact, R.id.about, R.id.logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem id = menu.findItem(R.id.idLogin);
        MenuItem id1 = menu.findItem(R.id.logout);
        MenuItem id2 = menu.findItem(R.id.action_settings);
        MenuItem id3 = menu.findItem(R.id.nameUser);


        if (fAuth.getCurrentUser() !=null) {
            id.setVisible(false);
            id1.setVisible(true);
            id2.setVisible(true);
            id3.setVisible(true);

            String currentUserId =fAuth.getInstance().getCurrentUser().getUid();
            DatabaseReference referance= FirebaseDatabase.getInstance().getReference().child("users")
                    .child(currentUserId);

            referance.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    //case if the user exists
                    if (snapshot.exists()){
                        id3.setTitle("Hi "+snapshot.child("name").getValue().toString());


                    }

                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {}});



        }


        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int id1 = item.getItemId();
        int id3 = item.getItemId();
        if (id == R.id.idLogin) {

            Intent intent= new Intent(MainActivity.this, login1.class);
            startActivity(intent);
            return true;
        }
        if (fAuth.getCurrentUser() !=null) {
            if (id1 == R.id.logout) {
                fAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Login out successful.", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

        if (id3 == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, setting.class));
            Toast.makeText(getApplicationContext(), "setting !!!.", Toast.LENGTH_SHORT).show();
            return true;
        }



        return false;
    }
}