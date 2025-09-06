package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class TranslationParallaxView extends FrameLayout {
    public final int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;

    public TranslationParallaxView(Context context0) {
        this(context0, null);
    }

    public TranslationParallaxView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public TranslationParallaxView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.c = -1;
        this.d = false;
        this.e = false;
        this.f = false;
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
        int v = motionEvent0.getAction();
        switch(v) {
            case 0: {
                this.b = (int)motionEvent0.getY();
                this.e = true;
                this.d = true;
                this.f = false;
                break;
            }
            case 1: {
                this.e = false;
                return super.onInterceptTouchEvent(motionEvent0);
            label_5:
                if(v == 2) {
                    if(!this.d) {
                        return true;
                    }
                    int v1 = Math.abs(this.b - ((int)motionEvent0.getY()));
                    this.e = false;
                    if(v1 > this.a) {
                        this.d = false;
                        this.f = true;
                        return true;
                    }
                }
                break;
            }
            default: {
                goto label_5;
            }
        }
        return super.onInterceptTouchEvent(motionEvent0);
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
                    this.f = true;
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

