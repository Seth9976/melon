package androidx.compose.ui.viewinterop;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import u1.m;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesElement;", "LP0/a0;", "Lu1/m;", "<init>", "()V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class FocusGroupPropertiesElement extends a0 {
    public static final FocusGroupPropertiesElement a;

    static {
        FocusGroupPropertiesElement.a = new FocusGroupPropertiesElement();
    }

    @Override  // P0.a0
    public final p create() {
        return new m();
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 == this;
    }

    @Override
    public final int hashCode() {
        return 0x8D00D93A;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "FocusGroupProperties";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        m m0 = (m)p0;
    }
}

