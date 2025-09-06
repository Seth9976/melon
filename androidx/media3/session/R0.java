package androidx.media3.session;

import H8.q;
import J0.h;
import T3.e;
import android.util.Log;
import android.util.SparseBooleanArray;
import e3.b;
import g7.c;
import h7.K0;
import k7.a;

public final class r0 implements Runnable {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;
    public final Object e;

    public r0(h h0, x0 x00, boolean z, w0 w00) {
        this.a = 1;
        super();
        this.c = h0;
        this.d = x00;
        this.b = z;
        this.e = w00;
    }

    public r0(Object object0, Object object1, Object object2, boolean z, int v) {
        this.a = v;
        this.c = object0;
        this.d = object1;
        this.e = object2;
        this.b = z;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((t0)this.c).d(((y0)this.d), ((e)this.e), this.b);
                return;
            }
            case 1: {
                w0 w00 = (w0)this.e;
                n0 n00 = ((N0)((h)this.c).d).g;
                o1 o10 = n00.t;
                h1.f(o10, ((x0)this.d));
                int v = o10.getPlaybackState();
                if(v != 1) {
                    if(v == 4 && o10.Y(4)) {
                        o10.seekToDefaultPosition();
                    }
                }
                else if(o10.Y(2)) {
                    o10.prepare();
                }
                boolean z = this.b;
                if(z && o10.Y(1)) {
                    o10.play();
                }
                SparseBooleanArray sparseBooleanArray0 = new SparseBooleanArray();
                for(int v1 = 0; v1 < 2; ++v1) {
                    int v2 = new int[]{0x1F, 2}[v1];
                    b.j(((boolean)1));
                    sparseBooleanArray0.append(v2, true);
                }
                if(z) {
                    b.j(((boolean)1));
                    sparseBooleanArray0.append(1, true);
                }
                b.j(((boolean)1));
                n00.x(w00);
                return;
            }
            default: {
                q q0 = (q)this.c;
                K0 k00 = (K0)this.d;
                c c0 = (c)this.e;
                q0.getClass();
                if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "disk worker: log non-fatal event to persistence", null);
                }
                ((a)q0.b).d(k00, c0.a, this.b);
            }
        }
    }
}

