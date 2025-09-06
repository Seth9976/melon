package Yb;

import kotlin.jvm.internal.q;

public final class s extends v {
    public final String c;
    public final Throwable d;
    public final String e;

    public s(String s, Throwable throwable0) {
        super(s, throwable0);
        this.c = s;
        this.d = throwable0;
        this.e = "PlayerException.Default";
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
        if(!(object0 instanceof s)) {
            return false;
        }
        return q.b(this.c, ((s)object0).c) ? q.b(this.d, ((s)object0).d) : false;
    }

    @Override
    public final Throwable getCause() {
        return this.d;
    }

    @Override
    public final String getMessage() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        int v = this.c.hashCode();
        return this.d == null ? v * 0x1F : v * 0x1F + this.d.hashCode();
    }

    @Override
    public final String toString() {
        return "Default(message=" + this.c + ", cause=" + this.d + ")";
    }
}

