package androidx.compose.foundation.layout;

import F.Q;
import M.e0;
import P0.a0;
import P0.f;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/OffsetPxElement;", "LP0/a0;", "LM/e0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class OffsetPxElement extends a0 {
    public final k a;
    public final Q b;

    public OffsetPxElement(k k0, Q q0) {
        this.a = k0;
        this.b = q0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new e0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = true;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        OffsetPxElement offsetPxElement0 = object0 instanceof OffsetPxElement ? ((OffsetPxElement)object0) : null;
        return offsetPxElement0 != null && this.a == offsetPxElement0.a;
    }

    @Override
    public final int hashCode() {
        return 0x4CF + this.a.hashCode() * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        this.b.invoke(x00);
    }

    @Override
    public final String toString() {
        return "OffsetPxModifier(offset=" + this.a + ", rtlAware=true)";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        k k0 = this.a;
        if(((e0)p0).a != k0 || !((e0)p0).b) {
            f.v(((e0)p0)).V(false);
        }
        ((e0)p0).a = k0;
        ((e0)p0).b = true;
    }
}

