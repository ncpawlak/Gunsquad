package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class playerScreen extends AppCompatActivity {

    Button barracks, start;

    static private int missionNumber=1;
    static private int waveNumber=0;
    static private int money=10000;

    public int getWaveNumber() {return waveNumber;}
    public void setWaveNumber(int wave) {this.waveNumber = waveNumber+wave;}

    public void setMissionNumber(int missionNumber) {this.missionNumber = missionNumber;}
    public int getMissionNumber() {return missionNumber;}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_screen);

        barracks = (Button)findViewById(R.id.barracks);
        barracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),Barracks.class);
                startActivity(b);

            }
        });

        start = (Button)findViewById(R.id.startM);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(),Mission_Screen.class);
                startActivity(s);
            }
        });

        TextView m = (TextView)findViewById(R.id.money);
        m.setText("$" + String.valueOf(money));
    }

    public void increaseMissionNumber(){
        this.missionNumber++;
    }

    public void checkWave(Mission m) {
        //this.waveNumber++;
        if (this.waveNumber > m.getMissionAmountNumber()){
            increaseMissionNumber();
            this.waveNumber=0;
        }
    }

    public int getMoney() {return money;}
    public void setMoney(int i){money = money + i;}

}

