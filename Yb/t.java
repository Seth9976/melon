package Yb;

import b3.K;
import kotlin.jvm.internal.q;

public final class t extends v {
    public final String c;
    public final K d;
    public final String e;
    public final String f;

    public t(String s, K k0) {
        q.g(k0, "exception");
        super(s, k0);
        this.c = s;
        this.d = k0;
        this.e = "PlayerException.Music";
        String s1 = k0.b();
        this.f = this.b + " [" + s1 + "]";
    }

    @Override  // Sb.a
    public final String a() {
        return this.f;
    }

    @Override  // Sb.a
    public final String b() {
        return this.e;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t)) {
            return false;
        }
        return q.b(this.c, ((t)object0).c) ? q.b(this.d, ((t)object0).d) : false;
    }

    @Override
    public final String getMessage() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + this.c.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Music(message=" + this.c + ", exception=" + this.d + ")";
    }
}

