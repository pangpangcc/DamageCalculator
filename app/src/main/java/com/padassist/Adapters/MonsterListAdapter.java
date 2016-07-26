package com.padassist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.padassist.Data.Monster;
import com.padassist.R;

import java.util.ArrayList;

/**
 * Created by Anthony on 7/14/2015.
 */
public class MonsterListAdapter extends ArrayAdapter<Monster> {
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<Monster> monsterList;
    private int resourceId;

    public MonsterListAdapter(Context context, int textViewResourceId, ArrayList<Monster> monsterList) {
        super(context, textViewResourceId, monsterList);
        mContext = context;
        this.monsterList = monsterList;
        this.resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.monsterName = (TextView) convertView.findViewById(R.id.monsterName);
            viewHolder.monsterPlus = (TextView) convertView.findViewById(R.id.monsterPlus);
            viewHolder.monsterAwakenings = (TextView) convertView.findViewById(R.id.monsterAwakenings);
            viewHolder.monsterATK = (TextView) convertView.findViewById(R.id.monsterATK);
            viewHolder.monsterRCV = (TextView) convertView.findViewById(R.id.monsterRCV);
            viewHolder.monsterHP = (TextView) convertView.findViewById(R.id.monsterHP);
            viewHolder.monsterLevelValue = (TextView) convertView.findViewById(R.id.monsterLevelValue);
            viewHolder.monsterLevel = (TextView) convertView.findViewById(R.id.monsterLevel);
            viewHolder.monsterPicture = (ImageView) convertView.findViewById(R.id.monsterPicture);
            viewHolder.type1 = (ImageView) convertView.findViewById(R.id.type1);
            viewHolder.type2 = (ImageView) convertView.findViewById(R.id.type2);
            viewHolder.type3 = (ImageView) convertView.findViewById(R.id.type3);
            viewHolder.rarity = (TextView) convertView.findViewById(R.id.rarity);
            viewHolder.rarityStar = (ImageView) convertView.findViewById(R.id.rarityStar);

            convertView.setTag(R.string.viewHolder, viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(R.string.viewHolder);
        }
        viewHolder.monsterPicture.setImageResource(monsterList.get(position).getMonsterPicture());
        viewHolder.monsterATK.setText(Integer.toString(monsterList.get(position).getTotalAtk()) + " / ");
        viewHolder.monsterRCV.setText(Integer.toString(monsterList.get(position).getTotalRcv()));
        viewHolder.monsterHP.setText(Integer.toString(monsterList.get(position).getTotalHp()) + " / ");
        viewHolder.monsterAwakenings.setText(" " + Integer.toString(monsterList.get(position).getCurrentAwakenings()));
        viewHolder.monsterName.setText(monsterList.get(position).getName());
        viewHolder.monsterLevelValue.setText(Integer.toString(monsterList.get(position).getCurrentLevel()));
        viewHolder.monsterPlus.setText(" +" + Integer.toString(monsterList.get(position).getTotalPlus()) + " ");
        viewHolder.rarity.setText("" + monsterList.get(position).getRarity());
        viewHolder.rarityStar.setColorFilter(0xFFD4D421);
        if (monsterList.get(position).getCurrentAwakenings() == monsterList.get(position).getMaxAwakenings()) {
            viewHolder.monsterAwakenings.setBackgroundResource(R.drawable.awakening_max);
            viewHolder.monsterAwakenings.setText("");
        }

        if (monsterList.get(position).getTotalPlus() == 0) {
            viewHolder.monsterPlus.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.monsterPlus.setVisibility(View.VISIBLE);
        }
        if (monsterList.get(position).getCurrentAwakenings() == 0) {
            viewHolder.monsterAwakenings.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.monsterAwakenings.setVisibility(View.VISIBLE);
        }

        switch(monsterList.get(position).getType1()){
            case 0:
                viewHolder.type1.setImageResource(R.drawable.type_evo_material);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 1:
                viewHolder.type1.setImageResource(R.drawable.type_balanced);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 2:
                viewHolder.type1.setImageResource(R.drawable.type_physical);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 3:
                viewHolder.type1.setImageResource(R.drawable.type_healer);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 4:
                viewHolder.type1.setImageResource(R.drawable.type_dragon);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 5:
                viewHolder.type1.setImageResource(R.drawable.type_god);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 6:
                viewHolder.type1.setImageResource(R.drawable.type_attacker);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 7:
                viewHolder.type1.setImageResource(R.drawable.type_devil);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 8:
                viewHolder.type1.setImageResource(R.drawable.type_machine);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 12:
                viewHolder.type1.setImageResource(R.drawable.type_awoken);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            case 13:
                viewHolder.type1.setVisibility(View.INVISIBLE);
                break;
            case 14:
                viewHolder.type1.setImageResource(R.drawable.type_enhance_material);
                viewHolder.type1.setVisibility(View.VISIBLE);
                break;
            default:
                viewHolder.type1.setVisibility(View.GONE);
                break;
        }
        switch(monsterList.get(position).getType2()){
            case 0:
                viewHolder.type2.setImageResource(R.drawable.type_evo_material);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 1:
                viewHolder.type2.setImageResource(R.drawable.type_balanced);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 2:
                viewHolder.type2.setImageResource(R.drawable.type_physical);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 3:
                viewHolder.type2.setImageResource(R.drawable.type_healer);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 4:
                viewHolder.type2.setImageResource(R.drawable.type_dragon);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 5:
                viewHolder.type2.setImageResource(R.drawable.type_god);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 6:
                viewHolder.type2.setImageResource(R.drawable.type_attacker);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 7:
                viewHolder.type2.setImageResource(R.drawable.type_devil);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 8:
                viewHolder.type2.setImageResource(R.drawable.type_machine);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 12:
                viewHolder.type2.setImageResource(R.drawable.type_awoken);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            case 13:
                viewHolder.type2.setVisibility(View.INVISIBLE);
                break;
            case 14:
                viewHolder.type2.setImageResource(R.drawable.type_enhance_material);
                viewHolder.type2.setVisibility(View.VISIBLE);
                break;
            default:
                viewHolder.type2.setVisibility(View.GONE);
                break;
        }
        switch(monsterList.get(position).getType3()){
            case 0:
                viewHolder.type3.setImageResource(R.drawable.type_evo_material);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 1:
                viewHolder.type3.setImageResource(R.drawable.type_balanced);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 2:
                viewHolder.type3.setImageResource(R.drawable.type_physical);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 3:
                viewHolder.type3.setImageResource(R.drawable.type_healer);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 4:
                viewHolder.type3.setImageResource(R.drawable.type_dragon);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 5:
                viewHolder.type3.setImageResource(R.drawable.type_god);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 6:
                viewHolder.type3.setImageResource(R.drawable.type_attacker);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 7:
                viewHolder.type3.setImageResource(R.drawable.type_devil);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 8:
                viewHolder.type3.setImageResource(R.drawable.type_machine);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 12:
                viewHolder.type3.setImageResource(R.drawable.type_awoken);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            case 13:
                viewHolder.type3.setVisibility(View.INVISIBLE);
                break;
            case 14:
                viewHolder.type3.setImageResource(R.drawable.type_enhance_material);
                viewHolder.type3.setVisibility(View.VISIBLE);
                break;
            default:
                viewHolder.type3.setVisibility(View.GONE);
                break;
        }

        if(monsterList.get(position).getMonsterId() == 0){
            viewHolder.monsterLevelValue.setVisibility(View.INVISIBLE);
            viewHolder.monsterHP.setVisibility(View.INVISIBLE);
            viewHolder.monsterATK.setVisibility(View.INVISIBLE);
            viewHolder.monsterRCV.setVisibility(View.INVISIBLE);
            viewHolder.monsterLevel.setVisibility(View.INVISIBLE);
            viewHolder.type1.setVisibility(View.INVISIBLE);
            viewHolder.type2.setVisibility(View.INVISIBLE);
            viewHolder.rarity.setVisibility(View.INVISIBLE);
            viewHolder.rarityStar.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.monsterLevelValue.setVisibility(View.VISIBLE);
            viewHolder.monsterHP.setVisibility(View.VISIBLE);
            viewHolder.monsterATK.setVisibility(View.VISIBLE);
            viewHolder.monsterRCV.setVisibility(View.VISIBLE);
            viewHolder.monsterLevel.setVisibility(View.VISIBLE);
            viewHolder.type1.setVisibility(View.VISIBLE);
            viewHolder.type2.setVisibility(View.VISIBLE);
            viewHolder.type3.setVisibility(View.VISIBLE);
            viewHolder.rarity.setVisibility(View.VISIBLE);
            viewHolder.rarityStar.setVisibility(View.VISIBLE);
        }

        if(monsterList.get(position).getType2() == -1){
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)viewHolder.type1.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            viewHolder.type1.setLayoutParams(params);
        }

        if(monsterList.get(position).getType3() == -1){
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)viewHolder.type2.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            viewHolder.type2.setLayoutParams(params);
        }

        return convertView;
    }


    static class ViewHolder {
        TextView monsterName, monsterPlus, monsterAwakenings, monsterLevelValue, monsterHP, monsterATK, monsterRCV, monsterLevel, rarity;
        ImageView monsterPicture, type1, type2, type3, rarityStar;

    }
    public void updateList(ArrayList<Monster> monsterList){
        this.monsterList = monsterList;
        notifyDataSetChanged();
    }
}
