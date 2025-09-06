package f1;

import P4.a;
import V3.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class u implements g {
    public final a1.g a;
    public final int b;

    public u(String s, int v) {
        a1.g g0 = new a1.g(s);
        super();
        this.a = g0;
        this.b = v;
    }

    @Override  // f1.g
    public final void a(d d0) {
        int v = d0.d;
        a1.g g0 = this.a;
        int v1 = -1;
        if(v == -1) {
            int v2 = d0.b;
            String s1 = g0.b;
            d0.g(v2, d0.c, g0.b);
            if(s1.length() > 0) {
                d0.h(v2, s1.length() + v2);
            }
        }
        else {
            String s = g0.b;
            d0.g(v, d0.e, g0.b);
            if(s.length() > 0) {
                d0.h(v, s.length() + v);
            }
        }
        int v3 = d0.c;
        if(d0.b == v3) {
            v1 = v3;
        }
        int v4 = a.j((this.b <= 0 ? v1 + this.b - g0.b.length() : v1 + this.b - 1), 0, ((A3.g)d0.f).l());
        d0.i(v4, v4);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u)) {
            return false;
        }
        return q.b(this.a.b, ((u)object0).a.b) ? this.b == ((u)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a.b.hashCode() * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SetComposingTextCommand(text=\'");
        stringBuilder0.append(this.a.b);
        stringBuilder0.append("\', newCursorPosition=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

