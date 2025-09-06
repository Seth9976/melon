package s3;

import B7.b;
import android.os.Looper;
import b3.E;
import b3.p0;
import i3.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.j;
import k3.k;
import w3.d;

public abstract class a {
    public final ArrayList a;
    public final HashSet b;
    public final b c;
    public final k d;
    public Looper e;
    public p0 f;
    public l g;

    public a() {
        this.a = new ArrayList(1);
        this.b = new HashSet(1);
        this.c = new b(0, new CopyOnWriteArrayList(), null);
        this.d = new k(new CopyOnWriteArrayList(), 0, null);
    }

    public boolean a(E e0) {
        return false;
    }

    public abstract x b(z arg1, d arg2, long arg3);

    public final void c(A a0) {
        this.b.remove(a0);
        if(!this.b.isEmpty() && this.b.isEmpty()) {
            this.d();
        }
    }

    public void d() {
    }

    public final void e(A a0) {
        this.e.getClass();
        this.b.add(a0);
        if(this.b.isEmpty()) {
            this.f();
        }
    }

    public void f() {
    }

    public p0 g() {
        return null;
    }

    public abstract E h();

    public boolean i() {
        return true;
    }

    public abstract void j();

    public final void k(A a0, g3.x x0, l l0) {
        Looper looper0 = Looper.myLooper();
        e3.b.c(this.e == null || this.e == looper0);
        this.g = l0;
        p0 p00 = this.f;
        this.a.add(a0);
        if(this.e == null) {
            this.e = looper0;
            this.b.add(a0);
            this.l(x0);
            return;
        }
        if(p00 != null) {
            this.e(a0);
            a0.a(this, p00);
        }
    }

    public abstract void l(g3.x arg1);

    public final void m(p0 p00) {
        this.f = p00;
        for(Object object0: this.a) {
            ((A)object0).a(this, p00);
        }
    }

    public abstract void n(x arg1);

    public final void o(A a0) {
        this.a.remove(a0);
        if(this.a.isEmpty()) {
            this.e = null;
            this.f = null;
            this.g = null;
            this.b.clear();
            this.p();
            return;
        }
        this.c(a0);
    }

    public abstract void p();

    public final void q(k3.l l0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.d.c;
        for(Object object0: copyOnWriteArrayList0) {
            j j0 = (j)object0;
            if(j0.b == l0) {
                copyOnWriteArrayList0.remove(j0);
            }
        }
    }

    public final void r(D d0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = (CopyOnWriteArrayList)this.c.c;
        for(Object object0: copyOnWriteArrayList0) {
            C c0 = (C)object0;
            if(c0.b == d0) {
                copyOnWriteArrayList0.remove(c0);
            }
        }
    }

    public void s(E e0) {
    }
}

