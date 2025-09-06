package androidx.compose.foundation.relocation;

import P0.a0;
import Q0.x0;
import R.b;
import R.c;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterElement;", "LP0/a0;", "LR/c;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BringIntoViewRequesterElement extends a0 {
    public final b a;

    public BringIntoViewRequesterElement(b b0) {
        this.a = b0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new c();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof BringIntoViewRequesterElement && q.b(this.a, ((BringIntoViewRequesterElement)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "bringIntoViewRequester";
        x00.c.b(this.a, "bringIntoViewRequester");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        b b0 = ((c)p0).a;
        if(b0 != null) {
            b0.a.j(((c)p0));
        }
        b b1 = this.a;
        if(b1 != null) {
            b1.a.b(((c)p0));
        }
        ((c)p0).a = b1;
    }
}

