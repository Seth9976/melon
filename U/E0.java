package U;

import A7.d;
import f1.i;
import f1.j;
import f1.k;
import f1.l;
import h1.b;
import kotlin.jvm.internal.q;

public final class e0 {
    public final int a;
    public final Boolean b;
    public final int c;
    public final int d;
    public static final e0 e;

    static {
        e0.e = new e0(0, 0x7F);
    }

    public e0(int v, int v1) {
        if((v1 & 8) != 0) {
            v = -1;
        }
        this(null, ((v1 & 4) == 0 ? 1 : 0), v);
    }

    public e0(Boolean boolean0, int v, int v1) {
        this.a = -1;
        this.b = boolean0;
        this.c = v;
        this.d = v1;
    }

    public final j a(boolean z) {
        k k0 = new k(this.a);
        i i0 = null;
        if(this.a == -1) {
            k0 = null;
        }
        int v = k0 == null ? 0 : k0.a;
        int v1 = 1;
        boolean z1 = this.b == null ? true : this.b.booleanValue();
        l l0 = new l(this.c);
        if(this.c == 0) {
            l0 = null;
        }
        int v2 = l0 == null ? 1 : l0.a;
        i i1 = new i(this.d);
        if(this.d != -1) {
            i0 = i1;
        }
        if(i0 != null) {
            v1 = i0.a;
        }
        return new j(z, v, z1, v2, v1, b.c);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof e0 && this.a == ((e0)object0).a && q.b(this.b, ((e0)object0).b) && this.c == ((e0)object0).c && this.d == ((e0)object0).d;
    }

    @Override
    public final int hashCode() {
        return this.b == null ? d.b(this.d, d.b(this.c, this.a * 961, 0x1F), 0x745F) : d.b(this.d, d.b(this.c, (this.a * 0x1F + this.b.hashCode()) * 0x1F, 0x1F), 0x745F);
    }

    @Override
    public final String toString() {
        return "KeyboardOptions(capitalization=" + k.a(this.a) + ", autoCorrectEnabled=" + this.b + ", keyboardType=" + l.a(this.c) + ", imeAction=" + i.a(this.d) + ", platformImeOptions=nullshowKeyboardOnFocus=null, hintLocales=null)";
    }
}

