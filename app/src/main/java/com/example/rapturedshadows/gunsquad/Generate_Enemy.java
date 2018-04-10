package com.example.rapturedshadows.gunsquad;

import java.util.Random;

/**
 * Created by RapturedShadows on 12/10/16.
 */

public class Generate_Enemy {
    private int playerLevel;
    playerScreen p = new playerScreen();
    private int damage, speed, accuracy, defense;


    public void generateStats() {
        playerLevel = p.getMissionNumber();
        Random r = new Random();
        damage = r.nextInt(playerLevel*7) + (r.nextInt(12) + 4);
        speed = r.nextInt(playerLevel*7) + (r.nextInt(12) + 4);
        accuracy = r.nextInt(playerLevel*7) + (r.nextInt(12) + 4);
        defense = r.nextInt(playerLevel*7) + (r.nextInt(10) + 4);
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

    public int getDefense() {
        return defense;
    }
}
