package androidx.compose.ui.draganddrop;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import u0.a;
import u0.e;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/compose/ui/draganddrop/AndroidDragAndDropManager$modifier$1", "LP0/a0;", "Lu0/e;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidDragAndDropManager.modifier.1 extends a0 {
    public final a a;

    public AndroidDragAndDropManager.modifier.1(a a0) {
        this.a = a0;
    }

    @Override  // P0.a0
    public final p create() {
        return this.a.a;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return this.a.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "RootDragAndDropNode";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        e e0 = (e)p0;
    }
}

