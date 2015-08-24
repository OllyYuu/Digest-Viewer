package com.example.digestviewer.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.digestviewer.app.R;

/**
 * Created by OllyYuu on 24.08.2015.
 */
public class MainFragment extends BaseFragment {
    @Override
    FragmentId getFragmentId() {
        return FragmentId.FRAGMENT_MAIN;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }
}
