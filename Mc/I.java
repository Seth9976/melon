package Mc;

import Cc.e0;
import Q0.t0;
import U8.h;
import U8.p;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.ui.platform.ComposeView;
import com.melon.ui.K4;
import ie.H;
import m0.b;
import m0.c;
import we.a;
import we.n;

public final class i implements n {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final Object d;
    public final Object e;
    public final Object f;

    public i(ComposeView composeView0, K4 k40, m m0, boolean z, boolean z1) {
        this.a = 0;
        super();
        this.d = composeView0;
        this.e = k40;
        this.f = m0;
        this.b = z;
        this.c = z1;
    }

    public i(String s, boolean z, h h0, boolean z1, a a0, int v) {
        this.a = 1;
        super();
        this.d = s;
        this.b = z;
        this.e = h0;
        this.c = z1;
        this.f = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            p.f(((String)this.d), this.b, ((h)this.e), this.c, ((a)this.f), ((l)object0), 1);
            return H.a;
        }
        ComposeView composeView0 = (ComposeView)this.d;
        K4 k40 = (K4)this.e;
        m m0 = (m)this.f;
        int v = (int)(((Integer)object1));
        if(((androidx.compose.runtime.p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            composeView0.setViewCompositionStrategy(t0.d);
            long v1 = e0.T(((androidx.compose.runtime.p)(((l)object0))), 0x7F0604AA);  // color:white000s_support_high_contrast
            b b0 = c.e(0x5DF3B4DD, ((androidx.compose.runtime.p)(((l)object0))), new j(k40, m0, this.b, this.c));
            Q1.c.g(d.c, null, v1, 0L, 0.0f, b0, ((androidx.compose.runtime.p)(((l)object0))), 0x180006, 58);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object0))).T();
        return H.a;
    }
}

