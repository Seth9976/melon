package androidx.compose.ui.layout;

import N0.V;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/OnLayoutRectChangedElement;", "LP0/a0;", "LN0/V;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class OnLayoutRectChangedElement extends a0 {
    public final k a;

    public OnLayoutRectChangedElement(k k0) {
        this.a = k0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new V();  // 初始化器: Lr0/p;-><init>()V
        p0.a = 1000L;
        p0.b = 0x40L;
        p0.c = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof OnLayoutRectChangedElement) {
                ((OnLayoutRectChangedElement)object0).getClass();
                return q.b(this.a, ((OnLayoutRectChangedElement)object0).a);
            }
            return false;
        }
        return true;
    }

    // 去混淆评级： 低(30)
    @Override
    public final int hashCode() {
        return this.a.hashCode() + 0xEB1A8;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "onRectChanged";
        x00.c.b(1000L, "throttleMillis");
        x00.c.b(0x40L, "debounceMillis");
        x00.c.b(this.a, "callback");
    }

    @Override
    public final String toString() {
        return "OnLayoutRectChangedElement(throttleMillis=1000, debounceMillis=64, callback=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((V)p0).a = 1000L;
        ((V)p0).b = 0x40L;
        ((V)p0).c = this.a;
        ((V)p0).m0();
    }
}

