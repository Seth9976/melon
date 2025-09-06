package f1;

import V3.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class a implements g {
    public final a1.g a;
    public final int b;

    public a(a1.g g0, int v) {
        this.a = g0;
        this.b = v;
    }

    public a(String s, int v) {
        this(new a1.g(s), v);
    }

    @Override  // f1.g
    public final void a(d d0) {
        int v = d0.d;
        a1.g g0 = this.a;
        int v1 = -1;
        if(v == -1) {
            d0.g(d0.b, d0.c, g0.b);
        }
        else {
            d0.g(v, d0.e, g0.b);
        }
        int v2 = d0.c;
        if(d0.b == v2) {
            v1 = v2;
        }
        int v3 = P4.a.j((this.b <= 0 ? v1 + this.b - g0.b.length() : v1 + this.b - 1), 0, ((A3.g)d0.f).l());
        d0.i(v3, v3);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        return q.b(this.a.b, ((a)object0).a.b) ? this.b == ((a)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a.b.hashCode() * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CommitTextCommand(text=\'");
        stringBuilder0.append(this.a.b);
        stringBuilder0.append("\', newCursorPosition=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

