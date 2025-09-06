package coil.compose;

import A7.d;
import C0.c;
import N0.k;
import P0.a0;
import P0.f;
import Q0.x0;
import j5.s;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.e;
import r0.p;
import y0.t;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil/compose/ContentPainterElement;", "LP0/a0;", "Lj5/s;", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ContentPainterElement extends a0 {
    public final c a;
    public final e b;
    public final k c;
    public final float d;
    public final t e;

    public ContentPainterElement(c c0, e e0, k k0, float f, t t0) {
        this.a = c0;
        this.b = e0;
        this.c = k0;
        this.d = f;
        this.e = t0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new s();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        p0.e = this.e;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ContentPainterElement)) {
            return false;
        }
        if(!q.b(this.a, ((ContentPainterElement)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((ContentPainterElement)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((ContentPainterElement)object0).c)) {
            return false;
        }
        return Float.compare(this.d, ((ContentPainterElement)object0).d) == 0 ? q.b(this.e, ((ContentPainterElement)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.a(this.d, (this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F, 0x1F);
        return this.e == null ? v : v + this.e.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "content";
        x00.c.b(this.a, "painter");
        x00.c.b(this.b, "alignment");
        x00.c.b(this.c, "contentScale");
        x00.c.b(this.d, "alpha");
        x00.c.b(this.e, "colorFilter");
    }

    @Override
    public final String toString() {
        return "ContentPainterElement(painter=" + this.a + ", alignment=" + this.b + ", contentScale=" + this.c + ", alpha=" + this.d + ", colorFilter=" + this.e + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        boolean z = x0.e.a(((s)p0).a.getIntrinsicSize-NH-jbRc(), this.a.getIntrinsicSize-NH-jbRc());
        ((s)p0).a = this.a;
        ((s)p0).b = this.b;
        ((s)p0).c = this.c;
        ((s)p0).d = this.d;
        ((s)p0).e = this.e;
        if(!z) {
            f.v(((s)p0)).D();
        }
        f.m(((s)p0));
    }
}

