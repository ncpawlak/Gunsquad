package com.example.rapturedshadows.gunsquad;

/**
 * Created by RapturedShadows on 11/29/16.
 */

public class Perk_Specialist extends Perks {
    Perk_Specialist() {
        //make it so canUsePrimary boolean is true
        name = "Specialist";
        typeID = 1;
        description = "Soldier can carry any weapon in the secondary slot.";
        price = 1200;
        iconID = R.drawable.acr;
    }
}
