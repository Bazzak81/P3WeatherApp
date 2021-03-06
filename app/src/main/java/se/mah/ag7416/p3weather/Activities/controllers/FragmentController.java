package se.mah.ag7416.p3weather.Activities.controllers;

import android.util.Log;

import se.mah.ag7416.p3weather.Activities.activities.FragmentActivity;
import se.mah.ag7416.p3weather.Activities.connection.JSONParser;
import se.mah.ag7416.p3weather.Activities.connection.Querry;
import se.mah.ag7416.p3weather.Activities.fragments.WeatherFragment;

/**
 * Created by Jimmy Åkesson on 2017-10-24.
 */

public class FragmentController {

    private double Long, Lat;
    private String city = "Home";
    private Querry querry;
    private JSONParser parser;
    private WeatherFragment fragment;
    private FragmentActivity fragmentActivity;

    public FragmentController(String cityQuerry, FragmentActivity fragmentActivity, double Long,
                              double Lat) {
        this.fragmentActivity = fragmentActivity;
        this.city = cityQuerry;
        this.Long = Long;
        this.Lat = Lat;
        fragment = new WeatherFragment();
        fragment.setController(this);
        runQuerry();
        fragmentActivity.addFragment(fragment, city);

        //TODO lägga till controller?

    }

    public WeatherFragment getFragment() {
        return fragment;
    }

    public FragmentActivity getActivity() {
        return fragmentActivity;
    }

    public void newFragmentDialog() {
        fragmentActivity.getController().fragmentDialog();
    }

    public void runQuerry() {

        querry = new Querry();
        querry.setCity(city, Long, Lat, this);
        querry.start();
    }

    public void updateParser(JSONParser parser, final boolean firstFragment) {
        this.parser = parser;

        fragmentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setValues();
                if(firstFragment) fragment.hideMinusButton();
            }
        });

    }

    private void setValues() {
        fragment.setText(parser.getCity(), parser.getTemp(), parser.getWindspeed(),
                parser.getIcon(), parser.getDescription(), parser.getBackground());

    }


}
