package com.example.digestviewer.app.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.digestviewer.app.R;
import com.example.digestviewer.app.module.Source;
import com.squareup.picasso.Picasso;

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
        source.name = "Habrahabr";
        source.numberArticle = 2;
        source.numberNewArticle =0;


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
        TextView sourceName = (TextView) view.findViewById(R.id.sourceItemName);
        sourceName.setText(data.get(i).name);

        TextView numArtical = (TextView) view.findViewById(R.id.numberArticle);
        numArtical.setText(Integer.toString(data.get(i).numberArticle));

        TextView numNewArtical = (TextView) view.findViewById(R.id.numberNewArticle);
        numNewArtical.setText(Integer.toString(data.get(i).numberNewArticle));

        ImageView logo = (ImageView) view.findViewById(R.id.logo);
        Picasso.with(context).load("http://hsto.org/storage2/d06/04e/552/d0604e552dec681e3994b4a550bcfaa2.png").into(logo);


        return view;
    }
}
