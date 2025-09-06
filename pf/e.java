package pf;

import de.c;
import kotlin.jvm.internal.q;

public final class e extends c {
    public final String k;
    public final String l;

    public e(String s, String s1) {
        q.g(s, "name");
        q.g(s1, "desc");
        super();
        this.k = s;
        this.l = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        return q.b(this.k, ((e)object0).k) ? q.b(this.l, ((e)object0).l) : false;
    }

    @Override
    public final int hashCode() {
        return this.l.hashCode() + this.k.hashCode() * 0x1F;
    }

    @Override  // de.c
    public final String m() {
        return this.k + this.l;
    }
}

