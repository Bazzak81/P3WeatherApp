package se.mah.ag7416.p3weather.Activities.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import java.io.IOException;
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
    private double longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

//        new FragmentController("Lund", this);
        LocationManager lm = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null);
        Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        latitude = loc.getLatitude();
        longitude = loc.getLongitude();
        Log.d("FragmentActivity", "Lat & Long "+latitude+" & "+longitude);
        controller = new Controller(this);
        controller.createNewFragment("Home",longitude,latitude);
//        controller.createNewFragment("Lomma",0,0);
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
        latitude = location.getLatitude();
        longitude = location.getLongitude();

        //TODO Updatera hemfragmentet
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