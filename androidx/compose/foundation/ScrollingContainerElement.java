package androidx.compose.foundation;

import I.X0;
import I.Z;
import I.d;
import I.u0;
import K.l;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/ScrollingContainerElement;", "LP0/a0;", "Landroidx/compose/foundation/R0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class ScrollingContainerElement extends a0 {
    public final X0 a;
    public final u0 b;
    public final boolean c;
    public final boolean d;
    public final Z e;
    public final l f;
    public final d g;
    public final boolean h;
    public final m i;

    public ScrollingContainerElement(d d0, Z z0, u0 u00, X0 x00, l l0, m m0, boolean z1, boolean z2, boolean z3) {
        this.a = x00;
        this.b = u00;
        this.c = z1;
        this.d = z2;
        this.e = z0;
        this.f = l0;
        this.g = d0;
        this.h = z3;
        this.i = m0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new R0();  // 初始化器: LP0/n;-><init>()V
        p0.c = this.a;
        p0.d = this.b;
        p0.e = this.c;
        p0.f = this.d;
        p0.g = this.e;
        p0.h = this.f;
        p0.i = this.g;
        p0.j = this.h;
        p0.k = this.i;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return ScrollingContainerElement.class == class0 && q.b(this.a, ((ScrollingContainerElement)object0).a) && this.b == ((ScrollingContainerElement)object0).b && this.c == ((ScrollingContainerElement)object0).c && this.d == ((ScrollingContainerElement)object0).d && q.b(this.e, ((ScrollingContainerElement)object0).e) && q.b(this.f, ((ScrollingContainerElement)object0).f) && q.b(this.g, ((ScrollingContainerElement)object0).g) && this.h == ((ScrollingContainerElement)object0).h && q.b(this.i, ((ScrollingContainerElement)object0).i);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = A7.d.e((((A7.d.e(A7.d.e((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c), 0x1F, this.d) + (this.e == null ? 0 : this.e.hashCode())) * 0x1F + (this.f == null ? 0 : this.f.hashCode())) * 0x1F + (this.g == null ? 0 : this.g.hashCode())) * 0x1F, 0x1F, this.h);
        m m0 = this.i;
        if(m0 != null) {
            v = m0.hashCode();
        }
        return v1 + v;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "scrollingContainer";
        x00.c.b(this.a, "state");
        x00.c.b(this.b, "orientation");
        x00.c.b(Boolean.valueOf(this.c), "enabled");
        x00.c.b(Boolean.valueOf(this.d), "reverseScrolling");
        x00.c.b(this.e, "flingBehavior");
        x00.c.b(this.f, "interactionSource");
        x00.c.b(this.g, "bringIntoViewSpec");
        x00.c.b(Boolean.valueOf(this.h), "useLocalOverscrollFactory");
        x00.c.b(this.i, "overscrollEffect");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((R0)p0).r0(this.g, this.e, this.b, this.a, this.f, this.i, this.h, this.c, this.d);
    }
}

