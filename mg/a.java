package mg;

import kotlin.jvm.internal.q;

public final class a {
    public String a;
    public String b;

    public a(String s, String s1) {
        q.g(s, "_name");
        q.g(s1, "_value");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        return object0 instanceof a ? q.b(this.a, ((a)object0).a) && q.b(this.b, ((a)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a + ": " + this.b;
    }
}

