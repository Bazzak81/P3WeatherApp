package se.mah.ag7416.p3weather.Activities.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import se.mah.ag7416.p3weather.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private ImageView weatherImage;
    private ImageButton plusFragment;
    private ImageButton minusFragment;
    private TextView tvTemperature;
    private TextView tvCity;
    private TextView tvSetTempUnit;
    private TextView tvSetWindspeed;
    private TextView tvTempFormat;
    private int icon;
    private View view;

    private FragmentController fragmentController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weather, container, false);
        initializeComponents(view);
        registerListeners();
        return view;
    }


    public void setController(FragmentController fragmentController) {
        this.fragmentController = fragmentController;
    }

    public void initializeComponents(View view) {
        plusFragment = (ImageButton) view.findViewById(R.id.plusFragment);
        minusFragment = (ImageButton) view.findViewById(R.id.minusFragment);
        weatherImage = (ImageView) view.findViewById(R.id.weatherImage);
        tvTemperature = (TextView) view.findViewById(R.id.tvTemperature);
        tvCity = (TextView) view.findViewById(R.id.tvCity);
        tvSetTempUnit = (TextView) view.findViewById(R.id.tvSetTempUnit);
        tvSetWindspeed = (TextView) view.findViewById(R.id.tvSetWindspeed);
        tvTempFormat = (TextView) view.findViewById(R.id.tvTempFormat);
    }

    public void registerListeners() {
        FragmentListener listener = new FragmentListener();
        plusFragment.setOnClickListener(listener);
        minusFragment.setOnClickListener(listener);
    }

    public void setText(String city, String temp, String wind, int icon, String description) {
        tvCity.setText(city);
        tvTemperature.setText(temp);
        tvSetWindspeed.setText(wind + " m/s");
        weatherImage.setImageResource(icon);
        tvSetTempUnit.setText(description);
    }

    public void hideMinusButton(){
        minusFragment.setVisibility(View.INVISIBLE);
    }

    private class FragmentListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.plusFragment:
                    Toast.makeText(getActivity(), "Add-fragment button clicked", Toast
                            .LENGTH_SHORT).show();
                    fragmentController.newFragmentDialog();
                    break;
                case R.id.minusFragment:
                    fragmentController.getActivity().getController().removeFragment
                            (fragmentController.getFragment());
                    break;
            }
        }
    }
}
