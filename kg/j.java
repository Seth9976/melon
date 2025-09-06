package kg;

import Q0.m;
import Q8.h;
import com.google.firebase.messaging.u;
import e1.F;
import e1.n;
import gd.k4;
import i.n.i.b.a.s.e.Ga;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import k8.Y;
import kb.D;
import kotlin.jvm.internal.q;
import lg.a;
import lg.b;
import og.e;
import og.f;
import pc.t;
import pg.d;

public final class j {
    public final CopyOnWriteArraySet a;
    public final CopyOnWriteArraySet b;
    public final CopyOnWriteArraySet c;
    public final h d;
    public final h e;
    public final LinkedHashMap f;
    public final LinkedHashMap g;
    public final AtomicBoolean h;
    public final AtomicBoolean i;
    public final a j;
    public final List k;
    public final b l;
    public final u m;

    static {
    }

    public j(List list0, D d0) {
        Y.r(com.iloen.melon.utils.a.a, "protocol");
        q.g(list0, "interfaces");
        super();
        this.h = new AtomicBoolean();
        this.i = new AtomicBoolean();
        if((list0 instanceof Collection ? !list0.isEmpty() : list0.iterator().hasNext()) == 0) {
            throw new IllegalStateException("no valid network interface.");
        }
        this.a = new CopyOnWriteArraySet();
        this.b = new CopyOnWriteArraySet();
        this.c = new CopyOnWriteArraySet();
        new CopyOnWriteArraySet();
        this.f = new LinkedHashMap();
        List list1 = Collections.synchronizedList(new ArrayList());
        q.f(list1, "Collections.synchronizedList(mutableListOf())");
        this.k = list1;
        u u0 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        u0.a = new t(((Ga)d0.b), 1);
        pg.b b0 = new pg.b("io-", 1);
        d d1 = new d();
        u0.b = new t(new pg.a(new ThreadPoolExecutor(0, Math.max(2, Runtime.getRuntime().availableProcessors()) * 2, 15L, TimeUnit.SECONDS, d1, b0, d1), true), 1);
        TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
        u0.c = new t(new pg.a(new ThreadPoolExecutor(0, 0x7FFFFFFF, 0L, timeUnit0, new SynchronousQueue(), new pg.b("mg-", 1)), false), 1);
        u0.d = new t(new pg.a(new ThreadPoolExecutor(0, 0x7FFFFFFF, 0L, timeUnit0, new SynchronousQueue(), new pg.b("sv-", 2)), true), 1);
        this.m = u0;
        this.g = new LinkedHashMap();
        kg.h h0 = new kg.h(this, 0);
        Y.r(3, "protocol");
        q.g(list0, "interfaces");
        h h1 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h1.a = n.m(list0, new og.h(u0, h0, 0), new og.h(u0, h0, 1));
        this.d = h1;
        kg.h h2 = new kg.h(this, 1);
        Y.r(3, "protocol");
        q.g(list0, "interfaces");
        h h3 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h3.a = n.m(list0, new f(u0, h2, 0), new f(u0, h2, 1));
        this.e = h3;
        for(Object object0: h3.a) {
            ((e)object0).getClass();
        }
        kg.h h4 = new kg.h(this, 2);
        q.g(this.m, "taskExecutors");
        this.j = new a(this.m, h4);
        m m0 = new m(3, this, j.class, "onReceiveEvent", "onReceiveEvent(Lnet/mm2d/upnp/Service;JLjava/util/List;)V", 0, 1);
        q.g(this.m, "taskExecutors");
        this.l = new b(this.m, m0, d0);
    }

    public final void a(l l0) {
        l l1;
        String s = l0.j;
        a a0 = this.j;
        a0.getClass();
        LinkedHashMap linkedHashMap0 = a0.d;
        q.g(s, "udn");
        ReentrantLock reentrantLock0 = a0.b;
        reentrantLock0.lock();
        try {
            l1 = (l)linkedHashMap0.get(s);
        }
        catch(Throwable throwable0) {
            reentrantLock0.unlock();
            throw throwable0;
        }
        reentrantLock0.unlock();
        if(l1 != null) {
            l1.a.a();
        }
        reentrantLock0.lock();
        try {
            linkedHashMap0.put(s, l0);
            a0.c.signalAll();
        }
        catch(Throwable throwable1) {
            reentrantLock0.unlock();
            throw throwable1;
        }
        reentrantLock0.unlock();
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        F.n(l0, linkedHashSet0);
        for(Object object0: linkedHashSet0) {
            this.f.put(((String)object0), l0);
        }
        ((t)this.m.a).C(new i(this, l0, 0));
    }

    public final void b(l l0) {
        q.g(l0, "device");
        synchronized(this.j) {
            for(Object object0: l0.c) {
                this.l.d(((p)object0));
            }
            LinkedHashSet linkedHashSet0 = new LinkedHashSet();
            F.n(l0, linkedHashSet0);
            for(Object object1: linkedHashSet0) {
                this.f.remove(((String)object1));
            }
            this.j.getClass();
            ReentrantLock reentrantLock0 = this.j.b;
            reentrantLock0.lock();
            try {
                l l1 = (l)this.j.d.remove(l0.j);
            }
            catch(Throwable throwable0) {
                reentrantLock0.unlock();
                throw throwable0;
            }
            reentrantLock0.unlock();
        }
        ((t)this.m.a).C(new i(this, l0, 1));
    }

    public final boolean c(jg.h h0, jg.h h1) {
        q.g(h0, "oldMessage");
        q.g(h1, "newMessage");
        InetAddress inetAddress0 = h1.getLocalAddress();
        if(com.iloen.melon.utils.a.a == 1) {
            return inetAddress0 instanceof Inet4Address;
        }
        InetAddress inetAddress1 = h0.getLocalAddress();
        if(inetAddress1 instanceof Inet4Address) {
            return ((Inet4Address)inetAddress1).isLinkLocalAddress() ? true : inetAddress0 instanceof Inet4Address;
        }
        return inetAddress0 instanceof Inet6Address || inetAddress0 != null && !inetAddress0.isLinkLocalAddress();
    }

    public final void d(jg.h h0) {
        String s = h0.e();
        boolean z = q.b(h0.b(), "ssdp:byebye");
        LinkedHashMap linkedHashMap0 = this.g;
        if(z) {
            linkedHashMap0.remove(s);
            return;
        }
        k k0 = (k)linkedHashMap0.get(s);
        if(k0 == null) {
            k k1 = new k(this, h0);
            q.g(s, "uuid");
            linkedHashMap0.put(s, k1);
            if(!((t)this.m.b).C(new k4(6, this, k1))) {
                linkedHashMap0.remove(s);
            }
        }
        else if(this.c(k0.o, h0)) {
            k0.c(h0);
        }
    }

    public final void e(jg.h h0) {
        q.g(h0, "message");
        synchronized(this.j) {
            String s = h0.e();
            l l0 = (l)this.f.get(s);
            if(l0 == null) {
                this.d(h0);
                return;
            }
            if(q.b(h0.b(), "ssdp:byebye")) {
                l0.a.a();
                this.b(l0);
            }
            else if(this.c(l0.a, h0)) {
                l0.c(h0);
            }
        }
    }
}

