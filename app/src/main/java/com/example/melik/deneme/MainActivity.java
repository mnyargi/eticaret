package com.example.melik.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button kullaniciGiris;
    Button isverenGiris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullaniciGiris = (Button)findViewById(R.id.userBtn);
        isverenGiris = (Button)findViewById(R.id.isverenBtn);

        kullaniciGiris.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent userIntent = new Intent(MainActivity.this, userPage.class);
                startActivity(userIntent);
            }
        });
        isverenGiris.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent isverenIntent = new Intent(MainActivity.this, isverenPage.class);
                startActivity(isverenIntent);
            }
        });

    }

}
