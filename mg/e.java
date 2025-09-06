package mg;

import Tf.o;
import Tf.v;
import ie.m;
import java.io.ByteArrayOutputStream;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jg.d;
import jg.h;
import kotlin.jvm.internal.q;

public final class e implements h {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final d e;
    public final InetAddress f;

    public e(d d0, InetAddress inetAddress0) {
        m m0;
        this.e = d0;
        this.f = inetAddress0;
        String s = null;
        if(inetAddress0 == null) {
            this.a = 0L;
            this.b = "";
            this.c = "";
            this.d = null;
            return;
        }
        String s1 = d0.f("Cache-Control");
        if(s1 != null) {
            Locale locale0 = Locale.US;
            q.f(locale0, "Locale.US");
            s = s1.toLowerCase(locale0);
            q.f(s, "(this as java.lang.String).toLowerCase(locale)");
        }
        int v = 1800;
        if(s != null && v.r0(s, "max-age", false)) {
            Integer integer0 = v.t0(o.W0('=', s, ""));
            if(integer0 != null) {
                v = (int)integer0;
            }
        }
        this.a = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(((long)v));
        String s2 = d0.f("USN");
        if(s2 == null || s2.length() == 0 || !v.r0(s2, "uuid", false)) {
            m0 = new m("", "");
        }
        else {
            int v1 = o.F0(s2, "::", 0, false, 6);
            if(v1 < 0) {
                m0 = new m(s2, "");
            }
            else {
                String s3 = s2.substring(0, v1);
                q.f(s3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String s4 = s2.substring(v1 + 2);
                q.f(s4, "(this as java.lang.String).substring(startIndex)");
                m0 = new m(s3, s4);
            }
        }
        String s5 = (String)m0.b;
        this.b = (String)m0.a;
        this.c = d0.f("NTS");
        this.d = d0.f("LOCATION");
    }

    @Override  // jg.h
    public final void a() {
    }

    @Override  // jg.h
    public final String b() {
        return this.c;
    }

    @Override  // jg.h
    public final long c() {
        return this.a;
    }

    @Override  // jg.h
    public final void d(ByteArrayOutputStream byteArrayOutputStream0) {
        this.e.d(byteArrayOutputStream0);
    }

    @Override  // jg.h
    public final String e() {
        return this.b;
    }

    @Override  // jg.h
    public final int f() {
        InetAddress inetAddress0 = this.f instanceof Inet6Address ? this.f : null;
        return ((Inet6Address)inetAddress0) == null ? 0 : ((Inet6Address)inetAddress0).getScopeId();
    }

    @Override  // jg.h
    public final String g() {
        return this.d;
    }

    @Override  // jg.h
    public final String getHeader() {
        return this.e.f("X-TelepathyAddress.sony.com");
    }

    @Override  // jg.h
    public final InetAddress getLocalAddress() {
        return this.f;
    }

    @Override
    public final String toString() {
        return this.e.toString();
    }
}

