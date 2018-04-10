package com.example.rapturedshadows.gunsquad;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Barracks extends AppCompatActivity {
    private List<Unit> allUnits = new ArrayList<Unit>();
    static private Unit[] soldiers = new Unit[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barracks);


        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), playerScreen.class);
                startActivity(i);
            }
        });

        populateUnits();
        populateList();
    }

    public void fillArray() {
        soldiers[0] = new Unit("Noah Pawlak");
        soldiers[1] = new Unit("Andrew King");
        soldiers[2] = new Unit("Howard Meck");
        soldiers[3] = new Unit("Bryant Frye");
        soldiers[4] = new Unit("Luke Hellman");
        soldiers[5] = new Unit("Josh Taylor");
        soldiers[6] = new Unit("David Butz");
        soldiers[7] = new Unit("Tyler James");
        soldiers[8] = new Unit("Brandon Patrick");
        soldiers[9] = new Unit("Jordan Arndt");
    }

    public void populateUnits() {
        allUnits.add(soldiers[0]);
        allUnits.add(soldiers[1]);
        allUnits.add(soldiers[2]);
        allUnits.add(soldiers[3]);
        allUnits.add(soldiers[4]);
        allUnits.add(soldiers[5]);
        allUnits.add(soldiers[6]);
        allUnits.add(soldiers[7]);
        allUnits.add(soldiers[8]);
        allUnits.add(soldiers[9]);
    }

    private void populateList() {
        ArrayAdapter<Unit> adapter = new Barracks.MyListAdapter();
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }


    public class MyListAdapter extends ArrayAdapter<Unit> {
        public MyListAdapter() {
            super(Barracks.this, R.layout.soldier_view, allUnits);
        }

        public View getView(int position, final View convertView, ViewGroup parent){
            View itemView= convertView;
            if(itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.soldier_view,parent,false);
            }

            //find soldier
            final Unit currentUnit = allUnits.get(position);

            //name
            final TextView nameText = (TextView)itemView.findViewById(R.id.soldiername);
            nameText.setText(currentUnit.getName());

            ImageView pic = (ImageView)itemView.findViewById(R.id.soldierpic);
            pic.setImageResource(currentUnit.getIconID());

            TextView health = (TextView)itemView.findViewById(R.id.health);
            health.setText("HP:"+String.valueOf(currentUnit.getTemporaryHealth()) + "/" + currentUnit.getHealth());

            TextView level = (TextView)itemView.findViewById(R.id.soldierlevel);
            level.setText("Level: " + currentUnit.getLevel());

            TextView xp = (TextView)itemView.findViewById(R.id.xp);
            xp.setText("XP:"+ currentUnit.getUnitXP() + "/" + currentUnit.getNextLevelXP());

            Button market = (Button)findViewById(R.id.market);
            market.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), Market_MainScreen.class);
                    startActivity(i);
                }
            });

            final Button stats = (Button)itemView.findViewById(R.id.allstats);
            stats.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), advancedstatsofunit.class);
                    i.putExtra("Unit", currentUnit);
                    startActivity(i);
                }
            });




            return itemView;
        }
    }


    public Unit[] getArray(){
        return soldiers;
    }

    public Unit getIndividualSoldiers(int i){
        return soldiers[i];
    }

    public boolean ifFilled() {
        return false;
    }

    public void healthSubtractAfterAttack(int dam, int pos1, int pos2, int pos3) {
        int t = dam / 3;
        soldiers[pos1].setHealthAfterMission(t);
        soldiers[pos2].setHealthAfterMission(t);
        soldiers[pos3].setHealthAfterMission(t);
        if (soldiers[pos1].died())
            soldiers[pos1].clear();
        if (soldiers[pos2].died())
            soldiers[pos2].clear();
        if (soldiers[pos3].died())
            soldiers[pos3].clear();
    }

    public void increaseUnitsHealth(int one, int two, int three) {
        for (int i = 0; i < 10; i++){
            if (!(soldiers[i] == soldiers[one]) && !(soldiers[i] == soldiers[two]) && !(soldiers[i] == soldiers[three]))
                soldiers[i].increaseHPAfterMission();
        }
    }
}
