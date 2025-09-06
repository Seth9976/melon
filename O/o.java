package O;

import androidx.compose.foundation.lazy.layout.z;
import je.x;
import kotlin.jvm.internal.r;
import r1.b;
import we.k;

public final class o extends r implements we.o {
    public final int f;
    public final z g;
    public final long h;
    public final int i;
    public final int j;

    public o(z z0, long v, int v1, int v2, int v3) {
        this.f = v3;
        this.g = z0;
        this.h = v;
        this.i = v1;
        this.j = v2;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.f) {
            case 0: {
                return this.g.b.w(b.g(((Number)object0).intValue() + this.i, this.h), b.f(((Number)object1).intValue() + this.j, this.h), x.a, ((k)object2));
            }
            case 1: {
                return this.g.b.w(b.g(((Number)object0).intValue() + this.i, this.h), b.f(((Number)object1).intValue() + this.j, this.h), x.a, ((k)object2));
            }
            default: {
                return this.g.b.w(b.g(((Number)object0).intValue() + this.i, this.h), b.f(((Number)object1).intValue() + this.j, this.h), x.a, ((k)object2));
            }
        }
    }
}

