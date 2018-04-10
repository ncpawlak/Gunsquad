package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Market_Attachments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market__attachments);

        Button grip = (Button)findViewById(R.id.foregrips);
        grip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Market_Grips.class);
                startActivity(i);
            }
        });

        Button barrel = (Button)findViewById(R.id.barrels);
        barrel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Market_Barrels.class);
                startActivity(i);
            }
        });

        Button clip = (Button)findViewById(R.id.clips);
        clip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Market_Clips.class);
                startActivity(i);
            }
        });

        Button scope = (Button)findViewById(R.id.scopes);
        scope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Market_Scopes.class);
                startActivity(i);
            }
        });

        Button acc = (Button)findViewById(R.id.accessories);
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Market_Accessories.class);
                startActivity(i);
            }
        });

        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(getApplicationContext(),Market_MainScreen.class);
                startActivity(m);
            }
        });
    }
}
