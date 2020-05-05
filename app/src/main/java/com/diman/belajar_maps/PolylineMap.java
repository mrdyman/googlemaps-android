package com.diman.belajar_maps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class PolylineMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polyline_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        //  tambah koordinat marker
        LatLng untad = new LatLng (-0.836228, 119.893651);
        LatLng kos = new LatLng(-0.830480, 119.885037);

//    atur ukuran marker
        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_hitam);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_merah);

        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();

        Bitmap pinStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap pinDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);


        mMap.addMarker(new MarkerOptions().position(untad).title("Marker in UNTAD")
                .snippet("Ini Kampus Panas")
                .icon(BitmapDescriptorFactory.fromBitmap(pinStart)));


        mMap.addMarker(new MarkerOptions().position(kos).title("Marker lokasi Kos")
        .snippet("ini kos ku say")
        .icon(BitmapDescriptorFactory.fromBitmap(pinDes)));

        mMap.addPolyline(new PolylineOptions().add(
                untad,
                new LatLng(-0.836341, 119.892311),
                new LatLng(-0.836545, 119.892279),
                new LatLng(-0.836384, 119.889565),
                new LatLng(-0.836363, 119.889340),
                new LatLng(-0.836282, 119.889233),
                new LatLng(-0.836282, 119.889233),
                new LatLng(-0.836204, 119.883431),
                new LatLng(-0.836743, 119.883487),
                new LatLng(-0.839093, 119.883360),
                new LatLng(-0.841530, 119.883290),
                new LatLng(-0.841571, 119.884040),
                kos
        ).width(10)
        .color(Color.RED));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kos, 14.5f));

    }
}
