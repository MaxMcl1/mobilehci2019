package com.mobilehci.campustour.ui.all;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mobilehci.campustour.Building;
import com.mobilehci.campustour.LocationInformationActivity;
import com.mobilehci.campustour.R;

import java.util.ArrayList;
import java.util.List;

public class AllFragment extends Fragment {
    
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_all, container, false);

        List<String> buildings = new ArrayList<>();
        for (Building b : Building.values()) buildings.add(b.getName());

        ArrayAdapter<String> allBuildingsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, buildings);

        ListView listView = root.findViewById(R.id.list_all_buildings);
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

        return root;
    }
}