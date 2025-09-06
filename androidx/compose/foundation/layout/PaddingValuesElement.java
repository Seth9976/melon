package androidx.compose.foundation.layout;

import B0.b;
import M.i0;
import M.k0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesElement;", "LP0/a0;", "LM/k0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class PaddingValuesElement extends a0 {
    public final i0 a;
    public final b b;

    public PaddingValuesElement(i0 i00, b b0) {
        this.a = i00;
        this.b = b0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new k0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        PaddingValuesElement paddingValuesElement0 = object0 instanceof PaddingValuesElement ? ((PaddingValuesElement)object0) : null;
        return paddingValuesElement0 == null ? false : q.b(this.a, paddingValuesElement0.a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        this.b.invoke(x00);
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((k0)p0).a = this.a;
    }
}

