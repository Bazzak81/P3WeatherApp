package se.mah.ag7416.p3weather.Activities.Controllers;

import android.util.Log;

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
            JSONObject weather = jsonObject.getJSONObject("weather");
            String icon = weather.getString("icon");
            if (icon == "01d" || icon == "01n") {
                return R.drawable.sunny;
            }
            if (icon == "02d" || icon == "02n") {
                return R.drawable.sunnycloudy;
            }
            if (icon == "03d" || icon == "03n" || icon == "04d" || icon == "04n" || icon == "50d"
                    || icon == "50n") {
                return R.drawable.cloudy;
            }
            if (icon == "09d" || icon == "09n" || icon == "11d" || icon == "11n") {
                return R.drawable.rainy;
            }
            if (icon == "10d" || icon == "10n") {
                return R.drawable.sunnyrainy;
            }
            if (icon == "13d" || icon == "13n") {
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
