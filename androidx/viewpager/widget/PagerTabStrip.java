package androidx.viewpager.widget;

import P1.c;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip extends PagerTitleStrip {
    public final int B;
    public final int D;
    public final int E;
    public final int G;
    public final int I;
    public final Paint M;
    public final Rect N;
    public int S;
    public boolean T;
    public boolean V;
    public final int W;
    public boolean b0;
    public float c0;
    public float d0;
    public final int e0;
    public int w;

    public PagerTabStrip(Context context0) {
        this(context0, null);
    }

    public PagerTabStrip(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        Paint paint0 = new Paint();
        this.M = paint0;
        this.N = new Rect();
        this.S = 0xFF;
        this.T = false;
        this.V = false;
        this.w = this.n;
        paint0.setColor(this.n);
        DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
        this.B = (int)(3.0f * displayMetrics0.density + 0.5f);
        this.D = (int)(6.0f * displayMetrics0.density + 0.5f);
        this.E = (int)(64.0f * displayMetrics0.density);
        this.I = (int)(16.0f * displayMetrics0.density + 0.5f);
        this.W = (int)(1.0f * displayMetrics0.density + 0.5f);
        this.G = (int)(displayMetrics0.density * 32.0f + 0.5f);
        this.e0 = ViewConfiguration.get(context0).getScaledTouchSlop();
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        this.setTextSpacing(this.getTextSpacing());
        this.setWillNotDraw(false);
        this.b.setFocusable(true);
        b b0 = new b(this, 0);
        this.b.setOnClickListener(b0);
        this.d.setFocusable(true);
        b b1 = new b(this, 1);
        this.d.setOnClickListener(b1);
        if(this.getBackground() == null) {
            this.T = true;
        }
    }

    @Override  // androidx.viewpager.widget.PagerTitleStrip
    public final void c(int v, boolean z, float f) {
        int v1 = this.getHeight();
        int v2 = this.c.getLeft();
        int v3 = this.c.getRight();
        int v4 = v1 - this.B;
        this.N.set(v2 - this.I, v4, v3 + this.I, v1);
        super.c(v, z, f);
        this.S = (int)(Math.abs(f - 0.5f) * 510.0f);
        int v5 = this.c.getLeft();
        int v6 = this.c.getRight();
        this.N.union(v5 - this.I, v4, v6 + this.I, v1);
        this.invalidate(this.N);
    }

    public boolean getDrawFullUnderline() {
        return this.T;
    }

    @Override  // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.G);
    }

    public int getTabIndicatorColor() {
        return this.w;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        int v = this.getHeight();
        int v1 = this.c.getLeft();
        int v2 = this.c.getRight();
        Paint paint0 = this.M;
        paint0.setColor(this.S << 24 | this.w & 0xFFFFFF);
        canvas0.drawRect(((float)(v1 - this.I)), ((float)(v - this.B)), ((float)(v2 + this.I)), ((float)v), paint0);
        if(this.T) {
            paint0.setColor(0xFF000000 | this.w);
            float f = (float)this.getPaddingLeft();
            int v3 = this.getWidth();
            int v4 = this.getPaddingRight();
            canvas0.drawRect(f, ((float)(v - this.W)), ((float)(v3 - v4)), ((float)v), paint0);
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        if(v != 0 && this.b0) {
            return false;
        }
        float f = motionEvent0.getX();
        float f1 = motionEvent0.getY();
        switch(v) {
            case 0: {
                this.c0 = f;
                this.d0 = f1;
                this.b0 = false;
                return true;
            label_11:
                if(v == 2) {
                    float f2 = (float)this.e0;
                    if(Math.abs(f - this.c0) > f2 || Math.abs(f1 - this.d0) > f2) {
                        this.b0 = true;
                        return true;
                    }
                }
                break;
            }
            case 1: {
                TextView textView0 = this.c;
                int v1 = textView0.getLeft();
                int v2 = this.I;
                if(f < ((float)(v1 - v2))) {
                    this.a.setCurrentItem(this.a.getCurrentItem() - 1);
                    return true;
                }
                if(f > ((float)(textView0.getRight() + v2))) {
                    this.a.setCurrentItem(this.a.getCurrentItem() + 1);
                }
                break;
            }
            default: {
                goto label_11;
            }
        }
        return true;
    }

    @Override  // android.view.View
    public void setBackgroundColor(int v) {
        super.setBackgroundColor(v);
        if(!this.V) {
            this.T = (v & 0xFF000000) == 0;
        }
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        if(!this.V) {
            this.T = drawable0 == null;
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        if(!this.V) {
            this.T = v == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.T = z;
        this.V = true;
        this.invalidate();
    }

    @Override  // android.view.View
    public final void setPadding(int v, int v1, int v2, int v3) {
        int v4 = this.D;
        if(v3 < v4) {
            v3 = v4;
        }
        super.setPadding(v, v1, v2, v3);
    }

    public void setTabIndicatorColor(int v) {
        this.w = v;
        this.M.setColor(v);
        this.invalidate();
    }

    public void setTabIndicatorColorResource(int v) {
        this.setTabIndicatorColor(c.getColor(this.getContext(), v));
    }

    @Override  // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int v) {
        int v1 = this.E;
        if(v < v1) {
            v = v1;
        }
        super.setTextSpacing(v);
    }
}

