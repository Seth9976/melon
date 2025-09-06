package androidx.compose.ui.input.rotary;

import L0.a;
import P0.a0;
import Q0.l;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/rotary/RotaryInputElement;", "LP0/a0;", "LL0/a;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class RotaryInputElement extends a0 {
    @Override  // P0.a0
    public final p create() {
        p p0 = new a();  // 初始化器: Lr0/p;-><init>()V
        p0.a = l.i;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof RotaryInputElement) {
                ((RotaryInputElement)object0).getClass();
                return l.i.equals(l.i);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return l.i.hashCode() * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "onRotaryScrollEvent";
        x00.c.b(l.i, "onRotaryScrollEvent");
    }

    @Override
    public final String toString() {
        return "RotaryInputElement(onRotaryScrollEvent=" + l.i + ", onPreRotaryScrollEvent=null)";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((a)p0).a = l.i;
    }
}

