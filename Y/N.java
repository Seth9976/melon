package Y;

import T7.b;
import U.b0;
import Vd.w;
import a1.Q;
import a1.t;

public final class n implements h {
    public final int a;
    public static final n b;
    public static final n c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;

    static {
        n.b = new n(0);
        n.c = new n(1);
        n.d = new b(12);
        n.e = new b(13);
        n.f = new b(14);
        n.g = new b(15);
    }

    public n(int v) {
        this.a = v;
        super();
    }

    @Override  // Y.h
    public long a(w w0, int v) {
        if(this.a != 0) {
            return ((Q)w0.e).j(v);
        }
        String s = ((Q)w0.e).a.a.b;
        return t.b(b0.u(s, v), b0.t(s, v));
    }
}

