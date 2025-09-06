package Ge;

import B.a;
import Ff.t;
import Je.p;
import Me.L;
import Me.N;
import Me.j;
import Me.u;
import Pe.J;
import Pe.K;
import Pe.m;
import Se.r;
import Se.w;
import Tf.v;
import bf.f;
import bf.g;
import d5.n;
import e1.x;
import java.lang.reflect.Method;
import kotlin.jvm.internal.q;
import lf.A;
import lf.I;
import pf.e;
import qf.b;
import qf.c;
import xf.d;

public abstract class y0 {
    public static final b a;

    static {
        c c0 = new c("java.lang.Void");
        y0.a = new b(c0.b(), c0.a.f());
    }

    public static k a(u u0) {
        String s = a.B(u0);
        if(s == null) {
            if(u0 instanceof J) {
                String s1 = d.k(u0).getName().b();
                q.f(s1, "asString(...)");
                return new k(new e(Ze.u.a(s1), n.q(u0, 1)));
            }
            if(u0 instanceof K) {
                String s2 = d.k(u0).getName().b();
                q.f(s2, "asString(...)");
                return new k(new e(Ze.u.b(s2), n.q(u0, 1)));
            }
            s = ((m)u0).getName().b();
            q.f(s, "asString(...)");
        }
        return new k(new e(s, n.q(u0, 1)));
    }

    public static a b(L l0) {
        q.g(l0, "possiblyOverriddenProperty");
        L l1 = ((L)tf.e.s(l0)).a();
        q.f(l1, "getOriginal(...)");
        k k0 = null;
        if(l1 instanceof t) {
            I i0 = ((t)l1).V;
            q.f(of.k.d, "propertySignature");
            of.e e0 = (of.e)x.G(i0, of.k.d);
            if(e0 != null) {
                return new Ge.n(l1, i0, e0, ((t)l1).W, ((t)l1).X);
            }
        }
        else if(l1 instanceof g) {
            N n0 = ((g)l1).getSource();
            Re.g g0 = n0 instanceof Re.g ? ((Re.g)n0) : null;
            r r0 = g0 == null ? null : g0.a;
            if(r0 instanceof Se.t) {
                return new l(((Se.t)r0).a);
            }
            if(!(r0 instanceof w)) {
                throw new s0("Incorrect resolution sequence for Java field " + l1 + " (source = " + r0 + ')');
            }
            Method method0 = ((w)r0).a;
            K k1 = ((g)l1).N;
            N n1 = k1 == null ? null : k1.getSource();
            Re.g g1 = n1 instanceof Re.g ? ((Re.g)n1) : null;
            r r1 = g1 == null ? null : g1.a;
            w w0 = r1 instanceof w ? ((w)r1) : null;
            if(w0 != null) {
                k0 = w0.a;
            }
            return new Ge.m(method0, ((Method)k0));
        }
        J j0 = l1.getGetter();
        q.d(j0);
        k k2 = y0.a(j0);
        K k3 = l1.b();
        if(k3 != null) {
            k0 = y0.a(k3);
        }
        return new o(k2, k0);
    }

    public static ye.a c(u u0) {
        r r0 = null;
        q.g(u0, "possiblySubstitutedFunction");
        u u1 = ((u)tf.e.s(u0)).a();
        q.f(u1, "getOriginal(...)");
        if(u1 instanceof Ff.b) {
            rf.a a0 = ((Ff.n)u1).m0();
            if(a0 instanceof A) {
                e e0 = pf.g.c(((A)a0), ((Ff.n)u1).G(), ((Ff.n)u1).C());
                if(e0 != null) {
                    return new k(e0);
                }
            }
            if(a0 instanceof lf.n) {
                e e1 = pf.g.a(((lf.n)a0), ((Ff.n)u1).G(), ((Ff.n)u1).C());
                if(e1 != null) {
                    String s = e1.k;
                    String s1 = e1.l;
                    Me.k k0 = u0.e();
                    q.f(k0, "getContainingDeclaration(...)");
                    if(tf.g.b(k0)) {
                        return new k(e1);
                    }
                    Me.k k1 = u0.e();
                    q.f(k1, "getContainingDeclaration(...)");
                    if(tf.g.d(k1)) {
                        if(!((j)u0).h0()) {
                            if(!q.b(s, "constructor-impl")) {
                                throw new IllegalArgumentException(("Invalid signature: " + e1).toString());
                            }
                            Me.e e2 = ((j)u0).i0();
                            q.f(e2, "getConstructedClass(...)");
                            b b0 = d.f(e2);
                            q.d(b0);
                            String s2 = pf.b.b(b0.b());
                            if(v.i0(s1, ")V", false)) {
                                String s3 = Tf.o.O0(s1, "V") + s2;
                                q.g(s, "name");
                                q.g(s3, "desc");
                                return new k(new e(s, s3));
                            }
                            if(!v.i0(s1, s2, false)) {
                                throw new IllegalArgumentException(("Invalid signature: " + e1).toString());
                            }
                        }
                        else if(!q.b(s, "constructor-impl") || !v.i0(s1, ")V", false)) {
                            throw new IllegalArgumentException(("Invalid signature: " + e1).toString());
                        }
                        return new k(e1);
                    }
                    return new Ge.j(e1);
                }
            }
            return y0.a(u1);
        }
        if(u1 instanceof f) {
            N n0 = ((f)u1).getSource();
            Re.g g0 = n0 instanceof Re.g ? ((Re.g)n0) : null;
            r r1 = g0 == null ? null : g0.a;
            if(r1 instanceof w) {
                r0 = (w)r1;
            }
            if(r0 != null) {
                Method method0 = r0.a;
                if(method0 != null) {
                    return new i(method0);
                }
            }
            throw new s0("Incorrect resolution sequence for Java method " + u1);
        }
        if(u1 instanceof bf.b) {
            N n1 = ((bf.b)u1).getSource();
            Re.g g1 = n1 instanceof Re.g ? ((Re.g)n1) : null;
            if(g1 != null) {
                r0 = g1.a;
            }
            if(r0 instanceof Se.q) {
                return new h(((Se.q)r0).a);
            }
            if(!(r0 instanceof Se.n) || !((Se.n)r0).a.isAnnotation()) {
                throw new s0("Incorrect resolution sequence for Java constructor " + u1 + " (" + r0 + ')');
            }
            return new Ge.g(((Se.n)r0).a);
        }
        if((!((m)u1).getName().equals(p.c) || !tf.m.n(u1)) && (!((m)u1).getName().equals(p.a) || !tf.m.n(u1)) && (!q.b(((m)u1).getName(), Le.a.e) || !u1.F().isEmpty())) {
            throw new s0("Unknown origin of " + u1 + " (" + u1.getClass() + ')');
        }
        return y0.a(u1);
    }
}

