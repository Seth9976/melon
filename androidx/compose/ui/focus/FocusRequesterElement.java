package androidx.compose.ui.focus;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import w0.p;
import w0.r;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterElement;", "LP0/a0;", "Lw0/r;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class FocusRequesterElement extends a0 {
    public final p a;

    public FocusRequesterElement(p p0) {
        this.a = p0;
    }

    @Override  // P0.a0
    public final r0.p create() {
        r0.p p0 = new r();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof FocusRequesterElement ? q.b(this.a, ((FocusRequesterElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "focusRequester";
        x00.c.b(this.a, "focusRequester");
    }

    @Override
    public final String toString() {
        return "FocusRequesterElement(focusRequester=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(r0.p p0) {
        ((r)p0).a.a.j(((r)p0));
        ((r)p0).a = this.a;
        this.a.a.b(((r)p0));
    }
}

