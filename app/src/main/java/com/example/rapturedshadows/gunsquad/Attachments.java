package com.example.rapturedshadows.gunsquad;

import java.io.Serializable;

/**
 * Created by RapturedShadows on 12/15/16.
 */

public class Attachments implements Serializable {
    Attachments() {
        damage = 0;
        accuracy = 0;
        name = "  ";
        price = 0;
    }
    protected int damage, accuracy;
    protected String name;
    protected int price;
    protected int iconID;
    protected int typeID;

    public int getDamage() {return damage;}
    public int getAccuracy() {return accuracy;}
    public String getName() {return name;}
    public int getPrice() {return price;}
    public int getIconID() {return iconID;}
    public int getTypeID() {return typeID;}

    public void clear() {
        damage = 0;
        accuracy = 0;
        name = "";
    }
}
