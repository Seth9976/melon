package androidx.compose.foundation.layout;

import A7.d;
import M.C;
import M.D0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import r0.p;
import we.n;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement;", "LP0/a0;", "LM/D0;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class WrapContentElement extends a0 {
    public final C a;
    public final boolean b;
    public final r c;
    public final Object d;
    public final String e;

    public WrapContentElement(C c0, boolean z, n n0, Object object0, String s) {
        this.a = c0;
        this.b = z;
        this.c = (r)n0;
        this.d = object0;
        this.e = s;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new D0();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        return p0;
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
        if(WrapContentElement.class != class0) {
            return false;
        }
        if(this.a != ((WrapContentElement)object0).a) {
            return false;
        }
        return this.b == ((WrapContentElement)object0).b ? q.b(this.d, ((WrapContentElement)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + d.e(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = this.e;
        x00.c.b(this.d, "align");
        x00.c.b(Boolean.valueOf(this.b), "unbounded");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((D0)p0).a = this.a;
        ((D0)p0).b = this.b;
        ((D0)p0).c = this.c;
    }
}

