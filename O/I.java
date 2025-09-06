package O;

import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.jvm.internal.r;
import m0.b;
import we.o;

public final class i extends r implements o {
    public final b f;
    public final int g;

    public i(b b0, int v) {
        this.f = b0;
        this.g = v;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = ((Number)object2).intValue();
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((a)object0)) ? 4 : 2);
        }
        if(((p)(((l)object1))).Q(v & 1, (v & 19) != 18)) {
            this.f.invoke(((a)object0), this.g, ((p)(((l)object1))), ((int)(v & 14)));
            return H.a;
        }
        ((p)(((l)object1))).T();
        return H.a;
    }
}

