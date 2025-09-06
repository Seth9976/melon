package androidx.compose.foundation.layout;

import M.w0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.h;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/VerticalAlignElement;", "LP0/a0;", "LM/w0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class VerticalAlignElement extends a0 {
    public final h a;

    public VerticalAlignElement(h h0) {
        this.a = h0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new w0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        VerticalAlignElement verticalAlignElement0 = object0 instanceof VerticalAlignElement ? ((VerticalAlignElement)object0) : null;
        return verticalAlignElement0 == null ? false : this.a.equals(verticalAlignElement0.a);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a.a);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "align";
        x00.b = this.a;
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((w0)p0).a = this.a;
    }
}

