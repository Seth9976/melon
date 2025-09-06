package hd;

import ie.H;
import kotlin.jvm.internal.F;
import we.a;
import we.k;

public final class m0 implements a {
    public final int a;
    public final F b;
    public final k c;
    public final String d;
    public final String e;

    public m0(F f0, k k0, String s, String s1, int v) {
        this.a = v;
        this.b = f0;
        this.c = k0;
        this.d = s;
        this.e = s1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                k k1 = this.c;
                String s2 = this.d;
                String s3 = this.e;
                if(this.b.a == 0) {
                    k1.invoke(new y0(s2, s3));
                    return H.a;
                }
                k1.invoke(new v0(s2, s3, 0));
                return H.a;
            }
            case 1: {
                k k2 = this.c;
                String s4 = this.d;
                String s5 = this.e;
                if(this.b.a == 0) {
                    k2.invoke(new x0(s4, s5));
                    return H.a;
                }
                k2.invoke(new v0(s4, s5, 3));
                return H.a;
            }
            default: {
                k k0 = this.c;
                String s = this.d;
                String s1 = this.e;
                if(this.b.a == 0) {
                    k0.invoke(new s0(s, s1));
                    return H.a;
                }
                k0.invoke(new v0(s, s1, 1));
                return H.a;
            }
        }
    }
}

