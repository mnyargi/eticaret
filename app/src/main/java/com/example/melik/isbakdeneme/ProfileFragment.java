package com.example.melik.isbakdeneme;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.melik.isbakdeneme.R;

/**
 * Created by melik on 23.12.2016.
 */

public class ProfileFragment extends android.support.v4.app.Fragment {

    FragmentManager fragmentManager;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment,container,false);


    }
}
