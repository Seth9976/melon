package Q5;

import S5.b;
import W5.a;
import W5.c;
import W5.h;
import W5.i;
import W5.j;
import W5.k;
import X5.d;
import android.content.Context;
import javax.inject.Provider;

public final class v implements b {
    public final int a;
    public final Provider b;
    public final Provider c;
    public final b d;

    public v(Provider provider0, Provider provider1, b b0, int v) {
        this.a = v;
        this.b = provider0;
        this.c = provider1;
        this.d = b0;
        super();
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        return this.a != 0 ? new c(((Context)this.b.get()), ((d)this.c.get()), ((a)((p)this.d).get())) : new u(new R6.d(11), new R6.c(11), ((V5.c)((V5.b)this.b).get()), ((h)((i)this.c).get()), ((j)((k)this.d).get()));
    }
}

