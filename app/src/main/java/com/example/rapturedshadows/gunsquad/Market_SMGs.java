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

public class Market_SMGs extends AppCompatActivity {
    private List<Gun> smgs = new ArrayList<Gun>();
    Button back;
    playerScreen p = new playerScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market__smgs);

        back = (Button)findViewById(R.id.backtomarket);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),Market_MainScreen.class);
                startActivity(back);
            }
        });

        TextView money = (TextView)findViewById(R.id.money);
        money.setText("$" + p.getMoney());

        populateUnits();
        populateList();
    }

    public void populateUnits() {
        smgs.add(new AK74u());
        smgs.add(new Aug_Para());
        smgs.add(new Bizon());
        smgs.add(new Mac10());
        smgs.add(new MP5());
        smgs.add(new MPX());
        smgs.add(new P90());
        smgs.add(new UMP45());
        smgs.add(new Vector());
        smgs.add(new XK9());
    }

    private void populateList() {
        ArrayAdapter<Gun> adapter = new Market_SMGs.MyListAdapter();
        ListView list = (ListView)findViewById(R.id.smg_list);
        list.setAdapter(adapter);
    }


    public class MyListAdapter extends ArrayAdapter<Gun> {
        public MyListAdapter() {
            super(Market_SMGs.this, R.layout.weapon_view_market, smgs);
        }

        public View getView(int position, final View convertView, ViewGroup parent){
            View itemView= convertView;
            if(itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.weapon_view_market,parent,false);
            }

            //find soldier
            final Gun currentUnit = smgs.get(position);

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
