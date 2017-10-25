package se.mah.ag7416.p3weather.Activities.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jimmy Åkesson on 2017-10-23.
 */

public class Connection {

    //API key: 92d45b077fa249614bfc79c61cf8b50f
    private String apiKey = "&APPID=92d45b077fa249614bfc79c61cf8b50f";
    private String httpPath = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String language = "&lang=se";
    private String unit = "&units=metric";

    public Connection() {

    }

    public String getWeather(String city) {
        HttpURLConnection connection;
        InputStream inputStream;
        if (!city.equals("")) {
            try {
                connection = (HttpURLConnection) (new URL(httpPath + city + ",se" + apiKey + language

                        + unit)
                ).openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.connect();

                StringBuilder buffer = new StringBuilder();
                inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    buffer.append(line).append("\r\n");
                }
                inputStream.close();
                connection.disconnect();
                return buffer.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else{
            return null;
        }

    }
}