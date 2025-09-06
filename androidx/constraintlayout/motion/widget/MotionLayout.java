package androidx.constraintlayout.motion.widget;

import A1.b;
import A1.e;
import I1.a;
import I1.f;
import I1.k;
import I1.l;
import R6.d;
import U4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.appcompat.app.o;
import androidx.constraintlayout.helper.widget.MotionEffect;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.g;
import androidx.constraintlayout.widget.n;
import androidx.core.widget.NestedScrollView;
import c2.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import k8.Y;

public class MotionLayout extends ConstraintLayout implements t {
    public long A0;
    public float B;
    public float B0;
    public int C0;
    public int D;
    public float D0;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public int E;
    public int E0;
    public int F0;
    public int G;
    public int G0;
    public int H0;
    public int I;
    public int I0;
    public static boolean IS_IN_EDIT_MODE = false;
    public int J0;
    public float K0;
    public final e L0;
    public int M;
    public boolean M0;
    public boolean N;
    public y N0;
    public Runnable O0;
    public int[] P0;
    public int Q0;
    public boolean R0;
    public final HashMap S;
    public int S0;
    public long T;
    public final HashMap T0;
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public int U0;
    public float V;
    public int V0;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    public float W;
    public int W0;
    public final Rect X0;
    public boolean Y0;
    public A Z0;
    public final v a1;
    public float b0;
    public boolean b1;
    public long c0;
    public final RectF c1;
    public float d0;
    public View d1;
    public boolean e0;
    public Matrix e1;
    public boolean f0;
    public final ArrayList f1;
    public z g0;
    public int h0;
    public u i0;
    public boolean j0;
    public final a k0;
    public final androidx.constraintlayout.motion.widget.t l0;
    public androidx.constraintlayout.motion.widget.a m0;
    protected boolean mMeasureDuringTransition;
    public int n0;
    public E o;
    public int o0;
    public boolean p0;
    public float q0;
    public r r;
    public float r0;
    public long s0;
    public float t0;
    public boolean u0;
    public ArrayList v0;
    public Interpolator w;
    public ArrayList w0;
    public ArrayList x0;
    public CopyOnWriteArrayList y0;
    public int z0;

    public MotionLayout(Context context0) {
        super(context0);
        this.w = null;
        this.B = 0.0f;
        this.D = -1;
        this.E = -1;
        this.G = -1;
        this.I = 0;
        this.M = 0;
        this.N = true;
        this.S = new HashMap();
        this.T = 0L;
        this.V = 1.0f;
        this.W = 0.0f;
        this.b0 = 0.0f;
        this.d0 = 0.0f;
        this.f0 = false;
        this.h0 = 0;
        this.j0 = false;
        this.k0 = new a();
        this.l0 = new androidx.constraintlayout.motion.widget.t(this);
        this.p0 = false;
        this.u0 = false;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = 0;
        this.A0 = -1L;
        this.B0 = 0.0f;
        this.C0 = 0;
        this.D0 = 0.0f;
        this.mMeasureDuringTransition = false;
        this.L0 = new e(1);
        this.M0 = false;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = 0;
        this.R0 = false;
        this.S0 = 0;
        this.T0 = new HashMap();
        this.X0 = new Rect();
        this.Y0 = false;
        this.Z0 = A.a;
        this.a1 = new v(this);
        this.b1 = false;
        this.c1 = new RectF();
        this.d1 = null;
        this.e1 = null;
        this.f1 = new ArrayList();
        this.n(null);
    }

    public MotionLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.w = null;
        this.B = 0.0f;
        this.D = -1;
        this.E = -1;
        this.G = -1;
        this.I = 0;
        this.M = 0;
        this.N = true;
        this.S = new HashMap();
        this.T = 0L;
        this.V = 1.0f;
        this.W = 0.0f;
        this.b0 = 0.0f;
        this.d0 = 0.0f;
        this.f0 = false;
        this.h0 = 0;
        this.j0 = false;
        this.k0 = new a();
        this.l0 = new androidx.constraintlayout.motion.widget.t(this);
        this.p0 = false;
        this.u0 = false;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = 0;
        this.A0 = -1L;
        this.B0 = 0.0f;
        this.C0 = 0;
        this.D0 = 0.0f;
        this.mMeasureDuringTransition = false;
        this.L0 = new e(1);
        this.M0 = false;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = 0;
        this.R0 = false;
        this.S0 = 0;
        this.T0 = new HashMap();
        this.X0 = new Rect();
        this.Y0 = false;
        this.Z0 = A.a;
        this.a1 = new v(this);
        this.b1 = false;
        this.c1 = new RectF();
        this.d1 = null;
        this.e1 = null;
        this.f1 = new ArrayList();
        this.n(attributeSet0);
    }

    public MotionLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.w = null;
        this.B = 0.0f;
        this.D = -1;
        this.E = -1;
        this.G = -1;
        this.I = 0;
        this.M = 0;
        this.N = true;
        this.S = new HashMap();
        this.T = 0L;
        this.V = 1.0f;
        this.W = 0.0f;
        this.b0 = 0.0f;
        this.d0 = 0.0f;
        this.f0 = false;
        this.h0 = 0;
        this.j0 = false;
        this.k0 = new a();
        this.l0 = new androidx.constraintlayout.motion.widget.t(this);
        this.p0 = false;
        this.u0 = false;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = 0;
        this.A0 = -1L;
        this.B0 = 0.0f;
        this.C0 = 0;
        this.D0 = 0.0f;
        this.mMeasureDuringTransition = false;
        this.L0 = new e(1);
        this.M0 = false;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = 0;
        this.R0 = false;
        this.S0 = 0;
        this.T0 = new HashMap();
        this.X0 = new Rect();
        this.Y0 = false;
        this.Z0 = A.a;
        this.a1 = new v(this);
        this.b1 = false;
        this.c1 = new RectF();
        this.d1 = null;
        this.e1 = null;
        this.f1 = new ArrayList();
        this.n(attributeSet0);
    }

    public void addTransitionListener(z z0) {
        if(this.y0 == null) {
            this.y0 = new CopyOnWriteArrayList();
        }
        this.y0.add(z0);
    }

    public boolean applyViewTransition(int v, q q0) {
        E e0 = this.o;
        if(e0 != null) {
            for(Object object0: ((ArrayList)e0.q.c)) {
                I i0 = (I)object0;
                if(i0.a == v) {
                    ArrayList arrayList0 = (ArrayList)i0.f.a.get(-1);
                    if(arrayList0 != null) {
                        q0.w.addAll(arrayList0);
                    }
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public static Rect c(MotionLayout motionLayout0, F1.e e0) {
        motionLayout0.X0.top = e0.u();
        motionLayout0.X0.left = e0.t();
        motionLayout0.X0.right = e0.s() + motionLayout0.X0.left;
        motionLayout0.X0.bottom = e0.m() + motionLayout0.X0.top;
        return motionLayout0.X0;
    }

    public n cloneConstraintSet(int v) {
        E e0 = this.o;
        if(e0 == null) {
            return null;
        }
        n n0 = e0.b(v);
        n n1 = new n();
        n1.g(n0);
        return n1;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void dispatchDraw(Canvas canvas0) {
        Paint paint8;
        u u3;
        int v22;
        u u2;
        Paint paint7;
        Paint paint6;
        double f9;
        Paint paint5;
        int v17;
        int v15;
        int v13;
        int v12;
        ArrayList arrayList4;
        ArrayList arrayList0 = this.x0;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                ((MotionHelper)object0).getClass();
            }
        }
        this.j(false);
        E e0 = this.o;
        if(e0 != null) {
            E9.u u0 = e0.q;
            if(u0 != null) {
                ArrayList arrayList1 = (ArrayList)u0.e;
                ArrayList arrayList2 = (ArrayList)u0.d;
                if(arrayList2 != null) {
                    for(Object object1: arrayList2) {
                        ((H)object1).a();
                    }
                    ((ArrayList)u0.d).removeAll(arrayList1);
                    arrayList1.clear();
                    if(((ArrayList)u0.d).isEmpty()) {
                        u0.d = null;
                    }
                }
            }
        }
        super.dispatchDraw(canvas0);
        if(this.o != null) {
            if((this.h0 & 1) == 1 && !this.isInEditMode()) {
                ++this.z0;
                long v = this.A0;
                if(v == -1L) {
                    this.A0 = 13894792386500L;
                }
                else if(13894792386500L - v > 200000000L) {
                    this.B0 = ((float)(((int)(((float)this.z0) / (((float)(13894792386500L - v)) * 1.000000E-09f) * 100.0f)))) / 100.0f;
                    this.z0 = 0;
                    this.A0 = 13894792386500L;
                }
                Paint paint0 = new Paint();
                paint0.setTextSize(42.0f);
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append(this.B0);
                stringBuilder0.append(" fps ");
                int v1 = this.D;
                StringBuilder stringBuilder1 = Y.p(x.m(stringBuilder0, (v1 == -1 ? "UNDEFINED" : this.getContext().getResources().getResourceEntryName(v1)), " -> "));
                int v2 = this.G;
                stringBuilder1.append((v2 == -1 ? "UNDEFINED" : this.getContext().getResources().getResourceEntryName(v2)));
                stringBuilder1.append(" (progress: ");
                stringBuilder1.append(((float)(((int)(this.getProgress() * 1000.0f)))) / 10.0f);
                stringBuilder1.append(" ) state=");
                int v3 = this.E;
                stringBuilder1.append((v3 == -1 ? "undefined" : this.getContext().getResources().getResourceEntryName(v3)));
                String s = stringBuilder1.toString();
                paint0.setColor(0xFF000000);
                canvas0.drawText(s, 11.0f, ((float)(this.getHeight() - 29)), paint0);
                paint0.setColor(0xFF880088);
                canvas0.drawText(s, 10.0f, ((float)(this.getHeight() - 30)), paint0);
            }
            if(this.h0 > 1) {
                if(this.i0 == null) {
                    this.i0 = new u(this);
                }
                u u1 = this.i0;
                int v4 = this.o.c();
                int v5 = this.h0;
                Paint paint1 = u1.g;
                Paint paint2 = u1.f;
                Paint paint3 = u1.i;
                int v6 = u1.m;
                Paint paint4 = u1.e;
                MotionLayout motionLayout0 = u1.n;
                HashMap hashMap0 = this.S;
                if(hashMap0 != null && hashMap0.size() != 0) {
                    canvas0.save();
                    if(!motionLayout0.isInEditMode() && (v5 & 1) == 2) {
                        String s1 = motionLayout0.getContext().getResources().getResourceName(motionLayout0.G) + ":" + motionLayout0.getProgress();
                        canvas0.drawText(s1, 10.0f, ((float)(motionLayout0.getHeight() - 30)), u1.h);
                        canvas0.drawText(s1, 11.0f, ((float)(motionLayout0.getHeight() - 29)), paint4);
                    }
                    for(Object object2: hashMap0.values()) {
                        q q0 = (q)object2;
                        B b0 = q0.f;
                        ArrayList arrayList3 = q0.u;
                        int v7 = b0.b;
                        for(Object object3: arrayList3) {
                            v7 = Math.max(v7, ((B)object3).b);
                        }
                        int v8 = v5 <= 0 || Math.max(v7, q0.g.b) != 0 ? Math.max(v7, q0.g.b) : 1;
                        if(v8 != 0) {
                            float[] arr_f = u1.c;
                            int[] arr_v = u1.b;
                            if(arr_f == null) {
                                arrayList4 = arrayList3;
                                v12 = v4;
                                v13 = 0;
                            }
                            else {
                                arrayList4 = arrayList3;
                                double[] arr_f1 = q0.j[0].N();
                                if(arr_v != null) {
                                    int v9 = 0;
                                    for(Object object4: arrayList4) {
                                        arr_v[v9] = ((B)object4).o;
                                        ++v9;
                                    }
                                }
                                float[] arr_f2 = arr_f;
                                int v11 = 0;
                                for(int v10 = 0; v10 < arr_f1.length; ++v10) {
                                    q0.j[0].I(arr_f1[v10], q0.p);
                                    q0.f.c(arr_f1[v10], q0.o, q0.p, arr_f2, v11);
                                    v11 += 2;
                                }
                                v12 = v4;
                                v13 = v11 / 2;
                            }
                            u1.k = v13;
                            if(v8 >= 1) {
                                int v14 = v12 / 16;
                                if(u1.a == null || u1.a.length != v14 * 2) {
                                    u1.a = new float[v14 * 2];
                                    u1.d = new Path();
                                }
                                canvas0.translate(((float)v6), ((float)v6));
                                paint4.setColor(0x77000000);
                                paint3.setColor(0x77000000);
                                paint2.setColor(0x77000000);
                                paint1.setColor(0x77000000);
                                float[] arr_f3 = u1.a;
                                k k0 = q0.y == null ? null : ((k)q0.y.get("translationX"));
                                float f = 1.0f / ((float)(v14 - 1));
                                v15 = v5;
                                k k1 = q0.y == null ? null : ((k)q0.y.get("translationY"));
                                f f1 = q0.z == null ? null : ((f)q0.z.get("translationX"));
                                f f2 = q0.z == null ? null : ((f)q0.z.get("translationY"));
                                int v16 = 0;
                                while(true) {
                                    float f3 = NaNf;
                                    if(v16 >= v14) {
                                        break;
                                    }
                                    float f4 = ((float)v16) * f;
                                    float f5 = q0.n;
                                    if(f5 == 1.0f) {
                                        v17 = v16;
                                    }
                                    else {
                                        float f6 = q0.m;
                                        if(f4 < f6) {
                                            f4 = 0.0f;
                                        }
                                        if(f4 > f6) {
                                            v17 = v16;
                                            if(((double)f4) < 1.0) {
                                                f4 = Math.min((f4 - f6) * f5, 1.0f);
                                            }
                                        }
                                        else {
                                            v17 = v16;
                                        }
                                    }
                                    e e1 = b0.a;
                                    float f7 = 0.0f;
                                    for(Object object5: arrayList4) {
                                        B b1 = (B)object5;
                                        e e2 = b1.a;
                                        if(e2 != null) {
                                            float f8 = b1.c;
                                            if(f8 < f4) {
                                                f7 = f8;
                                                e1 = e2;
                                            }
                                            else if(Float.isNaN(f3)) {
                                                f3 = b1.c;
                                            }
                                        }
                                    }
                                    if(e1 == null) {
                                        paint5 = paint1;
                                        f9 = (double)f4;
                                    }
                                    else {
                                        if(Float.isNaN(f3)) {
                                            f3 = 1.0f;
                                        }
                                        paint5 = paint1;
                                        f9 = (double)(((float)e1.a(((double)((f4 - f7) / (f3 - f7))))) * (f3 - f7) + f7);
                                    }
                                    q0.j[0].I(f9, q0.p);
                                    b b2 = q0.k;
                                    if(b2 == null) {
                                        paint6 = paint3;
                                    }
                                    else {
                                        double[] arr_f4 = q0.p;
                                        paint6 = paint3;
                                        if(arr_f4.length > 0) {
                                            b2.I(f9, arr_f4);
                                        }
                                    }
                                    q0.f.c(f9, q0.o, q0.p, arr_f3, v17 * 2);
                                    if(f1 != null) {
                                        float f10 = arr_f3[v17 * 2];
                                        arr_f3[v17 * 2] = f1.a(f4) + f10;
                                    }
                                    else if(k0 != null) {
                                        float f11 = arr_f3[v17 * 2];
                                        arr_f3[v17 * 2] = k0.a(f4) + f11;
                                    }
                                    if(f2 != null) {
                                        int v18 = v17 * 2 + 1;
                                        float f12 = arr_f3[v18];
                                        arr_f3[v18] = f2.a(f4) + f12;
                                    }
                                    else if(k1 != null) {
                                        int v19 = v17 * 2 + 1;
                                        float f13 = arr_f3[v19];
                                        arr_f3[v19] = k1.a(f4) + f13;
                                    }
                                    v16 = v17 + 1;
                                    paint1 = paint5;
                                    paint3 = paint6;
                                }
                                B b3 = b0;
                                u1.a(canvas0, v8, u1.k, q0);
                                paint4.setColor(0xFFFFAA33);
                                paint2.setColor(-2067046);
                                paint3.setColor(-2067046);
                                paint7 = paint1;
                                paint7.setColor(0xFF33AA00);
                                float f14 = (float)(-v6);
                                canvas0.translate(f14, f14);
                                u1.a(canvas0, v8, u1.k, q0);
                                if(v8 == 5) {
                                    float[] arr_f5 = u1.j;
                                    u1.d.reset();
                                    int v20 = 0;
                                    while(v20 <= 50) {
                                        float f15 = q0.b(null, ((float)v20) / 50.0f);
                                        q0.j[0].I(((double)f15), q0.p);
                                        int[] arr_v1 = q0.o;
                                        double[] arr_f6 = q0.p;
                                        float f16 = b3.e;
                                        float f17 = b3.f;
                                        float f18 = b3.g;
                                        float f19 = b3.h;
                                        for(int v21 = 0; v21 < arr_v1.length; ++v21) {
                                            float f20 = (float)arr_f6[v21];
                                            switch(arr_v1[v21]) {
                                                case 1: {
                                                    f16 = f20;
                                                    break;
                                                }
                                                case 2: {
                                                    f17 = f20;
                                                    break;
                                                }
                                                case 3: {
                                                    f18 = f20;
                                                    break;
                                                }
                                                case 4: {
                                                    f19 = f20;
                                                }
                                            }
                                        }
                                        if(b3.m == null) {
                                            u2 = u1;
                                        }
                                        else {
                                            double f21 = (double)f16;
                                            u2 = u1;
                                            f16 = (float)(Math.sin(f17) * f21 + 0.0 - ((double)(f18 / 2.0f)));
                                            f17 = (float)(0.0 - Math.cos(f17) * f21 - ((double)(f19 / 2.0f)));
                                        }
                                        float f22 = f18 + f16 + 0.0f;
                                        float f23 = f19 + f17 + 0.0f;
                                        arr_f5[0] = f16 + 0.0f;
                                        arr_f5[1] = f17 + 0.0f;
                                        arr_f5[2] = f22;
                                        arr_f5[3] = f17 + 0.0f;
                                        arr_f5[4] = f22;
                                        arr_f5[5] = f23;
                                        arr_f5[6] = f16 + 0.0f;
                                        arr_f5[7] = f23;
                                        u2.d.moveTo(f16 + 0.0f, f17 + 0.0f);
                                        u2.d.lineTo(arr_f5[2], arr_f5[3]);
                                        u2.d.lineTo(arr_f5[4], arr_f5[5]);
                                        u2.d.lineTo(arr_f5[6], arr_f5[7]);
                                        u2.d.close();
                                        ++v20;
                                        u1 = u2;
                                    }
                                    v22 = v6;
                                    u3 = u1;
                                    paint8 = paint3;
                                    paint4.setColor(0x44000000);
                                    canvas0.translate(2.0f, 2.0f);
                                    canvas0.drawPath(u3.d, paint4);
                                    canvas0.translate(-2.0f, -2.0f);
                                    paint4.setColor(0xFFFF0000);
                                    canvas0.drawPath(u3.d, paint4);
                                }
                                else {
                                    v22 = v6;
                                    u3 = u1;
                                    paint8 = paint3;
                                }
                            }
                            else {
                                u3 = u1;
                                v15 = v5;
                                paint7 = paint1;
                                paint8 = paint3;
                                v22 = v6;
                            }
                            u1 = u3;
                            paint1 = paint7;
                            v4 = v12;
                            v5 = v15;
                            v6 = v22;
                            paint3 = paint8;
                        }
                    }
                    canvas0.restore();
                }
            }
            ArrayList arrayList5 = this.x0;
            if(arrayList5 != null) {
                for(Object object6: arrayList5) {
                    ((MotionHelper)object6).getClass();
                }
            }
        }
    }

    public void enableTransition(int v, boolean z) {
        D d0 = this.getTransition(v);
        if(z) {
            d0.o = false;
            return;
        }
        E e0 = this.o;
        if(d0 == e0.c) {
            for(Object object0: e0.i(this.E)) {
                D d1 = (D)object0;
                if(!d1.o) {
                    this.o.c = d1;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        d0.o = true;
    }

    public void enableViewTransition(int v, boolean z) {
        E e0 = this.o;
        if(e0 != null) {
            for(Object object0: ((ArrayList)e0.q.c)) {
                I i0 = (I)object0;
                if(i0.a == v) {
                    i0.c = !z;
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
    }

    public void fireTransitionCompleted() {
        if((this.g0 != null || this.y0 != null && !this.y0.isEmpty()) && this.C0 == -1) {
            this.C0 = this.E;
            ArrayList arrayList0 = this.f1;
            int v = arrayList0.isEmpty() ? -1 : ((int)(((Integer)com.iloen.melon.utils.a.i(1, arrayList0))));
            int v1 = this.E;
            if(v != v1 && v1 != -1) {
                arrayList0.add(v1);
            }
        }
        this.p();
        Runnable runnable0 = this.O0;
        if(runnable0 != null) {
            runnable0.run();
            this.O0 = null;
        }
        int[] arr_v = this.P0;
        if(arr_v != null && this.Q0 > 0) {
            this.transitionToState(arr_v[0]);
            System.arraycopy(this.P0, 1, this.P0, 0, this.P0.length - 1);
            --this.Q0;
        }
    }

    public void fireTrigger(int v, boolean z, float f) {
        z z1 = this.g0;
        if(z1 != null) {
            z1.onTransitionTrigger(this, v, z, f);
        }
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.y0;
        if(copyOnWriteArrayList0 != null) {
            for(Object object0: copyOnWriteArrayList0) {
                ((z)object0).onTransitionTrigger(this, v, z, f);
            }
        }
    }

    public n getConstraintSet(int v) {
        return this.o == null ? null : this.o.b(v);
    }

    public int[] getConstraintSetIds() {
        E e0 = this.o;
        if(e0 == null) {
            return null;
        }
        SparseArray sparseArray0 = e0.g;
        int v = sparseArray0.size();
        int[] arr_v = new int[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_v[v1] = sparseArray0.keyAt(v1);
        }
        return arr_v;
    }

    public int getCurrentState() {
        return this.E;
    }

    public ArrayList getDefinedTransitions() {
        return this.o == null ? null : this.o.d;
    }

    public androidx.constraintlayout.motion.widget.a getDesignTool() {
        if(this.m0 == null) {
            this.m0 = new androidx.constraintlayout.motion.widget.a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        return this.m0;
    }

    public int getEndState() {
        return this.G;
    }

    public int[] getMatchingConstraintSetIds(String[] arr_s) {
        E e0 = this.o;
        if(e0 == null) {
            return null;
        }
        SparseArray sparseArray0 = e0.g;
        int v = sparseArray0.size();
        int[] arr_v = new int[v];
        int v1 = 0;
        int v2 = 0;
        while(v1 < v) {
            n n0 = (n)sparseArray0.valueAt(v1);
            int v3 = sparseArray0.keyAt(v1);
            n0.getClass();
            int v4 = 0;
        label_13:
            while(v4 < arr_s.length) {
                String s = arr_s[v4];
                String[] arr_s1 = n0.c;
                int v5 = 0;
                while(true) {
                    if(v5 >= arr_s1.length) {
                        goto label_26;
                    }
                    if(!arr_s1[v5].equals(s)) {
                        ++v5;
                        continue;
                    }
                    ++v4;
                    continue label_13;
                }
            }
            String[] arr_s2 = (String[])Arrays.copyOf(n0.c, n0.c.length);
            arr_v[v2] = v3;
            ++v2;
        label_26:
            ++v1;
        }
        return Arrays.copyOf(arr_v, v2);
    }

    public long getNanoTime() [...] // 潜在的解密器

    public float getProgress() {
        return this.b0;
    }

    public E getScene() {
        return this.o;
    }

    public int getStartState() {
        return this.D;
    }

    public float getTargetPosition() {
        return this.d0;
    }

    public D getTransition(int v) {
        for(Object object0: this.o.d) {
            D d0 = (D)object0;
            if(d0.a == v) {
                return d0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public Bundle getTransitionState() {
        if(this.N0 == null) {
            this.N0 = new y(this);
        }
        y y0 = this.N0;
        y0.d = y0.e.G;
        y0.c = y0.e.D;
        y0.b = y0.e.getVelocity();
        y0.a = y0.e.getProgress();
        y y1 = this.N0;
        y1.getClass();
        Bundle bundle0 = new Bundle();
        bundle0.putFloat("motion.progress", y1.a);
        bundle0.putFloat("motion.velocity", y1.b);
        bundle0.putInt("motion.StartState", y1.c);
        bundle0.putInt("motion.EndState", y1.d);
        return bundle0;
    }

    public long getTransitionTimeMs() {
        E e0 = this.o;
        if(e0 != null) {
            this.V = ((float)e0.c()) / 1000.0f;
        }
        return (long)(this.V * 1000.0f);
    }

    public float getVelocity() {
        return this.B;
    }

    public void getViewVelocity(View view0, float f, float f1, float[] arr_f, int v) {
        double[] arr_f7;
        f f15;
        float[] arr_f3;
        k k5;
        float[] arr_f2;
        f f14;
        float f8;
        float f2 = this.B;
        float f3 = this.b0;
        if(this.r != null) {
            float f4 = Math.signum(this.d0 - f3);
            float f5 = this.r.getInterpolation(this.b0 + 0.00001f);
            float f6 = this.r.getInterpolation(this.b0);
            f2 = (f5 - f6) / 0.00001f * f4 / this.V;
            f3 = f6;
        }
        r r0 = this.r;
        if(r0 != null) {
            f2 = r0.a();
        }
        q q0 = (q)this.S.get(view0);
        if((v & 1) == 0) {
            int v1 = view0.getWidth();
            int v2 = view0.getHeight();
            float[] arr_f1 = q0.v;
            float f7 = q0.b(arr_f1, f3);
            k k0 = q0.y == null ? null : ((k)q0.y.get("translationX"));
            k k1 = q0.y == null ? null : ((k)q0.y.get("translationY"));
            k k2 = q0.y == null ? null : ((k)q0.y.get("rotation"));
            k k3 = q0.y == null ? null : ((k)q0.y.get("scaleX"));
            f8 = f2;
            k k4 = q0.y == null ? null : ((k)q0.y.get("scaleY"));
            f f9 = q0.z == null ? null : ((f)q0.z.get("translationX"));
            f f10 = q0.z == null ? null : ((f)q0.z.get("translationY"));
            f f11 = q0.z == null ? null : ((f)q0.z.get("rotation"));
            f f12 = q0.z == null ? null : ((f)q0.z.get("scaleX"));
            f f13 = q0.z == null ? null : ((f)q0.z.get("scaleY"));
            A1.r r1 = new A1.r();  // 初始化器: Ljava/lang/Object;-><init>()V
            r1.e = 0.0f;
            r1.d = 0.0f;
            r1.c = 0.0f;
            r1.b = 0.0f;
            r1.a = 0.0f;
            if(k2 == null) {
                f14 = f13;
            }
            else {
                f14 = f13;
                r1.e = (float)k2.a.K(((double)f7));
                r1.f = k2.a(f7);
            }
            if(k0 == null) {
                arr_f2 = arr_f1;
                k5 = null;
            }
            else {
                arr_f2 = arr_f1;
                k5 = k0;
                r1.c = (float)k0.a.K(((double)f7));
            }
            if(k1 == null) {
                arr_f3 = arr_f2;
            }
            else {
                arr_f3 = arr_f2;
                r1.d = (float)k1.a.K(((double)f7));
            }
            if(k3 != null) {
                r1.a = (float)k3.a.K(((double)f7));
            }
            if(k4 != null) {
                r1.b = (float)k4.a.K(((double)f7));
            }
            if(f11 != null) {
                r1.e = f11.b(f7);
            }
            if(f9 != null) {
                r1.c = f9.b(f7);
            }
            if(f10 != null) {
                r1.d = f10.b(f7);
            }
            if(f12 != null) {
                r1.a = f12.b(f7);
            }
            if(f14 == null) {
                f15 = null;
            }
            else {
                f15 = f14;
                r1.b = f15.b(f7);
            }
            b b0 = q0.k;
            if(b0 != null) {
                double[] arr_f4 = q0.p;
                if(arr_f4.length > 0) {
                    b0.I(((double)f7), arr_f4);
                    q0.k.L(((double)f7), q0.q);
                    int[] arr_v = q0.o;
                    double[] arr_f5 = q0.q;
                    double[] arr_f6 = q0.p;
                    q0.f.getClass();
                    B.e(f, f1, arr_f, arr_v, arr_f5, arr_f6);
                }
            }
            else if(q0.j == null) {
                float f18 = q0.g.e - q0.f.e;
                float f19 = q0.g.f - q0.f.f;
                float f20 = f19 + (q0.g.h - q0.f.h);
                arr_f[0] = (f18 + (q0.g.g - q0.f.g)) * f + (1.0f - f) * f18;
                arr_f[1] = f20 * f1 + (1.0f - f1) * f19;
                r1.e = 0.0f;
                r1.d = 0.0f;
                r1.c = 0.0f;
                r1.b = 0.0f;
                r1.a = 0.0f;
                if(k2 != null) {
                    r1.e = (float)k2.a.K(((double)f7));
                    r1.f = k2.a(f7);
                }
                if(k5 != null) {
                    r1.c = (float)k5.a.K(((double)f7));
                }
                if(k1 != null) {
                    r1.d = (float)k1.a.K(((double)f7));
                }
                if(k3 != null) {
                    r1.a = (float)k3.a.K(((double)f7));
                }
                if(k4 != null) {
                    r1.b = (float)k4.a.K(((double)f7));
                }
                if(f11 != null) {
                    r1.e = f11.b(f7);
                }
                if(f9 != null) {
                    r1.c = f9.b(f7);
                }
                if(f10 != null) {
                    r1.d = f10.b(f7);
                }
                if(f12 != null) {
                    r1.a = f12.b(f7);
                }
                if(f15 != null) {
                    r1.b = f15.b(f7);
                }
            }
            else {
                float f16 = q0.b(arr_f3, f7);
                q0.j[0].L(((double)f16), q0.q);
                q0.j[0].I(((double)f16), q0.p);
                float f17 = arr_f3[0];
                for(int v3 = 0; true; ++v3) {
                    arr_f7 = q0.q;
                    if(v3 >= arr_f7.length) {
                        break;
                    }
                    arr_f7[v3] *= (double)f17;
                }
                int[] arr_v1 = q0.o;
                double[] arr_f8 = q0.p;
                q0.f.getClass();
                B.e(f, f1, arr_f, arr_v1, arr_f7, arr_f8);
            }
            r1.a(f, f1, v1, v2, arr_f);
        }
        else {
            f8 = f2;
            q0.d(f3, f, f1, arr_f);
        }
        if(v < 2) {
            arr_f[0] *= f8;
            arr_f[1] *= f8;
        }
    }

    public final void h(float f) {
        E e0 = this.o;
        if(e0 != null) {
            float f1 = this.W;
            if(this.b0 != f1 && this.e0) {
                this.b0 = f1;
            }
            float f2 = this.b0;
            if(f2 != f) {
                this.j0 = false;
                this.d0 = f;
                this.V = ((float)e0.c()) / 1000.0f;
                this.setProgress(this.d0);
                this.r = null;
                this.w = this.o.e();
                this.e0 = false;
                this.T = 0xCA30AEDDF3CL;
                this.f0 = true;
                this.W = f2;
                this.b0 = f2;
                this.invalidate();
            }
        }
    }

    public final void i(boolean z) {
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            q q0 = (q)this.S.get(view0);
            if(q0 != null && "button".equals(ye.a.G(q0.b)) && q0.A != null) {
                for(int v2 = 0; true; ++v2) {
                    androidx.constraintlayout.motion.widget.n[] arr_n = q0.A;
                    if(v2 >= arr_n.length) {
                        break;
                    }
                    arr_n[v2].h(q0.b, (z ? -100.0f : 100.0f));
                }
            }
        }
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.Y0;
    }

    public boolean isInRotation() {
        return this.R0;
    }

    public boolean isInteractionEnabled() {
        return this.N;
    }

    public boolean isViewTransitionEnabled(int v) {
        E e0 = this.o;
        if(e0 != null) {
            for(Object object0: ((ArrayList)e0.q.c)) {
                I i0 = (I)object0;
                if(i0.a == v) {
                    return !i0.c;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public final void j(boolean z) {
        int v1;
        boolean z3;
        if(this.c0 == -1L) {
            this.c0 = 0xCA321DFFC48L;
        }
        float f = this.b0;
        if(Float.compare(f, 0.0f) > 0 && f < 1.0f) {
            this.E = -1;
        }
        boolean z1 = true;
        boolean z2 = false;
        if(this.u0 || this.f0 && (z || this.d0 != f)) {
            float f1 = Math.signum(this.d0 - f);
            r r0 = this.r;
            float f2 = r0 == null ? ((float)(0xCA321E64800L - this.c0)) * f1 * 1.000000E-09f / this.V : 0.0f;
            float f3 = this.e0 ? this.d0 : this.b0 + f2;
            int v = Float.compare(f1, 0.0f);
            if((v <= 0 || f3 < this.d0) && (f1 > 0.0f || f3 > this.d0)) {
                z3 = false;
            }
            else {
                f3 = this.d0;
                this.f0 = false;
                z3 = true;
            }
            this.b0 = f3;
            this.W = f3;
            this.c0 = 0xCA321E64800L;
            if(r0 == null || z3) {
                this.B = f2;
                v1 = 0;
            }
            else if(this.j0) {
                float f4 = r0.getInterpolation(((float)(0xCA321E64800L - this.T)) * 1.000000E-09f);
                a a0 = this.k0;
                if(this.r != a0) {
                    v1 = 0;
                }
                else if(a0.c.b()) {
                    v1 = 2;
                }
                else {
                    v1 = 1;
                }
                this.b0 = f4;
                this.c0 = 0xCA321E64800L;
                r r1 = this.r;
                if(r1 == null) {
                    f3 = f4;
                }
                else {
                    float f5 = r1.a();
                    this.B = f5;
                    if(Math.abs(f5) * this.V <= 0.00001f && v1 == 2) {
                        this.f0 = false;
                    }
                    if(f5 > 0.0f && f4 >= 1.0f) {
                        this.b0 = 1.0f;
                        this.f0 = false;
                        f4 = 1.0f;
                    }
                    if(f5 >= 0.0f || f4 > 0.0f) {
                        f3 = f4;
                    }
                    else {
                        this.b0 = 0.0f;
                        this.f0 = false;
                        f3 = 0.0f;
                    }
                }
            }
            else {
                float f6 = r0.getInterpolation(f3);
                r r2 = this.r;
                if(r2 == null) {
                    throw new NullPointerException();
                }
                this.B = r2.a();
                f3 = f6;
                v1 = 0;
            }
            if(Math.abs(this.B) > 0.00001f) {
                this.setState(A.c);
            }
            A a1 = A.d;
            if(v1 != 1) {
                if(v > 0 && f3 >= this.d0 || f1 <= 0.0f && f3 <= this.d0) {
                    f3 = this.d0;
                    this.f0 = false;
                }
                if(f3 >= 1.0f || f3 <= 0.0f) {
                    this.f0 = false;
                    this.setState(a1);
                }
            }
            int v2 = this.getChildCount();
            this.u0 = false;
            this.K0 = f3;
            float f7 = this.w == null ? f3 : this.w.getInterpolation(f3);
            Interpolator interpolator0 = this.w;
            if(interpolator0 != null) {
                this.B = interpolator0.getInterpolation(f1 / this.V + f3) - this.w.getInterpolation(f3);
            }
            for(int v3 = 0; v3 < v2; ++v3) {
                View view0 = this.getChildAt(v3);
                q q0 = (q)this.S.get(view0);
                if(q0 != null) {
                    boolean z4 = this.u0;
                    this.u0 = q0.f(f7, 13894788452700L, this.L0, view0) | z4;
                }
            }
            int v4 = (v <= 0 || f3 < this.d0) && (f1 > 0.0f || f3 > this.d0) ? 0 : 1;
            if(!this.u0 && !this.f0 && v4 != 0) {
                this.setState(a1);
            }
            if(this.mMeasureDuringTransition) {
                this.requestLayout();
            }
            this.u0 |= v4 ^ 1;
            if(f3 <= 0.0f) {
                int v5 = this.D;
                if(v5 != -1 && this.E != v5) {
                    this.E = v5;
                    this.o.b(v5).a(this);
                    this.setState(a1);
                    z2 = true;
                }
            }
            if(((double)f3) >= 1.0) {
                int v6 = this.G;
                if(this.E != v6) {
                    this.E = v6;
                    this.o.b(v6).a(this);
                    this.setState(a1);
                    z2 = true;
                }
            }
            if(this.u0 || this.f0) {
                this.invalidate();
            }
            else if(v > 0 && f3 == 1.0f || f1 < 0.0f && f3 == 0.0f) {
                this.setState(a1);
            }
            if(!this.u0 && !this.f0 && (v > 0 && f3 == 1.0f || f1 < 0.0f && f3 == 0.0f)) {
                this.o();
            }
        }
        float f8 = this.b0;
        if(f8 >= 1.0f) {
            int v7 = this.G;
            if(this.E == v7) {
                z1 = z2;
            }
            this.E = v7;
            z2 = z1;
        }
        else if(f8 <= 0.0f) {
            int v8 = this.D;
            if(this.E == v8) {
                z1 = z2;
            }
            this.E = v8;
            z2 = z1;
        }
        this.b1 |= z2;
        if(z2 && !this.M0) {
            this.requestLayout();
        }
        this.W = this.b0;
    }

    public void jumpToState(int v) {
        if(!this.isAttachedToWindow()) {
            this.E = v;
        }
        if(this.D == v) {
            this.setProgress(0.0f);
            return;
        }
        if(this.G == v) {
            this.setProgress(1.0f);
            return;
        }
        this.setTransition(v, v);
    }

    public final void k() {
        if((this.g0 != null || this.y0 != null && !this.y0.isEmpty()) && this.D0 != this.W) {
            if(this.C0 != -1) {
                z z0 = this.g0;
                if(z0 != null) {
                    z0.onTransitionStarted(this, this.D, this.G);
                }
                CopyOnWriteArrayList copyOnWriteArrayList0 = this.y0;
                if(copyOnWriteArrayList0 != null) {
                    for(Object object0: copyOnWriteArrayList0) {
                        ((z)object0).onTransitionStarted(this, this.D, this.G);
                    }
                }
            }
            this.C0 = -1;
            float f = this.W;
            this.D0 = f;
            z z1 = this.g0;
            if(z1 != null) {
                z1.onTransitionChange(this, this.D, this.G, f);
            }
            CopyOnWriteArrayList copyOnWriteArrayList1 = this.y0;
            if(copyOnWriteArrayList1 != null) {
                for(Object object1: copyOnWriteArrayList1) {
                    ((z)object1).onTransitionChange(this, this.D, this.G, this.W);
                }
            }
        }
    }

    public final void l(int v, float f, float f1, float f2, float[] arr_f) {
        View view0 = this.getViewById(v);
        q q0 = (q)this.S.get(view0);
        if(q0 != null) {
            q0.d(f, f1, f2, arr_f);
            view0.getY();
            return;
        }
        o.A("WARNING could not find view id ", (view0 == null ? "" + v : view0.getContext().getResources().getResourceName(v)), "MotionLayout");
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int v) {
        if(v != 0) {
            try {
                E e0 = new E(this.getContext(), this, v);
                this.o = e0;
                int v1 = -1;
                if(this.E == -1) {
                    this.E = e0.h();
                    this.D = this.o.h();
                    D d0 = this.o.c;
                    if(d0 != null) {
                        v1 = d0.c;
                    }
                    this.G = v1;
                }
                if(!this.isAttachedToWindow()) {
                    this.o = null;
                    return;
                }
            }
            catch(Exception exception0) {
                throw new IllegalArgumentException("unable to parse MotionScene file", exception0);
            }
            try {
                Display display0 = this.getDisplay();
                this.W0 = display0 == null ? 0 : display0.getRotation();
                E e1 = this.o;
                if(e1 != null) {
                    n n0 = e1.b(this.E);
                    this.o.o(this);
                    ArrayList arrayList0 = this.x0;
                    if(arrayList0 != null) {
                        for(Object object0: arrayList0) {
                            ((MotionHelper)object0).getClass();
                        }
                    }
                    if(n0 != null) {
                        n0.b(this);
                    }
                    this.D = this.E;
                }
                this.o();
                y y0 = this.N0;
                if(y0 != null) {
                    if(this.Y0) {
                        this.post(new s(this, 0));
                        return;
                    }
                    y0.a();
                    return;
                }
                if(this.o != null && (this.o.c != null && this.o.c.n == 4)) {
                    this.transitionToEnd();
                    this.setState(A.b);
                    this.setState(A.c);
                }
                return;
            }
            catch(Exception exception1) {
            }
            try {
                throw new IllegalArgumentException("unable to parse MotionScene file", exception1);
            }
            catch(Exception exception0) {
            }
            throw new IllegalArgumentException("unable to parse MotionScene file", exception0);
        }
        this.o = null;
    }

    public final boolean m(float f, float f1, View view0, MotionEvent motionEvent0) {
        boolean z1;
        boolean z = false;
        if(view0 instanceof ViewGroup) {
            for(int v = ((ViewGroup)view0).getChildCount() - 1; v >= 0; --v) {
                View view1 = ((ViewGroup)view0).getChildAt(v);
                if(this.m(((float)view1.getLeft()) + f - ((float)view0.getScrollX()), ((float)view1.getTop()) + f1 - ((float)view0.getScrollY()), view1, motionEvent0)) {
                    z = true;
                    break;
                }
            }
        }
        if(!z) {
            float f2 = ((float)view0.getRight()) + f - ((float)view0.getLeft());
            float f3 = ((float)view0.getBottom()) + f1 - ((float)view0.getTop());
            this.c1.set(f, f1, f2, f3);
            if(motionEvent0.getAction() != 0 || this.c1.contains(motionEvent0.getX(), motionEvent0.getY())) {
                Matrix matrix0 = view0.getMatrix();
                if(matrix0.isIdentity()) {
                    motionEvent0.offsetLocation(-f, -f1);
                    z1 = view0.onTouchEvent(motionEvent0);
                    motionEvent0.offsetLocation(--f, --f1);
                    return z1;
                }
                MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
                motionEvent1.offsetLocation(-f, -f1);
                if(this.e1 == null) {
                    this.e1 = new Matrix();
                }
                matrix0.invert(this.e1);
                motionEvent1.transform(this.e1);
                z1 = view0.onTouchEvent(motionEvent1);
                motionEvent1.recycle();
                return z1;
            }
        }
        return z;
    }

    public final void n(AttributeSet attributeSet0) {
        MotionLayout.IS_IN_EDIT_MODE = this.isInEditMode();
        int v = -1;
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, androidx.constraintlayout.widget.q.v);
            int v2 = typedArray0.getIndexCount();
            boolean z = true;
            for(int v3 = 0; v3 < v2; ++v3) {
                int v4 = 2;
                switch(typedArray0.getIndex(v3)) {
                    case 0: {
                        z = typedArray0.getBoolean(0, z);
                        break;
                    }
                    case 1: {
                        this.E = typedArray0.getResourceId(1, -1);
                        break;
                    }
                    case 2: {
                        int v5 = typedArray0.getResourceId(2, -1);
                        this.o = new E(this.getContext(), this, v5);
                        break;
                    }
                    case 3: {
                        this.h0 = typedArray0.getInt(3, 0);
                        break;
                    }
                    case 4: {
                        this.d0 = typedArray0.getFloat(4, 0.0f);
                        this.f0 = true;
                        break;
                    }
                    case 5: {
                        if(this.h0 == 0) {
                            if(!typedArray0.getBoolean(5, false)) {
                                v4 = 0;
                            }
                            this.h0 = v4;
                        }
                    }
                }
            }
            typedArray0.recycle();
            if(this.o == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if(!z) {
                this.o = null;
            }
        }
        if(this.h0 != 0) {
            E e0 = this.o;
            if(e0 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            }
            else {
                int v6 = e0.h();
                n n0 = this.o.b(this.o.h());
                String s = ye.a.F(this.getContext(), v6);
                int v7 = this.getChildCount();
                for(int v8 = 0; v8 < v7; ++v8) {
                    View view0 = this.getChildAt(v8);
                    int v9 = view0.getId();
                    if(v9 == -1) {
                        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("CHECK: ", s, " ALL VIEWS SHOULD HAVE ID\'s ");
                        stringBuilder0.append(view0.getClass().getName());
                        stringBuilder0.append(" does not!");
                        Log.w("MotionLayout", stringBuilder0.toString());
                    }
                    if(n0.m(v9) == null) {
                        StringBuilder stringBuilder1 = com.iloen.melon.utils.a.n("CHECK: ", s, " NO CONSTRAINTS for ");
                        stringBuilder1.append(ye.a.G(view0));
                        Log.w("MotionLayout", stringBuilder1.toString());
                    }
                }
                Integer[] arr_integer = (Integer[])n0.g.keySet().toArray(new Integer[0]);
                int[] arr_v = new int[arr_integer.length];
                for(int v10 = 0; v10 < arr_integer.length; ++v10) {
                    arr_v[v10] = (int)arr_integer[v10];
                }
                for(int v1 = 0; v1 < arr_integer.length; ++v1) {
                    int v11 = arr_v[v1];
                    String s1 = ye.a.F(this.getContext(), v11);
                    if(this.findViewById(arr_v[v1]) == null) {
                        Log.w("MotionLayout", "CHECK: " + s + " NO View matches id " + s1);
                    }
                    if(n0.l(v11).e.d == -1) {
                        Log.w("MotionLayout", "CHECK: " + s + "(" + s1 + ") no LAYOUT_HEIGHT");
                    }
                    if(n0.l(v11).e.c == -1) {
                        Log.w("MotionLayout", "CHECK: " + s + "(" + s1 + ") no LAYOUT_HEIGHT");
                    }
                }
                SparseIntArray sparseIntArray0 = new SparseIntArray();
                SparseIntArray sparseIntArray1 = new SparseIntArray();
                for(Object object0: this.o.d) {
                    if(((D)object0) == this.o.c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    if(((D)object0).d == ((D)object0).c) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int v12 = ((D)object0).d;
                    int v13 = ((D)object0).c;
                    String s2 = ye.a.F(this.getContext(), v12);
                    String s3 = ye.a.F(this.getContext(), v13);
                    if(sparseIntArray0.get(v12) == v13) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + s2 + "->" + s3);
                    }
                    if(sparseIntArray1.get(v13) == v12) {
                        Log.e("MotionLayout", "CHECK: you can\'t have reverse transitions" + s2 + "->" + s3);
                    }
                    sparseIntArray0.put(v12, v13);
                    sparseIntArray1.put(v13, v12);
                    if(this.o.b(v12) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart " + s2);
                    }
                    if(this.o.b(v13) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd " + s2);
                    }
                }
            }
        }
        if(this.E == -1) {
            E e1 = this.o;
            if(e1 != null) {
                this.E = e1.h();
                this.D = this.o.h();
                D d0 = this.o.c;
                if(d0 != null) {
                    v = d0.c;
                }
                this.G = v;
            }
        }
    }

    public final void o() {
        View view0;
        E e0 = this.o;
        if(e0 != null) {
            if(e0.a(this, this.E)) {
                this.requestLayout();
                return;
            }
            int v = this.E;
            if(v != -1) {
                ArrayList arrayList0 = this.o.f;
                ArrayList arrayList1 = this.o.d;
                for(Object object0: arrayList1) {
                    D d0 = (D)object0;
                    if(d0.m.size() > 0) {
                        for(Object object1: d0.m) {
                            ((C)object1).b(this);
                        }
                    }
                }
                for(Object object2: arrayList0) {
                    D d1 = (D)object2;
                    if(d1.m.size() > 0) {
                        for(Object object3: d1.m) {
                            ((C)object3).b(this);
                        }
                    }
                }
                for(Object object4: arrayList1) {
                    D d2 = (D)object4;
                    if(d2.m.size() > 0) {
                        for(Object object5: d2.m) {
                            ((C)object5).a(this, v, d2);
                        }
                    }
                }
                for(Object object6: arrayList0) {
                    D d3 = (D)object6;
                    if(d3.m.size() > 0) {
                        for(Object object7: d3.m) {
                            ((C)object7).a(this, v, d3);
                        }
                    }
                }
            }
            if(this.o.q()) {
                D d4 = this.o.c;
                if(d4 != null) {
                    F f0 = d4.l;
                    if(f0 != null) {
                        MotionLayout motionLayout0 = f0.r;
                        int v1 = f0.d;
                        if(v1 == -1) {
                            view0 = null;
                        }
                        else {
                            view0 = motionLayout0.findViewById(v1);
                            if(view0 == null) {
                                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + ye.a.F(motionLayout0.getContext(), f0.d));
                            }
                        }
                        if(view0 instanceof NestedScrollView) {
                            ((NestedScrollView)view0).setOnTouchListener(new B6.b(1));
                            ((NestedScrollView)view0).setOnScrollChangeListener(new d(15));
                        }
                    }
                }
            }
        }
    }

    public w obtainVelocityTracker() {
        androidx.constraintlayout.motion.widget.x.b.a = VelocityTracker.obtain();
        return androidx.constraintlayout.motion.widget.x.b;
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display0 = this.getDisplay();
        if(display0 != null) {
            this.W0 = display0.getRotation();
        }
        E e0 = this.o;
        if(e0 != null) {
            int v = this.E;
            if(v != -1) {
                n n0 = e0.b(v);
                this.o.o(this);
                ArrayList arrayList0 = this.x0;
                if(arrayList0 != null) {
                    for(Object object0: arrayList0) {
                        ((MotionHelper)object0).getClass();
                    }
                }
                if(n0 != null) {
                    n0.b(this);
                }
                this.D = this.E;
            }
        }
        this.o();
        y y0 = this.N0;
        if(y0 != null) {
            if(this.Y0) {
                this.post(new s(this, 2));
                return;
            }
            y0.a();
            return;
        }
        if(this.o != null && (this.o.c != null && this.o.c.n == 4)) {
            this.transitionToEnd();
            this.setState(A.b);
            this.setState(A.c);
        }
    }

    @Override  // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        E e0 = this.o;
        if(e0 != null && this.N) {
            E9.u u0 = e0.q;
            if(u0 != null) {
                ArrayList arrayList0 = (ArrayList)u0.c;
                MotionLayout motionLayout0 = (MotionLayout)u0.a;
                int v = motionLayout0.getCurrentState();
                if(v != -1) {
                    if(((HashSet)u0.b) == null) {
                        u0.b = new HashSet();
                        for(Object object0: arrayList0) {
                            I i0 = (I)object0;
                            int v1 = motionLayout0.getChildCount();
                            for(int v2 = 0; v2 < v1; ++v2) {
                                View view0 = motionLayout0.getChildAt(v2);
                                if(i0.c(view0)) {
                                    view0.getId();
                                    ((HashSet)u0.b).add(view0);
                                }
                            }
                        }
                    }
                    float f = motionEvent0.getX();
                    float f1 = motionEvent0.getY();
                    Rect rect0 = new Rect();
                    int v3 = motionEvent0.getAction();
                    ArrayList arrayList1 = (ArrayList)u0.d;
                    if(arrayList1 != null && !arrayList1.isEmpty()) {
                        for(Object object1: ((ArrayList)u0.d)) {
                            H h0 = (H)object1;
                            Rect rect1 = h0.l;
                            switch(v3) {
                                case 1: {
                                    if(h0.h) {
                                        continue;
                                    }
                                    h0.b();
                                    continue;
                                }
                                case 2: {
                                    h0.c.b.getHitRect(rect1);
                                    if(!rect1.contains(((int)f), ((int)f1)) && !h0.h) {
                                        break;
                                    }
                                    continue;
                                }
                                default: {
                                    continue;
                                }
                            }
                            h0.b();
                        }
                    }
                    if(v3 == 0 || v3 == 1) {
                        n n0 = motionLayout0.getConstraintSet(v);
                        for(Object object2: arrayList0) {
                            I i1 = (I)object2;
                            int v4 = i1.b;
                            if(v4 == 1) {
                                if(v3 != 0) {
                                    continue;
                                }
                            }
                            else if(v4 != 2) {
                                if(v4 == 3 && v3 == 0) {
                                    goto label_58;
                                }
                                continue;
                            }
                            else if(v3 != 1) {
                                continue;
                            }
                        label_58:
                            for(Object object3: ((HashSet)u0.b)) {
                                View view1 = (View)object3;
                                if(i1.c(view1)) {
                                    view1.getHitRect(rect0);
                                    if(rect0.contains(((int)f), ((int)f1))) {
                                        i1.a(u0, ((MotionLayout)u0.a), v, n0, new View[]{view1});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            D d0 = this.o.c;
            if(d0 != null && !d0.o) {
                F f2 = d0.l;
                if(f2 != null) {
                    if(motionEvent0.getAction() == 0) {
                        RectF rectF0 = f2.b(this, new RectF());
                        if(rectF0 == null || rectF0.contains(motionEvent0.getX(), motionEvent0.getY())) {
                            goto label_75;
                        }
                    }
                    else {
                    label_75:
                        int v5 = f2.e;
                        if(v5 != -1) {
                            if(this.d1 == null || this.d1.getId() != v5) {
                                this.d1 = this.findViewById(v5);
                            }
                            View view2 = this.d1;
                            if(view2 != null) {
                                float f3 = (float)view2.getLeft();
                                float f4 = (float)this.d1.getTop();
                                float f5 = (float)this.d1.getRight();
                                float f6 = (float)this.d1.getBottom();
                                this.c1.set(f3, f4, f5, f6);
                                float f7 = motionEvent0.getX();
                                float f8 = motionEvent0.getY();
                                return !this.c1.contains(f7, f8) || this.m(((float)this.d1.getLeft()), ((float)this.d1.getTop()), this.d1, motionEvent0) ? false : this.onTouchEvent(motionEvent0);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        try {
            this.M0 = true;
            if(this.o == null) {
                super.onLayout(z, v, v1, v2, v3);
                this.M0 = false;
                return;
            }
            int v4 = v2 - v;
            int v5 = v3 - v1;
            if(this.n0 != v4 || this.o0 != v5) {
                this.rebuildScene();
                this.j(true);
            }
            this.n0 = v4;
            this.o0 = v5;
            this.M0 = false;
        }
        catch(Throwable throwable0) {
            this.M0 = false;
            throw throwable0;
        }
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void onMeasure(int v, int v1) {
        boolean z2;
        if(this.o == null) {
            super.onMeasure(v, v1);
            return;
        }
        boolean z = true;
        boolean z1 = this.I != v || this.M != v1;
        if(this.b1) {
            this.b1 = false;
            this.o();
            this.p();
            z1 = true;
        }
        if(this.mDirtyHierarchy) {
            z1 = true;
        }
        this.I = v;
        this.M = v1;
        int v3 = this.o.h();
        D d0 = this.o.c;
        int v4 = d0 == null ? -1 : d0.c;
        v v5 = this.a1;
        if(!z1 && v3 == v5.e && v4 == v5.f || this.D == -1) {
            if(z1) {
                super.onMeasure(v, v1);
            }
            z2 = true;
        }
        else {
            super.onMeasure(v, v1);
            v5.e(this.o.b(v3), this.o.b(v4));
            v5.f();
            v5.e = v3;
            v5.f = v4;
            z2 = false;
        }
        if(this.mMeasureDuringTransition || z2) {
            int v6 = this.getPaddingTop();
            int v7 = this.getPaddingBottom();
            int v8 = this.getPaddingLeft();
            int v9 = this.getPaddingRight();
            int v10 = this.mLayoutWidget.s() + (v9 + v8);
            int v11 = this.mLayoutWidget.m() + (v7 + v6);
            if(this.I0 == 0x80000000 || this.I0 == 0) {
                v10 = (int)(this.K0 * ((float)(this.G0 - this.E0)) + ((float)this.E0));
                this.requestLayout();
            }
            if(this.J0 == 0x80000000 || this.J0 == 0) {
                v11 = (int)(this.K0 * ((float)(this.H0 - this.F0)) + ((float)this.F0));
                this.requestLayout();
            }
            this.setMeasuredDimension(v10, v11);
        }
        float f = Math.signum(this.d0 - this.b0);
        r r0 = this.r;
        float f1 = this.e0 ? this.d0 : this.b0 + (r0 instanceof a ? 0.0f : ((float)(13896306431100L - this.c0)) * f * 1.000000E-09f / this.V);
        int v12 = Float.compare(f, 0.0f);
        if((v12 <= 0 || f1 < this.d0) && (f > 0.0f || f1 > this.d0)) {
            z = false;
        }
        else {
            f1 = this.d0;
        }
        if(r0 != null && !z) {
            f1 = this.j0 ? r0.getInterpolation(((float)(13896306431100L - this.T)) * 1.000000E-09f) : r0.getInterpolation(f1);
        }
        if(v12 > 0 && f1 >= this.d0 || f <= 0.0f && f1 <= this.d0) {
            f1 = this.d0;
        }
        this.K0 = f1;
        int v13 = this.getChildCount();
        Interpolator interpolator0 = this.w;
        if(interpolator0 != null) {
            f1 = interpolator0.getInterpolation(f1);
        }
        for(int v2 = 0; v2 < v13; ++v2) {
            View view0 = this.getChildAt(v2);
            q q0 = (q)this.S.get(view0);
            if(q0 != null) {
                q0.f(f1, 13896306940300L, this.L0, view0);
            }
        }
        if(this.mMeasureDuringTransition) {
            this.requestLayout();
        }
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedFling(View view0, float f, float f1, boolean z) {
        return false;
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedPreFling(View view0, float f, float f1) {
        return false;
    }

    @Override  // c2.s
    public void onNestedPreScroll(View view0, int v, int v1, int[] arr_v, int v2) {
        float f4;
        boolean z;
        E e0 = this.o;
        if(e0 != null) {
            int v3 = -1;
            D d0 = e0.c;
            if(d0 != null && !d0.o) {
                F f0 = d0.l;
                if(f0 == null || (f0.e == -1 || view0.getId() == f0.e)) {
                    D d1 = e0.c;
                    if(d1 == null) {
                        z = false;
                    }
                    else {
                        F f1 = d1.l;
                        z = f1 == null ? false : f1.u;
                    }
                    if(z) {
                        if(d0.l != null && (d0.l.w & 4) != 0) {
                            v3 = v1;
                        }
                        if(this.W != 0 && this.W != 0x3F800000 || !view0.canScrollVertically(v3)) {
                            goto label_20;
                        }
                    }
                    else {
                    label_20:
                        if(d0.l != null && (d0.l.w & 1) != 0) {
                            D d2 = e0.c;
                            if(d2 == null) {
                                f4 = 0.0f;
                            }
                            else {
                                F f2 = d2.l;
                                if(f2 == null) {
                                    f4 = 0.0f;
                                }
                                else {
                                    float[] arr_f = f2.n;
                                    f2.r.l(f2.d, f2.r.getProgress(), f2.h, f2.g, f2.n);
                                    float f3 = f2.k;
                                    if(Float.compare(f3, 0.0f) == 0) {
                                        if(arr_f[1] == 0.0f) {
                                            arr_f[1] = 1.000000E-07f;
                                        }
                                        f4 = ((float)v1) * f2.l / arr_f[1];
                                    }
                                    else {
                                        if(arr_f[0] == 0.0f) {
                                            arr_f[0] = 1.000000E-07f;
                                        }
                                        f4 = ((float)v) * f3 / arr_f[0];
                                    }
                                }
                            }
                            if(this.b0 <= 0.0f && f4 < 0.0f || this.b0 >= 1.0f && f4 > 0.0f) {
                                view0.setNestedScrollingEnabled(false);
                                view0.post(new s(view0, 3));
                                return;
                            }
                        }
                        float f5 = this.W;
                        this.q0 = (float)v;
                        this.r0 = (float)v1;
                        this.t0 = (float)(((double)(0xCA38CD057F0L - this.s0)) * 1.000000E-09);
                        this.s0 = 0xCA38CD057F0L;
                        D d3 = e0.c;
                        if(d3 != null) {
                            F f6 = d3.l;
                            if(f6 != null) {
                                float[] arr_f1 = f6.n;
                                MotionLayout motionLayout0 = f6.r;
                                float f7 = motionLayout0.getProgress();
                                if(!f6.m) {
                                    f6.m = true;
                                    motionLayout0.setProgress(f7);
                                }
                                f6.r.l(f6.d, f7, f6.h, f6.g, f6.n);
                                if(((double)Math.abs(f6.l * arr_f1[1] + f6.k * arr_f1[0])) < 0.01) {
                                    arr_f1[0] = 0.01f;
                                    arr_f1[1] = 0.01f;
                                }
                                float f8 = Math.max(Math.min(f7 + (f6.k == 0.0f ? ((float)v1) * f6.l / arr_f1[1] : ((float)v) * f6.k / arr_f1[0]), 1.0f), 0.0f);
                                if(f8 != motionLayout0.getProgress()) {
                                    motionLayout0.setProgress(f8);
                                }
                            }
                        }
                        if(f5 != this.W) {
                            arr_v[0] = v;
                            arr_v[1] = v1;
                        }
                        this.j(false);
                        if(arr_v[0] != 0 || arr_v[1] != 0) {
                            this.p0 = true;
                        }
                    }
                }
            }
        }
    }

    @Override  // c2.s
    public void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4) {
    }

    @Override  // c2.t
    public void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        if(this.p0 || v != 0 || v1 != 0) {
            arr_v[0] += v2;
            arr_v[1] += v3;
        }
        this.p0 = false;
    }

    @Override  // c2.s
    public void onNestedScrollAccepted(View view0, View view1, int v, int v1) {
        this.s0 = 13896461401700L;
        this.t0 = 0.0f;
        this.q0 = 0.0f;
        this.r0 = 0.0f;
    }

    @Override  // android.view.View
    public void onRtlPropertiesChanged(int v) {
        E e0 = this.o;
        if(e0 != null) {
            boolean z = this.isRtl();
            e0.p = z;
            D d0 = e0.c;
            if(d0 != null) {
                F f0 = d0.l;
                if(f0 != null) {
                    f0.c(z);
                }
            }
        }
    }

    @Override  // c2.s
    public boolean onStartNestedScroll(View view0, View view1, int v, int v1) {
        return this.o != null && (this.o.c != null && (this.o.c.l != null && (this.o.c.l.w & 2) == 0));
    }

    @Override  // c2.s
    public void onStopNestedScroll(View view0, int v) {
        E e0 = this.o;
        if(e0 != null) {
            float f = this.t0;
            float f1 = 0.0f;
            if(f != 0.0f) {
                float f2 = this.q0 / f;
                float f3 = this.r0 / f;
                D d0 = e0.c;
                if(d0 != null) {
                    F f4 = d0.l;
                    if(f4 != null) {
                        f4.m = false;
                        MotionLayout motionLayout0 = f4.r;
                        float f5 = motionLayout0.getProgress();
                        f4.r.l(f4.d, f5, f4.h, f4.g, f4.n);
                        float f6 = f4.k == 0.0f ? f3 * f4.l / f4.n[1] : f2 * f4.k / f4.n[0];
                        if(!Float.isNaN(f6)) {
                            f5 += f6 / 3.0f;
                        }
                        if(f5 != 0 && f5 != 0x3F800000) {
                            int v1 = f4.c;
                            if(v1 != 3) {
                                if(((double)f5) >= 0.5) {
                                    f1 = 1.0f;
                                }
                                motionLayout0.touchAnimateTo(v1, f1, f6);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        MotionEvent motionEvent2;
        float f9;
        float f8;
        float f55;
        float f40;
        float[] arr_f1;
        float f24;
        int v3;
        float f19;
        float f18;
        if(this.o != null && this.N && this.o.q()) {
            E e0 = this.o;
            if(e0.c != null && e0.c.o) {
                return super.onTouchEvent(motionEvent0);
            }
            int v = this.getCurrentState();
            MotionLayout motionLayout0 = e0.a;
            RectF rectF0 = new RectF();
            if(e0.o == null) {
                e0.o = motionLayout0.obtainVelocityTracker();
            }
            VelocityTracker velocityTracker0 = ((androidx.constraintlayout.motion.widget.x)e0.o).a;
            if(velocityTracker0 != null) {
                velocityTracker0.addMovement(motionEvent0);
            }
            if(v == -1) {
            label_89:
                if(!e0.m) {
                    D d2 = e0.c;
                    if(d2 != null) {
                        F f11 = d2.l;
                        if(f11 != null && !e0.n) {
                            w w0 = e0.o;
                            float[] arr_f = f11.n;
                            MotionLayout motionLayout1 = f11.r;
                            A a0 = A.d;
                            if(f11.j) {
                                int[] arr_v = f11.o;
                                VelocityTracker velocityTracker1 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                if(velocityTracker1 != null) {
                                    velocityTracker1.addMovement(motionEvent0);
                                }
                                switch(motionEvent0.getAction()) {
                                    case 0: {
                                        f11.p = motionEvent0.getRawX();
                                        f11.q = motionEvent0.getRawY();
                                        f11.m = false;
                                        break;
                                    }
                                    case 1: {
                                        f11.m = false;
                                        VelocityTracker velocityTracker2 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                        if(velocityTracker2 != null) {
                                            velocityTracker2.computeCurrentVelocity(16);
                                        }
                                        VelocityTracker velocityTracker3 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                        float f12 = velocityTracker3 == null ? 0.0f : velocityTracker3.getXVelocity();
                                        VelocityTracker velocityTracker4 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                        float f13 = velocityTracker4 == null ? 0.0f : velocityTracker4.getYVelocity();
                                        float f14 = motionLayout1.getProgress();
                                        float f15 = ((float)motionLayout1.getWidth()) / 2.0f;
                                        float f16 = ((float)motionLayout1.getHeight()) / 2.0f;
                                        int v1 = f11.i;
                                        if(v1 == -1) {
                                            int v4 = f11.d;
                                            if(v4 != -1) {
                                                View view1 = motionLayout1.findViewById(v4);
                                                View view2 = motionLayout1.findViewById(((q)motionLayout1.S.get(view1)).f.k);
                                                motionLayout1.getLocationOnScreen(arr_v);
                                                float f20 = (float)arr_v[0];
                                                int v5 = view2.getLeft();
                                                f18 = f20 + ((float)(view2.getRight() + v5)) / 2.0f;
                                                f19 = (float)arr_v[1];
                                                v3 = view2.getTop();
                                                f15 = f18;
                                                f16 = f19 + ((float)(view2.getBottom() + v3)) / 2.0f;
                                            }
                                        }
                                        else {
                                            View view0 = motionLayout1.findViewById(v1);
                                            motionLayout1.getLocationOnScreen(arr_v);
                                            float f17 = (float)arr_v[0];
                                            int v2 = view0.getLeft();
                                            f18 = f17 + ((float)(view0.getRight() + v2)) / 2.0f;
                                            f19 = (float)arr_v[1];
                                            v3 = view0.getTop();
                                            f15 = f18;
                                            f16 = f19 + ((float)(view0.getBottom() + v3)) / 2.0f;
                                        }
                                        float f21 = motionEvent0.getRawX() - f15;
                                        float f22 = motionEvent0.getRawY() - f16;
                                        double f23 = Math.toDegrees(Math.atan2(f22, f21));
                                        int v6 = f11.d;
                                        if(v6 == -1) {
                                            f24 = f13;
                                            arr_f[1] = 360.0f;
                                        }
                                        else {
                                            f24 = f13;
                                            f11.r.l(v6, f14, f11.h, f11.g, f11.n);
                                            arr_f[1] = (float)Math.toDegrees(arr_f[1]);
                                        }
                                        float f25 = ((float)(Math.toDegrees(Math.atan2(f24 + f22, f12 + f21)) - f23)) * 62.5f;
                                        float f26 = Float.isNaN(f25) ? f14 : f25 * 3.0f * f11.v / arr_f[1] + f14;
                                        if(f26 == 0 || f26 == 0x3F800000) {
                                        label_174:
                                            if(0.0f >= f26 || 1.0f <= f26) {
                                                motionLayout1.setState(a0);
                                            }
                                        }
                                        else {
                                            int v7 = f11.c;
                                            if(v7 == 3) {
                                                goto label_174;
                                            }
                                            else {
                                                float f27 = f25 * f11.v / arr_f[1];
                                                float f28 = ((double)f26) < 0.5 ? 0.0f : 1.0f;
                                                if(v7 == 6) {
                                                    if(f14 + f27 < 0.0f) {
                                                        f27 = Math.abs(f27);
                                                    }
                                                    f28 = 1.0f;
                                                }
                                                if(f11.c == 7) {
                                                    if(f14 + f27 > 1.0f) {
                                                        f27 = -Math.abs(f27);
                                                    }
                                                    f28 = 0.0f;
                                                }
                                                motionLayout1.touchAnimateTo(f11.c, f28, f27 * 3.0f);
                                                if(0.0f >= f14 || 1.0f <= f14) {
                                                    motionLayout1.setState(a0);
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        motionEvent0.getRawY();
                                        motionEvent0.getRawX();
                                        float f29 = ((float)motionLayout1.getWidth()) / 2.0f;
                                        float f30 = ((float)motionLayout1.getHeight()) / 2.0f;
                                        int v8 = f11.i;
                                        if(v8 == -1) {
                                            int v12 = f11.d;
                                            if(v12 != -1) {
                                                View view4 = motionLayout1.findViewById(v12);
                                                View view5 = motionLayout1.findViewById(((q)motionLayout1.S.get(view4)).f.k);
                                                if(view5 == null) {
                                                    Log.e("TouchResponse", "could not find view to animate to");
                                                }
                                                else {
                                                    motionLayout1.getLocationOnScreen(arr_v);
                                                    float f33 = (float)arr_v[0];
                                                    int v13 = view5.getLeft();
                                                    f29 = f33 + ((float)(view5.getRight() + v13)) / 2.0f;
                                                    float f34 = (float)arr_v[1];
                                                    int v14 = view5.getTop();
                                                    f30 = ((float)(view5.getBottom() + v14)) / 2.0f + f34;
                                                }
                                            }
                                        }
                                        else {
                                            View view3 = motionLayout1.findViewById(v8);
                                            motionLayout1.getLocationOnScreen(arr_v);
                                            float f31 = (float)arr_v[0];
                                            int v9 = view3.getLeft();
                                            int v10 = view3.getRight();
                                            float f32 = (float)arr_v[1];
                                            int v11 = view3.getTop();
                                            f29 = f31 + ((float)(v10 + v9)) / 2.0f;
                                            f30 = f32 + ((float)(view3.getBottom() + v11)) / 2.0f;
                                        }
                                        float f35 = motionEvent0.getRawX();
                                        float f36 = motionEvent0.getRawY();
                                        double f37 = Math.atan2(motionEvent0.getRawY() - f30, motionEvent0.getRawX() - f29);
                                        float f38 = (float)((f37 - Math.atan2(f11.q - f30, f11.p - f29)) * 180.0 / 3.141593);
                                        if(f38 > 330.0f) {
                                            f38 -= 360.0f;
                                        }
                                        else if(f38 < -330.0f) {
                                            f38 += 360.0f;
                                        }
                                        if(((double)Math.abs(f38)) > 0.01 || f11.m) {
                                            float f39 = motionLayout1.getProgress();
                                            if(!f11.m) {
                                                f11.m = true;
                                                motionLayout1.setProgress(f39);
                                            }
                                            int v15 = f11.d;
                                            if(v15 == -1) {
                                                arr_f1 = arr_f;
                                                f40 = f39;
                                                arr_f1[1] = 360.0f;
                                            }
                                            else {
                                                arr_f1 = arr_f;
                                                f40 = f39;
                                                f11.r.l(v15, f40, f11.h, f11.g, f11.n);
                                                arr_f1[1] = (float)Math.toDegrees(arr_f1[1]);
                                            }
                                            float f41 = Math.max(Math.min(f38 * f11.v / arr_f1[1] + f40, 1.0f), 0.0f);
                                            float f42 = motionLayout1.getProgress();
                                            if(f41 == f42) {
                                                motionLayout1.B = 0.0f;
                                            }
                                            else {
                                                int v16 = Float.compare(f42, 0.0f);
                                                if(v16 == 0 || f42 == 1.0f) {
                                                    motionLayout1.i(v16 == 0);
                                                }
                                                motionLayout1.setProgress(f41);
                                                VelocityTracker velocityTracker5 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                                if(velocityTracker5 != null) {
                                                    velocityTracker5.computeCurrentVelocity(1000);
                                                }
                                                VelocityTracker velocityTracker6 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                                float f43 = velocityTracker6 == null ? 0.0f : velocityTracker6.getXVelocity();
                                                VelocityTracker velocityTracker7 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                                float f44 = velocityTracker7 == null ? 0.0f : velocityTracker7.getYVelocity();
                                                motionLayout1.B = (float)Math.toDegrees(((float)(Math.sin(Math.atan2(f44, f43) - f37) * Math.hypot(f44, f43) / Math.hypot(f35 - f29, f36 - f30))));
                                            }
                                            goto label_334;
                                        }
                                    }
                                }
                            }
                            else {
                                VelocityTracker velocityTracker8 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                if(velocityTracker8 != null) {
                                    velocityTracker8.addMovement(motionEvent0);
                                }
                                switch(motionEvent0.getAction()) {
                                    case 0: {
                                        f11.p = motionEvent0.getRawX();
                                        f11.q = motionEvent0.getRawY();
                                        f11.m = false;
                                        break;
                                    }
                                    case 1: {
                                        f11.m = false;
                                        VelocityTracker velocityTracker9 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                        if(velocityTracker9 != null) {
                                            velocityTracker9.computeCurrentVelocity(1000);
                                        }
                                        VelocityTracker velocityTracker10 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                        float f45 = velocityTracker10 == null ? 0.0f : velocityTracker10.getXVelocity();
                                        VelocityTracker velocityTracker11 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                        float f46 = velocityTracker11 == null ? 0.0f : velocityTracker11.getYVelocity();
                                        float f47 = motionLayout1.getProgress();
                                        int v17 = f11.d;
                                        if(v17 == -1) {
                                            float f48 = (float)Math.min(motionLayout1.getWidth(), motionLayout1.getHeight());
                                            arr_f[1] = f11.l * f48;
                                            arr_f[0] = f48 * f11.k;
                                        }
                                        else {
                                            f11.r.l(v17, f47, f11.h, f11.g, f11.n);
                                        }
                                        float f49 = f11.k == 0.0f ? f46 / arr_f[1] : f45 / arr_f[0];
                                        float f50 = Float.isNaN(f49) ? f47 : f49 / 3.0f + f47;
                                        if(f50 == 0 || f50 == 0x3F800000) {
                                        label_292:
                                            if(0.0f >= f50 || 1.0f <= f50) {
                                                motionLayout1.setState(a0);
                                            }
                                        }
                                        else {
                                            int v18 = f11.c;
                                            if(v18 == 3) {
                                                goto label_292;
                                            }
                                            else {
                                                float f51 = ((double)f50) < 0.5 ? 0.0f : 1.0f;
                                                if(v18 == 6) {
                                                    if(f47 + f49 < 0.0f) {
                                                        f49 = Math.abs(f49);
                                                    }
                                                    f51 = 1.0f;
                                                }
                                                if(f11.c == 7) {
                                                    if(f47 + f49 > 1.0f) {
                                                        f49 = -Math.abs(f49);
                                                    }
                                                    f51 = 0.0f;
                                                }
                                                motionLayout1.touchAnimateTo(f11.c, f51, f49);
                                                if(0.0f >= f47 || 1.0f <= f47) {
                                                    motionLayout1.setState(a0);
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        float f52 = motionEvent0.getRawY() - f11.q;
                                        float f53 = motionEvent0.getRawX() - f11.p;
                                        if(Math.abs(f11.l * f52 + f11.k * f53) > f11.x || f11.m) {
                                            float f54 = motionLayout1.getProgress();
                                            if(!f11.m) {
                                                f11.m = true;
                                                motionLayout1.setProgress(f54);
                                            }
                                            int v19 = f11.d;
                                            if(v19 == -1) {
                                                f55 = f54;
                                                float f56 = (float)Math.min(motionLayout1.getWidth(), motionLayout1.getHeight());
                                                arr_f[1] = f11.l * f56;
                                                arr_f[0] = f56 * f11.k;
                                            }
                                            else {
                                                f55 = f54;
                                                f11.r.l(v19, f55, f11.h, f11.g, f11.n);
                                            }
                                            if(Double.compare(Math.abs((f11.l * arr_f[1] + f11.k * arr_f[0]) * f11.v), 0.01) < 0) {
                                                arr_f[0] = 0.01f;
                                                arr_f[1] = 0.01f;
                                            }
                                            float f57 = f11.k == 0.0f ? f52 / arr_f[1] : f53 / arr_f[0];
                                            float f58 = f11.c == 6 ? Math.max(Math.max(Math.min(f55 + f57, 1.0f), 0.0f), 0.01f) : Math.max(Math.min(f55 + f57, 1.0f), 0.0f);
                                            if(f11.c == 7) {
                                                f58 = Math.min(f58, 0.99f);
                                            }
                                            float f59 = motionLayout1.getProgress();
                                            if(f58 == f59) {
                                                motionLayout1.B = 0.0f;
                                            }
                                            else {
                                                int v20 = Float.compare(f59, 0.0f);
                                                if(v20 == 0 || f59 == 1.0f) {
                                                    motionLayout1.i(v20 == 0);
                                                }
                                                motionLayout1.setProgress(f58);
                                                VelocityTracker velocityTracker12 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                                if(velocityTracker12 != null) {
                                                    velocityTracker12.computeCurrentVelocity(1000);
                                                }
                                                VelocityTracker velocityTracker13 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                                float f60 = velocityTracker13 == null ? 0.0f : velocityTracker13.getXVelocity();
                                                VelocityTracker velocityTracker14 = ((androidx.constraintlayout.motion.widget.x)w0).a;
                                                float f61 = velocityTracker14 == null ? 0.0f : velocityTracker14.getYVelocity();
                                                motionLayout1.B = f11.k == 0.0f ? f61 / arr_f[1] : f60 / arr_f[0];
                                            }
                                        label_334:
                                            f11.p = motionEvent0.getRawX();
                                            f11.q = motionEvent0.getRawY();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    e0.r = motionEvent0.getRawX();
                    e0.s = motionEvent0.getRawY();
                    if(motionEvent0.getAction() == 1) {
                        w w1 = e0.o;
                        if(w1 != null) {
                            VelocityTracker velocityTracker15 = ((androidx.constraintlayout.motion.widget.x)w1).a;
                            if(velocityTracker15 != null) {
                                velocityTracker15.recycle();
                                ((androidx.constraintlayout.motion.widget.x)w1).a = null;
                            }
                            e0.o = null;
                            int v21 = this.E;
                            if(v21 != -1) {
                                e0.a(this, v21);
                            }
                        }
                    }
                }
            }
            else {
                switch(motionEvent0.getAction()) {
                    case 0: {
                        e0.r = motionEvent0.getRawX();
                        e0.s = motionEvent0.getRawY();
                        e0.l = motionEvent0;
                        e0.m = false;
                        F f0 = e0.c.l;
                        if(f0 != null) {
                            RectF rectF1 = f0.a(motionLayout0, rectF0);
                            if(rectF1 == null || rectF1.contains(e0.l.getX(), e0.l.getY())) {
                                RectF rectF2 = e0.c.l.b(motionLayout0, rectF0);
                                e0.n = rectF2 == null || rectF2.contains(e0.l.getX(), e0.l.getY()) ? false : true;
                                e0.c.l.p = e0.r;
                                e0.c.l.q = e0.s;
                            }
                            else {
                                e0.l = null;
                                e0.m = true;
                            }
                        }
                        break;
                    }
                    case 2: {
                        if(e0.m) {
                            goto label_89;
                        }
                        else {
                            float f1 = motionEvent0.getRawY() - e0.s;
                            float f2 = motionEvent0.getRawX() - e0.r;
                            if(((double)f2) != 0.0 || ((double)f1) != 0.0) {
                                MotionEvent motionEvent1 = e0.l;
                                if(motionEvent1 != null) {
                                    ArrayList arrayList0 = e0.i(v);
                                    RectF rectF3 = new RectF();
                                    float f3 = 0.0f;
                                    D d0 = null;
                                    for(Object object0: arrayList0) {
                                        D d1 = (D)object0;
                                        if(!d1.o) {
                                            F f4 = d1.l;
                                            if(f4 == null) {
                                                f8 = f1;
                                                f9 = f2;
                                                motionEvent2 = motionEvent1;
                                            }
                                            else {
                                                f4.c(e0.p);
                                                RectF rectF4 = d1.l.b(motionLayout0, rectF3);
                                                if(rectF4 != null && !rectF4.contains(motionEvent1.getX(), motionEvent1.getY())) {
                                                    continue;
                                                }
                                                RectF rectF5 = d1.l.a(motionLayout0, rectF3);
                                                if(rectF5 != null && !rectF5.contains(motionEvent1.getX(), motionEvent1.getY())) {
                                                    continue;
                                                }
                                                float f5 = d1.l.l * f1 + d1.l.k * f2;
                                                if(d1.l.j) {
                                                    float f6 = motionEvent1.getX();
                                                    d1.l.getClass();
                                                    float f7 = motionEvent1.getY();
                                                    d1.l.getClass();
                                                    f8 = f1;
                                                    f9 = f2;
                                                    motionEvent2 = motionEvent1;
                                                    f5 = ((float)(Math.atan2(f1 + (f7 - 0.5f), f2 + (f6 - 0.5f)) - Math.atan2(f6 - 0.5f, f7 - 0.5f))) * 10.0f;
                                                }
                                                else {
                                                    f8 = f1;
                                                    f9 = f2;
                                                    motionEvent2 = motionEvent1;
                                                }
                                                float f10 = f5 * (d1.c == v ? -1.0f : 1.1f);
                                                if(f10 > f3) {
                                                    f3 = f10;
                                                    d0 = d1;
                                                }
                                            }
                                            f1 = f8;
                                            f2 = f9;
                                            motionEvent1 = motionEvent2;
                                        }
                                    }
                                    if(d0 != null) {
                                        this.setTransition(d0);
                                        RectF rectF6 = e0.c.l.b(motionLayout0, rectF0);
                                        e0.n = rectF6 != null && !rectF6.contains(e0.l.getX(), e0.l.getY());
                                        e0.c.l.p = e0.r;
                                        e0.c.l.q = e0.s;
                                        e0.c.l.m = false;
                                    }
                                    goto label_89;
                                }
                            }
                        }
                        break;
                    }
                    default: {
                        goto label_89;
                    }
                }
            }
            D d3 = this.o.c;
            return (d3.r & 4) == 0 ? true : d3.l.m;
        }
        return super.onTouchEvent(motionEvent0);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewAdded(View view0) {
        super.onViewAdded(view0);
        if(view0 instanceof MotionHelper) {
            if(this.y0 == null) {
                this.y0 = new CopyOnWriteArrayList();
            }
            this.y0.add(((MotionHelper)view0));
            if(((MotionHelper)view0).j) {
                if(this.v0 == null) {
                    this.v0 = new ArrayList();
                }
                this.v0.add(((MotionHelper)view0));
            }
            if(((MotionHelper)view0).k) {
                if(this.w0 == null) {
                    this.w0 = new ArrayList();
                }
                this.w0.add(((MotionHelper)view0));
            }
            if(((MotionHelper)view0) instanceof MotionEffect) {
                if(this.x0 == null) {
                    this.x0 = new ArrayList();
                }
                this.x0.add(((MotionHelper)view0));
            }
        }
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view0) {
        super.onViewRemoved(view0);
        ArrayList arrayList0 = this.v0;
        if(arrayList0 != null) {
            arrayList0.remove(view0);
        }
        ArrayList arrayList1 = this.w0;
        if(arrayList1 != null) {
            arrayList1.remove(view0);
        }
    }

    public final void p() {
        if(this.g0 == null && (this.y0 == null || this.y0.isEmpty())) {
            return;
        }
        ArrayList arrayList0 = this.f1;
        for(Object object0: arrayList0) {
            Integer integer0 = (Integer)object0;
            z z0 = this.g0;
            if(z0 != null) {
                z0.onTransitionCompleted(this, ((int)integer0));
            }
            CopyOnWriteArrayList copyOnWriteArrayList0 = this.y0;
            if(copyOnWriteArrayList0 != null) {
                for(Object object1: copyOnWriteArrayList0) {
                    ((z)object1).onTransitionCompleted(this, ((int)integer0));
                }
            }
        }
        arrayList0.clear();
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int v) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
        this.rebuildScene();
    }

    public void rebuildScene() {
        this.a1.f();
        this.invalidate();
    }

    public boolean removeTransitionListener(z z0) {
        return this.y0 == null ? false : this.y0.remove(z0);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void requestLayout() {
        if(!this.mMeasureDuringTransition && this.E == -1) {
            E e0 = this.o;
            if(e0 != null) {
                D d0 = e0.c;
                if(d0 != null) {
                    int v = d0.q;
                    if(v == 0) {
                        return;
                    }
                    if(v == 2) {
                        int v1 = this.getChildCount();
                        for(int v2 = 0; v2 < v1; ++v2) {
                            View view0 = this.getChildAt(v2);
                            ((q)this.S.get(view0)).d = true;
                        }
                        return;
                    }
                }
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int v, int v1) {
        int v2 = 1;
        this.R0 = true;
        this.U0 = this.getWidth();
        this.V0 = this.getHeight();
        int v3 = this.getDisplay().getRotation();
        if((v3 + 1) % 4 <= (this.W0 + 1) % 4) {
            v2 = 2;
        }
        this.S0 = v2;
        this.W0 = v3;
        int v4 = this.getChildCount();
        for(int v5 = 0; v5 < v4; ++v5) {
            View view0 = this.getChildAt(v5);
            HashMap hashMap0 = this.T0;
            l l0 = (l)hashMap0.get(view0);
            if(l0 == null) {
                l0 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
                hashMap0.put(view0, l0);
            }
            l0.b = view0.getLeft();
            l0.c = view0.getTop();
            l0.d = view0.getRight();
            l0.e = view0.getBottom();
            l0.a = view0.getRotation();
        }
        this.D = -1;
        this.G = v;
        this.o.p(-1, v);
        n n0 = this.o.b(this.G);
        this.a1.e(null, n0);
        this.W = 0.0f;
        this.b0 = 0.0f;
        this.invalidate();
        this.transitionToEnd(new s(this, 1));
        if(v1 > 0) {
            this.V = ((float)v1) / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int v) {
        if(this.getCurrentState() == -1) {
            this.transitionToState(v);
            return;
        }
        int[] arr_v = this.P0;
        if(arr_v == null) {
            this.P0 = new int[4];
        }
        else if(arr_v.length <= this.Q0) {
            this.P0 = Arrays.copyOf(arr_v, arr_v.length * 2);
        }
        int v1 = this.Q0;
        this.Q0 = v1 + 1;
        this.P0[v1] = v;
    }

    public void setDebugMode(int v) {
        this.h0 = v;
        this.invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.Y0 = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.N = z;
    }

    public void setInterpolatedProgress(float f) {
        if(this.o != null) {
            this.setState(A.c);
            Interpolator interpolator0 = this.o.e();
            if(interpolator0 != null) {
                this.setProgress(interpolator0.getInterpolation(f));
                return;
            }
        }
        this.setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList arrayList0 = this.w0;
        if(arrayList0 != null) {
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((MotionHelper)this.w0.get(v1)).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        ArrayList arrayList0 = this.v0;
        if(arrayList0 != null) {
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((MotionHelper)this.v0.get(v1)).setProgress(f);
            }
        }
    }

    public void setProgress(float f) {
        int v = Float.compare(f, 0.0f);
        if(v < 0 || f > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if(!this.isAttachedToWindow()) {
            if(this.N0 == null) {
                this.N0 = new y(this);
            }
            this.N0.a = f;
            return;
        }
        A a0 = A.d;
        A a1 = A.c;
        if(v <= 0) {
            if(this.b0 == 1.0f && this.E == this.G) {
                this.setState(a1);
            }
            this.E = this.D;
            if(this.b0 == 0.0f) {
                this.setState(a0);
            }
        }
        else if(f >= 1.0f) {
            if(this.b0 == 0.0f && this.E == this.D) {
                this.setState(a1);
            }
            this.E = this.G;
            if(this.b0 == 1.0f) {
                this.setState(a0);
            }
        }
        else {
            this.E = -1;
            this.setState(a1);
        }
        if(this.o == null) {
            return;
        }
        this.e0 = true;
        this.d0 = f;
        this.W = f;
        this.c0 = -1L;
        this.T = -1L;
        this.r = null;
        this.f0 = true;
        this.invalidate();
    }

    public void setProgress(float f, float f1) {
        if(!this.isAttachedToWindow()) {
            if(this.N0 == null) {
                this.N0 = new y(this);
            }
            this.N0.a = f;
            this.N0.b = f1;
            return;
        }
        this.setProgress(f);
        this.setState(A.c);
        this.B = f1;
        float f2 = 0.0f;
        int v = Float.compare(f1, 0.0f);
        if(v != 0) {
            if(v > 0) {
                f2 = 1.0f;
            }
            this.h(f2);
            return;
        }
        if(f != 0 && f != 0x3F800000) {
            if(f > 0.5f) {
                f2 = 1.0f;
            }
            this.h(f2);
        }
    }

    public void setScene(E e0) {
        this.o = e0;
        boolean z = this.isRtl();
        e0.p = z;
        D d0 = e0.c;
        if(d0 != null) {
            F f0 = d0.l;
            if(f0 != null) {
                f0.c(z);
            }
        }
        this.rebuildScene();
    }

    public void setStartState(int v) {
        if(!this.isAttachedToWindow()) {
            if(this.N0 == null) {
                this.N0 = new y(this);
            }
            this.N0.c = v;
            this.N0.d = v;
            return;
        }
        this.E = v;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int v, int v1, int v2) {
        this.setState(A.b);
        this.E = v;
        this.D = -1;
        this.G = -1;
        g g0 = this.mConstraintLayoutSpec;
        if(g0 != null) {
            g0.b(((float)v1), ((float)v2), v);
            return;
        }
        E e0 = this.o;
        if(e0 != null) {
            e0.b(v).b(this);
        }
    }

    public void setState(A a0) {
        A a1 = A.d;
        if(a0 != a1 || this.E != -1) {
            A a2 = this.Z0;
            this.Z0 = a0;
            A a3 = A.c;
            if(a2 == a3 && a0 == a3) {
                this.k();
            }
            switch(a2.ordinal()) {
                case 0: 
                case 1: {
                    if(a0 == a3) {
                        this.k();
                    }
                    if(a0 == a1) {
                        this.fireTransitionCompleted();
                        return;
                    }
                    break;
                }
                case 2: {
                    if(a0 == a1) {
                        this.fireTransitionCompleted();
                        return;
                    }
                    break;
                }
            }
        }
    }

    public void setTransition(int v) {
        float f1;
        if(this.o != null) {
            D d0 = this.getTransition(v);
            this.D = d0.d;
            this.G = d0.c;
            if(!this.isAttachedToWindow()) {
                if(this.N0 == null) {
                    this.N0 = new y(this);
                }
                this.N0.c = this.D;
                this.N0.d = this.G;
                return;
            }
            int v1 = this.E;
            float f = 0.0f;
            if(v1 == this.D) {
                f1 = 0.0f;
            }
            else {
                f1 = v1 == this.G ? 1.0f : NaNf;
            }
            E e0 = this.o;
            e0.c = d0;
            F f2 = d0.l;
            if(f2 != null) {
                f2.c(e0.p);
            }
            n n0 = this.o.b(this.D);
            n n1 = this.o.b(this.G);
            this.a1.e(n0, n1);
            this.rebuildScene();
            if(this.b0 != f1) {
                switch(f1) {
                    case 0: {
                        this.i(true);
                        this.o.b(this.D).b(this);
                        break;
                    }
                    case 0x3F800000: {
                        this.i(false);
                        this.o.b(this.G).b(this);
                    }
                }
            }
            if(!Float.isNaN(f1)) {
                f = f1;
            }
            this.b0 = f;
            if(Float.isNaN(f1)) {
                Log.v("MotionLayout", ".(null:-1) transitionToStart ");
                this.transitionToStart();
                return;
            }
            this.setProgress(f1);
        }
    }

    public void setTransition(int v, int v1) {
        if(!this.isAttachedToWindow()) {
            if(this.N0 == null) {
                this.N0 = new y(this);
            }
            this.N0.c = v;
            this.N0.d = v1;
            return;
        }
        E e0 = this.o;
        if(e0 != null) {
            this.D = v;
            this.G = v1;
            e0.p(v, v1);
            n n0 = this.o.b(v);
            n n1 = this.o.b(v1);
            this.a1.e(n0, n1);
            this.rebuildScene();
            this.b0 = 0.0f;
            this.transitionToStart();
        }
    }

    public void setTransition(D d0) {
        E e0 = this.o;
        e0.c = d0;
        if(d0 != null) {
            F f0 = d0.l;
            if(f0 != null) {
                f0.c(e0.p);
            }
        }
        this.setState(A.b);
        D d1 = this.o.c;
        int v = -1;
        if(this.E == (d1 == null ? -1 : d1.c)) {
            this.b0 = 1.0f;
            this.W = 1.0f;
            this.d0 = 1.0f;
        }
        else {
            this.b0 = 0.0f;
            this.W = 0.0f;
            this.d0 = 0.0f;
        }
        this.c0 = (d0.r & 1) == 0 ? 0xCA401EB5A1CL : -1L;
        int v1 = this.o.h();
        E e1 = this.o;
        D d2 = e1.c;
        if(d2 != null) {
            v = d2.c;
        }
        if(v1 == this.D && v == this.G) {
            return;
        }
        this.D = v1;
        this.G = v;
        e1.p(v1, v);
        n n0 = this.o.b(this.D);
        n n1 = this.o.b(this.G);
        this.a1.e(n0, n1);
        this.a1.e = this.D;
        this.a1.f = this.G;
        this.a1.f();
        this.rebuildScene();
    }

    public void setTransitionDuration(int v) {
        E e0 = this.o;
        if(e0 == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        D d0 = e0.c;
        if(d0 != null) {
            d0.h = Math.max(v, 8);
            return;
        }
        e0.j = v;
    }

    public void setTransitionListener(z z0) {
        this.g0 = z0;
    }

    public void setTransitionState(Bundle bundle0) {
        if(this.N0 == null) {
            this.N0 = new y(this);
        }
        y y0 = this.N0;
        y0.getClass();
        y0.a = bundle0.getFloat("motion.progress");
        y0.b = bundle0.getFloat("motion.velocity");
        y0.c = bundle0.getInt("motion.StartState");
        y0.d = bundle0.getInt("motion.EndState");
        if(this.isAttachedToWindow()) {
            this.N0.a();
        }
    }

    @Override  // android.view.View
    public String toString() {
        Context context0 = this.getContext();
        return ye.a.F(context0, this.D) + "->" + ye.a.F(context0, this.G) + " (pos:" + this.b0 + " Dpos/Dt:" + this.B;
    }

    public void touchAnimateTo(int v, float f, float f1) {
        float f14;
        int v2;
        float f29;
        float f27;
        float f25;
        float f22;
        int v1;
        float f17;
        if(this.o == null || this.b0 == f) {
            return;
        }
        this.j0 = true;
        this.T = 13898868202700L;
        float f2 = ((float)this.o.c()) / 1000.0f;
        this.V = f2;
        this.d0 = f;
        this.f0 = true;
        a a0 = this.k0;
        float f3 = 0.0f;
        if(v == 0 || v == 1 || v == 2) {
        label_55:
            if(v == 1 || v == 7) {
                f17 = 0.0f;
            }
            else if(v != 2 && v != 6) {
                f17 = f;
            }
            else {
                f17 = 1.0f;
            }
            E e0 = this.o;
            D d1 = e0.c;
            if(d1 == null) {
                v1 = 0;
            }
            else {
                F f18 = d1.l;
                v1 = f18 == null ? 0 : f18.D;
            }
            if(v1 == 0) {
                float f19 = this.b0;
                float f20 = e0.g();
                D d2 = this.o.c;
                if(d2 != null) {
                    F f21 = d2.l;
                    if(f21 != null) {
                        f3 = f21.s;
                    }
                }
                f22 = f17;
                this.k0.b(f19, f22, f1, f2, f20, f3);
            }
            else {
                float f23 = this.b0;
                if(d1 == null) {
                    f25 = 0.0f;
                }
                else {
                    F f24 = d1.l;
                    f25 = f24 == null ? 0.0f : f24.z;
                }
                if(d1 == null) {
                    f27 = 0.0f;
                }
                else {
                    F f26 = d1.l;
                    f27 = f26 == null ? 0.0f : f26.A;
                }
                if(d1 == null) {
                    f29 = 0.0f;
                }
                else {
                    F f28 = d1.l;
                    f29 = f28 == null ? 0.0f : f28.y;
                }
                if(d1 != null) {
                    F f30 = d1.l;
                    if(f30 != null) {
                        f3 = f30.B;
                    }
                }
                if(d1 == null) {
                    v2 = 0;
                }
                else {
                    F f31 = d1.l;
                    v2 = f31 == null ? 0 : f31.C;
                }
                this.k0.c(f23, f17, f25, f27, f29, f3, v2);
                f22 = f17;
            }
            this.d0 = f22;
            this.E = this.E;
            this.r = a0;
        }
        else {
            androidx.constraintlayout.motion.widget.t t0 = this.l0;
            if(v == 4) {
                float f15 = this.b0;
                float f16 = this.o.g();
                t0.a = f1;
                t0.b = f15;
                t0.c = f16;
                this.r = t0;
            }
            else {
                switch(v) {
                    case 5: {
                        float f4 = this.b0;
                        float f5 = this.o.g();
                        if(Float.compare(f1, 0.0f) > 0) {
                            float f6 = f1 / f5;
                            if(f1 * f6 - f5 * f6 * f6 / 2.0f + f4 > 1.0f) {
                                goto label_23;
                            }
                            else {
                                goto label_30;
                            }
                        }
                        else {
                            float f7 = -f1 / f5;
                            if(f5 * f7 * f7 / 2.0f + f1 * f7 + f4 < 0.0f) {
                            label_23:
                                float f8 = this.b0;
                                float f9 = this.o.g();
                                t0.a = f1;
                                t0.b = f8;
                                t0.c = f9;
                                this.r = t0;
                            }
                            else {
                            label_30:
                                float f10 = this.b0;
                                float f11 = this.V;
                                float f12 = this.o.g();
                                D d0 = this.o.c;
                                if(d0 == null) {
                                    f14 = 0.0f;
                                }
                                else {
                                    F f13 = d0.l;
                                    f14 = f13 == null ? 0.0f : f13.s;
                                }
                                this.k0.b(f10, f, f1, f11, f12, f14);
                                this.B = 0.0f;
                                this.d0 = f;
                                this.E = this.E;
                                this.r = a0;
                            }
                        }
                        break;
                    }
                    case 6: 
                    case 7: {
                        goto label_55;
                    }
                }
            }
        }
        this.e0 = false;
        this.T = 13898870987300L;
        this.invalidate();
    }

    public void touchSpringTo(float f, float f1) {
        int v;
        float f9;
        float f7;
        float f5;
        if(this.o == null || this.b0 == f) {
            return;
        }
        this.j0 = true;
        this.T = 13898847719100L;
        this.V = ((float)this.o.c()) / 1000.0f;
        this.d0 = f;
        this.f0 = true;
        float f2 = this.b0;
        D d0 = this.o.c;
        float f3 = 0.0f;
        if(d0 == null) {
            f5 = 0.0f;
        }
        else {
            F f4 = d0.l;
            f5 = f4 == null ? 0.0f : f4.z;
        }
        if(d0 == null) {
            f7 = 0.0f;
        }
        else {
            F f6 = d0.l;
            f7 = f6 == null ? 0.0f : f6.A;
        }
        if(d0 == null) {
            f9 = 0.0f;
        }
        else {
            F f8 = d0.l;
            f9 = f8 == null ? 0.0f : f8.y;
        }
        if(d0 != null) {
            F f10 = d0.l;
            if(f10 != null) {
                f3 = f10.B;
            }
        }
        if(d0 == null) {
            v = 0;
        }
        else {
            F f11 = d0.l;
            v = f11 == null ? 0 : f11.C;
        }
        this.k0.c(f2, f, f5, f7, f9, f3, v);
        this.d0 = f;
        this.E = this.E;
        this.r = this.k0;
        this.e0 = false;
        this.T = 0xCA413F05078L;
        this.invalidate();
    }

    public void transitionToEnd() {
        this.h(1.0f);
        this.O0 = null;
    }

    public void transitionToEnd(Runnable runnable0) {
        this.h(1.0f);
        this.O0 = runnable0;
    }

    public void transitionToStart() {
        this.h(0.0f);
    }

    public void transitionToStart(Runnable runnable0) {
        this.h(0.0f);
        this.O0 = runnable0;
    }

    public void transitionToState(int v) {
        if(!this.isAttachedToWindow()) {
            if(this.N0 == null) {
                this.N0 = new y(this);
            }
            this.N0.d = v;
            return;
        }
        this.transitionToState(v, -1, -1);
    }

    public void transitionToState(int v, int v1) {
        if(!this.isAttachedToWindow()) {
            if(this.N0 == null) {
                this.N0 = new y(this);
            }
            this.N0.d = v;
            return;
        }
        this.transitionToState(v, -1, -1, v1);
    }

    public void transitionToState(int v, int v1, int v2) {
        this.transitionToState(v, v1, v2, -1);
    }

    public void transitionToState(int v, int v1, int v2, int v3) {
        E e0 = this.o;
        if(e0 != null) {
            T3.e e1 = e0.b;
            if(e1 != null) {
                int v4 = this.E;
                androidx.constraintlayout.widget.t t0 = (androidx.constraintlayout.widget.t)((SparseArray)e1.b).get(v);
                if(t0 == null) {
                    v4 = v;
                }
                else {
                    ArrayList arrayList0 = t0.b;
                    int v5 = t0.c;
                    if(((float)v1) != -1.0f && ((float)v2) != -1.0f) {
                        androidx.constraintlayout.widget.u u0 = null;
                        for(Object object0: arrayList0) {
                            androidx.constraintlayout.widget.u u1 = (androidx.constraintlayout.widget.u)object0;
                            if(u1.a(((float)v1), ((float)v2))) {
                                if(v4 == u1.e) {
                                    goto label_33;
                                }
                                u0 = u1;
                            }
                        }
                        v4 = u0 == null ? v5 : u0.e;
                    }
                    else if(v5 != v4) {
                        for(Object object1: arrayList0) {
                            if(v4 != ((androidx.constraintlayout.widget.u)object1).e) {
                                continue;
                            }
                            goto label_33;
                        }
                        v4 = v5;
                    }
                }
            label_33:
                if(v4 != -1) {
                    v = v4;
                }
            }
        }
        int v6 = this.E;
        if(v6 != v) {
            if(this.D == v) {
                this.h(0.0f);
                if(v3 > 0) {
                    this.V = ((float)v3) / 1000.0f;
                }
            }
            else if(this.G == v) {
                this.h(1.0f);
                if(v3 > 0) {
                    this.V = ((float)v3) / 1000.0f;
                }
            }
            else {
                this.G = v;
                if(v6 == -1) {
                    goto label_56;
                }
                this.setTransition(v6, v);
                this.h(1.0f);
                this.b0 = 0.0f;
                this.transitionToEnd();
                if(v3 > 0) {
                    this.V = ((float)v3) / 1000.0f;
                    return;
                label_56:
                    this.j0 = false;
                    this.d0 = 1.0f;
                    this.W = 0.0f;
                    this.b0 = 0.0f;
                    this.c0 = 13899963585000L;
                    this.T = 13899963972700L;
                    this.e0 = false;
                    this.r = null;
                    if(v3 == -1) {
                        this.V = ((float)this.o.c()) / 1000.0f;
                    }
                    this.D = -1;
                    this.o.p(-1, this.G);
                    SparseArray sparseArray0 = new SparseArray();
                    if(v3 == 0) {
                        this.V = ((float)this.o.c()) / 1000.0f;
                    }
                    else if(v3 > 0) {
                        this.V = ((float)v3) / 1000.0f;
                    }
                    int v8 = this.getChildCount();
                    HashMap hashMap0 = this.S;
                    hashMap0.clear();
                    for(int v9 = 0; v9 < v8; ++v9) {
                        View view0 = this.getChildAt(v9);
                        hashMap0.put(view0, new q(view0));
                        sparseArray0.put(view0.getId(), ((q)hashMap0.get(view0)));
                    }
                    this.f0 = true;
                    n n0 = this.o.b(v);
                    this.a1.e(null, n0);
                    this.rebuildScene();
                    this.a1.a();
                    int v10 = this.getChildCount();
                    for(int v11 = 0; v11 < v10; ++v11) {
                        View view1 = this.getChildAt(v11);
                        q q0 = (q)hashMap0.get(view1);
                        if(q0 != null) {
                            q0.f.c = 0.0f;
                            q0.f.d = 0.0f;
                            float f = view1.getX();
                            float f1 = view1.getY();
                            float f2 = (float)view1.getWidth();
                            float f3 = (float)view1.getHeight();
                            q0.f.d(f, f1, f2, f3);
                            q0.h.getClass();
                            view1.getX();
                            view1.getY();
                            view1.getWidth();
                            view1.getHeight();
                            q0.h.b(view1);
                        }
                    }
                    int v12 = this.getWidth();
                    int v13 = this.getHeight();
                    if(this.x0 == null) {
                        for(int v16 = 0; v16 < v8; ++v16) {
                            q q3 = (q)hashMap0.get(this.getChildAt(v16));
                            if(q3 != null) {
                                this.o.f(q3);
                                q3.i(v12, v13, 13899965450700L);
                            }
                        }
                    }
                    else {
                        for(int v14 = 0; v14 < v8; ++v14) {
                            q q1 = (q)hashMap0.get(this.getChildAt(v14));
                            if(q1 != null) {
                                this.o.f(q1);
                            }
                        }
                        for(Object object2: this.x0) {
                            ((MotionHelper)object2).q(this, hashMap0);
                        }
                        for(int v15 = 0; v15 < v8; ++v15) {
                            q q2 = (q)hashMap0.get(this.getChildAt(v15));
                            if(q2 != null) {
                                q2.i(v12, v13, 13899965092400L);
                            }
                        }
                    }
                    D d0 = this.o.c;
                    float f4 = d0 == null ? 0.0f : d0.i;
                    if(f4 != 0.0f) {
                        float f5 = 3.402823E+38f;
                        float f6 = -3.402823E+38f;
                        for(int v17 = 0; v17 < v8; ++v17) {
                            B b0 = ((q)hashMap0.get(this.getChildAt(v17))).g;
                            float f7 = b0.f + b0.e;
                            f5 = Math.min(f5, f7);
                            f6 = Math.max(f6, f7);
                        }
                        for(int v7 = 0; v7 < v8; ++v7) {
                            q q4 = (q)hashMap0.get(this.getChildAt(v7));
                            float f8 = q4.g.e;
                            float f9 = q4.g.f;
                            q4.n = 1.0f / (1.0f - f4);
                            q4.m = f4 - (f8 + f9 - f5) * f4 / (f6 - f5);
                        }
                    }
                    this.W = 0.0f;
                    this.b0 = 0.0f;
                    this.f0 = true;
                    this.invalidate();
                }
            }
        }
    }

    public void updateState() {
        n n0 = this.o.b(this.D);
        n n1 = this.o.b(this.G);
        this.a1.e(n0, n1);
        this.rebuildScene();
    }

    public void updateState(int v, n n0) {
        E e0 = this.o;
        if(e0 != null) {
            e0.g.put(v, n0);
        }
        this.updateState();
        if(this.E == v) {
            n0.b(this);
        }
    }

    public void updateStateAnimate(int v, n n0, int v1) {
        if(this.o != null && this.E == v) {
            this.updateState(0x7F0A0DCF, this.getConstraintSet(v));  // id:view_transition
            this.setState(0x7F0A0DCF, -1, -1);  // id:view_transition
            this.updateState(v, n0);
            D d0 = new D(this.o, v);
            d0.h = Math.max(v1, 8);
            this.setTransition(d0);
            this.transitionToEnd();
        }
    }

    public void viewTransition(int v, View[] arr_view) {
        E e0 = this.o;
        if(e0 != null) {
            E9.u u0 = e0.q;
            String s = (String)u0.f;
            ArrayList arrayList0 = new ArrayList();
            I i0 = null;
            for(Object object0: ((ArrayList)u0.c)) {
                I i1 = (I)object0;
                if(i1.a == v) {
                    for(int v1 = 0; v1 < arr_view.length; ++v1) {
                        View view0 = arr_view[v1];
                        if(i1.b(view0)) {
                            arrayList0.add(view0);
                        }
                    }
                    if(arrayList0.isEmpty()) {
                        i0 = i1;
                    }
                    else {
                        View[] arr_view1 = (View[])arrayList0.toArray(new View[0]);
                        MotionLayout motionLayout0 = (MotionLayout)u0.a;
                        int v2 = motionLayout0.getCurrentState();
                        if(i1.e == 2) {
                            i0 = i1;
                            i0.a(u0, ((MotionLayout)u0.a), v2, null, arr_view1);
                        }
                        else {
                            if(v2 == -1) {
                                Log.w(s, "No support for ViewTransition within transition yet. Currently: " + motionLayout0.toString());
                            }
                            else {
                                n n0 = motionLayout0.getConstraintSet(v2);
                                if(n0 != null) {
                                    i0 = i1;
                                    i0.a(u0, ((MotionLayout)u0.a), v2, n0, arr_view1);
                                    goto label_35;
                                }
                            }
                            i0 = i1;
                        }
                    label_35:
                        arrayList0.clear();
                    }
                }
            }
            if(i0 == null) {
                Log.e(s, " Could not find ViewTransition");
            }
            return;
        }
        Log.e("MotionLayout", " no motionScene");
    }
}

