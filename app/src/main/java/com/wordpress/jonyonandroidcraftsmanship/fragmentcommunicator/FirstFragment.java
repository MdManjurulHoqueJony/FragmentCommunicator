package com.wordpress.jonyonandroidcraftsmanship.fragmentcommunicator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

    private Button btnClick;
    private int counter = 0;
    private OnCommunicator communicator;
    private ClickListener clickListener = new ClickListener();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            counter = 0;
        } else {
            counter = savedInstanceState.getInt("counter");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (OnCommunicator) getActivity();
        initializeView();
        setListeners();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    private void initializeView() {
        btnClick = (Button) getActivity().findViewById(R.id.btnClick);
    }

    private void setListeners() {
        btnClick.setOnClickListener(clickListener);
    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            counter++;
            communicator.carryData("Clicked " + counter + " times");
        }
    }
}
