package androidx.compose.foundation;

import A7.d;
import P0.a0;
import Q0.x0;
import Y.V;
import Y.W;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import r1.c;
import r1.f;
import r1.h;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/MagnifierElement;", "LP0/a0;", "Landroidx/compose/foundation/o0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class MagnifierElement extends a0 {
    public final V a;
    public final W b;
    public final G0 c;

    public MagnifierElement(V v0, W w0, G0 g00) {
        this.a = v0;
        this.b = w0;
        this.c = g00;
    }

    @Override  // P0.a0
    public final p create() {
        return new o0(this.a, this.b, this.c);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof MagnifierElement) {
            MagnifierElement magnifierElement0 = (MagnifierElement)object0;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + d.e(d.a(NaNf, d.a(NaNf, d.c(d.e(d.a(NaNf, this.a.hashCode() * 961, 0x1F), 0x1F, true), 0x1F, 0x7FC000007FC00000L), 0x1F), 0x1F), 0x1F, true)) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "magnifier";
        x00.c.b(this.a, "sourceCenter");
        x00.c.b(null, "magnifierCenter");
        x00.c.b(NaNf, "zoom");
        h h0 = new h(0x7FC000007FC00000L);
        x00.c.b(h0, "size");
        f f0 = new f(NaNf);
        x00.c.b(f0, "cornerRadius");
        f f1 = new f(NaNf);
        x00.c.b(f1, "elevation");
        x00.c.b(Boolean.TRUE, "clippingEnabled");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((o0)p0).getClass();
        G0 g00 = ((o0)p0).c;
        View view0 = ((o0)p0).d;
        c c0 = ((o0)p0).e;
        ((o0)p0).a = this.a;
        ((o0)p0).b = this.b;
        ((o0)p0).c = this.c;
        View view1 = P0.f.x(((o0)p0));
        c c1 = P0.f.v(((o0)p0)).S;
        if(((o0)p0).f != null && (!this.c.equals(g00) || !view1.equals(view0) || !q.b(c1, c0))) {
            ((o0)p0).n0();
        }
        ((o0)p0).o0();
    }
}

