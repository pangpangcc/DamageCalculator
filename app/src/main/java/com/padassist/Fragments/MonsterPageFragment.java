package com.padassist.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.padassist.Data.BaseMonster;
import com.padassist.Data.Monster;
import com.padassist.Data.Team;
import com.padassist.MainActivity;
import com.padassist.R;
import com.padassist.TextWatcher.MyTextWatcher;
import com.padassist.Util.DamageCalculationUtil;
import com.padassist.Util.MonsterPageUtil;
import com.padassist.Util.Singleton;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MonsterPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MonsterPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonsterPageFragment extends MonsterPageUtil {
    public static final String TAG = MonsterPageFragment.class.getSimpleName();

    private Toast toast;
    private MonsterRemoveDialogFragment monsterRemoveDialogFragment;
    private ReplaceAllConfirmationDialogFragment replaceConfirmationDialog;
    private DeleteMonsterConfirmationDialogFragment deleteConfirmationDialog;

    public static MonsterPageFragment newInstance(long monsterId, int position) {
        MonsterPageFragment fragment = new MonsterPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        args.putLong("monsterId", monsterId);
//        args.putParcelable("monster", monster);
        args.putInt("position", position);
        return fragment;
    }

    public MonsterPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
//            monster = getArguments().getParcelable("monster");
            monsterId = getArguments().getLong("monsterId");
            position = getArguments().getInt("position");
        }
        Log.d("MonsterPage", "monster is: " + monster);
        monsterRemove.setOnClickListener(maxButtons);
        switch (position) {
            case 0:
                getActivity().setTitle("Modify Leader");
                break;
            case 1:
                getActivity().setTitle("Modify Sub 1");
                break;
            case 2:
                getActivity().setTitle("Modify Sub 2");
                break;
            case 3:
                getActivity().setTitle("Modify Sub 3");
                break;
            case 4:
                getActivity().setTitle("Modify Sub 4");
                break;
            case 5:
                getActivity().setTitle("Modify Helper");
        }

        for(int i = 0; i < monster.getEvolutions().size(); i++){
            Log.d("MonsterPage", "Evolutions are: " + monster.getEvolutions().get(i).getValue());
        }

    }

    public Monster getMonster() {
        if (getArguments() != null) {
//            Monster monster = getArguments().getParcelable("monster");
//            monster = realm.copyFromRealm(monster);

            monsterId = getArguments().getLong("monsterId");
            Monster monster = realm.where(Monster.class).equalTo("monsterId", monsterId).findFirst();
            monster = realm.copyFromRealm(monster);

//            return realm.where(Monster.class).equalTo("monsterId", getArguments().getLong("monsterId")).findFirst();
            return monster;
        } else return null;
    }

    private View.OnClickListener maxButtons = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (monsterRemoveDialogFragment == null) {
                monsterRemoveDialogFragment = MonsterRemoveDialogFragment.newInstance(removeMonster, monster);
            }
            if(!monsterRemoveDialogFragment.isAdded()){
                monsterRemoveDialogFragment.show(getChildFragmentManager(), "Show Remove Monster", monster);
            }

        }
    };

    private MonsterRemoveDialogFragment.RemoveMonster removeMonster = new MonsterRemoveDialogFragment.RemoveMonster() {
        @Override
        public void removeMonsterDatabase() {
            if (deleteConfirmationDialog == null) {
                deleteConfirmationDialog = DeleteMonsterConfirmationDialogFragment.newInstance(deleteMonster, 0);
            }
            if(!deleteConfirmationDialog.isAdded()){
                deleteConfirmationDialog.show(getChildFragmentManager(), "Monster Replace All");
            }
            monsterRemoveDialogFragment.dismiss();
        }

        @Override
        public void removeMonsterTeam() {
            if (position == 0) {
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), "Leader cannot be empty", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Team newTeam = realm.where(Team.class).equalTo("teamId", 0).findFirst();
                newTeam = realm.copyFromRealm(newTeam);
                Monster monsterZero = realm.where(Monster.class).equalTo("monsterId", 0).findFirst();
                switch (Singleton.getInstance().getMonsterOverwrite()) {
                    case 0:
                        newTeam.setLead(monsterZero);
                        break;
                    case 1:
                        newTeam.setSub1(monsterZero);
                        break;
                    case 2:
                        newTeam.setSub2(monsterZero);
                        break;
                    case 3:
                        newTeam.setSub3(monsterZero);
                        break;
                    case 4:
                        newTeam.setSub4(monsterZero);
                        break;
                    case 5:
                        newTeam.setHelper(monsterZero);
                        break;
                }

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(newTeam);
                realm.commitTransaction();
                monsterRemoveDialogFragment.dismiss();
                getActivity().getSupportFragmentManager().popBackStack();
            }
        }

        @Override
        public void favoriteMonster(boolean favorite) {
            monster.setFavorite(favorite);
            setFavorite();
        }

        @Override
        public void replaceAllTeam() {
            if (replaceConfirmationDialog == null) {
                replaceConfirmationDialog = ReplaceAllConfirmationDialogFragment.newInstance(replaceAllMonster);
            }
            if(!replaceConfirmationDialog.isAdded()){
                replaceConfirmationDialog.show(getChildFragmentManager(), "Monster Replace All");
            }
        }

        @Override
        public void replaceMonster() {
            ((MainActivity) getActivity()).switchFragment(MonsterTabLayoutFragment.newInstance(false, 1, position), MonsterTabLayoutFragment.TAG, "good");
            monsterRemoveDialogFragment.dismiss();
        }

        @Override
        public void evolveMonster(long baseMonsterId) {
            if(baseMonsterId != 0){
                monster.setBaseMonster(realm.where(BaseMonster.class).equalTo("monsterId", baseMonsterId).findFirst());
                showAwakenings();
                grayAwakenings();
                monsterStats();
                setImageViews();
                rarity.setText("" + monster.getRarity());
                monsterName.setText(monster.getName());
                monsterPicture.setImageResource(monster.getMonsterPicture());
                awakeningsCheck();
            }
        }
    };

    private ReplaceAllConfirmationDialogFragment.ResetLayout replaceAllMonster = new ReplaceAllConfirmationDialogFragment.ResetLayout() {
        @Override
        public void resetLayout() {
            ((MainActivity) getActivity()).switchFragment(MonsterTabLayoutFragment.newInstance(true, monster.getMonsterId(), position), MonsterTabLayoutFragment.TAG, "good");
            replaceConfirmationDialog.dismiss();
        }
    };

    private DeleteMonsterConfirmationDialogFragment.ResetLayout deleteMonster = new DeleteMonsterConfirmationDialogFragment.ResetLayout() {
        @Override
        public void resetLayout(int position) {
            ArrayList<Team> teamList = new ArrayList<>();
            RealmResults results = realm.where(Team.class).findAll();
            teamList.addAll(results);
            final long monsterId = monster.getMonsterId();
            Log.d("SaveMonsterList", "teamlist is: " + teamList);
            for (int i = 0; i < teamList.size(); i++) {
                for (int j = 0; j < teamList.get(i).getMonsters().size(); j++) {
                    if (teamList.get(i).getMonsters().get(j).getMonsterId() == monsterId) {
                        realm.beginTransaction();
                        teamList.get(i).setMonsters(j, realm.where(Monster.class).equalTo("monsterId", 0).findFirst());
                        realm.commitTransaction();
                        Log.d("SaveMonsterList", "team " + i + " monsters is: " + teamList.get(i).getMonsters());
                    }
                }
            }
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.where(Monster.class).equalTo("monsterId", monsterId).findFirst().deleteFromRealm();
                }
            });
            getActivity().getSupportFragmentManager().popBackStack();
        }
    };


}
