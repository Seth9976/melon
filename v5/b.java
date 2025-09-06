package V5;

import Q5.v;
import R5.f;
import W5.c;
import X5.d;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class b implements S5.b {
    public final Provider a;
    public final Provider b;
    public final v c;
    public final Provider d;
    public final Provider e;

    public b(Provider provider0, Provider provider1, v v0, Provider provider2, Provider provider3) {
        this.a = provider0;
        this.b = provider1;
        this.c = v0;
        this.d = provider2;
        this.e = provider3;
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        return new a(((Executor)this.a.get()), ((f)this.b.get()), ((c)this.c.get()), ((d)this.d.get()), ((Y5.c)this.e.get()));
    }
}

