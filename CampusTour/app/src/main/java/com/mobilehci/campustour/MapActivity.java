package com.mobilehci.campustour;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Places.initialize(getApplicationContext(), AIzaSyAktuE_JafSa7eZLYXNN3i2VQUiAAgAOTE);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng boydOrr = new LatLng(55.8736, -4.2926);
        LatLng stAndrews = new LatLng(55.8715, -4.2794);
        LatLng kelvin = new LatLng(55.8715, -4.2919);
        LatLng mainBuilding = new LatLng(55.8715, -4.2885);
        LatLng library = new LatLng(55.8734, -4.2889);

        mMap.addMarker(new MarkerOptions().position(stAndrews).title("St Andrews Building"));
        mMap.addMarker(new MarkerOptions().position(kelvin).title("Kelvin Building"));
        mMap.addMarker(new MarkerOptions().position(mainBuilding).title("Main Building"));
        mMap.addMarker(new MarkerOptions().position(library).title("Library"));
        mMap.addMarker(new MarkerOptions().position(boydOrr).title("Boyd Orr"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(boydOrr));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(boydOrr, 15.0f));
    }
}
