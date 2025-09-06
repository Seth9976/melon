package Ge;

import De.p;
import De.w;
import Me.K;
import Me.c;
import Pe.J;
import androidx.appcompat.app.o;
import d3.g;
import ie.j;
import ie.k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public abstract class j0 extends h0 implements p {
    public final u0 g;
    public final Object h;
    public static final w[] i;

    static {
        z z0 = new z(j0.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0);
        j0.i = new w[]{I.a.g(z0)};
    }

    public j0() {
        this.g = E9.w.H(null, new i0(this, 0));
        i0 i00 = new i0(this, 1);
        this.h = g.P(k.b, i00);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof j0 && q.b(this.s(), ((j0)object0).s());
    }

    @Override  // Ge.s
    public final He.g g() {
        return (He.g)((j)this.h).getValue();
    }

    @Override  // De.c
    public final String getName() {
        return o.r(new StringBuilder("<get-"), this.s().h, '>');
    }

    @Override
    public final int hashCode() {
        return this.s().hashCode();
    }

    @Override  // Ge.s
    public final c n() {
        w w0 = j0.i[0];
        Object object0 = this.g.invoke();
        q.f(object0, "getValue(...)");
        return (J)object0;
    }

    @Override  // Ge.h0
    public final K r() {
        w w0 = j0.i[0];
        Object object0 = this.g.invoke();
        q.f(object0, "getValue(...)");
        return (J)object0;
    }

    @Override
    public final String toString() {
        return "getter of " + this.s();
    }
}

