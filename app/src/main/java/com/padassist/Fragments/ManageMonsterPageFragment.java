package com.padassist.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.padassist.Data.BaseMonster;
import com.padassist.Data.Monster;
import com.padassist.Data.Team;
import com.padassist.MainActivity;
import com.padassist.R;
import com.padassist.Util.MonsterPageUtil;
import com.padassist.Util.Singleton;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ManageMonsterPageFragment extends MonsterPageUtil {
    public static final String TAG = ManageMonsterPageFragment.class.getSimpleName();

    private Toast toast;
    private MonsterManageDialogFragment monsterManageDialogFragment;
    private ReplaceAllConfirmationDialogFragment replaceConfirmationDialog;
    private DeleteMonsterConfirmationDialogFragment deleteConfirmationDialog;

    public static ManageMonsterPageFragment newInstance(Monster monster) {
        ManageMonsterPageFragment fragment = new ManageMonsterPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        args.putParcelable("monster", monster);
        return fragment;
    }

    public ManageMonsterPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            monster = getArguments().getParcelable("monster");
        }
        monsterRemove.setOnClickListener(maxButtons);

    }

    public Monster getMonster(){
        if(getArguments() != null){
            return getArguments().getParcelable("monster");
        } else return null;
    }

    private View.OnClickListener maxButtons = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (monsterManageDialogFragment == null) {
                monsterManageDialogFragment = MonsterManageDialogFragment.newInstance(removeMonster, monster);
            }
            if(!monsterManageDialogFragment.isAdded()){
                monsterManageDialogFragment.show(getChildFragmentManager(), "Show Remove Monster", monster);
            }
        }
    };

    private MonsterManageDialogFragment.RemoveMonster removeMonster = new MonsterManageDialogFragment.RemoveMonster() {
        @Override
        public void removeMonsterDatabase() {
            if (deleteConfirmationDialog == null) {
                deleteConfirmationDialog = DeleteMonsterConfirmationDialogFragment.newInstance(deleteMonster, 0);
            }
            if(!deleteConfirmationDialog.isAdded()){
                deleteConfirmationDialog.show(getChildFragmentManager(), "Monster Replace All");
            }
//            monsterManageDialogFragment.dismiss();
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
