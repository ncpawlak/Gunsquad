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

public class Market_Perks extends AppCompatActivity {
    private List<Perks> perks = new ArrayList<Perks>();

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market__perks);

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
        perks.add(new Perk_DeadEye());
        perks.add(new Perk_LegDay());
        perks.add(new Perk_Medic());
        perks.add(new Perk_Specialist());
    }

    private void populateList() {
        ArrayAdapter<Perks> adapter = new Market_Perks.MyListAdapter();
        ListView list = (ListView)findViewById(R.id.perk_list);
        list.setAdapter(adapter);
    }

    public class MyListAdapter extends ArrayAdapter<Perks> {
        public MyListAdapter() {
            super(Market_Perks.this, R.layout.perk_view_market, perks);
        }
        public View getView(int position, final View convertView, ViewGroup parent){
            View itemView= convertView;
            if(itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.perk_view_market,parent,false);
            }

            //find soldier
            final Perks currentUnit = perks.get(position);

            //fill view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.perkpic);
            imageView.setImageResource(currentUnit.getIconID());

            //name
            TextView nameText = (TextView)itemView.findViewById(R.id.perkname);
            nameText.setText(currentUnit.getName());

            //price
            TextView description = (TextView)itemView.findViewById(R.id.perkprice);
            description.setText("$"+String.valueOf(currentUnit.getPrice()));

            //description
            TextView desc = (TextView)itemView.findViewById(R.id.perkdescription);
            desc.setText(currentUnit.getDescription());


            //buy
            Button buy = (Button)itemView.findViewById(R.id.purchase);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerScreen p = new playerScreen();
                    if (p.getMoney() >= currentUnit.getPrice()) {
                        p.setMoney(currentUnit.getPrice());
                        Intent buy = new Intent(getApplicationContext(),purchase_screen_perks.class);
                        buy.putExtra("perk",currentUnit);
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
