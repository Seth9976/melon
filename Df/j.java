package df;

import Ac.q0;
import De.I;
import Gf.i;
import Gf.m;
import Gf.p;
import If.l;
import Me.M;
import Me.O;
import Me.T;
import Me.a0;
import Me.d0;
import Me.e;
import Me.f;
import Me.g0;
import Me.k;
import Me.y;
import Ne.h;
import Qe.b;
import Re.g;
import Se.n;
import bf.c;
import cf.a;
import com.google.firebase.messaging.u;
import h7.u0;
import ie.r;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.q;
import xf.d;

public final class j extends Pe.j implements c {
    public final M B;
    public final Af.j D;
    public final F E;
    public final cf.c G;
    public final i I;
    public static final Set M;
    public final u g;
    public final n h;
    public final e i;
    public final u j;
    public final r k;
    public final f l;
    public final y m;
    public final g0 n;
    public final boolean o;
    public final Ff.i r;
    public final o w;

    static {
        j.M = je.n.A0(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public j(u u0, k k0, n n0, e e0) {
        q.g(u0, "outerContext");
        d0 d00;
        y y0;
        Boolean boolean1;
        Boolean boolean0;
        f f0;
        q.g(k0, "containingDeclaration");
        q.g(n0, "jClass");
        a a0 = (a)u0.a;
        qf.e e1 = n0.e();
        g g0 = a0.j.b(n0);
        super(a0.a, k0, e1, g0);
        this.g = u0;
        this.h = n0;
        this.i = e0;
        u u1 = d5.f.k(u0, this, n0, 4);
        this.j = u1;
        a a1 = (a)u1.a;
        p p0 = a1.a;
        a1.g.getClass();
        this.k = d3.g.Q(new df.i(this, 0));
        Class class0 = n0.a;
        if(class0.isAnnotation()) {
            f0 = f.e;
        }
        else if(class0.isInterface()) {
            f0 = f.b;
        }
        else {
            f0 = class0.isEnum() ? f.c : f.a;
        }
        this.l = f0;
        n n1 = null;
        boolean z = false;
        if(class0.isAnnotation() || class0.isEnum()) {
            y0 = y.b;
        }
        else {
            O o0 = y.a;
            q.g(class0, "clazz");
            Method method0 = (Method)ye.a.J().a;
            if(method0 == null) {
                boolean0 = null;
            }
            else {
                Object object0 = method0.invoke(class0, null);
                q.e(object0, "null cannot be cast to non-null type kotlin.Boolean");
                boolean0 = (Boolean)object0;
            }
            boolean z1 = boolean0 == null ? false : boolean0.booleanValue();
            q.g(class0, "clazz");
            Method method1 = (Method)ye.a.J().a;
            if(method1 == null) {
                boolean1 = null;
            }
            else {
                Object object1 = method1.invoke(class0, null);
                q.e(object1, "null cannot be cast to non-null type kotlin.Boolean");
                boolean1 = (Boolean)object1;
            }
            boolean z2 = (boolean1 == null ? false : boolean1.booleanValue()) || Modifier.isAbstract(class0.getModifiers()) || class0.isInterface();
            boolean z3 = Modifier.isFinal(class0.getModifiers());
            o0.getClass();
            if(z1) {
                y0 = y.c;
            }
            else if(z2) {
                y0 = y.e;
            }
            else if(z3) {
                y0 = y.b;
            }
            else {
                y0 = y.d;
            }
        }
        this.m = y0;
        int v = class0.getModifiers();
        if(Modifier.isPublic(v)) {
            d00 = d0.c;
        }
        else if(Modifier.isPrivate(v)) {
            d00 = a0.c;
        }
        else if(!Modifier.isProtected(v)) {
            d00 = Qe.a.c;
        }
        else if(Modifier.isStatic(v)) {
            d00 = Qe.c.c;
        }
        else {
            d00 = b.c;
        }
        this.n = d00;
        Class class1 = class0.getDeclaringClass();
        if(class1 != null) {
            n1 = new n(class1);
        }
        this.o = n1 != null && !Modifier.isStatic(class0.getModifiers());
        this.r = new Ff.i(this);
        if(e0 != null) {
            z = true;
        }
        o o1 = new o(u1, this, n0, z, null);
        this.w = o1;
        ((l)a1.u).getClass();
        q0 q00 = new q0(this, 22);
        M.d.getClass();
        q.g(p0, "storageManager");
        this.B = new M(this, p0, q00);
        this.D = new Af.j(o1);
        this.E = new F(u1, n0, this);
        this.G = u0.Q(u1, n0);
        df.i i0 = new df.i(this, 1);
        ((m)p0).getClass();
        this.I = new i(((m)p0), i0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Me.e
    public final Pe.i B() {
        return null;
    }

    @Override  // Me.e
    public final boolean O0() {
        return false;
    }

    @Override  // Pe.b, Me.e
    public final Af.p Z() {
        return this.D;
    }

    @Override  // Me.e
    public final T a0() {
        return null;
    }

    @Override  // Pe.b, Me.e
    public final Af.p d0() {
        return (o)super.d0();
    }

    @Override  // Me.x
    public final boolean e0() {
        return false;
    }

    @Override  // Me.e
    public final boolean g0() {
        return false;
    }

    @Override  // Ne.a
    public final h getAnnotations() {
        return this.G;
    }

    @Override  // Me.e
    public final f getKind() {
        return this.l;
    }

    @Override  // Me.e
    public final Me.o getVisibility() {
        g0 g00 = this.n;
        if(q.b(g00, Me.p.a)) {
            Class class0 = this.h.a.getDeclaringClass();
            if((class0 == null ? null : new n(class0)) == null) {
                q.d(Ze.o.a);
                return Ze.o.a;
            }
        }
        return I.W(g00);
    }

    @Override  // Me.e
    public final List h() {
        return (List)this.I.invoke();
    }

    @Override  // Me.e
    public final y i() {
        return this.m;
    }

    @Override  // Me.e
    public final boolean isInline() {
        return false;
    }

    @Override  // Me.e
    public final boolean j() {
        return false;
    }

    @Override  // Me.e
    public final boolean l0() {
        return false;
    }

    @Override  // Pe.y
    public final Af.p n(If.f f0) {
        d.j(this.B.a);
        return (o)(((Af.p)P4.a.r(this.B.c, M.e[0])));
    }

    @Override  // Me.h
    public final Hf.M q() {
        return this.r;
    }

    public final o r() {
        return (o)super.d0();
    }

    @Override  // Me.x
    public final boolean r0() {
        return false;
    }

    @Override  // Me.e
    public final Collection s() {
        return (List)this.w.q.invoke();
    }

    @Override  // Me.e
    public final Af.p t0() {
        return this.E;
    }

    @Override
    public final String toString() {
        return "Lazy Java class " + d.h(this);
    }

    @Override  // Me.i
    public final boolean x() {
        return this.o;
    }
}

