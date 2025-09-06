package z4;

import android.database.SQLException;
import androidx.room.S;
import androidx.room.T;
import e1.x;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import je.m;
import oe.c;
import oe.i;
import we.k;
import we.n;

public final class u implements T, v {
    public final h a;
    public final boolean b;
    public final m c;
    public final AtomicBoolean d;

    public u(h h0, boolean z) {
        this.a = h0;
        this.b = z;
        this.c = new m();
        this.d = new AtomicBoolean(false);
    }

    @Override  // androidx.room.T
    public final Object a(i i0) {
        if(!this.d.get()) {
            a a0 = (a)i0.getContext().get(a.b);
            if(a0 != null && a0.a == this) {
                return Boolean.valueOf(!this.c.isEmpty());
            }
            u0.S(21, "Attempted to use connection on a different coroutine");
            throw null;
        }
        u0.S(21, "Connection is recycled");
        throw null;
    }

    @Override  // androidx.room.T
    public final Object b(S s0, n n0, i i0) {
        if(!this.d.get()) {
            a a0 = (a)i0.getContext().get(a.b);
            if(a0 != null && a0.a == this) {
                return this.g(s0, n0, i0);
            }
            u0.S(21, "Attempted to use connection on a different coroutine");
            throw null;
        }
        u0.S(21, "Connection is recycled");
        throw null;
    }

    @Override  // z4.v
    public final G4.a c() {
        return this.a;
    }

    @Override  // androidx.room.w
    public final Object d(String s, k k0, c c0) {
        Object object1;
        u u0;
        h h0;
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.I;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.I = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.E;
        ne.a a0 = ne.a.a;
        switch(t0.I) {
            case 0: {
                d5.n.D(object0);
                if(!this.d.get()) {
                    a a1 = (a)t0.getContext().get(a.b);
                    if(a1 != null && a1.a == this) {
                        t0.r = this;
                        t0.w = s;
                        t0.B = k0;
                        h0 = this.a;
                        t0.D = h0;
                        t0.I = 1;
                        if(h0.b.lock(null, t0) == a0) {
                            return a0;
                        }
                        u0 = this;
                        break;
                    }
                    u0.S(21, "Attempted to use connection on a different coroutine");
                    throw null;
                }
                u0.S(21, "Connection is recycled");
                throw null;
            }
            case 1: {
                h h1 = t0.D;
                k0 = t0.B;
                String s1 = t0.w;
                u0 = t0.r;
                d5.n.D(object0);
                h0 = h1;
                s = s1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            o o0 = new o(u0, u0.a.l0(s));
            try {
                object1 = k0.invoke(o0);
            }
            catch(Throwable throwable0) {
                x.y(o0, throwable0);
                throw throwable0;
            }
            x.y(o0, null);
            return object1;
        }
        finally {
            h0.unlock(null);
        }
    }

    public final Object e(S s0, c c0) {
        u u0;
        h h0;
        q q0;
        if(c0 instanceof q) {
            q0 = (q)c0;
            int v = q0.G;
            if((v & 0x80000000) == 0) {
                q0 = new q(this, c0);
            }
            else {
                q0.G = v ^ 0x80000000;
            }
        }
        else {
            q0 = new q(this, c0);
        }
        Object object0 = q0.D;
        ne.a a0 = ne.a.a;
        switch(q0.G) {
            case 0: {
                d5.n.D(object0);
                q0.r = this;
                q0.w = s0;
                h0 = this.a;
                q0.B = h0;
                q0.G = 1;
                if(h0.b.lock(null, q0) == a0) {
                    return a0;
                }
                u0 = this;
                break;
            }
            case 1: {
                h h1 = q0.B;
                S s1 = q0.w;
                u0 = q0.r;
                d5.n.D(object0);
                h0 = h1;
                s0 = s1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            m m0 = u0.c;
            h h2 = u0.a;
            int v2 = m0.c;
            if(m0.isEmpty()) {
                int v3 = s0.ordinal();
                switch(v3) {
                    case 0: {
                        u0.w("BEGIN DEFERRED TRANSACTION", h2);
                        break;
                    }
                    case 1: {
                        u0.w("BEGIN IMMEDIATE TRANSACTION", h2);
                        break;
                    }
                    default: {
                        if(v3 != 2) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        u0.w("BEGIN EXCLUSIVE TRANSACTION", h2);
                        break;
                    }
                }
            }
            else {
                u0.w(("SAVEPOINT \'" + v2 + '\''), h2);
            }
            m0.addLast(new p(v2));
            return H.a;
        }
        finally {
            h0.unlock(null);
        }
    }

    public final Object f(boolean z, c c0) {
        h h1;
        u u0;
        r r0;
        if(c0 instanceof r) {
            r0 = (r)c0;
            int v = r0.G;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, c0);
            }
            else {
                r0.G = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, c0);
        }
        Object object0 = r0.D;
        ne.a a0 = ne.a.a;
        switch(r0.G) {
            case 0: {
                d5.n.D(object0);
                r0.r = this;
                h h0 = this.a;
                r0.w = h0;
                r0.B = z;
                r0.G = 1;
                if(h0.b.lock(null, r0) == a0) {
                    return a0;
                }
                u0 = this;
                h1 = h0;
                break;
            }
            case 1: {
                z = r0.B;
                h1 = r0.w;
                u0 = r0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            m m0 = u0.c;
            h h2 = u0.a;
            if(!m0.isEmpty()) {
                p p0 = (p)je.u.Z(m0);
                if(z) {
                    p0.getClass();
                    if(m0.isEmpty()) {
                        u0.w("END TRANSACTION", h2);
                    }
                    else {
                        u0.w(("RELEASE SAVEPOINT \'" + p0.a + '\''), h2);
                    }
                }
                else if(m0.isEmpty()) {
                    u0.w("ROLLBACK TRANSACTION", h2);
                }
                else {
                    u0.w(("ROLLBACK TRANSACTION TO SAVEPOINT \'" + p0.a + '\''), h2);
                }
                return H.a;
            }
        }
        finally {
            h1.unlock(null);
        }
        throw new IllegalStateException("Not in a transaction");
    }

    public final Object g(S s0, n n0, c c0) {
        Throwable throwable3;
        SQLException sQLException1;
        int v1;
        u u1;
        u u0;
        s s1;
        if(c0 instanceof s) {
            s1 = (s)c0;
            int v = s1.G;
            if((v & 0x80000000) == 0) {
                s1 = new s(this, c0);
            }
            else {
                s1.G = v ^ 0x80000000;
            }
        }
        else {
            s1 = new s(this, c0);
        }
        Object object0 = s1.D;
        ne.a a0 = ne.a.a;
        boolean z = false;
        switch(s1.G) {
            case 0: {
                d5.n.D(object0);
                if(s0 == null) {
                    s0 = S.a;
                }
                s1.r = this;
                s1.w = (Serializable)n0;
                s1.G = 1;
                if(this.e(s0, s1) != a0) {
                    u0 = this;
                    goto label_29;
                }
                return a0;
            }
            case 1: {
                n0 = (n)s1.w;
                u0 = (u)s1.r;
                d5.n.D(object0);
            label_29:
                A4.c c1 = new A4.c(u0, 1);
                s1.r = u0;
                s1.w = null;
                s1.B = 1;
                s1.G = 2;
                object0 = n0.invoke(c1, s1);
                if(object0 != a0) {
                    u1 = u0;
                    v1 = 1;
                    goto label_63;
                }
                return a0;
            }
            case 2: {
                v1 = s1.B;
                u1 = (u)s1.r;
                try {
                    d5.n.D(object0);
                    goto label_63;
                }
                catch(Throwable throwable1) {
                    throwable0 = throwable1;
                    u0 = u1;
                }
                try {
                    throw throwable0;
                }
                catch(Throwable throwable2) {
                    try {
                        s1.r = throwable0;
                        s1.w = throwable2;
                        s1.G = 5;
                        if(u0.f(false, s1) == a0) {
                            return a0;
                        }
                    }
                    catch(SQLException sQLException0) {
                        sQLException1 = sQLException0;
                        throwable3 = throwable2;
                        goto label_75;
                    }
                    throwable3 = throwable2;
                    throw throwable3;
                }
            label_63:
                if(v1 != 0) {
                    z = true;
                }
                s1.r = object0;
                s1.G = 3;
                return u1.f(z, s1) != a0 ? object0 : a0;
            }
            case 3: 
            case 4: {
                Object object1 = s1.r;
                d5.n.D(object0);
                return object1;
            }
            case 5: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        throwable3 = (Throwable)s1.w;
        throwable0 = (Throwable)s1.r;
        try {
            d5.n.D(object0);
            throw throwable3;
        }
        catch(SQLException sQLException1) {
        }
    label_75:
        if(throwable0 == null) {
            throw sQLException1;
        }
        else {
            e2.a.q(throwable0, sQLException1);
        }
        throw throwable3;
    }
}

