package se.mah.ag7416.p3weather.Activities.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
<<<<<<< HEAD
<<<<<<< HEAD
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
=======
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
>>>>>>> master
=======
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
>>>>>>> master
import android.widget.EditText;
import android.widget.Toast;

import se.mah.ag7416.p3weather.Activities.Controllers.Controller;
import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-24.
 */

public class CreateNewFragmentDialog extends DialogFragment {

    private EditText editCity;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> master
    private Button search;
    private Button cancel;
    private Controller controller;

    public CreateNewFragmentDialog() {

    }

    @Override
    public View onCreateView(Bundle savedInstanceState) {
       LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.newdialogfragment, null);
//        View view = inflater.inflate(R.layout.newdialogfragment, container, false);
        initializeComponents(view);
        registerListeners();
        return view;

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
<<<<<<< HEAD
=======
    private Controller controller;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.newdialogfragment, null);
        builder.setView(view);
        editCity = (EditText) view.findViewById(R.id.editCity);

        builder.setPositiveButton(R.string.search_now, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controller.createNewFragment(editCity.getText().toString());
                        Log.d("CreateNewFragmentDialog", "onClick: "+editCity.getText().toString());
                        dismiss();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
>>>>>>> master
=======
>>>>>>> master

    private class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
          switch(v.getId()) {
            case R.id.search:
                controller.createNewFragment(editCity.getText().toString());
                 Log.d("CreateNewFragmentDialog", "onClick: "+editCity.getText().toString());
                 dismiss();
            break;
            case R.id.cancel:
              dismiss();
        }
    }

    public void setController(Controller controller){
        this.controller=controller;
    }
}
