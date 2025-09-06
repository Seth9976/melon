package androidx.compose.foundation.layout;

import M.Y;
import M.Z;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicWidthElement;", "LP0/a0;", "LM/Z;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class IntrinsicWidthElement extends a0 {
    public final Y a;
    public final boolean b;

    public IntrinsicWidthElement(Y y0, boolean z) {
        this.a = y0;
        this.b = z;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new Z();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            IntrinsicWidthElement intrinsicWidthElement0 = object0 instanceof IntrinsicWidthElement ? ((IntrinsicWidthElement)object0) : null;
            return intrinsicWidthElement0 != null && this.a == intrinsicWidthElement0.a && this.b == intrinsicWidthElement0.b;
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
        ((Z)p0).a = this.a;
        ((Z)p0).b = this.b;
    }
}

