package com.example.doannv.bangtinfb.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.doannv.bangtinfb.R;

public class ThongTinFragment extends Fragment {
    BottomNavigationView bottomNavigationView;
    Toolbar toolbarthongtin;
    private View statics;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        statics = inflater.inflate( R.layout.thongtin_fragment, container, false );
        AnhXa();
        ActionToolbar();
        return statics;
    }

    private void AnhXa() {
        bottomNavigationView = statics.findViewById (R.id.btNavigation);
        toolbarthongtin = statics.findViewById(R.id.toolbarthongtin);
//        final AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.setSupportActionBar(toolbarthongtin);
//        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        activity.getMenuInflater();
//        toolbarthongtin.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
    }
    private void ActionToolbar() {

    }
}
