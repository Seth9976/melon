package androidx.compose.foundation.lazy.layout;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement", "LP0/a0;", "Landroidx/compose/foundation/lazy/layout/q;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class LazyLayoutItemAnimator.DisplayingDisappearingItemsElement extends a0 {
    public final s a;

    public LazyLayoutItemAnimator.DisplayingDisappearingItemsElement(s s0) {
        this.a = s0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new q();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof LazyLayoutItemAnimator.DisplayingDisappearingItemsElement ? kotlin.jvm.internal.q.b(this.a, ((LazyLayoutItemAnimator.DisplayingDisappearingItemsElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "DisplayingDisappearingItemsElement";
    }

    @Override
    public final String toString() {
        return "DisplayingDisappearingItemsElement(animator=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        s s0 = this.a;
        if(!kotlin.jvm.internal.q.b(((q)p0).a, s0) && ((q)p0).getNode().isAttached()) {
            s s1 = ((q)p0).a;
            s1.d();
            s1.b = null;
            ((q)p0).a = s0;
        }
    }
}

