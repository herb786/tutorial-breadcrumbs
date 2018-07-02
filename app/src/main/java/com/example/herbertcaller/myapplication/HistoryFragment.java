package com.example.herbertcaller.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HistoryFragment extends Fragment {

    TextView ancientCivilizationHome;
    StoreActivity storeActivity;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
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
        View  view = inflater.inflate(R.layout.fragment_history, container, false);
        ancientCivilizationHome = view.findViewById(R.id.ancientCivilizationHome);

        ancientCivilizationHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeActivity.breadcrumbTextView.setText("Store>History");
                getChildFragmentManager()
                        .beginTransaction()
                        .add(R.id.historyContainer, new AncientCivilizationFragment(), "AncientCivilizationFragment")
                        .commit();
            }
        });
        return view;
    }

}
