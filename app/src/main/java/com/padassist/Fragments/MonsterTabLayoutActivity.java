package com.padassist.Fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.padassist.Adapters.MonsterPagerAdapter;
import com.padassist.Data.Monster;
import com.padassist.Util.MonsterTabLayoutUtil;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MonsterTabLayoutActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonsterTabLayoutActivity extends MonsterTabLayoutUtil {
    private boolean replaceAll;
    private long replaceMonsterId;
    private int monsterPosition;
    private MonsterPagerAdapter monsterPagerAdapter;

    // TODO: Rename and change types and number of parameters
    public static MonsterTabLayoutActivity newInstance(boolean replaceAll, long replaceMonsterId, int monsterPosition) {
        MonsterTabLayoutActivity fragment = new MonsterTabLayoutActivity();
        Bundle args = new Bundle();
        args.putBoolean("replaceAll", replaceAll);
        args.putLong("replaceMonsterId", replaceMonsterId);
        args.putInt("monsterPosition", monsterPosition);
        fragment.setArguments(args);
        return fragment;
    }

    public MonsterTabLayoutActivity() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            replaceAll = getArguments().getBoolean("replaceAll");
            replaceMonsterId = getArguments().getLong("replaceMonsterId");
            monsterPosition = getArguments().getInt("monsterPosition");
        }
        monsterPagerAdapter = new MonsterPagerAdapter(getChildFragmentManager(), getActivity(), replaceAll, replaceMonsterId);
        viewPager.setAdapter(monsterPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        if(Monster.getAllHelperMonsters().size() < 1 && monsterPosition == 5 && replaceMonsterId == 0){
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            tab.select();
        }else if(Monster.getAllMonsters().size() <= 1){
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            tab.select();
        }

        switch (monsterPosition) {
            case 0:
                getActivity().setTitle("Replace Leader");
                break;
            case 1:
                getActivity().setTitle("Replace Sub 1");
                break;
            case 2:
                getActivity().setTitle("Replace Sub 2");
                break;
            case 3:
                getActivity().setTitle("Replace Sub 3");
                break;
            case 4:
                getActivity().setTitle("Replace Sub 4");
                break;
            case 5:
                getActivity().setTitle("Replace Helper");
        }

    }

    private TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = new TabLayout.TabLayoutOnPageChangeListener(tabLayout){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if(position == 0){
                getActivity().setTitle("Saved Monsters");
            } else if(position == 1) {
                getActivity().setTitle("Create Monster");
            }
        }
    };

}
