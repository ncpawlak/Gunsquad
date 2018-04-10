package com.example.rapturedshadows.gunsquad;

import java.io.Serializable;

/**
 * Created by RapturedShadows on 11/13/16.
 */

public class Armor implements Serializable{
    protected String name;
    protected int defense, speed;
    protected int iconID;
    protected int price;

    public String getName() {return name;}
    public int getDefense() {return defense;}
    public int getSpeed() {return speed;}
    public int getIconID() {return iconID;}
    public int getPrice() {return price;}

    Armor() {
        name = "None";
        defense = 0;
        speed = 0;
        price = 0;
    }
}
