package Yb;

public final class q extends r {
    public final String c;
    public final String d;

    public q() {
        super("Check System Settings: Auto Time is not checked", null);
        this.c = "Check System Settings: Auto Time is not checked";
        this.d = "OfflineModeException.NotAllowedTimeSet";
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
        return object0 instanceof q ? kotlin.jvm.internal.q.b(this.c, ((q)object0).c) : false;
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
        return "NotAllowedTimeSet(message=" + this.c + ")";
    }
}

