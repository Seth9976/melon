package Ze;

import Ac.q0;
import Je.i;
import Me.c;
import Me.u;
import Pe.L;
import Pe.S;
import d5.n;
import h7.u0;
import je.C;
import je.p;
import kotlin.jvm.internal.q;
import qf.e;
import we.k;

public final class d implements k {
    public final int a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final d h;

    static {
        d.b = new d(0);
        d.c = new d(1);
        d.d = new d(2);
        d.e = new d(3);
        d.f = new d(4);
        d.g = new d(5);
        d.h = new d(6);
    }

    public d(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z = false;
        switch(this.a) {
            case 0: {
                q.g(((c)object0), "it");
                String s1 = n.r(((c)object0));
                return Boolean.valueOf(p.d0(E.f, s1));
            }
            case 1: {
                q.g(((c)object0), "it");
                if(((c)object0) instanceof u) {
                    String s2 = n.r(((c)object0));
                    if(p.d0(E.f, s2)) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
            case 2: {
                q.g(((c)object0), "it");
                return Boolean.valueOf(u0.G(((c)object0)));
            }
            case 3: {
                return ((S)object0).getType();
            }
            case 4: {
                q.g(((c)object0), "it");
                return Boolean.valueOf(u0.G(xf.d.k(((c)object0))));
            }
            case 5: {
                q.g(((c)object0), "it");
                if(i.A(((L)(((c)object0)))) && xf.d.b(((L)(((c)object0))), new q0(((L)(((c)object0))), 15)) != null) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            default: {
                q.g(((c)object0), "it");
                if(i.A(((c)object0))) {
                    e e0 = ((c)object0).getName();
                    B b0 = null;
                    if(E.e.contains(e0)) {
                        c c0 = xf.d.b(((c)object0), d.c);
                        if(c0 != null) {
                            String s = n.r(c0);
                            if(s != null) {
                                if(E.b.contains(s)) {
                                    b0 = B.a;
                                }
                                else {
                                    b0 = ((D)C.Q(s, E.d)) == D.b ? B.c : B.b;
                                }
                            }
                        }
                    }
                    if(b0 != null) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        }
    }
}

