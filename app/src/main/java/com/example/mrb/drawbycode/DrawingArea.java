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
    Paint pntGreenPaint;

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
        pntGreenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntBlackPaint.setColor(Color.BLACK);
        pntBlackPaint.setStrokeWidth(3);

        pntBlackLinePaint.setColor(Color.BLACK);
        pntBlackLinePaint.setStrokeWidth(10);

        pntRedPaint.setColor(Color.RED);
        pntRedPaint.setStrokeWidth(3);

        pntGreenPaint.setColor(Color.GREEN);
        pntGreenPaint.setStrokeWidth(3);

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
        canvas.drawRect((float) 0.0, (float) 0.0,(float)720.0,(float) 1080.0, pntGreenPaint);


        float top = (float)0;
        float bottom = (float)82;
        float left = (float)0;
        float right = (float)82;
        int a = 0;


                while(a < 52) {
                    canvas.drawRect(left, top, right, bottom, pntBlackPaint);
                    left = left + 164;
                    right = right + 164;
                    a = a + 1;

                    if(a == 4 || a == 12 || a == 20 || a == 28 || a == 36 || a == 44){
                        top = top + 82;
                        bottom = bottom + 82;
                        left = 82;
                        right = 164;
                    }

                    if (a == 8 || a == 16 || a == 24 || a == 24 || a == 32 || a == 40 || a ==48) {
                        top = top + 82;
                        bottom = bottom + 82;
                        left = 0;
                        right = 82;
                    }
                }


    }


}
