package se.mah.ag7416.p3weather.Activities.Controllers;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import se.mah.ag7416.p3weather.R;

/**
 * Created by Jimmy Åkesson on 2017-10-23.
 */

public class JSONParser {

    private JSONObject jsonObject;

    public JSONParser(String city) {
        String data = new Connection().getWeather(city);
        Log.d("JSONParser", "JSONParser: " + data);
        try {
            jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTemp() {
        try {
            JSONObject main = jsonObject.getJSONObject("main");
            return main.getString("temp");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getWindspeed() {
        try {
            JSONObject wind = jsonObject.getJSONObject("wind");
            return wind.getString("speed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCity() {
        try {
            return jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIcon() {
        try {
            JSONArray weather = jsonObject.getJSONArray("weather");
            JSONObject w = weather.getJSONObject(0);
            String icon = w.getString("icon");
            if (icon.equals("01d") || icon.equals("01n")) {
                return R.drawable.sunny;
            }else
            if (icon.equals("02d") || icon.equals("02n")) {
                return R.drawable.sunnycloudy;
            }else
            if (icon.equals("03d") || icon.equals("03n") || icon.equals("04d") || icon.equals
                    ("04n") || icon.equals("50d")
                    || icon.equals("50n")) {
                return R.drawable.cloudy;
            }else
            if (icon.equals("09d") || icon.equals("09n") || icon.equals("11d") || icon.equals
                    ("11n")) {
                return R.drawable.rainy;
            }else
            if (icon.equals("10d") || icon.equals("10n")) {
                return R.drawable.sunnyrainy;
            }else
            if (icon.equals("13d") || icon.equals("13n")) {
                return R.drawable.snowy;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getError() {
        try {
            return jsonObject.getString("error");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
