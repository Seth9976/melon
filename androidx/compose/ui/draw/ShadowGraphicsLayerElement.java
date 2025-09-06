package androidx.compose.ui.draw;

import A7.d;
import P0.a0;
import P0.j0;
import Q0.x0;
import androidx.appcompat.app.o;
import androidx.compose.foundation.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import r1.f;
import y0.Q;
import y0.m;
import y0.s;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "LP0/a0;", "Ly0/m;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ShadowGraphicsLayerElement extends a0 {
    public final float a;
    public final Q b;
    public final boolean c;
    public final long d;
    public final long e;

    public ShadowGraphicsLayerElement(float f, Q q0, boolean z, long v, long v1) {
        this.a = f;
        this.b = q0;
        this.c = z;
        this.d = v;
        this.e = v1;
    }

    @Override  // P0.a0
    public final p create() {
        return new m(new w(this, 24));
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof ShadowGraphicsLayerElement && f.a(this.a, ((ShadowGraphicsLayerElement)object0).a) && q.b(this.b, ((ShadowGraphicsLayerElement)object0).b) && this.c == ((ShadowGraphicsLayerElement)object0).c && s.d(this.d, ((ShadowGraphicsLayerElement)object0).d) && s.d(this.e, ((ShadowGraphicsLayerElement)object0).e);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.e) + d.c(d.e((this.b.hashCode() + Float.hashCode(this.a) * 0x1F) * 0x1F, 0x1F, this.c), 0x1F, this.d);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "shadow";
        f f0 = new f(this.a);
        x00.c.b(f0, "elevation");
        x00.c.b(this.b, "shape");
        x00.c.b(Boolean.valueOf(this.c), "clip");
        s s0 = new s(this.d);
        x00.c.b(s0, "ambientColor");
        s s1 = new s(this.e);
        x00.c.b(s1, "spotColor");
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ShadowGraphicsLayerElement(elevation=");
        o.v(this.a, stringBuilder0, ", shape=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", clip=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", ambientColor=");
        o.x(this.d, ", spotColor=", stringBuilder0);
        stringBuilder0.append(s.j(this.e));
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((m)p0).a = new w(this, 24);
        j0 j00 = P0.f.t(((m)p0), 2).m;
        if(j00 != null) {
            j00.n1(((m)p0).a, true);
        }
    }
}

