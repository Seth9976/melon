package androidx.compose.ui.layout;

import N0.w;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutIdElement;", "LP0/a0;", "LN0/w;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class LayoutIdElement extends a0 {
    public final Object a;

    public LayoutIdElement(Object object0) {
        this.a = object0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new w();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof LayoutIdElement ? q.b(this.a, ((LayoutIdElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "layoutId";
        x00.b = this.a;
    }

    @Override
    public final String toString() {
        return "LayoutIdElement(layoutId=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((w)p0).a = this.a;
    }
}

