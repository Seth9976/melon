package U;

import Mc.H;
import Y.Q;
import Y.X;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.ui.input.key.a;
import f1.p;
import f1.x;
import kotlin.jvm.internal.r;
import r0.q;
import we.k;
import we.o;

public final class z0 extends r implements o {
    public final f0 f;
    public final Q g;
    public final x h;
    public final boolean i;
    public final boolean j;
    public final p k;
    public final O0 l;
    public final k m;
    public final int n;

    public z0(f0 f00, Q q0, x x0, boolean z, boolean z1, p p0, O0 o00, k k0, int v) {
        this.f = f00;
        this.g = q0;
        this.h = x0;
        this.i = z;
        this.j = z1;
        this.k = p0;
        this.l = o00;
        this.m = k0;
        this.n = v;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        q q0 = (q)object0;
        ((Number)object2).intValue();
        ((androidx.compose.runtime.p)(((l)object1))).a0(851809892);
        X x0 = ((androidx.compose.runtime.p)(((l)object1))).N();
        V v0 = androidx.compose.runtime.k.a;
        if(x0 == v0) {
            x0 = new X();  // 初始化器: Ljava/lang/Object;-><init>()V
            ((androidx.compose.runtime.p)(((l)object1))).l0(x0);
        }
        U.Q q1 = ((androidx.compose.runtime.p)(((l)object1))).N();
        if(q1 == v0) {
            q1 = new U.Q();  // 初始化器: Ljava/lang/Object;-><init>()V
            ((androidx.compose.runtime.p)(((l)object1))).l0(q1);
        }
        y0 y00 = new y0(this.f, this.g, this.h, this.i, this.j, x0, this.k, this.l, q1, this.m, this.n);
        boolean z = ((androidx.compose.runtime.p)(((l)object1))).i(y00);
        H h0 = ((androidx.compose.runtime.p)(((l)object1))).N();
        if(z || h0 == v0) {
            H h1 = new H(1, y00, y0.class, "process", "process-ZmokQxo(Landroid/view/KeyEvent;)Z", 0, 22);
            ((androidx.compose.runtime.p)(((l)object1))).l0(h1);
            h0 = h1;
        }
        q q2 = a.b(h0);
        ((androidx.compose.runtime.p)(((l)object1))).p(false);
        return q2;
    }
}

