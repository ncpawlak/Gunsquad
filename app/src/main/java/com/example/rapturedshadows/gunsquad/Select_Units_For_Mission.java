package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Select_Units_For_Mission extends AppCompatActivity {

    Button back;
    static Unit one = new Unit();
    static Unit two = new Unit();
    static Unit three = new Unit();
    static int onePos=-1, twoPos=-1, threePos=-1;
    boolean on=false,tw=false,thr=false;
    private List<Unit> assaultRifles = new ArrayList<Unit>();
    Barracks b = new Barracks();
    Unit[] soldiers = new Unit[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__units__for__mission);

        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Mission_Screen.class);
                startActivity(i);
            }
        });



        populateUnits();
        populateList();

            Button b = (Button)findViewById(R.id.attack);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent i = new Intent(getApplicationContext(), Attack.class);
                        i.putExtra("one", one);
                        i.putExtra("two", two);
                        i.putExtra("three", three);
                        startActivity(i);

                }
            });
    }


    public void populateUnits() {
        assaultRifles.add(b.getIndividualSoldiers(0));
        assaultRifles.add(b.getIndividualSoldiers(1));
        assaultRifles.add(b.getIndividualSoldiers(2));
        assaultRifles.add(b.getIndividualSoldiers(3));
        assaultRifles.add(b.getIndividualSoldiers(4));
        assaultRifles.add(b.getIndividualSoldiers(5));
        assaultRifles.add(b.getIndividualSoldiers(6));
        assaultRifles.add(b.getIndividualSoldiers(7));
        assaultRifles.add(b.getIndividualSoldiers(8));
        assaultRifles.add(b.getIndividualSoldiers(9));
    }

    private void populateList() {
        ArrayAdapter<Unit> adapter = new Select_Units_For_Mission.MyListAdapter();
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Unit> {
        public MyListAdapter() {
            super(Select_Units_For_Mission.this, R.layout.soldier_view, assaultRifles);
        }

        public View getView(final int position, final View convertView, ViewGroup parent){
            View itemView= convertView;
            if(itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.soldier_view,parent,false);
            }

            //find soldier
            final Unit currentUnit = assaultRifles.get(position);



            //fill view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.soldierpic);
            imageView.setImageResource(currentUnit.getIconID());

            //name
            TextView nameText = (TextView)itemView.findViewById(R.id.soldiername);
            nameText.setText(currentUnit.getName());

            //level
            TextView level = (TextView)itemView.findViewById(R.id.soldierlevel);
            level.setText("Level: " + currentUnit.getLevel());

            TextView health = (TextView)itemView.findViewById(R.id.health);
            health.setText("HP:" + String.valueOf(currentUnit.getTemporaryHealth() + "/"+ currentUnit.getHealth()));

            TextView xp = (TextView)itemView.findViewById(R.id.xp);
            xp.setText("XP:"+ currentUnit.getUnitXP() + "/" + currentUnit.getNextLevelXP());

            Button b = (Button)itemView.findViewById(R.id.allstats);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), advancedstatsofunit.class);
                    i.putExtra("Unit",currentUnit);
                    startActivity(i);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!on && currentUnit.getName() != "KIA"){
                        one = currentUnit;
                        on = true;
                        Select_Units_For_Mission.onePos = position;
                        TextView s = (TextView)findViewById(R.id.soldier1);
                        //v.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                        s.setText("Soldier 1: " + one.getName());
                    } else if (!tw && currentUnit != one && currentUnit.getName() != "KIA"){
                        two = currentUnit;
                        tw = true;
                        Select_Units_For_Mission.twoPos = position;
                        TextView s = (TextView)findViewById(R.id.soldier2);
                        //v.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                        s.setText("Soldier 2: " + two.getName());
                    } else if (!thr && currentUnit != two && currentUnit != one && currentUnit.getName() != "KIA"){
                        three = currentUnit;
                        thr = true;
                        Select_Units_For_Mission.threePos = position;
                        TextView s = (TextView)findViewById(R.id.soldier3);
                        //v.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                        s.setText("Soldier 3: " + three.getName());
                    }
                }
            });


            return itemView;
        }
    }

    public int getOnePos() {
        return onePos;
    }

    public int getTwoPos() {
        return twoPos;
    }

    public int getThreePos() {
        return threePos;
    }

}
