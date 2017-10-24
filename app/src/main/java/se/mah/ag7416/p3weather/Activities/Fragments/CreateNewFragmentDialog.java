package se.mah.ag7416.p3weather.Activities.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;

import se.mah.ag7416.p3weather.R;

/**
 * Created by OlleOlsson on 2017-10-24.
 */

public class CreateNewFragmentDialog extends DialogFragment {

    private EditText editCity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        editCity = (EditText) getView().findViewById(R.id.editCity);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.newdialogfragment, null))
                .setPositiveButton(R.string.search_now, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // editCity.getText().toString(); bla bla bla vafan man nu vill

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CreateNewFragmentDialog.this.getDialog().cancel();

                    }
                });

        return builder.create();
    }
}
