package com.okanbasar.ga_test_app;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends BaseActivity {
    private static final String TAG = "ProfileActivity";

    TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameTextView = (TextView) findViewById(R.id.usernameTextView);
        usernameTextView.setText(getIntent().getExtras().get("username").toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setScreenViewBuilder(TAG);
    }
}
