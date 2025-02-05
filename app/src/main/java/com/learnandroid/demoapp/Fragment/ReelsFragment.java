package com.learnandroid.demoapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learnandroid.demoapp.R;
import com.learnandroid.demoapp.databinding.FragmentReelsBinding;

public class ReelsFragment extends Fragment {
    FragmentReelsBinding binding;


    public ReelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_reels, container, false);
        binding = FragmentReelsBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }
}