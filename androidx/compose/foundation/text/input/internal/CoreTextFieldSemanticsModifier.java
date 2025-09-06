package androidx.compose.foundation.text.input.internal;

import A7.d;
import P0.a0;
import P0.f;
import Q0.x0;
import U.f0;
import W.g;
import W.i;
import Y.Q;
import a1.T;
import f1.D;
import f1.j;
import f1.p;
import f1.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifier;", "LP0/a0;", "LW/i;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CoreTextFieldSemanticsModifier extends a0 {
    public final D a;
    public final x b;
    public final f0 c;
    public final boolean d;
    public final boolean e;
    public final p f;
    public final Q g;
    public final j h;
    public final w0.p i;

    public CoreTextFieldSemanticsModifier(D d0, x x0, f0 f00, boolean z, boolean z1, p p0, Q q0, j j0, w0.p p1) {
        this.a = d0;
        this.b = x0;
        this.c = f00;
        this.d = z;
        this.e = z1;
        this.f = p0;
        this.g = q0;
        this.h = j0;
        this.i = p1;
    }

    @Override  // P0.a0
    public final r0.p create() {
        r0.p p0 = new i();  // 初始化器: LP0/n;-><init>()V
        p0.c = this.a;
        p0.d = this.b;
        p0.e = this.c;
        p0.f = this.d;
        p0.g = this.e;
        p0.h = this.f;
        p0.i = this.g;
        p0.j = this.h;
        p0.k = this.i;
        this.g.g = new g(((i)p0), 0);
        return p0;
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof CoreTextFieldSemanticsModifier && this.a.equals(((CoreTextFieldSemanticsModifier)object0).a) && q.b(this.b, ((CoreTextFieldSemanticsModifier)object0).b) && this.c.equals(((CoreTextFieldSemanticsModifier)object0).c) && this.d == ((CoreTextFieldSemanticsModifier)object0).d && this.e == ((CoreTextFieldSemanticsModifier)object0).e && q.b(this.f, ((CoreTextFieldSemanticsModifier)object0).f) && this.g.equals(((CoreTextFieldSemanticsModifier)object0).g) && q.b(this.h, ((CoreTextFieldSemanticsModifier)object0).h) && q.b(this.i, ((CoreTextFieldSemanticsModifier)object0).i);
    }

    @Override
    public final int hashCode() {
        return this.i.hashCode() + (this.h.hashCode() + (this.g.hashCode() + (this.f.hashCode() + d.e(d.e(d.e((this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F, 0x1F, false), 0x1F, this.d), 0x1F, this.e)) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override
    public final String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.a + ", value=" + this.b + ", state=" + this.c + ", readOnly=false, enabled=" + this.d + ", isPassword=" + this.e + ", offsetMapping=" + this.f + ", manager=" + this.g + ", imeOptions=" + this.h + ", focusRequester=" + this.i + ')';
    }

    @Override  // P0.a0
    public final void update(r0.p p0) {
        boolean z = ((i)p0).f;
        boolean z1 = ((i)p0).g;
        j j0 = ((i)p0).j;
        Q q0 = ((i)p0).i;
        ((i)p0).c = this.a;
        ((i)p0).d = this.b;
        ((i)p0).e = this.c;
        ((i)p0).f = this.d;
        ((i)p0).h = this.f;
        Q q1 = this.g;
        ((i)p0).i = q1;
        ((i)p0).j = this.h;
        ((i)p0).k = this.i;
        if(this.d != z || !q.b(this.h, j0) || this.e != z1 || !T.b(this.b.b)) {
            f.v(((i)p0)).E();
        }
        if(!q1.equals(q0)) {
            q1.g = new g(((i)p0), 7);
        }
    }
}

