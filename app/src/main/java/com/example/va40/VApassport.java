package com.example.va40;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.MarginPageTransformer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.va40.databinding.ActivityVapassportBinding;
import com.example.va40.dose_fragment.SlideAdapter;
import com.example.va40.dose_fragment.doseRecyAdapter;
import com.example.va40.dose_fragment.first_dose;
import com.example.va40.dose_fragment.second_dose;
import com.example.va40.dose_fragment.third_dose;

import java.util.ArrayList;
import java.util.List;

public class VApassport extends AppCompatActivity {
    private ActivityVapassportBinding binding;
    private SlideAdapter slideAdapter;
    private doseRecyAdapter doseRecyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVapassportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.vsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VApassport.this,MainFace.class);
                startActivity(i);
            }
        });
        viewpager();

        doseRecyAdapter = new doseRecyAdapter(VApassport.this);
        binding.recyclerView.setAdapter(doseRecyAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(VApassport.this));

    }
    private void viewpager(){
        List<Fragment> dose = new ArrayList<>();
        dose.add(new first_dose());
        dose.add(new second_dose());
        dose.add(new third_dose());
        slideAdapter = new SlideAdapter(this,dose);
        binding.viewpager.setAdapter(slideAdapter);

        binding.viewpager.setClipChildren(false);
        binding.viewpager.setClipToPadding(false);
        binding.viewpager.setOffscreenPageLimit(3);
        binding.viewpager.setPageTransformer(new MarginPageTransformer(70));
    }


}