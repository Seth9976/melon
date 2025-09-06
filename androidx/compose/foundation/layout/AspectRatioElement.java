package androidx.compose.foundation.layout;

import M.k;
import N.a;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioElement;", "LP0/a0;", "LM/k;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class AspectRatioElement extends a0 {
    public final float a;
    public final boolean b;

    public AspectRatioElement(float f, boolean z) {
        this.a = f;
        this.b = z;
        if(f > 0.0f) {
            return;
        }
        a.a(("aspectRatio " + f + " must be > 0"));
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new k();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        AspectRatioElement aspectRatioElement0 = object0 instanceof AspectRatioElement ? ((AspectRatioElement)object0) : null;
        return aspectRatioElement0 == null ? false : this.a == aspectRatioElement0.a && this.b == ((AspectRatioElement)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((k)p0).a = this.a;
        ((k)p0).b = this.b;
    }
}

