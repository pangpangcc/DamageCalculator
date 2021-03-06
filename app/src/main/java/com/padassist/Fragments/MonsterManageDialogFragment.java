package com.padassist.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.padassist.Adapters.EvolutionSpinnerAdapter;
import com.padassist.Data.Monster;
import com.padassist.R;

import java.util.ArrayList;

public class MonsterManageDialogFragment extends DialogFragment {

    public interface RemoveMonster {
        public void removeMonsterDatabase();

        public void favoriteMonster(boolean favorite);

        public void replaceAllTeam();

        public void evolveMonster(long baseMonsterId);

    }

    private RadioGroup choiceRadioGroup;
    private CheckBox favorite;
    private RemoveMonster remove;
    private Spinner evolutionSpinner;
    private ArrayList<Long> evolutions = new ArrayList<>();
    private EvolutionSpinnerAdapter evolutionSpinnerAdapter;
    private Monster monster;

    public static MonsterManageDialogFragment newInstance(RemoveMonster removeMonster, Monster monster) {
        MonsterManageDialogFragment dialogFragment = new MonsterManageDialogFragment();
        dialogFragment.setRemove(removeMonster);
        Bundle args = new Bundle();
        args.putParcelable("monster", monster);
        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View rootView = View.inflate(getActivity(), R.layout.fragment_monster_manage_dialog, null);
        choiceRadioGroup = (RadioGroup) rootView.findViewById(R.id.choiceRadioGroup);
        favorite = (CheckBox) rootView.findViewById(R.id.favoriteCheck);
        evolutionSpinner = (Spinner) rootView.findViewById(R.id.evolutionSpinner);
        builder.setTitle("Monster Options");
        builder.setView(rootView)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (choiceRadioGroup.getCheckedRadioButtonId() == R.id.removeDatabase) {
                            remove.removeMonsterDatabase();
//                        } else if (choiceRadioGroup.getCheckedRadioButtonId() == R.id.replaceAllTeams) {
//                            remove.replaceAllTeam();
                        } else if (choiceRadioGroup.getCheckedRadioButtonId() == R.id.evolveMonster) {
                            remove.evolveMonster(evolutions.get(evolutionSpinner.getSelectedItemPosition()));
                        } else {
                            dialog.dismiss();
                        }
                        remove.favoriteMonster(favorite.isChecked());
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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            monster = getArguments().getParcelable("monster");
        }
        favorite.setChecked(monster.isFavorite());
        if (monster.isFavorite()) {
            choiceRadioGroup.getChildAt(choiceRadioGroup.getChildCount() - 1).setEnabled(false);
        } else {
            choiceRadioGroup.getChildAt(choiceRadioGroup.getChildCount() - 1).setEnabled(true);
        }
        favorite.setOnCheckedChangeListener(favoriteCheckListener);
        setupEvolutions();
        evolutionSpinnerAdapter = new EvolutionSpinnerAdapter(getActivity(), R.layout.evolution_spinner_row, R.id.monsterName, evolutions);
        evolutionSpinner.setAdapter(evolutionSpinnerAdapter);
        choiceRadioGroup.setOnCheckedChangeListener(radioGroupCheckChangeListener);

    }

    private CheckBox.OnCheckedChangeListener favoriteCheckListener = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                choiceRadioGroup.getChildAt(choiceRadioGroup.getChildCount() - 1).setEnabled(false);
            } else {
                choiceRadioGroup.getChildAt(choiceRadioGroup.getChildCount() - 1).setEnabled(true);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroupCheckChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.evolveMonster:
                    evolutionSpinner.setEnabled(true);
                    break;
                default:
                    evolutionSpinner.setEnabled(false);
                    break;
            }
        }
    };

    public void setRemove(RemoveMonster remove) {
        this.remove = remove;
    }


    private void setupEvolutions() {
        evolutions.clear();
        for(int i = 0; i < monster.getEvolutions().size(); i++){
            evolutions.add(monster.getEvolutions().get(i).getValue());
        }
        evolutions.add(0, Long.valueOf(0));
        if(evolutions.size() == 1){
            choiceRadioGroup.getChildAt(choiceRadioGroup.getChildCount() - 2).setEnabled(false);
        }else {
            choiceRadioGroup.getChildAt(choiceRadioGroup.getChildCount() - 2).setEnabled(true);
            evolutionSpinner.setEnabled(false);
        }
    }

    public void show(FragmentManager manager, String tag, Monster monster) {
        super.show(manager, tag);
        this.monster = monster;
    }
}
