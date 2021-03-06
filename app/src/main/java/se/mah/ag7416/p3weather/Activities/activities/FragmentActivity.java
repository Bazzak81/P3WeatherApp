package se.mah.ag7416.p3weather.Activities.activities;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import java.util.ArrayList;

import se.mah.ag7416.p3weather.Activities.controllers.Controller;
import se.mah.ag7416.p3weather.Activities.fragments.WeatherFragment;
import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-18.
 */

public class FragmentActivity extends AppCompatActivity implements LocationListener {

    private Controller controller;
    private double longitude, latitude;
    private int numberOfFragments = 0;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private ArrayList<WeatherFragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().hide();
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
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(100);
        pagerAdapter = new ScreenSlideAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        controller = new Controller(this);
        controller.createNewFragment("Home", longitude, latitude);

        //TODO Få detta att funka
        SharedPreferences preferences = getSharedPreferences("save", MODE_PRIVATE);
        if(preferences.contains("numberOfFragments")) {
            int number = preferences.getInt("numberOfFragments", 0);
            for (int x = 1; x <= number-1; x++) {
                String city = preferences.getString("city" + x, "");
                controller.createNewFragment(city, 0, 0);
            }
        }
    }

    public Controller getController() {
        return controller;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void addFragment(WeatherFragment fragment, String tag) {
        numberOfFragments++;
        fragmentList.add(fragment);
        pagerAdapter.notifyDataSetChanged();
        viewPager.setCurrentItem(numberOfFragments);

    }

    public void removeFragment(WeatherFragment fragment) {
        numberOfFragments--;
        int index = fragmentList.indexOf(fragment);
        fragmentList.remove(index);
        pagerAdapter.destroyItem(viewPager,index,fragment);
        pagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
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
            this.fm = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public int getItemPosition(Object object) {
            if (fragmentList.contains((WeatherFragment) object)) {
                return fragmentList.indexOf((WeatherFragment) object);
            } else {
                return POSITION_NONE;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        SharedPreferences preferences = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        if (numberOfFragments > 0) {
            editor.putInt("numberOfFragments", numberOfFragments);
            for (int x = 0; x <= fragmentList.size() - 1; x++) {
                editor.putString("city" + x, fragmentList.get(x).getCity());
            }
            editor.apply();
        }
    }
}