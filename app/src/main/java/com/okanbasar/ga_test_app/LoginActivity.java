package com.okanbasar.ga_test_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";

    TextView usernameTextView;
    TextView passwordTextView;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTextView = (TextView) findViewById(R.id.usernameTextView);
        passwordTextView = (TextView) findViewById(R.id.passwordTextView);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEventBuilder("Category-1","Action-1","Label-1",null);

                Intent i = new Intent();
                i.setClass(LoginActivity.this,ProfileActivity.class);
                i.putExtra("username",usernameTextView.getText().toString().trim());
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setScreenViewBuilder(TAG);
    }
}
