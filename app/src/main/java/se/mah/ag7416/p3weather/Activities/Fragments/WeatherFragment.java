package se.mah.ag7416.p3weather.Activities.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import se.mah.ag7416.p3weather.Activities.Controllers.FragmentController;
import se.mah.ag7416.p3weather.Activities.Models.WeatherModel;
import se.mah.ag7416.p3weather.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private WeatherModel weatherModel;
    public static final String CELCIUS = "Celcius";
    private String weatherCondition;
    private ImageView weatherImage;
    private ImageView plusFragment;
    private ImageView minusFragment;
    private TextView tvTemperature;
    private TextView tvCity;
    private TextView tvSetTempUnit;
    private TextView tvSetWindspeed;
    private TextView tvTempFormat;
    private int icon;
    private View view;
    private se.mah.ag7416.p3weather.Activities.Fragments.FragmentController fragmentController;

    public WeatherFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weather, container, false);
        weatherModel = new WeatherModel();
        initializeComponents(view);
//        setImageResource(view);
//        setTextViews();
        return view;
    }

    public void setController(se.mah.ag7416.p3weather.Activities.Fragments.FragmentController fragmentController){
        this.fragmentController=fragmentController;
    }

    public void initializeComponents(View view) {

        plusFragment = (ImageView) view.findViewById(R.id.plusFragment);
        minusFragment = (ImageView) view.findViewById(R.id.minusFragment);
        weatherImage = (ImageView) view.findViewById(R.id.weatherImage);
        tvTemperature = (TextView) view.findViewById(R.id.tvTemperature);
        tvCity = (TextView) view.findViewById(R.id.tvCity);
        tvSetTempUnit = (TextView) view.findViewById(R.id.tvSetTempUnit);
        tvSetWindspeed = (TextView) view.findViewById(R.id.tvSetWindspeed);
        tvTempFormat=(TextView)view.findViewById(R.id.tvTempFormat);

    }

    public void setText(String city, String temp, String wind, int icon ){
        tvCity.setText(city);
        tvTemperature.setText(temp);
        tvSetTempUnit.setText(CELCIUS);
        tvSetWindspeed.setText(wind);
        weatherImage.setImageResource(icon);
    }

    public void setTextViews() {
        tvCity.setText(weatherModel.place.getCity());
        tvTemperature.setText(String.valueOf(weatherModel.temperature.getTemp()));
        tvSetTempUnit.setText(CELCIUS);
        tvSetWindspeed.setText(String.valueOf(weatherModel.wind.getWindSpeed()));
    }

    public void setImageResource(View view) {
        weatherCondition = weatherModel.currentConditionModel.getCondition();

        switch (weatherCondition) {
            case "cloudy":
                weatherImage.setImageResource(R.drawable.cloudy);
                //view.setBackgroundColor();
                break;
            case "rainy":
                weatherImage.setImageResource(R.drawable.rainy);
                //view.setBackgroundColor();
                break;
            case "snowy":
                weatherImage.setImageResource(R.drawable.snowy);
                //view.setBackgroundColor();
                break;
            case "sunny":
                weatherImage.setImageResource(R.drawable.sunny);
                //view.setBackgroundColor();
                break;
            case "sunnycloudy":
                weatherImage.setImageResource(R.drawable.sunnycloudy);
                //view.setBackgroundColor();
                break;
            case "sunnyrainy":
                weatherImage.setImageResource(R.drawable.sunnyrainy);
                //view.setBackgroundColor();
                break;
            default:
        }
    }

    public void registerListeners() {
        plusFragment.setOnClickListener(new addFragmentListener());
        minusFragment.setOnClickListener(new removeFragmentListener());
    }

    private class addFragmentListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "Add-fragment button clicked", Toast.LENGTH_SHORT).show();
        }
    }

    private class removeFragmentListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "Remove-fragment button clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
