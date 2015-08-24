package com.example.digestviewer.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.digestviewer.app.R;
import com.example.digestviewer.app.module.Source;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OllyYuu on 24.08.2015.
 */
public class SourceAdapter extends BaseAdapter {

    List<Source> data;
    private Context context;

    public SourceAdapter(Context context) {
        this.context = context;
        data = new ArrayList<Source>();
        Source source = new Source();
        source.name = "TestName";
        data.add(source);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.source_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.sourceItemName);
        textView.setText(data.get(i).name);

        return view;
    }
}
