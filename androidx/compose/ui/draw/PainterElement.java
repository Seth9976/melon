package androidx.compose.ui.draw;

import A7.d;
import C0.c;
import N0.k;
import P0.a0;
import P0.f;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.e;
import r0.p;
import v0.h;
import y0.t;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/PainterElement;", "LP0/a0;", "Lv0/h;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class PainterElement extends a0 {
    public final c a;
    public final e b;
    public final k c;
    public final float d;
    public final t e;

    public PainterElement(c c0, e e0, k k0, float f, t t0) {
        this.a = c0;
        this.b = e0;
        this.c = k0;
        this.d = f;
        this.e = t0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new h();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = true;
        p0.c = this.b;
        p0.d = this.c;
        p0.e = this.d;
        p0.f = this.e;
        return p0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof PainterElement && q.b(this.a, ((PainterElement)object0).a) && q.b(this.b, ((PainterElement)object0).b) && q.b(this.c, ((PainterElement)object0).c) && Float.compare(this.d, ((PainterElement)object0).d) == 0 && q.b(this.e, ((PainterElement)object0).e);
    }

    @Override
    public final int hashCode() {
        int v = d.a(this.d, (this.c.hashCode() + (this.b.hashCode() + d.e(this.a.hashCode() * 0x1F, 0x1F, true)) * 0x1F) * 0x1F, 0x1F);
        return this.e == null ? v : v + this.e.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "paint";
        x00.c.b(this.a, "painter");
        x00.c.b(Boolean.TRUE, "sizeToIntrinsics");
        x00.c.b(this.b, "alignment");
        x00.c.b(this.c, "contentScale");
        x00.c.b(this.d, "alpha");
        x00.c.b(this.e, "colorFilter");
    }

    @Override
    public final String toString() {
        return "PainterElement(painter=" + this.a + ", sizeToIntrinsics=true, alignment=" + this.b + ", contentScale=" + this.c + ", alpha=" + this.d + ", colorFilter=" + this.e + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        boolean z = !((h)p0).b || !x0.e.a(((h)p0).a.getIntrinsicSize-NH-jbRc(), this.a.getIntrinsicSize-NH-jbRc());
        ((h)p0).a = this.a;
        ((h)p0).b = true;
        ((h)p0).c = this.b;
        ((h)p0).d = this.c;
        ((h)p0).e = this.d;
        ((h)p0).f = this.e;
        if(z) {
            f.v(((h)p0)).D();
        }
        f.m(((h)p0));
    }
}

