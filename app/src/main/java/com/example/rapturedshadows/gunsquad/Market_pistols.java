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

public class Market_pistols extends AppCompatActivity {
    private List<Gun> pistols = new ArrayList<Gun>();
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_pistols);

        back = (Button)findViewById(R.id.backtomarket);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),Market_MainScreen.class);
                startActivity(back);
            }
        });

        populateUnits();
        populateList();
    }

    public void populateUnits() {
        pistols.add(new DEagle());
        pistols.add(new FNP());
        pistols.add(new G38());
        pistols.add(new M9());
        pistols.add(new M1911());
        pistols.add(new MK23());
        pistols.add(new P227());
        pistols.add(new USP());
    }

    private void populateList() {
        ArrayAdapter<Gun> adapter = new Market_pistols.MyListAdapter();
        ListView list = (ListView)findViewById(R.id.pistol_list);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Gun> {
        public MyListAdapter() {
            super(Market_pistols.this, R.layout.weapon_view_market, pistols);
        }

        public View getView(int position, final View convertView, ViewGroup parent){
            View itemView= convertView;
            if(itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.weapon_view_market,parent,false);
            }

            //find soldier
            final Gun currentUnit = pistols.get(position);

            //fill view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.gunpic);
            imageView.setImageResource(currentUnit.getIconID());

            //name
            TextView nameText = (TextView)itemView.findViewById(R.id.gunname);
            nameText.setText(currentUnit.getName());

            //price
            TextView description = (TextView)itemView.findViewById(R.id.gunprice);
            description.setText("$"+String.valueOf(currentUnit.getPrice()));

            //damage
            TextView damage = (TextView)itemView.findViewById(R.id.gundam);
            damage.setText("Damage: "+String.valueOf(currentUnit.getDamage()));

            //speed
            TextView speed =  (TextView)itemView.findViewById(R.id.gunspeed);
            speed.setText("Speed: "+String.valueOf(currentUnit.getSpeed()));

            //accuracy
            TextView acc = (TextView)itemView.findViewById(R.id.gunacc);
            acc.setText("Accuracy: "+String.valueOf(currentUnit.getAccuracy()));


            //buy
            Button buy = (Button)itemView.findViewById(R.id.purchase);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerScreen p = new playerScreen();
                    if (p.getMoney() >= currentUnit.getPrice()) {
                        p.setMoney(-currentUnit.getPrice());
                        Intent buy = new Intent(getApplicationContext(),purchase_screen.class);
                        buy.putExtra("gun",currentUnit);
                        startActivity(buy);
                    } else {
                        Toast.makeText(getApplicationContext(), "Not Enough Funds", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return itemView;
        }
    }
}
