package com.mobilehci.campustour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LocationInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_information);

        int randInt = new Random().nextInt(Building.values().length);


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
