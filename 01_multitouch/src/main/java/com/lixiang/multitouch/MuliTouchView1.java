package com.lixiang.multitouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;

public class MuliTouchView1 extends View {
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    public MuliTouchView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    {
        bitmap=Util.getAvator(getResources(),R.drawable.avator,500);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,(getWidth()-bitmap.getWidth())/2,(getHeight()-bitmap.getHeight())/2,paint);
    }

    private float downX,downY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getRawX();
        float y=event.getRawY();
        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                downX=x;
                downY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx=x-downX;
                float dy=y-downY;
                setX(getX()+dx);
                setY(getY()+dy);
                downX=x;
                downY=y;
                offsetXY();
                break;
        }
        return true;
    }
    private void offsetXY()
    {
        setX(Math.max(-(getWidth()-bitmap.getWidth())/2,getX()));
        setX(Math.min((getWidth()-bitmap.getWidth())/2,getX()));
        setY(Math.max(-(getHeight()-bitmap.getWidth())/2,getY()));
        setY(Math.min((getHeight()-bitmap.getHeight())/2,getY()));
    }
}
