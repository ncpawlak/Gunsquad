package com.example.rapturedshadows.gunsquad;

import java.io.Serializable;

/**
 * Created by RapturedShadows on 11/13/16.
 */

public class Gun implements Serializable {
    Gun(){
        baseDamage = damage;
        baseAccuracy = accuracy;
        baseSpeed = speed;
    }

    protected String name;
    protected int damage, accuracy, speed;
    protected int baseDamage, baseAccuracy, baseSpeed;
    protected int iconID;
    protected int price;
    protected int gunID;
    protected Attachments grip = new Attachments(), clip = new Attachments(),
            accessory = new Attachments(), barrel = new Attachments(), scope = new Attachments();

    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getSpeed() {
        return speed;
    }
    public int getIconID() {return iconID;}
    public int getPrice() {return price;}
    public int getGunID() {return gunID;}

    public void clear() {
        speed = 0;
        accuracy = 0;
        damage = 0;
        name = "";
        grip.clear();
        clip.clear();
        accessory.clear();
        barrel.clear();
        scope.clear();
    }

    public void totalUpStats(){
        damage = damage + barrel.getDamage() + accessory.getDamage() + clip.getDamage();
        accuracy = accuracy + scope.getAccuracy() + barrel.getAccuracy() + grip.getAccuracy() + accessory.getAccuracy();
    }

    public Attachments getGrip() {
        return grip;
    }

    public void setGrip(Attachments g) {
        damage = damage-grip.getDamage();
        accuracy=accuracy-grip.getAccuracy();
        this.grip = g;
        damage = damage+g.getDamage();
        accuracy=accuracy+g.getAccuracy();
    }

    public Attachments getClip() {
        return clip;
    }

    public void setClip(Attachments c) {
        damage = damage-clip.getDamage();
        accuracy=accuracy-clip.getAccuracy();
        this.clip = c;
        damage = damage+c.getDamage();
        accuracy=accuracy+c.getAccuracy();
    }

    public Attachments getAccessory() {
        return accessory;
    }

    public void setAccessory(Attachments a) {
        damage = damage-accessory.getDamage();
        accuracy=accuracy-accessory.getAccuracy();
        this.accessory = a;
        damage = damage+a.getDamage();
        accuracy=accuracy+a.getAccuracy();
    }

    public Attachments getBarrel() {
        return barrel;
    }

    public void setBarrel(Attachments b) {
        damage = damage - barrel.getDamage();
        accuracy=accuracy-barrel.getAccuracy();
        this.barrel = b;
        damage = damage+b.getDamage();
        accuracy=accuracy+b.getAccuracy();
    }

    public Attachments getScope() {
        return scope;
    }

    public void setScope(Attachments s) {
        damage = damage-scope.getDamage();
        accuracy=accuracy-scope.getAccuracy();
        this.scope = s;
        damage = damage+s.getDamage();
        accuracy=accuracy+s.getAccuracy();
    }
}
