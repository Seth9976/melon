package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

public class TranslationView extends RelativeLayout {
    public final int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public TranslationView(Context context0) {
        this(context0, null);
    }

    public TranslationView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public TranslationView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.d = false;
        this.e = false;
        this.a = ViewConfiguration.get(context0).getScaledTouchSlop();
    }

    public int getHeaderHeight() {
        return 0;
    }

    public int getMinHeaderHeight() {
        return this.c;
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.setClickable(true);
    }

    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getAction()) {
            case 0: {
                this.b = (int)motionEvent0.getY();
                this.e = true;
                this.d = true;
                return super.onInterceptTouchEvent(motionEvent0);
            }
            case 1: {
                this.e = false;
                return super.onInterceptTouchEvent(motionEvent0);
            }
            case 2: {
                if(!this.d) {
                    return true;
                }
                int v = Math.abs(this.b - ((int)motionEvent0.getY()));
                this.e = false;
                if(v > this.a) {
                    this.d = false;
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent0);
            }
            default: {
                return super.onInterceptTouchEvent(motionEvent0);
            }
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getAction()) {
            case 1: {
                this.e = false;
                return super.onTouchEvent(motionEvent0);
            }
            case 2: {
                if(!this.d) {
                    return false;
                }
                int v = Math.abs(this.b - ((int)motionEvent0.getY()));
                this.e = false;
                if(v > this.a) {
                    this.d = false;
                    return false;
                }
                return super.onTouchEvent(motionEvent0);
            }
            default: {
                return super.onTouchEvent(motionEvent0);
            }
        }
    }

    public void setMinHeaderHeight(int v) {
        this.c = v;
    }
}

