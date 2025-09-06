package com.google.android.exoplayer2.audio;

import W.p;
import ea.c;
import i.n.i.b.a.s.e.S3;
import i.n.i.b.a.s.e.W6;

public final class a implements Runnable {
    public final int a;
    public final String b;
    public final long c;
    public final long d;
    public final Object e;

    public a(Object object0, String s, long v, long v1, int v2) {
        this.a = v2;
        this.e = object0;
        this.b = s;
        this.c = v;
        this.d = v1;
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
                return;
            }
            case 2: {
                ((S3)((c)object0).c).M(this.c, this.b, this.d);
                return;
            }
            default: {
                ((W6)((p)object0).b).N(this.c, this.b, this.d);
            }
        }
    }
}

