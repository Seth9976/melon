package androidx.compose.foundation.layout;

import M.C;
import M.E;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/FillElement;", "LP0/a0;", "LM/E;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class FillElement extends a0 {
    public final C a;
    public final float b;
    public final String c;

    public FillElement(C c0, float f, String s) {
        this.a = c0;
        this.b = f;
        this.c = s;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new E();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof FillElement)) {
            return false;
        }
        return this.a == ((FillElement)object0).a ? this.b == ((FillElement)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = this.c;
        x00.c.b(this.b, "fraction");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((E)p0).a = this.a;
        ((E)p0).b = this.b;
    }
}

