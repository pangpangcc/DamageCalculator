package com.example.anthony.damagecalculator.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anthony.damagecalculator.Data.Team;
import com.example.anthony.damagecalculator.R;

public class TeamLoadDialogFragment extends DialogFragment {

    private RadioGroup choiceRadioGroup;
    private LoadTeam loadTeam;

    public interface LoadTeam {
        public void loadTeam();

        public void deleteTeam();
    }

    public static TeamLoadDialogFragment newInstance(LoadTeam loadTeam) {
        TeamLoadDialogFragment dialogFragment = new TeamLoadDialogFragment();
        dialogFragment.setLoadTeam(loadTeam);
        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View rootView = View.inflate(getActivity(), R.layout.fragment_team_load_dialog, null);
        choiceRadioGroup = (RadioGroup) rootView.findViewById(R.id.choiceRadioGroup);
        builder.setTitle("Team Options");
        builder.setView(rootView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        AlertDialog dialog = (AlertDialog) getDialog();
        if (dialog != null) {
            Button positiveButton = (Button) dialog.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choiceRadioGroup.getCheckedRadioButtonId() == R.id.loadTeam) {
                        loadTeam.loadTeam();
                        dismiss();
                        getActivity().getSupportFragmentManager().popBackStack();
                    } else if (choiceRadioGroup.getCheckedRadioButtonId() == R.id.deleteTeam) {
                        loadTeam.deleteTeam();
                        dismiss();
                    }
                }
            });
        }
    }

    public void setLoadTeam(LoadTeam loadTeam) {
        this.loadTeam = loadTeam;
    }

}