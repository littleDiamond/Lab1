package com.examples.myreceipts;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class PointOfSaleActivity extends AppCompatActivity {
    private static final String TAG = "PointOfSaleActivity";
    ArrayList<InventoryItem> posItems = new ArrayList<>();
    private RecyclerView rvPOS;
    private RecyclerView.LayoutManager manager;
    private POSAdapter mPOSAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos);
        Log.d(TAG, "onCreate: Started.");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // setup the grid layout
        rvPOS = findViewById(R.id.rvPOS);
        manager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        rvPOS.setLayoutManager(manager);

        // populate the grid with inventory items
        posItems = getIntent().getExtras().getParcelableArrayList("InventoryItem");
        mPOSAdapter = new POSAdapter(this, posItems);
        rvPOS.setAdapter(mPOSAdapter);

    }
}
