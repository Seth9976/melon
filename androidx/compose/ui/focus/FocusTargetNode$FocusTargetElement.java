package androidx.compose.ui.focus;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import w0.u;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"androidx/compose/ui/focus/FocusTargetNode$FocusTargetElement", "LP0/a0;", "Lw0/u;", "<init>", "()V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class FocusTargetNode.FocusTargetElement extends a0 {
    public static final FocusTargetNode.FocusTargetElement a;

    static {
        FocusTargetNode.FocusTargetElement.a = new FocusTargetNode.FocusTargetElement();
    }

    @Override  // P0.a0
    public final p create() {
        return new u(0, 7, null);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return 0x67A7B089;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "focusTarget";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        u u0 = (u)p0;
    }
}

