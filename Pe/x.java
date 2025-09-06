package Pe;

import Af.p;
import Hf.B;
import Hf.I;
import Hf.M;
import Hf.V;
import Hf.Y;
import Hf.b0;
import Hf.c;
import Hf.g;
import Hf.i;
import If.f;
import Me.A;
import Me.N;
import Me.S;
import Me.T;
import Me.e;
import Me.k;
import Me.l;
import Me.m;
import Me.o;
import Me.v;
import Ne.h;
import ea.b;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import je.q;
import xf.d;

public final class x extends y {
    public final y a;
    public final V b;
    public V c;
    public ArrayList d;
    public ArrayList e;
    public i f;

    public x(y y0, V v0) {
        this.a = y0;
        this.b = v0;
    }

    @Override  // Me.e
    public final Pe.i B() {
        return this.a.B();
    }

    @Override  // Me.e
    public final boolean O0() {
        return this.a.O0();
    }

    @Override  // Me.e
    public final u P0() {
        throw new UnsupportedOperationException();
    }

    @Override  // Me.k
    public final Object R(m m0, Object object0) {
        return m0.x(this, object0);
    }

    @Override  // Me.e
    public final p Z() {
        p p0 = this.a.Z();
        if(p0 != null) {
            return p0;
        }
        x.o(28);
        throw null;
    }

    @Override  // Me.e
    public final e a() {
        e e0 = this.a.a();
        if(e0 != null) {
            return e0;
        }
        x.o(21);
        throw null;
    }

    @Override  // Me.e
    public final T a0() {
        T t0 = this.a.a0();
        if(t0 == null) {
            return null;
        }
        V v0 = this.b;
        if(t0 instanceof v) {
            qf.e e0 = ((v)t0).a;
            B b0 = (B)((v)t0).b;
            if(b0 != null && !v0.a.e()) {
                b0 = (B)this.p().i(b0, b0.c);
            }
            return new v(e0, b0);
        }
        if(!(t0 instanceof A)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        ArrayList arrayList0 = new ArrayList(q.Q(10, ((A)t0).a));
        for(Object object0: ((A)t0).a) {
            qf.e e1 = (qf.e)((ie.m)object0).a;
            B b1 = (B)(((Kf.e)((ie.m)object0).b));
            if(b1 != null && !v0.a.e()) {
                b1 = (B)this.p().i(b1, b0.c);
            }
            arrayList0.add(new ie.m(e1, b1));
        }
        return new A(arrayList0);
    }

    @Override  // Me.P
    public final l c(V v0) {
        if(v0 != null) {
            return v0.a.e() ? this : new x(this, V.e(v0.f(), this.p().f()));
        }
        x.o(23);
        throw null;
    }

    @Override  // Me.e
    public final p d0() {
        d.i(tf.e.d(this.a));
        return this.n(f.a);
    }

    @Override  // Me.k
    public final k e() {
        k k0 = this.a.e();
        if(k0 != null) {
            return k0;
        }
        x.o(22);
        throw null;
    }

    @Override  // Me.x
    public final boolean e0() {
        return this.a.e0();
    }

    @Override  // Me.e
    public final List f0() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        x.o(17);
        throw null;
    }

    @Override  // Me.e
    public final B g() {
        I i0;
        List list0 = Y.d(this.q().getParameters());
        h h0 = this.getAnnotations();
        if(h0.isEmpty()) {
            I.b.getClass();
            i0 = I.c;
        }
        else {
            List list1 = e.k.z(new g(h0));
            I.b.getClass();
            i0 = b.g(list1);
        }
        M m0 = this.q();
        return c.v(this.d0(), i0, m0, list0, false);
    }

    @Override  // Me.e
    public final boolean g0() {
        return this.a.g0();
    }

    @Override  // Ne.a
    public final h getAnnotations() {
        h h0 = this.a.getAnnotations();
        if(h0 != null) {
            return h0;
        }
        x.o(19);
        throw null;
    }

    @Override  // Me.e
    public final Me.f getKind() {
        Me.f f0 = this.a.getKind();
        if(f0 != null) {
            return f0;
        }
        x.o(25);
        throw null;
    }

    @Override  // Me.k
    public final qf.e getName() {
        qf.e e0 = this.a.getName();
        if(e0 != null) {
            return e0;
        }
        x.o(20);
        throw null;
    }

    @Override  // Me.l
    public final N getSource() {
        return N.q;
    }

    @Override  // Me.e
    public final o getVisibility() {
        o o0 = this.a.getVisibility();
        if(o0 != null) {
            return o0;
        }
        x.o(27);
        throw null;
    }

    @Override  // Me.e
    public final List h() {
        this.p();
        List list0 = this.e;
        if(list0 != null) {
            return list0;
        }
        x.o(30);
        throw null;
    }

    @Override  // Me.e
    public final Me.y i() {
        Me.y y0 = this.a.i();
        if(y0 != null) {
            return y0;
        }
        x.o(26);
        throw null;
    }

    @Override  // Me.x
    public final boolean isExternal() {
        return this.a.isExternal();
    }

    @Override  // Me.e
    public final boolean isInline() {
        return this.a.isInline();
    }

    @Override  // Me.e
    public final boolean j() {
        return this.a.j();
    }

    @Override  // Pe.y
    public final p k(Hf.T t0, f f0) {
        p p0 = this.a.k(t0, f0);
        if(this.b.a.e()) {
            if(p0 != null) {
                return p0;
            }
            x.o(7);
            throw null;
        }
        return new Af.u(p0, this.p());
    }

    @Override  // Me.e
    public final boolean l0() {
        return this.a.l0();
    }

    @Override  // Pe.y
    public final p n(f f0) {
        p p0 = this.a.n(f0);
        if(this.b.a.e()) {
            if(p0 != null) {
                return p0;
            }
            x.o(14);
            throw null;
        }
        return new Af.u(p0, this.p());
    }

    public static void o(int v) {
        IllegalArgumentException illegalArgumentException0;
        int v1;
        String s;
        switch(v) {
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                s = "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
                break;
            }
            default: {
                s = "@NotNull method %s.%s must not return null";
            }
        }
        switch(v) {
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                v1 = 3;
                break;
            }
            default: {
                v1 = 2;
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 2: 
            case 8: {
                arr_object[0] = "typeArguments";
                break;
            }
            case 5: 
            case 10: {
                arr_object[0] = "typeSubstitution";
                break;
            }
            case 3: 
            case 6: 
            case 13: {
                arr_object[0] = "kotlinTypeRefiner";
                break;
            }
            case 23: {
                arr_object[0] = "substitutor";
                break;
            }
            default: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
            }
        }
        switch(v) {
            case 4: 
            case 7: 
            case 9: 
            case 11: {
                arr_object[1] = "getMemberScope";
                break;
            }
            case 12: 
            case 14: {
                arr_object[1] = "getUnsubstitutedMemberScope";
                break;
            }
            case 15: {
                arr_object[1] = "getStaticScope";
                break;
            }
            case 16: {
                arr_object[1] = "getDefaultType";
                break;
            }
            case 17: {
                arr_object[1] = "getContextReceivers";
                break;
            }
            case 18: {
                arr_object[1] = "getConstructors";
                break;
            }
            case 19: {
                arr_object[1] = "getAnnotations";
                break;
            }
            case 20: {
                arr_object[1] = "getName";
                break;
            }
            case 21: {
                arr_object[1] = "getOriginal";
                break;
            }
            case 22: {
                arr_object[1] = "getContainingDeclaration";
                break;
            }
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            }
            case 24: {
                arr_object[1] = "substitute";
                break;
            }
            case 25: {
                arr_object[1] = "getKind";
                break;
            }
            case 26: {
                arr_object[1] = "getModality";
                break;
            }
            case 27: {
                arr_object[1] = "getVisibility";
                break;
            }
            case 28: {
                arr_object[1] = "getUnsubstitutedInnerClassesScope";
                break;
            }
            case 29: {
                arr_object[1] = "getSource";
                break;
            }
            case 30: {
                arr_object[1] = "getDeclaredTypeParameters";
                break;
            }
            case 0x1F: {
                arr_object[1] = "getSealedSubclasses";
                break;
            }
            default: {
                arr_object[1] = "getTypeConstructor";
            }
        }
        switch(v) {
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: {
                arr_object[2] = "getMemberScope";
                break;
            }
            case 13: {
                arr_object[2] = "getUnsubstitutedMemberScope";
                break;
            }
            case 23: {
                arr_object[2] = "substitute";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 13: 
            case 23: {
                illegalArgumentException0 = new IllegalArgumentException(s1);
                break;
            }
            default: {
                illegalArgumentException0 = new IllegalStateException(s1);
            }
        }
        throw illegalArgumentException0;
    }

    public final V p() {
        if(this.c == null) {
            V v0 = this.b;
            if(v0.a.e()) {
                this.c = v0;
                return this.c;
            }
            List list0 = this.a.q().getParameters();
            this.d = new ArrayList(list0.size());
            this.c = c.A(list0, v0.f(), this, this.d);
            ArrayList arrayList0 = this.d;
            kotlin.jvm.internal.q.g(arrayList0, "<this>");
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: arrayList0) {
                if(!((S)object0).U()) {
                    arrayList1.add(object0);
                }
            }
            this.e = arrayList1;
        }
        return this.c;
    }

    @Override  // Me.h
    public final M q() {
        M m0 = this.a.q();
        if(this.b.a.e()) {
            if(m0 != null) {
                return m0;
            }
            x.o(0);
            throw null;
        }
        if(this.f == null) {
            V v0 = this.p();
            Collection collection0 = m0.f();
            ArrayList arrayList0 = new ArrayList(collection0.size());
            for(Object object0: collection0) {
                arrayList0.add(v0.i(((Hf.x)object0), b0.c));
            }
            this.f = new i(this, this.d, arrayList0, Gf.m.e);
        }
        M m1 = this.f;
        if(m1 != null) {
            return m1;
        }
        x.o(1);
        throw null;
    }

    @Override  // Me.e
    public final p q0(Hf.T t0) {
        d.i(tf.e.d(this));
        return this.k(t0, f.a);
    }

    @Override  // Me.x
    public final boolean r0() {
        return this.a.r0();
    }

    @Override  // Me.e
    public final Collection s() {
        Collection collection0 = this.a.s();
        Collection collection1 = new ArrayList(collection0.size());
        for(Object object0: collection0) {
            ((Pe.i)object0).getClass();
            s s0 = ((Pe.i)object0).z1(V.b);
            s0.e = ((Pe.i)object0).G1();
            s0.m(((Pe.i)object0).i());
            s0.k(((Pe.i)object0).getVisibility());
            s0.c(((Pe.i)object0).getKind());
            s0.m = false;
            ((ArrayList)collection1).add(((Pe.i)s0.N.w1(s0)).J1(this.p()));
        }
        return collection1;
    }

    @Override  // Me.e
    public final p t0() {
        p p0 = this.a.t0();
        if(p0 != null) {
            return p0;
        }
        x.o(15);
        throw null;
    }

    @Override  // Me.i
    public final boolean x() {
        return this.a.x();
    }
}

