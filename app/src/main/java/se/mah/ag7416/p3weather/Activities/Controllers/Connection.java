package se.mah.ag7416.p3weather.Activities.Controllers;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.ContentValues.TAG;

/**
 * Created by Jimmy Åkesson on 2017-10-23.
 */

public class Connection {

    //API key: 92d45b077fa249614bfc79c61cf8b50f
    private String apiKey = "92d45b077fa249614bfc79c61cf8b50f";
    private String httpPath = "api.openweathermap.org/data/2.5/weather?q=";


    public Connection() {


    }
}