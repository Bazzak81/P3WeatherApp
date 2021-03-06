package se.mah.ag7416.p3weather.Activities.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import se.mah.ag7416.p3weather.Activities.controllers.Controller;
import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-24.
 */

public class CreateNewFragmentDialog extends DialogFragment {

    private EditText editCity;
    private Button search;
    private Button cancel;
    private Controller controller;

    public CreateNewFragmentDialog() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.newdialogfragment, null);
        builder.setView(view);

        initializeComponents(view);
        registerListeners();
        return builder.create();

    }

    public void initializeComponents(View view) {
        editCity = (EditText) view.findViewById(R.id.editCity);
        search = (Button) view.findViewById(R.id.search);
        cancel = (Button) view.findViewById(R.id.cancel);
    }

    public void registerListeners() {
      Listener listener = new Listener();
        search.setOnClickListener(listener);
        cancel.setOnClickListener(listener);
    }

    private class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.search:
                    controller.createNewFragment(editCity.getText().toString(),0,0);
                    Log.d("CreateNewFragmentDialog", "onClick: " + editCity.getText().toString());
                    dismiss();
                    break;
                case R.id.cancel:
                    dismiss();

            }
        }
    }

    public void setController(Controller controller){
        this.controller=controller;
    }
}
