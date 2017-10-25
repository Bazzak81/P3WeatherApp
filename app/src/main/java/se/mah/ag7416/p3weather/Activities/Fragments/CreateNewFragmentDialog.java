package se.mah.ag7416.p3weather.Activities.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import se.mah.ag7416.p3weather.Activities.Controllers.Controller;
import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-24.
 */

public class CreateNewFragmentDialog extends DialogFragment {

    private EditText editCity;
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

        return builder.create();
    }

    public void setController(Controller controller){
        this.controller=controller;
    }
}
