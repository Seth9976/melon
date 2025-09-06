package com.google.firebase;

import X6.a;
import X6.b;
import X6.c;
import X6.d;
import Y6.s;
import Y6.u;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.ExecutorsKt;

public final class f implements Y6.f {
    public final int a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;

    static {
        f.b = new f(0);
        f.c = new f(1);
        f.d = new f(2);
        f.e = new f(3);
    }

    public f(int v) {
        this.a = v;
        super();
    }

    @Override  // Y6.f
    public final Object c(u u0) {
        switch(this.a) {
            case 0: {
                Object object1 = u0.d(new s(a.class, Executor.class));
                q.f(object1, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.from(((Executor)object1));
            }
            case 1: {
                Object object2 = u0.d(new s(c.class, Executor.class));
                q.f(object2, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.from(((Executor)object2));
            }
            case 2: {
                Object object3 = u0.d(new s(b.class, Executor.class));
                q.f(object3, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.from(((Executor)object3));
            }
            default: {
                Object object0 = u0.d(new s(d.class, Executor.class));
                q.f(object0, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.from(((Executor)object0));
            }
        }
    }
}

