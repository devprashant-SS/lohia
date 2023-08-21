package com.example.lohia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2; // Import ViewPager2

import com.example.lohia.Adapter.Image_adapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    Button Health;
    ViewPager2 mviewpager; // Change to ViewPager2

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Health = view.findViewById(R.id.health);
        Health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getContext(), UserDataActivity.class));
                startActivity(new Intent(getContext(), TreeShowActivity.class));
            }
        });

        List<Integer> imagesList = new ArrayList<>();
        imagesList.add(R.drawable.ic_launcher_background);
        imagesList.add(R.drawable.ic_launcher_background);
        imagesList.add(R.drawable.ic_launcher_background);

        mviewpager = view.findViewById(R.id.slider_viewpage);
        mviewpager.setAdapter(new Image_adapter(imagesList)); // Pass only the images list

        return view;
    }
}
