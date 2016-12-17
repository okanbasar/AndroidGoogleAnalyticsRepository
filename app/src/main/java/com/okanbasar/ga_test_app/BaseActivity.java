package com.okanbasar.ga_test_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class BaseActivity extends AppCompatActivity {

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void setScreenViewBuilder(String screenName){
        mTracker.setScreenName("Activity~" + screenName);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public void setEventBuilder(String category, String action, String label, Long value){
        HitBuilders.EventBuilder eventBuilder = new HitBuilders.EventBuilder();

        if(category != null) eventBuilder.setCategory(category);
        if(action != null) eventBuilder.setAction(action);
        if(label != null) eventBuilder.setLabel(label);
        if(value != null) eventBuilder.setValue(value);

        mTracker.send(eventBuilder.build());
    }
}
