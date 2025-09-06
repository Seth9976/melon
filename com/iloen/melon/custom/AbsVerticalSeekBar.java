package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import k8.t1;

public class AbsVerticalSeekBar extends VerticalProgressBar {
    public int B;
    public final float D;
    public Drawable o;
    public int r;
    public final boolean w;

    public AbsVerticalSeekBar(Context context0) {
        super(context0);
        this.w = true;
        this.B = 1;
    }

    public AbsVerticalSeekBar(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.w = true;
        this.B = 1;
    }

    public AbsVerticalSeekBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.w = true;
        this.B = 1;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.D, v, 0);
        this.setThumb(typedArray0.getDrawable(0));
        this.setThumbOffset(typedArray0.getDimensionPixelOffset(1, this.getThumbOffset()));
        typedArray0.recycle();
        TypedArray typedArray1 = context0.obtainStyledAttributes(attributeSet0, t1.I, 0, 0);
        this.D = typedArray1.getFloat(0, 0.5f);
        typedArray1.recycle();
    }

    @Override  // com.iloen.melon.custom.VerticalProgressBar
    public void b(float f, boolean z) {
        Drawable drawable0 = this.o;
        if(drawable0 != null) {
            this.f(this.getHeight(), drawable0, f, 0x80000000);
            this.invalidate();
        }
    }

    @Override  // com.iloen.melon.custom.VerticalProgressBar
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable0 = this.getProgressDrawable();
        if(drawable0 != null) {
            drawable0.setAlpha((this.isEnabled() ? 0xFF : ((int)(this.D * 255.0f))));
        }
        if(this.o != null && this.o.isStateful()) {
            int[] arr_v = this.getDrawableState();
            this.o.setState(arr_v);
        }
    }

    public final void f(int v, Drawable drawable0, float f, int v1) {
        int v7;
        int v2 = this.getPaddingTop();
        int v3 = this.getPaddingBottom();
        int v4 = drawable0.getIntrinsicWidth();
        int v5 = drawable0.getIntrinsicHeight();
        int v6 = (int)((1.0f - f) * ((float)(this.r * 2 + (v - v2 - v3 - v5))));
        if(v1 == 0x80000000) {
            Rect rect0 = drawable0.getBounds();
            v1 = rect0.left;
            v7 = rect0.right;
        }
        else {
            v7 = v1 + v4;
        }
        drawable0.setBounds(v1, v6, v7, v5 + v6);
    }

    public final void g(MotionEvent motionEvent0) {
        float f;
        int v = this.getPaddingTop();
        int v1 = this.getPaddingBottom();
        int v2 = this.getHeight();
        int v3 = v2 - v;
        int v4 = v2 - ((int)motionEvent0.getY());
        if(v4 < v1) {
            f = 0.0f;
        }
        else {
            f = v4 <= v3 ? ((float)(v4 - v1)) / ((float)(v3 - v1)) : 1.0f;
        }
        this.d(((int)(f * ((float)this.getMax()) + 0.0f)), true);
    }

    public int getKeyProgressIncrement() {
        return this.B;
    }

    public int getThumbOffset() {
        return this.r;
    }

    @Override  // com.iloen.melon.custom.VerticalProgressBar
    public final void onDraw(Canvas canvas0) {
        synchronized(this) {
            super.onDraw(canvas0);
            if(this.o != null) {
                canvas0.save();
                canvas0.translate(((float)this.getPaddingLeft()), ((float)(this.getPaddingTop() - this.r)));
                this.o.draw(canvas0);
                canvas0.restore();
            }
        }
    }

    @Override  // android.view.View
    public final boolean onKeyDown(int v, KeyEvent keyEvent0) {
        int v1 = this.getProgress();
        switch(v) {
            case 19: {
                if(v1 < this.getMax()) {
                    this.d(v1 + this.B, true);
                    return true;
                }
                break;
            }
            case 20: {
                if(v1 > 0) {
                    this.d(v1 - this.B, true);
                    return true;
                }
                break;
            }
            default: {
                return super.onKeyDown(v, keyEvent0);
            }
        }
        return super.onKeyDown(v, keyEvent0);
    }

    @Override  // com.iloen.melon.custom.VerticalProgressBar
    public final void onMeasure(int v, int v1) {
        int v6;
        synchronized(this) {
            Drawable drawable0 = this.getCurrentDrawable();
            int v3 = 0;
            int v4 = this.o == null ? 0 : this.o.getIntrinsicWidth();
            if(drawable0 == null) {
                v6 = 0;
            }
            else {
                drawable0.getIntrinsicWidth();
                v3 = Math.max(v4, 0);
                int v5 = Math.min(this.d, drawable0.getIntrinsicHeight());
                v6 = Math.max(this.c, v5);
            }
            int v7 = this.getPaddingLeft();
            int v8 = this.getPaddingRight();
            int v9 = this.getPaddingTop();
            int v10 = this.getPaddingBottom();
            this.setMeasuredDimension(View.resolveSize(v7 + v8 + v3, v), View.resolveSize(v9 + v10 + v6, v1));
        }
    }

    @Override  // com.iloen.melon.custom.VerticalProgressBar
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        Drawable drawable0 = this.getCurrentDrawable();
        Drawable drawable1 = this.o;
        int v4 = drawable1 == null ? 0 : drawable1.getIntrinsicWidth();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingRight();
        int v7 = this.getPaddingTop();
        int v8 = this.getPaddingBottom();
        int v9 = Math.min(this.b, v - v5 - v6);
        int v10 = this.getMax();
        float f = v10 <= 0 ? 0.0f : ((float)this.getProgress()) / ((float)v10);
        if(v4 > v9) {
            int v11 = (v4 - v9) / 2;
            if(drawable0 != null) {
                drawable0.setBounds(v11, 0, v - v6 - v5 - v11, v1 - v8 - v7);
            }
            if(drawable1 != null) {
                this.f(v1, drawable1, f, (v - v4) / 2 - v5);
            }
        }
        else {
            if(drawable0 != null) {
                drawable0.setBounds(0, 0, v - v6 - v5, v1 - v8 - v7);
            }
            if(drawable1 != null) {
                this.f(v1, drawable1, f, (v9 - v4) / 2);
            }
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(this.w && this.isEnabled()) {
            switch(motionEvent0.getAction()) {
                case 0: {
                    this.g(motionEvent0);
                    return true;
                }
                case 1: {
                    this.g(motionEvent0);
                    this.invalidate();
                    return true;
                }
                case 2: {
                    this.g(motionEvent0);
                    return true;
                }
                case 3: {
                    this.invalidate();
                    return true;
                }
                default: {
                    return true;
                }
            }
        }
        return false;
    }

    public void setKeyProgressIncrement(int v) {
        if(v < 0) {
            v = -v;
        }
        this.B = v;
    }

    @Override  // com.iloen.melon.custom.VerticalProgressBar
    public void setMax(int v) {
        synchronized(this) {
            super.setMax(v);
            if(this.B == 0 || this.getMax() / this.B > 20) {
                this.setKeyProgressIncrement(Math.max(1, Math.round(((float)this.getMax()) / 20.0f)));
            }
        }
    }

    public void setThumb(Drawable drawable0) {
        if(drawable0 != null) {
            drawable0.setCallback(this);
            this.r = drawable0.getIntrinsicHeight() / 2;
        }
        this.o = drawable0;
        this.invalidate();
    }

    public void setThumbOffset(int v) {
        this.r = v;
        this.invalidate();
    }

    @Override  // com.iloen.melon.custom.VerticalProgressBar
    public final boolean verifyDrawable(Drawable drawable0) {
        return drawable0 == this.o || super.verifyDrawable(drawable0);
    }
}

