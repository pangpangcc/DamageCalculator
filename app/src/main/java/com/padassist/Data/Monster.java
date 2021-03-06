package com.padassist.Data;

import android.os.Parcel;
import android.os.Parcelable;


import com.padassist.Util.DamageCalculationUtil;
import com.padassist.Util.Singleton;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Monster extends RealmObject implements Parcelable {
    public static final int HP_PLUS_MULTIPLIER = 10;
    public static final int ATK_PLUS_MULTIPLIER = 5;
    public static final int RCV_PLUS_MULTIPLIER = 3;

    @PrimaryKey
    private long monsterId;

    private long baseMonsterId;

    private BaseMonster baseMonster;

    private boolean favorite;

    private int priority;

    private int currentLevel;

    private int atkPlus;

    private int hpPlus;

    private int rcvPlus;

    private int currentAwakenings;

    private double currentAtk;

    private double currentRcv;

    private double currentHp;

    private boolean helper;

    private RealmList<RealmInt> latents;

    private RealmList<RealmInt> killerAwakenings;
    @Ignore
    DecimalFormat format = new DecimalFormat("0.00");
    @Ignore
    private ArrayList<Integer> awakenings = new ArrayList<>();
    @Ignore
    private Realm realm = Realm.getDefaultInstance();

    public Monster() {
    }

    public Monster(long baseMonsterId) {
        currentLevel = 1;
        monsterId = 0;
        this.baseMonsterId = baseMonsterId;
        baseMonster = realm.where(BaseMonster.class).equalTo("monsterId", baseMonsterId).findFirst();
        hpPlus = 0;
        atkPlus = 0;
        rcvPlus = 0;
        currentHp = 0;
        currentAtk = 0;
        currentRcv = 0;
        currentAwakenings = 0;
        priority = 2;
        favorite = false;
        helper = false;
        latents = new RealmList<>();
        latents.add(new RealmInt(0));
        latents.add(new RealmInt(0));
        latents.add(new RealmInt(0));
        latents.add(new RealmInt(0));
        latents.add(new RealmInt(0));
        killerAwakenings = new RealmList<>();
        if (baseMonsterId != 0) {
            setCurrentHp(DamageCalculationUtil.monsterStatCalc(baseMonster.getHpMin(), baseMonster.getHpMax(), currentLevel, baseMonster.getMaxLevel(), baseMonster.getHpScale()));
            setCurrentAtk(DamageCalculationUtil.monsterStatCalc(baseMonster.getAtkMin(), baseMonster.getAtkMax(), currentLevel, baseMonster.getMaxLevel(), baseMonster.getAtkScale()));
            setCurrentRcv(DamageCalculationUtil.monsterStatCalc(baseMonster.getRcvMin(), baseMonster.getRcvMax(), currentLevel, baseMonster.getMaxLevel(), baseMonster.getRcvScale()));
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
        setCurrentHp(DamageCalculationUtil.monsterStatCalc(baseMonster.getHpMin(), baseMonster.getHpMax(), currentLevel, baseMonster.getMaxLevel(), baseMonster.getHpScale()));
        setCurrentAtk(DamageCalculationUtil.monsterStatCalc(baseMonster.getAtkMin(), baseMonster.getAtkMax(), currentLevel, baseMonster.getMaxLevel(), baseMonster.getAtkScale()));
        setCurrentRcv(DamageCalculationUtil.monsterStatCalc(baseMonster.getRcvMin(), baseMonster.getRcvMax(), currentLevel, baseMonster.getMaxLevel(), baseMonster.getRcvScale()));
    }

    public int getCurrentAtk() {
        return (int) currentAtk;
    }

    public int getCurrentHp() {
        return (int) currentHp;
    }

    public int getTotalHp() {
        int totalHp = (int) currentHp + hpPlus * HP_PLUS_MULTIPLIER;
        int counter = 0;
        setAwakenings();
        for (int i = 0; i < awakenings.size(); i++) {
            if (awakenings.get(i) == 1) {
                counter++;
            }
        }
        int counter2 = 0;
        for (int i = 0; i < latents.size(); i++) {
            if (latents.get(i).getValue() == 1) {
                counter2++;
            }
        }
        int latentHp = (int) Math.floor(currentHp * counter2 * 0.015 + .5);
        totalHp = totalHp + (200 * counter) + latentHp;

        if(Singleton.getInstance().isCoopEnable()){
            if (awakenings.contains(30)) {
                totalHp *= 1.5;
            }
        }
        return totalHp;
    }

    public int getTotalAtk() {
        int totalAtk = (int) currentAtk + atkPlus * ATK_PLUS_MULTIPLIER;
        int counter = 0;
        setAwakenings();
        for (int i = 0; i < awakenings.size(); i++) {
            if (awakenings.get(i) == 2) {
                counter++;
            }
        }
        int counter2 = 0;
        for (int i = 0; i < latents.size(); i++) {
            if (latents.get(i).getValue() == 2) {
                counter2++;
            }
        }
        int latentAtk = (int) Math.floor(currentAtk * counter2 * 0.01 + .5);
        totalAtk = totalAtk + (100 * counter) + latentAtk;

        if(Singleton.getInstance().isCoopEnable()){
            if (awakenings.contains(30)) {
                totalAtk *= 1.5;
            }
        }
        return totalAtk;
    }

    public int getTotalRcv() {
        int totalRcv = (int) currentRcv + rcvPlus * RCV_PLUS_MULTIPLIER;
        int counter = 0;
        setAwakenings();
        for (int i = 0; i < awakenings.size(); i++) {
            if (awakenings.get(i) == 3) {
                counter++;
            }
        }
        int counter2 = 0;
        for (int i = 0; i < latents.size(); i++) {
            if (latents.get(i).getValue() == 3) {
                counter2++;
            }
        }
        int latentRcv = (int) Math.floor(currentRcv * counter2 * 0.05 + .5);
        totalRcv = totalRcv + (50 * counter) + latentRcv;
        if(Singleton.getInstance().isCoopEnable()){
            if (awakenings.contains(30)) {
                totalRcv *= 1.5;
            }
        }
        return totalRcv;
    }

    public ArrayList<Integer> setAwakenings() {
        if(currentAwakenings != awakenings.size()){
            if (currentAwakenings < getMaxAwakenings()) {
                for (int i = 0; i < currentAwakenings; i++) {
                    awakenings.add(getAwokenSkills().get(i).getValue());
                }
            } else {
                for (int i = 0; i < getMaxAwakenings(); i++) {
                    awakenings.add(getAwokenSkills().get(i).getValue());
                }
            }
        }
        return awakenings;
    }

    public String getWeightedString() {
        return format.format(getWeighted());
    }

    public double getWeighted() {
        return currentHp / HP_PLUS_MULTIPLIER + currentAtk / ATK_PLUS_MULTIPLIER + currentRcv / RCV_PLUS_MULTIPLIER;
    }

    public String getTotalWeightedString() {
        return format.format(getTotalWeighted());
    }

    public double getTotalWeighted() {
        return getWeighted() + hpPlus + atkPlus + rcvPlus;
    }

    public void setCurrentAtk(double currentAtk) {
        this.currentAtk = currentAtk;
    }

    public int getCurrentRcv() {
        return (int) currentRcv;
    }

    public void setCurrentRcv(double currentRcv) {
        this.currentRcv = currentRcv;
    }

    public int getAtkMax() {
        return baseMonster.getAtkMax();
    }

    public int getAtkMin() {
        return baseMonster.getAtkMin();
    }

    public int getHpMax() {
        return baseMonster.getHpMax();
    }

    public int getHpMin() {
        return baseMonster.getHpMin();
    }

    public int getMaxLevel() {
        return baseMonster.getMaxLevel();
    }

    public int getRcvMax() {
        return baseMonster.getRcvMax();
    }

    public int getRcvMin() {
        return baseMonster.getRcvMin();
    }

    public int getType1() {
        return baseMonster.getType1();
    }

    public int getType2() {
        return baseMonster.getType2();
    }

    public int getType3() {
        return baseMonster.getType3();
    }

    public String getType1String() {
        return baseMonster.getType1String();
    }

    public String getType2String() {
        return baseMonster.getType2String();
    }

    public String getType3String() {
        return baseMonster.getType3String();
    }

    public Element getElement1() {
        return baseMonster.getElement1();
    }

    public Element getElement2() {
        return baseMonster.getElement2();
    }

    public int getElement1Int() {
        return baseMonster.getElement1Int();
    }

    public int getElement2Int() {
        return baseMonster.getElement2Int();
    }

    public RealmList<RealmInt> getAwokenSkills() {
        return baseMonster.getAwokenSkills();
    }

    public int getAwokenSkills(int position) {
        return baseMonster.getAwokenSkills(position).getValue();
    }

    public String getActiveSkill() {
        return baseMonster.getActiveSkill();
    }

    public String getLeaderSkill() {
        return baseMonster.getLeaderSkill();
    }

    public String getName() {
        return baseMonster.getName();
    }

    public double getAtkScale() {
        return baseMonster.getAtkScale();
    }

    public double getRcvScale() {
        return baseMonster.getRcvScale();
    }

    public double getHpScale() {
        return baseMonster.getHpScale();
    }

    public void setCurrentHp(double currentHp) {
        this.currentHp = currentHp;
    }

    public int getAtkPlus() {
        return atkPlus;
    }

    public void setAtkPlus(int atkPlus) {
        this.atkPlus = atkPlus;
    }

    public int getHpPlus() {
        return hpPlus;
    }

    public void setHpPlus(int hpPlus) {
        this.hpPlus = hpPlus;
    }

    public int getRcvPlus() {
        return rcvPlus;
    }

    public void setRcvPlus(int rcvPlus) {
        this.rcvPlus = rcvPlus;
    }

    public int getTotalPlus() {
        return hpPlus + atkPlus + rcvPlus;
    }

    public int getMaxAwakenings() {
        return baseMonster.getMaxAwakenings();
    }

    public int getCurrentAwakenings() {
        return currentAwakenings;
    }

    public void setCurrentAwakenings(int currentAwakenings) {
        if(killerAwakenings.size() == 0 || currentAwakenings != this.currentAwakenings){
            ArrayList<Integer> awokenSkills = new ArrayList<>();
            for(int i = 0; i < getAwokenSkills().size(); i++){
                awokenSkills.add(getAwokenSkills().get(i).getValue());
            }
            if (awokenSkills.contains(31) || awokenSkills.contains(32) || awokenSkills.contains(33) || awokenSkills.contains(34) || awokenSkills.contains(35) || awokenSkills.contains(36) || awokenSkills.contains(37) || awokenSkills.contains(38) || awokenSkills.contains(39) || awokenSkills.contains(40) || awokenSkills.contains(41) || awokenSkills.contains(42)) {
                killerAwakenings.clear();
                if (currentAwakenings > getMaxAwakenings()) {
                    for (int i = 0; i < getMaxAwakenings(); i++) {
                        switch (baseMonster.getAwokenSkills(i).getValue()) {
                            case 31:
                                killerAwakenings.add(new RealmInt(31));
                                break;
                            case 32:
                                killerAwakenings.add(new RealmInt(32));
                                break;
                            case 33:
                                killerAwakenings.add(new RealmInt(33));
                                break;
                            case 34:
                                killerAwakenings.add(new RealmInt(34));
                                break;
                            case 35:
                                killerAwakenings.add(new RealmInt(35));
                                break;
                            case 36:
                                killerAwakenings.add(new RealmInt(36));
                                break;
                            case 37:
                                killerAwakenings.add(new RealmInt(37));
                                break;
                            case 38:
                                killerAwakenings.add(new RealmInt(38));
                                break;
                            case 39:
                                killerAwakenings.add(new RealmInt(39));
                                break;
                            case 40:
                                killerAwakenings.add(new RealmInt(40));
                                break;
                            case 41:
                                killerAwakenings.add(new RealmInt(41));
                                break;
                            case 42:
                                killerAwakenings.add(new RealmInt(42));
                                break;
                        }
                    }
                } else {
                    for (int i = 0; i < currentAwakenings; i++) {
                        switch (baseMonster.getAwokenSkills(i).getValue()) {
                            case 31:
                                killerAwakenings.add(new RealmInt(31));
                                break;
                            case 32:
                                killerAwakenings.add(new RealmInt(32));
                                break;
                            case 33:
                                killerAwakenings.add(new RealmInt(33));
                                break;
                            case 34:
                                killerAwakenings.add(new RealmInt(34));
                                break;
                            case 35:
                                killerAwakenings.add(new RealmInt(35));
                                break;
                            case 36:
                                killerAwakenings.add(new RealmInt(36));
                                break;
                            case 37:
                                killerAwakenings.add(new RealmInt(37));
                                break;
                            case 38:
                                killerAwakenings.add(new RealmInt(38));
                                break;
                            case 39:
                                killerAwakenings.add(new RealmInt(39));
                                break;
                            case 40:
                                killerAwakenings.add(new RealmInt(40));
                                break;
                            case 41:
                                killerAwakenings.add(new RealmInt(41));
                                break;
                            case 42:
                                killerAwakenings.add(new RealmInt(42));
                                break;
                        }
                    }
                }
            }
        }
        this.currentAwakenings = currentAwakenings;
    }

    public long getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(long monsterId) {
        this.monsterId = monsterId;
    }

    public long getBaseMonsterId() {
        return baseMonster.getMonsterId();
    }

    public int getMonsterPicture() {
        return baseMonster.getMonsterPicture();
    }

    public int getXpCurve() {
        return baseMonster.getXpCurve();
    }

    public int getRarity() {
        return baseMonster.getRarity();
    }

    public int getTeamCost() {
        return baseMonster.getTeamCost();
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public RealmList<RealmLong> getEvolutions() {
        return baseMonster.getEvolutions();
    }

    public BaseMonster getBaseMonster() {
        return baseMonster;
    }

    public void setBaseMonster(BaseMonster baseMonster) {
        this.baseMonster = baseMonster;
    }

    public boolean isHelper() {
        return helper;
    }

    public void setHelper(boolean helper) {
        this.helper = helper;
    }

    public RealmList<RealmInt> getLatents() {
        return latents;
    }

    public void setLatents(RealmList<RealmInt> latents) {
        this.latents = latents;
    }

    public RealmList<RealmInt> getKillerAwakenings() {
        return killerAwakenings;
    }

    public ArrayList<Integer> getTypes() {
        return baseMonster.getTypes();
    }

    public int getTPA() {
        int numOfDoubleProngs = 0;
        if (Singleton.getInstance().hasAwakenings()) {
            return numOfDoubleProngs;
        } else {
            if (currentAwakenings < getMaxAwakenings()) {
                for (int i = 0; i < currentAwakenings; i++) {
                    if (baseMonster.getAwokenSkills(i).getValue() == 27) {
                        numOfDoubleProngs++;
                    }
                }
            } else {
                for (int i = 0; i < getMaxAwakenings(); i++) {
                    if (baseMonster.getAwokenSkills(i).getValue() == 27) {
                        numOfDoubleProngs++;
                    }
                }
            }
        }

        return numOfDoubleProngs;
    }

    public Monster(Parcel source) {
        monsterId = source.readLong();
        baseMonster = source.readParcelable(BaseMonster.class.getClassLoader());
        favorite = source.readByte() == 1;
        priority = source.readInt();
        currentLevel = source.readInt();
        atkPlus = source.readInt();
        hpPlus = source.readInt();
        rcvPlus = source.readInt();
        currentAwakenings = source.readInt();
        currentAtk = source.readDouble();
        currentHp = source.readDouble();
        helper = source.readByte() == 1;
//        latents = source.readArrayList(Integer.class.getClassLoader());
//        killerAwakenings = source.readArrayList(Integer.class.getClassLoader());
//        awakenings = source.readArrayList(Integer.class.getClassLoader());
        //isBound = source.readByte() == 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(monsterId);
        dest.writeParcelable(baseMonster, flags);
        dest.writeByte((byte) (favorite ? 1: 0));
        dest.writeInt(priority);
        dest.writeInt(currentLevel);
        dest.writeInt(atkPlus);
        dest.writeInt(hpPlus);
        dest.writeInt(rcvPlus);
        dest.writeInt(currentAwakenings);
        dest.writeDouble(currentAtk);
        dest.writeDouble(currentHp);
        dest.writeByte((byte) (helper ? 1: 0));
//        dest.writeList(latents);
//        dest.writeList(killerAwakenings);
//        dest.writeList(awakenings);
        //dest.writeByte((byte) (isBound ? 1 : 0));
    }

    public static final Parcelable.Creator<Monster> CREATOR = new Creator<Monster>() {
        public Monster createFromParcel(Parcel source) {
            return new Monster(source);
        }

        public Monster[] newArray(int size) {
            return new Monster[size];
        }
    };
}


