package com.lindong.yangbo.meshview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/19.
 */
public class MeshView extends View {

    private int row = 3;
    private int column = 3;
    private boolean showBorder = true;
    private int lineColor = Color.GREEN;
    private float lineWidth = 1;

    private Paint mPaint;

    public MeshView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MeshView);
        row = a.getInt(R.styleable.MeshView_row, row);
        column = a.getInt(R.styleable.MeshView_column, column);
        showBorder = a.getBoolean(R.styleable.MeshView_showBorder, showBorder);
        lineColor = a.getColor(R.styleable.MeshView_lineColor, lineColor);
        lineWidth = a.getDimension(R.styleable.MeshView_lineWidth, lineWidth);
        a.recycle();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(lineColor);
        mPaint.setStrokeWidth(lineWidth);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int viewWidth = getWidth();
        final int viewHeight = getHeight();

        float halfLineWidth = lineWidth / 2;
        if(showBorder){
            canvas.drawLine(0, halfLineWidth, viewWidth, halfLineWidth, mPaint);    //top
            canvas.drawLine(0, viewHeight - halfLineWidth, viewWidth, viewHeight - halfLineWidth, mPaint);    //bottom
            canvas.drawLine(halfLineWidth, 0, halfLineWidth, viewHeight, mPaint);    //left
            canvas.drawLine(viewWidth - halfLineWidth, 0, viewWidth - halfLineWidth
                    , viewHeight, mPaint);    //right
        }

        float verticalGap = ((float)viewHeight) / row;
        for(int i = 1; i <= row; i++){
            canvas.drawLine(0, i * verticalGap, viewWidth, i * verticalGap, mPaint);
        }

        float horizontalGap = ((float)viewWidth) / column;
        for(int i = 1; i <= column; i++){
            canvas.drawLine(i * horizontalGap, 0, i * horizontalGap, viewHeight, mPaint);
        }
    }
}
