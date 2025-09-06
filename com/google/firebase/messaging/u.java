package com.google.firebase.messaging;

import A0.c;
import Df.e;
import F.a0;
import F.b0;
import Gf.m;
import Me.B;
import Me.C;
import Me.z;
import P0.c0;
import W.p;
import android.content.Context;
import android.util.Log;
import androidx.collection.f;
import androidx.media3.session.legacy.V;
import androidx.media3.session.n0;
import androidx.media3.session.s1;
import androidx.media3.session.t1;
import androidx.media3.session.w0;
import b3.N;
import cf.a;
import com.iloen.melon.utils.log.LogU;
import e3.x;
import ie.H;
import ie.j;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import jf.l;
import jf.n;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.sync.Mutex;
import l2.M;
import l2.d;
import l2.i0;
import lf.k;
import qf.b;

public final class u implements e, n {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public static u e;

    public u(c c0) {
        this.a = c0;
    }

    public u(m m0, z z0) {
        q.g(z0, "module");
        super();
        this.a = m0;
        this.b = z0;
        this.c = m0.b(new B(this, 0));
        this.d = m0.b(new B(this, 1));
    }

    public u(p p0, jf.p p1) {
        this.d = p0;
        super();
        this.c = p0;
        this.a = p1;
        this.b = new ArrayList();
    }

    public u(n0 n00) {
        this.b = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.c = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.a = new Object();
        this.d = new WeakReference(n00);
    }

    public u(a a0, cf.e e0, j j0) {
        q.g(e0, "typeParameterResolver");
        super();
        this.a = a0;
        this.b = e0;
        this.c = j0;
        q.g(e0, "typeParameterResolver");
        V v0 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
        v0.a = this;
        v0.b = e0;
        v0.c = new ea.c(new ef.e());  // 初始化器: Ljava/lang/Object;-><init>()V
        this.d = v0;
    }

    public u(String s, FileInputStream fileInputStream0) {
        this.d = new Properties();
        this.a = s;
        this.b = "audio/*";
        this.c = fileInputStream0;
    }

    public u(String s, String s1, String s2) {
        this.d = new Properties();
        this.a = s;
        this.b = s1;
        try {
            this.c = new ByteArrayInputStream(s2.getBytes("UTF-8"));
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            LogU.e("HttpServer", unsupportedEncodingException0.getMessage(), unsupportedEncodingException0);
        }
    }

    public u(Method method0, Method method1, Method method2, Method method3) {
        this.a = method0;
        this.b = method1;
        this.c = method2;
        this.d = method3;
    }

    @Override  // jf.n
    public l a(b b0, Re.a a0) {
        return ((E9.u)((p)this.c).a).C(b0, a0, ((ArrayList)this.b));
    }

    public void b(Object object0, w0 w00, t1 t10, N n0) {
        synchronized(this.a) {
            w0 w01 = this.l(object0);
            if(w01 == null) {
                ((f)this.b).put(object0, w00);
                ((f)this.c).put(w00, new androidx.media3.session.f(object0, new c0(), t10, n0));
            }
            else {
                androidx.media3.session.f f0 = (androidx.media3.session.f)((f)this.c).get(w01);
                e3.b.k(f0);
                f0.d = t10;
                f0.e = n0;
            }
        }
    }

    public void c(String s, String s1) {
        ((Properties)this.d).put(s, s1);
    }

    public void d(w0 w00, int v, androidx.media3.session.e e0) {
        synchronized(this.a) {
            androidx.media3.session.f f0 = (androidx.media3.session.f)((f)this.c).get(w00);
            if(f0 != null) {
                N n0 = f0.g;
                n0.getClass();
                b3.l l0 = new b3.l(0);
                l0.d(n0.a);
                l0.c(v);
                f0.g = new N(l0.f());
                f0.c.add(e0);
            }
        }
    }

    public Object e(oe.c c0) {
        u u0;
        l2.j j0;
        M m0 = (M)this.d;
        if(c0 instanceof l2.j) {
            j0 = (l2.j)c0;
            int v = j0.D;
            if((v & 0x80000000) == 0) {
                j0 = new l2.j(this, c0);
            }
            else {
                j0.D = v ^ 0x80000000;
            }
        }
        else {
            j0 = new l2.j(this, c0);
        }
        Object object0 = j0.w;
        ne.a a0 = ne.a.a;
        switch(j0.D) {
            case 0: {
                d5.n.D(object0);
                List list0 = (List)this.c;
                if(list0 == null || list0.isEmpty()) {
                    j0.r = this;
                    j0.D = 1;
                    object0 = M.f(m0, false, j0);
                    if(object0 == a0) {
                        return a0;
                    }
                }
                else {
                    i0 i00 = m0.g();
                    l2.m m1 = new l2.m(m0, this, null);
                    j0.r = this;
                    j0.D = 2;
                    object0 = i00.b(m1, j0);
                    if(object0 == a0) {
                        return a0;
                    }
                }
                u0 = this;
                break;
            }
            case 1: {
                u0 = j0.r;
                d5.n.D(object0);
                break;
            }
            case 2: {
                u0 = j0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((M)u0.d).h.d(((d)object0));
        return H.a;
    }

    @Override  // Df.e
    public Df.d f(b b0) {
        q.g(b0, "classId");
        k k0 = (k)((LinkedHashMap)this.d).get(b0);
        if(k0 == null) {
            return null;
        }
        d5.e e0 = (d5.e)this.a;
        mf.a a0 = (mf.a)this.b;
        ((Df.z)this.c).invoke(b0);
        return new Df.d(e0, k0, a0, Me.N.q);
    }

    public void g(androidx.media3.session.f f0) {
        n0 n00 = (n0)((WeakReference)this.d).get();
        if(n00 != null) {
            AtomicBoolean atomicBoolean0 = new AtomicBoolean(true);
            while(atomicBoolean0.get()) {
                atomicBoolean0.set(false);
                Object object0 = f0.c.poll();
                if(((androidx.media3.session.e)object0) == null) {
                    f0.f = false;
                    return;
                }
                AtomicBoolean atomicBoolean1 = new AtomicBoolean(true);
                A3.m m0 = new A3.m(n00, this.l(f0.a), new I5.a(this, ((androidx.media3.session.e)object0), atomicBoolean1, f0, atomicBoolean0, 2));
                x.P(n00.l, m0);
                atomicBoolean1.set(false);
            }
        }
    }

    public void h(w0 w00) {
        synchronized(this.a) {
            androidx.media3.session.f f0 = (androidx.media3.session.f)((f)this.c).get(w00);
            if(f0 == null) {
                return;
            }
            N n0 = f0.g;
            f0.g = N.b;
            androidx.media3.session.c c0 = new androidx.media3.session.c(this, w00, n0);
            f0.c.add(c0);
            if(f0.f) {
                return;
            }
            f0.f = true;
            this.g(f0);
        }
    }

    public N i(w0 w00) {
        synchronized(this.a) {
            androidx.media3.session.f f0 = (androidx.media3.session.f)((f)this.c).get(w00);
            return f0 != null ? f0.e : null;
        }
    }

    public Me.e j(b b0, List list0) {
        q.g(b0, "classId");
        return (Me.e)((Gf.e)this.d).invoke(new C(b0, list0));
    }

    public I6.V k() {
        synchronized(this.a) {
        }
        return I6.V.p(((f)this.b).values());
    }

    public w0 l(Object object0) {
        synchronized(this.a) {
        }
        return (w0)((f)this.b).get(object0);
    }

    public static u m() {
        synchronized(u.class) {
            if(u.e == null) {
                u u0 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
                u0.a = null;
                u0.b = null;
                u0.c = null;
                u0.d = new ArrayDeque();
                u.e = u0;
            }
            return u.e;
        }
    }

    public c0 n(w0 w00) {
        synchronized(this.a) {
            androidx.media3.session.f f0 = (androidx.media3.session.f)((f)this.c).get(w00);
            return f0 == null ? null : f0.b;
        }
    }

    public G.u o(G.u u0, G.u u1) {
        if(((G.u)this.d) == null) {
            this.d = u0.c();
        }
        G.u u2 = (G.u)this.d;
        if(u2 != null) {
            int v = u2.b();
            int v1 = 0;
            while(v1 < v) {
                G.u u3 = (G.u)this.d;
                if(u3 != null) {
                    c c0 = (c)this.a;
                    float f = u0.a(v1);
                    float f1 = u1.a(v1);
                    b0 b00 = (b0)c0.b;
                    double f2 = b00.b(f1);
                    u3.e(Math.signum(f1) * ((float)(Math.exp(((double)F.c0.a) / (((double)F.c0.a) - 1.0) * f2) * ((double)(b00.a * b00.b)))) + f, v1);
                    ++v1;
                    continue;
                }
                q.m("targetVector");
                throw null;
            }
            G.u u4 = (G.u)this.d;
            if(u4 != null) {
                return u4;
            }
            q.m("targetVector");
            throw null;
        }
        q.m("targetVector");
        throw null;
    }

    public G.u p(long v, G.u u0, G.u u1) {
        if(((G.u)this.c) == null) {
            this.c = u0.c();
        }
        G.u u2 = (G.u)this.c;
        if(u2 != null) {
            int v1 = u2.b();
            int v2 = 0;
            while(v2 < v1) {
                G.u u3 = (G.u)this.c;
                if(u3 != null) {
                    c c0 = (c)this.a;
                    u0.getClass();
                    float f = u1.a(v2);
                    a0 a00 = ((b0)c0.b).a(f);
                    F.a a0 = F.b.a((a00.c <= 0L ? 1.0f : ((float)(v / 1000000L)) / ((float)a00.c)));
                    u3.e(Math.signum(a00.a) * a0.b * a00.b / ((float)a00.c) * 1000.0f, v2);
                    ++v2;
                    continue;
                }
                q.m("velocityVector");
                throw null;
            }
            G.u u4 = (G.u)this.c;
            if(u4 != null) {
                return u4;
            }
            q.m("velocityVector");
            throw null;
        }
        q.m("velocityVector");
        throw null;
    }

    public boolean q(Context context0) {
        if(((Boolean)this.c) == null) {
            this.c = Boolean.valueOf(context0.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if(!((Boolean)this.b).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean)this.c).booleanValue();
    }

    public boolean r(Context context0) {
        if(((Boolean)this.b) == null) {
            this.b = Boolean.valueOf(context0.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if(!((Boolean)this.b).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean)this.b).booleanValue();
    }

    public boolean s(w0 w00) {
        synchronized(this.a) {
            return ((f)this.c).get(w00) != null;
        }
    }

    public boolean t(w0 w00, int v) {
        androidx.media3.session.f f0;
        synchronized(this.a) {
            f0 = (androidx.media3.session.f)((f)this.c).get(w00);
        }
        n0 n00 = (n0)((WeakReference)this.d).get();
        return f0 != null && f0.e.a(v) && n00 != null && n00.t.y().a(v);
    }

    public boolean u(w0 w00, int v) {
        androidx.media3.session.f f0;
        synchronized(this.a) {
            f0 = (androidx.media3.session.f)((f)this.c).get(w00);
        }
        return f0 != null && f0.d.a(v);
    }

    public boolean v(w0 w00, s1 s10) {
        androidx.media3.session.f f0;
        synchronized(this.a) {
            f0 = (androidx.media3.session.f)((f)this.c).get(w00);
        }
        if(f0 != null) {
            I6.b0 b00 = f0.d.a;
            s10.getClass();
            return b00.contains(s10);
        }
        return false;
    }

    public void w(w0 w00) {
        androidx.media3.session.f f0;
        synchronized(this.a) {
            f0 = (androidx.media3.session.f)((f)this.c).remove(w00);
            if(f0 == null) {
                return;
            }
            ((f)this.b).remove(f0.a);
        }
        f0.b.release();
        n0 n00 = (n0)((WeakReference)this.d).get();
        if(n00 != null && !n00.l()) {
            androidx.media3.session.d d0 = new androidx.media3.session.d(n00, w00, 0);
            x.P(n00.l, d0);
        }
    }

    public Object x(oe.c c0) {
        u u1;
        Throwable throwable1;
        Mutex mutex2;
        u u0;
        Mutex mutex0;
        l2.b0 b00;
        if(c0 instanceof l2.b0) {
            b00 = (l2.b0)c0;
            int v = b00.E;
            if((v & 0x80000000) == 0) {
                b00 = new l2.b0(this, c0);
            }
            else {
                b00.E = v ^ 0x80000000;
            }
        }
        else {
            b00 = new l2.b0(this, c0);
        }
        Object object0 = b00.B;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(b00.E) {
            case 0: {
                d5.n.D(object0);
                if(((CompletableDeferred)this.b).isCompleted()) {
                    return h0;
                }
                mutex0 = (Mutex)this.a;
                b00.r = this;
                b00.w = mutex0;
                b00.E = 1;
                if(mutex0.lock(null, b00) != a0) {
                    u0 = this;
                    goto label_29;
                }
                return a0;
            }
            case 1: {
                Mutex mutex1 = b00.w;
                u0 = b00.r;
                d5.n.D(object0);
                mutex0 = mutex1;
                try {
                label_29:
                    if(!((CompletableDeferred)u0.b).isCompleted()) {
                        b00.r = u0;
                        b00.w = mutex0;
                        b00.E = 2;
                        if(u0.e(b00) == a0) {
                            return a0;
                        }
                        mutex2 = mutex0;
                        u1 = u0;
                        goto label_48;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    throwable1 = throwable0;
                    break;
                }
                mutex0.unlock(null);
                return h0;
            }
            case 2: {
                try {
                    mutex2 = b00.w;
                    u1 = b00.r;
                    d5.n.D(object0);
                label_48:
                    ((CompletableDeferred)u1.b).complete(h0);
                    goto label_53;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable1;
    label_53:
        mutex2.unlock(null);
        return h0;
    }

    public void y() {
        ArrayList arrayList0 = (ArrayList)this.b;
        if(!arrayList0.isEmpty()) {
            ((HashMap)((p)this.c).b).put(((jf.p)this.a), arrayList0);
        }
    }

    public H8.q z(int v, b b0, Re.a a0) {
        jf.p p0 = new jf.p(((jf.p)this.a).a + '@' + v);
        p p1 = (p)this.d;
        HashMap hashMap0 = (HashMap)p1.b;
        List list0 = (List)hashMap0.get(p0);
        if(list0 == null) {
            list0 = new ArrayList();
            hashMap0.put(p0, list0);
        }
        return ((E9.u)p1.a).C(b0, a0, list0);
    }
}

