package se.mah.ag7416.p3weather.Activities.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import se.mah.ag7416.p3weather.Activities.Fragments.WeatherFragment;
import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-18.
 */

public class FragmentActivity extends AppCompatActivity {

    private WeatherFragment weatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        weatherFragment = new WeatherFragment();
        addFragment(weatherFragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction swap = getSupportFragmentManager().beginTransaction();
        swap.replace(R.id.fragment_container, fragment);
        swap.commit();
    }
}
