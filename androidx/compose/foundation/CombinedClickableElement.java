package androidx.compose.foundation;

import A7.d;
import J0.N;
import K.l;
import P0.a0;
import P0.f;
import Q0.x0;
import X0.i;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.a;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/CombinedClickableElement;", "LP0/a0;", "Landroidx/compose/foundation/I;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class CombinedClickableElement extends a0 {
    public final l a;
    public final String b;
    public final i c;
    public final a d;
    public final String e;
    public final a f;

    public CombinedClickableElement(l l0, i i0, String s, String s1, a a0, a a1) {
        this.a = l0;
        this.b = s;
        this.c = i0;
        this.d = a0;
        this.e = s1;
        this.f = a1;
    }

    @Override  // P0.a0
    public final p create() {
        return new I(this.a, this.c, this.e, this.b, this.d, this.f);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return CombinedClickableElement.class == class0 && q.b(this.a, ((CombinedClickableElement)object0).a) && q.b(this.b, ((CombinedClickableElement)object0).b) && q.b(this.c, ((CombinedClickableElement)object0).c) && this.d == ((CombinedClickableElement)object0).d && q.b(this.e, ((CombinedClickableElement)object0).e) && this.f == ((CombinedClickableElement)object0).f;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e((this.a == null ? 0 : this.a.hashCode()) * 961, 0x1F, true);
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.a;
        int v4 = this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        a a0 = this.f;
        if(a0 != null) {
            v = a0.hashCode();
        }
        return 0x4CF + (((v4 + ((v1 + v2) * 0x1F + v3) * 0x1F) * 0x1F + v5) * 0x1F + v) * 961;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "combinedClickable";
        x00.c.b(null, "indicationNodeFactory");
        x00.c.b(this.a, "interactionSource");
        x00.c.b(Boolean.TRUE, "enabled");
        x00.c.b(this.b, "onClickLabel");
        x00.c.b(this.c, "role");
        x00.c.b(this.d, "onClick");
        x00.c.b(null, "onDoubleClick");
        x00.c.b(this.f, "onLongClick");
        x00.c.b(this.e, "onLongClickLabel");
        x00.c.b(Boolean.TRUE, "hapticFeedbackEnabled");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        int v = 1;
        ((I)p0).I = true;
        String s = this.e;
        if(!q.b(((I)p0).E, s)) {
            ((I)p0).E = s;
            f.v(((I)p0)).E();
        }
        int v1 = 0;
        a a0 = this.f;
        if((((I)p0).G == null ? 1 : 0) != (a0 == null ? 1 : 0)) {
            ((I)p0).r0();
            f.v(((I)p0)).E();
            v1 = 1;
        }
        ((I)p0).G = a0;
        if(((I)p0).g) {
            v = v1;
        }
        ((I)p0).w0(this.a, null, true, this.b, this.c, this.d);
        if(v != 0) {
            N n0 = ((I)p0).j;
            if(n0 != null) {
                n0.o0();
            }
        }
    }
}

