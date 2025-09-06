package Hf;

import gd.m7;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class t implements k {
    public final int a;
    public final k b;

    public t(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.d(((x)object0));
                return this.b.invoke(((x)object0)).toString();
            }
            case 1: {
                q.g(((String)object0), "tagSeq");
                m7 m70 = new m7(((String)object0));
                this.b.invoke(m70);
                return H.a;
            }
            default: {
                this.b.invoke(((Number)object0).intValue());
                return H.a;
            }
        }
    }
}

