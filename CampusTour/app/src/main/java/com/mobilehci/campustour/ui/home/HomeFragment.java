package com.mobilehci.campustour.ui.home;

import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobilehci.campustour.Building;

public class HomeFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public void onResume() {
        super.onResume();

        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            getMapAsync(this);

            Toast toast = Toast.makeText(getContext(), "Scan a building QR code", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (Building building : Building.values()) {
            if (building.isVisited()) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(building.getLatitude(), building.getLongitude())).title(building.getName()));
            }
        }

        Building b = Building.BOYD_ORR;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(b.getLatitude(), b.getLongitude())));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(b.getLatitude(), b.getLongitude()), 15.0f));
    }
}