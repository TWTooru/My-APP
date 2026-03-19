package com.example.va40.dose_fragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.va40.VApassport;

import java.util.List;

public class SlideAdapter extends FragmentStateAdapter {
    private List<Fragment> dose;
    public  SlideAdapter(VApassport fragmentManager, List<Fragment> dose){
        super(fragmentManager);
        this.dose = dose;
    }

    @Override
    public Fragment createFragment(int position) {
        return dose.get(position);
    }

    @Override
    public int getItemCount() {
        return dose.size();
    }
}
