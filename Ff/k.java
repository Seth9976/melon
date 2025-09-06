package Ff;

import A1.g;
import Ac.G;
import Af.p;
import Af.q;
import Af.t;
import Dd.g2;
import Df.B;
import Df.j;
import Df.s;
import Df.v;
import Gf.h;
import Gf.i;
import Gf.m;
import If.l;
import Me.L;
import Me.M;
import Me.N;
import Me.T;
import Me.f;
import Me.o;
import Me.y;
import Pe.b;
import Pe.u;
import Pe.z;
import Q1.c;
import U4.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import je.D;
import lf.C;
import lf.Z;
import lf.g0;
import lf.h0;
import nf.a;
import nf.d;
import qf.e;

public final class k extends b implements Me.k {
    public final h B;
    public final i D;
    public final h E;
    public final s G;
    public final Ne.h I;
    public final lf.k e;
    public final a f;
    public final N g;
    public final qf.b h;
    public final y i;
    public final o j;
    public final f k;
    public final g l;
    public final q m;
    public final Ff.i n;
    public final M o;
    public final d5.i r;
    public final Me.k w;

    public k(g g0, lf.k k0, nf.f f0, a a0, N n0) {
        kotlin.jvm.internal.q.g(g0, "outerContext");
        d5.i i1;
        f f1;
        kotlin.jvm.internal.q.g(k0, "classProto");
        kotlin.jvm.internal.q.g(f0, "nameResolver");
        kotlin.jvm.internal.q.g(n0, "sourceElement");
        super(((Df.i)g0.a).a, c.z(f0, k0.e).f());
        this.e = k0;
        this.f = a0;
        this.g = n0;
        this.h = c.z(f0, k0.e);
        this.i = j.e(((C)d.e.d(k0.d)));
        this.j = F.q(((h0)d.d.d(k0.d)));
        lf.j j0 = (lf.j)d.f.d(k0.d);
        switch((j0 == null ? -1 : v.b[j0.ordinal()])) {
            case 1: {
                f1 = f.a;
                break;
            }
            case 2: {
                f1 = f.b;
                break;
            }
            case 3: {
                f1 = f.c;
                break;
            }
            case 4: {
                f1 = f.d;
                break;
            }
            case 5: {
                f1 = f.e;
                break;
            }
            case 6: 
            case 7: {
                f1 = f.f;
                break;
            }
            default: {
                f1 = f.a;
            }
        }
        this.k = f1;
        List list0 = k0.g;
        kotlin.jvm.internal.q.f(list0, "getTypeParameterList(...)");
        Z z0 = k0.b0;
        kotlin.jvm.internal.q.f(z0, "getTypeTable(...)");
        z z1 = new z(z0);
        g0 g00 = k0.d0;
        kotlin.jvm.internal.q.f(g00, "getVersionRequirementTable(...)");
        g g1 = g0.a(this, list0, f0, z1, e2.a.w(g00), a0);
        Df.i i0 = (Df.i)g1.a;
        m m0 = i0.a;
        this.l = g1;
        boolean z2 = d.m.e(k0.d).booleanValue();
        f f2 = f.c;
        Af.o o0 = f1 == f2 ? new t(m0, this, z2 || kotlin.jvm.internal.q.b(i0.s.d(), Boolean.TRUE)) : Af.o.b;
        this.m = o0;
        this.n = new Ff.i(this);
        ((l)i0.q).getClass();
        g2 g20 = new g2(1, this, Ff.h.class, "<init>", "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V", 0, 7);
        M.d.getClass();
        kotlin.jvm.internal.q.g(m0, "storageManager");
        this.o = new M(this, m0, g20);
        s s0 = null;
        if(f1 == f2) {
            i1 = new d5.i();  // 初始化器: Ljava/lang/Object;-><init>()V
            i1.d = this;
            List list1 = this.e.E;
            kotlin.jvm.internal.q.f(list1, "getEnumEntryList(...)");
            int v = D.N(je.q.Q(10, list1));
            if(v < 16) {
                v = 16;
            }
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
            for(Object object0: list1) {
                linkedHashMap0.put(c.B(((nf.f)this.l.b), ((lf.v)object0).d), object0);
            }
            i1.a = linkedHashMap0;
            k k1 = (k)i1.d;
            i1.b = ((Df.i)k1.l.a).a.c(new G(2, i1, k1));
            m m1 = ((Df.i)((k)i1.d).l.a).a;
            Af.g g2 = new Af.g(i1, 4);
            m1.getClass();
            i1.c = new i(m1, g2);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        }
        else {
            i1 = null;
        }
        this.r = i1;
        Me.k k2 = (Me.k)g0.c;
        this.w = k2;
        Ff.d d0 = new Ff.d(this, 0);
        m0.getClass();
        this.B = new h(m0, d0);
        this.D = new i(m0, new Ff.d(this, 1));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        new h(m0, new Ff.d(this, 2));
        m0.a(new Ff.d(this, 3));
        this.E = new h(m0, new Ff.d(this, 4));
        nf.f f3 = (nf.f)g1.b;
        z z3 = (z)g1.d;
        k k3 = k2 instanceof k ? ((k)k2) : null;
        if(k3 != null) {
            s0 = k3.G;
        }
        this.G = new s(k0, f3, z3, n0, s0);
        Ne.f f4 = d.c.e(k0.d).booleanValue() ? new x(m0, new Ff.d(this, 5)) : Ne.g.a;
        this.I = f4;
    }

    @Override  // Me.e
    public final Pe.i B() {
        return (Pe.i)this.B.invoke();
    }

    @Override  // Me.e
    public final boolean O0() {
        return d.h.e(this.e.d).booleanValue();
    }

    @Override  // Me.e
    public final T a0() {
        return (T)this.E.invoke();
    }

    @Override  // Me.k
    public final Me.k e() {
        return this.w;
    }

    @Override  // Me.x
    public final boolean e0() {
        return false;
    }

    @Override  // Pe.b
    public final List f0() {
        g g0 = this.l;
        Iterable iterable0 = e1.G.h(this.e, ((z)g0.d));
        List list0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            Hf.x x0 = ((B)g0.h).g(((lf.T)object0));
            ((ArrayList)list0).add(new u(this.P0(), new Bf.b(this, x0, null), Ne.g.a));
        }
        return list0;
    }

    @Override  // Me.e
    public final boolean g0() {
        return d.f.d(this.e.d) == lf.j.f;
    }

    @Override  // Ne.a
    public final Ne.h getAnnotations() {
        return this.I;
    }

    @Override  // Me.e
    public final f getKind() {
        return this.k;
    }

    @Override  // Me.l
    public final N getSource() {
        return this.g;
    }

    @Override  // Me.e
    public final o getVisibility() {
        return this.j;
    }

    @Override  // Me.e
    public final List h() {
        return ((B)this.l.h).b();
    }

    @Override  // Me.e
    public final y i() {
        return this.i;
    }

    @Override  // Me.x
    public final boolean isExternal() {
        return d.i.e(this.e.d).booleanValue();
    }

    @Override  // Me.e
    public final boolean isInline() {
        if(d.k.e(this.e.d).booleanValue()) {
            int v = this.f.b;
            return v < 1 || v <= 1 && (this.f.c < 4 || this.f.c <= 4 && this.f.d <= 1);
        }
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // Me.e
    public final boolean j() {
        return d.k.e(this.e.d).booleanValue() && this.f.a(1, 4, 2);
    }

    @Override  // Me.e
    public final boolean l0() {
        return d.l.e(this.e.d).booleanValue();
    }

    @Override  // Pe.y
    public final p n(If.f f0) {
        xf.d.j(this.o.a);
        return (p)P4.a.r(this.o.c, M.e[0]);
    }

    @Override  // Me.h
    public final Hf.M q() {
        return this.n;
    }

    public final Ff.h r() {
        ((l)((Df.i)this.l.a).q).getClass();
        xf.d.j(this.o.a);
        return (Ff.h)(((p)P4.a.r(this.o.c, M.e[0])));
    }

    @Override  // Me.x
    public final boolean r0() {
        return d.j.e(this.e.d).booleanValue();
    }

    @Override  // Me.e
    public final Collection s() {
        return (Collection)this.D.invoke();
    }

    public final Hf.B t(e e0) {
        Hf.x x0 = null;
        boolean z = false;
        Object object0 = null;
        for(Object object1: this.r().b(e0, Ue.c.g)) {
            if(((L)object1).Q() != null) {
                continue;
            }
            if(!z) {
                z = true;
                object0 = object1;
                continue;
            }
            object0 = null;
            goto label_15;
        }
        if(!z) {
            object0 = null;
        }
    label_15:
        if(((L)object0) != null) {
            x0 = ((L)object0).getType();
        }
        return (Hf.B)x0;
    }

    @Override  // Me.e
    public final p t0() {
        return this.m;
    }

    // 去混淆评级： 低(20)
    @Override
    public final String toString() {
        return "deserialized " + (this.r0() ? "expect " : "") + "class " + this.getName();
    }

    @Override  // Me.i
    public final boolean x() {
        return d.g.e(this.e.d).booleanValue();
    }
}

