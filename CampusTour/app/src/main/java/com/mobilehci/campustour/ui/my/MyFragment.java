package com.mobilehci.campustour.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mobilehci.campustour.Building;
import com.mobilehci.campustour.ListAdapter;
import com.mobilehci.campustour.LocationInformationActivity;
import com.mobilehci.campustour.R;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my, container, false);

        List<String> names = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        List<Integer> images = new ArrayList<>();

        for (Building b : Building.values()) {
            if (b.isVisited()) {
                names.add(b.getName());
                descriptions.add(b.getDescription());
                images.add(b.getImage());
            }
        }

        if (names.size() > 0) {
            ListAdapter allBuildingsAdapter = new ListAdapter(getActivity(), names, descriptions, images);

            ListView listView = root.findViewById(R.id.list_my_buildings);
            listView.setAdapter(allBuildingsAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), LocationInformationActivity.class);

                    Bundle b = new Bundle();
                    b.putInt("key", position); //Your id
                    intent.putExtras(b); //Put your id to your next Intent

                    startActivity(intent);
                }
            });
        } else {
            root.findViewById(R.id.empty_text).setVisibility(View.VISIBLE);
        }

        return root;
    }
}