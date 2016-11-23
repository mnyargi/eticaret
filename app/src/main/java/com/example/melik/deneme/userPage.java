package com.example.melik.deneme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by melik on 20.11.2016.
 */
public class userPage extends Activity {

    EditText userMail,userPass;
    Button userBtnGrs;
    Toast to;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kullanicigiris);
        userMail = (EditText)findViewById(R.id.userMailTxt);
        userPass  = (EditText)findViewById(R.id.userPassTxt);
        userBtnGrs = (Button)findViewById(R.id.userBtnGrs);

        userBtnGrs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(userMail.toString().equals("mnyargi")&& userPass.toString().equals("123456")){
                Intent userIntent2 = new Intent(userPage.this, userIndex.class);
                startActivity(userIntent2);
                }
                else {
                    Intent userIntent2 = new Intent(userPage.this, userIndex.class);
                    startActivity(userIntent2);
                }
            }
        });

    }

    public void myClickHandler(View target) {
        // Do stuff
    }
}
