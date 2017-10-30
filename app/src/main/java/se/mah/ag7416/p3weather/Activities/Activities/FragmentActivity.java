package se.mah.ag7416.p3weather.Activities.Activities;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import se.mah.ag7416.p3weather.Activities.Controllers.Controller;
import se.mah.ag7416.p3weather.Activities.Fragments.FragmentController;
import se.mah.ag7416.p3weather.Activities.Fragments.WeatherFragment;
import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-18.
 */

public class FragmentActivity extends AppCompatActivity implements LocationListener {

    private WeatherFragment weatherFragment;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

//        new FragmentController("Lund", this);
        controller = new Controller(this);
        
        controller.createNewFragment("Lomma",0,0);
    }

    public Controller getController() {
        return controller;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void addFragment(Fragment fragment, String tag) {
        FragmentTransaction swap = getSupportFragmentManager().beginTransaction();
        swap.replace(R.id.fragment_container, fragment, tag);
        swap.commit();
    }

    public void removeFragment(Fragment fragment){
        FragmentTransaction remove = getSupportFragmentManager().beginTransaction();
        remove.remove(fragment);
        remove.commit();
    }

    @Override
    public void onLocationChanged(Location location) {
        //TODO Fixa
     
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        Geocoder gc = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = gc.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        if (addresses != null) {

            for (int i = 0; i <= addresses.size(); i++) {
                Log.d("FragmentActivity", "onLocationChanged: " + addresses.get(i));

            }
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}