package com.monkeypoo.justinrusso.monkeypoo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Panels.MainGamePanel;
import com.monkeypoo.justinrusso.monkeypoo.Game.Contants;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Contants.SCREEN_WIDTH = displayMetrics.widthPixels;
        Contants.SCREEN_HEIGHT = displayMetrics.heightPixels;

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(new MainGamePanel(this));
    }
}
