package G1;

import F1.i;

public final class j extends p {
    @Override  // G1.e
    public final void a(e e0) {
        g g0 = this.h;
        if(!g0.c || g0.j) {
            return;
        }
        g0.d(((int)(((float)((g)g0.l.get(0)).g) * ((i)this.b).v0 + 0.5f)));
    }

    @Override  // G1.p
    public final void d() {
        F1.e e0 = this.b;
        int v = ((i)e0).w0;
        int v1 = ((i)e0).x0;
        g g0 = this.h;
        if(((i)e0).z0 == 1) {
            if(v != -1) {
                g0.l.add(e0.W.d.h);
                this.b.W.d.h.k.add(g0);
                g0.f = v;
            }
            else if(v1 == -1) {
                g0.b = true;
                g0.l.add(e0.W.d.i);
                this.b.W.d.i.k.add(g0);
            }
            else {
                g0.l.add(e0.W.d.i);
                this.b.W.d.i.k.add(g0);
                g0.f = -v1;
            }
            this.m(this.b.d.h);
            this.m(this.b.d.i);
            return;
        }
        if(v != -1) {
            g0.l.add(e0.W.e.h);
            this.b.W.e.h.k.add(g0);
            g0.f = v;
        }
        else if(v1 == -1) {
            g0.b = true;
            g0.l.add(e0.W.e.i);
            this.b.W.e.i.k.add(g0);
        }
        else {
            g0.l.add(e0.W.e.i);
            this.b.W.e.i.k.add(g0);
            g0.f = -v1;
        }
        this.m(this.b.e.h);
        this.m(this.b.e.i);
    }

    @Override  // G1.p
    public final void e() {
        F1.e e0 = this.b;
        g g0 = this.h;
        if(((i)e0).z0 == 1) {
            e0.b0 = g0.g;
            return;
        }
        e0.c0 = g0.g;
    }

    @Override  // G1.p
    public final void f() {
        this.h.c();
    }

    @Override  // G1.p
    public final boolean k() {
        return false;
    }

    public final void m(g g0) {
        this.h.k.add(g0);
        g0.l.add(this.h);
    }
}

