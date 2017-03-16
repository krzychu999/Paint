package com.example.mknizewski.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;


public class PaintView extends SurfaceView implements SurfaceHolder.Callback
{
    ArrayList<RectF> punkty;
    Paint paint = new Paint();

    public PaintView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        punkty= new ArrayList<>();
        paint=new Paint();
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3)
    {

    }
    public void surfaceCreated (SurfaceHolder arg0)
    {

    }
    public void surfaceDestroyed(SurfaceHolder arg0)
    {

    }
    public boolean onTouchEvent(MotionEvent event)
    {
        RectF oval = new RectF(event.getX()-50, event.getY()-50, event.getX(), event.getY());
        punkty.add(oval);
        invalidate();
        return true;
    }
    protected void onDraw(Canvas canvas)
    {
        paint.setColor(Color.RED);
        for(RectF punkt : punkty)
        {
            canvas.drawOval(punkt,paint);
        }
    }
}
