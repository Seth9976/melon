package r6;

import L1.b;
import P2.a;
import Q1.c;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.media3.session.legacy.V;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d5.n;
import e6.e;
import e6.f;
import java.util.ArrayList;
import pc.t;
import z6.i;
import z6.y;

public abstract class o {
    public final Matrix A;
    public b B;
    public static final a C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int[] H;
    public static final int[] I;
    public static final int[] J;
    public static final int[] K;
    public static final int[] L;
    public static final int[] M;
    public z6.o a;
    public i b;
    public Drawable c;
    public r6.b d;
    public LayerDrawable e;
    public boolean f;
    public boolean g;
    public float h;
    public float i;
    public float j;
    public int k;
    public Animator l;
    public f m;
    public f n;
    public float o;
    public float p;
    public int q;
    public int r;
    public ArrayList s;
    public ArrayList t;
    public ArrayList u;
    public final FloatingActionButton v;
    public final t w;
    public final Rect x;
    public final RectF y;
    public final RectF z;

    static {
        o.C = e6.a.c;
        o.D = 0x7F040454;  // attr:motionDurationLong2
        o.E = 0x7F040464;  // attr:motionEasingEmphasizedInterpolator
        o.F = 0x7F040457;  // attr:motionDurationMedium1
        o.G = 0x7F040462;  // attr:motionEasingEmphasizedAccelerateInterpolator
        o.H = new int[]{0x10100A7, 0x101009E};
        o.I = new int[]{0x1010367, 0x101009C, 0x101009E};
        o.J = new int[]{0x101009C, 0x101009E};
        o.K = new int[]{0x1010367, 0x101009E};
        o.L = new int[]{0x101009E};
        o.M = new int[0];
    }

    public o(FloatingActionButton floatingActionButton0, t t0) {
        this.g = true;
        this.p = 1.0f;
        this.r = 0;
        this.x = new Rect();
        this.y = new RectF();
        this.z = new RectF();
        this.A = new Matrix();
        this.v = floatingActionButton0;
        this.w = t0;
        V v0 = new V(10);
        ValueAnimator valueAnimator0 = o.d(new m(((q)this), 1));
        v0.b(o.H, valueAnimator0);
        ValueAnimator valueAnimator1 = o.d(new m(((q)this), 0));
        v0.b(o.I, valueAnimator1);
        ValueAnimator valueAnimator2 = o.d(new m(((q)this), 0));
        v0.b(o.J, valueAnimator2);
        ValueAnimator valueAnimator3 = o.d(new m(((q)this), 0));
        v0.b(o.K, valueAnimator3);
        ValueAnimator valueAnimator4 = o.d(new m(((q)this), 2));
        v0.b(o.L, valueAnimator4);
        ValueAnimator valueAnimator5 = o.d(new l(((q)this)));  // 初始化器: Lr6/n;-><init>(Lr6/q;)V
        v0.b(o.M, valueAnimator5);
        this.o = floatingActionButton0.getRotation();
    }

    public final void a(float f, Matrix matrix0) {
        matrix0.reset();
        Drawable drawable0 = this.v.getDrawable();
        if(drawable0 != null && this.q != 0) {
            float f1 = (float)drawable0.getIntrinsicWidth();
            float f2 = (float)drawable0.getIntrinsicHeight();
            this.y.set(0.0f, 0.0f, f1, f2);
            float f3 = (float)this.q;
            this.z.set(0.0f, 0.0f, f3, f3);
            matrix0.setRectToRect(this.y, this.z, Matrix.ScaleToFit.CENTER);
            float f4 = ((float)this.q) / 2.0f;
            matrix0.postScale(f, f, f4, f4);
        }
    }

    public final AnimatorSet b(f f0, float f1, float f2, float f3) {
        ArrayList arrayList0 = new ArrayList();
        FloatingActionButton floatingActionButton0 = this.v;
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(floatingActionButton0, View.ALPHA, new float[]{f1});
        f0.f("opacity").a(objectAnimator0);
        arrayList0.add(objectAnimator0);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(floatingActionButton0, View.SCALE_X, new float[]{f2});
        f0.f("scale").a(objectAnimator1);
        int v = Build.VERSION.SDK_INT;
        if(v == 26) {
            N4.q q0 = new N4.q(1);
            q0.b = new FloatEvaluator();
            objectAnimator1.setEvaluator(q0);
        }
        arrayList0.add(objectAnimator1);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(floatingActionButton0, View.SCALE_Y, new float[]{f2});
        f0.f("scale").a(objectAnimator2);
        if(v == 26) {
            N4.q q1 = new N4.q(1);
            q1.b = new FloatEvaluator();
            objectAnimator2.setEvaluator(q1);
        }
        arrayList0.add(objectAnimator2);
        this.a(f3, this.A);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofObject(floatingActionButton0, new e(), new j(this), new Matrix[]{new Matrix(this.A)});
        f0.f("iconScale").a(objectAnimator3);
        arrayList0.add(objectAnimator3);
        AnimatorSet animatorSet0 = new AnimatorSet();
        n.y(animatorSet0, arrayList0);
        return animatorSet0;
    }

    public final AnimatorSet c(float f, float f1, float f2, int v, int v1) {
        AnimatorSet animatorSet0 = new AnimatorSet();
        ArrayList arrayList0 = new ArrayList();
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        valueAnimator0.addUpdateListener(new k(this, this.v.getAlpha(), f, this.v.getScaleX(), f1, this.v.getScaleY(), this.p, f2, new Matrix(this.A)));
        arrayList0.add(valueAnimator0);
        n.y(animatorSet0, arrayList0);
        animatorSet0.setDuration(((long)e1.n.B(this.v.getContext(), v, this.v.getContext().getResources().getInteger(0x7F0B0033))));  // integer:material_motion_duration_long_1
        animatorSet0.setInterpolator(e1.n.C(this.v.getContext(), v1, e6.a.b));
        return animatorSet0;
    }

    public static ValueAnimator d(r6.n n0) {
        ValueAnimator valueAnimator0 = new ValueAnimator();
        valueAnimator0.setInterpolator(o.C);
        valueAnimator0.setDuration(100L);
        valueAnimator0.addListener(n0);
        valueAnimator0.addUpdateListener(n0);
        valueAnimator0.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator0;
    }

    public abstract float e();

    public void f(Rect rect0) {
        int v = this.f ? Math.max((this.k - this.v.getSizeDimension()) / 2, 0) : 0;
        float f = this.g ? this.e() + this.j : 0.0f;
        int v1 = Math.max(v, ((int)Math.ceil(f)));
        int v2 = Math.max(v, ((int)Math.ceil(f * 1.5f)));
        rect0.set(v1, v2, v1, v2);
    }

    public abstract void g(ColorStateList arg1, PorterDuff.Mode arg2, ColorStateList arg3, int arg4);

    public abstract void h();

    public abstract void i();

    public abstract void j(int[] arg1);

    public abstract void k(float arg1, float arg2, float arg3);

    public final void l() {
        ArrayList arrayList0 = this.u;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                FloatingActionButton floatingActionButton0 = ((h)object0).b;
                ((h)object0).a.getClass();
                float f = floatingActionButton0.getVisibility() != 0 || ((h)object0).a.a.z0 != 1 ? 0.0f : floatingActionButton0.getScaleY();
                ((h)object0).a.a.u0.n(f);
            }
        }
    }

    public final void m() {
        ArrayList arrayList0 = this.u;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                FloatingActionButton floatingActionButton0 = ((h)object0).b;
                ((h)object0).a.getClass();
                BottomAppBar bottomAppBar0 = ((h)object0).a.a;
                i i0 = bottomAppBar0.u0;
                if(bottomAppBar0.z0 == 1) {
                    float f = floatingActionButton0.getTranslationX();
                    if(bottomAppBar0.getTopEdgeTreatment().f != f) {
                        bottomAppBar0.getTopEdgeTreatment().f = f;
                        i0.invalidateSelf();
                    }
                    float f1 = 0.0f;
                    float f2 = Math.max(0.0f, -floatingActionButton0.getTranslationY());
                    if(bottomAppBar0.getTopEdgeTreatment().e != f2) {
                        bottomAppBar0.getTopEdgeTreatment().u(f2);
                        i0.invalidateSelf();
                    }
                    if(floatingActionButton0.getVisibility() == 0) {
                        f1 = floatingActionButton0.getScaleY();
                    }
                    i0.n(f1);
                }
            }
        }
    }

    public void n(ColorStateList colorStateList0) {
        Drawable drawable0 = this.c;
        if(drawable0 != null) {
            drawable0.setTintList(x6.a.c(colorStateList0));
        }
    }

    public final void o(z6.o o0) {
        this.a = o0;
        i i0 = this.b;
        if(i0 != null) {
            i0.setShapeAppearanceModel(o0);
        }
        Drawable drawable0 = this.c;
        if(drawable0 instanceof y) {
            ((y)drawable0).setShapeAppearanceModel(o0);
        }
        r6.b b0 = this.d;
        if(b0 != null) {
            b0.o = o0;
            b0.invalidateSelf();
        }
    }

    public abstract boolean p();

    public abstract void q();

    public final void r() {
        Rect rect0 = this.x;
        this.f(rect0);
        c.o(this.e, "Didn\'t initialize content background");
        boolean z = this.p();
        t t0 = this.w;
        if(z) {
            InsetDrawable insetDrawable0 = new InsetDrawable(this.e, rect0.left, rect0.top, rect0.right, rect0.bottom);
            ((FloatingActionButton)t0.b).super.setBackgroundDrawable(insetDrawable0);
        }
        else {
            LayerDrawable layerDrawable0 = this.e;
            if(layerDrawable0 == null) {
                t0.getClass();
            }
            else {
                ((FloatingActionButton)t0.b).super.setBackgroundDrawable(layerDrawable0);
            }
        }
        int v = rect0.left;
        int v1 = rect0.top;
        int v2 = rect0.right;
        int v3 = rect0.bottom;
        FloatingActionButton floatingActionButton0 = (FloatingActionButton)t0.b;
        floatingActionButton0.l.set(v, v1, v2, v3);
        floatingActionButton0.setPadding(v + floatingActionButton0.i, v1 + floatingActionButton0.i, v2 + floatingActionButton0.i, v3 + floatingActionButton0.i);
    }
}

