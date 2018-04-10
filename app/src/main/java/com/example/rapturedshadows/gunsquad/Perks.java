package com.example.rapturedshadows.gunsquad;

import java.io.Serializable;

/**
 * Created by RapturedShadows on 11/29/16.
 */

public class Perks implements Serializable {
    protected String name;
    protected String description;
    protected int price;
    protected int iconID;
    protected int typeID;

    public String getName() {return name;}
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public int getIconID(){return iconID;}
    public int getTypeID() {return typeID;}
}
