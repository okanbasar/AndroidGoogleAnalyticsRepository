package com.okanbasar.ga_test_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class ProfileActivity extends BaseActivity {
    private static final String TAG = "ProfileActivity";
    private Tracker mTracker;
    private static final String activityName = "ProfileActivity";

    TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        setContentView(R.layout.activity_profile);

        usernameTextView = (TextView) findViewById(R.id.usernameTextView);
        usernameTextView.setText(getIntent().getExtras().get("username").toString());
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "Profile onResume: " + activityName);
        mTracker.setScreenName("Activity~" + activityName);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
