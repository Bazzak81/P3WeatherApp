package se.mah.ag7416.p3weather.Activities.Controllers;

import android.util.Log;

/**
 * Created by OlleOlsson on 2017-10-18.
 */

//TODO Flytta över all text till values/strings

public class Controller {

    public Controller(){
        new Querry().start();
    }


    private class Querry extends Thread{


        @Override
        public void run() {
            JSONParser question = new JSONParser("Malmo");
            Log.d("Querry", "onCreate: city "+question.getCity());
            Log.d("Querry", "onCreate: temp "+question.getTemp());
        }
    }
}
