package androidx.compose.ui.input.pointer;

import J0.a;
import J0.q;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierElement;", "LP0/a0;", "LJ0/q;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class PointerHoverIconModifierElement extends a0 {
    public final a a;

    public PointerHoverIconModifierElement(a a0) {
        this.a = a0;
    }

    @Override  // P0.a0
    public final p create() {
        return new q(this.a, null);  // 初始化器: LJ0/g;-><init>(LJ0/a;LP0/o;)V
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof PointerHoverIconModifierElement && this.a.equals(((PointerHoverIconModifierElement)object0).a);
    }

    @Override
    public final int hashCode() {
        return 0x4D5 + this.a.b * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "pointerHoverIcon";
        x00.c.b(this.a, "icon");
        x00.c.b(Boolean.FALSE, "overrideDescendants");
    }

    @Override
    public final String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.a + ", overrideDescendants=false)";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        a a0 = this.a;
        if(!kotlin.jvm.internal.q.b(((q)p0).b, a0)) {
            ((q)p0).b = a0;
            if(((q)p0).c) {
                ((q)p0).o0();
            }
        }
    }
}

