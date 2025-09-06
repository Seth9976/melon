package Yb;

import kotlin.jvm.internal.q;

public final class p extends r {
    public final String c;
    public final String d;

    public p(String s) {
        q.g(s, "message");
        super(s, null);
        this.c = s;
        this.d = "OfflineModeException.InvalidProductState";
    }

    @Override  // Sb.a
    public final String b() {
        return this.d;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p ? q.b(this.c, ((p)object0).c) : false;
    }

    @Override
    public final String getMessage() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "InvalidProductState(message=" + this.c + ")";
    }
}

