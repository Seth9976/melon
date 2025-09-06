package androidx.compose.foundation;

import A7.d;
import P0.a0;
import Q0.l;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import y0.E;
import y0.Q;
import y0.o;
import y0.s;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/BackgroundElement;", "LP0/a0;", "Landroidx/compose/foundation/r;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BackgroundElement extends a0 {
    public final long a;
    public final o b;
    public final float c;
    public final Q d;
    public final l e;

    public BackgroundElement(long v, E e0, Q q0, int v1) {
        l l0 = l.k;
        if((v1 & 1) != 0) {
            v = s.g;
        }
        if((v1 & 2) != 0) {
            e0 = null;
        }
        super();
        this.a = v;
        this.b = e0;
        this.c = 1.0f;
        this.d = q0;
        this.e = l0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new r();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        p0.e = 0x7FC000007FC00000L;
        return p0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        BackgroundElement backgroundElement0 = object0 instanceof BackgroundElement ? ((BackgroundElement)object0) : null;
        return backgroundElement0 == null ? false : s.d(this.a, backgroundElement0.a) && q.b(this.b, backgroundElement0.b) && this.c == backgroundElement0.c && q.b(this.d, backgroundElement0.d);
    }

    @Override
    public final int hashCode() {
        int v = Long.hashCode(this.a);
        return this.b == null ? this.d.hashCode() + d.a(this.c, v * 961, 0x1F) : this.d.hashCode() + d.a(this.c, (v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        this.e.getClass();
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((r)p0).a = this.a;
        ((r)p0).b = this.b;
        ((r)p0).c = this.c;
        ((r)p0).d = this.d;
    }
}

