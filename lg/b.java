package lg;

import Q0.m;
import X2.k;
import com.google.firebase.messaging.u;
import java.util.concurrent.locks.ReentrantLock;
import kb.D;
import kg.p;
import kg.r;
import kotlin.jvm.internal.q;

public final class b {
    public final d a;
    public final k b;
    public final m c;

    public b(u u0, m m0, D d0) {
        q.g(u0, "taskExecutors");
        super();
        this.c = m0;
        this.a = new d(u0);
        this.b = new k(u0, new m(3, this, b.class, "onEventReceived", "onEventReceived$mmupnp(Ljava/lang/String;JLjava/util/List;)Z", 0, 2));
    }

    public final void a() {
    }

    public final void b() {
        this.a.a.c(this.a);
    }

    public final void c(p p0) {
        d d0 = this.a;
        d0.getClass();
        ReentrantLock reentrantLock0 = d0.b;
        reentrantLock0.lock();
        try {
            r r0 = p0.a();
            c c0 = (c)d0.d.get(r0.c);
            if(c0 != null) {
                c0.f = true;
            }
            d0.c.signalAll();
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void d(p p0) {
        q.g(p0, "service");
        this.a.b(p0);
    }
}

