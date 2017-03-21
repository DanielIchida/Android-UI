package com.example.daniel.mapas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    BottomNavigationView navigation;
    GoogleMap map;
    int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    map.clear();
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(40.401871, -3.720667))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title("Estadio Vicente Caldeon")
                            .snippet("Atletico de Madrid Equipo Colchonero"));
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.401871, -3.720667), 15));
                    return true;
                case R.id.navigation_acercamiento:
                    map.clear();
                    map.animateCamera(CameraUpdateFactory.zoomIn());
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(new LatLng(40.401871, -3.720667))      // Sets the center of the map to Mountain View
                            .zoom(18)                   // Sets the zoom
                            .bearing(0)                // Sets the orientation of the camera to east
                            .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                            .build();                   // Creates a CameraPosition from the builder
                    map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    return true;
                case R.id.navigation_capa:
                    count ++;
                    if(count % 2 == 0){
                        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    }else{
                        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    }
                    return true;
                case R.id.navigation_puntos:
                    map.clear();
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.401871, -3.720667), 2));
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(41.423544, -3.374713))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(34.834805, -11.636431))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(-7.823426, -56.284867))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(7.772729, 20.707317))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(34.213357, 104.203409))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                    break;
            }
            return false;
        }

    };


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //40.401871, -3.720667
        map.addMarker(new MarkerOptions()
                .position(new LatLng(40.401871, -3.720667))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .title("Estadio Vicente Caldeon")
                .snippet("Atletico de Madrid Equipo Colchonero"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.401871, -3.720667), 15));
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }
}
