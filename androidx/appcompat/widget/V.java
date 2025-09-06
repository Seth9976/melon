package androidx.appcompat.widget;

import Y1.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import c2.M;
import c2.W;
import d5.m;
import g.a;

public final class v {
    public final View a;
    public final x b;
    public int c;
    public b d;
    public b e;
    public b f;

    public v(View view0) {
        this.c = -1;
        this.a = view0;
        this.b = x.a();
    }

    public final void a() {
        View view0 = this.a;
        Drawable drawable0 = view0.getBackground();
        if(drawable0 != null) {
            if(this.d != null) {
                if(this.f == null) {
                    this.f = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                b b0 = this.f;
                b0.c = null;
                b0.b = false;
                b0.d = null;
                b0.a = false;
                ColorStateList colorStateList0 = M.c(view0);
                if(colorStateList0 != null) {
                    b0.b = true;
                    b0.c = colorStateList0;
                }
                PorterDuff.Mode porterDuff$Mode0 = M.d(view0);
                if(porterDuff$Mode0 != null) {
                    b0.a = true;
                    b0.d = porterDuff$Mode0;
                }
                if(b0.b || b0.a) {
                    x.e(drawable0, b0, view0.getDrawableState());
                    return;
                }
            }
            b b1 = this.e;
            if(b1 != null) {
                x.e(drawable0, b1, view0.getDrawableState());
                return;
            }
            b b2 = this.d;
            if(b2 != null) {
                x.e(drawable0, b2, view0.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        return this.e == null ? null : ((ColorStateList)this.e.c);
    }

    public final PorterDuff.Mode c() {
        return this.e == null ? null : ((PorterDuff.Mode)this.e.d);
    }

    public final void d(AttributeSet attributeSet0, int v) {
        ColorStateList colorStateList0;
        View view0 = this.a;
        m m0 = m.r(view0.getContext(), attributeSet0, a.C, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        Context context0 = this.a.getContext();
        W.n(this.a, context0, a.C, attributeSet0, ((TypedArray)m0.c), v);
        try {
            if(typedArray0.hasValue(0)) {
                this.c = typedArray0.getResourceId(0, -1);
                x x0 = this.b;
                Context context1 = view0.getContext();
                synchronized(x0) {
                    colorStateList0 = x0.a.f(context1, this.c);
                }
                if(colorStateList0 != null) {
                    this.g(colorStateList0);
                }
            }
            if(typedArray0.hasValue(1)) {
                M.j(view0, m0.j(1));
            }
            if(typedArray0.hasValue(2)) {
                M.k(view0, h0.c(typedArray0.getInt(2, -1), null));
            }
        }
        finally {
            m0.t();
        }
    }

    public final void e() {
        this.c = -1;
        this.g(null);
        this.a();
    }

    public final void f(int v) {
        ColorStateList colorStateList0;
        this.c = v;
        x x0 = this.b;
        if(x0 == null) {
            colorStateList0 = null;
        }
        else {
            Context context0 = this.a.getContext();
            synchronized(x0) {
                colorStateList0 = x0.a.f(context0, v);
            }
        }
        this.g(colorStateList0);
        this.a();
    }

    public final void g(ColorStateList colorStateList0) {
        if(colorStateList0 == null) {
            this.d = null;
        }
        else {
            if(this.d == null) {
                this.d = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            this.d.c = colorStateList0;
            this.d.b = true;
        }
        this.a();
    }

    public final void h(ColorStateList colorStateList0) {
        if(this.e == null) {
            this.e = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        this.e.c = colorStateList0;
        this.e.b = true;
        this.a();
    }

    public final void i(PorterDuff.Mode porterDuff$Mode0) {
        if(this.e == null) {
            this.e = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        this.e.d = porterDuff$Mode0;
        this.e.a = true;
        this.a();
    }
}

