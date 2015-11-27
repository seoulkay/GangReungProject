package com.klutch.kay.gangproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class DetailActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    //Grace: 갤러리 뷰
    ImageView lastClicked = null;
    //이미지 크기
    int width = 300;
    int height = 200;
    int padding = 30;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detail_map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        String addr = intent.getStringExtra("NEW address");

        Toast.makeText(getApplicationContext(), addr, Toast.LENGTH_SHORT).show();
        TextView place = (TextView)findViewById(R.id.detail_place);
        place.setText(intent.getStringExtra("Place"));
        TextView textView = (TextView)findViewById(R.id.detail_txtView);
        textView.setText(intent.getStringExtra("detail_content"));

        //Grace: 갤러리
        LinearLayout l;
        l = (LinearLayout) findViewById(R.id.detail_imgGallery);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        int[] images = new int[] {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};


        for (int i=0; i<6; i++){
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(layoutParams);
            iv.setImageResource(images[i]);
            iv.setPadding(padding, padding, padding, padding);
            iv.setOnClickListener(this);
            l.addView(iv);
        }
        //Grace: 플로팅 액션 버튼
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TipListPageActivity.class);
                startActivity(intent);
                //Grace: 액티비티 전환 애니메이션 효과
                overridePendingTransition(R.anim.fade, R.anim.cycle_7);
            }
        });

    }

    //Grace: 갤러리 이미지 클릭
    public void onClick(View v){
    }
        /*if (v instanceof ImageView){
            if(lastClicked != null){
                lastClicked.setPadding(padding, padding, padding, padding);
                lastClicked.invalidate();
            }
            v.setPadding(0,0,0,0);
            v.invalidate();
            lastClicked = (ImageView) v;
        }
    }*/


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
