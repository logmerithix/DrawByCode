package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{
    boolean blnShowText;
    int intTextPosition;

    Paint pntTextPaint;     // Painting object to handle the paint jobs for text
    Paint pntBlackPaint;    // Painting object to handle the paint jobs for graphics
    Paint pntBlackLinePaint;
    Paint pntRedPaint;      // Painting object to handle the paint jobs for graphics

    public DrawingArea(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init()
    {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlackLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntRedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntBlackPaint.setColor(Color.BLACK);
        pntBlackPaint.setStrokeWidth(3);

        pntBlackLinePaint.setColor(Color.BLACK);
        pntBlackLinePaint.setStrokeWidth(10);

        pntRedPaint.setColor(Color.RED);
        pntRedPaint.setStrokeWidth(3);

    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.

        super.onSizeChanged(w, h, oldw, oldh);

    }

    protected void onDraw(Canvas canvas)
    {
        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.


     /*
        super.onDraw(canvas);
        //                Left            Top              Right         Bottom
        canvas.drawRect((float) 295.0, (float) 300.0, (float) 305.0, (float) 500.0, pntBlackPaint);
        //                 X Pos             Y Pos        Diameter
        canvas.drawCircle((float) 300.0, (float) 250.0, (float) 50.0, pntBlackPaint);
        //                  Start X      Start Y          End X          End Y
        canvas.drawLine((float) 295.0, (float) 300.0, (float) 200.0, (float) 450.0, pntBlackLinePaint);

        canvas.drawLine((float) 305.0, (float) 300.0, (float) 395.0, (float) 450.0, pntBlackLinePaint);

        canvas.drawLine((float) 295.0, (float) 498.0, (float) 200.0, (float) 650.0, pntBlackLinePaint);

        canvas.drawLine((float) 305.0, (float) 498.0, (float) 395.0, (float) 650.0, pntBlackLinePaint);

     */

     /*
        for (int l = 0; l < 720; l += 15){
        canvas.drawLine((float) l, (float) 0.0, (float) l, (float) 1275.0, pntBlackPaint);
        } for (int h = 0; h < 1280; h += 15)  {
          canvas.drawLine((float) 0.0, (float) h, (float) 645.0, (float) h, pntBlackPaint);
        }

     */

        for (int l = 0; l < 645; l += 50) {
        canvas.drawRect((float) l, (float) 0.0, (float) 50+l, (float) 50.0, pntBlackPaint);
        }

    }


}
