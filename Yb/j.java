package Yb;

import kotlin.jvm.internal.q;

public final class j extends m {
    public final String c;
    public final String d;

    public j(String s) {
        super(s, null);
        this.c = s;
        this.d = "DrmException.ExtendFailed";
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
        return object0 instanceof j ? q.b(this.c, ((j)object0).c) : false;
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
        return "ExtendFailed(message=" + this.c + ")";
    }
}

