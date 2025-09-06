package u2;

import N4.Q;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import e1.b;
import java.util.ArrayList;
import v6.i;
import v6.j;
import y8.s;

public final class e {
    public float a;
    public float b;
    public boolean c;
    public final j d;
    public final b e;
    public boolean f;
    public float g;
    public float h;
    public long i;
    public float j;
    public final ArrayList k;
    public final ArrayList l;
    public f m;
    public float n;
    public boolean o;
    public static final c p;
    public static final c q;
    public static final c r;
    public static final c s;
    public static final c t;
    public static final c u;

    static {
        e.p = new c(1);
        e.q = new c(2);
        e.r = new c(3);
        e.s = new c(4);
        e.t = new c(5);
        e.u = new c(0);
    }

    public e(M.e e0) {
        this.a = 0.0f;
        this.b = 3.402823E+38f;
        this.c = false;
        this.f = false;
        this.g = 3.402823E+38f;
        this.h = -3.402823E+38f;
        this.i = 0L;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = null;
        this.e = new d(e0);
        this.j = 1.0f;
        this.m = null;
        this.n = 3.402823E+38f;
        this.o = false;
    }

    public e(j j0) {
        i i0 = j.w;
        super();
        this.a = 0.0f;
        this.b = 3.402823E+38f;
        this.c = false;
        this.f = false;
        this.g = 3.402823E+38f;
        this.h = -3.402823E+38f;
        this.i = 0L;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = j0;
        this.e = i0;
        if(i0 == e.r || i0 == e.s || i0 == e.t) {
            this.j = 0.1f;
        }
        else if(i0 == e.u) {
            this.j = 0.003906f;
        }
        else if(i0 == e.p || i0 == e.q) {
            this.j = 0.003906f;
        }
        else {
            this.j = 1.0f;
        }
        this.m = null;
        this.n = 3.402823E+38f;
        this.o = false;
    }

    public final void a(float f) {
        if(this.f) {
            this.n = f;
            return;
        }
        if(this.m == null) {
            this.m = new f(f);
        }
        f f1 = this.m;
        f1.i = (double)f;
        if(((double)(((float)(((double)f))))) > ((double)this.g)) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if(((double)(((float)(((double)f))))) < ((double)this.h)) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double f2 = Math.abs(this.j * 0.75f);
        f1.d = f2;
        f1.e = f2 * 62.5;
        if(Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if(!this.f) {
            this.f = true;
            if(!this.c) {
                this.b = this.e.C(this.d);
            }
            if(this.b > this.g || this.b < this.h) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            ThreadLocal threadLocal0 = u2.b.f;
            if(threadLocal0.get() == null) {
                threadLocal0.set(new u2.b());
            }
            u2.b b0 = (u2.b)threadLocal0.get();
            ArrayList arrayList0 = b0.b;
            if(arrayList0.size() == 0) {
                if(b0.d == null) {
                    b0.d = new s(b0.c);
                }
                ((Choreographer)b0.d.b).postFrameCallback(((a)b0.d.c));
            }
            if(!arrayList0.contains(this)) {
                arrayList0.add(this);
            }
        }
    }

    public final void b(float f) {
        ArrayList arrayList0;
        this.e.K(this.d, f);
        for(int v = 0; true; ++v) {
            arrayList0 = this.l;
            if(v >= arrayList0.size()) {
                break;
            }
            if(arrayList0.get(v) != null) {
                Q q0 = (Q)arrayList0.get(v);
                long v1 = Math.max(-1L, Math.min(q0.g.S + 1L, Math.round(this.b)));
                q0.g.F(v1, q0.a);
                q0.a = v1;
            }
        }
        for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
            if(arrayList0.get(v2) == null) {
                arrayList0.remove(v2);
            }
        }
    }

    public final void c() {
        if(this.m.b <= 0.0) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if(Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if(this.f) {
            this.o = true;
        }
    }
}

