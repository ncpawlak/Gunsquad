package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Market_MainScreen extends AppCompatActivity {

    Button back, assaultRifles, sniperRifles, smgs, lmgs, pistols;
    Button perks, attachments;
    TextView name, primary, secondary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market__main_screen);

        back = (Button)findViewById(R.id.barracks);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),Barracks.class);
                startActivity(back);
            }
        });

        assaultRifles = (Button)findViewById(R.id.assault);
        assaultRifles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gun = new Intent(getApplicationContext(), Market_AssaultRifles.class);
                startActivity(gun);
            }
        });

        sniperRifles = (Button)findViewById(R.id.sniper);
        sniperRifles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gun = new Intent(getApplicationContext(), Market_SniperRifles.class);
                startActivity(gun);
            }
        });

        smgs = (Button)findViewById(R.id.smg);
        smgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gun = new Intent(getApplicationContext(), Market_SMGs.class);
                startActivity(gun);
            }
        });

        perks = (Button)findViewById(R.id.perks);
        perks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perk = new Intent(getApplicationContext(), Market_Perks.class);
                startActivity(perk);
            }
        });

        lmgs = (Button)findViewById(R.id.lmg);
        lmgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gun = new Intent(getApplicationContext(), market_LMGs.class);
                startActivity(gun);
            }
        });

        pistols = (Button)findViewById(R.id.pistols);
        pistols.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gun = new Intent(getApplicationContext(), Market_pistols.class);
                startActivity(gun);
            }
        });

        attachments = (Button)findViewById(R.id.attachments);
        attachments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gun = new Intent(getApplicationContext(), Market_Attachments.class);
                startActivity(gun);
            }
        });

    }
}
