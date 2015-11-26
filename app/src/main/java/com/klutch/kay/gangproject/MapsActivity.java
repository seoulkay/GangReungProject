package com.klutch.kay.gangproject;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        String addr = intent.getStringExtra("NEW address");

        Toast.makeText(getApplicationContext(), addr, Toast.LENGTH_SHORT).show();

        TextView textView = (TextView)findViewById(R.id.detail_content);
        textView.setText(intent.getStringExtra("detail_content"));


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

        Intent intent = getIntent();
        String addr = intent.getStringExtra("NEW address");

        /*Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + addr);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        */

        Double lat = 0d;
        Double lon = 0d;
        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> result = geocoder.getFromLocationName(addr, 1);
            lat = result.get(0).getLatitude();
            lon = result.get(0).getLongitude();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LatLng MV =new LatLng(37.4, -122.1);

        // Add a marker in Sydney and move the camera
        LatLng venue= new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(venue).title("Marker in the attraction"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(venue, 18));
        //mMap.animateCamera(CameraUpdateFactory.zoomIn());
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        //CameraPosition cameraPosition = new CameraPosition.Builder().target(MV).zoom(17).bearing(90).tilt(30).build();
        //mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}
