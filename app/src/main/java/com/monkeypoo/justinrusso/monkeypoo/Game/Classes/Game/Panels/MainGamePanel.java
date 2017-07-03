package com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Panels;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Services.GameService;
import com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Resource.MainThread;

/**
 * Created by justin.russo on 6/7/17.
 */

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private GameService gameService;
    private Context context;
    private Rect startGameButton;
    public boolean gameStarted;

    public MainGamePanel(Context context) {
        super(context);

        this.context = context;
        gameStarted = false;

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);

        setFocusable(true);
    }

    @Override
    public void surfaceChanged (SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated (SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed (SurfaceHolder holder) {
        boolean retry = true;

        while (true) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        int positionX = (int)event.getX();
        int positionY = (int)event.getY();
        boolean test = false;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (gameService != null && !gameStarted && startGameButton.contains(positionX, positionY)) {
                    gameService.startGame();
                    gameStarted = true;
                }
                break;
        }

        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (gameService == null) {
            gameService = new GameService(context, canvas);
        }

        canvas.drawColor(Color.WHITE);

        gameService.process();
    }

    public void displayMainScreen(Canvas canvas){
        startGameButton = gameService.displayMainScreen();
    }
}
