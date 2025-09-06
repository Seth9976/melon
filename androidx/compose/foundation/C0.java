package androidx.compose.foundation;

import J0.n;
import J0.o;
import K.h;
import K.i;
import K.l;
import K.m;
import P0.w0;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ne.a;
import oe.c;
import r0.p;

public final class c0 extends p implements w0 {
    public l a;
    public h b;

    @Override  // P0.w0
    public final void L(n n0, o o0, long v) {
        if(o0 == o.b) {
            int v1 = n0.d;
            if(v1 == 4) {
                BuildersKt__Builders_commonKt.launch$default(this.getCoroutineScope(), null, null, new a0(this, null), 3, null);
                return;
            }
            if(v1 == 5) {
                BuildersKt__Builders_commonKt.launch$default(this.getCoroutineScope(), null, null, new b0(this, null), 3, null);
            }
        }
    }

    @Override  // P0.w0
    public final void N() {
        this.o0();
    }

    public static final Object m0(c0 c00, c c0) {
        Y y0;
        if(c0 instanceof Y) {
            y0 = (Y)c0;
            int v = y0.E;
            if((v & 0x80000000) == 0) {
                y0 = new Y(c00, c0);
            }
            else {
                y0.E = v ^ 0x80000000;
            }
        }
        else {
            y0 = new Y(c00, c0);
        }
        Object object0 = y0.B;
        a a0 = a.a;
        switch(y0.E) {
            case 0: {
                d5.n.D(object0);
                if(c00.b == null) {
                    h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
                    y0.r = c00;
                    y0.w = h0;
                    y0.E = 1;
                    if(((m)c00.a).a(h0, y0) == a0) {
                        return a0;
                    }
                    c00.b = h0;
                    return H.a;
                }
                break;
            }
            case 1: {
                h h1 = y0.w;
                c0 c01 = y0.r;
                d5.n.D(object0);
                c01.b = h1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public static final Object n0(c0 c00, c c0) {
        Z z0;
        if(c0 instanceof Z) {
            z0 = (Z)c0;
            int v = z0.D;
            if((v & 0x80000000) == 0) {
                z0 = new Z(c00, c0);
            }
            else {
                z0.D = v ^ 0x80000000;
            }
        }
        else {
            z0 = new Z(c00, c0);
        }
        Object object0 = z0.w;
        a a0 = a.a;
        switch(z0.D) {
            case 0: {
                d5.n.D(object0);
                h h0 = c00.b;
                if(h0 != null) {
                    i i0 = new i(h0);
                    z0.r = c00;
                    z0.D = 1;
                    if(((m)c00.a).a(i0, z0) == a0) {
                        return a0;
                    }
                    c00.b = null;
                    return H.a;
                }
                break;
            }
            case 1: {
                c00 = z0.r;
                d5.n.D(object0);
                c00.b = null;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public final void o0() {
        h h0 = this.b;
        if(h0 != null) {
            i i0 = new i(h0);
            ((m)this.a).b(i0);
            this.b = null;
        }
    }

    @Override  // r0.p
    public final void onDetach() {
        this.o0();
    }
}

