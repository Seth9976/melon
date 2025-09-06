package androidx.compose.foundation;

import A0.b;
import A0.c;
import A0.d;
import A0.f;
import A0.i;
import P0.K;
import androidx.media3.session.legacy.V;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import y0.o;

public final class v extends r implements k {
    public final boolean f;
    public final o g;
    public final long h;
    public final float i;
    public final float j;
    public final long k;
    public final long l;
    public final i m;

    public v(boolean z, o o0, long v, float f, float f1, long v1, long v2, i i0) {
        this.f = z;
        this.g = o0;
        this.h = v;
        this.i = f;
        this.j = f1;
        this.k = v1;
        this.l = v2;
        this.m = i0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ((K)(((d)object0))).a();
        b b0 = ((K)(((d)object0))).a;
        if(this.f) {
            f.P(((K)(((d)object0))), this.g, 0L, 0L, this.h, null, 0xF6);
            return H.a;
        }
        long v = this.h;
        float f = this.i;
        if(Float.intBitsToFloat(((int)(v >> 0x20))) < f) {
            float f1 = Float.intBitsToFloat(((int)(b0.c() >> 0x20)));
            float f2 = Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL)));
            long v1 = b0.b.l();
            b0.b.h().q();
            try {
                ((V)((c)b0.b.a).b).h().h(this.j, this.j, f1 - this.j, f2 - this.j, 0);
                f.P(((K)(((d)object0))), this.g, 0L, 0L, this.h, null, 0xF6);
                return H.a;
            }
            finally {
                androidx.appcompat.app.o.y(b0.b, v1);
            }
        }
        f.P(((K)(((d)object0))), this.g, this.k, this.l, q.w(v, f), this.m, 0xD0);
        return H.a;
    }
}

