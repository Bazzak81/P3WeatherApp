package se.mah.ag7416.p3weather.Activities.Controllers;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jimmy Åkesson on 2017-10-23.
 */

public class JSONParser {

    private JSONObject jsonObject;

    public JSONParser(String city){
        String data= new Connection().getWeather(city);
        Log.d("JSONParser", "JSONParser: "+data);
        try {
            jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTemp(){
        try {
            JSONObject main = jsonObject.getJSONObject("main");
            return main.getString("temp");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getWindspeed(){
        try {
            JSONObject wind = jsonObject.getJSONObject("wind");
            return wind.getString("speed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCity(){
        try {
            return jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIcon(){


        return 0;
    }
}
