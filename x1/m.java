package x1;

import I.i;
import N0.L;
import android.os.Handler;
import androidx.compose.runtime.w0;
import ie.H;
import j3.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import p0.s;

public final class m implements w0, k {
    public final j a;
    public Handler b;
    public final s c;
    public boolean d;
    public final l e;
    public final ArrayList f;

    public m(j j0) {
        this.a = j0;
        this.c = new s(new l(this, 0));
        this.d = true;
        this.e = new l(this, 1);
        this.f = new ArrayList();
    }

    @Override  // x1.k
    public final void a(x1.s s0, List list0) {
        this.f.clear();
        i i0 = new i(list0, this, s0, 9);
        this.c.c(H.a, this.e, i0);
        this.d = false;
    }

    @Override  // x1.k
    public final boolean b(List list0) {
        if(!this.d) {
            ArrayList arrayList0 = this.f;
            if(list0.size() == arrayList0.size()) {
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    Object object0 = ((L)list0.get(v1)).q();
                    if(!q.b((object0 instanceof h ? ((h)object0) : null), arrayList0.get(v1))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override  // androidx.compose.runtime.w0
    public final void c() {
        this.c.d();
    }

    @Override  // androidx.compose.runtime.w0
    public final void d() {
    }

    @Override  // androidx.compose.runtime.w0
    public final void e() {
        s s0 = this.c;
        n n0 = s0.h;
        if(n0 != null) {
            n0.d();
        }
        s0.b();
    }
}

