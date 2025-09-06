package Nf;

import bf.f;
import y5.a;

public abstract class n implements e {
    public final int a;
    public final String b;

    public n(String s, int v) {
        this.a = v;
        this.b = s;
        super();
    }

    @Override  // Nf.e
    public final String b(f f0) {
        return a.L(this, f0);
    }

    @Override  // Nf.e
    public final String getDescription() {
        return this.b;
    }
}

