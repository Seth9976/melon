package Ff;

import Me.L;
import Me.N;
import Me.k;
import Me.o;
import Me.y;
import Pe.I;
import Pe.z;
import k8.Y;
import kotlin.jvm.internal.q;
import nf.d;
import nf.f;
import nf.h;
import qf.e;
import rf.a;

public final class t extends I implements b {
    public final lf.I V;
    public final f W;
    public final z X;
    public final h Y;
    public final m Z;

    public t(k k0, L l0, Ne.h h0, y y0, o o0, boolean z, e e0, int v, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, lf.I i0, f f0, z z6, h h1, m m0) {
        q.g(k0, "containingDeclaration");
        q.g(h0, "annotations");
        q.g(y0, "modality");
        q.g(o0, "visibility");
        q.g(e0, "name");
        Y.r(v, "kind");
        q.g(i0, "proto");
        q.g(f0, "nameResolver");
        q.g(z6, "typeTable");
        q.g(h1, "versionRequirementTable");
        super(k0, l0, h0, y0, o0, z, e0, v, N.q, z1, z2, z5, z3, z4);
        this.V = i0;
        this.W = f0;
        this.X = z6;
        this.Y = h1;
        this.Z = m0;
    }

    @Override  // Ff.n
    public final z C() {
        return this.X;
    }

    @Override  // Ff.n
    public final f G() {
        return this.W;
    }

    @Override  // Ff.n
    public final m K() {
        return this.Z;
    }

    @Override  // Pe.I, Me.x
    public final boolean isExternal() {
        return d.E.e(this.V.d).booleanValue();
    }

    @Override  // Ff.n
    public final a m0() {
        return this.V;
    }

    @Override  // Pe.I
    public final I v1(k k0, y y0, o o0, L l0, int v, e e0) {
        q.g(k0, "newOwner");
        q.g(y0, "newModality");
        q.g(o0, "newVisibility");
        Y.r(v, "kind");
        q.g(e0, "newName");
        Ne.h h0 = this.getAnnotations();
        boolean z = this.isExternal();
        return new t(k0, l0, h0, y0, o0, this.f, e0, v, this.n, this.o, z, this.B, this.r, this.V, this.W, this.X, this.Y, this.Z);
    }
}

