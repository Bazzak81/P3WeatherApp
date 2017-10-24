package se.mah.ag7416.p3weather.Activities.Fragments;

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

    public FragmentController(String cityQuerry) {
        fragment= new WeatherFragment(); //TODO lägga till controller?
        querry = new Querry();
        querry.setCity(cityQuerry,this);
        querry.start();
    }

    public void updateParser(JSONParser parser){
        this.parser=parser;
        setValues();
        //TODO kör alla set metoder
    }

    private void setValues(){
        fragment.setText(parser.getCity(),parser.getTemp(),parser.getWindspeed(),parser.getIcon());
    }
}
