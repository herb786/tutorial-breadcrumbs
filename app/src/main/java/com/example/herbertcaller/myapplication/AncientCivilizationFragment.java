package com.example.herbertcaller.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AncientCivilizationFragment extends Fragment {

    StoreActivity storeActivity;
    TextView egyptHome;
    TextView sumerHome;

    public AncientCivilizationFragment() {
        // Required empty public constructor
    }

    public static AncientCivilizationFragment newInstance() {
        AncientCivilizationFragment fragment = new AncientCivilizationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storeActivity = (StoreActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ancient_civilization, container, false);
        egyptHome = view.findViewById(R.id.egyptHome);
        sumerHome = view.findViewById(R.id.sumerHome);

        final EgyptFragment egyptFragment = new EgyptFragment();
        final SumerFragment sumerFragment = new SumerFragment();

        /*
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.ancientCivilizationContainer, egyptFragment, "EgyptFragment")
                .commit();

        getChildFragmentManager()
                .beginTransaction()
                .setPrimaryNavigationFragment(egyptFragment)
                .add(R.id.ancientCivilizationContainer, sumerFragment, "SumerFragment")
                .commit();
                */

        egyptHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeActivity.breadcrumbTextView.setText("Store > History > Ancient Civilization > Egypt");
                getChildFragmentManager()
                        .beginTransaction()
                        .addToBackStack("EgyptFragment")
                        .add(R.id.ancientCivilizationContainer, egyptFragment, "EgyptFragment")
                        //.show(egyptFragment)
                        //.hide(sumerFragment)
                        .commit();
            }
        });

        sumerHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeActivity.breadcrumbTextView.setText("Store > History > Ancient Civilization > Sumer");
                getChildFragmentManager()
                        .beginTransaction()
                        .addToBackStack("SumerFragment")
                        .add(R.id.ancientCivilizationContainer, sumerFragment, "SumerFragment")
                        //.show(sumerFragment)
                        //.hide(egyptFragment)
                        .commit();
            }
        });

        return view;
    }

}
