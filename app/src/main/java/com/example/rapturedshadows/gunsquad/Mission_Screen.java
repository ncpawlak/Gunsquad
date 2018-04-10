package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Mission_Screen extends AppCompatActivity {

    Button back, start;
    TextView name, missionNo, waveNo, description;
    int waveNum;
    Select_Units_For_Mission select = new Select_Units_For_Mission();
    static private Mission m = new Mission();



    InnerRussianBase one = new InnerRussianBase();
    ChineseLastStand two = new ChineseLastStand();
    playerScreen p;
    Barracks b = new Barracks();

    public static Mission getM() {
        return m;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission__screen);

        RelativeLayout r = (RelativeLayout)findViewById(R.id.activity_mission__screen);
        p = new playerScreen();

        back = (Button)findViewById(R.id.playerscreen);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),playerScreen.class);
                startActivity(back);
            }
        });

        name = (TextView)findViewById(R.id.nameofmission);
        name.setText("Story Mode");
        missionNo = (TextView)findViewById(R.id.missionnumber);
        missionNo.setText("Mission: "+String.valueOf(p.getMissionNumber()));

        determineMissionInfo(r);
        start = (Button)findViewById(R.id.startmission);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //determineMissionInfo();
                Intent i = new Intent(getApplicationContext(), Select_Units_For_Mission.class);
                startActivity(i);
                p.checkWave(one);
            }
        });
    }


    void determineMissionInfo(RelativeLayout r) {
        waveNum = p.getWaveNumber();
        switch (p.getMissionNumber()){
            case 1:
                r.setBackgroundResource(R.drawable.innermoscow);
                description = (TextView)findViewById(R.id.missionDescription);
                description.setText(" ");
                name = (TextView)findViewById(R.id.nameofmission);
                name.setText(one.getName());
                missionNo = (TextView)findViewById(R.id.missionnumber);
                missionNo.setText("Mission: "+String.valueOf(one.getMissionNumber()));
                waveNo = (TextView)findViewById(R.id.waveamount);
                waveNo.setText("Waves: " + String.valueOf(waveNum)+"/"+String.valueOf(one.getMissionAmountNumber()));
                description = (TextView)findViewById(R.id.missionDescription);
                description.setText(one.getADescription(p.getWaveNumber()+1));
                m = one;
                break;
            case 2:
                r.setBackgroundResource(R.drawable.chineselaststand);
                description = (TextView)findViewById(R.id.missionDescription);
                description.setText(" ");
                name = (TextView)findViewById(R.id.nameofmission);
                name.setText(two.getName());
                missionNo = (TextView)findViewById(R.id.missionnumber);
                missionNo.setText("Mission: "+ String.valueOf(two.getMissionNumber()));
                waveNo = (TextView)findViewById(R.id.waveamount);
                waveNo.setText("Waves: " + String.valueOf(waveNum)+"/"+String.valueOf(two.getMissionAmountNumber()));
                description = (TextView)findViewById(R.id.missionDescription);
                description.setText(two.getADescription(p.getWaveNumber()+1));
                m = two;
                break;
            default:

                break;
        }
    }
}
