package a0;

import E9.h;
import K.l;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.f0;
import androidx.compose.foundation.g0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import y0.M;
import y0.s;

public final class d implements f0 {
    public final b0 a;

    public d(b0 b00) {
        this.a = b00;
    }

    @Override  // androidx.compose.foundation.f0
    public final g0 a(l l0, p p0) {
        long v;
        p0.a0(0x3AEF0613);
        c c0 = (c)p0.k(a0.l.a);
        b0 b00 = this.a;
        if(Long.compare(((s)b00.getValue()).a, 16L) == 0) {
            p0.a0(-303499670);
            c0.getClass();
            p0.a0(2042140174);
            v = s.b;
            M.q(v);
            p0.p(false);
            p0.p(false);
        }
        else {
            p0.a0(-303557454);
            p0.p(false);
            v = ((s)b00.getValue()).a;
        }
        b0 b01 = w.w(new s(v), p0);
        c0.getClass();
        p0.a0(0x9EDAF9E9);
        f f0 = ((double)M.q(s.b)) > 0.5 ? a0.l.b : a0.l.c;
        p0.p(false);
        b0 b02 = w.w(f0, p0);
        p0.a0(0x13BE9E37);
        ViewGroup viewGroup0 = h.n(((View)p0.k(AndroidCompositionLocals_androidKt.f)));
        boolean z = p0.g(l0);
        boolean z1 = p0.g(this);
        boolean z2 = p0.g(viewGroup0);
        a a0 = p0.N();
        V v1 = k.a;
        if((z | z1 | z2) != 0 || a0 == v1) {
            a0 = new a(b01, b02, viewGroup0);
            p0.l0(a0);
        }
        p0.p(false);
        boolean z3 = p0.g(l0);
        boolean z4 = p0.i(a0);
        e e0 = p0.N();
        if(z3 || z4 || e0 == v1) {
            e0 = new e(l0, a0, null);
            p0.l0(e0);
        }
        J.f(a0, l0, e0, p0);
        p0.p(false);
        return a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof d) {
                ((d)object0).getClass();
                return this.a.equals(((d)object0).a);
            }
            return false;
        }
        return true;
    }

    // 去混淆评级： 低(30)
    @Override
    public final int hashCode() {
        return this.a.hashCode() + 0x78520D0F;
    }
}

