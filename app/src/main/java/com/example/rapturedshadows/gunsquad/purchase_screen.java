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

public class purchase_screen extends AppCompatActivity {

    private List<Unit> allUnits = new ArrayList<Unit>();
    public Unit[] soldiers = new Unit[10];
    Barracks b = new Barracks();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_screen);

        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent market = new Intent(getApplicationContext(),Market_MainScreen.class);
                startActivity(market);
            }
        });

        soldiers = b.getArray();

        populateUnits();
        populateList();
    }

    public void populateUnits() {
        allUnits.add(b.getIndividualSoldiers(0));
        allUnits.add(b.getIndividualSoldiers(1));
        allUnits.add(b.getIndividualSoldiers(2));
        allUnits.add(b.getIndividualSoldiers(3));
        allUnits.add(b.getIndividualSoldiers(4));
        allUnits.add(b.getIndividualSoldiers(5));
        allUnits.add(b.getIndividualSoldiers(6));
        allUnits.add(b.getIndividualSoldiers(7));
        allUnits.add(b.getIndividualSoldiers(8));
        allUnits.add(b.getIndividualSoldiers(9));
    }

    public void populateList() {
        ArrayAdapter<Unit> adapter = new purchase_screen.MyListAdapter();
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    public class MyListAdapter extends ArrayAdapter<Unit> {
        public MyListAdapter() {
            super(purchase_screen.this, R.layout.solder_view_for_purchase, allUnits);
        }

        public View getView(final int position, final View convertView, final ViewGroup parent){

            final Gun weapon = (Gun)getIntent().getSerializableExtra("gun");

            View itemView= convertView;
            if(itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.solder_view_for_purchase, parent, false);
            }

            //find soldier
            final Unit currentUnit = allUnits.get(position);


            //fill view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.soldierpic);
            imageView.setImageResource(currentUnit.getIconID());

            //name
            TextView nameText = (TextView)itemView.findViewById(R.id.soldiername);
            nameText.setText(currentUnit.getName());

            //level
            TextView description = (TextView)itemView.findViewById(R.id.soldierlevel);
            description.setText("Level: "+String.valueOf(currentUnit.getLevel()));

            //primary stuff
            ImageView primary = (ImageView)itemView.findViewById(R.id.primary);
            primary.setImageResource(currentUnit.getPrimary().getIconID());
            TextView pdam = (TextView)itemView.findViewById(R.id.pdam);
            pdam.setText("Dam: "+String.valueOf(currentUnit.getPrimary().getDamage()));
            TextView pacc = (TextView)itemView.findViewById(R.id.pacc);
            pacc.setText("Acc: "+String.valueOf(currentUnit.getPrimary().getAccuracy()));
            TextView psp = (TextView)itemView.findViewById(R.id.pspeed);
            psp.setText("Sp: "+String.valueOf(currentUnit.getPrimary().getSpeed()));
            primary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentUnit.setPrimary(weapon);
                    currentUnit.totalUpStats();
                    Toast.makeText(getApplicationContext(), "Equipped", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            });


            //secondary stuff
            ImageView secondary = (ImageView)itemView.findViewById(R.id.secondary);
            secondary.setImageResource(currentUnit.getSecondary().getIconID());
            TextView sdam = (TextView)itemView.findViewById(R.id.sdam);
            sdam.setText("Dam: "+String.valueOf(currentUnit.getSecondary().getDamage()));
            TextView sacc = (TextView)itemView.findViewById(R.id.sacc);
            sacc.setText("Acc: "+String.valueOf(currentUnit.getSecondary().getAccuracy()));
            TextView ssp = (TextView)itemView.findViewById(R.id.sspeed);
            ssp.setText("Sp: "+String.valueOf(currentUnit.getSecondary().getSpeed()));
            secondary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentUnit.ifCanUseAsPrimary()){   //can use it
                        currentUnit.setSecondary(weapon);
                        currentUnit.totalUpStats();
                        Toast.makeText(getApplicationContext(), "Equipped", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                    else if (!currentUnit.ifCanUseAsPrimary() && weapon.getGunID() != 0) //cant use it
                        Toast.makeText(getApplicationContext(), "Cannot Equip; Perk Not Purchased", Toast.LENGTH_LONG).show();
                    else if (weapon.getGunID() == 0){
                        currentUnit.setSecondary(weapon);
                        currentUnit.totalUpStats();
                        Toast.makeText(getApplicationContext(), "Equipped", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }
            });

            return itemView;
        }
    }
}
