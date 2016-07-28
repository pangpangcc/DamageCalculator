package com.padassist.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.padassist.Data.Element;
import com.padassist.Data.Enemy;
import com.padassist.Data.Team;
import com.padassist.R;

import java.text.DecimalFormat;

/**
 * Created by DragonLotus on 11/4/2015.
 */
public class MonsterDamageListRecycler extends RecyclerView.Adapter<MonsterDamageListRecycler.ViewHolder> {

    private int combos, element1Damage, element1DamageEnemy, element2Damage, element2DamageEnemy;
    private boolean hasEnemy;
    private Enemy enemy;
    private Team team;
    private DecimalFormat df = new DecimalFormat("#.##");
    private Context mContext;
    private LayoutInflater inflater;
    private View.OnClickListener bindMonsterOnClickListener;

    private View.OnClickListener onItemClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            ViewHolder holder = (ViewHolder) v.getTag();
        }
    };

    public MonsterDamageListRecycler(Context context, boolean hasEnemy, Enemy enemy, int combos, Team team, View.OnClickListener bindMonsterOnClickListener){
        mContext = context;
        this.hasEnemy = hasEnemy;
        this.enemy = enemy;
        this.combos = combos;
        this.team = team;
        this.bindMonsterOnClickListener = bindMonsterOnClickListener;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.monsterName.setText(team.getMonsters(position).getName());
        if (team.getMonsters(position).getTotalPlus() == 0) {
            viewHolder.monsterPlus.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.monsterPlus.setVisibility(View.VISIBLE);
            viewHolder.monsterPlus.setText(" +" + Integer.toString(team.getMonsters(position).getTotalPlus()) + " ");
        }
        if (team.getMonsters(position).getCurrentAwakenings() == 0) {
            viewHolder.monsterAwakenings.setVisibility(View.INVISIBLE);
            viewHolder.monsterAwakenings.setText("");
        } else {
            viewHolder.monsterAwakenings.setVisibility(View.VISIBLE);
            if (team.getMonsters(position).getCurrentAwakenings() >= team.getMonsters(position).getMaxAwakenings()) {
                viewHolder.monsterAwakenings.setBackgroundResource(R.drawable.awakening_max);
                viewHolder.monsterAwakenings.setText("");
            } else {
                viewHolder.monsterAwakenings.setBackgroundResource(R.drawable.awakening_background);
                viewHolder.monsterAwakenings.setText(" " + Integer.toString(team.getMonsters(position).getCurrentAwakenings()));
            }
        }
        viewHolder.monsterPicture.setImageResource(team.getMonsters(position).getMonsterPicture());
        //Needs to get # of orb awakenings from team object maybe
        element1Damage = team.getMonsters(position).getElement1Damage(team, combos);
        element2Damage = team.getMonsters(position).getElement2Damage(team, combos);
        viewHolder.monsterElement1Damage.setText(" " + String.valueOf(element1Damage) + " ");
        viewHolder.monsterElement2Damage.setText(" " + String.valueOf(element2Damage) + " ");

        if(team.getMonsters(position).getElement1().equals(Element.BLANK)){
            viewHolder.monsterElement1Damage.setVisibility(View.INVISIBLE);
            viewHolder.monsterElement1DamageEnemy.setVisibility(View.INVISIBLE);
            viewHolder.monsterElement1Percent.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.monsterElement1Damage.setVisibility(View.VISIBLE);
            viewHolder.monsterElement1DamageEnemy.setVisibility(View.VISIBLE);
            viewHolder.monsterElement1Percent.setVisibility(View.VISIBLE);
        }
        if(team.getMonsters(position).getElement2().equals(Element.BLANK)){
            viewHolder.monsterElement2Damage.setVisibility(View.INVISIBLE);
            viewHolder.monsterElement2DamageEnemy.setVisibility(View.INVISIBLE);
            viewHolder.monsterElement2Percent.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.monsterElement2Damage.setVisibility(View.VISIBLE);
            viewHolder.monsterElement2DamageEnemy.setVisibility(View.VISIBLE);
            viewHolder.monsterElement2Percent.setVisibility(View.VISIBLE);
        }

        if (hasEnemy) {
            if (enemy.getHasDamageThreshold()) {
                element1DamageEnemy = team.getMonsters(position).getElement1DamageThreshold(team, enemy, combos);
                element2DamageEnemy = team.getMonsters(position).getElement2DamageThreshold(team, enemy, combos);
                viewHolder.monsterElement1DamageEnemy.setText("(" + String.valueOf(element1DamageEnemy) + ")");
                viewHolder.monsterElement2DamageEnemy.setText("(" + String.valueOf(element2DamageEnemy) + ")");
            } else if (enemy.hasDamageImmunity()){
                element1DamageEnemy = team.getMonsters(position).getElement1DamageImmunity(team, enemy, combos);
                element2DamageEnemy = team.getMonsters(position).getElement2DamageImmunity(team, enemy, combos);
                viewHolder.monsterElement1DamageEnemy.setText("(" + String.valueOf(element1DamageEnemy) + ")");
                viewHolder.monsterElement2DamageEnemy.setText("(" + String.valueOf(element2DamageEnemy) + ")");
            } else if (enemy.getHasAbsorb()) {
                element1DamageEnemy = team.getMonsters(position).getElement1DamageAbsorb(team, enemy, combos);
                element2DamageEnemy = team.getMonsters(position).getElement2DamageAbsorb(team, enemy, combos);
                viewHolder.monsterElement1DamageEnemy.setText("(" + String.valueOf(element1DamageEnemy) + ")");
                viewHolder.monsterElement2DamageEnemy.setText("(" + String.valueOf(element2DamageEnemy) + ")");
            } else if (enemy.getHasReduction()) {
                element1DamageEnemy = team.getMonsters(position).getElement1DamageReduction(team, enemy, combos);
                element2DamageEnemy = team.getMonsters(position).getElement2DamageReduction(team, enemy, combos);
                viewHolder.monsterElement1DamageEnemy.setText("(" + String.valueOf(element1DamageEnemy) + ")");
                viewHolder.monsterElement2DamageEnemy.setText("(" + String.valueOf(element2DamageEnemy) + ")");
            } else {
                element1DamageEnemy = team.getMonsters(position).getElement1DamageEnemy(team, enemy, combos);
                element2DamageEnemy = team.getMonsters(position).getElement2DamageEnemy(team, enemy, combos);
                viewHolder.monsterElement1DamageEnemy.setText("(" + String.valueOf(element1DamageEnemy) + ")");
                viewHolder.monsterElement2DamageEnemy.setText("(" + String.valueOf(element2DamageEnemy) + ")");
            }
            viewHolder.monsterElement1Percent.setText(String.valueOf(df.format((double) element1DamageEnemy / team.getTotalDamage() * 100) + "%"));
            viewHolder.monsterElement2Percent.setText(String.valueOf(df.format((double) element2DamageEnemy / team.getTotalDamage() * 100) + "%"));
            if(Double.isNaN((double) element1DamageEnemy / team.getTotalDamage() * 100)){
                viewHolder.monsterElement1Percent.setText("0%");
            }
            if(Double.isNaN((double) element2DamageEnemy / team.getTotalDamage() * 100)){
                viewHolder.monsterElement2Percent.setText("0%");
            }
            //if statement to check element damage > total damage, set to 0%?
        } else {
            viewHolder.monsterElement1Percent.setText(String.valueOf(df.format((double) element1Damage / team.getTotalDamage() * 100) + "%"));
            viewHolder.monsterElement2Percent.setText(String.valueOf(df.format((double) element2Damage / team.getTotalDamage() * 100) + "%"));
            if(Double.isNaN((double) element1Damage / team.getTotalDamage() * 100)){
                viewHolder.monsterElement1Percent.setText("0%");
            }
            if(Double.isNaN((double) element2Damage / team.getTotalDamage() * 100)) {
                viewHolder.monsterElement2Percent.setText("0%");
            }
            viewHolder.monsterElement1DamageEnemy.setVisibility(View.INVISIBLE);
            viewHolder.monsterElement2DamageEnemy.setVisibility(View.INVISIBLE);
        }

        setTextColors(position, viewHolder);

        viewHolder.itemView.setOnClickListener(bindMonsterOnClickListener);
        viewHolder.itemView.setTag(R.string.index, position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.monster_damage_row, parent, false));
    }

    @Override
    public int getItemCount() {
        return team.getMonsters().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView monsterName, monsterPlus, monsterAwakenings, monsterElement1Damage, monsterElement1DamageEnemy, monsterElement2Damage, monsterElement2DamageEnemy, monsterElement1Percent, monsterElement2Percent;
        ImageView monsterPicture;
        RelativeLayout relativeLayout;

        public ViewHolder(View convertView){
            super(convertView);
            monsterPicture = (ImageView) convertView.findViewById(R.id.monsterPicture);
            monsterName = (TextView) convertView.findViewById(R.id.monsterName);
            monsterPlus = (TextView) convertView.findViewById(R.id.monsterPlus);
            monsterAwakenings = (TextView) convertView.findViewById(R.id.monsterAwakenings);
            monsterElement1Damage = (TextView) convertView.findViewById(R.id.monsterElement1Damage);
            monsterElement1DamageEnemy = (TextView) convertView.findViewById(R.id.monsterElement1DamageEnemy);
            monsterElement2Damage = (TextView) convertView.findViewById(R.id.monsterElement2Damage);
            monsterElement2DamageEnemy = (TextView) convertView.findViewById(R.id.monsterElement2DamageEnemy);
            monsterElement1Percent = (TextView) convertView.findViewById(R.id.monsterElement1Percent);
            monsterElement2Percent = (TextView) convertView.findViewById(R.id.monsterElement2Percent);
            relativeLayout = (RelativeLayout) convertView.findViewById(R.id.relativeLayout);
        }
    }

    public void setTextColors(int position, ViewHolder viewHolder) {
        if (team.getMonsters(position).getElement1().equals(Element.RED)) {
            viewHolder.monsterElement1Damage.setTextColor(Color.parseColor("#FF0000"));
            viewHolder.monsterElement1DamageEnemy.setTextColor(Color.parseColor("#FF0000"));
        } else if (team.getMonsters(position).getElement1().equals(Element.BLUE)) {
            viewHolder.monsterElement1Damage.setTextColor(Color.parseColor("#4444FF"));
            viewHolder.monsterElement1DamageEnemy.setTextColor(Color.parseColor("#4444FF"));
        } else if (team.getMonsters(position).getElement1().equals(Element.GREEN)) {
            viewHolder.monsterElement1Damage.setTextColor(Color.parseColor("#00CC00"));
            viewHolder.monsterElement1DamageEnemy.setTextColor(Color.parseColor("#00CC00"));
        } else if (team.getMonsters(position).getElement1().equals(Element.LIGHT)) {
            viewHolder.monsterElement1Damage.setTextColor(Color.parseColor("#F0F000"));
            viewHolder.monsterElement1DamageEnemy.setTextColor(Color.parseColor("#F0F000"));
        } else if (team.getMonsters(position).getElement1().equals(Element.DARK)) {
            viewHolder.monsterElement1Damage.setTextColor(Color.parseColor("#AA00FF"));
            viewHolder.monsterElement1DamageEnemy.setTextColor(Color.parseColor("#AA00FF"));
        }
        if (team.getMonsters(position).getElement2().equals(Element.RED)) {
            viewHolder.monsterElement2Damage.setTextColor(Color.parseColor("#FF0000"));
            viewHolder.monsterElement2DamageEnemy.setTextColor(Color.parseColor("#FF0000"));
        } else if (team.getMonsters(position).getElement2().equals(Element.BLUE)) {
            viewHolder.monsterElement2Damage.setTextColor(Color.parseColor("#4444FF"));
            viewHolder.monsterElement2DamageEnemy.setTextColor(Color.parseColor("#4444FF"));
        } else if (team.getMonsters(position).getElement2().equals(Element.GREEN)) {
            viewHolder.monsterElement2Damage.setTextColor(Color.parseColor("#00CC00"));
            viewHolder.monsterElement2DamageEnemy.setTextColor(Color.parseColor("#00CC00"));
        } else if (team.getMonsters(position).getElement2().equals(Element.LIGHT)) {
            viewHolder.monsterElement2Damage.setTextColor(Color.parseColor("#F0F000"));
            viewHolder.monsterElement2DamageEnemy.setTextColor(Color.parseColor("#F0F000"));
        } else if (team.getMonsters(position).getElement2().equals(Element.DARK)) {
            viewHolder.monsterElement2Damage.setTextColor(Color.parseColor("#AA00FF"));
            viewHolder.monsterElement2DamageEnemy.setTextColor(Color.parseColor("#AA00FF"));
        }

        if (element1DamageEnemy < 0) {
            viewHolder.monsterElement1DamageEnemy.setTextColor(Color.parseColor("#FFBBBB"));
        }
        if (element2DamageEnemy < 0) {
            viewHolder.monsterElement2DamageEnemy.setTextColor(Color.parseColor("#FFBBBB"));
        }

        if(team.getIsBound().get(position)){
            viewHolder.monsterElement1Damage.setTextColor(Color.parseColor("#666666"));
            viewHolder.monsterElement1DamageEnemy.setTextColor(Color.parseColor("#666666"));
            viewHolder.monsterElement2Damage.setTextColor(Color.parseColor("#666666"));
            viewHolder.monsterElement2DamageEnemy.setTextColor(Color.parseColor("#666666"));
            viewHolder.monsterElement1Percent.setText(String.valueOf("0%"));
            viewHolder.monsterElement2Percent.setText(String.valueOf("0%"));
        }
    }

    public void setCombos(int combos) {
        this.combos = combos;
    }
}