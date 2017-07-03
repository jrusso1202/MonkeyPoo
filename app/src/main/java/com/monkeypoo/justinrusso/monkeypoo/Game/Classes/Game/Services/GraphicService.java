package com.monkeypoo.justinrusso.monkeypoo.Game.Classes.Game.Services;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by justin.russo on 6/10/17.
 */

public class GraphicService {
    private Canvas canvas;

    public GraphicService(Canvas canvas) {
        this.canvas = canvas;
    }

    public Rect drawButton(int buttonColor, int textColor, String text, float textSize){
        Paint buttonPaint = new Paint();
        Paint textPaint = new Paint();
        Rect button = new Rect();
        button.set((canvas.getWidth() / 2) - 450, (canvas.getHeight() / 2) + 300, (canvas.getWidth() / 2) + 450, (canvas.getHeight() / 2) + 450);
        RectF buttonRounded = new RectF(button);
        Rect textBounds = new Rect();

        buttonPaint.setColor(buttonColor);
        textPaint.setColor(textColor);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(textSize);
        textPaint.getTextBounds(text, 0, text.length(), textBounds);
        float textX = button.left + ((button.width() / 2) - (textBounds.width() / 2));
        float textY = button.top + ((button.height()) - (textBounds.height() / 2));
        canvas.drawRoundRect(buttonRounded, 25, 25, buttonPaint);
        canvas.drawText(text, textX, textY, textPaint);

        return button;
    }
}
