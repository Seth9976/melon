package androidx.compose.ui.focus;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import w0.k;
import w0.u;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/compose/ui/focus/FocusOwnerImpl$modifier$1", "LP0/a0;", "Lw0/u;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class FocusOwnerImpl.modifier.1 extends a0 {
    public final k a;

    public FocusOwnerImpl.modifier.1(k k0) {
        this.a = k0;
    }

    @Override  // P0.a0
    public final p create() {
        return this.a.f;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return this.a.f.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "RootFocusTarget";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        u u0 = (u)p0;
    }
}

