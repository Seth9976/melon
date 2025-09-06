package androidx.compose.ui.input.key;

import H0.a;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/key/SoftKeyboardInterceptionElement;", "LP0/a0;", "LH0/a;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class SoftKeyboardInterceptionElement extends a0 {
    public final k a;

    public SoftKeyboardInterceptionElement(k k0) {
        this.a = k0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new a();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        return p0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof SoftKeyboardInterceptionElement && q.b(this.a, ((SoftKeyboardInterceptionElement)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode() * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        k k0 = this.a;
        if(k0 != null) {
            x00.a = "onKeyToSoftKeyboardInterceptedEvent";
            x00.c.b(k0, "onKeyToSoftKeyboardInterceptedEvent");
        }
    }

    @Override
    public final String toString() {
        return "SoftKeyboardInterceptionElement(onKeyEvent=" + this.a + ", onPreKeyEvent=null)";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((a)p0).a = this.a;
    }
}

