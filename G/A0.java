package G;

import A0.c;
import A7.d;
import kotlin.jvm.internal.q;

public final class a0 implements D {
    public final float a;
    public final float b;
    public final Object c;

    public a0(float f, float f1, Object object0) {
        this.a = f;
        this.b = f1;
        this.c = object0;
    }

    public a0(Object object0, int v) {
        if((v & 4) != 0) {
            object0 = null;
        }
        this(1.0f, 1500.0f, object0);
    }

    @Override  // G.o
    public final A0 a(y0 y00) {
        Object object0 = this.c;
        if(object0 == null) {
            return new c(this.a, this.b, null);
        }
        u u0 = (u)y00.a.invoke(object0);
        return new c(this.a, this.b, u0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a0 && ((a0)object0).a == this.a && ((a0)object0).b == this.b && q.b(((a0)object0).c, this.c);
    }

    @Override
    public final int hashCode() {
        return this.c == null ? Float.hashCode(this.b) + d.a(this.a, 0, 0x1F) : Float.hashCode(this.b) + d.a(this.a, this.c.hashCode() * 0x1F, 0x1F);
    }
}

