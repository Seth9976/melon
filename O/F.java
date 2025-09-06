package O;

import De.I;
import I.u0;
import androidx.compose.foundation.lazy.layout.n;
import java.util.Collection;
import java.util.List;
import je.p;

public final class f implements n {
    public final F a;

    public f(F f0) {
        this.a = f0;
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int a() {
        F f0 = this.a;
        if(((List)f0.h().k).isEmpty()) {
            return 0;
        }
        u u0 = f0.h();
        long v = u0.p == u0.a ? u0.e() & 0xFFFFFFFFL : u0.e() >> 0x20;
        int v1 = I.d0(f0.h());
        if(v1 != 0) {
            int v2 = ((int)v) / v1;
            return v2 >= 1 ? v2 : 1;
        }
        return 1;
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final boolean b() {
        return !((Collection)this.a.h().k).isEmpty();
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int c() {
        return Math.max(0, this.a.d.a());
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int d() {
        return Math.min(this.getItemCount() - 1, ((v)p.s0(((List)this.a.h().k))).a);
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int getItemCount() {
        return this.a.h().n;
    }
}

