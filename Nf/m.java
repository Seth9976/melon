package Nf;

import bf.f;

public final class m extends n {
    public final int c;
    public static final m d;
    public static final m e;

    static {
        m.d = new m("must be a member function", 0);
        m.e = new m("must be a member or an extension function", 1);
    }

    public m(String s, int v) {
        this.c = v;
        super(s, 0);
    }

    @Override  // Nf.e
    public final boolean a(f f0) {
        return this.c == 0 ? f0.j != null : f0.j != null || f0.i != null;
    }
}

