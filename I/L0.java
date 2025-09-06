package I;

import A0.b;
import A0.d;
import F.g;
import P0.K;
import Q0.P;
import Q0.b1;
import Q0.k0;
import U.J0;
import U.f0;
import U.w0;
import W.f;
import W.l;
import W.w;
import android.graphics.Paint;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.b0;
import androidx.media3.session.a0;
import c.a;
import f1.j;
import f1.p;
import f1.x;
import ie.H;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.Channel;
import v1.m;
import we.k;
import x0.c;
import y0.M;
import y0.T;
import y0.h;
import y0.q;
import y0.t;

public final class l0 extends r implements k {
    public final int f;
    public final Object g;
    public final Object h;
    public final Object i;
    public final Object j;
    public final Object k;

    public l0(Object object0, Object object1, Object object2, Object object3, Object object4, int v) {
        this.f = v;
        this.g = object0;
        this.h = object1;
        this.i = object2;
        this.j = object3;
        this.k = object4;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z = false;
        H h0 = H.a;
        b1 b10 = null;
        Object object1 = this.k;
        Object object2 = this.j;
        Object object3 = this.i;
        Object object4 = this.h;
        Object object5 = this.g;
        switch(this.f) {
            case 0: {
                float f = ((Number)object0).floatValue();
                h0 h00 = t0.j(((Channel)((t0)object5).f));
                if(h00 != null) {
                    ((t0)object5).k(h00);
                    h0 h01 = ((h0)((kotlin.jvm.internal.H)object4).a).a(h00);
                    ((kotlin.jvm.internal.H)object4).a = h01;
                    float f1 = ((g1)object2).f(((g1)object2).d(h01.a));
                    ((E)object3).a = f1;
                    ((C)object1).a = !g0.a(f1 - f);
                }
                if(h00 != null) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            case 1: {
                ((K)(((d)object0))).a();
                b b0 = ((K)(((d)object0))).a;
                float f2 = ((I0)((l)object5).c).m();
                if(f2 != 0.0f) {
                    int v = ((p)object4).t(((int)(((x)object3).b >> 0x20)));
                    J0 j00 = ((f0)object2).d();
                    c c0 = j00 == null ? new c(0.0f, 0.0f, 0.0f, 0.0f) : j00.a.c(v);
                    float f3 = (float)Math.floor(((K)(((d)object0))).Y(w0.a));
                    if(f3 < 1.0f) {
                        f3 = 1.0f;
                    }
                    float f4 = f3 / 2.0f;
                    float f5 = c0.a + f4;
                    float f6 = Float.intBitsToFloat(((int)(b0.c() >> 0x20))) - f4;
                    if(f5 > f6) {
                        f5 = f6;
                    }
                    if(f5 >= f4) {
                        f4 = f5;
                    }
                    float f7 = ((int)f3) % 2 == 1 ? ((float)Math.floor(f4)) + 0.5f : ((float)Math.rint(f4));
                    long v1 = ((long)Float.floatToRawIntBits(f7)) << 0x20 | ((long)Float.floatToRawIntBits(c0.b)) & 0xFFFFFFFFL;
                    long v2 = ((long)Float.floatToRawIntBits(f7)) << 0x20 | ((long)Float.floatToRawIntBits(c0.d)) & 0xFFFFFFFFL;
                    q q0 = b0.a.c;
                    A1.k k0 = b0.d;
                    if(k0 == null) {
                        k0 = M.h();
                        k0.u(1);
                        b0.d = k0;
                    }
                    ((T)object1).a(f2, b0.c(), k0);
                    Paint paint0 = (Paint)k0.c;
                    if(!kotlin.jvm.internal.q.b(((t)k0.e), null)) {
                        k0.n(null);
                    }
                    if(k0.b != 3) {
                        k0.l(3);
                    }
                    if(paint0.getStrokeWidth() != f3) {
                        k0.t(f3);
                    }
                    if(paint0.getStrokeMiter() != 4.0f) {
                        ((Paint)k0.c).setStrokeMiter(4.0f);
                    }
                    if(k0.h() != 0) {
                        k0.r(0);
                    }
                    if(k0.i() != 0) {
                        k0.s(0);
                    }
                    if(!kotlin.jvm.internal.q.b(((h)k0.f), null)) {
                        k0.p(null);
                    }
                    if(!paint0.isFilterBitmap()) {
                        k0.o(1);
                    }
                    q0.f(v1, v2, k0);
                }
                return h0;
            }
            case 2: {
                W.r r0 = ((f)object4).a;
                ((w)object0).h = (x)object5;
                ((w)object0).i = (j)object3;
                ((w)object0).c = (g)object2;
                ((w)object0).d = (k)object1;
                ((w)object0).e = r0 == null ? null : r0.b;
                ((w)object0).f = r0 == null ? null : r0.c;
                if(r0 != null) {
                    b10 = (b1)P0.f.i(r0, k0.s);
                }
                ((w)object0).g = b10;
                return h0;
            }
            case 3: {
                androidx.compose.runtime.H h2 = (androidx.compose.runtime.H)object0;
                ((a)object5).a = ((e.h)object4).d(((String)object3), ((f.c)object2), new a0(((b0)object1), 12));
                return new P(((a)object5), 5);
            }
            default: {
                androidx.compose.runtime.H h1 = (androidx.compose.runtime.H)object0;
                ((m)object5).n.addView(((m)object5), ((m)object5).o);
                ((m)object5).j(((we.a)object4), ((v1.q)object3), ((String)object2), ((r1.m)object1));
                return new P(((m)object5), 6);
            }
        }
    }
}

