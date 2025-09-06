package androidx.compose.foundation.selection;

import A7.d;
import K.l;
import P0.a0;
import P0.f;
import Q0.x0;
import S.b;
import androidx.compose.foundation.l0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.a;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/selection/SelectableElement;", "LP0/a0;", "LS/b;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class SelectableElement extends a0 {
    public final boolean a;
    public final l b;
    public final l0 c;
    public final a d;

    public SelectableElement(boolean z, l l0, l0 l00, a a0) {
        this.a = z;
        this.b = l0;
        this.c = l00;
        this.d = a0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new b(this.b, this.c, true, null, null, this.d);  // 初始化器: Landroidx/compose/foundation/j;-><init>(LK/l;Landroidx/compose/foundation/l0;ZLjava/lang/String;LX0/i;Lwe/a;)V
        p0.E = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return SelectableElement.class == class0 && this.a == ((SelectableElement)object0).a && q.b(this.b, ((SelectableElement)object0).b) && q.b(this.c, ((SelectableElement)object0).c) && this.d == ((SelectableElement)object0).d;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = Boolean.hashCode(this.a);
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        l0 l00 = this.c;
        if(l00 != null) {
            v1 = l00.hashCode();
        }
        return this.d.hashCode() + d.e(((v * 0x1F + v2) * 0x1F + v1) * 0x1F, 961, true);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "selectable";
        x00.c.b(Boolean.valueOf(this.a), "selected");
        x00.c.b(this.b, "interactionSource");
        x00.c.b(this.c, "indicationNodeFactory");
        x00.c.b(Boolean.TRUE, "enabled");
        x00.c.b(null, "role");
        x00.c.b(this.d, "onClick");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        boolean z = this.a;
        if(((b)p0).E != z) {
            ((b)p0).E = z;
            f.v(((b)p0)).E();
        }
        ((b)p0).w0(this.b, this.c, true, null, null, this.d);
    }
}

