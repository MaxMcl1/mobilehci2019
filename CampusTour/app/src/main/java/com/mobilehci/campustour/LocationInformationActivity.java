package com.mobilehci.campustour;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mobilehci.campustour.ui.home.HomeActivity;

public class LocationInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location_information);

        FloatingActionButton fab = findViewById(R.id.CameraButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, HomeActivity.REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        Bundle b = getIntent().getExtras();
        int value = 0; // or other values

        if (b != null) value = b.getInt("key");

        Building building = Building.values()[value];

        TextView Name = findViewById(R.id.LocationName);
        SpannableString buildingName = new SpannableString(building.getName());
        buildingName.setSpan(new UnderlineSpan(), 0, buildingName.length(), 0);
        Name.setText(buildingName);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.LocationLayout);

        for (int i = 0; i < building.getFacilities().length; i++) {
            ImageView image = new ImageView(this);

            image.setImageResource(building.getFacilities()[i]);
            image.setId(i);
            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
            image.setMaxHeight(15);
            image.setMaxWidth(15);
            //image.setColorFilter(Color.parseColor("#54a0ff"));
            //image.setColorFilter(Color.BLACK);

            layout.addView(image);

            ConstraintSet set = new ConstraintSet();
            set.clone(layout);

            int topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
            set.connect(image.getId(), ConstraintSet.TOP, R.id.LocationName, ConstraintSet.BOTTOM, topMargin);

            int leftMargin = (i * 90) + 32;
            if (i == 0) leftMargin = 32;

            set.connect(image.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, leftMargin);
            set.connect(R.id.Location_Information, ConstraintSet.TOP, image.getId(), ConstraintSet.BOTTOM, topMargin);
            set.applyTo(layout);
        }

        TextView Info = findViewById(R.id.Location_Information);
        Info.setText(building.getDescription());

        CheckedTextView Visited = findViewById(R.id.Visited_Checked);
        Visited.setChecked(true);

        if (building.isVisited()) {
            Visited.setCheckMarkDrawable(R.drawable.ic_check);
        } else {
            Visited.setCheckMarkDrawable(R.drawable.ic_clear);
        }

        ImageView image = findViewById(R.id.LocationImage);
        image.setImageResource(building.getImage());
    }
}
