package com.mobilehci.campustour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobilehci.campustour.ui.home.HomeActivity;

import java.util.Random;

/*public class LocationInformationActivity extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_location_information, container, false);

        Bundle b = this.getArguments();
        int value = 0; // or other values

        if(b != null)
            value = b.getInt("key");

        Building building = Building.values()[value];

        TextView Name = root.findViewById(R.id.LocationName);
        Name.setText(building.getName());

        TextView Info = root.findViewById(R.id.Location_Information);
        Info.setText(building.getDescription());

        TextView Visited = root.findViewById(R.id.VisitedText);
        Visited.setText(Boolean.toString(building.isVisited()));

        ImageView image = root.findViewById(R.id.LocationImage);
        image.setImageResource(building.getImage());

        return root;
    }
}*/

public class LocationInformationActivity extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_information);

        Bundle b = getIntent().getExtras();
        int value = 0; // or other values

        if(b != null)
            value = b.getInt("key");

        Building building = Building.values()[value];

        TextView Name = findViewById(R.id.LocationName);
        Name.setText(building.getName());

        TextView Info = findViewById(R.id.Location_Information);
        Info.setText(building.getDescription());

        TextView Visited = findViewById(R.id.VisitedText);
        Visited.setText(Boolean.toString(building.isVisited()));

        ImageView image = findViewById(R.id.LocationImage);
        image.setImageResource(building.getImage());
    }
}
