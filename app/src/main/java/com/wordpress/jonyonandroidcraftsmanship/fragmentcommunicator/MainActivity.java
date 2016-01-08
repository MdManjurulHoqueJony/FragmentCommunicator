package com.wordpress.jonyonandroidcraftsmanship.fragmentcommunicator;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity implements OnCommunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void carryData(String text) {
        FragmentManager fragmentManager = getFragmentManager();
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.fragment2);
        secondFragment.changeText(text);
    }
}
