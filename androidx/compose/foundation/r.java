package androidx.compose.foundation;

import A0.b;
import A0.d;
import A0.f;
import A0.h;
import G.g;
import P0.K;
import P0.n0;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import r0.p;
import r1.m;
import x0.e;
import y0.G;
import y0.H;
import y0.I;
import y0.L;
import y0.M;
import y0.Q;
import y0.o;
import y0.s;

public final class r extends p implements n0, P0.p {
    public long a;
    public o b;
    public float c;
    public Q d;
    public long e;
    public m f;
    public M g;
    public Q h;
    public M i;

    @Override  // P0.p
    public final void draw(d d0) {
        M m0;
        if(this.d == M.a) {
            if(!s.d(this.a, s.g)) {
                f.d0(d0, this.a, 0L, 0.0f, null, 0, 0x7E);
            }
            o o0 = this.b;
            if(o0 != null) {
                f.f0(d0, o0, 0L, 0L, this.c, null, 0x76);
            }
        }
        else {
            b b0 = ((K)d0).a;
            if(!e.a(b0.c(), this.e) || ((K)d0).getLayoutDirection() != this.f || !q.b(this.h, this.d)) {
                P0.f.r(this, new g(23, this, ((K)d0)));
                m0 = this.i;
                this.i = null;
            }
            else {
                m0 = this.g;
                q.d(m0);
            }
            this.g = m0;
            this.e = b0.c();
            this.f = ((K)d0).getLayoutDirection();
            this.h = this.d;
            q.d(m0);
            if(!s.d(this.a, s.g)) {
                M.m(d0, m0, this.a);
            }
            o o1 = this.b;
            if(o1 != null) {
                float f = this.c;
                h h0 = h.b;
                if(m0 instanceof H) {
                    long v = M.t(((H)m0).e);
                    ((K)d0).E(o1, ((long)Float.floatToRawIntBits(((H)m0).e.b)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(((H)m0).e.a)) << 0x20, v, f, h0, 3);
                }
                else if(m0 instanceof I) {
                    L l0 = ((I)m0).f;
                    if(l0 == null) {
                        float f1 = Float.intBitsToFloat(((int)(((I)m0).e.h >> 0x20)));
                        ((K)d0).f(o1, ((long)Float.floatToRawIntBits(((I)m0).e.b)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(((I)m0).e.a)) << 0x20, ((long)Float.floatToRawIntBits(((I)m0).e.b())) << 0x20 | ((long)Float.floatToRawIntBits(((I)m0).e.a())) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f1)) << 0x20, f, h0);
                    }
                    else {
                        ((K)d0).J(l0, o1, f, h0, 3);
                    }
                }
                else {
                    if(!(m0 instanceof G)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    ((K)d0).J(((G)m0).e, o1, f, h0, 3);
                }
            }
        }
        ((K)d0).a();
    }

    @Override  // P0.n0
    public final void y() {
        this.e = 0x7FC000007FC00000L;
        this.f = null;
        this.g = null;
        this.h = null;
        P0.f.m(this);
    }
}

