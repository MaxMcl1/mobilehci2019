package com.mobilehci.campustour.ui.friends;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mobilehci.campustour.Building;
import com.mobilehci.campustour.ExpandableListAdapter;
import com.mobilehci.campustour.LocationInformationActivity;
import com.mobilehci.campustour.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FriendsFragment extends Fragment {

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_friends, container, false);

        List<String> names = new ArrayList<>(Arrays.asList("robertpringle2", "patrick_devanney", "max_the_mclaughlan69"));
        HashMap<String, List<Building>> expandableListDetail = new HashMap<>();

        expandableListDetail.put(names.get(0), Arrays.asList(Building.BOYD_ORR, Building.ST_ANDREWS, Building.KELVIN));
        expandableListDetail.put(names.get(1), Arrays.asList(Building.BOYD_ORR, Building.LIBRARY));
        expandableListDetail.put(names.get(2), Arrays.asList(Building.KELVIN, Building.MAIN, Building.KELVIN, Building.LIBRARY));

        List<String> descriptions = new ArrayList<>(Arrays.asList("Last active 2 hours ago", "Last active 3 days ago", "Last active 9 mins ago"));
        List<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.robert_pringle, R.drawable.patrick_devanney, R.drawable.max_mclaughlan));

        ExpandableListAdapter friendsAdapter = new ExpandableListAdapter(getContext(), names, descriptions, images, expandableListDetail);

        ExpandableListView listView = root.findViewById(R.id.list_friends);
        listView.setAdapter(friendsAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(getActivity(), LocationInformationActivity.class);

                String selected = ((TextView) v.findViewById(R.id.buildingRowName)).getText().toString().toUpperCase().replaceAll(" ", "_");
                selected = selected.replaceAll("_BUILDING", "");

                Bundle b = new Bundle();
                b.putInt("key", Building.valueOf(selected).ordinal()); //Your id
                intent.putExtras(b); //Put your id to your next Intent

                startActivity(intent);

                return false;
            }
        });

        Toast toast = Toast.makeText(getContext(), "Click a friend to see the buildings which they have discovered", Toast.LENGTH_LONG);
        toast.show();

        return root;
    }
}
