package androidx.compose.ui.draw;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import v0.c;
import v0.d;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawWithCacheElement;", "LP0/a0;", "Lv0/c;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class DrawWithCacheElement extends a0 {
    public final k a;

    public DrawWithCacheElement(k k0) {
        this.a = k0;
    }

    @Override  // P0.a0
    public final p create() {
        return new c(new d(), this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DrawWithCacheElement ? q.b(this.a, ((DrawWithCacheElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "drawWithCache";
        x00.c.b(this.a, "onBuildDrawCache");
    }

    @Override
    public final String toString() {
        return "DrawWithCacheElement(onBuildDrawCache=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((c)p0).c = this.a;
        ((c)p0).m0();
    }
}

