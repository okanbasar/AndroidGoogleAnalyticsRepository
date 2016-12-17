package com.okanbasar.ga_test_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private Tracker mTracker;
    private static final String activityName = "LoginActivity";

    TextView usernameTextView;
    TextView passwordTextView;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        setContentView(R.layout.activity_login);

        usernameTextView = (TextView) findViewById(R.id.usernameTextView);
        passwordTextView = (TextView) findViewById(R.id.passwordTextView);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Login Button Click: " + activityName);
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Category-1")
                        .setAction("Action-1")
                        .setLabel("Label-1") //optional
                        .setValue(1) //optional
                        .build());

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

        Log.e(TAG, "Login onResume: " + activityName);
        mTracker.setScreenName("Activity~" + activityName);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
