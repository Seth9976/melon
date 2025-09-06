package androidx.compose.ui.draw;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import v0.e;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawBehindElement;", "LP0/a0;", "Lv0/e;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class DrawBehindElement extends a0 {
    public final k a;

    public DrawBehindElement(k k0) {
        this.a = k0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new e();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DrawBehindElement ? q.b(this.a, ((DrawBehindElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "drawBehind";
        x00.c.b(this.a, "onDraw");
    }

    @Override
    public final String toString() {
        return "DrawBehindElement(onDraw=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((e)p0).a = this.a;
    }
}

