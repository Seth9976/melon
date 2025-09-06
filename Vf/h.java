package vf;

import Hf.x;
import Me.z;
import kotlin.jvm.internal.q;
import we.k;

public final class h implements k {
    public final int a;
    public final Object b;

    public h(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((z)object0), "it");
            return (x)this.b;
        }
        q.g(((z)object0), "it");
        return ((z)object0).d().r(((Je.k)this.b));
    }
}

