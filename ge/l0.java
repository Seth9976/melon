package Ge;

import De.h;
import De.w;
import Me.c;
import Pe.K;
import androidx.appcompat.app.o;
import d3.g;
import ie.j;
import ie.k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public abstract class l0 extends h0 implements h {
    public final u0 g;
    public final Object h;
    public static final w[] i;

    static {
        z z0 = new z(l0.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0);
        l0.i = new w[]{I.a.g(z0)};
    }

    public l0() {
        this.g = E9.w.H(null, new k0(this, 0));
        k0 k00 = new k0(this, 1);
        this.h = g.P(k.b, k00);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof l0 && q.b(this.s(), ((l0)object0).s());
    }

    @Override  // Ge.s
    public final He.g g() {
        return (He.g)((j)this.h).getValue();
    }

    @Override  // De.c
    public final String getName() {
        return o.r(new StringBuilder("<set-"), this.s().h, '>');
    }

    @Override
    public final int hashCode() {
        return this.s().hashCode();
    }

    @Override  // Ge.s
    public final c n() {
        w w0 = l0.i[0];
        Object object0 = this.g.invoke();
        q.f(object0, "getValue(...)");
        return (K)object0;
    }

    @Override  // Ge.h0
    public final Me.K r() {
        w w0 = l0.i[0];
        Object object0 = this.g.invoke();
        q.f(object0, "getValue(...)");
        return (K)object0;
    }

    @Override
    public final String toString() {
        return "setter of " + this.s();
    }
}

