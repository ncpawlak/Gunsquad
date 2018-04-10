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

public class Market_SniperRifles extends AppCompatActivity {
    private List<Gun> sniperRifles = new ArrayList<Gun>();
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market__sniper_rifles);

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
        sniperRifles.add(new M14());
        sniperRifles.add(new M24());
        sniperRifles.add(new M98());
        sniperRifles.add(new M200());
        sniperRifles.add(new MK12());
        sniperRifles.add(new SR25());
        sniperRifles.add(new SVD());
        sniperRifles.add(new WA2000());


    }

    private void populateList() {
        ArrayAdapter<Gun> adapter = new Market_SniperRifles.MyListAdapter();
        ListView list = (ListView)findViewById(R.id.s_r_list);
        list.setAdapter(adapter);
    }

    public class MyListAdapter extends ArrayAdapter<Gun> {
        public MyListAdapter() {
            super(Market_SniperRifles.this, R.layout.weapon_view_market, sniperRifles);
        }

        public View getView(int position, final View convertView, ViewGroup parent){
            View itemView= convertView;
            if(itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.weapon_view_market,parent,false);
            }

            //find soldier
            final Gun currentUnit = sniperRifles.get(position);

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

            //purchase
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
