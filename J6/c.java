package j6;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.google.android.material.card.MaterialCardView;
import d3.g;
import d6.a;
import e1.n;
import z6.e;
import z6.i;
import z6.l;
import z6.m;
import z6.o;

public final class c {
    public final MaterialCardView a;
    public final Rect b;
    public final i c;
    public final i d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Drawable i;
    public Drawable j;
    public ColorStateList k;
    public ColorStateList l;
    public o m;
    public ColorStateList n;
    public RippleDrawable o;
    public LayerDrawable p;
    public i q;
    public boolean r;
    public boolean s;
    public ValueAnimator t;
    public final TimeInterpolator u;
    public final int v;
    public final int w;
    public float x;
    public static final double y;
    public static final ColorDrawable z;

    static {
        c.y = 0.707107;
        c.z = Build.VERSION.SDK_INT > 28 ? null : new ColorDrawable();
    }

    public c(MaterialCardView materialCardView0, AttributeSet attributeSet0, int v) {
        this.b = new Rect();
        this.r = false;
        this.x = 0.0f;
        this.a = materialCardView0;
        i i0 = new i(materialCardView0.getContext(), attributeSet0, v, 0x7F140495);  // style:Widget.MaterialComponents.CardView
        this.c = i0;
        i0.k(materialCardView0.getContext());
        i0.p();
        m m0 = i0.a.a.g();
        TypedArray typedArray0 = materialCardView0.getContext().obtainStyledAttributes(attributeSet0, a.h, v, 0x7F14012B);  // style:CardView
        if(typedArray0.hasValue(3)) {
            m0.c(typedArray0.getDimension(3, 0.0f));
        }
        this.d = new i();
        this.h(m0.a());
        this.u = n.C(materialCardView0.getContext(), 0x7F040466, e6.a.a);  // attr:motionEasingLinearInterpolator
        this.v = n.B(materialCardView0.getContext(), 0x7F04045C, 300);  // attr:motionDurationShort2
        this.w = n.B(materialCardView0.getContext(), 0x7F04045B, 300);  // attr:motionDurationShort1
        typedArray0.recycle();
    }

    public final float a() {
        return Math.max(Math.max(c.b(this.m.a, this.c.i()), c.b(this.m.b, this.c.a.a.f.a(this.c.g()))), Math.max(c.b(this.m.c, this.c.a.a.g.a(this.c.g())), c.b(this.m.d, this.c.a.a.h.a(this.c.g()))));
    }

    public static float b(g g0, float f) {
        if(g0 instanceof l) {
            return (float)((1.0 - c.y) * ((double)f));
        }
        return g0 instanceof e ? f / 2.0f : 0.0f;
    }

    public final LayerDrawable c() {
        if(this.o == null) {
            this.q = new i(this.m);
            this.o = new RippleDrawable(this.k, null, this.q);
        }
        if(this.p == null) {
            LayerDrawable layerDrawable0 = new LayerDrawable(new Drawable[]{this.o, this.d, this.j});
            this.p = layerDrawable0;
            layerDrawable0.setId(2, 0x7F0A0873);  // id:mtrl_card_checked_layer_id
        }
        return this.p;
    }

    public final b d(Drawable drawable0) {
        MaterialCardView materialCardView0 = this.a;
        if(materialCardView0.getUseCompatPadding()) {
            float f = 0.0f;
            int v = (int)Math.ceil(materialCardView0.getMaxCardElevation() * 1.5f + (this.i() ? this.a() : 0.0f));
            float f1 = materialCardView0.getMaxCardElevation();
            if(this.i()) {
                f = this.a();
            }
            int v1 = (int)Math.ceil(f1 + f);
            return new b(drawable0, v1, v, v1, v);  // 初始化器: Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/Drawable;IIII)V
        }
        return new b(drawable0, 0, 0, 0, 0);  // 初始化器: Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/Drawable;IIII)V
    }

    public final void e(int v, int v1) {
        int v9;
        int v8;
        int v3;
        int v2;
        if(this.p != null) {
            MaterialCardView materialCardView0 = this.a;
            if(materialCardView0.getUseCompatPadding()) {
                float f = 0.0f;
                v2 = (int)Math.ceil((materialCardView0.getMaxCardElevation() * 1.5f + (this.i() ? this.a() : 0.0f)) * 2.0f);
                float f1 = materialCardView0.getMaxCardElevation();
                if(this.i()) {
                    f = this.a();
                }
                v3 = (int)Math.ceil((f1 + f) * 2.0f);
            }
            else {
                v2 = 0;
                v3 = 0;
            }
            int v4 = (this.g & 0x800005) == 0x800005 ? v - this.e - this.f - v3 : this.e;
            int v5 = (this.g & 80) == 80 ? this.e : v1 - this.e - this.f - v2;
            int v6 = (this.g & 0x800005) == 0x800005 ? this.e : v - this.e - this.f - v3;
            int v7 = (this.g & 80) == 80 ? v1 - this.e - this.f - v2 : this.e;
            if(materialCardView0.getLayoutDirection() == 1) {
                v8 = v6;
                v9 = v4;
            }
            else {
                v9 = v6;
                v8 = v4;
            }
            this.p.setLayerInset(2, v8, v7, v9, v5);
        }
    }

    public final void f(boolean z, boolean z1) {
        Drawable drawable0 = this.j;
        if(drawable0 != null) {
            int v = 0;
            float f = 0.0f;
            if(z1) {
                if(z) {
                    f = 1.0f;
                }
                float f1 = z ? 1.0f - this.x : this.x;
                ValueAnimator valueAnimator0 = this.t;
                if(valueAnimator0 != null) {
                    valueAnimator0.cancel();
                    this.t = null;
                }
                ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[]{this.x, f});
                this.t = valueAnimator1;
                valueAnimator1.addUpdateListener(new com.google.android.exoplayer2.ui.a(this, 7));
                this.t.setInterpolator(this.u);
                this.t.setDuration(((long)(((float)(z ? this.v : this.w)) * f1)));
                this.t.start();
                return;
            }
            if(z) {
                v = 0xFF;
            }
            drawable0.setAlpha(v);
            if(z) {
                f = 1.0f;
            }
            this.x = f;
        }
    }

    public final void g(Drawable drawable0) {
        if(drawable0 == null) {
            this.j = c.z;
        }
        else {
            Drawable drawable1 = drawable0.mutate();
            this.j = drawable1;
            drawable1.setTintList(this.l);
            this.f(this.a.j, false);
        }
        LayerDrawable layerDrawable0 = this.p;
        if(layerDrawable0 != null) {
            layerDrawable0.setDrawableByLayerId(0x7F0A0873, this.j);  // id:mtrl_card_checked_layer_id
        }
    }

    public final void h(o o0) {
        this.m = o0;
        this.c.setShapeAppearanceModel(o0);
        this.c.M = !this.c.a.a.f(this.c.g());
        i i0 = this.d;
        if(i0 != null) {
            i0.setShapeAppearanceModel(o0);
        }
        i i1 = this.q;
        if(i1 != null) {
            i1.setShapeAppearanceModel(o0);
        }
    }

    // 去混淆评级： 低(30)
    public final boolean i() {
        return this.a.getPreventCornerOverlap() && this.c.a.a.f(this.c.g()) && this.a.getUseCompatPadding();
    }

    public final boolean j() {
        View view0 = this.a;
        if(view0.isClickable()) {
            return true;
        }
        while(view0.isDuplicateParentStateEnabled() && view0.getParent() instanceof View) {
            view0 = (View)view0.getParent();
        }
        return view0.isClickable();
    }

    public final void k() {
        Drawable drawable0 = this.i;
        LayerDrawable layerDrawable0 = this.j() ? this.c() : this.d;
        this.i = layerDrawable0;
        if(drawable0 != layerDrawable0) {
            MaterialCardView materialCardView0 = this.a;
            if(materialCardView0.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable)materialCardView0.getForeground()).setDrawable(layerDrawable0);
                return;
            }
            materialCardView0.setForeground(this.d(layerDrawable0));
        }
    }

    public final void l() {
        MaterialCardView materialCardView0 = this.a;
        float f = 0.0f;
        float f1 = (!materialCardView0.getPreventCornerOverlap() || this.c.a.a.f(this.c.g())) && !this.i() ? 0.0f : this.a();
        if(materialCardView0.getPreventCornerOverlap() && materialCardView0.getUseCompatPadding()) {
            double f2 = (double)materialCardView0.getCardViewRadius();
            f = (float)((1.0 - c.y) * f2);
        }
        int v = (int)(f1 - f);
        materialCardView0.c.set(this.b.left + v, this.b.top + v, this.b.right + v, this.b.bottom + v);
        ea.c c0 = materialCardView0.e;
        CardView cardView0 = (CardView)c0.c;
        if(!cardView0.getUseCompatPadding()) {
            c0.j(0, 0, 0, 0);
            return;
        }
        float f3 = ((D.a)(((Drawable)c0.b))).e;
        float f4 = ((D.a)(((Drawable)c0.b))).a;
        int v1 = (int)Math.ceil(D.b.a(f3, f4, cardView0.getPreventCornerOverlap()));
        int v2 = (int)Math.ceil(D.b.b(f3, f4, cardView0.getPreventCornerOverlap()));
        c0.j(v1, v2, v1, v2);
    }

    public final void m() {
        MaterialCardView materialCardView0 = this.a;
        if(!this.r) {
            materialCardView0.setBackgroundInternal(this.d(this.c));
        }
        materialCardView0.setForeground(this.d(this.i));
    }
}

