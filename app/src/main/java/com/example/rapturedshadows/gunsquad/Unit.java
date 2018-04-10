package com.example.rapturedshadows.gunsquad;

import android.widget.Toast;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by RapturedShadows on 11/13/16.
 */

public class Unit implements Serializable{
    public Unit() {
        name = "None";
        generateStats();
        primary = startingPrimary;
        secondary = startingSecondary;
        totalUpStats();
        nextLevelXP = 10;
    }

    public Unit(String n) {
        name = n;
        generateStats();
        primary = startingPrimary;
        secondary = startingSecondary;
        totalUpStats();
        nextLevelXP = 10;
    }

    Random random = new Random();
    private M4 startingPrimary = new M4();
    private M9 startingSecondary = new M9();
    private String name;
    private int level=1;
    private int bareDefense, bareDamage, bareSpeed, bareAccuracy, bareHealth, temporaryHealth;
    private int defense, damage, speed, accuracy, health;
    private Gun primary = new Gun();
    private Gun secondary = new Gun();
    private int unitXP, nextLevelXP;
    private boolean alive = true;

    private Armor chest = new Armor(), shoulders = new Armor(), forearms = new Armor(),
            legs = new Armor(), helmet = new Helmets();
    private int iconID=R.drawable.pic;
    private boolean canUsePrimary=false;


    public int getIconID() {
        return iconID;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String s) {
        name = s;
    }
    public int getLevel() {
        return level;
    }
    public int getBareDefense() {
        return bareDefense;
    }
    public int getBareDamage() {
        return bareDamage;
    }
    public int getBareSpeed() {
        return bareSpeed;
    }
    public int getBareAccuracy() {
        return bareAccuracy;
    }
    public int getBareHealth() {
        return bareHealth;
    }
    public int getTemporaryHealth() {
        return temporaryHealth;
    }
    public int getDefense() {
        return defense;
    }
    public int getDamage() {
        return damage;
    }
    public int getSpeed() {
        return speed;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getHealth() {
        return health;
    }
    public Gun getPrimary() {
        return primary;
    }
    public void setPrimary(Gun g){primary = g;}
    public Gun getSecondary() {
        return secondary;
    }
    public void setSecondary(Gun g){secondary = g;}
    public Armor getChest() {
        return chest;
    }
    public Armor getShoulders() {
        return shoulders;
    }
    public Armor getForearms() {
        return forearms;
    }
    public Armor getLegs() {
        return legs;
    }
    public Armor getHelmet() {
        return helmet;
    }
    public void CanUseAsPrimary(){canUsePrimary=true;}
    public boolean ifCanUseAsPrimary(){return canUsePrimary;}
    public int getUnitXP() {return unitXP;}
    public int getNextLevelXP() {return nextLevelXP;}

    public void generateStats() {
        bareDamage = 5;
        bareAccuracy = 5;
        bareDefense = 5;
        bareHealth = 10;
        temporaryHealth = bareHealth;
        bareSpeed = 5;
        primary.totalUpStats();
        secondary.totalUpStats();
        totalUpStats();
    }

    public void totalUpStats() {
        damage = 0;
        accuracy = 0;
        defense = 0;
        health = 0;
        speed = 0;
        //primary.totalUpStats();
        //secondary.totalUpStats();
        damage = bareDamage + primary.getDamage() + secondary.getDamage();
        accuracy = bareAccuracy + primary.getAccuracy() + secondary.getAccuracy();
        defense = bareDefense;
        health = bareHealth;
        speed = bareSpeed + primary.getSpeed() + secondary.getSpeed();
    }

    public void increaseXP(int xp){
        unitXP = unitXP + xp;
        if (unitXP >= nextLevelXP)
            levelUp();
    }

    public void levelUp() {
        level++;
        if (unitXP >= nextLevelXP)
            unitXP = unitXP - nextLevelXP;
        else
            unitXP = 0;
        nextLevelXP = nextLevelXP + (level+15);

        bareDamage += 3;
        bareAccuracy += 3;
        bareDefense += 3;
        bareHealth += 3;
        health += 3;
        temporaryHealth = bareHealth;
        bareSpeed += 3;
        totalUpStats();
    }

    public void setHealthAfterMission(int i){
        temporaryHealth = temporaryHealth - i;
        if (temporaryHealth <= 0){
            alive = false;
        }

    }

    public boolean died() {
        if (!alive)
            return true;
        else
            return false;
    }

    public void clear() {
        name = "KIA";
        defense = 0;
        damage = 0;
        speed = 0;
        accuracy = 0;
        health = 0;
        temporaryHealth = 0;
        bareDefense = 0;
        bareDamage = 0;
        bareSpeed = 0;
        bareAccuracy = 0;
        bareHealth = 0;
        level = 0;
        primary.clear();
        secondary.clear();
    }

    public void increaseHPAfterMission() {
        temporaryHealth = temporaryHealth + 3;
        if (temporaryHealth >= health)
            temporaryHealth = health;
    }

    public void setPrimaryAttachment(Attachments a, int i){
        switch (i){
            case 1:
                primary.setBarrel(a);
                damage = damage + primary.getBarrel().getDamage();
                accuracy = accuracy + primary.getBarrel().getAccuracy();
                break;
            case 2:
                primary.setScope(a);
                damage = damage + primary.getScope().getDamage();
                accuracy = accuracy + primary.getScope().getAccuracy();
                break;
            case 3:
                primary.setClip(a);
                damage = damage + primary.getClip().getDamage();
                accuracy = accuracy + primary.getClip().getAccuracy();
                break;
            case 4:
                primary.setAccessory(a);
                damage = damage + primary.getAccessory().getDamage();
                accuracy = accuracy + primary.getAccessory().getAccuracy();
                break;
            case 5:
                primary.setGrip(a);
                damage = damage + primary.getGrip().getDamage();
                accuracy = accuracy + primary.getGrip().getAccuracy();
                break;
            default:
                break;
        }
    }

    public void setSecondaryAttachment(Attachments a, int i){
        switch (i){
            case 1:
                secondary.setBarrel(a);
                damage = damage + secondary.getBarrel().getDamage();
                accuracy = accuracy + secondary.getBarrel().getAccuracy();
                break;
            case 2:
                secondary.setScope(a);
                damage = damage + secondary.getScope().getDamage();
                accuracy = accuracy + secondary.getScope().getAccuracy();
                break;
            case 3:
                secondary.setClip(a);
                damage = damage + secondary.getClip().getDamage();
                accuracy = accuracy + secondary.getClip().getAccuracy();
                break;
            case 4:
                secondary.setAccessory(a);
                damage = damage + secondary.getAccessory().getDamage();
                accuracy = accuracy + secondary.getAccessory().getAccuracy();
                break;
            case 5:
                secondary.setGrip(a);
                damage = damage + secondary.getGrip().getDamage();
                accuracy = accuracy + secondary.getGrip().getAccuracy();
                break;
            default:
                break;
        }
    }

    public void determinePerk(int i){
        switch (i){
            case 1:
                canUsePrimary = true;
                break;
            case 2:
                bareSpeed = bareSpeed + 30;
                totalUpStats();
                break;
            case 3:
                bareAccuracy = bareAccuracy + 25;
                totalUpStats();
                break;
            default:
                break;
        }
    }

}
