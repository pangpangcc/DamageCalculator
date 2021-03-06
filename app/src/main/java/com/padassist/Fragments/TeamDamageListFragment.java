package com.padassist.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.padassist.Adapters.MonsterDamageListRecycler;
import com.padassist.Data.Element;
import com.padassist.Data.Enemy;
import com.padassist.Data.OrbMatch;
import com.padassist.Data.Team;
import com.padassist.R;
import com.padassist.TextWatcher.MyTextWatcher;
import com.padassist.Util.DamageCalculationUtil;
import com.padassist.Util.Singleton;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeamDamageListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeamDamageListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamDamageListFragment extends Fragment {
    public static final String TAG = MonsterPageFragment.class.getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;
    private RecyclerView monsterListView;
    private EditText additionalComboValue, damageThresholdValue, damageImmunityValue, reductionValue;
    private MonsterDamageListRecycler monsterListAdapter;
    private Enemy enemy;
    private Team team;
    private Toast toast;
    private boolean hasEnemy;
    //private ArrayList<Monster> monsterList;
    private int additionalCombos, additionalCombosFragment, totalCombos = 0;
    private long totalDamage = 0, temp = 0;
    private TextView enemyHP, enemyHPValue, enemyHPPercent, enemyHPPercentValue, totalDamageValue, totalComboValue, hpRecoveredValue, targetReduction, targetAbsorb, damageThreshold, hasAwakenings, teamHpValue, damageImmunity, reductionPercent;
    private RadioGroup reductionRadioGroup;
    private Button monsterListToggle;
    private CheckBox redOrbReduction, blueOrbReduction, greenOrbReduction, lightOrbReduction, darkOrbReduction, redOrbAbsorb, blueOrbAbsorb, greenOrbAbsorb, lightOrbAbsorb, darkOrbAbsorb;
    private CheckBox absorbCheck, reductionCheck, damageThresholdCheck, damageImmunityCheck, hasAwakeningsCheck, activeUsedCheck;
    private RadioGroup absorbRadioGroup;
    private Button optionButton;
    private SeekBar teamHp;
    private DecimalFormat df = new DecimalFormat("#.##");
    private DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    private DecimalFormat dfSpace;
    private ExtraMultiplierDialogFragment extraMultiplierDialogFragment;
    private Realm realm = Realm.getDefaultInstance();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeamDamageListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamDamageListFragment newInstance(String param1, String param2) {
        TeamDamageListFragment fragment = new TeamDamageListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public static TeamDamageListFragment newInstance(boolean hasEnemy, int additionalCombos, Team team, Enemy enemy) {
        TeamDamageListFragment fragment = new TeamDamageListFragment();
        Bundle args = new Bundle();
        args.putBoolean("hasEnemy", hasEnemy);
        args.putInt("additionalCombos", additionalCombos);
        args.putParcelable("team", team);
        args.putParcelable("enemy", enemy);
        fragment.setArguments(args);
        return fragment;
    }

    public static TeamDamageListFragment newInstance(boolean hasEnemy, int additionalCombos, Team team) {
        TeamDamageListFragment fragment = new TeamDamageListFragment();
        Bundle args = new Bundle();
        args.putBoolean("hasEnemy", hasEnemy);
        args.putInt("additionalCombos", additionalCombos);
        args.putParcelable("team", team);
        fragment.setArguments(args);
        return fragment;
    }

    public TeamDamageListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.setGroupVisible(R.id.teamDamage, true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                clearTextFocus();
                totalCombos += additionalCombosFragment;
                if (totalCombos < realm.where(OrbMatch.class).findAll().size()) {
                    totalCombos = realm.where(OrbMatch.class).findAll().size();
                }
                monsterListAdapter.setCombos(totalCombos);
                team.setAtkMultiplierArrays(totalCombos);
                updateTextView();
                monsterListAdapter.notifyDataSetChanged();
                additionalComboValue.setText("0");
                break;
            case R.id.toggleCoop:
                updateTextView();
                monsterListAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_team_damage_list, container, false);
        monsterListView = (RecyclerView) rootView.findViewById(R.id.monsterListView);
        additionalComboValue = (EditText) rootView.findViewById(R.id.additionalComboValue);
        monsterListToggle = (Button) rootView.findViewById(R.id.monsterListToggle);
        enemyHP = (TextView) rootView.findViewById(R.id.enemyHP);
        enemyHPValue = (TextView) rootView.findViewById(R.id.enemyHPValue);
        enemyHPPercent = (TextView) rootView.findViewById(R.id.enemyHPPercent);
        enemyHPPercentValue = (TextView) rootView.findViewById(R.id.enemyHPPercentValue);
        totalDamageValue = (TextView) rootView.findViewById(R.id.totalDamageValue);
        totalComboValue = (TextView) rootView.findViewById(R.id.totalComboValue);
        hpRecoveredValue = (TextView) rootView.findViewById(R.id.hpRecoveredValue);
        targetReduction = (TextView) rootView.findViewById(R.id.targetReduction);
        targetAbsorb = (TextView) rootView.findViewById(R.id.elementAbsorb);
        hasAwakenings = (TextView) rootView.findViewById(R.id.hasAwakenings);
        optionButton = (Button) rootView.findViewById(R.id.options);
        reductionRadioGroup = (RadioGroup) rootView.findViewById(R.id.reductionOrbRadioGroup);
        absorbRadioGroup = (RadioGroup) rootView.findViewById(R.id.absorbOrbRadioGroup);
        redOrbReduction = (CheckBox) rootView.findViewById(R.id.redOrbReduction);
        blueOrbReduction = (CheckBox) rootView.findViewById(R.id.blueOrbReduction);
        greenOrbReduction = (CheckBox) rootView.findViewById(R.id.greenOrbReduction);
        darkOrbReduction = (CheckBox) rootView.findViewById(R.id.darkOrbReduction);
        lightOrbReduction = (CheckBox) rootView.findViewById(R.id.lightOrbReduction);
        redOrbAbsorb = (CheckBox) rootView.findViewById(R.id.redOrbAbsorb);
        blueOrbAbsorb = (CheckBox) rootView.findViewById(R.id.blueOrbAbsorb);
        greenOrbAbsorb = (CheckBox) rootView.findViewById(R.id.greenOrbAbsorb);
        lightOrbAbsorb = (CheckBox) rootView.findViewById(R.id.lightOrbAbsorb);
        darkOrbAbsorb = (CheckBox) rootView.findViewById(R.id.darkOrbAbsorb);
        reductionCheck = (CheckBox) rootView.findViewById(R.id.reductionCheck);
        damageThresholdValue = (EditText) rootView.findViewById(R.id.damageThresholdValue);
        damageThresholdCheck = (CheckBox) rootView.findViewById(R.id.damageThresholdCheck);
        damageThreshold = (TextView) rootView.findViewById(R.id.damageThreshold);
        absorbCheck = (CheckBox) rootView.findViewById(R.id.absorbCheck);
        hasAwakeningsCheck = (CheckBox) rootView.findViewById(R.id.hasAwakeningsCheck);
        activeUsedCheck = (CheckBox) rootView.findViewById(R.id.activeUsedCheck);
        teamHp = (SeekBar) rootView.findViewById(R.id.teamHpSeekBar);
        teamHpValue = (TextView) rootView.findViewById(R.id.teamHpValue);
        reductionValue = (EditText) rootView.findViewById(R.id.reductionValue);
        damageImmunityValue = (EditText) rootView.findViewById(R.id.damageImmunityValue);
        damageImmunityCheck = (CheckBox) rootView.findViewById(R.id.damageImmunityCheck);
        damageImmunity = (TextView) rootView.findViewById(R.id.damageImmunity);
        reductionPercent = (TextView) rootView.findViewById(R.id.reductionPercent);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            hasEnemy = getArguments().getBoolean("hasEnemy");
            additionalCombos = getArguments().getInt("additionalCombos");
            team = getArguments().getParcelable("team");
            enemy = getArguments().getParcelable("enemy");
        }
        if (hasEnemy) {
            temp = enemy.getCurrentHp();
            setReductionOrbs();
            setAbsorbOrbs();
            setDamageThreshold();
        }
        dfs.setGroupingSeparator(' ');
        dfSpace = new DecimalFormat("###,###", dfs);
        setCheckBoxes();
        totalCombos = additionalCombos + realm.where(OrbMatch.class).findAll().size();
        updateTextView();
        setupHpSeekBar();
        monsterListAdapter = new MonsterDamageListRecycler(getActivity(), hasEnemy, enemy, totalCombos, team, bindMonsterOnClickListener);
        monsterListView.setAdapter(monsterListAdapter);
        monsterListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        monsterListToggle.setOnClickListener(monsterListToggleOnClickListener);
        additionalComboValue.addTextChangedListener(additionalComboTextWatcher);
        additionalComboValue.setOnFocusChangeListener(editTextOnFocusChange);
//        monsterListView.setOnItemClickListener(bindMonsterOnClickListener);
        optionButton.setOnClickListener(optionsButtonOnClickListener);
        absorbCheck.setOnCheckedChangeListener(checkBoxOnChangeListener);
        reductionCheck.setOnCheckedChangeListener(checkBoxOnChangeListener);
        damageThresholdCheck.setOnCheckedChangeListener(checkBoxOnChangeListener);
        damageThresholdValue.addTextChangedListener(damageThresholdWatcher);
        damageThresholdValue.setOnFocusChangeListener(editTextOnFocusChange);
        damageImmunityCheck.setOnCheckedChangeListener(checkBoxOnChangeListener);
        damageImmunityValue.addTextChangedListener(damageImmunityWatcher);
        damageImmunityValue.setOnFocusChangeListener(editTextOnFocusChange);
        reductionValue.addTextChangedListener(reductionWatcher);

        redOrbReduction.setOnCheckedChangeListener(reductionCheckedChangedListener);
        blueOrbReduction.setOnCheckedChangeListener(reductionCheckedChangedListener);
        greenOrbReduction.setOnCheckedChangeListener(reductionCheckedChangedListener);
        darkOrbReduction.setOnCheckedChangeListener(reductionCheckedChangedListener);
        lightOrbReduction.setOnCheckedChangeListener(reductionCheckedChangedListener);

        redOrbAbsorb.setOnCheckedChangeListener(absorbCheckedChangedListener);
        blueOrbAbsorb.setOnCheckedChangeListener(absorbCheckedChangedListener);
        greenOrbAbsorb.setOnCheckedChangeListener(absorbCheckedChangedListener);
        darkOrbAbsorb.setOnCheckedChangeListener(absorbCheckedChangedListener);
        lightOrbAbsorb.setOnCheckedChangeListener(absorbCheckedChangedListener);

        hasAwakeningsCheck.setOnCheckedChangeListener(checkBoxOnChangeListener);
        activeUsedCheck.setOnCheckedChangeListener(checkBoxOnChangeListener);
        teamHp.setOnSeekBarChangeListener(teamHpSeekBarListener);
        if(hasEnemy){
            getActivity().setTitle("Team Damage (with target)");
        } else {
            getActivity().setTitle("Team Damage (no target)");
        }
    }

    // TODO: Rename method, updateAwakenings argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private View.OnClickListener monsterListToggleOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (monsterListView.getVisibility() == View.GONE) {
                monsterListView.setVisibility(View.VISIBLE);
                monsterListToggle.setText("Hide Damage Breakdown");
            } else if (monsterListView.getVisibility() == View.VISIBLE) {
                monsterListView.setVisibility(View.GONE);
                monsterListToggle.setText("Show Damage Breakdown");
            }
        }
    };

    public void updateTextView() {
        totalDamage = 0;
        if (!hasEnemy) {
            enemyHP.setVisibility(View.GONE);
            enemyHPValue.setVisibility(View.GONE);
            enemyHPPercent.setVisibility(View.GONE);
            enemyHPPercentValue.setVisibility(View.GONE);
            reductionRadioGroup.setVisibility(View.GONE);
            targetReduction.setVisibility(View.GONE);
            targetAbsorb.setVisibility(View.GONE);
            absorbRadioGroup.setVisibility(View.GONE);
            damageThresholdCheck.setVisibility(View.GONE);
            damageThresholdValue.setVisibility(View.GONE);
            damageThreshold.setVisibility(View.GONE);
            reductionCheck.setVisibility(View.GONE);
            absorbCheck.setVisibility(View.GONE);
            reductionValue.setVisibility(View.GONE);
            damageImmunityValue.setVisibility(View.GONE);
            damageImmunity.setVisibility(View.GONE);
            damageImmunityCheck.setVisibility(View.GONE);
            reductionPercent.setVisibility(View.GONE);
            RelativeLayout.LayoutParams z = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            z.addRule(RelativeLayout.BELOW, totalComboValue.getId());
            z.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            hasAwakeningsCheck.setLayoutParams(z);
            for (int i = 0; i < team.sizeMonsters(); i++) {
                if (team.getIsBound().get(i)) {
                } else {
                    totalDamage += (long)DamageCalculationUtil.monsterElement1Damage(team, team.getMonsters(i), i, totalCombos);
                    totalDamage += (long)DamageCalculationUtil.monsterElement2Damage(team, team.getMonsters(i), i, totalCombos);
                }
            }
        } else {
            enemy.setCurrentHp(temp);
            if (enemy.getHasDamageThreshold()) {
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        if (enemy.getCurrentHp() - ((long)DamageCalculationUtil.monsterElement1DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy) + totalDamage) >= enemy.getTargetHp()) {
                            totalDamage = enemy.getCurrentHp() - enemy.getTargetHp();
                        } else {
                            if ((long)DamageCalculationUtil.monsterElement1DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy) < 0 && totalDamage >= enemy.getCurrentHp()) {
                                totalDamage = enemy.getCurrentHp() + (long)DamageCalculationUtil.monsterElement1DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy);
                            } else {
                                totalDamage += (long)DamageCalculationUtil.monsterElement1DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy);
                            }
                        }
                    }
                }
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        if (enemy.getCurrentHp() - ((long)DamageCalculationUtil.monsterElement2DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy) + totalDamage) >= enemy.getTargetHp()) {
                            totalDamage = enemy.getCurrentHp() - enemy.getTargetHp();
                        } else {
                            if ((long)DamageCalculationUtil.monsterElement2DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy) < 0 && totalDamage >= enemy.getCurrentHp()) {
                                totalDamage = enemy.getCurrentHp() + (long)DamageCalculationUtil.monsterElement2DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy);
                            } else {
                                totalDamage += (long)DamageCalculationUtil.monsterElement2DamageThreshold(team, team.getMonsters(i), i, totalCombos, enemy);
                            }
                        }
                    }
                }
            } else if (enemy.hasDamageImmunity()){
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        if (enemy.getCurrentHp() - ((long)DamageCalculationUtil.monsterElement1DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy) + totalDamage) >= enemy.getTargetHp()) {
                            totalDamage = enemy.getCurrentHp() - enemy.getTargetHp();
                        } else {
                            if ((long)DamageCalculationUtil.monsterElement1DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy) < 0 && totalDamage >= enemy.getCurrentHp()) {
                                totalDamage = enemy.getCurrentHp() + (long)DamageCalculationUtil.monsterElement1DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy);
                            } else {
                                totalDamage += (long)DamageCalculationUtil.monsterElement1DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy);
                            }
                        }
                    }
                }
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        if (enemy.getCurrentHp() - ((long)DamageCalculationUtil.monsterElement2DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy) + totalDamage) >= enemy.getTargetHp()) {
                            totalDamage = enemy.getCurrentHp() - enemy.getTargetHp();
                        } else {
                            if ((long)DamageCalculationUtil.monsterElement2DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy) < 0 && totalDamage >= enemy.getCurrentHp()) {
                                totalDamage = enemy.getCurrentHp() + (long)DamageCalculationUtil.monsterElement2DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy);
                            } else {
                                totalDamage += (long)DamageCalculationUtil.monsterElement2DamageImmunity(team, team.getMonsters(i), i, totalCombos, enemy);
                            }
                        }
                    }
                }
            }
            else if (enemy.getHasAbsorb()) {
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        if (enemy.getCurrentHp() - ((long)DamageCalculationUtil.monsterElement1DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy) + totalDamage) >= enemy.getTargetHp()) {
                            totalDamage = enemy.getCurrentHp() - enemy.getTargetHp();
                        } else {
                            if ((long)DamageCalculationUtil.monsterElement1DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy) < 0 && totalDamage >= enemy.getCurrentHp()) {
                                totalDamage = enemy.getCurrentHp() + (long)DamageCalculationUtil.monsterElement1DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy);
                            } else {
                                totalDamage += (long)DamageCalculationUtil.monsterElement1DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy);
                            }
                        }
                    }
                }
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        if (enemy.getCurrentHp() - ((long)DamageCalculationUtil.monsterElement2DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy) + totalDamage) >= enemy.getTargetHp()) {
                            totalDamage = enemy.getCurrentHp() - enemy.getTargetHp();
                        } else {
                            if ((long)DamageCalculationUtil.monsterElement2DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy) < 0 && totalDamage >= enemy.getCurrentHp()) {
                                totalDamage = enemy.getCurrentHp() + (long)DamageCalculationUtil.monsterElement2DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy);
                            } else {
                                totalDamage += (long)DamageCalculationUtil.monsterElement2DamageAbsorb(team, team.getMonsters(i), i, totalCombos, enemy);
                            }
                        }

                    }
                }
            } else if (enemy.getHasReduction()) {
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        totalDamage += (long)DamageCalculationUtil.monsterElement1DamageReduction(team, team.getMonsters(i), i, totalCombos, enemy);
                        totalDamage += (long)DamageCalculationUtil.monsterElement2DamageReduction(team, team.getMonsters(i), i, totalCombos, enemy);
                    }
                }
            } else {
                for (int i = 0; i < team.sizeMonsters(); i++) {
                    if (team.getIsBound().get(i)) {
                    } else {
                        totalDamage += (long)DamageCalculationUtil.monsterElement1DamageEnemy(team, team.getMonsters(i), i, totalCombos, enemy);
                        totalDamage += (long)DamageCalculationUtil.monsterElement2DamageEnemy(team, team.getMonsters(i), i, totalCombos, enemy);
                    }
                }
            }
            //Need to set colors of each enemy element stuff
            setTextColors();
            enemy.setCurrentHp(enemy.getCurrentHp() - totalDamage);
            if (enemy.getCurrentHp() != temp) {
                enemy.setBeforeGravityHP(enemy.getCurrentHp());
                enemy.setIsDamaged(true);
            }
            if (totalDamage == 0 && enemy.getCurrentHp() == enemy.getTargetHp()) {
                enemy.setBeforeGravityHP(enemy.getCurrentHp());
            }
            enemyHPValue.setText(" " + dfSpace.format(enemy.getCurrentHp()) + " ");
            enemyHPPercentValue.setText(String.valueOf(df.format((double) enemy.getCurrentHp() / enemy.getTargetHp() * 100) + "%"));
        }
        team.setTotalDamage(totalDamage);
        totalDamageValue.setText(" " + dfSpace.format(totalDamage) + " ");
        hpRecoveredValue.setText(" " + dfSpace.format((int) DamageCalculationUtil.hpRecovered(team, totalCombos)) + " ");
        totalComboValue.setText(String.valueOf(totalCombos));
        if (totalDamage < 0) {
            totalDamageValue.setTextColor(Color.parseColor("#FFBBBB"));
        } else {
            totalDamageValue.setTextColor(Color.parseColor("#BBBBBB"));
        }
        if(DamageCalculationUtil.hpRecovered(team, totalCombos) < 0){
            hpRecoveredValue.setTextColor(Color.parseColor("#c737fd"));
        } else {
            hpRecoveredValue.setTextColor(Color.parseColor("#FF9999"));
        }
    }

    private View.OnClickListener bindMonsterOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag(R.string.index);
            clearTextFocus();
            if (team.getIsBound().get(position)) {
                team.getIsBound().set(position, false);
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), "Monster unbound", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                int counter = 0;
                if (Singleton.getInstance().hasAwakenings()) {
                    for (int i = 0; i < team.getMonsters(position).getCurrentAwakenings(); i++) {
                        if (team.getMonsters(position).getAwokenSkills().get(i).getValue() == 10) {
                            counter++;
                        }
                    }
                }
                if (counter == 2) {
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast = Toast.makeText(getActivity(), "Monster cannot be bound", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    team.getIsBound().set(position, true);
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast = Toast.makeText(getActivity(), "Monster bound", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            team.updateAwakenings();
            team.updateOrbs();
            team.setAtkMultiplierArrays(totalCombos);
            Log.d("TeamDamageList", "bound list: " + team.getIsBound());
            updateTextView();
            monsterListAdapter.notifyDataSetChanged();
        }
    };

    private void setTextColors() {
        if (enemy.getTargetElement().equals(Element.RED)) {
            enemyHPValue.setTextColor(Color.parseColor("#FF0000"));
        } else if (enemy.getTargetElement().equals(Element.BLUE)) {
            enemyHPValue.setTextColor(Color.parseColor("#4444FF"));
        } else if (enemy.getTargetElement().equals(Element.GREEN)) {
            enemyHPValue.setTextColor(Color.parseColor("#00CC00"));
        } else if (enemy.getTargetElement().equals(Element.LIGHT)) {
            enemyHPValue.setTextColor(Color.parseColor("#F0F000"));
        } else if (enemy.getTargetElement().equals(Element.DARK)) {
            enemyHPValue.setTextColor(Color.parseColor("#AA00FF"));
        }
    }

    private MyTextWatcher.ChangeStats changeStats = new MyTextWatcher.ChangeStats() {
        @Override
        public void changeMonsterAttribute(int statToChange, int statValue) {
            if (statToChange == MyTextWatcher.ADDITIONAL_COMBOS) {
                additionalCombosFragment = statValue;
            } else if (statToChange == MyTextWatcher.DAMAGE_THRESHOLD) {
                enemy.setDamageThreshold(statValue);
            } else if (statToChange == MyTextWatcher.DAMAGE_IMMUNITY) {
                enemy.setDamageImmunity(statValue);
            } else if (statToChange == MyTextWatcher.REDUCTION_VALUE) {
                enemy.setReductionValue(statValue);
                if(statValue > 100){
                    enemy.setReductionValue(100);
                    reductionValue.setText("100");
                }
            }
        }
    };

    private MyTextWatcher additionalComboTextWatcher = new MyTextWatcher(MyTextWatcher.ADDITIONAL_COMBOS, changeStats);
    private MyTextWatcher damageThresholdWatcher = new MyTextWatcher(MyTextWatcher.DAMAGE_THRESHOLD, changeStats);
    private MyTextWatcher damageImmunityWatcher = new MyTextWatcher(MyTextWatcher.DAMAGE_IMMUNITY, changeStats);
    private MyTextWatcher reductionWatcher = new MyTextWatcher(MyTextWatcher.REDUCTION_VALUE, changeStats);

    private View.OnFocusChangeListener editTextOnFocusChange = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                hideKeyboard(v);
                if ((additionalComboValue.getText().toString().equals(""))) {
                    additionalComboValue.setText("0");
                } else if (damageThresholdValue.getText().toString().equals("")) {
                    damageThresholdValue.setText("0");
                    enemy.setDamageThreshold(0);
                }
            }
        }
    };

    private Button.OnClickListener optionsButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearTextFocus();
            if (extraMultiplierDialogFragment == null) {
                extraMultiplierDialogFragment = extraMultiplierDialogFragment.newInstance(saveTeam, team);
            }
            if(!extraMultiplierDialogFragment.isAdded()){
                extraMultiplierDialogFragment.show(getChildFragmentManager(), team, "Show extra multiplier Dialog");
            }
        }
    };

    ExtraMultiplierDialogFragment.SaveTeam saveTeam = new ExtraMultiplierDialogFragment.SaveTeam() {
        @Override
        public void update() {
            updateTextView();
            monsterListAdapter.notifyDataSetChanged();
        }
    };

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    private void setReductionOrbs() {
        reductionValue.setText(String.valueOf(enemy.getReductionValue()));
        if (enemy.getHasReduction()) {
            reductionCheck.setChecked(true);
            reductionValue.setEnabled(true);
            for (int i = 0; i < reductionRadioGroup.getChildCount(); i++) {
                reductionRadioGroup.getChildAt(i).setEnabled(true);
            }
            if (enemy.containsReduction(Element.RED)) {
                redOrbReduction.setChecked(true);
            }
            if (enemy.containsReduction(Element.BLUE)) {
                blueOrbReduction.setChecked(true);
            }
            if (enemy.containsReduction(Element.GREEN)) {
                greenOrbReduction.setChecked(true);
            }
            if (enemy.containsReduction(Element.DARK)) {
                darkOrbReduction.setChecked(true);
            }
            if (enemy.containsReduction(Element.LIGHT)) {
                lightOrbReduction.setChecked(true);
            }
        } else {
            reductionValue.setEnabled(false);
            reductionCheck.setChecked(false);
        }

    }

    private void setAbsorbOrbs() {
        if (enemy.getHasAbsorb()) {
            absorbCheck.setChecked(true);
            for (int i = 0; i < absorbRadioGroup.getChildCount(); i++) {
                absorbRadioGroup.getChildAt(i).setEnabled(true);
            }
            if (enemy.getAbsorb().contains(Element.RED)) {
                redOrbAbsorb.setChecked(true);
            }
            if (enemy.getAbsorb().contains(Element.BLUE)) {
                blueOrbAbsorb.setChecked(true);
            }
            if (enemy.getAbsorb().contains(Element.GREEN)) {
                greenOrbAbsorb.setChecked(true);
            }
            if (enemy.getAbsorb().contains(Element.DARK)) {
                darkOrbAbsorb.setChecked(true);
            }
            if (enemy.getAbsorb().contains(Element.LIGHT)) {
                lightOrbAbsorb.setChecked(true);
            }

        }else {
            absorbCheck.setChecked(false);
            redOrbAbsorb.setChecked(false);
            blueOrbAbsorb.setChecked(false);
            greenOrbAbsorb.setChecked(false);
            darkOrbAbsorb.setChecked(false);
            lightOrbAbsorb.setChecked(false);
            for (int i = 0; i < absorbRadioGroup.getChildCount(); i++) {
                absorbRadioGroup.getChildAt(i).setEnabled(false);
            }
        }
    }

    private void setDamageThreshold() {
        damageThresholdValue.setText(String.valueOf(enemy.getDamageThreshold()));
        damageImmunityValue.setText(String.valueOf(enemy.getDamageImmunity()));
        if (enemy.getHasDamageThreshold()) {
            damageThresholdValue.setEnabled(true);
            damageThresholdCheck.setChecked(true);
        }
        if (enemy.hasDamageImmunity()) {
            damageImmunityCheck.setChecked(true);
            damageImmunityValue.setEnabled(true);
        }
    }

    private CompoundButton.OnCheckedChangeListener checkBoxOnChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            clearTextFocus();
            if (buttonView.equals(damageThresholdCheck)) {
                enemy.setHasDamageThreshold(isChecked);
                if (isChecked) {
                    damageThresholdValue.setEnabled(true);
                    damageImmunityValue.clearFocus();
                    damageImmunityValue.setEnabled(false);
                    damageImmunityCheck.setChecked(false);
                } else {
                    damageThresholdValue.clearFocus();
                    damageThresholdValue.setEnabled(false);
                }
            } else if (buttonView.equals(damageImmunityCheck)){
                enemy.setHasDamageImmunity(isChecked);
                if (isChecked) {
                    damageImmunityValue.setEnabled(true);
                    damageThresholdValue.clearFocus();
                    damageThresholdValue.setEnabled(false);
                    damageThresholdCheck.setChecked(false);
                } else {
                    damageImmunityValue.clearFocus();
                    damageImmunityValue.setEnabled(false);
                }

            } else if (buttonView.equals(reductionCheck)) {
                enemy.setHasReduction(isChecked);
                if (isChecked) {
                    for (int i = 0; i < reductionRadioGroup.getChildCount(); i++) {
                        reductionRadioGroup.getChildAt(i).setEnabled(true);
                    }
                    reductionValue.setEnabled(true);
                } else {
                    redOrbReduction.setChecked(false);
                    blueOrbReduction.setChecked(false);
                    greenOrbReduction.setChecked(false);
                    lightOrbReduction.setChecked(false);
                    darkOrbReduction.setChecked(false);
                    for (int i = 0; i < reductionRadioGroup.getChildCount(); i++) {
                        reductionRadioGroup.getChildAt(i).setEnabled(false);
                    }
                    setElementReduction(isChecked, buttonView.getId());
                    reductionValue.setEnabled(false);
                }
            } else if (buttonView.equals(absorbCheck)) {
                enemy.setHasAbsorb(isChecked);
                if (isChecked) {
                    for (int i = 0; i < absorbRadioGroup.getChildCount(); i++) {
                        absorbRadioGroup.getChildAt(i).setEnabled(true);
                    }
                } else {
                    redOrbAbsorb.setChecked(false);
                    blueOrbAbsorb.setChecked(false);
                    greenOrbAbsorb.setChecked(false);
                    lightOrbAbsorb.setChecked(false);
                    darkOrbAbsorb.setChecked(false);
                    for (int i = 0; i < absorbRadioGroup.getChildCount(); i++) {
                        absorbRadioGroup.getChildAt(i).setEnabled(false);
                    }
                }
            } else if (buttonView.equals(hasAwakeningsCheck)) {
                Singleton.getInstance().setHasAwakenings(isChecked);
                team.updateAwakenings();
            } else if (buttonView.equals(activeUsedCheck)) {
                Singleton.getInstance().setActiveSkillUsed(isChecked);
                team.updateAwakenings();
            }
//            updateTextView();
//            monsterListAdapter.notifyDataSetChanged();
        }
    };

    private CompoundButton.OnCheckedChangeListener reductionCheckedChangedListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            setElementReduction(isChecked, buttonView.getId());
        }
    };

    private void setElementReduction(boolean isChecked, int buttonId) {
        clearTextFocus();
        Element element = null;
        switch (buttonId) {
            case R.id.redOrbReduction:
                element = Element.RED;
                break;
            case R.id.blueOrbReduction:
                element = Element.BLUE;
                break;
            case R.id.greenOrbReduction:
                element = Element.GREEN;
                break;
            case R.id.darkOrbReduction:
                element = Element.DARK;
                break;
            case R.id.lightOrbReduction:
                element = Element.LIGHT;
                break;
        }

        if (isChecked) {
            if (!enemy.containsReduction(element)) {
                enemy.addReduction(element);
            }
        } else {
            if (enemy.containsReduction(element)) {
                enemy.removeReduction(element);
            }
        }
//        updateTextView();
//        monsterListAdapter.notifyDataSetChanged();
    }

    private CompoundButton.OnCheckedChangeListener absorbCheckedChangedListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            setElementAbsorb(isChecked, buttonView.getId());
        }
    };

    private void setElementAbsorb(boolean isChecked, int buttonId) {
        clearTextFocus();
        Element element = null;
        switch (buttonId) {
            case R.id.redOrbAbsorb:
                element = Element.RED;
                break;
            case R.id.blueOrbAbsorb:
                element = Element.BLUE;
                break;
            case R.id.greenOrbAbsorb:
                element = Element.GREEN;
                break;
            case R.id.lightOrbAbsorb:
                element = Element.LIGHT;
                break;
            case R.id.darkOrbAbsorb:
                element = Element.DARK;
                break;
        }

        if (isChecked) {
            if (!enemy.getAbsorb().contains(element)) {
                enemy.getAbsorb().add(element);
            }
        } else {
            if (enemy.getAbsorb().contains(element)) {
                enemy.getAbsorb().remove(element);
            }
        }
    }

    private void setCheckBoxes() {
        hasAwakeningsCheck.setChecked(Singleton.getInstance().hasAwakenings());
        activeUsedCheck.setChecked(Singleton.getInstance().isActiveSkillUsed());
    }

    private void setupHpSeekBar() {
        int position = 0;
        if(team.getLeadSkill().getHpPercent().isEmpty()){
            if (team.getHelperSkill().getHpPercent().isEmpty()){
                team.setTeamHp(100);
            }else {
                for(int i = 0; i < team.getHelperSkill().getAtkData().size(); i++){
                    if (i == 0){
                        position = i;
                    }else {
                        if (team.getHelperSkill().getAtkData().get(i).getValue() > team.getHelperSkill().getAtkData().get(i-1).getValue()){
                            position = i;
                        }
                    }
                }
                team.setTeamHp(team.getHelperSkill().getHpPercent().get(0 + 2*position).getValue());
            }
        } else {
            for(int i = 0; i < team.getLeadSkill().getAtkData().size(); i++){
                if (i == 0){
                    position = i;
                }else {
                    if (team.getLeadSkill().getAtkData().get(i).getValue() > team.getLeadSkill().getAtkData().get(i-1).getValue()){
                        position = i;
                    }
                }
            }
            team.setTeamHp(team.getLeadSkill().getHpPercent().get(0 + 2*position).getValue());
        }
//        team.save();
        teamHp.setProgress(team.getTeamHp());
        updateTextView();
        teamHpValue.setText("" + teamHp.getProgress());
    }

    private SeekBar.OnSeekBarChangeListener teamHpSeekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                team.setTeamHp(progress);
            }
            teamHpValue.setText("" + progress);
//            team.save();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            updateTextView();
            monsterListAdapter.notifyDataSetChanged();
        }
    };

    private void clearTextFocus() {
        additionalComboValue.clearFocus();
        damageThresholdValue.clearFocus();
    }

}
