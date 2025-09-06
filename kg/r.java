package kg;

import X2.k;
import d5.w;
import e1.x;
import e3.o;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import jg.c;
import jg.e;
import jg.f;
import kotlin.jvm.internal.q;
import lg.b;
import mg.d;

public final class r {
    public final l a;
    public final b b;
    public String c;
    public final p d;
    public static final long e;

    static {
        r.e = TimeUnit.SECONDS.toMillis(300L);
    }

    public r(p p0) {
        this.d = p0;
        this.a = p0.f;
        this.b = p0.f.f.l;
    }

    public final URL a(String s) {
        q.g(s, "url");
        String s1 = this.a.p == null ? this.a.b : this.a.p;
        return c.a(this.a.a.f(), s1, s);
    }

    public final o b(String s) {
        e e0 = new e("GET", "", "HTTP/1.1");
        o o0 = new o(e0, new d(e0, null));
        e0.a = "UNSUBSCRIBE";
        o0.h(this.a(this.d.k));
        o0.setHeader("SID", s);
        o0.setHeader("Content-Length", "0");
        return o0;
    }

    public final boolean c(String s) {
        q.g(s, "subscriptionId");
        e e0 = new e("GET", "", "HTTP/1.1");
        o o0 = new o(e0, new d(e0, null));
        e0.a = "SUBSCRIBE";
        p p0 = this.d;
        o0.h(this.a(p0.k));
        o0.setHeader("SID", s);
        o0.setHeader("TIMEOUT", "Second-300");
        o0.setHeader("Content-Length", "0");
        d5.e e1 = new Gf.l(false).h(0, o0);
        if(((f)e1.b).a != jg.b.d) {
            return false;
        }
        String s1 = ((d)e1.c).a.b("SID");
        long v = x.L(e1);
        if(q.b(s1, s) && v > 0L) {
            this.b.a.getClass();
            ReentrantLock reentrantLock0 = this.b.a.b;
            reentrantLock0.lock();
            try {
                r r0 = p0.a();
                lg.c c0 = (lg.c)this.b.a.d.get(r0.c);
                if(c0 != null) {
                    long v2 = System.currentTimeMillis();
                    c0.b = v2;
                    c0.e = v;
                    c0.c = v2 + v;
                }
                return true;
            }
            finally {
                reentrantLock0.unlock();
            }
        }
        return false;
    }

    public final boolean d(boolean z) {
        int v;
        String s = "";
        e e0 = new e("GET", "", "HTTP/1.1");
        o o0 = new o(e0, new d(e0, null));
        e0.a = "SUBSCRIBE";
        p p0 = this.d;
        o0.h(this.a(p0.k));
        o0.setHeader("NT", "upnp:event");
        InetAddress inetAddress0 = this.a.a.getLocalAddress();
        b b0 = this.b;
        if(inetAddress0 != null) {
            k k0 = b0.b;
            if(((pg.c)k0.f).e()) {
                ServerSocket serverSocket0 = (ServerSocket)k0.b;
                v = serverSocket0 == null ? 0 : serverSocket0.getLocalPort();
            }
            else {
                v = 0;
            }
            s = "<http://" + w.S(inetAddress0, v) + "/>";
        }
        o0.setHeader("CALLBACK", s);
        o0.setHeader("TIMEOUT", "Second-300");
        o0.setHeader("Content-Length", "0");
        d5.e e1 = new Gf.l(false).h(0, o0);
        if(((f)e1.b).a != jg.b.d) {
            return false;
        }
        String s1 = ((d)e1.c).a.b("SID");
        long v1 = x.L(e1);
        if(s1 != null && s1.length() != 0 && v1 > 0L) {
            this.c = s1;
            lg.d d0 = b0.a;
            d0.getClass();
            ReentrantLock reentrantLock0 = d0.b;
            reentrantLock0.lock();
            try {
                String s2 = p0.a().c;
                if(s2 != null && s2.length() != 0) {
                    lg.c c0 = new lg.c(p0, v1, z);
                    d0.d.put(s2, c0);
                    d0.c.signalAll();
                    return true;
                }
                return true;
            }
            finally {
                reentrantLock0.unlock();
            }
        }
        return false;
    }

    public final boolean e() {
        String s = this.c;
        if(s != null && s.length() != 0) {
            try {
                o o0 = this.b(s);
                d5.e e0 = new Gf.l(false).h(0, o0);
                this.b.d(this.d);
                this.c = null;
                return ((f)e0.b).a != jg.b.d ? false : true;
            }
            catch(IOException unused_ex) {
                Arrays.copyOf(new Object[0], 0);
            }
            return false;
        }
        return false;
    }
}

