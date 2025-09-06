package i.n.i.b.a.s.e;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class a6 {
    public final ArrayList a;
    public final HashSet b;
    public final K2 c;
    public final X1 d;
    public Looper e;
    public i f;

    public a6() {
        this.a = new ArrayList(1);
        this.b = new HashSet(1);
        this.c = new K2();
        this.d = new X1();
    }

    public abstract e a();

    public abstract v0 b(e2 arg1, L3 arg2, long arg3);

    public final void c(i i0) {
        this.f = i0;
        for(Object object0: this.a) {
            ((f2)object0).a(this, i0);
        }
    }

    public abstract void d(g0 arg1);

    public abstract void e(v0 arg1);

    public final void g(Y1 y10) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.d.c;
        for(Object object0: copyOnWriteArrayList0) {
            W1 w10 = (W1)object0;
            if(w10.b == y10) {
                copyOnWriteArrayList0.remove(w10);
            }
        }
    }

    public final void h(f2 f20) {
        this.e.getClass();
        this.b.add(f20);
        if(this.b.isEmpty()) {
            this.q();
        }
    }

    public final void i(f2 f20, g0 g00) {
        Looper looper0 = Looper.myLooper();
        M7.u(this.e == null || this.e == looper0);
        i i0 = this.f;
        this.a.add(f20);
        if(this.e == null) {
            this.e = looper0;
            this.b.add(f20);
            this.d(g00);
            return;
        }
        if(i0 != null) {
            this.h(f20);
            f20.a(this, i0);
        }
    }

    public final void j(L2 l20) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.c.c;
        for(Object object0: copyOnWriteArrayList0) {
            J2 j20 = (J2)object0;
            if(j20.b == l20) {
                copyOnWriteArrayList0.remove(j20);
            }
        }
    }

    public final K2 k(e2 e20) {
        return new K2(this.c.c, 0, e20, 0L);
    }

    public abstract void l();

    public final void m(f2 f20) {
        this.a.remove(f20);
        if(this.a.isEmpty()) {
            this.e = null;
            this.f = null;
            this.b.clear();
            this.s();
            return;
        }
        this.n(f20);
    }

    public final void n(f2 f20) {
        this.b.remove(f20);
        if(!this.b.isEmpty() && this.b.isEmpty()) {
            this.p();
        }
    }

    public void p() {
    }

    public void q() {
    }

    public abstract void s();
}

