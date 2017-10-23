package se.mah.ag7416.p3weather.Activities.Models;

/**
 * Created by OlleOlsson on 2017-10-23.
 */

public class WeatherModel {
    public PlaceModel place;
    public CurrentConditionModel currentConditionModel = new CurrentConditionModel();
    public TemperatureModel temperature = new TemperatureModel();
    public WindModel wind = new WindModel();

}
