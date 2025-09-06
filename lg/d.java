package lg;

import com.google.firebase.messaging.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kg.p;
import kg.r;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import pc.t;
import pg.c;

public final class d implements Runnable {
    public final c a;
    public final ReentrantLock b;
    public final Condition c;
    public final LinkedHashMap d;
    public static final long e;

    static {
        d.e = TimeUnit.SECONDS.toMillis(1L);
    }

    public d(u u0) {
        q.g(u0, "taskExecutors");
        super();
        this.a = new c(((t)u0.c));
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.b = reentrantLock0;
        this.c = reentrantLock0.newCondition();
        this.d = new LinkedHashMap();
    }

    public final long a() {
        Object object0;
        Iterator iterator0 = this.d.values().iterator();
        if(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            if(iterator0.hasNext()) {
                long v = ((lg.c)object1).f ? ((lg.c)object1).a() : ((lg.c)object1).c;
                while(true) {
                    Object object2 = iterator0.next();
                    lg.c c0 = (lg.c)object2;
                    long v1 = c0.f ? c0.a() : c0.c;
                    if(v > v1) {
                        object1 = object2;
                        v = v1;
                    }
                    if(!iterator0.hasNext()) {
                        break;
                    }
                }
            }
            object0 = object1;
        }
        else {
            object0 = null;
        }
        if(((lg.c)object0) != null) {
            return ((lg.c)object0).f ? ((lg.c)object0).a() : ((lg.c)object0).c;
        }
        return 0L;
    }

    public final void b(p p0) {
        q.g(p0, "service");
        ReentrantLock reentrantLock0 = this.b;
        reentrantLock0.lock();
        try {
            LinkedHashMap linkedHashMap0 = this.d;
            String s = p0.a().c;
            if(linkedHashMap0 != null) {
                if(((lg.c)N.c(linkedHashMap0).remove(s)) != null) {
                    this.c.signalAll();
                }
                return;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final void c() {
        ReentrantLock reentrantLock0 = this.b;
        reentrantLock0.lock();
        try {
            long v1 = System.currentTimeMillis();
            Iterable iterable0 = this.d.values();
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: iterable0) {
                if(((lg.c)object0).c < v1) {
                    arrayList0.add(object0);
                }
            }
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object1: arrayList0) {
                arrayList1.add(((lg.c)object1).d);
            }
            for(Object object2: arrayList1) {
                this.b(((p)object2));
                ((p)object2).a().e();
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void d(ArrayList arrayList0) {
        boolean z1;
        boolean z;
        for(Object object0: arrayList0) {
            lg.c c0 = (lg.c)object0;
            p p0 = c0.d;
            if(!c0.f || c0.a() > System.currentTimeMillis()) {
                z1 = true;
            }
            else {
                r r0 = p0.a();
                r0.getClass();
                try {
                    String s = r0.c;
                    z = s == null || s.length() == 0 ? r0.d(false) : r0.c(s);
                }
                catch(IOException iOException0) {
                    d8.d.D(6, iOException0, "fail to renewSubscribe", Arrays.copyOf(new Object[0], 0));
                    z = false;
                }
                if(z) {
                    c0.a = 0;
                    z1 = true;
                }
                else {
                    ++c0.a;
                    z1 = false;
                }
            }
            if(!z1 && c0.a >= 2) {
                this.b(p0);
            }
        }
    }

    public final void e() {
        ReentrantLock reentrantLock0 = this.b;
        reentrantLock0.lock();
        try {
            if(this.d.isEmpty()) {
                return;
            }
            long v1 = Math.max(this.a() - System.currentTimeMillis(), d.e);
            this.c.await(v1, TimeUnit.MILLISECONDS);
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override
    public final void run() {
        ArrayList arrayList0;
        Thread thread0 = Thread.currentThread();
        q.f(thread0, "it");
        thread0.setName("jeb-dexdec-sb-st-2447-subscribe-holder");
        try {
            while(!this.a.a()) {
                LinkedHashMap linkedHashMap0 = this.d;
                ReentrantLock reentrantLock0 = this.b;
                reentrantLock0.lock();
                try {
                    while(linkedHashMap0.isEmpty()) {
                        this.c.await();
                    }
                    arrayList0 = new ArrayList(linkedHashMap0.values());
                }
                finally {
                    reentrantLock0.unlock();
                }
                this.d(arrayList0);
                this.c();
                this.e();
            }
        }
        catch(InterruptedException unused_ex) {
        }
    }
}

