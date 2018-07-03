package com.example.herbertcaller.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StoreActivity extends AppCompatActivity {

    TextView breadcrumbTextView;
    TextView historyHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BOOK STORE
        breadcrumbTextView = findViewById(R.id.breadcrumbTextView);
        historyHome = findViewById(R.id.historyHome);

        breadcrumbTextView.setText("Store");

        historyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breadcrumbTextView.setText("Store > History");
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("HistoryFragment")
                        .add(R.id.storeContainer, new HistoryFragment(),"HistoryFragment")
                        .commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        //popFragmentOnBackPressed();
        popFragmentOnBackPressedUsingId();
    }

    private void popFragmentOnBackPressedUsingId(){
        Fragment lastFragment = null;
        Fragment firstFragment = getSupportFragmentManager().findFragmentById(R.id.storeContainer);
        Fragment beforeLastFragment = getSupportFragmentManager().findFragmentById(R.id.historyContainer);
        if (beforeLastFragment != null)
            lastFragment = beforeLastFragment.getChildFragmentManager().findFragmentById(R.id.ancientCivilizationContainer);
        if (lastFragment != null){
            breadcrumbTextView.setText("Store > History > Ancient Civilization");
            lastFragment.getFragmentManager().popBackStack();
        } else if (beforeLastFragment != null) {
            breadcrumbTextView.setText("Store > History");
            beforeLastFragment.getFragmentManager().popBackStack();
        } else if (firstFragment != null) {
            breadcrumbTextView.setText("Store");
            firstFragment.getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void popFragmentOnBackPressed(){
        int stemFragmentCount = getSupportFragmentManager().getBackStackEntryCount();
        if (stemFragmentCount > 0) {
            // Use container Id to find fragment
            Fragment stemFragment = getSupportFragmentManager().findFragmentByTag("HistoryFragment");
            int branchFragmentCount = stemFragment.getChildFragmentManager().getBackStackEntryCount();
            if (branchFragmentCount > 0) {
                // Use tag to find fragment
                Fragment branchFragment = stemFragment.getChildFragmentManager().findFragmentByTag("AncientCivilizationFragment");
                int leafFragmentCount = branchFragment.getChildFragmentManager().getBackStackEntryCount();
                if (leafFragmentCount > 0) {
                    breadcrumbTextView.setText("Store > History > Ancient Civilization");
                    branchFragment.getChildFragmentManager().popBackStack();
                } else {
                    breadcrumbTextView.setText("Store > History");
                    stemFragment.getChildFragmentManager().popBackStack();
                }
            } else {
                breadcrumbTextView.setText("Store");
                getSupportFragmentManager().popBackStack();
            }
        } else {
            super.onBackPressed();
        }
    }

}
