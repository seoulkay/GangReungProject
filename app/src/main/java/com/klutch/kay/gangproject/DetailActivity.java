package com.klutch.kay.gangproject;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class DetailActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    //Grace: 갤러리 뷰
    ImageView lastClicked = null;
    //이미지 크기
    int width = 400;
    int height = 300;
    int padding = 10;

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 150;

    int size = (int) Math.ceil(Math.sqrt(MAX_WIDTH * MAX_HEIGHT));



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

        //Toast.makeText(getApplicationContext(), addr, Toast.LENGTH_SHORT).show();
        TextView place = (TextView)findViewById(R.id.detail_place);
        place.setText(intent.getStringExtra("Place"));
        TextView textView = (TextView)findViewById(R.id.detail_txtView);
        textView.setText(intent.getStringExtra("detail_content"));
        TextView txt_website = (TextView)findViewById(R.id.txt_url);
        txt_website.setText(intent.getStringExtra("homepage"));
        //전화번호가 없다니...
        TextView txt_number = (TextView)findViewById(R.id.txt_number);
        txt_number.setText(intent.getStringExtra("phone"));
        TextView attractions = (TextView)findViewById(R.id.attractions);
        attractions.setText(intent.getStringExtra("attractions"));


        //Grace: 갤러리
        LinearLayout l;
        l = (LinearLayout) findViewById(R.id.detail_imgGallery);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        String[] images = intent.getStringArrayExtra("imgs");

        for (int i=1; i<images.length; i++){
            System.out.println("URL ADDRESS" + images[i]);
            ImageView iv = new ImageView(this);
            //사진 로딩
            Picasso.with(getApplicationContext()).load("http://" + images[i]).transform(new BitmapTransform(MAX_WIDTH, MAX_HEIGHT)).resize(size, size).centerInside().into(iv);

            iv.setLayoutParams(layoutParams);
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



        Double lat = 0d;
        Double lon = 0d;
        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> result = geocoder.getFromLocationName(addr, 1);
            lat = result.get(0).getLatitude();
            lon = result.get(0).getLongitude();
        } catch (Exception e) {
            e.printStackTrace();
           try {
               List<Address> result = geocoder.getFromLocationName("강원도", 1);
               lat = result.get(0).getLatitude();
               lon = result.get(0).getLongitude();
           }catch(IOException e1){
               e.printStackTrace();
           }
        }

        LatLng MV =new LatLng(37.4, -122.1);

        // Add a marker in Sydney and move the camera
        LatLng venue= new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(venue).title("Marker in the attraction"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(venue, 10));
        //mMap.animateCamera(CameraUpdateFactory.zoomIn());
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        //CameraPosition cameraPosition = new CameraPosition.Builder().target(MV).zoom(17).bearing(90).tilt(30).build();
        //mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    //Grace: 갤러리 이미지 클릭

    public void onClick(View v){
        if (v instanceof ImageView){
            if(lastClicked != null){
                lastClicked.setPadding(padding, padding, padding, padding);
                lastClicked.invalidate();
            }
            v.setPadding(0,0,0,0);
            v.invalidate();
            lastClicked = (ImageView) v;
        }
    }

}
