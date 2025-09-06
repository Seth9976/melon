package a1;

import A7.d;
import androidx.appcompat.app.o;
import g1.a;
import kotlin.jvm.internal.q;

public final class e {
    public final Object a;
    public final int b;
    public final int c;
    public final String d;

    public e(Object object0, int v, int v1) {
        this("", v, v1, object0);
    }

    public e(String s, int v, int v1, Object object0) {
        this.a = object0;
        this.b = v;
        this.c = v1;
        this.d = s;
        if(v > v1) {
            a.a("Reversed range is not supported");
        }
    }

    public static e a(e e0, D d0, int v, int v1) {
        if((v1 & 1) != 0) {
            d0 = e0.a;
        }
        int v2 = e0.b;
        if((v1 & 4) != 0) {
            v = e0.c;
        }
        return new e(e0.d, v2, v, d0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        if(!q.b(this.a, ((e)object0).a)) {
            return false;
        }
        if(this.b != ((e)object0).b) {
            return false;
        }
        return this.c == ((e)object0).c ? q.b(this.d, ((e)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.d.hashCode() + d.b(this.c, d.b(this.b, 0, 0x1F), 0x1F) : this.d.hashCode() + d.b(this.c, d.b(this.b, this.a.hashCode() * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Range(item=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", start=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", end=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", tag=");
        return o.r(stringBuilder0, this.d, ')');
    }
}

