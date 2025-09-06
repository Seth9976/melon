package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import d5.f;
import k8.t1;

public class IndexableBar extends RelativeLayout {
    public final float a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public float f;
    public TextPaint g;
    public static final String[] h;

    static {
        IndexableBar.h = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "A", "F", "K", "P", "U", "Z", "#"};
    }

    public IndexableBar(Context context0) {
        super(context0);
        this.a();
    }

    public IndexableBar(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.l, 0, 0);
        this.b = typedArray0.getColor(1, 0xFF000000);
        this.c = (float)typedArray0.getDimensionPixelSize(0, 0);
        this.a = (float)typedArray0.getDimensionPixelSize(4, 0);
        this.d = (float)typedArray0.getDimensionPixelSize(2, 0);
        this.e = (float)typedArray0.getDimensionPixelSize(3, 0);
        typedArray0.recycle();
        this.a();
    }

    public final void a() {
        Typeface typeface0 = f.F(this.getContext());
        TextPaint textPaint0 = new TextPaint();
        this.g = textPaint0;
        textPaint0.setFlags(1);
        this.g.setTextAlign(Paint.Align.CENTER);
        this.g.setTextSize(this.c);
        this.g.setColor(this.b);
        this.g.setTypeface(typeface0);
        this.f = this.e / 2.0f;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        for(int v = 0; v < 21; ++v) {
            float f = this.g.measureText(IndexableBar.h[v]);
            canvas0.drawText(IndexableBar.h[v], this.f, (this.a + f) / 2.0f + (((float)v) * this.a + this.d), this.g);
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        motionEvent0.getAction();
        motionEvent0.getY();
        return true;
    }

    public void setOnLetterSelectListener(X x0) {
    }
}

