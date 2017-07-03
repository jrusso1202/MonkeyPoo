package com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Services;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Constants;
import com.monkeypoo.justinrusso.monkeypoo.R;

/**
 * Created by justin.russo on 6/10/17.
 */

public class GameService {
    private DataService dataService;
    private ImageService imageService;
    private Canvas canvas;
    private Context context;
    private GraphicService graphicService;
    private boolean gameStarted;
    public Constants.Levels level;

    public GameService(Context context, Canvas canvas){
        this.context = context;
        this.canvas = canvas;
        imageService = new ImageService(context, canvas);
        graphicService = new GraphicService(canvas);
        dataService = new DataService(context);
    }

    public Rect displayMainScreen(){
        imageService.drawImageOnCanvas(canvas, R.drawable.homescreen, true);

        return graphicService.drawButton(Color.rgb(241, 128, 21), Color.WHITE, "start flinging poo", 100);
    }

    public void startGame() {
        dataService = new DataService(context);
        getLevel();
        gameStarted = true;
    }

    public void process() {
        if (gameStarted) {

            switch (level) {
                case LEVEL1:
                    Constants.Levels l = level;
                    break;
            }
        }
    }

    //PRIVATE METHODS
    private void getLevel() {
        int returnLevelInt = dataService.getInteger(R.integer.Level);

        if (returnLevelInt > -1) {
            level = Constants.Levels.values()[returnLevelInt - 1];
        } else {
            dataService.setInteger(R.integer.Level, 1);
            level = Constants.Levels.LEVEL1;
        }
    }

    private void setLevel(Constants.Levels newLevel) {
        dataService.setInteger(R.integer.Level, newLevel.ordinal() + 1);
        level = newLevel;
    }
}
