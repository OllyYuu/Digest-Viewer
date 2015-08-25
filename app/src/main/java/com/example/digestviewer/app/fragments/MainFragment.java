package com.example.digestviewer.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.digestviewer.app.MainActivity;
import com.example.digestviewer.app.R;
import com.example.digestviewer.app.adapters.SourceAdapter;

/**
 * Created by OllyYuu on 24.08.2015.
 */
public class MainFragment extends BaseFragment {
    @Override
    public FragmentId getFragmentId() {
        return FragmentId.FRAGMENT_MAIN;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listviewSource);
        listView.setAdapter(new SourceAdapter(getActivity()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((MainActivity)getActivity()).pushFragment(FragmentId.FRAGMENT_LIST);
            }
        });

        return rootView;
    }
}
