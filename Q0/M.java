package Q0;

import Q.c;
import android.content.res.Resources;
import ie.H;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kg.j;
import kg.p;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import pc.t;
import r1.d;
import u0.b;
import we.k;
import we.o;
import x0.e;

public final class m extends n implements o {
    public final int b;

    public m(int v, Object object0, Class class0, String s, String s1, int v1, int v2) {
        this.b = v2;
        super(v, v1, class0, object0, s, s1);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        p p0;
        switch(this.b) {
            case 0: {
                if(object0 != null) {
                    throw new ClassCastException();
                }
                Resources resources0 = ((u)this.receiver).getContext().getResources();
                b b1 = new b(new d(resources0.getDisplayMetrics().density, resources0.getConfiguration().fontScale), ((e)object1).a, ((k)object2));
                return Boolean.valueOf(I.a.a(((u)this.receiver), null, b1));
            }
            case 1: {
                long v2 = ((Number)object1).longValue();
                q.g(((p)object0), "p1");
                q.g(((List)object2), "p3");
                CopyOnWriteArraySet copyOnWriteArraySet0 = ((j)this.receiver).b;
                com.google.firebase.messaging.u u0 = ((j)this.receiver).m;
                for(Object object3: ((j)this.receiver).c) {
                    if(object3 != null) {
                        throw new ClassCastException();
                    }
                    ((t)u0.a).C(new c(((p)object0), v2, ((List)object2)));
                }
                if(!copyOnWriteArraySet0.isEmpty()) {
                    for(Object object4: ((List)object2)) {
                        String s = (String)((ie.m)object4).b;
                        kg.q q0 = (kg.q)((p)object0).d.get(((String)((ie.m)object4).a));
                        if(q0 != null && q0.a && s != null) {
                            for(Object object5: copyOnWriteArraySet0) {
                                if(object5 != null) {
                                    throw new ClassCastException();
                                }
                                ((t)u0.a).C(new X.k(((p)object0), v2, q0, s));
                            }
                        }
                    }
                }
                return H.a;
            }
            default: {
                long v = ((Number)object1).longValue();
                q.g(((String)object0), "p1");
                q.g(((List)object2), "p3");
                lg.b b0 = (lg.b)this.receiver;
                b0.getClass();
                b0.a.getClass();
                b0.a.b.lock();
                try {
                    lg.c c0 = (lg.c)b0.a.d.get(((String)object0));
                    p0 = c0 == null ? null : c0.d;
                }
                finally {
                    b0.a.b.unlock();
                }
                if(p0 != null) {
                    b0.c.invoke(p0, v, ((List)object2));
                    return true;
                }
                return false;
            }
        }
    }
}

