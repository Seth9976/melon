package G;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b1;
import kotlin.jvm.internal.r;
import we.k;

public final class k0 implements b1 {
    public final o0 a;
    public k b;
    public r c;
    public final l0 d;

    public k0(l0 l00, o0 o00, k k0, k k1) {
        this.d = l00;
        this.a = o00;
        this.b = k0;
        this.c = (r)k1;
    }

    public final void a(m0 m00) {
        Object object0 = ((k)this.c).invoke(m00.b());
        boolean z = this.d.c.g();
        o0 o00 = this.a;
        if(z) {
            o00.g(((k)this.c).invoke(m00.c()), object0, ((D)this.b.invoke(m00)));
            return;
        }
        o00.i(object0, ((D)this.b.invoke(m00)));
    }

    @Override  // androidx.compose.runtime.b1
    public final Object getValue() {
        this.a(this.d.c.f());
        return ((O0)this.a.h).getValue();
    }
}

