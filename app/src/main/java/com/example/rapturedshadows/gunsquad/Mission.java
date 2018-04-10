package com.example.rapturedshadows.gunsquad;


import android.media.Image;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by RapturedShadows on 11/13/16.
 */

public class Mission {
    protected String name;
    protected String description1;
    protected int background;

    public String getDescription2() {
        return description2;
    }

    public String getDescription3() {
        return description3;
    }

    public String getDescription4() {
        return description4;
    }

    public String getADescription(int i) {
        switch (i){
            case 1:
                return description1;
            case 2:
                return description2;
            case 3:
                return description3;
            case 4:
                return description4;
            default:
                return description1;
        }
    }

    protected String description2;
    protected String description3;
    protected String description4;
    protected int missionNumber;
    protected int missionAmountNumber;
    protected int amtOfMoney;
    protected int amtOfXP;

    public int getAmtOfXP() {
        return amtOfXP;
    }

    public int getAmtOfMoney() {
        return amtOfMoney;
    }

    public String getName() {
        return name;
    }

    public String getDescription1() {
        return description1;
    }

    public int getMissionNumber() {
        return missionNumber;
    }

    public int getMissionAmountNumber() {
        return missionAmountNumber;
    }

    public int getBackground() {return background;}
}
