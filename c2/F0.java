package c2;

import S1.d;
import X2.l;
import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import androidx.datastore.preferences.protobuf.m;
import java.util.Objects;
import x9.c;

public final class f0 implements View.OnApplyWindowInsetsListener {
    public final m a;
    public B0 b;

    public f0(View view0, m m0) {
        B0 b01;
        o0 o00;
        this.a = m0;
        B0 b00 = N.a(view0);
        if(b00 == null) {
            b01 = null;
        }
        else {
            int v = Build.VERSION.SDK_INT;
            if(v >= 34) {
                o00 = new q0(b00);
            }
            else if(v >= 30) {
                o00 = new p0(b00);
            }
            else if(v >= 29) {
                o00 = new o0(b00);
            }
            else {
                o00 = new m0(b00);
            }
            b01 = o00.b();
        }
        this.b = b01;
    }

    @Override  // android.view.View$OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
        PathInterpolator pathInterpolator0;
        int v10;
        int[] arr_v1;
        if(!view0.isLaidOut()) {
            this.b = B0.h(view0, windowInsets0);
            return g0.j(view0, windowInsets0);
        }
        B0 b00 = B0.h(view0, windowInsets0);
        y0 y00 = b00.a;
        if(this.b == null) {
            this.b = N.a(view0);
        }
        if(this.b == null) {
            this.b = b00;
            return g0.j(view0, windowInsets0);
        }
        m m0 = g0.k(view0);
        if(m0 != null && Objects.equals(((B0)m0.b), b00)) {
            return g0.j(view0, windowInsets0);
        }
        int[] arr_v = new int[1];
        int v = 0;
        B0 b01 = this.b;
        int v1 = 1;
        while(v1 <= 0x200) {
            d d0 = y00.g(v1);
            d d1 = b01.a.g(v1);
            int v2 = d0.a;
            int v3 = d0.d;
            int v4 = d0.c;
            int v5 = d0.b;
            int v6 = d1.a;
            int v7 = d1.d;
            int v8 = d1.c;
            int v9 = d1.b;
            if(v2 > v6 || v5 > v9 || v4 > v8 || v3 > v7) {
                arr_v1 = arr_v;
                v10 = 1;
            }
            else {
                arr_v1 = arr_v;
                v10 = 0;
            }
            if(v10 != (v2 < v6 || v5 < v9 || v4 < v8 || v3 < v7 ? 1 : 0)) {
                if(v10 == 0) {
                    v |= v1;
                }
                else {
                    arr_v1[0] |= v1;
                }
            }
            v1 <<= 1;
            arr_v = arr_v1;
        }
        int v11 = arr_v[0];
        int v12 = v11 | v;
        if(v12 == 0) {
            this.b = b00;
            return g0.j(view0, windowInsets0);
        }
        B0 b02 = this.b;
        if((v11 & 8) != 0) {
            pathInterpolator0 = g0.e;
        }
        else if((v & 8) != 0) {
            pathInterpolator0 = g0.f;
        }
        else if((v11 & 0x207) != 0) {
            pathInterpolator0 = g0.g;
        }
        else if((v & 0x207) == 0) {
            pathInterpolator0 = null;
        }
        else {
            pathInterpolator0 = g0.h;
        }
        l0 l00 = new l0(v12, pathInterpolator0, ((v12 & 8) == 0 ? 0xFAL : 0xA0L));
        l00.a.e(0.0f);
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(l00.a.b());
        d d2 = y00.g(v12);
        d d3 = b02.a.g(v12);
        c c0 = new c(6, d.c(Math.min(d2.a, d3.a), Math.min(d2.b, d3.b), Math.min(d2.c, d3.c), Math.min(d2.d, d3.d)), d.c(Math.max(d2.a, d3.a), Math.max(d2.b, d3.b), Math.max(d2.c, d3.c), Math.max(d2.d, d3.d)));
        g0.g(view0, l00, b00, false);
        valueAnimator0.addUpdateListener(new e0(l00, b00, b02, v12, view0));
        valueAnimator0.addListener(new G6.c(3, l00, view0));
        x.a(view0, new l(5, view0, l00, c0, valueAnimator0, false));
        this.b = b00;
        return g0.j(view0, windowInsets0);
    }
}

