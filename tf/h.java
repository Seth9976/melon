package tf;

import Me.L;
import Me.Q;
import Me.f;
import Me.j;
import Me.k;
import Me.u;
import e1.b;
import java.util.Comparator;
import qf.c;
import xf.d;

public final class h implements Comparator {
    public final int a;
    public static final h b;

    static {
        h.b = new h(0);
    }

    public h(int v) {
        this.a = v;
        super();
    }

    public static int a(k k0) {
        if(k0 != null) {
            if(e.m(k0, f.d)) {
                return 8;
            }
            if(k0 instanceof j) {
                return 7;
            }
            if(k0 instanceof L) {
                return ((L)k0).Q() == null ? 6 : 5;
            }
            if(k0 instanceof u) {
                return ((u)k0).Q() == null ? 4 : 3;
            }
            if(k0 instanceof Me.e) {
                return 2;
            }
            return k0 instanceof Q ? 1 : 0;
        }
        e.a(36);
        throw null;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        Integer integer0;
        if(this.a != 0) {
            c c0 = d.g(((Me.e)object0));
            c c1 = d.g(((Me.e)object1));
            return b.r(c0.a.a, c1.a.a);
        }
        int v = h.a(((k)object1)) - h.a(((k)object0));
        if(v != 0) {
            integer0 = v;
            return integer0 == null ? 0 : ((int)integer0);
        }
        if(e.m(((k)object0), f.d) && e.m(((k)object1), f.d)) {
            return 0;
        }
        qf.e e0 = ((k)object0).getName();
        qf.e e1 = ((k)object1).getName();
        int v1 = e0.a.compareTo(e1.a);
        integer0 = v1 == 0 ? null : v1;
        return integer0 == null ? 0 : ((int)integer0);
    }
}

