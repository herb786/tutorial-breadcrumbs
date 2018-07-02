package com.example.herbertcaller.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EgyptFragment extends Fragment {

    public EgyptFragment() {
        // Required empty public constructor
    }

    public static EgyptFragment newInstance() {
        EgyptFragment fragment = new EgyptFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_egypt, container, false);
    }

}
