package androidx.compose.ui;

import A7.d;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import r0.u;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/ZIndexElement;", "LP0/a0;", "Lr0/u;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ZIndexElement extends a0 {
    public final float a;

    public ZIndexElement(float f) {
        this.a = f;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new u();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ZIndexElement ? Float.compare(this.a, ((ZIndexElement)object0).a) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "zIndex";
        x00.c.b(this.a, "zIndex");
    }

    @Override
    public final String toString() {
        return d.m(new StringBuilder("ZIndexElement(zIndex="), this.a, ')');
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((u)p0).a = this.a;
    }
}

