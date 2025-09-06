package androidx.compose.ui.graphics;

import P0.a0;
import P0.f;
import P0.j0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.k;
import y0.m;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/BlockGraphicsLayerElement;", "LP0/a0;", "Ly0/m;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BlockGraphicsLayerElement extends a0 {
    public final k a;

    public BlockGraphicsLayerElement(k k0) {
        this.a = k0;
    }

    @Override  // P0.a0
    public final p create() {
        return new m(this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof BlockGraphicsLayerElement ? q.b(this.a, ((BlockGraphicsLayerElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "graphicsLayer";
        x00.c.b(this.a, "block");
    }

    @Override
    public final String toString() {
        return "BlockGraphicsLayerElement(block=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((m)p0).a = this.a;
        j0 j00 = f.t(((m)p0), 2).m;
        if(j00 != null) {
            j00.n1(((m)p0).a, true);
        }
    }
}

