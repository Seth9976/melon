package androidx.compose.ui.platform;

import P0.a0;
import Q0.d0;
import Q0.u;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$bringIntoViewNode$1", "LP0/a0;", "LQ0/d0;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidComposeView.bringIntoViewNode.1 extends a0 {
    public final u a;

    public AndroidComposeView.bringIntoViewNode.1(u u0) {
        this.a = u0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new d0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "BringIntoViewOnScreen";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((d0)p0).a = this.a;
    }
}

