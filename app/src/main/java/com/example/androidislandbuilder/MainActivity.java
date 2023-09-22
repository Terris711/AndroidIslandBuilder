package com.example.androidislandbuilder;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MapFragment mapFragment = new MapFragment();
    SelectorFragment selectorFragment = new SelectorFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.map, mapFragment).commit();

        fragmentManager.beginTransaction().add(R.id.selector, selectorFragment).commit();

    }
}