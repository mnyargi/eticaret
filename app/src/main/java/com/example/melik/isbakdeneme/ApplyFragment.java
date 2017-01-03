package com.example.melik.isbakdeneme;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by melik on 24.12.2016.
 */

public class ApplyFragment extends Fragment {
    FragmentManager fragmentManager;
    public ApplyFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.apply_fragment,container,false);


    }
}
