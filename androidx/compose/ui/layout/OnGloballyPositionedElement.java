package androidx.compose.ui.layout;

import N0.U;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/OnGloballyPositionedElement;", "LP0/a0;", "LN0/U;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class OnGloballyPositionedElement extends a0 {
    public final k a;

    public OnGloballyPositionedElement(k k0) {
        this.a = k0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new U();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof OnGloballyPositionedElement ? this.a == ((OnGloballyPositionedElement)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "onGloballyPositioned";
        x00.c.b(this.a, "onGloballyPositioned");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((U)p0).a = this.a;
    }
}

