package com.facebook.appevents.internal;

import android.content.Context;
import androidx.media3.exoplayer.B;
import androidx.media3.exoplayer.x;
import androidx.media3.exoplayer.y;
import ea.b;
import ea.c;
import i.n.i.b.a.s.e.K2;
import i.n.i.b.a.s.e.L2;
import i.n.i.b.a.s.e.S3;

public final class a implements Runnable {
    public final int a;
    public final long b;
    public final Object c;
    public final Object d;

    public a(int v, long v1, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.d = object1;
        this.b = v1;
        super();
    }

    public a(long v, String s, Context context0) {
        this.a = 0;
        super();
        this.b = v;
        this.c = s;
        this.d = context0;
    }

    @Override
    public final void run() {
        long v = this.b;
        Object object0 = this.d;
        Object object1 = this.c;
        switch(this.a) {
            case 0: {
                ActivityLifecycleTracker.onActivityResumed$lambda$3(v, ((String)object1), ((Context)object0));
                return;
            }
            case 1: {
                ((L2)object0).E(((K2)object1).a, ((K2)object1).b, v);
                return;
            }
            case 2: {
                ((S3)((c)object1).c).w(v, object0);
                return;
            }
            default: {
                B b0 = ((y)((b)object1).b).a;
                i3.a a0 = b0.s.u();
                Y6.a a1 = new Y6.a(a0, object0, v);
                b0.s.v(a0, 26, a1);
                if(b0.P == object0) {
                    x x0 = new x(0);
                    b0.m.g(26, x0);
                }
            }
        }
    }
}

