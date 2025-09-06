package ed;

import kotlin.jvm.internal.q;

public final class a {
    public final we.a a;

    public a(we.a a0) {
        this.a = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof a ? q.b(this.a, ((a)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ArchiveAllShowData(clickAction=" + this.a + ")";
    }
}

