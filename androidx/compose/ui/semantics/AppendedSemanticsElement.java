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

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/semantics/AppendedSemanticsElement;", "LP0/a0;", "LX0/d;", "LX0/m;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AppendedSemanticsElement extends a0 implements m {
    public final boolean a;
    public final k b;

    public AppendedSemanticsElement(k k0, boolean z) {
        this.a = z;
        this.b = k0;
    }

    @Override  // X0.m
    public final l b() {
        l l0 = new l();
        l0.c = this.a;
        this.b.invoke(l0);
        return l0;
    }

    @Override  // P0.a0
    public final p create() {
        return new d(this.a, false, this.b);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof AppendedSemanticsElement && this.a == ((AppendedSemanticsElement)object0).a && q.b(this.b, ((AppendedSemanticsElement)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "semantics";
        x00.c.b(Boolean.valueOf(this.a), "mergeDescendants");
        n.a(x00, this.b());
    }

    @Override
    public final String toString() {
        return "AppendedSemanticsElement(mergeDescendants=" + this.a + ", properties=" + this.b + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((d)p0).a = this.a;
        ((d)p0).c = this.b;
    }
}

