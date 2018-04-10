package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class advancedstatsofunit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advancedstatsofunit);

        Button b = (Button)findViewById(R.id.backtobarracks);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        final Unit soldier = (Unit)getIntent().getSerializableExtra("Unit");


        TextView name = (TextView)findViewById(R.id.soldiername);
        name.setText(soldier.getName());

        TextView health = (TextView)findViewById(R.id.soldierhealth);
        health.setText("Health: " + soldier.getTemporaryHealth()+"/"+soldier.getHealth());

        TextView level = (TextView)findViewById(R.id.soldierlevel);
        level.setText("Level: "+String.valueOf(soldier.getLevel()));

        ImageView primary = (ImageView)findViewById(R.id.primary);
        primary.setImageResource(soldier.getPrimary().getIconID());

        ImageView secondary = (ImageView)findViewById(R.id.secondary);
        secondary.setImageResource(soldier.getSecondary().getIconID());

        TextView damage = (TextView)findViewById(R.id.soldierdamage);
        damage.setText("Damage: "+String.valueOf(soldier.getDamage()));

        TextView accuracy = (TextView)findViewById(R.id.soldieraccuracy);
        accuracy.setText("Accuracy: "+String.valueOf(soldier.getAccuracy()));

        TextView defense = (TextView)findViewById(R.id.soldierdefense);
        defense.setText("Defense: "+String.valueOf(soldier.getDefense()));

        TextView speed = (TextView)findViewById(R.id.soldierspeed);
        speed.setText("Speed: "+String.valueOf(soldier.getSpeed()));

        TextView pname = (TextView)findViewById(R.id.primaryname);
        pname.setText("Primary: "+soldier.getPrimary().getName());

        TextView sname = (TextView)findViewById(R.id.secondaryName);
        sname.setText("Secondary: "+soldier.getSecondary().getName());

        TextView dam = (TextView)findViewById(R.id.primarydamage);
        dam.setText(String.valueOf("Damage: "+soldier.getPrimary().getDamage()));

        TextView acc = (TextView)findViewById(R.id.primaryaccuracy);
        acc.setText(String.valueOf("Accuracy: "+soldier.getPrimary().getAccuracy()));

        TextView sp = (TextView)findViewById(R.id.primaryspeed);
        sp.setText(String.valueOf("Speed: "+soldier.getPrimary().getSpeed()));

        TextView sdam = (TextView)findViewById(R.id.secondarydamage);
        sdam.setText(String.valueOf("Damage: "+soldier.getSecondary().getDamage()));

        TextView sacc = (TextView)findViewById(R.id.secondaryaccuracy);
        sacc.setText(String.valueOf("Accuracy: "+soldier.getSecondary().getAccuracy()));

        TextView ssp = (TextView)findViewById(R.id.secondaryspeed);
        ssp.setText(String.valueOf("Speed: "+soldier.getSecondary().getSpeed()));

        TextView xp = (TextView)findViewById(R.id.soldierxp);
        xp.setText(String.valueOf(soldier.getUnitXP()) + "/" + String.valueOf(soldier.getNextLevelXP()) + "XP");

        TextView pscope = (TextView)findViewById(R.id.primarysight);
        if (soldier.getPrimary().getScope().getName() != null)
            pscope.setText("Sight: " + soldier.getPrimary().getScope().getName());
        else
            pscope.setText(" ");

        TextView pbarrel = (TextView)findViewById(R.id.primarybarrel);
        if (soldier.getPrimary().getBarrel().getName() != null)
            pbarrel.setText("Barrel: " + soldier.getPrimary().getBarrel().getName());
        else
            pbarrel.setText(" ");

        TextView pgrip = (TextView)findViewById(R.id.primarygrip);
        if (soldier.getPrimary().getGrip().getName() != null)
            pgrip.setText("Grip: " + soldier.getPrimary().getGrip().getName());
        else
            pgrip.setText(" ");

        TextView pclip = (TextView)findViewById(R.id.primaryclip);
        if (soldier.getPrimary().getClip().getName() != null)
            pclip.setText("Clip: " + soldier.getPrimary().getClip().getName());
        else
            pclip.setText(" ");

        TextView pacc = (TextView)findViewById(R.id.primaryaccessory);
        if (soldier.getPrimary().getAccessory().getName() != null)
            pacc.setText("Acc: " + soldier.getPrimary().getAccessory().getName());
        else
            pacc.setText(" ");


        TextView sscope = (TextView)findViewById(R.id.secondarysight);
        if (soldier.getSecondary().getScope().getName() != null)
            sscope.setText("Sight: " + soldier.getSecondary().getScope().getName());
        else
            sscope.setText(" ");

        TextView sbarrel = (TextView)findViewById(R.id.secondarybarrel);
        if (soldier.getSecondary().getBarrel().getName() != null)
            sbarrel.setText("Barrel: " + soldier.getSecondary().getBarrel().getName());
        else
            sbarrel.setText(" ");

        TextView sgrip = (TextView)findViewById(R.id.secondarygrip);
        if (soldier.getPrimary().getGrip().getName() != null)
            sgrip.setText("Grip: " + soldier.getSecondary().getGrip().getName());
        else
            sgrip.setText(" ");

        TextView sclip = (TextView)findViewById(R.id.secondaryclip);
        if (soldier.getSecondary().getClip().getName() != null)
            sclip.setText("Clip: " + soldier.getSecondary().getClip().getName());
        else
            sclip.setText(" ");

        TextView seacc = (TextView)findViewById(R.id.secondaryaccessory);
        if (soldier.getSecondary().getAccessory().getName() != null)
            seacc.setText("Acc: " + soldier.getSecondary().getAccessory().getName());
        else
            seacc.setText(" ");
    }
}
