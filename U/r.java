package U;

import a1.Q;
import a1.g;
import androidx.compose.runtime.O0;
import kotlin.jvm.internal.q;
import we.a;

public final class r extends kotlin.jvm.internal.r implements a {
    public final int f;
    public final L0 g;

    public r(L0 l00, int v) {
        this.f = v;
        this.g = l00;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return this.g == null ? false : Boolean.valueOf(((Boolean)new r(this.g, 2).invoke()).booleanValue());
            }
            case 1: {
                return this.g == null ? false : Boolean.valueOf(((Boolean)new r(this.g, 2).invoke()).booleanValue());
            }
            default: {
                g g0 = this.g.b;
                Q q0 = (Q)((O0)this.g.a).getValue();
                if(q0 != null) {
                    return q0.a == null ? Boolean.valueOf(q.b(g0, null)) : Boolean.valueOf(q.b(g0, q0.a.a));
                }
                return Boolean.valueOf(q.b(g0, null));
            }
        }
    }
}

