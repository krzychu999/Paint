package com.example.mknizewski.paint;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;


public class PaintView extends SurfaceView implements SurfaceHolder.Callback {

    ArrayList<ObiektDoNarysowania> punkty;
    Paint paint = new Paint();
    private int color;
    private int rozmiar;

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        punkty = new ArrayList<>();
        paint = new Paint();
        color = Color.RED;

    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {

    }

    public void surfaceCreated(SurfaceHolder arg0) {

    }

    public void surfaceDestroyed(SurfaceHolder arg0) {

    }

    public boolean onTouchEvent(MotionEvent event) {

        RectF oval = new RectF(event.getX() - rozmiar, event.getY() - rozmiar, event.getX() + rozmiar, event.getY() + rozmiar);
        punkty.add(new ObiektDoNarysowania(color, oval));
        invalidate();


        return true;
    }

    protected void onDraw(Canvas canvas) {

        for (ObiektDoNarysowania punkt : punkty) {
            paint.setColor(punkt.kolor);
            canvas.drawOval(punkt.figura, paint);
        }

    }
    public void setRozmiar(int rozmiar)
    {
        this.rozmiar = rozmiar;
    }
    public int getRozmiar()
    {
        return rozmiar;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void clearView()
    {
        punkty.clear();
        invalidate();
    }
}
