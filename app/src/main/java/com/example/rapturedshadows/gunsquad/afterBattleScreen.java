package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class afterBattleScreen extends AppCompatActivity {

    Attack a = new Attack();
    playerScreen p = new playerScreen();
    Mission_Screen m = new Mission_Screen();
    Unit one = new Unit(), two = new Unit(), three = new Unit();
    int pos1, pos2, pos3;
    Barracks bar = new Barracks();
    Select_Units_For_Mission s = new Select_Units_For_Mission();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_battle_screen);

        one = (Unit)getIntent().getSerializableExtra("one");
        two = (Unit)getIntent().getSerializableExtra("two");
        three = (Unit)getIntent().getSerializableExtra("three");
        pos1 = s.getOnePos();
        pos2 = s.getTwoPos();
        pos3 = s.getThreePos();

        Button b = (Button)findViewById(R.id.Next);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),playerScreen.class);
                startActivity(i);
            }
        });


        TextView result = (TextView)findViewById(R.id.win_or_lose);
        if (a.isWin()){
            result.setText("You Won!");
            p.setMoney(m.getM().getAmtOfMoney());
            bar.getIndividualSoldiers(pos1).increaseXP(m.getM().getAmtOfXP());

                bar.getIndividualSoldiers(pos2).increaseXP(m.getM().getAmtOfXP());

                bar.getIndividualSoldiers(pos3).increaseXP(m.getM().getAmtOfXP());
            p.setWaveNumber(1);
            p.checkWave(m.getM());
            bar.increaseUnitsHealth(pos1,pos2,pos3);
        } else
            result.setText("You Lost...");

        TextView amt = (TextView)findViewById(R.id.amtofmoney);
        amt.setText("Money Rewarded: $" + m.getM().getAmtOfMoney());

        TextView unit1 = (TextView)findViewById(R.id.unit1);
        unit1.setText(bar.getIndividualSoldiers(pos1).getName() + ": " + bar.getIndividualSoldiers(pos1).getUnitXP() + "/" + bar.getIndividualSoldiers(pos1).getNextLevelXP() + "XP" + "   " + "Level: " + bar.getIndividualSoldiers(pos1).getLevel());

        if (!(pos1 == pos2)) {
            TextView unit2 = (TextView) findViewById(R.id.unit2);
            unit2.setText(bar.getIndividualSoldiers(pos2).getName() + ": " + bar.getIndividualSoldiers(pos2).getUnitXP() + "/" + bar.getIndividualSoldiers(pos2).getNextLevelXP() + "XP" + "   " + "Level: " + bar.getIndividualSoldiers(pos2).getLevel());
        }

        if (!(pos1 == pos3) && !(pos2 == pos3)) {
            TextView unit3 = (TextView) findViewById(R.id.unit3);
            unit3.setText(bar.getIndividualSoldiers(pos3).getName() + ": " + bar.getIndividualSoldiers(pos3).getUnitXP() + "/" + bar.getIndividualSoldiers(pos3).getNextLevelXP() + "XP" + "   " + "Level: " + bar.getIndividualSoldiers(pos3).getLevel());
        }
    }
}
