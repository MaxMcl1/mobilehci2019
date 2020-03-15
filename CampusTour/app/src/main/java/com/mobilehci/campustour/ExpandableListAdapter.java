package com.mobilehci.campustour;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> names;
    private List<String> descriptions;
    private List<Integer> images;
    private HashMap<String, List<Building>> expandableListDetail;

    public ExpandableListAdapter(Context context, List<String> names, List<String> descriptions, List<Integer> images, HashMap<String, List<Building>> expandableListDetail) {
        this.context = context;
        this.names = names;
        this.descriptions = descriptions;
        this.images = images;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.names.get(listPosition)).get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final Building building = (Building) getChild(listPosition, expandedListPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row_item, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.buildingRowName);
        TextView description = (TextView) convertView.findViewById(R.id.buildingRowDescription);
        ImageView image = (ImageView) convertView.findViewById(R.id.buildingRowImage);

        name.setText(building.getName());
        if (building.getDescription().length() > 81) {
            description.setText(building.getDescription().substring(0, 80) + "...");
        } else {
            description.setText(building.getDescription());
        }
        image.setImageResource(building.getImage());

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.names.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.names.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.names.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row_friends_item, null);
        }

        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.friendName);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        TextView name = (TextView) convertView.findViewById(R.id.friendName);
        TextView description = (TextView) convertView.findViewById(R.id.friendDescription);
        ImageView image = (ImageView) convertView.findViewById(R.id.friendImage);

        name.setText(names.get(listPosition));
        description.setText(descriptions.get(listPosition));
        image.setImageResource(images.get(listPosition));

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
