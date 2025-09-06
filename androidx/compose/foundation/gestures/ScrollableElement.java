package androidx.compose.foundation.gestures;

import A7.d;
import I.W0;
import I.X0;
import I.u0;
import K.l;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableElement;", "LP0/a0;", "LI/W0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class ScrollableElement extends a0 {
    public final X0 a;
    public final u0 b;
    public final boolean c;
    public final boolean d;
    public final l e;

    public ScrollableElement(X0 x00, u0 u00, boolean z, boolean z1, l l0) {
        this.a = x00;
        this.b = u00;
        this.c = z;
        this.d = z1;
        this.e = l0;
    }

    @Override  // P0.a0
    public final p create() {
        return new W0(null, null, this.b, this.a, this.e, null, this.c, this.d);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof ScrollableElement && q.b(this.a, ((ScrollableElement)object0).a) && this.b == ((ScrollableElement)object0).b && this.c == ((ScrollableElement)object0).c && this.d == ((ScrollableElement)object0).d && q.b(this.e, ((ScrollableElement)object0).e);
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.e((this.b.hashCode() + this.a.hashCode() * 0x1F) * 961, 0x1F, this.c), 961, this.d);
        return this.e == null ? v * 0x1F : (v + this.e.hashCode()) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "scrollable";
        x00.c.b(this.b, "orientation");
        x00.c.b(this.a, "state");
        x00.c.b(null, "overscrollEffect");
        x00.c.b(Boolean.valueOf(this.c), "enabled");
        x00.c.b(Boolean.valueOf(this.d), "reverseDirection");
        x00.c.b(null, "flingBehavior");
        x00.c.b(this.e, "interactionSource");
        x00.c.b(null, "bringIntoViewSpec");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((W0)p0).y0(null, null, this.b, this.a, this.e, null, this.c, this.d);
    }
}

