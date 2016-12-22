package com.example.melik.isbakdeneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button mainUserSignInBtn, mainEmployeurSignInBtn, mainSignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mainUserSignInBtn = (Button)findViewById(R.id.mainUserSignIn);
        mainEmployeurSignInBtn = (Button)findViewById(R.id.mainEmployeurSignIn);
        mainSignUpBtn = (Button)findViewById(R.id.mainSignUp);

        mainUserSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(MainPage.this, UserSignIn.class);
                startActivity(userIntent);
            }
        });

        mainEmployeurSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent employeurIntent = new Intent(MainPage.this, EmployeurSignIn.class);
                startActivity(employeurIntent);
            }
        });

        mainSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(MainPage.this, SignUp.class);
                startActivity(signUpIntent);
            }
        });
    }
}
