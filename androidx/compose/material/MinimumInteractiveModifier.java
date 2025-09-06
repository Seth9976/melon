package androidx.compose.material;

import P0.a0;
import Q0.x0;
import Z.y;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/material/MinimumInteractiveModifier;", "LP0/a0;", "LZ/y;", "<init>", "()V", "material_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class MinimumInteractiveModifier extends a0 {
    public static final MinimumInteractiveModifier a;

    static {
        MinimumInteractiveModifier.a = new MinimumInteractiveModifier();
    }

    @Override  // P0.a0
    public final p create() {
        return new y();  // 初始化器: Lr0/p;-><init>()V
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "minimumInteractiveComponentSize";
        x00.c.b("Reserves at least 48.dp in size to disambiguate touch interactions if the element would measure smaller", "README");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        y y0 = (y)p0;
    }
}

