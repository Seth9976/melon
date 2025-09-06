package W5;

import Q5.v;
import S5.b;
import X5.d;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class k implements b {
    public final Provider a;
    public final Provider b;
    public final v c;
    public final Provider d;

    public k(Provider provider0, Provider provider1, v v0, Provider provider2) {
        this.a = provider0;
        this.b = provider1;
        this.c = v0;
        this.d = provider2;
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        return new j(((Executor)this.a.get()), ((d)this.b.get()), ((c)this.c.get()), ((Y5.c)this.d.get()));
    }
}

