package I;

import N0.v;
import P0.f;
import P0.j0;
import P0.y;
import e1.n;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import r0.p;
import x0.c;

public final class l extends p implements P0.l, y {
    public u0 a;
    public final g1 b;
    public boolean c;
    public d d;
    public final a e;
    public v f;
    public boolean g;
    public boolean h;
    public long i;
    public boolean j;

    public l(u0 u00, g1 g10, boolean z, d d0) {
        this.a = u00;
        this.b = g10;
        this.c = z;
        this.d = d0;
        this.e = new a(0);
        this.i = 0L;
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override  // P0.y
    public final void h(long v) {
        int v2;
        long v1 = this.i;
        this.i = v;
        switch(this.a.ordinal()) {
            case 0: {
                v2 = q.h(((int)(v & 0xFFFFFFFFL)), ((int)(0xFFFFFFFFL & v1)));
                break;
            }
            case 1: {
                v2 = q.h(((int)(v >> 0x20)), ((int)(v1 >> 0x20)));
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        if(v2 < 0 && !this.j && !this.g) {
            c c0 = this.n0();
            if(c0 != null && this.o0(c0, v1)) {
                this.h = true;
            }
        }
    }

    public static final float m0(l l0, d d0) {
        int v3;
        c c1;
        if(!r1.l.b(l0.i, 0L)) {
            int v = l0.e.a.c - 1;
            Object[] arr_object = l0.e.a.a;
            c c0 = null;
            if(v < arr_object.length) {
                c1 = null;
                while(v >= 0) {
                    c c2 = (c)((h)arr_object[v]).a.invoke();
                    if(c2 != null) {
                        long v1 = c2.b();
                        long v2 = n.E(l0.i);
                        switch(l0.a.ordinal()) {
                            case 0: {
                                v3 = Float.compare(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))));
                                break;
                            }
                            case 1: {
                                v3 = Float.compare(Float.intBitsToFloat(((int)(v1 >> 0x20))), Float.intBitsToFloat(((int)(v2 >> 0x20))));
                                break;
                            }
                            default: {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                        if(v3 <= 0) {
                            c1 = c2;
                            goto label_22;
                        }
                        if(c1 != null) {
                            break;
                        }
                        c1 = c2;
                        break;
                    }
                label_22:
                    --v;
                }
            }
            else {
                c1 = null;
            }
            if(c1 != null) {
                goto label_31;
            }
            if(l0.g) {
                c0 = l0.n0();
            }
            if(c0 != null) {
                c1 = c0;
            label_31:
                long v4 = n.E(l0.i);
                switch(l0.a.ordinal()) {
                    case 0: {
                        return d0.a(c1.b, c1.d - c1.b, Float.intBitsToFloat(((int)(v4 & 0xFFFFFFFFL))));
                    }
                    case 1: {
                        return d0.a(c1.a, c1.c - c1.a, Float.intBitsToFloat(((int)(v4 >> 0x20))));
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
        }
        return 0.0f;
    }

    public final c n0() {
        if(this.isAttached()) {
            j0 j00 = f.u(this);
            v v0 = this.f;
            if(v0 != null) {
                if(!v0.h()) {
                    v0 = null;
                }
                return v0 == null ? null : j00.f(v0, false);
            }
        }
        return null;
    }

    public final boolean o0(c c0, long v) {
        long v1 = this.q0(c0, v);
        return Math.abs(Float.intBitsToFloat(((int)(v1 >> 0x20)))) <= 0.5f && Math.abs(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)))) <= 0.5f;
    }

    public final void p0() {
        d d0 = this.d == null ? ((d)f.i(this, g.a)) : this.d;
        if(this.j) {
            L.a.c("launchAnimation called when previous animation was running");
        }
        d.a.getClass();
        K1 k10 = new K1(I.c.b);
        CoroutineScope coroutineScope0 = this.getCoroutineScope();
        k k0 = new k(this, k10, d0, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, CoroutineStart.UNDISPATCHED, k0, 1, null);
    }

    public final long q0(c c0, long v) {
        long v1 = n.E(v);
        switch(this.a.ordinal()) {
            case 0: {
                return ((long)Float.floatToRawIntBits((this.d == null ? ((d)f.i(this, g.a)) : this.d).a(c0.b, c0.d - c0.b, Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL;
            }
            case 1: {
                return ((long)Float.floatToRawIntBits((this.d == null ? ((d)f.i(this, g.a)) : this.d).a(c0.a, c0.c - c0.a, Float.intBitsToFloat(((int)(v1 >> 0x20)))))) << 0x20;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

