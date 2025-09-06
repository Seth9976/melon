package androidx.compose.ui.input.key;

import H0.g;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputElement;", "LP0/a0;", "LH0/g;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class KeyInputElement extends a0 {
    public final k a;
    public final k b;

    public KeyInputElement(k k0, k k1) {
        this.a = k0;
        this.b = k1;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new g();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof KeyInputElement)) {
            return false;
        }
        return this.a == ((KeyInputElement)object0).a ? this.b == ((KeyInputElement)object0).b : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        k k0 = this.b;
        if(k0 != null) {
            v = k0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        k k0 = this.a;
        if(k0 != null) {
            x00.a = "onKeyEvent";
            x00.c.b(k0, "onKeyEvent");
        }
        k k1 = this.b;
        if(k1 != null) {
            x00.a = "onPreviewKeyEvent";
            x00.c.b(k1, "onPreviewKeyEvent");
        }
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((g)p0).a = this.a;
        ((g)p0).b = this.b;
    }
}

