package se.mah.ag7416.p3weather.Activities.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import java.lang.reflect.Array;

import se.mah.ag7416.p3weather.Activities.Controllers.Controller;
import se.mah.ag7416.p3weather.Activities.Fragments.WeatherFragment;
import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-18.
 */

public class FragmentActivity extends AppCompatActivity implements LocationListener {

    private WeatherFragment weatherFragment;
    private Controller controller;
    private double longitude, latitude;
    private int numberOfFragments = 0;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private String[] fragmentTags = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        LocationManager lm = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null);
        Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        latitude = loc.getLatitude();
        longitude = loc.getLongitude();
        controller = new Controller(this);
        controller.createNewFragment("Home", longitude, latitude);

        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlideAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
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
        numberOfFragments++;
        Log.d("FragmentActivity", "addFragment: "+tag);
        String[] temp = fragmentTags;
        fragmentTags = new String[numberOfFragments];
//        fragmentTags=temp;
        fragmentTags[numberOfFragments-1]=tag;
    }

    public void removeFragment(Fragment fragment) {
        FragmentTransaction remove = getSupportFragmentManager().beginTransaction();
        remove.remove(fragment);
        remove.commit();
        numberOfFragments--;
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

    private class ScreenSlideAdapter extends FragmentStatePagerAdapter {
        private FragmentManager fm;

        public ScreenSlideAdapter(FragmentManager fm) {
            super(fm);
            this.fm=fm;
        }

        @Override
        public Fragment getItem(int position) {
            return fm.findFragmentByTag(fragmentTags[position]);
        }

        @Override
        public int getCount() {
            return numberOfFragments;
        }
    }
}