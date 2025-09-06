package androidx.compose.foundation.lazy.layout;

import A7.d;
import I.a;
import I.u0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierElement;", "LP0/a0;", "Landroidx/compose/foundation/lazy/layout/m;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class LazyLayoutBeyondBoundsModifierElement extends a0 {
    public final n a;
    public final a b;
    public final boolean c;
    public final u0 d;

    public LazyLayoutBeyondBoundsModifierElement(n n0, a a0, boolean z, u0 u00) {
        this.a = n0;
        this.b = a0;
        this.c = z;
        this.d = u00;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new m();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        return p0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof LazyLayoutBeyondBoundsModifierElement && q.b(this.a, ((LazyLayoutBeyondBoundsModifierElement)object0).a) && q.b(this.b, ((LazyLayoutBeyondBoundsModifierElement)object0).b) && this.c == ((LazyLayoutBeyondBoundsModifierElement)object0).c && this.d == ((LazyLayoutBeyondBoundsModifierElement)object0).d;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + d.e((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((m)p0).a = this.a;
        ((m)p0).b = this.b;
        ((m)p0).c = this.c;
        ((m)p0).d = this.d;
    }
}

