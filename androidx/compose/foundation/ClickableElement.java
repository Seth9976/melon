package androidx.compose.foundation;

import A7.d;
import K.l;
import P0.a0;
import Q0.x0;
import X0.i;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.a;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/ClickableElement;", "LP0/a0;", "Landroidx/compose/foundation/C;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class ClickableElement extends a0 {
    public final l a;
    public final l0 b;
    public final boolean c;
    public final String d;
    public final i e;
    public final a f;

    public ClickableElement(l l0, l0 l00, boolean z, String s, i i0, a a0) {
        this.a = l0;
        this.b = l00;
        this.c = z;
        this.d = s;
        this.e = i0;
        this.f = a0;
    }

    @Override  // P0.a0
    public final p create() {
        return new C(this.a, this.b, this.c, this.d, this.e, this.f);  // 初始化器: Landroidx/compose/foundation/j;-><init>(LK/l;Landroidx/compose/foundation/l0;ZLjava/lang/String;LX0/i;Lwe/a;)V
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        Class class0 = object0.getClass();
        if(ClickableElement.class != class0) {
            return false;
        }
        if(!q.b(this.a, ((ClickableElement)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((ClickableElement)object0).b)) {
            return false;
        }
        if(this.c != ((ClickableElement)object0).c) {
            return false;
        }
        if(!q.b(this.d, ((ClickableElement)object0).d)) {
            return false;
        }
        return q.b(this.e, ((ClickableElement)object0).e) ? this.f == ((ClickableElement)object0).f : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(((this.a == null ? 0 : this.a.hashCode()) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F, 0x1F, this.c);
        int v2 = this.d == null ? 0 : this.d.hashCode();
        i i0 = this.e;
        if(i0 != null) {
            v = i0.a;
        }
        return this.f.hashCode() + ((v1 + v2) * 0x1F + v) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "clickable";
        x00.c.b(Boolean.valueOf(this.c), "enabled");
        x00.c.b(this.f, "onClick");
        x00.c.b(this.d, "onClickLabel");
        x00.c.b(this.e, "role");
        x00.c.b(this.a, "interactionSource");
        x00.c.b(this.b, "indicationNodeFactory");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((C)p0).w0(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}

