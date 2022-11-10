package com.example.hotel.ui.room;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotel.R;
import com.example.hotel.contacter;
import com.example.hotel.rooM1;
import com.example.hotel.rooM2;

public class room extends Fragment {
    private View Room1,Room2;
    private RoomViewModel mViewModel;

    public static room newInstance() {
        return new room();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_room, container, false);
        Room1= v.findViewById(R.id.rooMM1);
        Room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), rooM1.class));
            }
        });

        Room2=v.findViewById(R.id.rooMM2);
        Room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), rooM2.class));
            }
        });






        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RoomViewModel.class);
        // TODO: Use the ViewModel
    }

}