package com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Services;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by justin.russo on 6/7/17.
 */

public class TextService {
    private Rect centerTextRectangle;
    private Paint paint = new Paint();

    public TextService() {
        this.centerTextRectangle = new Rect();
    }

    public void drawText (Canvas canvas, String text, int textSize, float x, float y) {
        paint.setTextSize(textSize);
        paint.setColor(Color.MAGENTA);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text, x, y, paint);
    }

    public void drawCenterText(Canvas canvas, String text) {
        drawCenterText(canvas, text, 100);
    }

    public void drawCenterText(Canvas canvas, String text, int textSize) {
        canvas.getClipBounds(centerTextRectangle);
        int cHeight = centerTextRectangle.height();
        int cWidth = centerTextRectangle.width();
        paint.getTextBounds(text, 0, text.length(), centerTextRectangle);
        float x = cWidth / 2f - centerTextRectangle.width() / 2f - centerTextRectangle.left;
        float y = cHeight / 2f + centerTextRectangle.height() / 2f - centerTextRectangle.bottom;
        this.drawText(canvas, text, textSize, x, y);
    }
}
