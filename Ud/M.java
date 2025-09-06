package ud;

import androidx.compose.runtime.I0;
import androidx.compose.runtime.Z;
import ie.H;
import we.a;
import we.k;

public final class m implements a {
    public final long a;
    public final k b;
    public final Z c;

    public m(long v, k k0, Z z0) {
        this.a = v;
        this.b = k0;
        this.c = z0;
    }

    @Override  // we.a
    public final Object invoke() {
        Long long0 = (long)(((I0)this.c).m() * ((float)this.a));
        this.b.invoke(long0);
        return H.a;
    }
}

