package G;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.w;

public final class p implements b1 {
    public final y0 a;
    public final b0 b;
    public u c;
    public long d;
    public long e;
    public boolean f;

    public p(y0 y00, Object object0, u u0, int v) {
        if((v & 4) != 0) {
            u0 = null;
        }
        this(y00, object0, u0, 0x8000000000000000L, 0x8000000000000000L, false);
    }

    public p(y0 y00, Object object0, u u0, long v, long v1, boolean z) {
        u u1;
        this.a = y00;
        this.b = w.s(object0);
        if(u0 == null) {
            u1 = (u)y00.a.invoke(object0);
            u1.d();
        }
        else {
            u1 = f.j(u0);
        }
        this.c = u1;
        this.d = v;
        this.e = v1;
        this.f = z;
    }

    public final Object a() {
        return this.a.b.invoke(this.c);
    }

    @Override  // androidx.compose.runtime.b1
    public final Object getValue() {
        return ((O0)this.b).getValue();
    }

    @Override
    public final String toString() {
        return "AnimationState(value=" + ((O0)this.b).getValue() + ", velocity=" + this.a() + ", isRunning=" + this.f + ", lastFrameTimeNanos=" + this.d + ", finishedTimeNanos=" + this.e + ')';
    }
}

