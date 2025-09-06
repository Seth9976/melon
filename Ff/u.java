package Ff;

import Me.N;
import Me.k;
import Pe.L;
import Pe.t;
import Pe.z;
import k8.Y;
import kotlin.jvm.internal.q;
import lf.A;
import nf.f;
import nf.h;
import qf.e;
import rf.a;

public final class u extends L implements b {
    public final A Y;
    public final f Z;
    public final z b0;
    public final h c0;
    public final m d0;

    public u(k k0, L l0, Ne.h h0, e e0, int v, A a0, f f0, z z0, h h1, m m0, N n0) {
        q.g(k0, "containingDeclaration");
        q.g(h0, "annotations");
        Y.r(v, "kind");
        q.g(a0, "proto");
        q.g(f0, "nameResolver");
        q.g(z0, "typeTable");
        q.g(h1, "versionRequirementTable");
        N n1 = n0 == null ? N.q : n0;
        super(k0, l0, h0, e0, v, n1);
        this.Y = a0;
        this.Z = f0;
        this.b0 = z0;
        this.c0 = h1;
        this.d0 = m0;
    }

    @Override  // Ff.n
    public final z C() {
        return this.b0;
    }

    @Override  // Ff.n
    public final f G() {
        return this.Z;
    }

    @Override  // Ff.n
    public final m K() {
        return this.d0;
    }

    @Override  // Ff.n
    public final a m0() {
        return this.Y;
    }

    @Override  // Pe.L
    public final t v1(int v, k k0, Me.u u0, N n0, Ne.h h0, e e0) {
        e e2;
        q.g(k0, "newOwner");
        Y.r(v, "kind");
        q.g(h0, "annotations");
        if(e0 == null) {
            e e1 = this.getName();
            q.f(e1, "getName(...)");
            e2 = e1;
        }
        else {
            e2 = e0;
        }
        t t0 = new u(k0, ((L)u0), h0, e2, v, this.Y, this.Z, this.b0, this.c0, this.d0, n0);
        t0.I = this.I;
        return t0;
    }
}

