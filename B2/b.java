package b2;

import java.util.Objects;
import va.e;

public final class b {
    public final Object a;
    public final Object b;

    public b(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b ? Objects.equals(((b)object0).a, this.a) && Objects.equals(((b)object0).b, this.b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Object object0 = this.b;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v ^ v1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Pair{");
        stringBuilder0.append(this.a);
        stringBuilder0.append(" ");
        return e.d(stringBuilder0, this.b, "}");
    }
}

