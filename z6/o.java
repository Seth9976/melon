package z6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import d3.g;
import d5.n;

public final class o {
    public g a;
    public g b;
    public g c;
    public g d;
    public d e;
    public d f;
    public d g;
    public d h;
    public f i;
    public f j;
    public f k;
    public f l;
    public static final k m;

    static {
        o.m = new k(0.5f);
    }

    public o() {
        this.a = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.d = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new a(0.0f);
        this.f = new a(0.0f);
        this.g = new a(0.0f);
        this.h = new a(0.0f);
        this.i = new f(0);
        this.j = new f(0);
        this.k = new f(0);
        this.l = new f(0);
    }

    public static m a(Context context0, int v, int v1) {
        return o.b(context0, v, v1, new a(0.0f));
    }

    public static m b(Context context0, int v, int v1, d d0) {
        ContextThemeWrapper contextThemeWrapper0 = new ContextThemeWrapper(context0, v);
        if(v1 != 0) {
            contextThemeWrapper0 = new ContextThemeWrapper(contextThemeWrapper0, v1);
        }
        TypedArray typedArray0 = contextThemeWrapper0.obtainStyledAttributes(d6.a.X);
        try {
            int v3 = typedArray0.getInt(0, 0);
            int v4 = typedArray0.getInt(3, v3);
            int v5 = typedArray0.getInt(4, v3);
            int v6 = typedArray0.getInt(2, v3);
            int v7 = typedArray0.getInt(1, v3);
            d d1 = o.e(typedArray0, 5, d0);
            d d2 = o.e(typedArray0, 8, d1);
            d d3 = o.e(typedArray0, 9, d1);
            d d4 = o.e(typedArray0, 7, d1);
            d d5 = o.e(typedArray0, 6, d1);
            m m0 = new m();
            g g0 = n.s(v4);
            m0.a = g0;
            m.b(g0);
            m0.e = d2;
            g g1 = n.s(v5);
            m0.b = g1;
            m.b(g1);
            m0.f = d3;
            g g2 = n.s(v6);
            m0.c = g2;
            m.b(g2);
            m0.g = d4;
            g g3 = n.s(v7);
            m0.d = g3;
            m.b(g3);
            m0.h = d5;
            return m0;
        }
        finally {
            typedArray0.recycle();
        }
    }

    public static m c(Context context0, AttributeSet attributeSet0, int v, int v1, d d0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.I, v, v1);
        int v2 = typedArray0.getResourceId(0, 0);
        int v3 = typedArray0.getResourceId(1, 0);
        typedArray0.recycle();
        return o.b(context0, v2, v3, d0);
    }

    public static m d(Context context0, AttributeSet attributeSet0, int v, int v1) {
        return o.c(context0, attributeSet0, v, v1, new a(0.0f));
    }

    public static d e(TypedArray typedArray0, int v, d d0) {
        TypedValue typedValue0 = typedArray0.peekValue(v);
        if(typedValue0 != null) {
            int v1 = typedValue0.type;
            if(v1 == 5) {
                return new a(((float)TypedValue.complexToDimensionPixelSize(typedValue0.data, typedArray0.getResources().getDisplayMetrics())));
            }
            if(v1 == 6) {
                return new k(typedValue0.getFraction(1.0f, 1.0f));
            }
        }
        return d0;
    }

    // 去混淆评级： 低(36)
    public final boolean f(RectF rectF0) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float f = this.e.a(rectF0);
        return z && (this.f.a(rectF0) == f && this.h.a(rectF0) == f && this.g.a(rectF0) == f) && (this.b instanceof l && this.a instanceof l && this.c instanceof l && this.d instanceof l);
    }

    public final m g() {
        m m0 = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
        m0.a = this.a;
        m0.b = this.b;
        m0.c = this.c;
        m0.d = this.d;
        m0.e = this.e;
        m0.f = this.f;
        m0.g = this.g;
        m0.h = this.h;
        m0.i = this.i;
        m0.j = this.j;
        m0.k = this.k;
        m0.l = this.l;
        return m0;
    }

    public final o h(z6.n n0) {
        m m0 = this.g();
        m0.e = n0.b(this.e);
        m0.f = n0.b(this.f);
        m0.h = n0.b(this.h);
        m0.g = n0.b(this.g);
        return m0.a();
    }
}

