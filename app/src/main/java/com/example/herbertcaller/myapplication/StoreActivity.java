package com.example.herbertcaller.myapplication;

import android.os.Bundle;
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
                breadcrumbTextView.setText("Store>History");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.storeContainer, new HistoryFragment(), "HistoryFragment")
                        .commit();
            }
        });

    }
}
