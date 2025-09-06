package androidx.compose.foundation.layout;

import M.l;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.e;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/BoxChildDataElement;", "LP0/a0;", "LM/l;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BoxChildDataElement extends a0 {
    public final e a;
    public final boolean b;

    public BoxChildDataElement(e e0, boolean z) {
        this.a = e0;
        this.b = z;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new l();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            BoxChildDataElement boxChildDataElement0 = object0 instanceof BoxChildDataElement ? ((BoxChildDataElement)object0) : null;
            return boxChildDataElement0 != null && q.b(this.a, boxChildDataElement0.a) && this.b == boxChildDataElement0.b;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((l)p0).a = this.a;
        ((l)p0).b = this.b;
    }
}

