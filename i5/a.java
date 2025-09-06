package I5;

import M6.s;
import M6.x;
import R6.c;
import S8.b;
import U4.B;
import U4.k;
import U4.z;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Trace;
import androidx.lifecycle.L;
import androidx.media3.session.d0;
import androidx.media3.session.e;
import androidx.media3.session.f;
import androidx.media3.session.g0;
import androidx.media3.session.i0;
import androidx.media3.session.j0;
import androidx.media3.session.k0;
import androidx.media3.session.legacy.m;
import androidx.media3.session.legacy.o;
import androidx.media3.session.legacy.u;
import androidx.media3.session.n0;
import androidx.media3.session.s1;
import androidx.media3.session.w0;
import com.facebook.internal.security.OidcSecurityUtil;
import i.n.i.b.a.s.e.B2;
import i.n.i.b.a.s.e.X1;
import i.n.i.b.a.s.e.Y1;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import w1.j;

public final class a implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public a(k0 k00, w0 w00, m m0, String s, Bundle bundle0) {
        this.a = 6;
        super();
        this.c = k00;
        this.d = w00;
        this.e = m0;
        this.b = s;
        this.f = bundle0;
    }

    public a(k0 k00, w0 w00, u u0, Bundle bundle0, String s) {
        this.a = 5;
        super();
        this.c = k00;
        this.d = w00;
        this.e = u0;
        this.f = bundle0;
        this.b = s;
    }

    public a(Object object0, Object object1, Object object2, Object object3, Object object4, int v) {
        this.a = v;
        this.c = object0;
        this.d = object1;
        this.b = object2;
        this.e = object3;
        this.f = object4;
        super();
    }

    public a(Object object0, String s, Object object1, Object object2, Object object3, int v) {
        this.a = v;
        this.c = object0;
        this.b = s;
        this.d = object1;
        this.e = object2;
        this.f = object3;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                OidcSecurityUtil.a(((URL)this.c), ((H)this.d), ((String)this.b), ((ReentrantLock)this.e), ((Condition)this.f));
                return;
            }
            case 1: {
                String s = (String)this.b;
                we.a a0 = (we.a)this.d;
                L l0 = (L)this.e;
                j j0 = (j)this.f;
                ((k)this.c).getClass();
                boolean z = V4.u.x();
                try {
                    if(z) {
                        q.g(s, "label");
                        Trace.beginSection(V4.u.H(s));
                    }
                    try {
                        a0.invoke();
                        l0.postValue(B.b);
                        j0.a(B.b);
                    }
                    catch(Throwable throwable0) {
                        l0.postValue(new z(throwable0));
                        j0.c(throwable0);
                    }
                }
                finally {
                    if(z) {
                        Trace.endSection();
                    }
                }
                return;
            }
            case 2: {
                ((e)this.d).run().addListener(new D5.a(((com.google.firebase.messaging.u)this.c), ((AtomicBoolean)this.b), ((f)this.e), ((AtomicBoolean)this.f), 5), s.a);
                return;
            }
            case 3: {
                x x0 = ((k0)this.c).n.t(((w0)this.b), ((d0)this.e));
                ((AtomicReference)this.d).set(x0);
                ((b)this.f).d();
                return;
            }
            case 4: {
                k0 k00 = (k0)this.c;
                w0 w00 = (w0)this.d;
                o o0 = (o)this.e;
                Bundle bundle0 = (Bundle)this.f;
                s1 s10 = new s1(((String)this.b), Bundle.EMPTY);
                if(!k00.l.v(w00, s10)) {
                    o0.e();
                    return;
                }
                M6.B b0 = k00.n.q(w00, s10, bundle0);
                b0.addListener(new A3.m(17, b0, o0), s.a);
                return;
            }
            case 5: {
                s s1 = s.a;
                k0 k01 = (k0)this.c;
                w0 w01 = (w0)this.d;
                u u0 = (u)this.e;
                Bundle bundle1 = (Bundle)this.f;
                String s2 = (String)this.b;
                n0 n00 = k01.n;
                if(!k01.l.u(w01, 50003)) {
                    u0.f(null);
                    return;
                }
                if(bundle1 != null) {
                    bundle1.setClassLoader(n00.f.getClassLoader());
                    try {
                        int v1 = bundle1.getInt("android.media.browse.extra.PAGE");
                        int v2 = bundle1.getInt("android.media.browse.extra.PAGE_SIZE");
                        if(v1 >= 0 && v2 > 0) {
                            d0 d00 = androidx.media3.session.q.i(n00.f, bundle1);
                            M6.H h0 = e3.x.Y(k01.n.r(w01, s2, v1, v2, d00), new g0(k01, 1));
                            h0.addListener(new i0(h0, u0, 1), s1);
                            return;
                        }
                    }
                    catch(BadParcelableException unused_ex) {
                    }
                }
                M6.H h1 = e3.x.Y(k01.n.r(w01, s2, 0, 0x7FFFFFFF, null), new g0(k01, 1));
                h1.addListener(new i0(h1, u0, 1), s1);
                return;
            }
            case 6: {
                k0 k02 = (k0)this.c;
                w0 w02 = (w0)this.d;
                m m0 = (m)this.e;
                String s3 = (String)this.b;
                Bundle bundle2 = (Bundle)this.f;
                if(!k02.l.u(w02, 50005)) {
                    m0.f(null);
                    return;
                }
                e3.b.k(w02.d);
                synchronized(((j0)w02.d).a) {
                    c c0 = new c(19);
                    ((j0)w02.d).c.add(c0);
                }
                d0 d01 = androidx.media3.session.q.i(k02.n.f, bundle2);
                k02.n.z(w02, s3, d01);
                return;
            }
            default: {
                ((Y1)this.d).S(((X1)this.c).a, ((X1)this.c).b, ((UUID)this.b), ((B2)this.e), ((byte[])this.f));
            }
        }
    }
}

