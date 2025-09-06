package androidx.compose.foundation;

import A0.d;
import N0.Z;
import P0.K;
import Q0.k0;
import X0.h;
import X0.x;
import android.content.Context;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ie.H;
import kotlin.jvm.internal.r;
import r1.c;
import we.k;

public final class u extends r implements k {
    public final int f;
    public static final u g;
    public static final u h;
    public static final u i;
    public static final u j;
    public static final u k;
    public static final u l;

    static {
        u.g = new u(1, 0);
        u.h = new u(1, 1);
        u.i = new u(1, 2);
        u.j = new u(1, 3);
        u.k = new u(1, 4);
        u.l = new u(1, 5);
    }

    public u(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        switch(this.f) {
            case 0: {
                ((K)(((d)object0))).a();
                return h0;
            }
            case 1: {
                Z z0 = (Z)object0;
                return h0;
            }
            case 2: {
                ((Number)object0).longValue();
                return h0;
            }
            case 3: {
                ((i0)object0).getClass();
                Object object1 = w.u(((i0)object0), AndroidCompositionLocals_androidKt.b);
                Object object2 = w.u(((i0)object0), k0.h);
                C0 c00 = (C0)w.u(((i0)object0), D0.a);
                return c00 == null ? null : new n(((Context)object1), ((c)object2), c00.a, c00.b);
            }
            case 4: {
                X0.u.j(((x)object0), h.d);
                return h0;
            }
            default: {
                return new Q0(((Number)object0).intValue());
            }
        }
    }
}

