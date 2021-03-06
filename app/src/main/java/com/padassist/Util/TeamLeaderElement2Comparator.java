package com.padassist.Util;

import com.padassist.Data.Team;

import java.util.Comparator;

/**
 * Created by DragonLotus on 10/4/2015.
 */
public class TeamLeaderElement2Comparator implements Comparator<Team> {
    @Override
    public int compare(Team lhs, Team rhs) {
        if (lhs.getLead().getMonsterId() == 0){
            return -1;
        }else if (rhs.getLead().getMonsterId() == 0){
            return 1;
        }else if (lhs.getLead().getElement2Int() == -1 && rhs.getLead().getElement2Int() == -1){
            if (lhs.getLead().getRarity() < rhs.getLead().getRarity()) {
                return 1;
            } else if (lhs.getLead().getRarity() == rhs.getLead().getRarity()) {
                if(lhs.getLead().getElement1Int() > rhs.getLead().getElement1Int()){
                    return 1;
                } else if (lhs.getLead().getElement1Int() == rhs.getLead().getElement2Int()){
                    if (lhs.getLead().getRarity() < rhs.getLead().getRarity()) {
                        return 1;
                    } else if (lhs.getLead().getRarity() == rhs.getLead().getRarity()) {
                        if (lhs.getLead().getBaseMonsterId() > rhs.getLead().getBaseMonsterId()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }else if (lhs.getLead().getElement2Int() == -1){
            return 1;
        }else if (rhs.getLead().getElement2Int() == -1){
            return -1;
        }else {
            if (lhs.getLead().getElement2Int() > rhs.getLead().getElement2Int()) {
                return 1;
            } else if (lhs.getLead().getElement2Int() == rhs.getLead().getElement2Int()) {
                if (lhs.getLead().getRarity() < rhs.getLead().getRarity()) {
                    return 1;
                } else if (lhs.getLead().getRarity() == rhs.getLead().getRarity()) {
                    if(lhs.getLead().getElement1Int() > rhs.getLead().getElement1Int()){
                        return 1;
                    } else if (lhs.getLead().getElement1Int() == rhs.getLead().getElement2Int()){
                        if (lhs.getLead().getRarity() < rhs.getLead().getRarity()) {
                            return 1;
                        } else if (lhs.getLead().getRarity() == rhs.getLead().getRarity()) {
                            if (lhs.getLead().getBaseMonsterId() > rhs.getLead().getBaseMonsterId()) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
