package Ff;

import Me.N;
import Me.e;
import Me.j;
import Me.k;
import Me.u;
import Pe.i;
import Pe.t;
import Pe.z;
import k8.Y;
import kotlin.jvm.internal.q;
import lf.n;
import nf.f;
import nf.h;
import rf.a;

public final class c extends i implements b {
    public final n Z;
    public final f b0;
    public final z c0;
    public final h d0;
    public final m e0;

    public c(e e0, j j0, Ne.h h0, boolean z, int v, n n0, f f0, z z1, h h1, m m0, N n1) {
        q.g(e0, "containingDeclaration");
        q.g(h0, "annotations");
        Y.r(v, "kind");
        q.g(n0, "proto");
        q.g(f0, "nameResolver");
        q.g(z1, "typeTable");
        q.g(h1, "versionRequirementTable");
        N n2 = n1 == null ? N.q : n1;
        super(e0, j0, h0, z, v, n2);
        this.Z = n0;
        this.b0 = f0;
        this.c0 = z1;
        this.d0 = h1;
        this.e0 = m0;
    }

    @Override  // Pe.t, Me.u
    public final boolean A() {
        return false;
    }

    @Override  // Ff.n
    public final z C() {
        return this.c0;
    }

    @Override  // Pe.i
    public final i E1(int v, k k0, u u0, N n0, Ne.h h0, qf.e e0) {
        return this.K1(k0, u0, v, h0, n0);
    }

    @Override  // Ff.n
    public final f G() {
        return this.b0;
    }

    @Override  // Ff.n
    public final m K() {
        return this.e0;
    }

    public final c K1(k k0, u u0, int v, Ne.h h0, N n0) {
        q.g(k0, "newOwner");
        Y.r(v, "kind");
        q.g(h0, "annotations");
        c c0 = new c(((e)k0), ((j)u0), h0, this.Y, v, this.Z, this.b0, this.c0, this.d0, this.e0, n0);
        c0.I = this.I;
        return c0;
    }

    @Override  // Pe.t, Me.x
    public final boolean isExternal() {
        return false;
    }

    @Override  // Pe.t, Me.u
    public final boolean isInline() {
        return false;
    }

    @Override  // Pe.t, Me.u
    public final boolean isSuspend() {
        return false;
    }

    @Override  // Ff.n
    public final a m0() {
        return this.Z;
    }

    @Override  // Pe.i
    public final t v1(int v, k k0, u u0, N n0, Ne.h h0, qf.e e0) {
        return this.K1(k0, u0, v, h0, n0);
    }
}

