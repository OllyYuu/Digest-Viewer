package com.example.digestviewer.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.digestviewer.app.R;

/**
 * Created by OllyYuu on 24.08.2015.
 */
public class ListFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View listView = inflater.inflate(R.layout.fragment_list, container, false);

        return listView;
    }

    @Override
    public FragmentId getFragmentId() {
        return FragmentId.FRAGMENT_LIST;
    }
}
