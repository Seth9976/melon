package androidx.compose.ui.input.nestedscroll;

import B2.o;
import I0.a;
import I0.d;
import I0.g;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollElement;", "LP0/a0;", "LI0/g;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class NestedScrollElement extends a0 {
    public final a a;
    public final d b;

    public NestedScrollElement(a a0, d d0) {
        this.a = a0;
        this.b = d0;
    }

    @Override  // P0.a0
    public final p create() {
        return new g(this.a, this.b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof NestedScrollElement)) {
            return false;
        }
        return q.b(((NestedScrollElement)object0).a, this.a) ? q.b(((NestedScrollElement)object0).b, this.b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "nestedScroll";
        x00.c.b(this.a, "connection");
        x00.c.b(this.b, "dispatcher");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((g)p0).a = this.a;
        d d0 = ((g)p0).b;
        if(d0.a == ((g)p0)) {
            d0.a = null;
        }
        d d1 = this.b;
        if(d1 == null) {
            ((g)p0).b = new d();
        }
        else if(!d1.equals(d0)) {
            ((g)p0).b = d1;
        }
        if(((g)p0).isAttached()) {
            d d2 = ((g)p0).b;
            d2.a = (g)p0;
            d2.b = null;
            ((g)p0).c = null;
            d2.c = new o(((g)p0), 8);
            d2.d = ((g)p0).getCoroutineScope();
        }
    }
}

