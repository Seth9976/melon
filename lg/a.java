package lg;

import com.google.firebase.messaging.u;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import je.p;
import kg.h;
import kg.l;
import kotlin.jvm.internal.q;
import pc.t;
import pg.c;

public final class a implements Runnable {
    public final c a;
    public final ReentrantLock b;
    public final Condition c;
    public final LinkedHashMap d;
    public final h e;
    public static final long f;

    static {
        a.f = TimeUnit.SECONDS.toMillis(10L);
    }

    public a(u u0, h h0) {
        q.g(u0, "taskExecutors");
        super();
        this.e = h0;
        this.a = new c(((t)u0.c));
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.b = reentrantLock0;
        this.c = reentrantLock0.newCondition();
        this.d = new LinkedHashMap();
    }

    public final void a() {
        long v = System.currentTimeMillis();
        LinkedHashMap linkedHashMap0 = this.d;
        Iterable iterable0 = linkedHashMap0.values();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            if(((l)object0).a.c() < v) {
                arrayList0.add(object0);
            }
        }
        for(Object object1: arrayList0) {
            linkedHashMap0.remove(((l)object1).j);
            this.e.invoke(((l)object1));
        }
    }

    public final void b() {
        LinkedHashMap linkedHashMap0 = this.d;
        if(linkedHashMap0.isEmpty()) {
            return;
        }
        Iterable iterable0 = linkedHashMap0.values();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(((l)object0).a.c());
        }
        Long long0 = (Long)p.v0(arrayList0);
        this.c.await(Math.max((long0 == null ? 0L : ((long)long0)) - System.currentTimeMillis() + a.f, a.f), TimeUnit.MILLISECONDS);
    }

    @Override
    public final void run() {
        Thread thread0 = Thread.currentThread();
        q.f(thread0, "it");
        thread0.setName("jeb-dexdec-sb-st-2455-device-holder");
        ReentrantLock reentrantLock0 = this.b;
        reentrantLock0.lock();
        try {
            while(!this.a.a()) {
                while(this.d.isEmpty()) {
                    this.c.await();
                }
                this.a();
                this.b();
            }
        }
        catch(InterruptedException unused_ex) {
        }
        finally {
            reentrantLock0.unlock();
        }
    }
}

