package androidx.compose.foundation.layout;

import A7.d;
import M.h0;
import N.a;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import r0.p;
import r1.f;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "LP0/a0;", "LM/h0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class PaddingElement extends a0 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final r e;

    public PaddingElement(float f, float f1, float f2, float f3, k k0) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = (r)k0;
        int v = 1;
        int v1 = Float.compare(f, 0.0f) >= 0 || Float.isNaN(f) ? 1 : 0;
        int v2 = f1 >= 0.0f || Float.isNaN(f1) ? 1 : 0;
        int v3 = f2 >= 0.0f || Float.isNaN(f2) ? 1 : 0;
        if(f3 < 0.0f && !Float.isNaN(f3)) {
            v = 0;
        }
        if((v1 & v2 & v3 & v) == 0) {
            a.a("Padding must be non-negative");
        }
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new h0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        p0.e = true;
        return p0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        PaddingElement paddingElement0 = object0 instanceof PaddingElement ? ((PaddingElement)object0) : null;
        return paddingElement0 != null && f.a(this.a, paddingElement0.a) && f.a(this.b, paddingElement0.b) && f.a(this.c, paddingElement0.c) && f.a(this.d, paddingElement0.d);
    }

    @Override
    public final int hashCode() {
        return d.a(this.d, d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F), 0x1F) + 0x4CF;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        ((k)this.e).invoke(x00);
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((h0)p0).a = this.a;
        ((h0)p0).b = this.b;
        ((h0)p0).c = this.c;
        ((h0)p0).d = this.d;
        ((h0)p0).e = true;
    }
}

