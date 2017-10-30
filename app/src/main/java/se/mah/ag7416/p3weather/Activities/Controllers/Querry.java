package se.mah.ag7416.p3weather.Activities.Controllers;

import se.mah.ag7416.p3weather.Activities.Fragments.FragmentController;


/**
 * Created by Jimmy Åkesson on 2017-10-24.
 */

public class Querry extends Thread {

    private String city;
    private double Long,Lat;
    private FragmentController fragmentController;

    public void setCity(String city,double Long,double Lat, FragmentController fragmentController) {
        this.city = city;
        this.fragmentController = fragmentController;
    }


    @Override
    public void run() {
        JSONParser question = new JSONParser(city);
        if (question != null) {
            fragmentController.updateParser(question);
        }
        interrupt();

//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        JSONParser test = new JSONParser("träleborg");
//        Log.d("Querry", "onCreate: city " + test.getCity());
//        Log.d("Querry", "onCreate: temp " + test.getTemp());
//        if (test.getError()!=null)
//            Log.d("Querry", "onCreate: null");
    }
}