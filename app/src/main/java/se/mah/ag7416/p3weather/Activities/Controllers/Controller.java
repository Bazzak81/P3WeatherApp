package se.mah.ag7416.p3weather.Activities.Controllers;

import android.util.Log;

/**
 * Created by OlleOlsson on 2017-10-18.
 */

public class Controller {

    public Controller(){
        new Querry().start();
    }


    private class Querry extends Thread{

        private static final String TAG = "Querry" ;

        @Override
        public void run() {
            JSONParser question = new JSONParser("Malmo");
            Log.d(TAG, "onCreate: city "+question.getCity());
            Log.d(TAG, "onCreate: temp "+question.getTemp());
        }
    }
}
