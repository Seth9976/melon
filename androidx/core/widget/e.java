package androidx.core.widget;

import E9.t;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.o0;

public final class e implements View.OnTouchListener {
    public static final int B;
    public final a a;
    public final AccelerateInterpolator b;
    public final o0 c;
    public t d;
    public final float[] e;
    public final float[] f;
    public final int g;
    public final int h;
    public final float[] i;
    public final float[] j;
    public final float[] k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean r;
    public final o0 w;

    static {
        e.B = 100;
    }

    public e(o0 o00) {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.e = 0x8000000000000000L;
        a0.g = -1L;
        a0.f = 0L;
        this.a = a0;
        this.b = new AccelerateInterpolator();
        float[] arr_f = {0.0f, 0.0f};
        this.e = arr_f;
        float[] arr_f1 = {3.402823E+38f, 3.402823E+38f};
        this.f = arr_f1;
        float[] arr_f2 = {0.0f, 0.0f};
        this.i = arr_f2;
        float[] arr_f3 = {0.0f, 0.0f};
        this.j = arr_f3;
        float[] arr_f4 = {3.402823E+38f, 3.402823E+38f};
        this.k = arr_f4;
        this.c = o00;
        DisplayMetrics displayMetrics0 = Resources.getSystem().getDisplayMetrics();
        int v = (int)(displayMetrics0.density * 315.0f + 0.5f);
        float f = ((float)(((int)(1575.0f * displayMetrics0.density + 0.5f)))) / 1000.0f;
        arr_f4[0] = f;
        arr_f4[1] = f;
        arr_f3[0] = ((float)v) / 1000.0f;
        arr_f3[1] = ((float)v) / 1000.0f;
        this.g = 1;
        arr_f1[0] = 3.402823E+38f;
        arr_f1[1] = 3.402823E+38f;
        arr_f[0] = 0.2f;
        arr_f[1] = 0.2f;
        arr_f2[0] = 0.001f;
        arr_f2[1] = 0.001f;
        this.h = e.B;
        a0.a = 500;
        a0.b = 500;
        this.w = o00;
    }

    public final float a(float f, float f1, float f2, int v) {
        float f5;
        float f3 = e.b(this.e[v] * f1, 0.0f, this.f[v]);
        float f4 = this.c(f1 - f, f3) - this.c(f, f3);
        AccelerateInterpolator accelerateInterpolator0 = this.b;
        if(Float.compare(f4, 0.0f) < 0) {
            f5 = e.b(-accelerateInterpolator0.getInterpolation(-f4), -1.0f, 1.0f);
        }
        else {
            f5 = f4 > 0.0f ? e.b(accelerateInterpolator0.getInterpolation(f4), -1.0f, 1.0f) : 0.0f;
        }
        int v1 = Float.compare(f5, 0.0f);
        if(v1 == 0) {
            return 0.0f;
        }
        float f6 = this.i[v];
        float f7 = this.j[v];
        float f8 = this.k[v];
        float f9 = f6 * f2;
        return v1 <= 0 ? -e.b(-f5 * f9, f7, f8) : e.b(f5 * f9, f7, f8);
    }

    public static float b(float f, float f1, float f2) {
        if(f > f2) {
            return f2;
        }
        return f < f1 ? f1 : f;
    }

    public final float c(float f, float f1) {
        if(f1 != 0.0f) {
            int v = this.g;
            if(v != 0 && v != 1) {
                return v != 2 || f >= 0.0f ? 0.0f : f / -f1;
            }
            if(f < f1) {
                if(Float.compare(f, 0.0f) >= 0) {
                    return 1.0f - f / f1;
                }
                return !this.o || v != 1 ? 0.0f : 1.0f;
            }
        }
        return 0.0f;
    }

    public final void d() {
        int v = 0;
        if(this.m) {
            this.o = false;
            return;
        }
        long v1 = AnimationUtils.currentAnimationTimeMillis();
        a a0 = this.a;
        int v2 = (int)(v1 - a0.e);
        int v3 = a0.b;
        if(v2 > v3) {
            v = v3;
        }
        else if(v2 >= 0) {
            v = v2;
        }
        a0.i = v;
        a0.h = a0.a(v1);
        a0.g = v1;
    }

    public final boolean e() {
        int v = (int)(this.a.d / Math.abs(this.a.d));
        if(v != 0) {
            o0 o00 = this.w;
            int v1 = o00.getCount();
            if(v1 != 0) {
                int v2 = o00.getChildCount();
                int v3 = o00.getFirstVisiblePosition();
                return v <= 0 ? v < 0 && (v3 > 0 || o00.getChildAt(0).getTop() < 0) : v3 + v2 < v1 || o00.getChildAt(v2 - 1).getBottom() > o00.getHeight();
            }
        }
        return false;
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        if(this.r) {
            switch(motionEvent0.getActionMasked()) {
                case 0: {
                    this.n = true;
                    this.l = false;
                    break;
                }
                case 2: {
                    break;
                }
                case 1: 
                case 3: {
                    this.d();
                    return false;
                }
                default: {
                    return false;
                }
            }
            float f = motionEvent0.getX();
            float f1 = (float)view0.getWidth();
            o0 o00 = this.c;
            float f2 = this.a(f, f1, ((float)o00.getWidth()), 0);
            float f3 = this.a(motionEvent0.getY(), ((float)view0.getHeight()), ((float)o00.getHeight()), 1);
            this.a.c = f2;
            this.a.d = f3;
            if(!this.o && this.e()) {
                if(this.d == null) {
                    this.d = new t(this, 7);
                }
                this.o = true;
                this.m = true;
                if(this.l) {
                    this.d.run();
                }
                else {
                    int v = this.h;
                    if(v > 0) {
                        o00.postOnAnimationDelayed(this.d, ((long)v));
                    }
                    else {
                        this.d.run();
                    }
                }
                this.l = true;
            }
        }
        return false;
    }
}

