package com.example.rapturedshadows.gunsquad;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.StringBuilderPrinter;
import android.widget.TextView;

public class armorofunit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armorofunit);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        final Unit soldier = (Unit)getIntent().getSerializableExtra("Unit");

        TextView name = (TextView)findViewById(R.id.soldiername);
        name.setText(soldier.getName());

        TextView health = (TextView)findViewById(R.id.health);
        health.setText(soldier.getTemporaryHealth()+"/"+soldier.getHealth());

        TextView level = (TextView)findViewById(R.id.soldierlevel);
        level.setText("Level: "+String.valueOf(soldier.getLevel()));

        TextView helmet = (TextView)findViewById(R.id.helmet);
        helmet.setText("Helmet: " + String.valueOf(soldier.getHelmet().getName()));

        TextView shoulders = (TextView)findViewById(R.id.shoulders);
        shoulders.setText("Shoulder Armor: " + String.valueOf(soldier.getShoulders().getName()));

        TextView chest = (TextView)findViewById(R.id.chest);
        chest.setText("Chest Armor: " + String.valueOf(soldier.getChest().getName()));

        TextView forearms = (TextView)findViewById(R.id.forearms);
        forearms.setText("Gauntlets: " + String.valueOf(soldier.getForearms().getName()));

        TextView legs = (TextView)findViewById(R.id.legs);
        legs.setText("Leg Armor: " + String.valueOf(soldier.getLegs().getName()));




    }
}
