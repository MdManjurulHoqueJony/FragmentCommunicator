package com.wordpress.jonyonandroidcraftsmanship.fragmentcommunicator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    private TextView tvText;
    private String text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        if (savedInstanceState != null) {
            text = savedInstanceState.getString("text");
            tvText = (TextView) view.findViewById(R.id.tvText);
            tvText.setText(text);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", text);
    }

    private void initializeView() {
        tvText = (TextView) getActivity().findViewById(R.id.tvText);
    }

    public void changeText(String text) {
        this.text = text;
        tvText.setText(text);
    }

}
