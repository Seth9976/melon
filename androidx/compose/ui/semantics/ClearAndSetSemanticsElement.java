package androidx.compose.ui.semantics;

import P0.a0;
import Q0.x0;
import X0.d;
import X0.l;
import X0.m;
import X0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/semantics/ClearAndSetSemanticsElement;", "LP0/a0;", "LX0/d;", "LX0/m;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ClearAndSetSemanticsElement extends a0 implements m {
    public final k a;

    public ClearAndSetSemanticsElement(k k0) {
        this.a = k0;
    }

    @Override  // X0.m
    public final l b() {
        l l0 = new l();
        l0.c = false;
        l0.d = true;
        this.a.invoke(l0);
        return l0;
    }

    @Override  // P0.a0
    public final p create() {
        return new d(false, true, this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ClearAndSetSemanticsElement ? q.b(this.a, ((ClearAndSetSemanticsElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "clearAndSetSemantics";
        n.a(x00, this.b());
    }

    @Override
    public final String toString() {
        return "ClearAndSetSemanticsElement(properties=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((d)p0).c = this.a;
    }
}

