package androidx.compose.foundation;

import K.l;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/FocusableElement;", "LP0/a0;", "Landroidx/compose/foundation/U;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class FocusableElement extends a0 {
    public final l a;

    public FocusableElement(l l0) {
        this.a = l0;
    }

    @Override  // P0.a0
    public final p create() {
        return new U(this.a, 1, null);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof FocusableElement ? q.b(this.a, ((FocusableElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "focusable";
        x00.c.b(Boolean.TRUE, "enabled");
        x00.c.b(this.a, "interactionSource");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((U)p0).r0(this.a);
    }
}

