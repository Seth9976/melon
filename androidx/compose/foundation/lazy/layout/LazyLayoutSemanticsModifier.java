package androidx.compose.foundation.lazy.layout;

import A7.d;
import I.u0;
import P0.a0;
import P0.f;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.a;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifier;", "LP0/a0;", "Landroidx/compose/foundation/lazy/layout/V;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class LazyLayoutSemanticsModifier extends a0 {
    public final a a;
    public final Q b;
    public final u0 c;
    public final boolean d;
    public final boolean e;

    public LazyLayoutSemanticsModifier(a a0, Q q0, u0 u00, boolean z, boolean z1) {
        this.a = a0;
        this.b = q0;
        this.c = u00;
        this.d = z;
        this.e = z1;
    }

    @Override  // P0.a0
    public final p create() {
        return new V(this.a, this.b, this.c, this.d, this.e);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof LazyLayoutSemanticsModifier && this.a == ((LazyLayoutSemanticsModifier)object0).a && q.b(this.b, ((LazyLayoutSemanticsModifier)object0).b) && this.c == ((LazyLayoutSemanticsModifier)object0).c && this.d == ((LazyLayoutSemanticsModifier)object0).d && this.e == ((LazyLayoutSemanticsModifier)object0).e;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.e) + d.e((this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F, 0x1F, this.d);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((V)p0).a = this.a;
        ((V)p0).b = this.b;
        u0 u00 = this.c;
        if(((V)p0).c != u00) {
            ((V)p0).c = u00;
            f.v(((V)p0)).E();
        }
        boolean z = this.d;
        boolean z1 = this.e;
        if(((V)p0).d == z && ((V)p0).e == z1) {
            return;
        }
        ((V)p0).d = z;
        ((V)p0).e = z1;
        ((V)p0).m0();
        f.v(((V)p0)).E();
    }
}

