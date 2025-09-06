package G1;

import F1.a;

public final class k extends p {
    @Override  // G1.e
    public final void a(e e0) {
        a a0 = (a)this.b;
        int v = a0.x0;
        g g0 = this.h;
        int v1 = 0;
        int v2 = -1;
        for(Object object0: g0.l) {
            int v3 = ((g)object0).g;
            if(v2 == -1 || v3 < v2) {
                v2 = v3;
            }
            if(v1 < v3) {
                v1 = v3;
            }
        }
        if(v != 0 && v != 2) {
            g0.d(v1 + a0.z0);
            return;
        }
        g0.d(v2 + a0.z0);
    }

    @Override  // G1.p
    public final void d() {
        F1.e e0 = this.b;
        if(e0 instanceof a) {
            g g0 = this.h;
            g0.b = true;
            int v = ((a)e0).x0;
            boolean z = ((a)e0).y0;
            int v1 = 0;
            switch(v) {
                case 0: {
                    g0.e = 4;
                    while(v1 < ((a)e0).w0) {
                        F1.e e4 = ((a)e0).v0[v1];
                        if(z || e4.j0 != 8) {
                            g g4 = e4.d.h;
                            g4.k.add(g0);
                            g0.l.add(g4);
                        }
                        ++v1;
                    }
                    this.m(this.b.d.h);
                    this.m(this.b.d.i);
                    break;
                }
                case 1: {
                    g0.e = 5;
                    while(v1 < ((a)e0).w0) {
                        F1.e e1 = ((a)e0).v0[v1];
                        if(z || e1.j0 != 8) {
                            g g1 = e1.d.i;
                            g1.k.add(g0);
                            g0.l.add(g1);
                        }
                        ++v1;
                    }
                    this.m(this.b.d.h);
                    this.m(this.b.d.i);
                    return;
                }
                case 2: {
                    g0.e = 6;
                    while(v1 < ((a)e0).w0) {
                        F1.e e2 = ((a)e0).v0[v1];
                        if(z || e2.j0 != 8) {
                            g g2 = e2.e.h;
                            g2.k.add(g0);
                            g0.l.add(g2);
                        }
                        ++v1;
                    }
                    this.m(this.b.e.h);
                    this.m(this.b.e.i);
                    return;
                }
                case 3: {
                    g0.e = 7;
                    while(v1 < ((a)e0).w0) {
                        F1.e e3 = ((a)e0).v0[v1];
                        if(z || e3.j0 != 8) {
                            g g3 = e3.e.i;
                            g3.k.add(g0);
                            g0.l.add(g3);
                        }
                        ++v1;
                    }
                    this.m(this.b.e.h);
                    this.m(this.b.e.i);
                }
            }
        }
    }

    @Override  // G1.p
    public final void e() {
        F1.e e0 = this.b;
        if(e0 instanceof a) {
            g g0 = this.h;
            switch(((a)e0).x0) {
                case 0: 
                case 1: {
                    e0.b0 = g0.g;
                    break;
                }
                default: {
                    e0.c0 = g0.g;
                }
            }
        }
    }

    @Override  // G1.p
    public final void f() {
        this.c = null;
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

