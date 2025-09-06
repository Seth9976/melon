package androidx.compose.material3.pulltorefresh;

import A7.d;
import P0.a0;
import Q0.x0;
import d0.o;
import d0.q;
import d0.s;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import r0.p;
import r1.f;
import we.a;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshElement;", "LP0/a0;", "Ld0/p;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PullToRefreshElement extends a0 {
    public final boolean a;
    public final a b;
    public final boolean c;
    public final q d;
    public final float e;

    public PullToRefreshElement(boolean z, a a0, boolean z1, s s0, float f) {
        this.a = z;
        this.b = a0;
        this.c = z1;
        this.d = s0;
        this.e = f;
    }

    @Override  // P0.a0
    public final p create() {
        return new d0.p(this.a, this.b, this.c, this.d, this.e);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof PullToRefreshElement && this.a == ((PullToRefreshElement)object0).a && kotlin.jvm.internal.q.b(this.b, ((PullToRefreshElement)object0).b) && this.c == ((PullToRefreshElement)object0).c && kotlin.jvm.internal.q.b(this.d, ((PullToRefreshElement)object0).d) && f.a(this.e, ((PullToRefreshElement)object0).e);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.e) + (this.d.hashCode() + d.e((this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F) * 0x1F, 0x1F, this.c)) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "PullToRefreshModifierNode";
        x00.c.b(Boolean.valueOf(this.a), "isRefreshing");
        x00.c.b(this.b, "onRefresh");
        x00.c.b(Boolean.valueOf(this.c), "enabled");
        x00.c.b(this.d, "state");
        f f0 = new f(this.e);
        x00.c.b(f0, "threshold");
    }

    @Override
    public final String toString() {
        return "PullToRefreshElement(isRefreshing=" + this.a + ", onRefresh=" + this.b + ", enabled=" + this.c + ", state=" + this.d + ", threshold=" + f.b(this.e) + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((d0.p)p0).d = this.b;
        ((d0.p)p0).e = this.c;
        ((d0.p)p0).f = this.d;
        ((d0.p)p0).g = this.e;
        boolean z = this.a;
        if(((d0.p)p0).c != z) {
            ((d0.p)p0).c = z;
            BuildersKt__Builders_commonKt.launch$default(((d0.p)p0).getCoroutineScope(), null, null, new o(((d0.p)p0), null), 3, null);
        }
    }
}

