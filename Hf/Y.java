package Hf;

import Af.p;
import If.f;
import java.util.List;
import kotlin.jvm.internal.q;
import we.k;

public final class y implements k {
    public final int a;
    public final M b;
    public final List c;

    public y(p p0, I i0, M m0, List list0, boolean z) {
        this.a = 1;
        super();
        this.b = m0;
        this.c = list0;
    }

    public y(I i0, M m0, List list0, boolean z) {
        this.a = 0;
        super();
        this.b = m0;
        this.c = list0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((f)object0), "kotlinTypeRefiner");
            this.b.e();
            return null;
        }
        q.g(((f)object0), "refiner");
        this.b.e();
        return null;
    }
}

