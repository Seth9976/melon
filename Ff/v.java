package Ff;

import Gf.p;
import Hf.B;
import Hf.I;
import Hf.M;
import Hf.Y;
import Hf.b0;
import Hf.c;
import Me.k;
import Me.l;
import Me.o;
import Me.w;
import Pe.d;
import Pe.f;
import Pe.z;
import java.util.List;
import kotlin.jvm.internal.q;
import lf.V;
import nf.h;
import qf.e;
import rf.a;

public final class v extends f implements n {
    public final V i;
    public final nf.f j;
    public final z k;
    public final h l;
    public final m m;
    public B n;
    public B o;
    public List r;
    public B w;

    public v(p p0, k k0, Ne.h h0, e e0, o o0, V v0, nf.f f0, z z0, h h1, m m0) {
        q.g(p0, "storageManager");
        q.g(k0, "containingDeclaration");
        q.g(o0, "visibility");
        q.g(v0, "proto");
        q.g(f0, "nameResolver");
        q.g(z0, "typeTable");
        q.g(h1, "versionRequirementTable");
        super(p0, k0, h0, e0, o0);
        this.i = v0;
        this.j = f0;
        this.k = z0;
        this.l = h1;
        this.m = m0;
    }

    @Override  // Ff.n
    public final z C() {
        return this.k;
    }

    @Override  // Ff.n
    public final nf.f G() {
        return this.j;
    }

    @Override  // Ff.n
    public final m K() {
        return this.m;
    }

    @Override  // Me.P
    public final l c(Hf.V v0) {
        q.g(v0, "substitutor");
        if(v0.a.e()) {
            return this;
        }
        k k0 = this.e();
        q.f(k0, "getContainingDeclaration(...)");
        Ne.h h0 = this.getAnnotations();
        q.f(h0, "<get-annotations>(...)");
        e e0 = this.getName();
        q.f(e0, "getName(...)");
        l l0 = new v(this.e, k0, h0, e0, this.f, this.i, this.j, this.k, this.l, this.m);
        ((v)l0).w1(this.h(), c.b(v0.g(this.v1(), b0.c)), c.b(v0.g(this.u1(), b0.c)));
        return l0;
    }

    @Override  // Me.h
    public final B g() {
        B b0 = this.w;
        if(b0 != null) {
            return b0;
        }
        q.m("defaultTypeImpl");
        throw null;
    }

    @Override  // Ff.n
    public final a m0() {
        return this.i;
    }

    public final Me.e t1() {
        if(!c.k(this.u1())) {
            Me.h h0 = this.u1().w().e();
            return h0 instanceof Me.e ? ((Me.e)h0) : null;
        }
        return null;
    }

    public final B u1() {
        B b0 = this.o;
        if(b0 != null) {
            return b0;
        }
        q.m("expandedType");
        throw null;
    }

    public final B v1() {
        B b0 = this.n;
        if(b0 != null) {
            return b0;
        }
        q.m("underlyingType");
        throw null;
    }

    public final void w1(List list0, B b0, B b1) {
        B b2;
        Af.p p0;
        q.g(b0, "underlyingType");
        q.g(b1, "expandedType");
        this.g = list0;
        this.n = b0;
        this.o = b1;
        this.r = w.c(this);
        Me.e e0 = this.t1();
        if(e0 == null) {
            p0 = Af.o.b;
        }
        else {
            p0 = e0.d0();
            if(p0 == null) {
                p0 = Af.o.b;
            }
        }
        d d0 = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(Jf.l.f(this)) {
            b2 = Jf.l.c(Jf.k.k, new String[]{this.toString()});
            this.w = b2;
            return;
        }
        M m0 = this.q();
        if(m0 != null) {
            List list1 = Y.d(((Pe.e)m0).getParameters());
            I.b.getClass();
            b2 = c.w(I.c, m0, list1, false, p0, d0);
            this.w = b2;
            return;
        }
        Y.a(12);
        throw null;
    }
}

