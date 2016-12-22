package com.example.melik.isbakdeneme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by melik on 22.12.2016.
 */

public class UserSignIn extends Activity {
    EditText userSignInPassEdt, userSignInMailEdt;
    Button userSignInPageBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_sign_in);

        userSignInMailEdt = (EditText)findViewById(R.id.userSignInMail);
        userSignInPassEdt = (EditText)findViewById(R.id.userSignInPass);
        userSignInPageBtn = (Button)findViewById(R.id.userSignInPageBtn);

        userSignInPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userMenuIntent = new Intent(UserSignIn.this, UserMenu.class);
                startActivity(userMenuIntent);

            }
        });

    }
}
