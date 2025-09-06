package androidx.compose.foundation.layout;

import A7.d;
import M.c0;
import M.d0;
import P0.a0;
import Q0.x0;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import r0.p;
import r1.f;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/OffsetElement;", "LP0/a0;", "LM/d0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class OffsetElement extends a0 {
    public final float a;
    public final float b;
    public final c0 c;

    public OffsetElement(float f, float f1, c0 c00) {
        this.a = f;
        this.b = f1;
        this.c = c00;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new d0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = true;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        OffsetElement offsetElement0 = object0 instanceof OffsetElement ? ((OffsetElement)object0) : null;
        return offsetElement0 != null && f.a(this.a, offsetElement0.a) && f.a(this.b, offsetElement0.b);
    }

    @Override
    public final int hashCode() {
        return d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F) + 0x4CF;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        this.c.invoke(x00);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("OffsetModifierElement(x=");
        o.v(this.a, stringBuilder0, ", y=");
        stringBuilder0.append(f.b(this.b));
        stringBuilder0.append(", rtlAware=true)");
        return stringBuilder0.toString();
    }

    @Override  // P0.a0
    public final void update(p p0) {
        float f = this.a;
        float f1 = this.b;
        if(!f.a(((d0)p0).a, f) || !f.a(((d0)p0).b, f1) || !((d0)p0).c) {
            P0.f.v(((d0)p0)).V(false);
        }
        ((d0)p0).a = f;
        ((d0)p0).b = f1;
        ((d0)p0).c = true;
    }
}

