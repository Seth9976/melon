package r7;

import java.util.Collections;
import java.util.Map;

public final class c {
    public final String a;
    public final Map b;

    public c(String s, Map map0) {
        this.a = s;
        this.b = map0;
    }

    public static c a(String s) {
        return new c(s, Collections.EMPTY_MAP);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? this.a.equals(((c)object0).a) && this.b.equals(((c)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "FieldDescriptor{name=" + this.a + ", properties=" + this.b.values() + "}";
    }
}

