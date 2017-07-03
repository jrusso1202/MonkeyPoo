package com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Services;

import java.io.File;
import java.io.FileOutputStream;
import android.content.Context;
import android.content.SharedPreferences;

import com.monkeypoo.justinrusso.monkeypoo.R;


/**
 * Created by justin.russo on 6/11/17.
 */

public class DataService {
    private FileOutputStream fileOutputStream;
    private Context context;
    private String PREFERENCES_SAVE_FILE = "monkey_poo_save";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;

    public DataService(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCES_SAVE_FILE, Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
    }

    public boolean resourceExists (int key) {
        String name = context.getResources().getResourceName(key);
        return name != null;
    }

    public void setInteger (int key, int Value) {
        sharedPreferencesEditor.putInt(context.getString(key), Value);
        sharedPreferencesEditor.commit();
    }

    public void setString (int key, String Value) {
        sharedPreferencesEditor.putString(context.getString(key), Value);
        sharedPreferencesEditor.commit();
    }

    public int getInteger (int key) {
        return sharedPreferences.getInt(context.getString(key), -1);
    }

    public String getString (int key) {
        return sharedPreferences.getString(context.getString(key), null);
    }
}
