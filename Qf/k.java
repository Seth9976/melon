package Qf;

import G7.c;
import Le.n;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.p;
import je.w;
import kotlin.jvm.internal.q;

public abstract class k {
    public static final i a;

    static {
        k.a = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final void a(AbstractCollection abstractCollection0, Object object0) {
        if(object0 != null) {
            abstractCollection0.add(object0);
        }
    }

    public void b(Object object0) {
    }

    public abstract boolean c(Object arg1);

    public static final List d(ArrayList arrayList0) {
        q.g(arrayList0, "<this>");
        switch(arrayList0.size()) {
            case 0: {
                return w.a;
            }
            case 1: {
                return e.k.z(p.k0(arrayList0));
            }
            default: {
                arrayList0.trimToSize();
                return arrayList0;
            }
        }
    }

    public static h e() {
        return new h(0);
    }

    public static Object f(Collection collection0, a a0, k k0) {
        c c0 = new c(1);
        for(Object object0: collection0) {
            k.g(object0, a0, c0, k0);
        }
        return k0.j();
    }

    public static void g(Object object0, a a0, c c0, k k0) {
        if(object0 == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'current\' of kotlin/reflect/jvm/internal/impl/utils/DFS.doDfs must not be null");
        }
        if(!c0.a.add(object0) || !k0.c(object0)) {
            return;
        }
        for(Object object1: a0.j(object0)) {
            k.g(object1, a0, c0, k0);
        }
        k0.b(object0);
    }

    public static Boolean h(Collection collection0, a a0, we.k k0) {
        return (Boolean)k.f(collection0, a0, new n(k0, ((Serializable)new boolean[1]), 1));
    }

    public static final boolean i(Throwable throwable0) {
        Class class0 = throwable0.getClass();
        do {
            if(q.b(class0.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
                return true;
            }
            class0 = class0.getSuperclass();
        }
        while(class0 != null);
        return false;
    }

    public abstract Object j();

    public static void k(Object object0) {
        if(object0 instanceof j) {
            throw ((j)object0).a;
        }
    }
}

