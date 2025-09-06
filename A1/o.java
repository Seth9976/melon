package a1;

import A7.d;
import kotlin.jvm.internal.q;

public final class o {
    public final m a;
    public final int b;
    public final int c;

    public o(m m0, int v, int v1) {
        this.a = m0;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o)) {
            return false;
        }
        if(!q.b(this.a, ((o)object0).a)) {
            return false;
        }
        return this.b == ((o)object0).b ? this.c == ((o)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BulletSpanWithLevel(bullet=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", indentationLevel=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", start=");
        return androidx.appcompat.app.o.q(stringBuilder0, this.c, ')');
    }
}

