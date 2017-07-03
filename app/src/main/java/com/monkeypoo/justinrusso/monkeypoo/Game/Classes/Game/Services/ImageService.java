package com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.monkeypoo.justinrusso.monkeypoo.R;

/**
 * Created by justin.russo on 6/8/17.
 */

public class ImageService {
    private View view;
    private Context context;
    private Canvas canvas;

    public ImageService(Context context, Canvas canvas){
        view = new View(context);
        this.context = context;
        this.canvas = canvas;
    }

    public void drawImageOnCanvas(Canvas canvas, int resImage, boolean center){
        Bitmap image = BitmapFactory.decodeResource(this.context.getResources(), resImage);
        float newX = 0;
        float newY = 0;

        if (center) {
            newX = (-1) * ((image.getWidth() - canvas.getWidth()) / 2);
            newY = (-1) * ((image.getWidth() - canvas.getWidth()) / 2);
        }

        drawImageOnCanvas(canvas, resImage, newX, newY);
    }

    public void drawImageOnCanvas(Canvas canvas, int resImage, float x, float y){
        Bitmap image = BitmapFactory.decodeResource(this.context.getResources(), resImage);
        canvas.drawBitmap(image, x, y, new Paint());
    }
}
