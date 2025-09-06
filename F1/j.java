package f1;

import A7.d;
import h1.b;
import kotlin.jvm.internal.q;

public final class j {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;
    public final b f;
    public static final j g;

    static {
        j.g = new j(false, 0, true, 1, 1, b.c);
    }

    public j(boolean z, int v, boolean z1, int v1, int v2, b b0) {
        this.a = z;
        this.b = v;
        this.c = z1;
        this.d = v1;
        this.e = v2;
        this.f = b0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j && this.a == ((j)object0).a && this.b == ((j)object0).b && this.c == ((j)object0).c && this.d == ((j)object0).d && this.e == ((j)object0).e && q.b(this.f, ((j)object0).f);
    }

    @Override
    public final int hashCode() {
        return this.f.a.hashCode() + d.b(this.e, d.b(this.d, d.e(d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F), 0x1F, this.c), 0x1F), 961);
    }

    @Override
    public final String toString() {
        return "ImeOptions(singleLine=" + this.a + ", capitalization=" + k.a(this.b) + ", autoCorrect=" + this.c + ", keyboardType=" + l.a(this.d) + ", imeAction=" + i.a(this.e) + ", platformImeOptions=null, hintLocales=" + this.f + ')';
    }
}

