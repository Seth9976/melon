package Ve;

import java.util.ArrayList;

public final class v extends M {
    public final ArrayList a;

    public v(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof v && this.a.equals(((v)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ArrayValue(" + this.a + ')';
    }
}

