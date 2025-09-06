package androidx.compose.foundation.layout;

import A7.d;
import M.s0;
import P0.a0;
import Q0.l;
import Q0.x0;
import kotlin.Metadata;
import r0.p;
import r1.f;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "LP0/a0;", "LM/s0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class SizeElement extends a0 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final boolean e;
    public final l f;

    public SizeElement(float f, float f1, float f2, float f3, boolean z) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = z;
        this.f = l.k;
    }

    public SizeElement(float f, float f1, float f2, float f3, boolean z, int v) {
        if((v & 1) != 0) {
            f = NaNf;
        }
        if((v & 2) != 0) {
            f1 = NaNf;
        }
        if((v & 4) != 0) {
            f2 = NaNf;
        }
        this(f, f1, f2, ((v & 8) == 0 ? f3 : NaNf), z);
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new s0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        p0.e = this.e;
        return p0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof SizeElement && f.a(this.a, ((SizeElement)object0).a) && f.a(this.b, ((SizeElement)object0).b) && f.a(this.c, ((SizeElement)object0).c) && f.a(this.d, ((SizeElement)object0).d) && this.e == ((SizeElement)object0).e;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.e) + d.a(this.d, d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F), 0x1F);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        this.f.getClass();
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((s0)p0).a = this.a;
        ((s0)p0).b = this.b;
        ((s0)p0).c = this.c;
        ((s0)p0).d = this.d;
        ((s0)p0).e = this.e;
    }
}

