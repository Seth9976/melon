package androidx.compose.foundation.layout;

import M.u0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import r1.f;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsElement;", "LP0/a0;", "LM/u0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class UnspecifiedConstraintsElement extends a0 {
    public final float a;
    public final float b;

    public UnspecifiedConstraintsElement(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new u0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof UnspecifiedConstraintsElement && f.a(this.a, ((UnspecifiedConstraintsElement)object0).a) && f.a(this.b, ((UnspecifiedConstraintsElement)object0).b);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "defaultMinSize";
        f f0 = new f(this.a);
        x00.c.b(f0, "minWidth");
        f f1 = new f(this.b);
        x00.c.b(f1, "minHeight");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((u0)p0).a = this.a;
        ((u0)p0).b = this.b;
    }
}

