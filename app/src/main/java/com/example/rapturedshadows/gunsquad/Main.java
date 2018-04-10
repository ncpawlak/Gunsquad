package com.example.rapturedshadows.gunsquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button newgame;

    public int position;

    Barracks b = new Barracks();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newgame = (Button)findViewById(R.id.newgame);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newgame = new Intent(getApplicationContext(),playerScreen.class);
                b.fillArray();
                startActivity(newgame);
            }
        });
    }

    public void setPosition(int i){
        this.position = i;
    }

    public int getPosition() {
        return position;
    }
}
