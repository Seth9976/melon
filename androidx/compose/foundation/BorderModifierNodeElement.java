package androidx.compose.foundation;

import P0.a0;
import Q0.W0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import r1.f;
import v0.c;
import y0.Q;
import y0.T;
import y0.o;
import y0.s;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/BorderModifierNodeElement;", "LP0/a0;", "Landroidx/compose/foundation/x;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class BorderModifierNodeElement extends a0 {
    public final float a;
    public final o b;
    public final Q c;

    public BorderModifierNodeElement(float f, o o0, Q q0) {
        this.a = f;
        this.b = o0;
        this.c = q0;
    }

    @Override  // P0.a0
    public final p create() {
        return new x(this.a, this.b, this.c);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof BorderModifierNodeElement && f.a(this.a, ((BorderModifierNodeElement)object0).a) && this.b.equals(((BorderModifierNodeElement)object0).b) && q.b(this.c, ((BorderModifierNodeElement)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + Float.hashCode(this.a) * 0x1F) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "border";
        W0 w00 = x00.c;
        w00.b(new f(this.a), "width");
        o o0 = this.b;
        if(o0 instanceof T) {
            w00.b(new s(((T)o0).a), "color");
            x00.b = new s(((T)o0).a);
        }
        else {
            w00.b(o0, "brush");
        }
        w00.b(this.c, "shape");
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BorderModifierNodeElement(width=");
        androidx.appcompat.app.o.v(this.a, stringBuilder0, ", brush=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", shape=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    @Override  // P0.a0
    public final void update(p p0) {
        float f = ((x)p0).d;
        c c0 = ((x)p0).g;
        float f1 = this.a;
        if(!f.a(f, f1)) {
            ((x)p0).d = f1;
            c0.m0();
        }
        o o0 = this.b;
        if(!q.b(((x)p0).e, o0)) {
            ((x)p0).e = o0;
            c0.m0();
        }
        Q q0 = this.c;
        if(!q.b(((x)p0).f, q0)) {
            ((x)p0).f = q0;
            c0.m0();
        }
    }
}

