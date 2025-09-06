package kd;

import A0.b;
import A0.d;
import B0.e;
import F.g;
import P0.K;
import jd.m3;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import we.k;

public final class a implements k {
    public final e a;
    public final boolean b;
    public final long c;
    public final long d;
    public final H e;
    public final long f;
    public final H g;
    public final long h;
    public final m3 i;
    public final long j;
    public final long k;

    public a(e e0, boolean z, long v, long v1, H h0, long v2, H h1, long v3, m3 m30, long v4, long v5) {
        this.a = e0;
        this.b = z;
        this.c = v;
        this.d = v1;
        this.e = h0;
        this.f = v2;
        this.g = h1;
        this.h = v3;
        this.i = m30;
        this.j = v4;
        this.k = v5;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        int v1;
        int v;
        q.g(((d)object0), "$this$drawWithContent");
        b b0 = ((K)(((d)object0))).a;
        if(Float.intBitsToFloat(((int)(b0.c() >> 0x20))) != 0.0f && Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL))) != 0.0f) {
            if(Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(b0.c() >> 0x20))) > 2.111111f) {
                v = (int)Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL)));
                v1 = ((int)Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL)))) * 9 / 19;
            }
            else {
                v1 = (int)Float.intBitsToFloat(((int)(b0.c() >> 0x20)));
                v = ((int)Float.intBitsToFloat(((int)(b0.c() >> 0x20)))) * 19 / 9;
            }
            kd.b b1 = new kd.b(this.b, this.c, ((d)object0), this.d, this.e, this.f, v1, v, this.g, this.h, this.i, this.j, this.k);
            long v2 = b0.c();
            g g0 = new g(((K)(((d)object0))), ((K)(((d)object0))).b, b1, 10);
            this.a.g(((K)(((d)object0))), ((K)(((d)object0))).getLayoutDirection(), ((long)(((int)Float.intBitsToFloat(((int)(v2 >> 0x20)))))) << 0x20 | ((long)(((int)Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL, g0);
            y5.a.z(((d)object0), this.a);
        }
        return ie.H.a;
    }
}

