package se.mah.ag7416.p3weather.Activities.Models;

/**
 * Created by OlleOlsson on 2017-10-23.
 */

public class CurrentConditionModel {
    private int weatherId;
    private String condition;
    private String description;
    private double temperature;

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
