package G;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import kotlin.jvm.internal.r;
import we.k;

public final class l0 {
    public final y0 a;
    public final b0 b;
    public final t0 c;

    public l0(t0 t00, y0 y00, String s) {
        this.c = t00;
        this.a = y00;
        this.b = w.s(null);
    }

    public final k0 a(k k0, k k1) {
        b0 b00 = this.b;
        k0 k00 = (k0)((O0)b00).getValue();
        t0 t00 = this.c;
        if(k00 == null) {
            Object object0 = k1.invoke(t00.c());
            Object object1 = k1.invoke(t00.c());
            u u0 = (u)this.a.a.invoke(object1);
            u0.d();
            o0 o00 = new o0(t00, object0, u0, this.a);
            k00 = new k0(this, o00, k0, k1);
            ((O0)b00).setValue(k00);
            t00.i.add(o00);
        }
        k00.c = (r)k1;
        k00.b = k0;
        k00.a(t00.f());
        return k00;
    }
}

