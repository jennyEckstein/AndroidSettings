package com.example.jenny.sunshine.androidsettings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity{

    public static final String PREF_CHECK_BOX = "pref_checkbox";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load the preferences from XML resource
        addPreferencesFromResource(R.xml.preferences);
    }
}
