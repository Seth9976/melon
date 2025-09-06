package j2;

import E9.t;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.viewpager.widget.e;
import e.k;
import java.util.Arrays;

public final class c {
    public int a;
    public int b;
    public int c;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public final float m;
    public float n;
    public int o;
    public final int p;
    public int q;
    public final OverScroller r;
    public final k s;
    public View t;
    public boolean u;
    public final ViewGroup v;
    public final t w;
    public static final e x;

    static {
        c.x = new e(1);
    }

    public c(Context context0, ViewGroup viewGroup0, k k0) {
        this.c = -1;
        this.w = new t(this, 21);
        if(k0 == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.v = viewGroup0;
        this.s = k0;
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
        int v = (int)(context0.getResources().getDisplayMetrics().density * 20.0f + 0.5f);
        this.p = v;
        this.o = v;
        this.b = viewConfiguration0.getScaledTouchSlop();
        this.m = (float)viewConfiguration0.getScaledMaximumFlingVelocity();
        this.n = (float)viewConfiguration0.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context0, c.x);
    }

    public final void a() {
        this.b();
        if(this.a == 2) {
            this.r.getCurrX();
            this.r.getCurrY();
            this.r.abortAnimation();
            int v = this.r.getCurrX();
            int v1 = this.r.getCurrY();
            this.s.H(this.t, v, v1);
        }
        this.r(0);
    }

    public final void b() {
        this.c = -1;
        float[] arr_f = this.d;
        if(arr_f != null) {
            Arrays.fill(arr_f, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
        VelocityTracker velocityTracker0 = this.l;
        if(velocityTracker0 != null) {
            velocityTracker0.recycle();
            this.l = null;
        }
    }

    public final void c(View view0, int v) {
        ViewParent viewParent0 = view0.getParent();
        ViewGroup viewGroup0 = this.v;
        if(viewParent0 != viewGroup0) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper\'s tracked parent view (" + viewGroup0 + ")");
        }
        this.t = view0;
        this.c = v;
        this.s.F(view0, v);
        this.r(1);
    }

    public final boolean d(float f, float f1, int v, int v1) {
        float f2 = Math.abs(f);
        float f3 = Math.abs(f1);
        if((this.h[v] & v1) == v1 && (this.q & v1) != 0 && (this.j[v] & v1) != v1 && (this.i[v] & v1) != v1) {
            float f4 = (float)this.b;
            if(f2 > f4 || f3 > f4) {
                if(f2 < f3 * 0.5f) {
                    this.s.getClass();
                }
                return (this.i[v] & v1) == 0 && f2 > ((float)this.b);
            }
        }
        return false;
    }

    public final boolean e(View view0, float f, float f1) {
        if(view0 != null) {
            boolean z = this.s.v(view0) > 0;
            boolean z1 = this.s.w() > 0;
            if(z && z1) {
                return f1 * f1 + f * f > ((float)(this.b * this.b));
            }
            return z ? Math.abs(f) > ((float)this.b) : z1 && Math.abs(f1) > ((float)this.b);
        }
        return false;
    }

    public final void f(int v) {
        float[] arr_f = this.d;
        if(arr_f != null) {
            int v1 = this.k;
            if((v1 & 1 << v) != 0) {
                arr_f[v] = 0.0f;
                this.e[v] = 0.0f;
                this.f[v] = 0.0f;
                this.g[v] = 0.0f;
                this.h[v] = 0;
                this.i[v] = 0;
                this.j[v] = 0;
                this.k = ~(1 << v) & v1;
            }
        }
    }

    public final int g(int v, int v1, int v2) {
        if(v == 0) {
            return 0;
        }
        int v3 = this.v.getWidth();
        int v4 = Math.abs(v1);
        return v4 <= 0 ? Math.min(((int)((((float)Math.abs(v)) / ((float)v2) + 1.0f) * 256.0f)), 600) : Math.min(Math.round(Math.abs((((float)Math.sin((Math.min(1.0f, ((float)Math.abs(v)) / ((float)v3)) - 0.5f) * 0.471239f)) * ((float)(v3 / 2)) + ((float)(v3 / 2))) / ((float)v4)) * 1000.0f) * 4, 600);
    }

    public final boolean h() {
        if(this.a == 2) {
            OverScroller overScroller0 = this.r;
            boolean z = overScroller0.computeScrollOffset();
            int v = overScroller0.getCurrX();
            int v1 = overScroller0.getCurrY();
            int v2 = v - this.t.getLeft();
            int v3 = v1 - this.t.getTop();
            if(v2 != 0) {
                this.t.offsetLeftAndRight(v2);
            }
            if(v3 != 0) {
                this.t.offsetTopAndBottom(v3);
            }
            if(v2 != 0 || v3 != 0) {
                this.s.H(this.t, v, v1);
            }
            if(z && v == overScroller0.getFinalX() && v1 == overScroller0.getFinalY()) {
                overScroller0.abortAnimation();
                z = false;
            }
            if(!z) {
                this.v.post(this.w);
            }
        }
        return this.a == 2;
    }

    public final View i(int v, int v1) {
        ViewGroup viewGroup0 = this.v;
        for(int v2 = viewGroup0.getChildCount() - 1; v2 >= 0; --v2) {
            this.s.getClass();
            View view0 = viewGroup0.getChildAt(v2);
            if(v >= view0.getLeft() && v < view0.getRight() && v1 >= view0.getTop() && v1 < view0.getBottom()) {
                return view0;
            }
        }
        return null;
    }

    public final boolean j(int v, int v1, int v2, int v3) {
        float f3;
        float f2;
        float f1;
        float f;
        int v4 = this.t.getLeft();
        int v5 = this.t.getTop();
        int v6 = v - v4;
        int v7 = v1 - v5;
        OverScroller overScroller0 = this.r;
        if(v6 == 0 && v7 == 0) {
            overScroller0.abortAnimation();
            this.r(0);
            return false;
        }
        View view0 = this.t;
        int v8 = (int)this.m;
        int v9 = Math.abs(v2);
        if(v9 < ((int)this.n)) {
            v2 = 0;
        }
        else if(v9 > v8) {
            v2 = v2 <= 0 ? -v8 : v8;
        }
        int v10 = Math.abs(v3);
        if(v10 < ((int)this.n)) {
            v3 = 0;
        }
        else if(v10 > v8) {
            v3 = v3 <= 0 ? -v8 : v8;
        }
        int v11 = Math.abs(v6);
        int v12 = Math.abs(v7);
        int v13 = Math.abs(v2);
        int v14 = Math.abs(v3);
        int v15 = v13 + v14;
        int v16 = v11 + v12;
        if(v2 == 0) {
            f = (float)v11;
            f1 = (float)v16;
        }
        else {
            f = (float)v13;
            f1 = (float)v15;
        }
        if(v3 == 0) {
            f2 = (float)v12;
            f3 = (float)v16;
        }
        else {
            f2 = (float)v14;
            f3 = (float)v15;
        }
        int v17 = this.g(v6, v2, this.s.v(view0));
        overScroller0.startScroll(v4, v5, v6, v7, ((int)(((float)this.g(v7, v3, this.s.w())) * (f2 / f3) + ((float)v17) * (f / f1))));
        this.r(2);
        return true;
    }

    public final boolean k(int v) {
        if((this.k & 1 << v) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + v + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public static boolean l(View view0, int v, int v1) {
        return view0 != null && v >= view0.getLeft() && v < view0.getRight() && v1 >= view0.getTop() && v1 < view0.getBottom();
    }

    public final void m(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        int v1 = motionEvent0.getActionIndex();
        if(v == 0) {
            this.b();
        }
        if(this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent0);
        k k0 = this.s;
        int v2 = 0;
        switch(v) {
            case 0: {
                float f8 = motionEvent0.getX();
                float f9 = motionEvent0.getY();
                int v18 = motionEvent0.getPointerId(0);
                View view1 = this.i(((int)f8), ((int)f9));
                this.p(f8, f9, v18);
                this.v(view1, v18);
                if((this.h[v18] & this.q) != 0) {
                    k0.E();
                }
                break;
            }
            case 1: {
                if(this.a == 1) {
                    this.n();
                }
                this.b();
                return;
            }
            case 2: {
                if(this.a != 1) {
                    int v16 = motionEvent0.getPointerCount();
                    while(v2 < v16) {
                        int v17 = motionEvent0.getPointerId(v2);
                        if(this.k(v17)) {
                            float f4 = motionEvent0.getX(v2);
                            float f5 = motionEvent0.getY(v2);
                            float f6 = f4 - this.d[v17];
                            float f7 = f5 - this.e[v17];
                            this.o(f6, f7, v17);
                            if(this.a == 1) {
                                break;
                            }
                            View view0 = this.i(((int)f4), ((int)f5));
                            if(!this.e(view0, f6, f7) || !this.v(view0, v17)) {
                                goto label_85;
                            }
                            break;
                        }
                    label_85:
                        ++v2;
                    }
                    this.q(motionEvent0);
                    return;
                }
                else if(this.k(this.c)) {
                    int v8 = motionEvent0.findPointerIndex(this.c);
                    float f2 = motionEvent0.getX(v8);
                    float f3 = motionEvent0.getY(v8);
                    int v9 = this.c;
                    int v10 = (int)(f2 - this.f[v9]);
                    int v11 = (int)(f3 - this.g[v9]);
                    int v12 = this.t.getLeft() + v10;
                    int v13 = this.t.getTop() + v11;
                    int v14 = this.t.getLeft();
                    int v15 = this.t.getTop();
                    if(v10 != 0) {
                        v12 = k0.j(this.t, v12);
                        this.t.offsetLeftAndRight(v12 - v14);
                    }
                    if(v11 != 0) {
                        v13 = k0.k(this.t, v13);
                        this.t.offsetTopAndBottom(v13 - v15);
                    }
                    if(v10 != 0 || v11 != 0) {
                        k0.H(this.t, v12, v13);
                    }
                    this.q(motionEvent0);
                    return;
                }
                break;
            }
            case 3: {
                if(this.a == 1) {
                    this.u = true;
                    k0.I(this.t, 0.0f, 0.0f);
                    this.u = false;
                    if(this.a == 1) {
                        this.r(0);
                    }
                }
                this.b();
                return;
            }
            case 5: {
                int v7 = motionEvent0.getPointerId(v1);
                float f = motionEvent0.getX(v1);
                float f1 = motionEvent0.getY(v1);
                this.p(f, f1, v7);
                if(this.a == 0) {
                    this.v(this.i(((int)f), ((int)f1)), v7);
                    if((this.h[v7] & this.q) != 0) {
                        k0.E();
                        return;
                    }
                }
                else if(c.l(this.t, ((int)f), ((int)f1))) {
                    this.v(this.t, v7);
                    return;
                }
                break;
            }
            case 6: {
                int v3 = motionEvent0.getPointerId(v1);
                if(this.a == 1 && v3 == this.c) {
                    int v4 = motionEvent0.getPointerCount();
                    while(true) {
                        int v5 = -1;
                        if(v2 >= v4) {
                            break;
                        }
                        int v6 = motionEvent0.getPointerId(v2);
                        if(v6 != this.c && (this.i(((int)motionEvent0.getX(v2)), ((int)motionEvent0.getY(v2))) == this.t && this.v(this.t, v6))) {
                            v5 = this.c;
                            break;
                        }
                        ++v2;
                    }
                    if(v5 == -1) {
                        this.n();
                    }
                }
                this.f(v3);
            }
        }
    }

    public final void n() {
        float f = this.m;
        this.l.computeCurrentVelocity(1000, f);
        float f1 = this.l.getXVelocity(this.c);
        float f2 = Math.abs(f1);
        if(Float.compare(f2, this.n) < 0) {
            f1 = 0.0f;
        }
        else if(f2 > f) {
            f1 = f1 > 0.0f ? f : -f;
        }
        float f3 = this.l.getYVelocity(this.c);
        float f4 = Math.abs(f3);
        if(f4 < this.n) {
            f = 0.0f;
        }
        else if(f4 <= f) {
            f = f3;
        }
        else if(f3 <= 0.0f) {
            f = -f;
        }
        this.u = true;
        this.s.I(this.t, f1, f);
        this.u = false;
        if(this.a == 1) {
            this.r(0);
        }
    }

    public final void o(float f, float f1, int v) {
        boolean z = this.d(f, f1, v, 1);
        if(this.d(f1, f, v, 4)) {
            z |= 4;
        }
        if(this.d(f, f1, v, 2)) {
            z |= 2;
        }
        if(this.d(f1, f, v, 8)) {
            z |= 8;
        }
        if(z) {
            this.i[v] |= true;
            this.s.D(1, v);
        }
    }

    public final void p(float f, float f1, int v) {
        float[] arr_f = this.d;
        int v1 = 0;
        if(arr_f == null || arr_f.length <= v) {
            float[] arr_f1 = new float[v + 1];
            float[] arr_f2 = new float[v + 1];
            float[] arr_f3 = new float[v + 1];
            float[] arr_f4 = new float[v + 1];
            int[] arr_v = new int[v + 1];
            int[] arr_v1 = new int[v + 1];
            int[] arr_v2 = new int[v + 1];
            if(arr_f != null) {
                System.arraycopy(arr_f, 0, arr_f1, 0, arr_f.length);
                System.arraycopy(this.e, 0, arr_f2, 0, this.e.length);
                System.arraycopy(this.f, 0, arr_f3, 0, this.f.length);
                System.arraycopy(this.g, 0, arr_f4, 0, this.g.length);
                System.arraycopy(this.h, 0, arr_v, 0, this.h.length);
                System.arraycopy(this.i, 0, arr_v1, 0, this.i.length);
                System.arraycopy(this.j, 0, arr_v2, 0, this.j.length);
            }
            this.d = arr_f1;
            this.e = arr_f2;
            this.f = arr_f3;
            this.g = arr_f4;
            this.h = arr_v;
            this.i = arr_v1;
            this.j = arr_v2;
        }
        float[] arr_f5 = this.d;
        this.f[v] = f;
        arr_f5[v] = f;
        float[] arr_f6 = this.e;
        this.g[v] = f1;
        arr_f6[v] = f1;
        int[] arr_v3 = this.h;
        ViewGroup viewGroup0 = this.v;
        if(((int)f) < viewGroup0.getLeft() + this.o) {
            v1 = 1;
        }
        if(((int)f1) < viewGroup0.getTop() + this.o) {
            v1 |= 4;
        }
        if(((int)f) > viewGroup0.getRight() - this.o) {
            v1 |= 2;
        }
        if(((int)f1) > viewGroup0.getBottom() - this.o) {
            v1 |= 8;
        }
        arr_v3[v] = v1;
        this.k |= 1 << v;
    }

    public final void q(MotionEvent motionEvent0) {
        int v = motionEvent0.getPointerCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = motionEvent0.getPointerId(v1);
            if(this.k(v2)) {
                float f = motionEvent0.getX(v1);
                float f1 = motionEvent0.getY(v1);
                this.f[v2] = f;
                this.g[v2] = f1;
            }
        }
    }

    public final void r(int v) {
        this.v.removeCallbacks(this.w);
        if(this.a != v) {
            this.a = v;
            this.s.G(v);
            if(this.a == 0) {
                this.t = null;
            }
        }
    }

    public final boolean s(int v, int v1) {
        if(!this.u) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return this.j(v, v1, ((int)this.l.getXVelocity(this.c)), ((int)this.l.getYVelocity(this.c)));
    }

    public final boolean t(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        int v1 = motionEvent0.getActionIndex();
        if(v == 0) {
            this.b();
        }
        if(this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent0);
        k k0 = this.s;
        switch(v) {
            case 0: {
                float f = motionEvent0.getX();
                float f1 = motionEvent0.getY();
                int v2 = motionEvent0.getPointerId(0);
                this.p(f, f1, v2);
                View view0 = this.i(((int)f), ((int)f1));
                if(view0 == this.t && this.a == 2) {
                    this.v(view0, v2);
                }
                if((this.h[v2] & this.q) != 0) {
                    k0.E();
                    return this.a == 1;
                }
                break;
            }
            case 2: {
                if(this.d != null && this.e != null) {
                    int v3 = motionEvent0.getPointerCount();
                    int v4 = 0;
                    while(v4 < v3) {
                        int v5 = motionEvent0.getPointerId(v4);
                        if(this.k(v5)) {
                            float f2 = motionEvent0.getX(v4);
                            float f3 = motionEvent0.getY(v4);
                            float f4 = f2 - this.d[v5];
                            float f5 = f3 - this.e[v5];
                            View view1 = this.i(((int)f2), ((int)f3));
                            boolean z = view1 != null && this.e(view1, f4, f5);
                            if(z) {
                                int v6 = view1.getLeft();
                                int v7 = k0.j(view1, ((int)f4) + v6);
                                int v8 = view1.getTop();
                                int v9 = k0.k(view1, ((int)f5) + v8);
                                int v10 = k0.v(view1);
                                int v11 = k0.w();
                                if(v10 != 0 && (v10 <= 0 || v7 != v6) || v11 != 0 && (v11 <= 0 || v9 != v8)) {
                                    goto label_44;
                                }
                                break;
                            }
                        label_44:
                            this.o(f4, f5, v5);
                            if(this.a != 1 && (!z || !this.v(view1, v5))) {
                                goto label_46;
                            }
                            break;
                        }
                    label_46:
                        ++v4;
                    }
                    this.q(motionEvent0);
                    return this.a == 1;
                }
                break;
            }
            case 1: 
            case 3: {
                this.b();
                return this.a == 1;
            }
            case 5: {
                int v12 = motionEvent0.getPointerId(v1);
                float f6 = motionEvent0.getX(v1);
                float f7 = motionEvent0.getY(v1);
                this.p(f6, f7, v12);
                int v13 = this.a;
                if(v13 == 0) {
                    if((this.h[v12] & this.q) != 0) {
                        k0.E();
                        return this.a == 1;
                    }
                }
                else if(v13 == 2) {
                    View view2 = this.i(((int)f6), ((int)f7));
                    if(view2 == this.t) {
                        this.v(view2, v12);
                        return this.a == 1;
                    }
                }
                break;
            }
            case 6: {
                this.f(motionEvent0.getPointerId(v1));
                return this.a == 1;
            }
            default: {
                return this.a == 1;
            }
        }
        return this.a == 1;
    }

    public final boolean u(View view0, int v, int v1) {
        this.t = view0;
        this.c = -1;
        boolean z = this.j(v, v1, 0, 0);
        if(!z && this.a == 0 && this.t != null) {
            this.t = null;
        }
        return z;
    }

    public final boolean v(View view0, int v) {
        if(view0 == this.t && this.c == v) {
            return true;
        }
        if(view0 != null && this.s.P(view0, v)) {
            this.c = v;
            this.c(view0, v);
            return true;
        }
        return false;
    }
}

