package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;


public class Attack extends AppCompatActivity {
    Unit one = new Unit();
    Unit two = new Unit();
    Unit three = new Unit();
    private int damage, speed, defense, accuracy, health, tempDefense;
    private int eDam, eSp, eDef, eAcc, etempDef;
    int pos1, pos2, pos3;

    Barracks b= new Barracks();


    public static boolean isWin() {
        return win;
    }

    static private boolean win = false;
    Generate_Enemy enemy = new Generate_Enemy();
    playerScreen p = new playerScreen();
    Timer time = new Timer();
    Select_Units_For_Mission s = new Select_Units_For_Mission();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);

        pos1 = getIntent().getIntExtra("onepos", pos1);
        pos2 = getIntent().getIntExtra("twopos", pos2);
        pos3 = getIntent().getIntExtra("threepos",pos3);

        one = b.getIndividualSoldiers(s.getOnePos());
        two = b.getIndividualSoldiers(s.getTwoPos());
        three = b.getIndividualSoldiers(s.getThreePos());


            damage = one.getDamage() + two.getDamage() + three.getDamage();
            speed = one.getSpeed() + two.getSpeed() + three.getSpeed();
            defense = one.getDefense() + two.getDefense() + three.getDefense();
            accuracy = one.getAccuracy() + two.getAccuracy() + three.getAccuracy();
            health = one.getHealth() + two.getHealth() + three.getHealth();
            tempDefense = defense;

        enemy.generateStats();
        eDam = enemy.getDamage();
        eDef = enemy.getDefense();
        eSp = enemy.getSpeed();
        eAcc = enemy.getAccuracy();
        etempDef = eDef;

        TextView dam = (TextView)findViewById(R.id.damage);
        dam.setText("Dam: " + String.valueOf(damage));

        TextView acc = (TextView)findViewById(R.id.accuracy);
        acc.setText("Acc: " + String.valueOf(accuracy));

        TextView sp = (TextView)findViewById(R.id.speed);
        sp.setText("Speed: " + String.valueOf(speed));

        TextView edam = (TextView)findViewById(R.id.edamage);
        edam.setText("Enemy Dam: " + String.valueOf(eDam));

        TextView eac = (TextView)findViewById(R.id.eaccuracy);
        eac.setText("Enemy Acc: " + String.valueOf(eAcc));

        TextView esp = (TextView)findViewById(R.id.espeed);
        esp.setText("Enemy Speed: " + String.valueOf(eSp));

        TextView def = (TextView)findViewById(R.id.defense);
        def.setText("Defense: " + defense);

        TextView edef = (TextView)findViewById(R.id.edefense);
        edef.setText("Enemy Defense: " + eDef);


        do {
            //player goes first
            //player turn
            if (speed >= enemy.getSpeed()) {
                Random r = new Random();
                int n = r.nextInt(100) + 1;
                if (accuracy >= n) {
                    //Toast.makeText(getApplicationContext(), "Enemy has been neutralized!", Toast.LENGTH_SHORT).show();
                    eDef = eDef - (damage / 2);
                    if (eDef <= 0)
                        break;
                } //else
                    //Toast.makeText(getApplicationContext(), "Shots not effective, reloading!", Toast.LENGTH_SHORT).show();

                //CPU turn
                Random d = new Random();
                n = d.nextInt(100) + 1;
                if (eAcc >= n) {
                    //Toast.makeText(getApplicationContext(), "Man down, need EVAC!", Toast.LENGTH_SHORT).show();
                    tempDefense = tempDefense - (eDam / 2);
                } //else
                    //Toast.makeText(getApplicationContext(), "Enemy shots non-effective!", Toast.LENGTH_SHORT).show();
            }


            //CPU goes first
            //CPU turn
            if (speed < enemy.getSpeed()) {
                Random r = new Random();
                int n = r.nextInt(100) + 1;
                if (eAcc >= n) {
                    //Toast.makeText(getApplicationContext(), "We need EVAC, we have injured!", Toast.LENGTH_SHORT).show();
                    tempDefense = tempDefense - (eDam / 2);
                } //else
                    //Toast.makeText(getApplicationContext(), "Hostile shots missing our location!", Toast.LENGTH_SHORT).show();

                //Player turn
                Random d = new Random();
                n = d.nextInt(100) + 1;
                if (accuracy >= n) {
                    //Toast.makeText(getApplicationContext(), "Enemy has been neutralized!", Toast.LENGTH_SHORT).show();
                    eDef = eDef - (damage / 2);
                    if (eDef <= 0)
                        break;
                } //else
                    //Toast.makeText(getApplicationContext(), "Shots not effective, reloading!", Toast.LENGTH_SHORT).show();
            }
        } while (defense > 0 && eDef > 0);


        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button con = (Button)findViewById(R.id.finish);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eDef <= 0) {
                    Toast.makeText(getApplicationContext(), "All Enemies Killed, Mission Accomplished.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),afterBattleScreen.class);
                    win = true;
                    tempDefense = defense - tempDefense;
                    Toast.makeText(getApplicationContext(), "Took " + tempDefense + " damage.", Toast.LENGTH_SHORT).show();
                    b.healthSubtractAfterAttack(tempDefense,pos1,pos2,pos3);
                    i.putExtra("one",one);
                    i.putExtra("two",two);
                    i.putExtra("three",three);
                    startActivity(i);
                } else if (defense <= 0) {
                    Toast.makeText(getApplicationContext(), "All Units KIA.", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void enemyKilled(){
        Toast.makeText(getApplicationContext(), "All hostiles have been neutralized, mission accomplished.", Toast.LENGTH_LONG).show();
    }
}
