package se.mah.ag7416.p3weather.Activities.Controllers;

import se.mah.ag7416.p3weather.Activities.Fragments.FragmentController;


/**
 * Created by Jimmy Åkesson on 2017-10-24.
 */

public class Querry extends Thread {

    private String city;
    private double Long,Lat;
    private FragmentController fragmentController;
    private boolean firstFragment=false;

    public void setCity(String city,double Long,double Lat, FragmentController fragmentController) {
        this.city = city;
        this.fragmentController = fragmentController;
        this.Long=Long;
        this.Lat=Lat;
        if(city.equals("Home")) firstFragment=true;
    }


    @Override
    public void run() {
        JSONParser question = new JSONParser(city,Long,Lat);
        if (question != null) {
            fragmentController.updateParser(question,firstFragment);
        }
        interrupt();
    }
}