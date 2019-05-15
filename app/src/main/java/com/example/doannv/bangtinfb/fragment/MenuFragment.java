package com.example.doannv.bangtinfb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doannv.bangtinfb.R;

public class MenuFragment extends Fragment {
    private View statics;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        statics = inflater.inflate( R.layout.menu_fragment, container, false );

        return statics;
    }
}
