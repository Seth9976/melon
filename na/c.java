package Na;

import kotlin.jvm.internal.q;

public final class c extends Exception {
    public final String a;

    public c(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? q.b(this.a, ((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "DescriptionError(description=" + this.a + ")";
    }
}

