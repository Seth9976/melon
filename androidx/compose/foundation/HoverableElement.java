package androidx.compose.foundation;

import K.l;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/HoverableElement;", "LP0/a0;", "Landroidx/compose/foundation/c0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class HoverableElement extends a0 {
    public final l a;

    public HoverableElement(l l0) {
        this.a = l0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new c0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof HoverableElement ? q.b(((HoverableElement)object0).a, this.a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "hoverable";
        x00.c.b(this.a, "interactionSource");
        x00.c.b(Boolean.TRUE, "enabled");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        l l0 = this.a;
        if(!q.b(((c0)p0).a, l0)) {
            ((c0)p0).o0();
            ((c0)p0).a = l0;
        }
    }
}

