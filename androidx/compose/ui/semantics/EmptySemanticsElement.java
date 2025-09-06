package androidx.compose.ui.semantics;

import P0.a0;
import Q0.x0;
import X0.f;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/semantics/EmptySemanticsElement;", "LP0/a0;", "LX0/f;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmptySemanticsElement extends a0 {
    public final f a;

    public EmptySemanticsElement(f f0) {
        this.a = f0;
    }

    @Override  // P0.a0
    public final p create() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override  // P0.a0
    public final void update(p p0) {
        f f0 = (f)p0;
    }
}

