package com.padassist.Data;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.padassist.Util.Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DragonLotus on 9/18/2015.
 */
@Table(name = "LeaderSkill")
public class LeaderSkill extends Model {

    @Column(name = "hpData")
    private ArrayList<Double> hpData;
    @Column(name = "atkData")
    private ArrayList<Double> atkData;
    @Column(name = "rcvData")
    private ArrayList<Double> rcvData;
    @Column(name = "name", unique = true, index = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "hpType")
    private ArrayList<Integer> hpType;
    @Column(name = "hpElement")
    private ArrayList<Integer> hpElement;
    @Column(name = "atkType")
    private ArrayList<Integer> atkType;
    @Column(name = "atkType2")
    private ArrayList<Integer> atkType2;
    @Column(name = "atkElement")
    private ArrayList<Integer> atkElement;
    @Column(name = "atkElement2")
    private ArrayList<Integer> atkElement2;
    @Column(name = "rcvType")
    private ArrayList<Integer> rcvType;
    @Column(name = "rcvElement")
    private ArrayList<Integer> rcvElement;
    @Column(name = "comboMin")
    private int comboMin;
    @Column(name = "comboMax")
    private int comboMax;
    @Column(name = "comboMin2")
    private int comboMin2;
    @Column(name = "comboMax2")
    private int comboMax2;
    //Can use for orbs linked, indian 2 skills, etc. need to think about it.
    @Column(name = "matchElements")
    private ArrayList<Element> matchElements;
    @Column(name = "matchElements2")
    private ArrayList<Element> matchElements2;
    @Column(name = "matchMonsters")
    private ArrayList<Long> matchMonsters;
    @Column(name = "hpSkillType")
    private LeaderSkillType hpSkillType;
    @Column(name = "atkSkillType")
    private LeaderSkillType atkSkillType;
    @Column(name = "rcvSkillType")
    private LeaderSkillType rcvSkillType;
    @Column(name = "hpPercent")
    private ArrayList<Integer> hpPercent;
    private double hpMultiplier;
    private double atkElement1Multiplier;
    private double atkElement2Multiplier;
    private double rcvMultiplier;

    public LeaderSkill() {
        hpMultiplier = 1;
        atkElement1Multiplier = 1;
        atkElement2Multiplier = 1;
        rcvMultiplier = 1;
        hpData = new ArrayList<>();
        atkData = new ArrayList<>();
        rcvData = new ArrayList<>();
        hpType = new ArrayList<>();
        hpElement = new ArrayList<>();
        atkType = new ArrayList<>();
        atkType2 = new ArrayList<>();
        atkElement = new ArrayList<>();
        rcvType = new ArrayList<>();
        rcvElement = new ArrayList<>();
        matchElements = new ArrayList<>();
        matchElements2 = new ArrayList<>();
        matchMonsters = new ArrayList<>();
        hpPercent = new ArrayList<>();
    }

    public ArrayList<Double> getAtkData() {
        return atkData;
    }

    public void setAtkData(ArrayList<Double> atkData) {
        this.atkData = atkData;
    }

    public void addAtkData(Double data) {
        atkData.add(data);
    }

    public ArrayList<Integer> getAtkElement() {
        return atkElement;
    }

    public void setAtkElement(ArrayList<Integer> atkElement) {
        this.atkElement = atkElement;
    }

    public void addAtkElement(int element) {
        atkElement.add(element);
    }

    public LeaderSkillType getAtkSkillType() {
        return atkSkillType;
    }

    public void setAtkSkillType(LeaderSkillType atkSkillType) {
        this.atkSkillType = atkSkillType;
    }

    public ArrayList<Integer> getAtkType() {
        return atkType;
    }

    public void setAtkType(ArrayList<Integer> atkType) {
        this.atkType = atkType;
    }

    public void addAtkType(int type) {
        atkType.add(type);
    }

    public int getComboMax2() {
        return comboMax2;
    }

    public void setComboMax2(int comboMax2) {
        this.comboMax2 = comboMax2;
    }

    public int getComboMax() {
        return comboMax;
    }

    public void setComboMax(int comboMax) {
        this.comboMax = comboMax;
    }

    public int getComboMin2() {
        return comboMin2;
    }

    public void setComboMin2(int comboMin2) {
        this.comboMin2 = comboMin2;
    }

    public int getComboMin() {
        return comboMin;
    }

    public void setComboMin(int comboMin) {
        this.comboMin = comboMin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Double> getHpData() {
        return hpData;
    }

    public void setHpData(ArrayList<Double> hpData) {
        this.hpData = hpData;
    }

    public void addHpData(Double data) {
        hpData.add(data);
    }

    public ArrayList<Integer> getHpElement() {
        return hpElement;
    }

    public void setHpElement(ArrayList<Integer> hpElement) {
        this.hpElement = hpElement;
    }

    public void addHpElement(int element) {
        hpElement.add(element);
    }

    public LeaderSkillType getHpSkillType() {
        return hpSkillType;
    }

    public void setHpSkillType(LeaderSkillType hpSkillType) {
        this.hpSkillType = hpSkillType;
    }

    public ArrayList<Integer> getHpType() {
        return hpType;
    }

    public void setHpType(ArrayList<Integer> hpType) {
        this.hpType = hpType;
    }

    public void addHpType(int type) {
        hpType.add(type);
    }

    public ArrayList<Element> getMatchElements() {
        return matchElements;
    }

    public void setMatchElements(ArrayList<Element> matchElements) {
        this.matchElements = matchElements;
    }

    public void addMatchElements(Element element) {
        matchElements.add(element);
    }

    public ArrayList<Element> getMatchElements2() {
        return matchElements2;
    }

    public void setMatchElements2(ArrayList<Element> matchElements2) {
        this.matchElements2 = matchElements2;
    }

    public void addMatchElements2(Element element) {
        matchElements2.add(element);
    }

    public ArrayList<Long> getMatchMonsters() {
        return matchMonsters;
    }

    public void setMatchMonsters(ArrayList<Long> matchMonsters) {
        this.matchMonsters = matchMonsters;
    }

    public void addMatchmonsters(Long monsterId) {
        matchMonsters.add(monsterId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getRcvData() {
        return rcvData;
    }

    public void setRcvData(ArrayList<Double> rcvData) {
        this.rcvData = rcvData;
    }

    public void addRcvData(Double data) {
        rcvData.add(data);
    }

    public ArrayList<Integer> getRcvElement() {
        return rcvElement;
    }

    public void setRcvElement(ArrayList<Integer> rcvElement) {
        this.rcvElement = rcvElement;
    }

    public void addRcvElement(int element) {
        rcvElement.add(element);
    }

    public LeaderSkillType getRcvSkillType() {
        return rcvSkillType;
    }

    public void setRcvSkillType(LeaderSkillType rcvSkillType) {
        this.rcvSkillType = rcvSkillType;
    }

    public ArrayList<Integer> getRcvType() {
        return rcvType;
    }

    public void setRcvType(ArrayList<Integer> rcvType) {
        this.rcvType = rcvType;
    }

    public void addRcvType(int type) {
        rcvType.add(type);
    }

    public double getAtkElement1Multiplier() {
        return atkElement1Multiplier;
    }

    public void setAtkElement1Multiplier(double atkElement1Multiplier) {
        this.atkElement1Multiplier = atkElement1Multiplier;
    }

    public double getAtkElement2Multiplier() {
        return atkElement2Multiplier;
    }

    public void setAtkElement2Multiplier(double atkElement2Multiplier) {
        this.atkElement2Multiplier = atkElement2Multiplier;
    }

    public double getHpMultiplier() {
        return hpMultiplier;
    }

    public void setHpMultiplier(double hpMultiplier) {
        this.hpMultiplier = hpMultiplier;
    }

    public ArrayList<Integer> getHpPercent() {
        return hpPercent;
    }

    public void setHpPercent(ArrayList<Integer> hpPercent) {
        this.hpPercent = hpPercent;
    }

    public double getRcvMultiplier() {
        return rcvMultiplier;
    }

    public void setRcvMultiplier(double rcvMultiplier) {
        this.rcvMultiplier = rcvMultiplier;
    }

    public ArrayList<Integer> getAtkElement2() {
        return atkElement2;
    }

    public void setAtkElement2(ArrayList<Integer> atkElement2) {
        this.atkElement2 = atkElement2;
    }

    public ArrayList<Integer> getAtkType2() {
        return atkType2;
    }

    public void setAtkType2(ArrayList<Integer> atkType2) {
        this.atkType2 = atkType2;
    }

    public double hpMultiplier(Monster monster, Team team) {
        hpMultiplier = 1;
        if (hpSkillType != null) {
            switch (hpSkillType) {
                case BLANK:
                    break;
                case FLAT:
                    flat(monster, 1);
                    break;
                case MONSTER_CONDITIONAL:
                    monsterConditional(monster, team, 1);
                    break;
            }
        }
        return hpMultiplier;
    }

    public double atkElement1Multiplier(Monster monster, Team team, int totalCombos) {
        atkElement1Multiplier = 1;
        if (atkSkillType != null) {
            switch (atkSkillType) {
                case BLANK:
                    break;
                case FLAT:
                    flat(monster, 2);
                    break;
                case FLAT_ATTRIBUTE_ACTIVE_ATTRIBUTE:
                    flatAttributeActiveAttribute(monster, team);
                    break;
                case FLAT_TYPE_FLAT_ATTRIBUTE:
                    flatTypeFlatAttribute(monster, team);
                    break;
                case COMBO:
                    combo(monster, team, totalCombos);
                    break;
                case MATCH_ELEMENT:
                    matchElement(monster, team);
                    break;
                case MONSTER_CONDITIONAL:
                    monsterConditional(monster, team, 2);
                    break;
                case FLAT_MONSTER_CONDITIONAL:
                    flatMonsterConditional(monster, team, 2);
                    break;
                case ORB_LINK:
                    orbLink(monster, team);
                    break;
                case ORB_LINK_FLAT:
                    orbLinkFlat(monster, team);
                    break;
                case ORB_LINK_INDIAN:
                    orbLinkIndian(monster, team);
                    break;
                case MATCH_ELEMENT_FLAT:
                    matchElementFlat(monster, team);
                    break;
                case COMBO_MATCH_ELEMENT:
                    comboMatchElement(monster, team, totalCombos);
                    break;
                case MATCH_ELEMENT_ACTIVE:
                    matchElementActive(monster, team, 2);
                    break;
                case FLAT_ACTIVE:
                    flatActive(monster, team, 2);
                    break;
                case COMBO_ACTIVE:
                    comboActive(monster, team, totalCombos, 2);
                    break;
                case COMBO_FLAT:
                    comboFlat(monster, team, totalCombos);
                    break;
                case COMBO_ATTRIBUTE:
                    comboAttribute(monster, team, totalCombos);
                    break;
                case COMBO_EXACT:
                    comboExact(monster, team, totalCombos);
                    break;
                case INDIAN:
                    indian(monster, team);
                    break;
                case INDIAN_FLAT:
                    indianFlat(monster, team);
                    break;
                case ORB_PLUS:
                    orbPlus(monster, team);
                    break;
                case ORB_PLUS_FLAT:
                    orbPlusFlat(monster, team);
                    break;
                case INDIAN_ORB_PLUS:
                    indianOrbPlus(monster, team);
                    break;
                case MATCH_ELEMENT_ORB_PLUS:
                    matchElementOrbPlus(monster, team);
                    break;
                case COMBO_ORB_PLUS:
                    comboOrbPlus(monster, team, totalCombos);
                    break;
                case GRIMOIRE_FLAT:
                    multiFlat(monster, team);
                    break;
                case HP_FLAT:
                    hpFlat(monster, team, 2);
                    break;
                case FLAT_HP_FLAT:
                    flatHpFlat(monster, team);
                    break;
                case HP_FLAT_ATTRIBUTE_FLAT_TYPE:
                    hpFlatAttributeFlatType(monster, team);
                    break;
                case ACTIVE:
                    active(monster, team, 2);
                    break;
                case FLAT_TYPE_ACTIVE_ATTRIBUTE:
                    flatTypeActiveAttribute(monster, team);
                    break;
                case ORB_LINK_EXACT_FLAT:
                    orbLinkExactFlat(monster, team);
                    break;
                case ORB_LINK_EXACT:
                    orbLinkExact(monster, team);
                    break;
                case ORB_LINK_ORB_PLUS:
                    orbLinkOrbPlus(monster, team);
                    break;
                case MATCH_ELEMENT_ORB_LINK:
                    matchElementOrbLink(monster, team);
                    break;
                case FLAT_TYPE_FLAT_TYPE:
                    flatTypeFlatType(monster, team);
                    break;
                case HP_FLAT_ORB_PLUS:
                    hpFlatOrbPlus(monster, team);
                    break;
                case HP_FLAT_MATCH_ELEMENT:
                    hpFlatMatchElement(monster, team);
                    break;
                case HP_FLAT_ACTIVE:
                    hpFlatActive(monster, team);
                    break;
                case ORB_LINK_ACTIVE:
                    orbLinkActive(monster, team);
                    break;
                case HP_FLAT_ATTRIBUTE_FLAT_ATTRIBUTE:
                    hpFlatAttributeFlatAttribute(monster, team);
                    break;
                case INDIAN_ACTIVE:
                    indianActive(monster, team);
                    break;
                case HEART_CROSS:
                    heartCross(monster, team);
                    break;
                case COMBO_INDIAN:
                    comboIndian(monster, team, totalCombos);
                    break;
                case ORB_LINK_HP_FLAT:
                    orbLinkHpFlat(monster, team);
                    break;
                case ORB_PLUS_HEART_CROSS:
                    orbPlusHeartCross(monster, team);
                    break;
                case INDIAN_HEART_CROSS:
                    indianHeartCross(monster, team);
                    break;
                case FLAT_HEART_CROSS:
                    flatHeartCross(monster, team);
                    break;
                case MATCH_ELEMENT_HEART_CROSS:
                    matchElementHeartCross(monster, team);
                    break;
                case ACTIVE_HEART_CROSS:
                    activeHeartCross(monster, team);
                    break;
                case INDIAN_MONSTER_CONDITIONAL:
                    indianMonsterConditional(monster, team);
                    break;
                case ORB_PLUS_MONSTER_CONDITIONAL:
                    orbPlusMonsterConditional(monster, team);
                    break;
                case CROSS:
                    cross(monster, team);
                    break;
                case INDIAN_CROSS:
                    indianCross(monster, team);
                    break;
                case ACTIVE_CROSS:
                    activeCross(monster, team);
                    break;
                case CO_OP_HP_FLAT:
                    coopHpFlat(monster, team);
                    break;
                case CO_OP_FLAT:
                    coopFlat(monster, team);
                    break;
                case CO_OP:
                    coop(monster, team, 2);
                    break;
            }
        }
        return atkElement1Multiplier;
    }

    public double atkElement2Multiplier(Monster monster, Team team, int totalCombos) {
        atkElement2Multiplier = 1;
        if (atkSkillType != null) {
            switch (atkSkillType) {
                case BLANK:
                    break;
                case FLAT:
                    flat(monster, 2);
                    break;
                case FLAT_ATTRIBUTE_ACTIVE_ATTRIBUTE:
                    flatAttributeActiveAttribute(monster, team);
                    break;
                case FLAT_TYPE_FLAT_ATTRIBUTE:
                    flatTypeFlatAttribute(monster, team);
                    break;
                case COMBO:
                    combo(monster, team, totalCombos);
                    break;
                case MATCH_ELEMENT:
                    matchElement(monster, team);
                    break;
                case MONSTER_CONDITIONAL:
                    monsterConditional(monster, team, 2);
                    break;
                case FLAT_MONSTER_CONDITIONAL:
                    flatMonsterConditional(monster, team, 2);
                    break;
                case ORB_LINK:
                    orbLink(monster, team);
                    break;
                case ORB_LINK_FLAT:
                    orbLinkFlat(monster, team);
                    break;
                case ORB_LINK_INDIAN:
                    orbLinkIndian(monster, team);
                    break;
                case MATCH_ELEMENT_FLAT:
                    matchElementFlat(monster, team);
                    break;
                case COMBO_MATCH_ELEMENT:
                    comboMatchElement(monster, team, totalCombos);
                    break;
                case MATCH_ELEMENT_ACTIVE:
                    matchElementActive(monster, team, 2);
                    break;
                case FLAT_ACTIVE:
                    flatActive(monster, team, 2);
                    break;
                case COMBO_ACTIVE:
                    comboActive(monster, team, totalCombos, 2);
                    break;
                case COMBO_FLAT:
                    comboFlat(monster, team, totalCombos);
                    break;
                case COMBO_ATTRIBUTE:
                    comboAttribute(monster, team, totalCombos);
                    break;
                case COMBO_EXACT:
                    comboExact(monster, team, totalCombos);
                    break;
                case INDIAN:
                    indian(monster, team);
                    break;
                case INDIAN_FLAT:
                    indianFlat(monster, team);
                    break;
                case ORB_PLUS:
                    orbPlus(monster, team);
                    break;
                case ORB_PLUS_FLAT:
                    orbPlusFlat(monster, team);
                    break;
                case INDIAN_ORB_PLUS:
                    indianOrbPlus(monster, team);
                    break;
                case MATCH_ELEMENT_ORB_PLUS:
                    matchElementOrbPlus(monster, team);
                    break;
                case COMBO_ORB_PLUS:
                    comboOrbPlus(monster, team, totalCombos);
                    break;
                case GRIMOIRE_FLAT:
                    multiFlat(monster, team);
                    break;
                case HP_FLAT:
                    hpFlat(monster, team, 2);
                    break;
                case FLAT_HP_FLAT:
                    flatHpFlat(monster, team);
                    break;
                case HP_FLAT_ATTRIBUTE_FLAT_TYPE:
                    hpFlatAttributeFlatType(monster, team);
                    break;
                case ACTIVE:
                    active(monster, team, 2);
                    break;
                case FLAT_TYPE_ACTIVE_ATTRIBUTE:
                    flatTypeActiveAttribute(monster, team);
                    break;
                case ORB_LINK_EXACT_FLAT:
                    orbLinkExactFlat(monster, team);
                    break;
                case ORB_LINK_EXACT:
                    orbLinkExact(monster, team);
                    break;
                case ORB_LINK_ORB_PLUS:
                    orbLinkOrbPlus(monster, team);
                    break;
                case MATCH_ELEMENT_ORB_LINK:
                    matchElementOrbLink(monster, team);
                    break;
                case FLAT_TYPE_FLAT_TYPE:
                    flatTypeFlatType(monster, team);
                    break;
                case HP_FLAT_ORB_PLUS:
                    hpFlatOrbPlus(monster, team);
                    break;
                case HP_FLAT_MATCH_ELEMENT:
                    hpFlatMatchElement(monster, team);
                    break;
                case HP_FLAT_ACTIVE:
                    hpFlatActive(monster, team);
                    break;
                case ORB_LINK_ACTIVE:
                    orbLinkActive(monster, team);
                    break;
                case HP_FLAT_ATTRIBUTE_FLAT_ATTRIBUTE:
                    hpFlatAttributeFlatAttribute(monster, team);
                    break;
                case INDIAN_ACTIVE:
                    indianActive(monster, team);
                    break;
                case HEART_CROSS:
                    heartCross(monster, team);
                    break;
                case COMBO_INDIAN:
                    comboIndian(monster, team, totalCombos);
                    break;
                case ORB_LINK_HP_FLAT:
                    orbLinkHpFlat(monster, team);
                    break;
                case ORB_PLUS_HEART_CROSS:
                    orbPlusHeartCross(monster, team);
                    break;
                case INDIAN_HEART_CROSS:
                    indianHeartCross(monster, team);
                    break;
                case FLAT_HEART_CROSS:
                    flatHeartCross(monster, team);
                    break;
                case MATCH_ELEMENT_HEART_CROSS:
                    matchElementHeartCross(monster, team);
                    break;
                case ACTIVE_HEART_CROSS:
                    activeHeartCross(monster, team);
                    break;
                case INDIAN_MONSTER_CONDITIONAL:
                    indianMonsterConditional(monster, team);
                    break;
                case ORB_PLUS_MONSTER_CONDITIONAL:
                    orbPlusMonsterConditional(monster, team);
                    break;
                case CROSS:
                    cross(monster, team);
                    break;
                case INDIAN_CROSS:
                    indianCross(monster, team);
                    break;
                case ACTIVE_CROSS:
                    activeCross(monster, team);
                    break;
                case CO_OP_HP_FLAT:
                    coopHpFlat(monster, team);
                    break;
                case CO_OP_FLAT:
                    coopFlat(monster, team);
                    break;
                case CO_OP:
                    coop(monster, team, 2);
                    break;
            }
        }
        return atkElement2Multiplier;
    }

    public double rcvMultiplier(Monster monster, Team team) {
        rcvMultiplier = 1;
        if (rcvSkillType != null) {
            switch (rcvSkillType) {
                case FLAT:
                    flat(monster, 3);
                    break;
                case MONSTER_CONDITIONAL:
                    monsterConditional(monster, team, 3);
                    break;
                case MATCH_ELEMENT_ACTIVE:
                    matchElementActive(monster, team, 3);
                    break;
                case FLAT_ACTIVE:
                    flatActive(monster, team, 3);
                    break;
                case COMBO_ACTIVE:
                    comboActive(monster, team, 0, 3);
                    break;
                case HP_FLAT:
                    hpFlat(monster, team, 3);
                    break;
                case ACTIVE:
                    active(monster, team, 3);
                    break;
                case CO_OP:
                    coop(monster, team, 3);
                    break;
            }
        }
        return rcvMultiplier;
    }

    private void flat(Monster monster, int stat) {
        switch (stat) {
            case 1:
                if (hpType.size() != 0) {
                    for (int i = 0; i < hpType.size(); i++) {
                        if (monster.getType1() == hpType.get(i) || monster.getType2() == hpType.get(i) || monster.getType3() == hpType.get(i)) {
                            hpMultiplier = hpData.get(0);
                        }
                    }
                }
                if (hpElement.size() != 0) {
                    for (int i = 0; i < hpElement.size(); i++) {
                        if (monster.getElement1Int() == hpElement.get(i) || monster.getElement2Int() == hpElement.get(i)) {
                            hpMultiplier = hpData.get(0);
                        }
                    }
                }
                break;
            case 2:
                if (atkType.size() != 0) {
                    for (int i = 0; i < atkType.size(); i++) {
                        if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                            atkElement1Multiplier = atkData.get(0);
                            atkElement2Multiplier = atkData.get(0);
                        }
                    }
                }
                if (atkElement.size() != 0) {
                    for (int i = 0; i < atkElement.size(); i++) {
                        if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                            atkElement1Multiplier = atkData.get(0);
                            atkElement2Multiplier = atkData.get(0);
                        }
                    }
                }
                break;
            case 3:
                if (rcvType.size() != 0) {
                    for (int i = 0; i < rcvType.size(); i++) {
                        if (monster.getType1() == rcvType.get(i) || monster.getType2() == rcvType.get(i) || monster.getType3() == rcvType.get(i)) {
                            rcvMultiplier = rcvData.get(0);
                        }
                    }
                }
                if (rcvElement.size() != 0) {
                    for (int i = 0; i < rcvElement.size(); i++) {
                        if (monster.getElement1Int() == rcvElement.get(i) || monster.getElement2Int() == rcvElement.get(i)) {
                            rcvMultiplier = rcvData.get(0);
                        }
                    }
                }
                break;
        }

    }

    private void combo(Monster monster, Team team, int totalCombos) {
        //Bastet, Anubis
        int comboDiff = comboMax - comboMin;
//        if (team.getOrbMatches().size() >= comboMax){
//            atkElement1Multiplier = atkData.get(comboDiff);
//        }else if(team.getOrbMatches().size() > comboMin){
//            for(int i = 0; i <= comboDiff; i++){
//                if(team.getOrbMatches().size() >= (comboMin + i)){
//                    atkElement1Multiplier = atkData.get(i);
//                }
//            }
//        }
        int counter = totalCombos - comboMin;
        if (counter >= comboDiff) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (totalCombos >= comboMin) {
            atkElement1Multiplier = atkData.get(counter);
            atkElement2Multiplier = atkData.get(counter);
        }
    }

    private void matchElement(Monster monster, Team team) {
        //Kirin, Horus, Ra
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < matchElements.size(); i++) {
            if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                counter++;
            }
        }

        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }
    }

    private void monsterConditional(Monster monster, Team team, int stat) {
        //Three kingdoms farmables. Zhao Yun.
        int counter = 0;
        for (int i = 0; i < matchMonsters.size(); i++) {
            if (team.getBaseMonsterId().contains(matchMonsters.get(i))) {
                counter++;
            }
        }
        if (counter == matchMonsters.size()) {
            if (stat == 1) {
                hpMultiplier = hpData.get(0);
            } else if (stat == 2) {
                atkElement1Multiplier = atkData.get(0);
                atkElement2Multiplier = atkData.get(0);
            } else if (stat == 3) {
                rcvMultiplier = rcvData.get(0);
            }
        }
    }

    private void flatMonsterConditional(Monster monster, Team team, int stat) {
        //Attack Data will look like {flat multiplier, monster conditional multiplier}
        //See Awoken Jord and Zhou Yu
        int counter = 0;
        for (int i = 0; i < matchMonsters.size(); i++) {
            if (team.getBaseMonsterId().contains(matchMonsters.get(i))) {
                counter++;
            }
        }

        if (stat == 1) {
            if (hpType.size() != 0) {
                for (int i = 0; i < hpType.size(); i++) {
                    if (monster.getType1() == hpType.get(i) || monster.getType2() == hpType.get(i) || monster.getType3() == hpType.get(i)) {
                        hpMultiplier = hpData.get(0);
                    }
                }
            }
            if (hpElement.size() != 0) {
                for (int i = 0; i < hpElement.size(); i++) {
                    if (monster.getElement1Int() == hpElement.get(i) || monster.getElement2Int() == hpElement.get(i)) {
                        hpMultiplier = hpData.get(0);
                    }
                }
            }
        } else if (stat == 2) {
            if (atkType.size() != 0) {
                for (int i = 0; i < atkType.size(); i++) {
                    if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                        atkElement1Multiplier = atkData.get(0);
                        atkElement2Multiplier = atkData.get(0);
                    }
                }
            }
            if (atkElement.size() != 0) {
                for (int i = 0; i < atkElement.size(); i++) {
                    if (monster.getElement1Int() == atkElement.get(i) || monster.getType2() == atkElement.get(i) || monster.getType3() == atkElement.get(i)) {
                        atkElement1Multiplier = atkData.get(0);
                        atkElement2Multiplier = atkData.get(0);
                    }
                }
            }
        } else if (stat == 3) {
            if (rcvType.size() != 0) {
                for (int i = 0; i < rcvType.size(); i++) {
                    if (monster.getType1() == rcvType.get(i) || monster.getType2() == rcvType.get(i) || monster.getType3() == rcvType.get(i)) {
                        rcvMultiplier = rcvData.get(0);
                    }
                }
            }
            if (rcvElement.size() != 0) {
                for (int i = 0; i < rcvElement.size(); i++) {
                    if (monster.getElement1Int() == rcvElement.get(i) || monster.getElement2Int() == rcvElement.get(i)) {
                        rcvMultiplier = rcvData.get(0);
                    }
                }
            }
        }
        if (counter == matchMonsters.size()) {
            if (stat == 1) {
                hpMultiplier *= hpData.get(1);
            } else if (stat == 2) {
                atkElement1Multiplier *= atkData.get(1);
                atkElement2Multiplier *= atkData.get(1);
            } else if (stat == 3) {
                rcvMultiplier *= rcvData.get(1);
            }
        }

    }

    private void orbPlus(Monster monster, Team team) {
        //Akechi Mitsuhide
        //atkData will be one number
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (team.getOrbMatches().get(i).getNumOrbPlus() >= 1 && team.getOrbMatches().get(i).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement1Multiplier = atkData.get(0);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        }
    }

    private void orbLink(Monster monster, Team team) {
        //Heroes
        //matchElements is the elements you can link, 2 for beach pandora and such.
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {

                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (counter < team.getOrbMatches().get(i).getOrbsLinked()) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }
    }

    private void matchElementFlat(Monster monster, Team team) {
        //Sonia Gran.
        // atkdata is {match element multipliers, flat multiplier is last}
        if (atkType.size() != 0) {
            for (int i = 0; i < atkType.size(); i++) {
                if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                    atkElement1Multiplier = atkData.get(atkData.size() - 1);
                    atkElement2Multiplier = atkData.get(atkData.size() - 1);
                }
            }
        }
        if (atkElement.size() != 0) {
            for (int i = 0; i < atkElement.size(); i++) {
                if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                    atkElement1Multiplier = atkData.get(atkData.size() - 1);
                    atkElement2Multiplier = atkData.get(atkData.size() - 1);
                }
            }
        }
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < matchElements.size(); i++) {
            if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                counter++;
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }

    }

    private void comboMatchElement(Monster monster, Team team, int totalCombos) {
        //Lkali ult, Awoken Kirin
        //atkdata is {combo multipliers first, match element multipliers last}
        int comboDiff = comboMax - comboMin;
        int counter = totalCombos - comboMin;
        if (counter >= comboDiff) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (totalCombos >= comboMin) {
            atkElement1Multiplier = atkData.get(counter);
            atkElement2Multiplier = atkData.get(counter);
        }

        int comboDiff2 = comboMax2 - comboMin2;
        int counter2 = 0;
        for (int i = 0; i < matchElements.size(); i++) {
            if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                counter2++;
            }
        }
        if (counter2 >= comboMax2) {
            atkElement1Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
        } else if (counter2 >= comboMin2) {
            atkElement1Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
        }

    }

    private void matchElementActive(Monster monster, Team team, int stat) {
        //Need active flag in team
        //Awoken Ra, Awoken Horus, Green Kirin
        //atkdata is {match elements first, additional damage with skill last}
        if (team.isActiveSkillUsed()) {
            if (stat == 2) {
                if (atkType.size() != 0) {
                    for (int i = 0; i < atkType.size(); i++) {
                        if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                            atkElement1Multiplier = atkData.get(atkData.size() - 1);
                            atkElement2Multiplier = atkData.get(atkData.size() - 1);
                        }
                    }
                }
                if (atkElement.size() != 0) {
                    for (int i = 0; i < atkElement.size(); i++) {
                        if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                            atkElement1Multiplier = atkData.get(atkData.size() - 1);
                            atkElement2Multiplier = atkData.get(atkData.size() - 1);
                        }
                    }
                }
            } else if (stat == 3) {
                if (rcvType.size() != 0) {
                    for (int i = 0; i < rcvType.size(); i++) {
                        if (monster.getType1() == rcvType.get(i) || monster.getType2() == rcvType.get(i) || monster.getType3() == rcvType.get(i)) {
                            rcvMultiplier = rcvData.get(rcvData.size() - 1);
                        }
                    }
                }
                if (rcvElement.size() != 0) {
                    for (int i = 0; i < rcvElement.size(); i++) {
                        if (monster.getElement1Int() == rcvElement.get(i) || monster.getElement2Int() == rcvElement.get(i)) {
                            rcvMultiplier = rcvData.get(rcvData.size() - 1);
                        }
                    }
                }
            }
        }
        if (stat == 2) {
            int comboDiff = comboMax - comboMin;
            int counter = 0;
            for (int i = 0; i < matchElements.size(); i++) {
                if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                    counter++;
                }
            }
            if (counter >= comboMax) {
                atkElement1Multiplier *= atkData.get(comboDiff);
                atkElement2Multiplier *= atkData.get(comboDiff);
            } else if (counter >= comboMin) {
                atkElement1Multiplier *= atkData.get(counter - comboMin);
                atkElement2Multiplier *= atkData.get(counter - comboMin);
            }
        }
    }

    private void flatActive(Monster monster, Team team, int stat) {
        //Nope. Not used
        //atkData will be {flat, active}
        if (team.isActiveSkillUsed()) {
            if (stat == 2) {
                if (atkType.size() != 0) {
                    for (int i = 0; i < atkType.size(); i++) {
                        if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                            atkElement1Multiplier = atkData.get(1);
                            atkElement2Multiplier = atkData.get(1);
                        }
                    }
                }
                if (atkElement.size() != 0) {
                    for (int i = 0; i < atkElement.size(); i++) {
                        if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                            atkElement1Multiplier = atkData.get(1);
                            atkElement2Multiplier = atkData.get(1);
                        }
                    }
                }
            } else if (stat == 3) {
                if (rcvType.size() != 0) {
                    for (int i = 0; i < rcvType.size(); i++) {
                        if (monster.getType1() == rcvType.get(i) || monster.getType2() == rcvType.get(i) || monster.getType3() == rcvType.get(i)) {
                            rcvMultiplier = rcvData.get(1);
                        }
                    }
                }
                if (rcvElement.size() != 0) {
                    for (int i = 0; i < rcvElement.size(); i++) {
                        if (monster.getElement1Int() == rcvElement.get(i) || monster.getElement2Int() == rcvElement.get(i)) {
                            rcvMultiplier = rcvData.get(1);
                        }
                    }
                }
            }
        }
        if (stat == 2) {
            if (atkType.size() != 0) {
                for (int i = 0; i < atkType.size(); i++) {
                    if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                        atkElement1Multiplier *= atkData.get(0);
                        atkElement2Multiplier *= atkData.get(0);
                        break;
                    }
                }
            }
            if (atkElement.size() != 0) {
                for (int i = 0; i < atkElement.size(); i++) {
                    if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                        atkElement1Multiplier *= atkData.get(0);
                        atkElement2Multiplier *= atkData.get(0);
                        break;
                    }
                }
            }
        } else if (stat == 3) {
            if (rcvType.size() != 0) {
                for (int i = 0; i < rcvType.size(); i++) {
                    if (monster.getType1() == rcvType.get(i) || monster.getType2() == rcvType.get(i) || monster.getType3() == rcvType.get(i)) {
                        rcvMultiplier *= rcvData.get(0);
                        break;
                    }
                }
            }
            if (rcvElement.size() != 0) {
                for (int i = 0; i < rcvElement.size(); i++) {
                    if (monster.getElement1Int() == rcvElement.get(i) || monster.getElement2Int() == rcvElement.get(i)) {
                        rcvMultiplier *= rcvData.get(0);
                        break;
                    }
                }
            }
        }
    }

    private void comboActive(Monster monster, Team team, int totalCombos, int stat) {
        //Awoken Anubis, Awoken Bastet
        //{Combos, active}
        int comboDiff = comboMax - comboMin;
        if (team.isActiveSkillUsed()) {
            if (stat == 2) {
                if (atkType.size() != 0) {
                    for (int i = 0; i < atkType.size(); i++) {
                        if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                            atkElement1Multiplier = atkData.get(comboDiff + 1);
                            atkElement2Multiplier = atkData.get(comboDiff + 1);
                        }
                    }
                }
                if (atkElement.size() != 0) {
                    for (int i = 0; i < atkElement.size(); i++) {
                        if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                            atkElement1Multiplier = atkData.get(comboDiff + 1);
                            atkElement2Multiplier = atkData.get(comboDiff + 1);
                        }
                    }
                }
            } else if (stat == 3) {
                if (rcvType.size() != 0) {
                    for (int i = 0; i < rcvType.size(); i++) {
                        if (monster.getType1() == rcvType.get(i) || monster.getType2() == rcvType.get(i) || monster.getType3() == rcvType.get(i)) {
                            rcvMultiplier = rcvData.get(comboDiff + 1);
                        }
                    }
                }
                if (rcvElement.size() != 0) {
                    for (int i = 0; i < rcvElement.size(); i++) {
                        if (monster.getElement1Int() == rcvElement.get(i) || monster.getElement2Int() == rcvElement.get(i)) {
                            rcvMultiplier = rcvData.get(comboDiff + 1);
                        }
                    }
                }
            }
        }

        int counter = totalCombos - comboMin;
        if (counter >= comboDiff) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (totalCombos >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter);
            atkElement2Multiplier *= atkData.get(counter);
        }
    }

    private void comboFlat(Monster monster, Team team, int totalCombos) {
        //Ronia ult
        //{combo multiplier, flat multiplier}
        int comboDiff = comboMax - comboMin;
        if (atkType.size() != 0) {
            for (int i = 0; i < atkType.size(); i++) {
                if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        }
        if (atkElement.size() != 0) {
            for (int i = 0; i < atkElement.size(); i++) {
                if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        }
        int counter = totalCombos - comboMin;
        if (counter >= comboDiff) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (totalCombos >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter);
            atkElement2Multiplier *= atkData.get(counter);
        }
    }

    private void multiFlat(Monster monster, Team team) {
        //Goetia? Not Goemon. I'll use this for Goetia and friends.
        //Damn I don't remember
        //atkdata will be {bigger multiplier, smaller multipler}
        int counter = 0;
        if (atkType.size() != 0) {
            if (monster.getType1() == atkType.get(0) || monster.getType2() == atkType.get(0) || monster.getType3() == atkType.get(0)) {
                if (monster.getType1() == atkType.get(1) || monster.getType2() == atkType.get(1) || monster.getType3() == atkType.get(1)) {
                    atkElement1Multiplier = atkData.get(0) * atkData.get(1);
                    atkElement2Multiplier = atkData.get(0) * atkData.get(1);
                } else {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            } else if (monster.getType1() == atkType.get(1) || monster.getType2() == atkType.get(1) || monster.getType3() == atkType.get(1)) {
                atkElement1Multiplier = atkData.get(1);
                atkElement2Multiplier = atkData.get(1);
            }
        }
        if (atkElement.size() != 0) {
            if (monster.getElement1Int() == atkElement.get(0) || monster.getElement2Int() == atkElement.get(0)) {
                if (monster.getElement1Int() == atkElement.get(1) || monster.getElement2Int() == atkElement.get(1)) {
                    atkElement1Multiplier = atkData.get(0) * atkData.get(1);
                    atkElement2Multiplier = atkData.get(0) * atkData.get(1);
                } else {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            } else if (monster.getElement1Int() == atkElement.get(1) || monster.getElement2Int() == atkElement.get(1)) {
                atkElement1Multiplier = atkData.get(1);
                atkElement2Multiplier = atkData.get(1);
            }
        }

    }

    private void indian(Monster monster, Team team) {
        //matchElement will be {fire, fire, fire} or something for Krishna
        //comboMin = 2, comboMax = 3 for Krishna. 3/3 for Sarasvati. 3/4 for Zuoh.
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter++;
                    i = -1;
                }
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }
    }

    private void indianFlat(Monster monster, Team team) {
        //matchElement will be {fire, fire, fire} or something for Krishna
        //comboMin = 2, comboMax = 3 for Krishna. 3/3 for Sarasvati. 3/4 for Zuoh.
        //Ruel. atkData {match multiplier, flat multiplier}
        int comboDiff = comboMax - comboMin;
        if (atkType.size() != 0) {
            for (int i = 0; i < atkType.size(); i++) {
                if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        }
        if (atkElement.size() != 0) {
            for (int i = 0; i < atkElement.size(); i++) {
                if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        }
        int counter = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter++;
                    i = -1;
                }
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }
    }

    private void indianOrbPlus(Monster monster, Team team) {
        //Ult Krishna and ult Sarasvati
        //atkData will be {match elements, orb plus multiplier}
        int comboDiff = comboMax - comboMin;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (team.getOrbMatches().get(i).getNumOrbPlus() >= 1 && team.getOrbMatches().get(i).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        }

        int counter = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter++;
                    i = -1;
                }
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }
    }

    private void matchElementOrbPlus(Monster monster, Team team) {
        //Kite
        //atkData will be {match elements, orb plus multiplier}
        int comboDiff = comboMax - comboMin;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (team.getOrbMatches().get(i).getNumOrbPlus() >= 1 && team.getOrbMatches().get(i).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < matchElements.size(); i++) {
            if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                counter++;
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }
    }

    private void comboOrbPlus(Monster monster, Team team, int totalCombos) {
        //Awoken Yomi
        //atkData will be {combo multipliers, orb plus multiplier}
        int comboDiff = comboMax - comboMin;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (team.getOrbMatches().get(i).getNumOrbPlus() >= 1 && team.getOrbMatches().get(i).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        }

        int counter = totalCombos - comboMin;
        if (counter >= comboDiff) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (totalCombos >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter);
            atkElement2Multiplier *= atkData.get(counter);
        }
    }

    private void orbPlusFlat(Monster monster, Team team) {
        //Not Sanada. Wot. Must've been a typo on PADx
        //atkData is {flat, orb plus multiplier
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (team.getOrbMatches().get(i).getNumOrbPlus() >= 1 && team.getOrbMatches().get(i).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement1Multiplier = atkData.get(1);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement2Multiplier = atkData.get(1);
                }
            }
        }
        if (atkElement.size() != 0) {
            int i = 0;
            while (i < atkElement.size()) {
                if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                    atkElement1Multiplier *= atkData.get(0);
                    atkElement2Multiplier *= atkData.get(0);
                    i = atkElement.size() + 1;
                } else {
                    i++;
                }
            }
        }
        if (atkType.size() != 0 && atkElement1Multiplier != atkData.get(0) * atkData.get(1)) {
            int i = 0;
            while (i < atkType.size()) {
                if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                    atkElement1Multiplier *= atkData.get(0);
                    atkElement2Multiplier *= atkData.get(0);
                    i = atkType.size() + 1;
                } else {
                    i++;
                }
            }
        }
    }

    private void active(Monster monster, Team team, int stat) {
        if (team.isActiveSkillUsed()) {
            if (stat == 2) {
                if (atkType.size() != 0) {
                    for (int i = 0; i < atkType.size(); i++) {
                        if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                            atkElement1Multiplier = atkData.get(0);
                            atkElement2Multiplier = atkData.get(0);
                        }
                    }
                }
                if (atkElement.size() != 0) {
                    for (int i = 0; i < atkElement.size(); i++) {
                        if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                            atkElement1Multiplier = atkData.get(0);
                            atkElement2Multiplier = atkData.get(0);
                        }
                    }
                }
            } else if (stat == 3) {
                if (rcvType.size() != 0) {
                    for (int i = 0; i < rcvType.size(); i++) {
                        if (monster.getType1() == rcvType.get(i) || monster.getType2() == rcvType.get(i) || monster.getType3() == rcvType.get(i)) {
                            rcvMultiplier = rcvData.get(0);
                        }
                    }
                }
                if (rcvElement.size() != 0) {
                    for (int i = 0; i < rcvElement.size(); i++) {
                        if (monster.getElement1Int() == rcvElement.get(i) || monster.getElement2Int() == rcvElement.get(i)) {
                            rcvMultiplier = rcvData.get(0);
                        }
                    }
                }
            }
        }
    }

    private void comboAttribute(Monster monster, Team team, int totalCombos) {
        int comboDiff = comboMax - comboMin;
        int counter = totalCombos - comboMin;
        if (counter >= comboDiff) {
            if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                atkElement1Multiplier = atkData.get(comboDiff);
                atkElement2Multiplier = atkData.get(comboDiff);
            }
        }
    }

    private void hpFlat(Monster monster, Team team, int stat) {
        if (stat == 2) {
            if (hpPercent.size() == 1) {
                if (team.getTeamHp() == hpPercent.get(0)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        atkElement1Multiplier = atkData.get(0);
                        atkElement2Multiplier = atkData.get(0);
                    } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
                        atkElement1Multiplier = atkData.get(0);
                        atkElement2Multiplier = atkData.get(0);
                    }
                }
            } else {
                for (int i = 0; i < hpPercent.size() / 2; i++) {
                    if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                        if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                            atkElement1Multiplier = atkData.get(i);
                            atkElement2Multiplier = atkData.get(i);
                        } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                            atkElement1Multiplier = atkData.get(i);
                            atkElement2Multiplier = atkData.get(i);
                        }
                    }
                }
            }
        } else if (stat == 3) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (rcvElement.contains(monster.getElement1Int()) || rcvElement.contains(monster.getElement2Int())) {
                    rcvMultiplier = rcvData.get(0);
                } else if (rcvType.contains(monster.getType1()) || rcvType.contains(monster.getType2())) {
                    rcvMultiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (rcvElement.contains(monster.getElement1Int()) || rcvElement.contains(monster.getElement2Int()) || atkType.contains(monster.getType3())) {
                        if (rcvMultiplier < rcvData.get(i)) {
                            rcvMultiplier = rcvData.get(i);
                        }
                    } else if (rcvType.contains(monster.getType1()) || rcvType.contains(monster.getType2())) {
                        if (rcvMultiplier < rcvData.get(i)) {
                            rcvMultiplier = rcvData.get(i);
                        }
                    }
                }
            }
        }
    }

    private void orbLinkFlat(Monster monster, Team team) {
        //{Combos, flat}
        int comboDiff = comboMax - comboMin;
        if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
            atkElement1Multiplier = atkData.get(comboDiff + 1);
            atkElement2Multiplier = atkData.get(comboDiff + 1);
        } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
            atkElement1Multiplier = atkData.get(comboDiff + 1);
            atkElement2Multiplier = atkData.get(comboDiff + 1);
        }

        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (counter < team.getOrbMatches().get(i).getOrbsLinked()) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }
    }

    private void comboExact(Monster monster, Team team, int totalCombos) {
        if (totalCombos == comboMin) {
            atkElement1Multiplier = atkData.get(0);
            atkElement2Multiplier = atkData.get(0);
        }
    }

    private void orbLinkIndian(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (counter < team.getOrbMatches().get(i).getOrbsLinked()) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }

        int comboDiff2 = comboMax2 - comboMin2;
        int counter2 = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements2.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements2.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter2++;
                    i = -1;
                }
            }
        }

        if (counter2 >= comboMax2) {
            atkElement1Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
        } else if (counter2 >= comboMin2) {
            atkElement1Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
        }
    }

    private void flatHpFlat(Monster monster, Team team) {
        //{HP flats, flat}
        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    }
                }
            }
        }
        if (atkElement1Multiplier < atkDataMax() * atkData.get(hpPercent.size() / 2)) {
            if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                atkElement1Multiplier *= atkData.get(hpPercent.size() / 2);
            } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                atkElement1Multiplier *= atkData.get(hpPercent.size() / 2);
            }
        }
        if (atkElement2Multiplier < atkDataMax() * atkData.get(hpPercent.size() / 2)) {
            if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                atkElement2Multiplier *= atkData.get(hpPercent.size() / 2);
            } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                atkElement2Multiplier *= atkData.get(hpPercent.size() / 2);
            }
        }

    }

    private void flatAttributeActiveAttribute(Monster monster, Team team) {
        //All attributes on the active skill used so yea. Cheating.
        if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
            atkElement1Multiplier = atkData.get(0);
            atkElement2Multiplier = atkData.get(0);
        }
        if (team.isActiveSkillUsed()) {
            if (atkElement2.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                atkElement1Multiplier *= atkData.get(1);
                atkElement2Multiplier *= atkData.get(1);
            }
        }
    }

    private void flatTypeFlatAttribute(Monster monster, Team team) {
        if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
            atkElement1Multiplier = atkData.get(1);
            atkElement2Multiplier = atkData.get(1);
        }
        if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
            atkElement1Multiplier *= atkData.get(0);
            atkElement2Multiplier *= atkData.get(0);
        }
    }

    private void hpFlatAttributeFlatType(Monster monster, Team team) {
        //Goemon Ult
        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        if (atkElement1Multiplier < atkData.get(i)) {
                            atkElement1Multiplier = atkData.get(i);
                        }
                        if (atkElement2Multiplier < atkData.get(i)) {
                            atkElement2Multiplier = atkData.get(i);
                        }
                    }
                }
            }
        }
        if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
            atkElement1Multiplier *= atkData.get(hpPercent.size() / 2);
            atkElement2Multiplier *= atkData.get(hpPercent.size() / 2);
        }
    }

    private void flatTypeActiveAttribute(Monster monster, Team team) {
        if (team.isActiveSkillUsed()) {
            if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                atkElement1Multiplier = atkData.get(1);
                atkElement2Multiplier = atkData.get(1);
            }
        }
        if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
            atkElement1Multiplier *= atkData.get(0);
            atkElement2Multiplier *= atkData.get(0);
        }
    }

    private void orbLinkExactFlat(Monster monster, Team team) {
        if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
            atkElement1Multiplier = atkData.get(1);
            atkElement2Multiplier = atkData.get(1);
        } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
            atkElement1Multiplier = atkData.get(1);
            atkElement2Multiplier = atkData.get(1);
        }
        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (team.getOrbMatches().get(i).getOrbsLinked() == comboMin) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter == comboMin) {
            atkElement1Multiplier *= atkData.get(0);
            atkElement2Multiplier *= atkData.get(0);
        }
    }

    private void orbLinkExact(Monster monster, Team team) {
        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (team.getOrbMatches().get(i).getOrbsLinked() == comboMin) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter == comboMin) {
            atkElement1Multiplier = atkData.get(0);
            atkElement2Multiplier = atkData.get(0);
        }
    }

    private void orbLinkOrbPlus(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (counter < team.getOrbMatches().get(i).getOrbsLinked()) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (team.getOrbMatches().get(i).getNumOrbPlus() >= 1 && team.getOrbMatches().get(i).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement1Multiplier *= atkData.get(comboDiff + 1);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement2Multiplier *= atkData.get(comboDiff + 1);
                }
            }
        }
    }

    private void matchElementOrbLink(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < matchElements.size(); i++) {
            if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                counter++;
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }

        int comboDiff2 = comboMax2 - comboMin2;
        int counter2 = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements2.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements2.get(j))) {
                    if (counter2 < team.getOrbMatches().get(i).getOrbsLinked()) {
                        counter2 = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter2 >= comboMax2) {
            atkElement1Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
        } else if (counter2 >= comboMin2) {
            atkElement1Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
        }
    }

    private void flatTypeFlatType(Monster monster, Team team) {
        if (atkType.size() != 0) {
            for (int i = 0; i < atkType.size(); i++) {
                if (monster.getTypes().contains(atkType.get(i))) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        }
        if (atkType2.size() != 0) {
            for (int i = 0; i < atkType2.size(); i++) {
                if (monster.getTypes().contains(atkType.get(i))) {
                    atkElement1Multiplier *= atkData.get(1);
                    atkElement2Multiplier *= atkData.get(1);
                }
            }
        }
    }

    private void hpFlatOrbPlus(Monster monster, Team team) {
        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    }
                }
            }
        }
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (team.getOrbMatches().get(i).getNumOrbPlus() >= 1 && team.getOrbMatches().get(i).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement1Multiplier *= atkData.get(atkData.size() - 1);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(i).getElement())) {
                    atkElement2Multiplier *= atkData.get(atkData.size() - 1);
                }
            }
        }
    }

    public void hpFlatMatchElement(Monster monster, Team team) {
        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    }
                }
            }
        }

        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < matchElements.size(); i++) {
            if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                counter++;
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff + hpPercent.size() / 2);
            atkElement2Multiplier *= atkData.get(comboDiff + hpPercent.size() / 2);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin + hpPercent.size() / 2);
            atkElement2Multiplier *= atkData.get(counter - comboMin + hpPercent.size() / 2);
        }

    }

    public void hpFlatActive(Monster monster, Team team) {
        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    }
                }
            }
        }

        if (team.isActiveSkillUsed()) {
            if (atkType.size() != 0) {
                for (int i = 0; i < atkType.size(); i++) {
                    if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                        atkElement1Multiplier *= atkData.get(atkData.size() - 1);
                        atkElement2Multiplier *= atkData.get(atkData.size() - 1);
                    }
                }
            }
            if (atkElement.size() != 0) {
                for (int i = 0; i < atkElement.size(); i++) {
                    if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                        atkElement1Multiplier *= atkData.get(atkData.size() - 1);
                        atkElement2Multiplier *= atkData.get(atkData.size() - 1);
                    }
                }
            }
        }
    }

    private void orbLinkActive(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (counter < team.getOrbMatches().get(i).getOrbsLinked()) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }
        if (team.isActiveSkillUsed()) {
            if (atkElement.size() != 0) {
                for (int i = 0; i < atkElement.size(); i++) {
                    if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                        atkElement1Multiplier *= atkData.get(atkData.size() - 1);
                        atkElement2Multiplier *= atkData.get(atkData.size() - 1);
                    }
                }
            }
        }
    }

    private void hpFlatAttributeFlatAttribute(Monster monster, Team team) {
        //Dmeta
        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        if (atkElement1Multiplier < atkData.get(i)) {
                            atkElement1Multiplier = atkData.get(i);
                        }
                        if (atkElement2Multiplier < atkData.get(i)) {
                            atkElement2Multiplier = atkData.get(i);
                        }
                    }
                }
            }
        }
        if (atkElement2.contains(monster.getElement1Int()) || atkElement2.contains(monster.getElement2Int())) {
            atkElement1Multiplier *= atkData.get(hpPercent.size() / 2);
            atkElement2Multiplier *= atkData.get(hpPercent.size() / 2);
        }
    }

    private void indianActive(Monster monster, Team team) {
        //Awoken Sun Quan
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        if (team.isActiveSkillUsed()) {
            if (atkType.size() != 0) {
                for (int i = 0; i < atkType.size(); i++) {
                    if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                        atkElement1Multiplier = atkData.get(comboDiff + 1);
                        atkElement2Multiplier = atkData.get(comboDiff + 1);
                    }
                }
            }
            if (atkElement.size() != 0) {
                for (int i = 0; i < atkElement.size(); i++) {
                    if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                        atkElement1Multiplier = atkData.get(comboDiff + 1);
                        atkElement2Multiplier = atkData.get(comboDiff + 1);
                    }
                }
            }
        }
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter++;
                    i = -1;
                }
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }
    }

    private void heartCross(Monster monster, Team team) {
        Boolean matched = false;
        int i = 0;
        while (!matched) {
            if (team.getOrbMatches().get(i).getElement() == Element.HEART) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                    matched = true;
                }
            }
            i++;
            if (i == team.getOrbMatches().size()) {
                break;
            }
        }
    }

    private void comboIndian(Monster monster, Team team, int totalCombos) {
        int comboDiff = comboMax - comboMin;
        int counter = totalCombos - comboMin;
        if (counter >= comboDiff) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (totalCombos >= comboMin) {
            atkElement1Multiplier = atkData.get(counter);
            atkElement2Multiplier = atkData.get(counter);
        }

        int comboDiff2 = comboMax2 - comboMin2;
        int counter2 = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements2.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements2.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter2++;
                    i = -1;
                }
            }
        }

        if (counter2 >= comboMax2) {
            atkElement1Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(comboDiff2 + comboDiff + 1);
        } else if (counter2 >= comboMin2) {
            atkElement1Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
            atkElement2Multiplier *= atkData.get(counter2 - comboMin2 + comboDiff + 1);
        }

    }

    private void orbLinkHpFlat(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
                    atkElement1Multiplier = atkData.get(comboDiff + 1);
                    atkElement2Multiplier = atkData.get(comboDiff + 1);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        atkElement1Multiplier = atkData.get(comboDiff + 1 + i);
                        atkElement2Multiplier = atkData.get(comboDiff + 1 + i);
                    } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                        atkElement1Multiplier = atkData.get(comboDiff + 1 + i);
                        atkElement2Multiplier = atkData.get(comboDiff + 1 + i);
                    }
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            for (int j = 0; j < matchElements.size(); j++) {
                if (team.getOrbMatches().get(i).getElement().equals(matchElements.get(j))) {
                    if (counter < team.getOrbMatches().get(i).getOrbsLinked()) {
                        counter = team.getOrbMatches().get(i).getOrbsLinked();
                    }
                }
            }

        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }
    }

    private void orbPlusHeartCross(Monster monster, Team team) {
        Boolean matched = false;
        int i = 0;
        while (!matched) {
            if (team.getOrbMatches().get(i).getElement() == Element.HEART) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier = atkData.get(1);
                    atkElement2Multiplier = atkData.get(1);
                    matched = true;
                }
            }
            i++;
            if (i == team.getOrbMatches().size()) {
                break;
            }
        }
        for (int j = 0; j < team.getOrbMatches().size(); j++) {
            if (team.getOrbMatches().get(j).getNumOrbPlus() >= 1 && team.getOrbMatches().get(j).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(j).getElement())) {
                    atkElement1Multiplier *= atkData.get(0);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(j).getElement())) {
                    atkElement2Multiplier *= atkData.get(0);
                }
            }
        }
    }

    private void indianHeartCross(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter++;
                    i = -1;
                }
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }

        Boolean matched = false;
        int i = 0;
        while (!matched) {
            if (team.getOrbMatches().get(i).getElement() == Element.HEART) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier *= atkData.get(comboDiff + 1);
                    atkElement2Multiplier *= atkData.get(comboDiff + 1);
                    matched = true;
                }
            }
            i++;
            if (i == team.getOrbMatches().size()) {
                break;
            }
        }
    }

    private void flatHeartCross(Monster monster, Team team) {
        if (atkType.size() != 0) {
            for (int i = 0; i < atkType.size(); i++) {
                if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        }
        if (atkElement.size() != 0) {
            for (int i = 0; i < atkElement.size(); i++) {
                if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        }

        Boolean matched = false;
        int i = 0;
        while (!matched) {
            if (team.getOrbMatches().get(i).getElement() == Element.HEART) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier *= atkData.get(1);
                    atkElement2Multiplier *= atkData.get(1);
                    matched = true;
                }
            }
            i++;
            if (i == team.getOrbMatches().size()) {
                break;
            }
        }
    }

    private void matchElementHeartCross(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        for (int i = 0; i < matchElements.size(); i++) {
            if (team.getOrbMatchElements().contains(matchElements.get(i))) {
                counter++;
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier *= atkData.get(comboDiff);
            atkElement2Multiplier *= atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier *= atkData.get(counter - comboMin);
            atkElement2Multiplier *= atkData.get(counter - comboMin);
        }

        Boolean matched = false;
        int i = 0;
        while (!matched) {
            if (team.getOrbMatches().get(i).getElement() == Element.HEART) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier *= atkData.get(comboDiff + 1);
                    atkElement2Multiplier *= atkData.get(comboDiff + 1);
                    matched = true;
                }
            }
            i++;
            if (i == team.getOrbMatches().size()) {
                break;
            }
        }
    }

    private void activeHeartCross(Monster monster, Team team) {
        if (team.isActiveSkillUsed()) {
            if (atkType.size() != 0) {
                for (int i = 0; i < atkType.size(); i++) {
                    if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                        atkElement1Multiplier = atkData.get(0);
                        atkElement2Multiplier = atkData.get(0);
                    }
                }
            }
            if (atkElement.size() != 0) {
                for (int i = 0; i < atkElement.size(); i++) {
                    if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                        atkElement1Multiplier = atkData.get(0);
                        atkElement2Multiplier = atkData.get(0);
                    }
                }
            }
        }

        Boolean matched = false;
        int i = 0;
        while (!matched) {
            if (team.getOrbMatches().get(i).getElement() == Element.HEART) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier *= atkData.get(1);
                    atkElement2Multiplier *= atkData.get(1);
                    matched = true;
                }
            }
            i++;
            if (i == team.getOrbMatches().size()) {
                break;
            }
        }
    }

    private void indianMonsterConditional(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter++;
                    i = -1;
                }
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }

        int counter2 = 0;
        for (int i = 0; i < matchMonsters.size(); i++) {
            if (team.getBaseMonsterId().contains(matchMonsters.get(i))) {
                counter2++;
            }
        }
        if (counter2 == matchMonsters.size()) {
            atkElement1Multiplier *= atkData.get(comboDiff + 1);
            atkElement2Multiplier *= atkData.get(comboDiff + 1);
        }
    }

    private void orbPlusMonsterConditional(Monster monster, Team team) {
        int counter = 0;
        for (int i = 0; i < matchMonsters.size(); i++) {
            if (team.getBaseMonsterId().contains(matchMonsters.get(i))) {
                counter++;
            }
        }
        if (counter == matchMonsters.size()) {
            atkElement1Multiplier = atkData.get(1);
            atkElement2Multiplier = atkData.get(1);
        }
        for (int j = 0; j < team.getOrbMatches().size(); j++) {
            if (team.getOrbMatches().get(j).getNumOrbPlus() >= 1 && team.getOrbMatches().get(j).getOrbsLinked() == 5) {
                if (monster.getElement1().equals(team.getOrbMatches().get(j).getElement())) {
                    atkElement1Multiplier *= atkData.get(0);
                }
                if (monster.getElement2().equals(team.getOrbMatches().get(j).getElement())) {
                    atkElement2Multiplier *= atkData.get(0);
                }
            }
        }
    }

    private void cross(Monster monster, Team team) {
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (matchElements.contains(team.getOrbMatches().get(i).getElement())) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier *= atkData.get(0);
                    atkElement2Multiplier *= atkData.get(0);
                }
            }
        }
    }

    private void indianCross(Monster monster, Team team) {
        int comboDiff = comboMax - comboMin;
        int counter = 0;
        ArrayList<Element> orbMatchElements = team.getAllOrbMatchElements();
        for (int i = 0, j = 0; j < matchElements.size(); i++) {
            if (i == orbMatchElements.size()) {
                j++;
                i = -1;
            } else {
                if (orbMatchElements.get(i).equals(matchElements.get(j))) {
                    orbMatchElements.remove(i);
                    j++;
                    counter++;
                    i = -1;
                }
            }
        }
        if (counter >= comboMax) {
            atkElement1Multiplier = atkData.get(comboDiff);
            atkElement2Multiplier = atkData.get(comboDiff);
        } else if (counter >= comboMin) {
            atkElement1Multiplier = atkData.get(counter - comboMin);
            atkElement2Multiplier = atkData.get(counter - comboMin);
        }

        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (matchElements.contains(team.getOrbMatches().get(i).getElement())) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier *= atkData.get(comboDiff + 1);
                    atkElement2Multiplier *= atkData.get(comboDiff + 1);
                }
            }
        }
    }

    private void activeCross(Monster monster, Team team) {
        if (team.isActiveSkillUsed()) {
            if (atkType.size() != 0) {
                for (int i = 0; i < atkType.size(); i++) {
                    if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                        atkElement1Multiplier *= atkData.get(0);
                        atkElement2Multiplier *= atkData.get(0);
                    }
                }
            }
            if (atkElement.size() != 0) {
                for (int i = 0; i < atkElement.size(); i++) {
                    if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                        atkElement1Multiplier *= atkData.get(0);
                        atkElement2Multiplier *= atkData.get(0);
                    }
                }
            }
        }
        for (int i = 0; i < team.getOrbMatches().size(); i++) {
            if (matchElements.contains(team.getOrbMatches().get(i).getElement())) {
                if (team.getOrbMatches().get(i).isCross()) {
                    atkElement1Multiplier *= atkData.get(1);
                    atkElement2Multiplier *= atkData.get(1);
                }
            }
        }
    }

    private void coopHpFlat(Monster monster, Team team) {

        if (hpPercent.size() == 1) {
            if (team.getTeamHp() == hpPercent.get(0)) {
                if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2())) {
                    atkElement1Multiplier = atkData.get(0);
                    atkElement2Multiplier = atkData.get(0);
                }
            }
        } else {
            for (int i = 0; i < hpPercent.size() / 2; i++) {
                if (team.getTeamHp() <= hpPercent.get(0 + 2 * i) && team.getTeamHp() >= hpPercent.get(1 + 2 * i)) {
                    if (atkElement.contains(monster.getElement1Int()) || atkElement.contains(monster.getElement2Int())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    } else if (atkType.contains(monster.getType1()) || atkType.contains(monster.getType2()) || atkType.contains(monster.getType3())) {
                        atkElement1Multiplier = atkData.get(i);
                        atkElement2Multiplier = atkData.get(i);
                    }
                }
            }
        }

        if (Singleton.getInstance().isCoopEnable()) {
            atkElement1Multiplier *= atkData.get(atkData.size() - 1);
            atkElement2Multiplier *= atkData.get(atkData.size() - 1);
        }
    }

    private void coopFlat(Monster monster, Team team) {
        if (atkType.size() != 0) {
            for (int i = 0; i < atkType.size(); i++) {
                if (monster.getType1() == atkType.get(i) || monster.getType2() == atkType.get(i) || monster.getType3() == atkType.get(i)) {
                    atkElement1Multiplier *= atkData.get(0);
                    atkElement2Multiplier *= atkData.get(0);
                    break;
                }
            }
        }
        if (atkElement.size() != 0) {
            for (int i = 0; i < atkElement.size(); i++) {
                if (monster.getElement1Int() == atkElement.get(i) || monster.getElement2Int() == atkElement.get(i)) {
                    atkElement1Multiplier *= atkData.get(0);
                    atkElement2Multiplier *= atkData.get(0);
                    break;
                }
            }
        }

        if (Singleton.getInstance().isCoopEnable()) {
            atkElement1Multiplier *= atkData.get(atkData.size() - 1);
            atkElement2Multiplier *= atkData.get(atkData.size() - 1);
        }
    }

    private void coop(Monster monster, Team team, int stat){
        if(Singleton.getInstance().isCoopEnable()){
            if(stat == 2){
                atkElement1Multiplier *= atkData.get(0);
                atkElement2Multiplier *= atkData.get(0);
            } else if (stat == 3){
                rcvMultiplier = rcvData.get(0);
            }
        }
    }

    private double atkDataMax() {
        double max = 1;
        for (int i = 0; i < atkData.size(); i++) {
            if (i == 0) {
                max = atkData.get(i);
            } else if (atkData.get(i) > atkData.get(i - 1)) {
                max = atkData.get(i);
            }
        }
        return max;
    }

    public static List<Monster> getAllLeaderSkills() {
        return new Select().from(LeaderSkill.class).execute();
    }

    public static LeaderSkill getLeaderSkill(String name) {
        return new Select().from(LeaderSkill.class).where("name = ?", name).executeSingle();
    }

}
