package W5;

import Q5.v;
import R5.f;
import S5.b;
import X5.d;
import android.content.Context;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class i implements b {
    public final Provider a;
    public final Provider b;
    public final Provider c;
    public final v d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public i(Provider provider0, Provider provider1, Provider provider2, v v0, Provider provider3, Provider provider4, Provider provider5) {
        this.a = provider0;
        this.b = provider1;
        this.c = provider2;
        this.d = v0;
        this.e = provider3;
        this.f = provider4;
        this.g = provider5;
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        return new h(((Context)this.a.get()), ((f)this.b.get()), ((d)this.c.get()), ((c)this.d.get()), ((Executor)this.e.get()), ((Y5.c)this.f.get()), new R6.d(11), new R6.c(11), ((X5.c)this.g.get()));
    }
}

