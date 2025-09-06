package jf;

import kotlin.jvm.internal.q;
import we.n;

public final class a implements n {
    public final int a;
    public static final a b;
    public static final a c;

    static {
        a.b = new a(0);
        a.c = new a(1);
    }

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            q.g(((c)object0), "$this$loadConstantFromProperty");
            q.g(((p)object1), "it");
            return ((c)object0).b.get(((p)object1));
        }
        q.g(((c)object0), "$this$loadConstantFromProperty");
        q.g(((p)object1), "it");
        return ((c)object0).c.get(((p)object1));
    }
}

