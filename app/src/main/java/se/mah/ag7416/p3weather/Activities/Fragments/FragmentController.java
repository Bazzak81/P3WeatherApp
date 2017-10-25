package se.mah.ag7416.p3weather.Activities.Fragments;

import android.util.Log;

import se.mah.ag7416.p3weather.Activities.Activities.FragmentActivity;
import se.mah.ag7416.p3weather.Activities.Controllers.JSONParser;
import se.mah.ag7416.p3weather.Activities.Controllers.Querry;

/**
 * Created by Jimmy Åkesson on 2017-10-24.
 */

public class FragmentController {

    private String temp;
    private String windSpeed;
    private String city;
    private int icon;
    private Querry querry;
    private JSONParser parser;
    private WeatherFragment fragment;
    private FragmentActivity fragmentActivity;

    public FragmentController(String cityQuerry, FragmentActivity fragmentActivity) {
        this.fragmentActivity=fragmentActivity;
        fragment= new WeatherFragment();
        fragment.setController(this);
        fragmentActivity.addFragment(fragment);

                //TODO lägga till controller?
        querry = new Querry();
        querry.setCity(cityQuerry,this);
        querry.start();
    }

    public void updateParser(JSONParser parser){
        this.parser=parser;
        fragmentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setValues();
            }
        });
        //TODO kör alla set metoder
    }

    private void setValues(){
        fragment.setText(parser.getCity(),parser.getTemp(),parser.getWindspeed(),parser.getIcon());
        Log.d("FragmentController ", "setValues: "+parser.getIcon());
    }
}
