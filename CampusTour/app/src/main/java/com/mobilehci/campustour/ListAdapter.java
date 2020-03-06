package com.mobilehci.campustour;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private List<String> names;
    private List<String> descriptions;
    private List<Integer> images;
    private Activity context;

    public ListAdapter(Activity context, List<String> names, List<String> descriptions, List<Integer> images) {
        super(context, R.layout.list_row_item, names);
        this.context = context;
        this.names = names;
        this.descriptions = descriptions;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) row = inflater.inflate(R.layout.list_row_item, null, true);

        TextView name = (TextView) row.findViewById(R.id.buildingRowName);
        TextView description = (TextView) row.findViewById(R.id.buildingRowDescription);
        ImageView image = (ImageView) row.findViewById(R.id.buildingRowImage);

        name.setText(names.get(position));
        description.setText(descriptions.get(position).substring(0, 140) + "...");
        image.setImageResource(images.get(position));

        return  row;
    }
}
