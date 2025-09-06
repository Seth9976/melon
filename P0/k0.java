package P0;

import Ic.h;
import J0.B;
import M0.a;
import N0.X;
import Q0.u;
import X0.m;
import androidx.collection.F;
import androidx.compose.foundation.lazy.layout.d;
import g0.e;
import r0.p;
import w0.k;
import w0.o;

public abstract class k0 {
    public static final F a;

    static {
        k0.a = new F();
    }

    public static final void a(p p0) {
        if(!p0.isAttached()) {
            a.b("autoInvalidateInsertedNode called on unattached node");
        }
        k0.b(p0, -1, 1);
    }

    public static final void b(p p0, int v, int v1) {
        if(p0 instanceof n) {
            k0.c(p0, ((n)p0).a & v, v1);
            int v2 = ~((n)p0).a & v;
            for(p p1 = ((n)p0).b; p1 != null; p1 = p1.getChild$ui_release()) {
                k0.b(p1, v2, v1);
            }
            return;
        }
        k0.c(p0, v & p0.getKindSet$ui_release(), v1);
    }

    public static final void c(p p0, int v, int v1) {
        e e1;
        p p2;
        if(v1 != 0 || p0.getShouldAutoInvalidate()) {
            if((v & 2) != 0 && p0 instanceof z) {
                f.v(((z)p0)).D();
                if(v1 == 2) {
                    j0 j00 = f.t(p0, 2);
                    j00.o = true;
                    j00.Y.invoke();
                    if(j00.b0 != null) {
                        j00.n1(null, false);
                        j00.l.V(false);
                    }
                }
            }
            if((v & 0x80) != 0 && p0 instanceof y && v1 != 2) {
                f.v(p0).D();
            }
            if((v & 0x100) != 0 && p0 instanceof q && v1 != 2) {
                I i0 = f.v(p0);
                if(!i0.q() && !i0.r() && !i0.k0) {
                    u u0 = (u)L.a(i0);
                    ((e)u0.l0.e.a).b(i0);
                    i0.k0 = true;
                    u0.G(null);
                }
            }
            if((v & 4) != 0 && p0 instanceof P0.p) {
                f.m(((P0.p)p0));
            }
            if((v & 8) != 0 && p0 instanceof z0) {
                f.v(p0).B = true;
            }
            if((v & 0x40) != 0 && p0 instanceof u0) {
                I i1 = f.v(((u0)p0));
                i1.c0.p.w = true;
                V v2 = i1.c0.q;
                if(v2 != null) {
                    v2.I = true;
                }
            }
            if((v & 0x800) != 0 && p0 instanceof o) {
                g.b = null;
                ((o)p0).X(g.a);
                if(g.b != null) {
                    if(!((p)(((o)p0))).getNode().isAttached()) {
                        a.b("visitChildren called on an unattached node");
                    }
                    e e0 = new e(new p[16]);
                    p p1 = ((p)(((o)p0))).getNode().getChild$ui_release();
                    if(p1 == null) {
                        f.b(e0, ((p)(((o)p0))).getNode());
                    }
                    else {
                        e0.b(p1);
                    }
                alab1:
                    while(true) {
                    alab2:
                        while(true) {
                            int v3 = e0.c;
                            if(v3 == 0) {
                                break alab1;
                            }
                            p2 = (p)e0.k(v3 - 1);
                            if((p2.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                                f.b(e0, p2);
                            }
                            else {
                                while(true) {
                                    if(p2 == null) {
                                        continue alab1;
                                    }
                                    if((p2.getKindSet$ui_release() & 0x400) == 0) {
                                        p2 = p2.getChild$ui_release();
                                        continue;
                                    }
                                    e1 = null;
                                label_52:
                                    if(p2 == null) {
                                        break;
                                    }
                                    break alab2;
                                }
                            }
                        }
                        if(p2 instanceof w0.u) {
                            w0.g g0 = ((k)((u)f.w(((w0.u)p2))).getFocusOwner()).g;
                            if(g0.d.a(((w0.u)p2)) && !g0.f) {
                                h h0 = new h(0, g0, w0.g.class, "invalidateNodes", "invalidateNodes()V", 0, 28);
                                g0.a.invoke(h0);
                                g0.f = true;
                            }
                        }
                        else if((p2.getKindSet$ui_release() & 0x400) != 0 && p2 instanceof n) {
                            p p3 = ((n)p2).b;
                            int v4 = 0;
                            while(p3 != null) {
                                if((p3.getKindSet$ui_release() & 0x400) != 0) {
                                    ++v4;
                                    if(v4 == 1) {
                                        p2 = p3;
                                    }
                                    else {
                                        if(e1 == null) {
                                            e1 = new e(new p[16]);
                                        }
                                        if(p2 != null) {
                                            e1.b(p2);
                                            p2 = null;
                                        }
                                        e1.b(p3);
                                    }
                                }
                                p3 = p3.getChild$ui_release();
                            }
                            if(v4 != 1) {
                                p2 = f.f(e1);
                            }
                            goto label_52;
                        }
                        p2 = f.f(e1);
                        goto label_52;
                    }
                }
            }
            if((v & 0x1000) != 0 && p0 instanceof w0.e) {
                w0.g g1 = ((k)((u)f.w(((w0.e)p0))).getFocusOwner()).g;
                if(g1.e.a(((w0.e)p0)) && !g1.f) {
                    h h1 = new h(0, g1, w0.g.class, "invalidateNodes", "invalidateNodes()V", 0, 28);
                    g1.a.invoke(h1);
                    g1.f = true;
                }
            }
        }
    }

    public static final void d(p p0) {
        if(!p0.isAttached()) {
            a.b("autoInvalidateUpdatedNode called on unattached node");
        }
        k0.b(p0, -1, 0);
    }

    public static final int e(r0.o o0) {
        int v = o0 instanceof N0.y ? 3 : 1;
        if(o0 instanceof androidx.compose.foundation.j0) {
            v |= 4;
        }
        if(o0 instanceof m) {
            v |= 8;
        }
        if(o0 instanceof B) {
            v |= 16;
        }
        if(o0 instanceof M.V) {
            v |= 0x20;
        }
        if(o0 instanceof d) {
            v |= 0x100;
        }
        if(o0 instanceof X) {
            v |= 0x40;
        }
        return o0 instanceof U0.a ? 0x80000 | v : v;
    }

    public static final int f(p p0) {
        if(p0.getKindSet$ui_release() != 0) {
            return p0.getKindSet$ui_release();
        }
        Class class0 = p0.getClass();
        F f0 = k0.a;
        int v = f0.d(class0);
        if(v >= 0) {
            return f0.c[v];
        }
        int v1 = p0 instanceof z ? 3 : 1;
        if(p0 instanceof P0.p) {
            v1 |= 4;
        }
        if(p0 instanceof z0) {
            v1 |= 8;
        }
        if(p0 instanceof w0) {
            v1 |= 16;
        }
        if(p0 instanceof O0.d) {
            v1 |= 0x20;
        }
        if(p0 instanceof u0) {
            v1 |= 0x40;
        }
        if(p0 instanceof y) {
            v1 |= 0x80;
        }
        if(p0 instanceof q) {
            v1 |= 0x100;
        }
        if(p0 instanceof w0.u) {
            v1 |= 0x400;
        }
        if(p0 instanceof o) {
            v1 |= 0x800;
        }
        if(p0 instanceof w0.e) {
            v1 |= 0x1000;
        }
        if(p0 instanceof H0.f) {
            v1 |= 0x2000;
        }
        if(p0 instanceof L0.a) {
            v1 |= 0x4000;
        }
        if(p0 instanceof l) {
            v1 |= 0x8000;
        }
        if(p0 instanceof H0.a) {
            v1 |= 0x20000;
        }
        if(p0 instanceof D0) {
            v1 |= 0x40000;
        }
        if(p0 instanceof U0.a) {
            v1 |= 0x80000;
        }
        f0.g(v1, class0);
        return v1;
    }

    public static final int g(p p0) {
        if(p0 instanceof n) {
            int v = ((n)p0).a;
            for(p p1 = ((n)p0).b; p1 != null; p1 = p1.getChild$ui_release()) {
                v |= k0.g(p1);
            }
            return v;
        }
        return k0.f(p0);
    }

    public static final boolean h(int v) [...] // 潜在的解密器
}

