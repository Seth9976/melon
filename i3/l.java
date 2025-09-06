package i3;

import android.media.metrics.LogSessionId;
import e3.b;
import java.util.Objects;

public final class l {
    public final String a;
    public final k b;
    public final Object c;

    static {
        new l(k.b, "");
    }

    public l(LogSessionId logSessionId0, String s) {
        this(new k(logSessionId0), s);
    }

    public l(k k0, String s) {
        this.b = k0;
        this.a = s;
        this.c = new Object();
    }

    public l(String s) {
        b.j(false);
        this.a = s;
        this.b = null;
        this.c = new Object();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l ? Objects.equals(this.a, ((l)object0).a) && Objects.equals(this.b, ((l)object0).b) && Objects.equals(this.c, ((l)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, this.c});
    }
}

