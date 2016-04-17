package com.example.jenny.sunshine.androidsettings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    private SharedPreferences sharedPreferences;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String checkBoxValueActual = getString(R.string.pref_checkbox_key);
        String checkBoxValueDefault = getString(R.string.pref_checkbox_default);

        Boolean checkBoxValue =
                sharedPreferences.getBoolean(checkBoxValueActual, Boolean.valueOf(checkBoxValueDefault));

        //Log.v(LOG_TAG, checkBoxValue.toString());
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView checkBoxTextView = (TextView) view.findViewById(R.id.checkBoxSetting);
        checkBoxTextView.setText(checkBoxValue.toString());
        return view;
    }

}

