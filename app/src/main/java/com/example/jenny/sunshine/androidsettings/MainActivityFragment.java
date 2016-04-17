package com.example.jenny.sunshine.androidsettings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private View view;
    private TextView checkBoxTextView;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        this.view = inflater.inflate(R.layout.fragment_main, container, false);
        checkBoxTextView = (TextView) view.findViewById(R.id.checkBoxSetting);
        setLayoutText();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onResume() {
        super.onResume();
        //Log.v(LOG_TAG, "onResume");
        setLayoutText();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Log.v(LOG_TAG, "onOptionsItemSelected");

        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setLayoutText(){
        String checkBoxValueActual = getString(R.string.pref_checkbox_key);
        String checkBoxValueDefault = getString(R.string.pref_checkbox_default);
        Boolean checkBoxValue =
                sharedPreferences.getBoolean(checkBoxValueActual, Boolean.valueOf(checkBoxValueDefault));

        //Log.v(LOG_TAG, "setLayoutText " + checkBoxValue.toString());
        checkBoxTextView.setText(checkBoxValue.toString());
    }
}

