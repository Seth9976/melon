package androidx.compose.foundation.layout;

import M.b0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/LayoutWeightElement;", "LP0/a0;", "LM/b0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LayoutWeightElement extends a0 {
    public final float a;
    public final boolean b;

    public LayoutWeightElement(float f, boolean z) {
        this.a = f;
        this.b = z;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new b0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        LayoutWeightElement layoutWeightElement0 = object0 instanceof LayoutWeightElement ? ((LayoutWeightElement)object0) : null;
        return layoutWeightElement0 == null ? false : this.a == layoutWeightElement0.a && this.b == layoutWeightElement0.b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "weight";
        x00.b = this.a;
        x00.c.b(this.a, "weight");
        x00.c.b(Boolean.valueOf(this.b), "fill");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((b0)p0).a = this.a;
        ((b0)p0).b = this.b;
    }
}

