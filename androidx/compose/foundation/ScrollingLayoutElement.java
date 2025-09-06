package androidx.compose.foundation;

import A7.d;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutElement;", "LP0/a0;", "Landroidx/compose/foundation/N0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ScrollingLayoutElement extends a0 {
    public final Q0 a;
    public final boolean b;

    public ScrollingLayoutElement(Q0 q00, boolean z) {
        this.a = q00;
        this.b = z;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new N0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof ScrollingLayoutElement && q.b(this.a, ((ScrollingLayoutElement)object0).a) && this.b == ((ScrollingLayoutElement)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + d.e(this.a.hashCode() * 0x1F, 0x1F, false);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "scroll";
        x00.c.b(this.a, "state");
        x00.c.b(Boolean.FALSE, "reverseScrolling");
        x00.c.b(Boolean.valueOf(this.b), "isVertical");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((N0)p0).a = this.a;
        ((N0)p0).b = this.b;
    }
}

