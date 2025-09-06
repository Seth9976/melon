package Q;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import d5.l;
import d5.t;
import we.a;

public final class e extends K {
    public final b0 J;
    public static final l K;

    static {
        e.K = t.l(b.f, d.g);
    }

    public e(int v, float f, a a0) {
        super(v, f);
        this.J = w.s(a0);
    }

    @Override  // Q.K
    public final int l() {
        return ((Number)((a)((O0)this.J).getValue()).invoke()).intValue();
    }
}

