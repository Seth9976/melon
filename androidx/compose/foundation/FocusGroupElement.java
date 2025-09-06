package androidx.compose.foundation;

import P0.a0;
import P0.n;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import w0.u;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/FocusGroupElement;", "LP0/a0;", "Landroidx/compose/foundation/P;", "<init>", "()V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class FocusGroupElement extends a0 {
    public static final FocusGroupElement a;

    static {
        FocusGroupElement.a = new FocusGroupElement();
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new P();  // 初始化器: LP0/n;-><init>()V
        ((n)p0).m0(new u(2, 4, null));
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return 0xC097F887;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "focusGroup";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        P p1 = (P)p0;
    }
}

