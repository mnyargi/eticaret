package com.example.melik.deneme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by melik on 20.11.2016.
 */
public class userIndex extends Activity {
    Button ayarlar;
    boolean bool=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userindex);
        ayarlar = (Button)findViewById(R.id.ayarlar);

        ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ayarlarIntent = new Intent(getApplicationContext(), ayarlar.class);
                //startActivity(ayarlarIntent);
                Intent menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(menuIntent);
            }
        });



    }

    public void myClickHandler(View target) {
        // Do stuff
    }
}
