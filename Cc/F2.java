package Cc;

import G.e;
import we.a;
import y0.i;

public final class f2 implements a {
    public final int a;
    public final e b;
    public final i c;
    public final Cc.a d;

    public f2(e e0, i i0, Cc.a a0, int v) {
        this.a = v;
        this.b = e0;
        this.c = i0;
        this.d = a0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return u2.e(0.0f, ((Number)this.b.d()).floatValue(), this.c, this.d);
            }
            case 1: {
                return u2.e(0.25f, ((Number)this.b.d()).floatValue(), this.c, this.d);
            }
            case 2: {
                return u2.e(0.5f, ((Number)this.b.d()).floatValue(), this.c, this.d);
            }
            default: {
                return u2.e(0.75f, ((Number)this.b.d()).floatValue(), this.c, this.d);
            }
        }
    }
}

