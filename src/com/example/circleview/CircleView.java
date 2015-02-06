package com.example.circleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class CircleView extends View {
    private Bitmap bitmap;
    private ShapeDrawable shapeDrawable;
    private BitmapShader bitmapShader;
    private int width;

    public CircleView(Context context) {
        super(context);
         bitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.head)).getBitmap();
         width = Math.min(bitmap.getWidth(), bitmap.getHeight());
         bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setShader(bitmapShader);
        shapeDrawable.setBounds(0, 0, width, width);
        shapeDrawable.draw(canvas);
    }
}
