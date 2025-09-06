package R5;

import R6.c;
import R6.d;
import S5.b;
import X5.a;
import X5.j;
import X5.l;
import android.content.Context;
import javax.inject.Provider;

public final class g implements b {
    public final int a;
    public final Provider b;
    public final Provider c;

    public g(Provider provider0, Provider provider1, int v) {
        this.a = v;
        this.b = provider0;
        this.c = provider1;
        super();
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        if(this.a != 0) {
            d d0 = new d(11);
            c c0 = new c(11);
            Object object0 = this.b.get();
            return new j(d0, c0, a.f, ((l)object0), this.c);
        }
        R5.d d1 = (R5.d)((e)this.c).get();
        return new f(((Context)((e)this.b).b), d1);
    }
}

