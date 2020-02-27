package com.mobilehci.campustour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button map = (Button)findViewById(R.id.mapBtn);
        map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent mapIntent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(mapIntent);
            }
        });
    }
}
