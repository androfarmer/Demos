package com.lixiang.multitouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MuliTouchView2 extends View {
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    public MuliTouchView2(Context context, @Nullable AttributeSet attrs) {
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
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return true;
    }

}
