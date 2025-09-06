package androidx.compose.foundation;

import K.l;
import P0.a0;
import P0.m;
import P0.n;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/IndicationModifierElement;", "LP0/a0;", "Landroidx/compose/foundation/k0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class IndicationModifierElement extends a0 {
    public final l a;
    public final l0 b;

    public IndicationModifierElement(l l0, l0 l00) {
        this.a = l0;
        this.b = l00;
    }

    @Override  // P0.a0
    public final p create() {
        m m0 = this.b.b(this.a);
        p p0 = new k0();  // 初始化器: LP0/n;-><init>()V
        p0.c = m0;
        ((n)p0).m0(m0);
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof IndicationModifierElement)) {
            return false;
        }
        return q.b(this.a, ((IndicationModifierElement)object0).a) ? q.b(this.b, ((IndicationModifierElement)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "indication";
        x00.c.b(this.a, "interactionSource");
        x00.c.b(this.b, "indication");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        m m0 = this.b.b(this.a);
        ((k0)p0).n0(((k0)p0).c);
        ((k0)p0).c = m0;
        ((k0)p0).m0(m0);
    }
}

