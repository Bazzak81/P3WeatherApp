package se.mah.ag7416.p3weather.Activities.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-24.
 */

public class CreateNewFragmentDialog extends DialogFragment {

    private EditText editCity;
    private Button search;
    private Button cancel;

    public CreateNewFragmentDialog() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newdialogfragment, container, false);
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
        search.setOnClickListener(new searchListener());
        cancel.setOnClickListener(new cancelListener());
    }

    private class searchListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "SEARCH CLICKED", Toast.LENGTH_SHORT).show();
        }
    }

    private class cancelListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "CANCEL CLICKED", Toast.LENGTH_SHORT).show();
            getDialog().cancel();
        }
    }
}
