package se.mah.ag7416.p3weather.Activities.controllers;


import java.util.ArrayList;

import se.mah.ag7416.p3weather.Activities.activities.FragmentActivity;
import se.mah.ag7416.p3weather.Activities.fragments.CreateNewFragmentDialog;
import se.mah.ag7416.p3weather.Activities.fragments.WeatherFragment;

/**
 * Created by OlleOlsson on 2017-10-18.
 */

//TODO Flytta över all text till values/strings

public class Controller {


    private FragmentActivity activity;
    private ArrayList<FragmentController> fragmentControllerArrayList= new ArrayList<>();

    public Controller(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    public void fragmentDialog() {
        CreateNewFragmentDialog dialog = new CreateNewFragmentDialog();
        dialog.show(activity.getFragmentManager(), "");
        dialog.setController(this);
    }

    public void createNewFragment(String city, double Long, double Lat){
        FragmentController fragmentController = new FragmentController(city,activity,Long,Lat);
        fragmentControllerArrayList.add(fragmentController);

    }

    public void removeFragment(WeatherFragment fragment){
        activity.removeFragment(fragment);
    }
}
