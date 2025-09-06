package i.n.i.b.a.s.e;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;

public final class i3 {
    public final ArrayList a;
    public final IdentityHashMap b;
    public final HashMap c;
    public final L9 d;
    public final K2 e;
    public final X1 f;
    public final HashMap g;
    public final HashSet h;
    public T8 i;
    public boolean j;
    public g0 k;

    public i3(L9 l90, S1 s10, Handler handler0) {
        this.d = l90;
        this.i = new T8();
        this.b = new IdentityHashMap();
        this.c = new HashMap();
        this.a = new ArrayList();
        K2 k20 = new K2();
        this.e = k20;
        X1 x10 = new X1();
        this.f = x10;
        this.g = new HashMap();
        this.h = new HashSet();
        if(s10 != null) {
            k20.d(handler0, s10);
            x10.c(handler0, s10);
        }
    }

    public final i a(int v, ArrayList arrayList0, T8 t80) {
        if(!arrayList0.isEmpty()) {
            this.i = t80;
            for(int v1 = v; v1 < arrayList0.size() + v; ++v1) {
                h3 h30 = (h3)arrayList0.get(v1 - v);
                ArrayList arrayList1 = this.a;
                if(v1 > 0) {
                    h3 h31 = (h3)arrayList1.get(v1 - 1);
                    int v2 = h31.d;
                    h30.d = h31.a.n.b.l() + v2;
                }
                else {
                    h30.d = 0;
                }
                h30.e = false;
                h30.c.clear();
                int v3 = h30.a.n.b.l();
                for(int v4 = v1; v4 < arrayList1.size(); ++v4) {
                    h3 h32 = (h3)arrayList1.get(v4);
                    h32.d += v3;
                }
                arrayList1.add(v1, h30);
                this.c.put(h30.b, h30);
                if(this.j) {
                    this.g(h30);
                    if(this.b.isEmpty()) {
                        this.h.add(h30);
                    }
                    else {
                        g3 g30 = (g3)this.g.get(h30);
                        if(g30 != null) {
                            g30.a.n(g30.b);
                        }
                    }
                }
            }
        }
        return this.c();
    }

    public final void b(v0 v00) {
        h3 h30 = (h3)this.b.remove(v00);
        h30.getClass();
        h30.a.e(v00);
        h30.c.remove(((oe)v00).a);
        if(!this.b.isEmpty()) {
            this.d();
        }
        this.f(h30);
    }

    public final i c() {
        ArrayList arrayList0 = this.a;
        if(arrayList0.isEmpty()) {
            return i.a;
        }
        int v1 = 0;
        for(int v = 0; v < arrayList0.size(); ++v) {
            h3 h30 = (h3)arrayList0.get(v);
            h30.d = v1;
            v1 += h30.a.n.b.l();
        }
        return new P7(arrayList0, this.i);
    }

    public final void d() {
        Iterator iterator0 = this.h.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            h3 h30 = (h3)object0;
            if(h30.c.isEmpty()) {
                g3 g30 = (g3)this.g.get(h30);
                if(g30 != null) {
                    g30.a.n(g30.b);
                }
                iterator0.remove();
            }
        }
    }

    public final void e(int v, int v1) {
        for(int v2 = v1 - 1; v2 >= v; --v2) {
            ArrayList arrayList0 = this.a;
            h3 h30 = (h3)arrayList0.remove(v2);
            this.c.remove(h30.b);
            int v3 = -h30.a.n.b.l();
            for(int v4 = v2; v4 < arrayList0.size(); ++v4) {
                h3 h31 = (h3)arrayList0.get(v4);
                h31.d += v3;
            }
            h30.e = true;
            if(this.j) {
                this.f(h30);
            }
        }
    }

    public final void f(h3 h30) {
        if(h30.e && h30.c.isEmpty()) {
            g3 g30 = (g3)this.g.remove(h30);
            g30.getClass();
            g30.a.m(g30.b);
            g30.a.j(g30.c);
            g30.a.g(g30.c);
            this.h.remove(h30);
        }
    }

    public final void g(h3 h30) {
        x x0 = h30.a;
        e3 e30 = new e3(this);
        f3 f30 = new f3(this, h30);
        g3 g30 = new g3(x0, e30, f30);
        this.g.put(h30, g30);
        Looper looper0 = Looper.myLooper();
        if(looper0 == null) {
            looper0 = Looper.getMainLooper();
        }
        Handler handler0 = new Handler(looper0, null);
        x0.getClass();
        x0.c.d(handler0, f30);
        Looper looper1 = Looper.myLooper();
        if(looper1 == null) {
            looper1 = Looper.getMainLooper();
        }
        Handler handler1 = new Handler(looper1, null);
        x0.d.c(handler1, f30);
        x0.i(e30, this.k);
    }
}

