package androidx.compose.ui.input.pointer;

import J0.F;
import J0.a;
import P0.a0;
import P0.o;
import Q0.x0;
import U.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/StylusHoverIconModifierElement;", "LP0/a0;", "LJ0/F;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class StylusHoverIconModifierElement extends a0 {
    public final o a;

    public StylusHoverIconModifierElement(o o0) {
        this.a = o0;
    }

    @Override  // P0.a0
    public final p create() {
        return new F(b0.c, this.a);  // 初始化器: LJ0/g;-><init>(LJ0/a;LP0/o;)V
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof StylusHoverIconModifierElement) {
                ((StylusHoverIconModifierElement)object0).getClass();
                return b0.c.equals(b0.c) && q.b(this.a, ((StylusHoverIconModifierElement)object0).a);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        o o0 = this.a;
        if(o0 != null) {
            v = o0.hashCode();
        }
        return v + 1020489;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "stylusHoverIcon";
        x00.c.b(b0.c, "icon");
        x00.c.b(Boolean.FALSE, "overrideDescendants");
        x00.c.b(this.a, "touchBoundsExpansion");
    }

    @Override
    public final String toString() {
        return "StylusHoverIconModifierElement(icon=" + b0.c + ", overrideDescendants=false, touchBoundsExpansion=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        a a0 = b0.c;
        if(!q.b(((F)p0).b, a0)) {
            ((F)p0).b = a0;
            if(((F)p0).c) {
                ((F)p0).o0();
            }
        }
        ((F)p0).a = this.a;
    }
}

