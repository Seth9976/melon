package tg;

import java.lang.reflect.Type;

public final class i implements f {
    public final int a;
    public final Type b;

    public i(int v, Type type0) {
        this.a = v;
        this.b = type0;
        super();
    }

    @Override  // tg.f
    public final Object adapt(d d0) {
        if(this.a != 0) {
            j j0 = new j(((z)d0));
            ((z)d0).enqueue(new h(j0, 1));
            return j0;
        }
        j j1 = new j(((z)d0));
        ((z)d0).enqueue(new h(j1, 0));
        return j1;
    }

    @Override  // tg.f
    public final Type responseType() {
        return this.b;
    }
}

