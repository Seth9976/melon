package ef;

import Hf.B;
import Hf.W;
import java.util.Set;
import kotlin.jvm.internal.q;

public final class a {
    public final Set a;
    public final W b;
    public final b c;
    public final boolean d;
    public final boolean e;
    public final Set f;
    public final B g;

    public a(W w0, b b0, boolean z, boolean z1, Set set0, B b1) {
        this.a = set0;
        this.b = w0;
        this.c = b0;
        this.d = z;
        this.e = z1;
        this.f = set0;
        this.g = b1;
    }

    public a(W w0, boolean z, boolean z1, Set set0, int v) {
        b b0 = b.a;
        if((v & 16) != 0) {
            set0 = null;
        }
        this(w0, b0, ((v & 4) == 0 ? z : false), ((v & 8) == 0 ? z1 : false), set0, null);
    }

    public static a a(a a0, b b0, boolean z, Set set0, B b1, int v) {
        W w0 = a0.b;
        if((v & 2) != 0) {
            b0 = a0.c;
        }
        if((v & 4) != 0) {
            z = a0.d;
        }
        boolean z1 = a0.e;
        if((v & 16) != 0) {
            set0 = a0.f;
        }
        if((v & 0x20) != 0) {
            b1 = a0.g;
        }
        a0.getClass();
        q.g(w0, "howThisTypeIsUsed");
        q.g(b0, "flexibility");
        return new a(w0, b0, z, z1, set0, b1);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a ? q.b(((a)object0).g, this.g) && ((a)object0).b == this.b && ((a)object0).c == this.c && ((a)object0).d == this.d && ((a)object0).e == this.e : false;
    }

    @Override
    public final int hashCode() {
        int v = this.g == null ? 0 : this.g.hashCode();
        int v1 = this.b.hashCode() + v * 0x1F + v;
        int v2 = 0x400 * v + this.c.hashCode() + 0x20 * this.b.hashCode();
        int v3 = v2 * 0x1F + this.d + v2;
        return v3 * 0x1F + this.e + v3;
    }

    @Override
    public final String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.b + ", flexibility=" + this.c + ", isRaw=" + this.d + ", isForAnnotationParameter=" + this.e + ", visitedTypeParameters=" + this.f + ", defaultType=" + this.g + ')';
    }
}

