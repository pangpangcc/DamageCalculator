package com.padassist.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Anthony on 7/16/2015.
 */
public class Enemy implements Parcelable {
    private int targetDef, beforeDefenseBreak, damageThreshold, damageImmunity, reductionValue;
    private long targetHp, currentHp, beforeGravityHP;
    private double gravityPercent;
    private Element targetElement;
    private ArrayList<Element> reduction, absorb;
    private ArrayList<Integer> gravityList, types;
    private Boolean hasAbsorb = false, hasReduction, hasDamageThreshold = false, isDamaged, hasDamageImmunity = false;


    //default is DKali from Arena 2
    public Enemy() {
        absorb = new ArrayList<>();
        reduction = new ArrayList<Element>();
        gravityList = new ArrayList<Integer>();
        types = new ArrayList<Integer>();
        targetHp = 33012222;
        targetDef = 0;
        currentHp = targetHp;
        beforeGravityHP = currentHp;
        beforeDefenseBreak = targetDef;
        targetElement = Element.DARK;
        gravityPercent = 1;
        damageThreshold = 200000;
        damageImmunity = 1000000;
        isDamaged = false;
        hasReduction = true;
        reduction.add(Element.RED);
        reduction.add(Element.BLUE);
        reduction.add(Element.GREEN);
        reduction.add(Element.LIGHT);
        reduction.add(Element.DARK);
        types.add(5);
        types.add(4);
        types.add(1337);
        reductionValue = 50;
    }


    public long getTargetHp() {
        return targetHp;
    }

    public void setTargetHp(long targetHp) {
        this.targetHp = targetHp;
    }

    public long getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(long currentHp) {
        this.currentHp = currentHp;
        if(this.currentHp < 0){
            this.currentHp = 0;
        }
    }

    public int getTargetDef() {
        return targetDef;
    }

    public void setTargetDef(int targetDef) {
        this.targetDef = targetDef;
    }

    public double getGravityPercent() {
        return gravityPercent;
    }

    public void setGravityPercent(double gravityPercent) {
        this.gravityPercent = gravityPercent;
    }

    public Element getTargetElement() {
        return targetElement;
    }

    public void setTargetElement(Element targetElement) {
        this.targetElement = targetElement;
    }

    public double getPercentHp() {
        if (targetHp == 0) {
            return 0;
        }
        return (double) currentHp / targetHp;
    }

    public long getBeforeGravityHP() {
        return beforeGravityHP;
    }

    public void setBeforeGravityHP(long beforeGravityHP) {
        this.beforeGravityHP = beforeGravityHP;
    }

    public int getBeforeDefenseBreak() {
        return beforeDefenseBreak;
    }

    public void setBeforeDefenseBreak(int beforeDefenseBreak) {
        this.beforeDefenseBreak = beforeDefenseBreak;
    }

    public int getDamageThreshold() {
        return damageThreshold;
    }

    public void setDamageThreshold(int damageThreshold) {
        this.damageThreshold = damageThreshold;
    }

    public ArrayList<Element> getAbsorb() {
        return absorb;
    }

    public void setAbsorb(ArrayList<Element> absorb) {
        this.absorb = absorb;
    }

    public ArrayList<Element> getReduction() {
        return reduction;
    }

    public void addReduction(Element element) {
        reduction.add(element);
    }

    public void removeReduction(Element element) {
        reduction.remove(element);
    }

    public boolean containsReduction(Element element) {
        return reduction.contains(element);
    }

    public void setReduction(ArrayList<Element> reduction) {
        this.reduction = reduction;
    }

    public Boolean getHasAbsorb() {
        return hasAbsorb;
    }

    public void setHasAbsorb(Boolean hasAbsorb) {
        this.hasAbsorb = hasAbsorb;
    }

    public Boolean getHasDamageThreshold() {
        return hasDamageThreshold;
    }

    public void setHasDamageThreshold(Boolean hasDamageThreshold) {
        this.hasDamageThreshold = hasDamageThreshold;
    }

    public Boolean isDamaged() {
        return isDamaged;
    }

    public void setIsDamaged(Boolean isDamaged) {
        this.isDamaged = isDamaged;
    }

    public Boolean getHasReduction() {
        return hasReduction;
    }

    public void setHasReduction(Boolean hasReduction) {
        this.hasReduction = hasReduction;
    }

    public ArrayList<Integer> getGravityList() {
        return gravityList;
    }

    public void setGravityList(ArrayList<Integer> gravityList) {
        this.gravityList = gravityList;
    }

    public int getGravityList(int position){
        return gravityList.get(position);
    }

    public void clearGravityList(){
        gravityList.clear();
    }

    public ArrayList<Integer> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Integer> types) {
        this.types = types;
    }

    public int getReductionValue() {
        return reductionValue;
    }

    public void setReductionValue(int reductionValue) {
        this.reductionValue = reductionValue;
    }

    public Boolean hasDamageImmunity() {
        return hasDamageImmunity;
    }

    public void setHasDamageImmunity(Boolean hasDamageImmunity) {
        this.hasDamageImmunity = hasDamageImmunity;
    }

    public int getDamageImmunity() {
        return damageImmunity;
    }

    public void setDamageImmunity(int damageImmunity) {
        this.damageImmunity = damageImmunity;
    }

    public Enemy(Parcel source) {
        targetHp = source.readLong();
        currentHp = source.readLong();
        targetDef = source.readInt();
        beforeGravityHP = source.readLong();
        beforeDefenseBreak = source.readInt();
        damageThreshold = source.readInt();
        gravityPercent = source.readDouble();
        targetElement = (Element) source.readSerializable();
        absorb = source.readArrayList(Element.class.getClassLoader());
        reduction = source.readArrayList(Element.class.getClassLoader());
        hasAbsorb = source.readByte() == 1;
        hasReduction = source.readByte() == 1;
        hasDamageThreshold = source.readByte() == 1;
        isDamaged = source.readByte() == 1;
        gravityList = source.readArrayList(Integer.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(targetHp);
        dest.writeLong(currentHp);
        dest.writeInt(targetDef);
        dest.writeLong(beforeGravityHP);
        dest.writeInt(beforeDefenseBreak);
        dest.writeInt(damageThreshold);
        dest.writeDouble(gravityPercent);
        dest.writeSerializable(targetElement);
        dest.writeList(absorb);
        dest.writeList(reduction);
        dest.writeByte((byte) (hasAbsorb ? 1 : 0));
        dest.writeByte((byte) (hasReduction ? 1 : 0));
        dest.writeByte((byte) (hasDamageThreshold ? 1 : 0));
        dest.writeByte((byte) (isDamaged ? 1: 0));
        dest.writeList(gravityList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Enemy> CREATOR = new Parcelable.Creator<Enemy>() {
        public Enemy createFromParcel(Parcel source) {
            return new Enemy(source);
        }

        public Enemy[] newArray(int size) {
            return new Enemy[size];
        }
    };

}
