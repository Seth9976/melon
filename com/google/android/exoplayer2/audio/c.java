package com.google.android.exoplayer2.audio;

import E9.u;
import I6.V;
import I6.w;
import W.p;
import Y3.m;
import i.n.i.b.a.s.e.W6;
import i3.a;
import s3.z;
import w3.b;

public final class c implements Runnable {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final Object e;

    public c(Object object0, int v, int v1, long v2, long v3) {
        this.a = v1;
        this.e = object0;
        this.b = v;
        this.c = v2;
        this.d = v3;
        super();
    }

    @Override
    public final void run() {
        Object object0 = this.e;
        switch(this.a) {
            case 0: {
                return;
            }
            case 1: {
                ((W6)((p)object0).b).t(this.b, this.c, this.d);
                return;
            }
            default: {
                u u0 = ((b)object0).b.d;
                z z0 = ((V)u0.b).isEmpty() ? null : ((z)w.j(((V)u0.b)));
                a a0 = ((b)object0).b.q(z0);
                ((b)object0).b.v(a0, 1006, new m(a0, this.b, this.c, this.d));
            }
        }
    }
}

